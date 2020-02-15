package br.com.volans.realsafe.service.impl;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.volans.realsafe.dao.CashCollectionDAO;
import br.com.volans.realsafe.dao.CashCollectionDetailDAO;
import br.com.volans.realsafe.dao.TerminalStatusDAO;
import br.com.volans.realsafe.dao.TransactionLogDAO;
import br.com.volans.realsafe.dto.DepositDetailDTO;
import br.com.volans.realsafe.dto.EventLogDTO;
import br.com.volans.realsafe.dto.NSUTerminalDTO;
import br.com.volans.realsafe.dto.TerminalStatusDTO;
import br.com.volans.realsafe.dto.TransactionLogDTO;
import br.com.volans.realsafe.dto.payload.CollectCashRequest;
import br.com.volans.realsafe.dto.payload.CollectCashResponse;
import br.com.volans.realsafe.dto.payload.ListCashCollectionDetailsRequest;
import br.com.volans.realsafe.dto.payload.ListCashCollectionRequest;
import br.com.volans.realsafe.dto.payload.PrintCollectCashReceiptRequest;
import br.com.volans.realsafe.enums.EventLogs;
import br.com.volans.realsafe.enums.MessageKeys;
import br.com.volans.realsafe.enums.TransactionStatuses;
import br.com.volans.realsafe.enums.Transactions;
import br.com.volans.realsafe.exception.ServiceLayerException;
import br.com.volans.realsafe.model.TerminalStatus;
import br.com.volans.realsafe.model.TransactionLog;
import br.com.volans.realsafe.service.AbstractService;
import br.com.volans.realsafe.service.CashCollectionService;
import br.com.volans.realsafe.service.PrinterService;
import br.com.volans.realsafe.util.Utils;

/**
 * Implementação da interface dos serviços de recolhimento de numerário.
 * 
 * @author Volans Informática Ltda
 */

@Service
public class CashCollectionServiceImpl extends AbstractService implements CashCollectionService {
	
	/**
	 * Declaração das constantes da classe.
	 */
	
	private static final String NEW_LINE = "\n";
	
	/**
	 * Declaração das variáveis membro
	 */

	private TransactionLogDAO transactionLogDAO;
	private CashCollectionDAO cashCollectionDAO;
	private CashCollectionDetailDAO cashCollectionDetailDAO;
	private TerminalStatusDAO terminalStatusDAO;
	private PrinterService printerService;
	
	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param transactionLogDAO - Instância do DAO de log de transações.
	 * @param cashCollectionDAO - Instância do DAO de recolhimento de numerário.
	 * @param cashCollectionDetailDAO - Instância do DAO de detalhes do recolhimento de numerário.
	 * @param terminalStatusDAO - Instância do DAO de status do terminal.
	 */
	
	@Autowired
	public CashCollectionServiceImpl(
			TransactionLogDAO transactionLogDAO,
			CashCollectionDAO cashCollectionDAO,
			CashCollectionDetailDAO cashCollectionDetailDAO,
			TerminalStatusDAO terminalStatusDAO,
			PrinterService printerService) {
		this.transactionLogDAO = transactionLogDAO;
		this.cashCollectionDAO = cashCollectionDAO;
		this.cashCollectionDetailDAO = cashCollectionDetailDAO;
		this.terminalStatusDAO = terminalStatusDAO;
		this.printerService = printerService;
	}
	
	/**
	 * Efetiva a coleta do recolhimento de numerário.
	 * 
	 * @param request - Instância do request de recolhimento de numerário.
	 * 
	 * @return - DTO com os dados do resultado da execução.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	@Override
	@Transactional
	public CollectCashResponse collectCash(CollectCashRequest request) throws ServiceLayerException {
		
		CollectCashResponse result = null;
		
		try {
				
			// Verifica os dados informados.
			
			if (request.getTerminalId() == null || request.getTerminalId().trim().isEmpty()) {
				throw new ServiceLayerException(getMessage(MessageKeys.TERMINAL_CODE_NOT_INFORMED.getKey()));
			}
			
			// Recupera os dados do status do terminal.
			
			TerminalStatusDTO terminalStatusDTO = terminalStatusDAO.findByTerminalId(request.getTerminalId());
			
			if (terminalStatusDTO == null) {
				throw new ServiceLayerException(getMessage(MessageKeys.TERMINAL_STATUS_NOT_FOUND.getKey()));
			}
			
			// Obtem o próximo NSU.
			
			NSUTerminalDTO nsuTerminal = getNextNSUTerminal(request.getTerminalId());
			String nsu = String.format("%s%07d", request.getTerminalId(), nsuTerminal.getNsuTerminal().longValue());
	
			// Efetua a gravação os dados da tabela de transações.
			
			TransactionLog transactionLog = new TransactionLog();
			
			transactionLog.setNsuTerminal(nsu);
			transactionLog.setGroupOwnerId(request.getGroupOwnerId());
			transactionLog.setUnitId(request.getUnitId());
			transactionLog.setUserId(request.getUserId());
			transactionLog.setTerminalId(request.getTerminalId());
			transactionLog.setAccountingDate(terminalStatusDTO.getAccountingDate());
			transactionLog.setDateTime(nsuTerminal.getCurrentDateTime());
			transactionLog.setFunctionalityId(Transactions.CASH_COLLECTION.getCode());
			transactionLog.setBankNotes(request.getBankNotes());
			transactionLog.setAmount(request.getAmount());
			
			transactionLogDAO.insert(transactionLog);
			
			// Efetua a gravação dos detalhes do recolhimento de numerário.
	
			cashCollectionDetailDAO.insert(nsu, request.getTerminalId(), 
					TransactionStatuses.PENDENT.getCode(), Transactions.DEPOSIT.getCode());
			
			// Atualiza os dados do status do terminal.
			
			TerminalStatus terminalStatus = new TerminalStatus();
	
			BeanUtils.copyProperties(terminalStatusDTO, terminalStatus);
			
			terminalStatus.setBanknotesInSafe(0);
			terminalStatus.setAmountInSafe(BigDecimal.ZERO);
			
			terminalStatusDAO.update(terminalStatus);
			
			// Atualiza os dados do recolhimento de numerário.
			
			Integer rowsAffected = cashCollectionDAO.collectCash(request.getTerminalId());
			
			// Retorna os dados do resultado da execução.
			
			result = new CollectCashResponse();
			
			result.setRowsAffected(rowsAffected);
			result.setDateTime(nsuTerminal.getCurrentDateTime());
			result.setNsuTerminal(nsu);
			
			// Efetua a gravação do log de eventos.
			
			EventLogDTO eventLogDTO = new EventLogDTO();
			eventLogDTO.setTerminalId(request.getTerminalId());
			eventLogDTO.setUserId(request.getUserId());
			eventLogDTO.setEventId(EventLogs.EVENT_CASH_COLLECTION.getCode());
			eventLogDTO.setEventName(getMessage(EventLogs.EVENT_CASH_COLLECTION.getKey()));
			eventLogDTO.setNsuTransaction(nsu);
			eventLogDTO.setExtraData(Utils.objectToJson(request));
			eventLogDTO.setMessage(getMessage(MessageKeys.SUCCESS.getKey()));
			eventLogDTO.setResultCode(0L);
			
			createEventLog(eventLogDTO);
			
			
		}
		catch (ServiceLayerException ex) {
			
			// Efetua a gravação do log de eventos.
			
			EventLogDTO eventLogDTO = new EventLogDTO();
			eventLogDTO.setTerminalId(request.getTerminalId());
			eventLogDTO.setUserId(request.getUserId());
			eventLogDTO.setEventId(EventLogs.EVENT_CASH_COLLECTION.getCode());
			eventLogDTO.setEventName(getMessage(EventLogs.EVENT_CASH_COLLECTION.getKey()));
			eventLogDTO.setExtraData(Utils.objectToJson(request));
			eventLogDTO.setMessage(ex.getMessage());
			eventLogDTO.setResultCode(ex.getCode());
			
			createEventLog(eventLogDTO);

			throw ex;
			
		}

		return result;
	}
	
	/**
	 * Efetua a impressão do recibo de uma operação de recolhimento de numerário.
	 * 
	 * @param request - Dados do recibo a ser impresso.
	 * 
	 * @return - Resultado da impressão do recibo.
	 * 
	 * @throws ServiceLayerException
	 */
	
	@Override
	public Integer printReceipt(PrintCollectCashReceiptRequest request) throws ServiceLayerException {

		SimpleDateFormat ddmmyyyy = new SimpleDateFormat("dd/MM/yyyy");
		ddmmyyyy.setTimeZone(TimeZone.getTimeZone("UTC"));
		
		SimpleDateFormat hhmm = new SimpleDateFormat("HH:mm");
		hhmm.setTimeZone(TimeZone.getTimeZone("UTC"));

		DecimalFormat currency = new DecimalFormat("##,###,###,##0", new DecimalFormatSymbols(new Locale("pt", "BR")));
		
		LocalDateTime now = LocalDateTime.now();
		
		String companyName = request.getCompanyName().length() > 31 ? request.getCompanyName().substring(0, 31) : request.getCompanyName();
		String unitName = request.getUnitName().length() > 24 ? request.getUnitName().substring(0, 24) : request.getUnitName();
		String userName = request.getUserName().length() > 31 ? request.getUserName().substring(0, 31) : request.getUserName();
		
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("                REAL$AFE").append(NEW_LINE);
		buffer.append(NEW_LINE);
		buffer.append(now.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		buffer.append("                         ");
		buffer.append(now.format(DateTimeFormatter.ofPattern("HH:mm"))).append(NEW_LINE);
		buffer.append("----------------------------------------").append(NEW_LINE);
		buffer.append(NEW_LINE);
		buffer.append("Comprovante da Operação: RECOLHIMENTO").append(NEW_LINE);
		buffer.append(NEW_LINE);
		buffer.append("NSU: ").append(request.getNsuTerminal()).append(NEW_LINE);
		buffer.append("Filial/Unidade: ").append(unitName).append(NEW_LINE);
		buffer.append("Empresa: ").append(companyName).append(NEW_LINE);
		buffer.append("Usuário: ").append(userName).append(NEW_LINE);
		buffer.append(NEW_LINE);
		buffer.append("Terminal: ").append(request.getTerminalId());
		buffer.append(NEW_LINE);
		
		String prevCompanyName = "";
		String prevUnitName = "";
		BigDecimal total = BigDecimal.ZERO;
		
		for (TransactionLogDTO transactionLog : request.getTransactionLogs()) {
			
			if (!prevCompanyName.equals(transactionLog.getCompanyName()) ||
				!prevUnitName.equals(transactionLog.getUnitName())) {

				if (!prevCompanyName.equals("") && 
					!prevUnitName.equals("")) {

					buffer.append(NEW_LINE);
					buffer.append("Total Recolhido:      R$ ").append(String.format("%15s",currency.format(total))).append(NEW_LINE);
					buffer.append("----------------------------------------").append(NEW_LINE);
					total = BigDecimal.ZERO;
					
				}
				
				buffer.append(NEW_LINE);
				buffer.append("Filial/Unidade: ").append(transactionLog.getUnitName()).append(NEW_LINE);
				buffer.append("Empresa: ").append(transactionLog.getCompanyName()).append(NEW_LINE);
				buffer.append(NEW_LINE);
				buffer.append("Data       Hora  Usuário  Valor Retirado").append(NEW_LINE);
				buffer.append("---------- ----- ------- ---------------").append(NEW_LINE);
				
				prevCompanyName = transactionLog.getCompanyName();
				prevUnitName = transactionLog.getUnitName();
					
			}
			
			buffer.append(ddmmyyyy.format(transactionLog.getDateTime())).append(" ");
			buffer.append(hhmm.format(transactionLog.getDateTime())).append(" ");
			String userTrans = transactionLog.getUserName().length() > 7 ? transactionLog.getUserName().substring(0, 7) : transactionLog.getUserName();
			buffer.append(userTrans).append(" ");
			buffer.append(String.format("%15s", currency.format(transactionLog.getAmount())));
			buffer.append(NEW_LINE);
			
			total = total.add(transactionLog.getAmount());
			
		}

		buffer.append(NEW_LINE);
		buffer.append("Total Recolhido:      R$ ").append(String.format("%15s",currency.format(total))).append(NEW_LINE);
		buffer.append("----------------------------------------").append(NEW_LINE);

		buffer.append(NEW_LINE);
		buffer.append("Total Geral:          R$ ").append(String.format("%15s",currency.format(request.getAmount()))).append(NEW_LINE);
		buffer.append("----------------------------------------").append(NEW_LINE);
		
		try {
			
			printerService.print(buffer.toString().getBytes("UTF-8"));

			printerService.cut();

		} 
		catch (UnsupportedEncodingException ex) {

			throw new ServiceLayerException(ex);
		
		}
		
		return 0;

	}
	
	/**
	 * Retorna a lista de detalhes de um recolhimento de numerário.
	 * 
	 * @param request - Instância do request de detalhes do recolhimento de numerário.
	 * 
	 * @return - Lista de detalhes de um recolhimento de numerário.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	@Override
	public List<TransactionLogDTO> listCashCollectionDetails(ListCashCollectionDetailsRequest request) throws ServiceLayerException {

		if (request.getCashCollectionNsu() == null || request.getCashCollectionNsu().trim().isEmpty()) {
			throw new ServiceLayerException(getMessage(MessageKeys.NSU_TERMINAL_NOT_INFORMED.getKey()));
		}
		
		List<TransactionLogDTO> result = cashCollectionDetailDAO.listCashCollectionDetails(request.getCashCollectionNsu());
		
		return result;

	}
	
	/**
	 * Efetua a pesquisa do recolhimento de numerário.
	 * 
	 * @param request - Instância do request de recolhimento de numerário.
	 * 
	 * @return - DTO com os detalhes do recolhimento do numerário.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	@Override
	public List<DepositDetailDTO> listCashCollection(ListCashCollectionRequest request) throws ServiceLayerException {

		if (request.getTerminalId() == null || request.getTerminalId().trim().isEmpty()) {
			throw new ServiceLayerException(getMessage(MessageKeys.TERMINAL_CODE_NOT_INFORMED.getKey()));
		}
		
		List<DepositDetailDTO> result = cashCollectionDAO.listCashCollection(request.getTerminalId());
		
		return result;

	}

}
