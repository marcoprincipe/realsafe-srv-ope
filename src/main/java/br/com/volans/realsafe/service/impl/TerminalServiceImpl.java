package br.com.volans.realsafe.service.impl;

import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.volans.realsafe.dao.ClosingDetailDAO;
import br.com.volans.realsafe.dao.OpeningDetailDAO;
import br.com.volans.realsafe.dao.TerminalDAO;
import br.com.volans.realsafe.dao.TerminalStatusDAO;
import br.com.volans.realsafe.dao.TransactionLogDAO;
import br.com.volans.realsafe.dto.ClosingDetailDTO;
import br.com.volans.realsafe.dto.EventLogDTO;
import br.com.volans.realsafe.dto.NSUTerminalDTO;
import br.com.volans.realsafe.dto.OpeningDetailDTO;
import br.com.volans.realsafe.dto.TerminalDTO;
import br.com.volans.realsafe.dto.TerminalStatusDTO;
import br.com.volans.realsafe.dto.payload.CloseTerminalRequest;
import br.com.volans.realsafe.dto.payload.GetClosingDetailRequest;
import br.com.volans.realsafe.dto.payload.GetOpeningDetailRequest;
import br.com.volans.realsafe.dto.payload.OpenTerminalRequest;
import br.com.volans.realsafe.dto.payload.PrintCloseTerminalReceiptRequest;
import br.com.volans.realsafe.dto.payload.PrintOpenTerminalReceiptRequest;
import br.com.volans.realsafe.enums.EventLogs;
import br.com.volans.realsafe.enums.MessageKeys;
import br.com.volans.realsafe.enums.TerminalStatuses;
import br.com.volans.realsafe.enums.Transactions;
import br.com.volans.realsafe.exception.ServiceLayerException;
import br.com.volans.realsafe.model.ClosingDetail;
import br.com.volans.realsafe.model.OpeningDetail;
import br.com.volans.realsafe.model.TerminalStatus;
import br.com.volans.realsafe.model.TransactionLog;
import br.com.volans.realsafe.service.AbstractService;
import br.com.volans.realsafe.service.PrinterService;
import br.com.volans.realsafe.service.TerminalService;
import br.com.volans.realsafe.util.Utils;

/**
 * Implementação da interface dos serviços de terminais.
 * 
 * @author Volans Informática Ltda.
 */

@Service
public class TerminalServiceImpl extends AbstractService implements TerminalService {
	
	/**
	 * Declaração das constantes da classe.
	 */
	
	private static final String NEW_LINE = "\n";
	
	/**
	 * Declaração das variáveis membro.
	 */

	private TransactionLogDAO transactionLogDAO;
	private OpeningDetailDAO openingDetailDAO;
	private ClosingDetailDAO closingDetailDAO;
	private TerminalDAO terminalDAO;
	private TerminalStatusDAO terminalStatusDAO;
	private PrinterService printerService;

	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param transactionLogDAO - Instância do DAO de log de transações.
	 * @param openingDetailDAO - Instância do DAO de detalhes de abertura.
	 * @param closingDetailDAO - Instância do DAO de detalhes de fechamento.
	 * @param terminalDAO - Instância do DAO de terminais.
	 * @param terminalStatusDAO - Instância do DAO de status do terminal.
	 * @param printerService - Instância do serviço de impressão.
	 */
	
	@Autowired
	public TerminalServiceImpl(
			TransactionLogDAO transactionLogDAO,
			OpeningDetailDAO openingDetailDAO,
			ClosingDetailDAO closingDetailDAO,
			TerminalDAO terminalDAO,
			TerminalStatusDAO terminalStatusDAO,
			PrinterService printerService) {
		this.transactionLogDAO = transactionLogDAO;
		this.openingDetailDAO = openingDetailDAO;
		this.closingDetailDAO = closingDetailDAO;
		this.terminalDAO = terminalDAO;
		this.terminalStatusDAO = terminalStatusDAO;
		this.printerService = printerService;
	}

	/**
	 * Recupera os dados do terminal local.
	 * 
	 * @return - Dados do terminal.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	@Override
	public TerminalDTO getLocalTerminal() throws ServiceLayerException {
		
		TerminalDTO result = terminalDAO.findSingleLocal();
		
		return result;
		
	}

	/**
	 * Recupera os dados do status terminal local.
	 * 
	 * @param terminalId - Identificador do terminal.
	 * 
	 * @return - Dados do status do terminal.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	@Override
	public TerminalStatusDTO getTerminalStatus(String terminalId) throws ServiceLayerException {
		
		if (terminalId == null || terminalId.trim().isEmpty()) {
			throw new ServiceLayerException(getMessage(MessageKeys.TERMINAL_CODE_NOT_INFORMED.getKey()));
		}
		
		TerminalStatusDTO result = terminalStatusDAO.findByTerminalId(terminalId);
		
		if (result == null) {
			throw new ServiceLayerException(getMessage(MessageKeys.TERMINAL_STATUS_NOT_FOUND.getKey()));
		}
		
		return result;
		
	}

	/**
	 * Efetua a abertura do terminal.
	 * 
	 * @param request - Dados para abertura do terminal.
	 * 
	 * @return - Dados do status do terminal.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	@Override
	@Transactional
	public TerminalStatusDTO openTerminal(OpenTerminalRequest request) throws ServiceLayerException {
		
		Date accountingDate = null;
		TerminalStatusDTO current = null;
		
		try {
		
			try {
				
				if (request.getAccountingDate() == null || 
					request.getAccountingDate().trim().equals("")) {
					throw new ServiceLayerException(getMessage(MessageKeys.ACCOUNTING_DATE_NOT_INFORMED.getKey()));
				}
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				sdf.setLenient(false);
				
				accountingDate = sdf.parse(request.getAccountingDate());
				
				Calendar calNow = Calendar.getInstance();
				calNow.set(Calendar.HOUR_OF_DAY, 0);
				calNow.set(Calendar.MINUTE, 0);
				calNow.set(Calendar.SECOND, 0);
				calNow.set(Calendar.MILLISECOND, 0);
				
				if (accountingDate.compareTo(calNow.getTime()) < 0) {
					throw new ServiceLayerException(getMessage(MessageKeys.INVALID_ACCOUNTING_DATE.getKey()));
				}
				
				Calendar calMax = Calendar.getInstance();
				calMax.set(Calendar.HOUR_OF_DAY, 0);
				calMax.set(Calendar.MINUTE, 0);
				calMax.set(Calendar.SECOND, 0);
				calMax.set(Calendar.MILLISECOND, 0);
				calMax.add(Calendar.DAY_OF_MONTH, 3);
				
				if (accountingDate.compareTo(calMax.getTime()) > 0) {
					throw new ServiceLayerException(getMessage(MessageKeys.INVALID_ACCOUNTING_DATE.getKey()));
				}
				
			} 
			catch (ParseException ex) {
				throw new ServiceLayerException(getMessage(MessageKeys.INVALID_ACCOUNTING_DATE.getKey()));
			}
			
			// Recupera os dados do status do terminal.
			
			TerminalStatusDTO terminalStatusDTO = getTerminalStatus(request.getTerminalId());
			
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
			transactionLog.setFunctionalityId(Transactions.OPENING.getCode());
			transactionLog.setAccountingDate(accountingDate);
			transactionLog.setDateTime(request.getDateTime());
			transactionLog.setBankNotes(request.getBankNotes());
			transactionLog.setAmount(request.getAmount());
			
			transactionLogDAO.insert(transactionLog);
			
			// Efetua a gravação dos detalhes da abertura.
			
			OpeningDetail openingDetail = new OpeningDetail();
			
			openingDetail.setNsuTerminal(nsu);
			openingDetail.setAccountingDate(accountingDate);
			openingDetail.setOpeningDateTime(request.getDateTime());
			openingDetail.setBankNotesInSafe(request.getBankNotes());
			openingDetail.setAmountInSafe(request.getAmount());
			openingDetail.setLastClosingDateTime(terminalStatusDTO.getLastClosingDateTime());
			openingDetail.setLastClosingBanknotes(terminalStatusDTO.getLastClosingBanknotes());
			openingDetail.setLastClosingAmount(terminalStatusDTO.getLastClosingAmount());
			openingDetail.setEtvClosing(request.getEtvClosing());
			
			openingDetailDAO.insert(openingDetail);
			
			//Efetua a gravação dos dados do status do terminal.
			
			TerminalStatus transactionStatus = new TerminalStatus();
			
			BeanUtils.copyProperties(terminalStatusDTO, transactionStatus);
			
			transactionStatus.setAccountingDate(accountingDate);
			transactionStatus.setBanknotesInSafe(request.getBankNotes());
			transactionStatus.setAmountInSafe(request.getAmount());
			
			transactionStatus.setLastOpeningDateTime(request.getDateTime());
			transactionStatus.setLastOpeningBanknotes(request.getBankNotes());
			transactionStatus.setLastOpeningAmount(request.getAmount());
			transactionStatus.setEtvClosing(request.getEtvClosing());
			transactionStatus.setStatus(TerminalStatuses.OPEN.getCode());
			
			terminalStatusDAO.update(transactionStatus);
			
			current = getTerminalStatus(request.getTerminalId());
			current.setLastNSU(nsu);
			
			// Efetua a gravação do log de eventos.
			
			EventLogDTO eventLogDTO = new EventLogDTO();
			eventLogDTO.setTerminalId(request.getTerminalId());
			eventLogDTO.setUserId(request.getUserId());
			eventLogDTO.setEventId(EventLogs.EVENT_OPEN_TERMINAL.getCode());
			eventLogDTO.setEventName(getMessage(EventLogs.EVENT_OPEN_TERMINAL.getKey()));
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
			eventLogDTO.setEventId(EventLogs.EVENT_OPEN_TERMINAL.getCode());
			eventLogDTO.setEventName(getMessage(EventLogs.EVENT_OPEN_TERMINAL.getKey()));
			eventLogDTO.setExtraData(Utils.objectToJson(request));
			eventLogDTO.setMessage(ex.getMessage());
			eventLogDTO.setResultCode(ex.getCode());
			
			createEventLog(eventLogDTO);
			
			throw ex;
			
		}
		
		return current;
	
	}
	
	/**
	 * Efetua a impressão do recibo de uma operação de abertura de terminal.
	 * 
	 * @param request - Dados do recibo a ser impresso.
	 * 
	 * @return - Resultado da impressão do recibo.
	 * 
	 * @throws ServiceLayerException
	 */
	
	@Override
	public Integer printOpenTerminalReceipt(PrintOpenTerminalReceiptRequest request) throws ServiceLayerException {

		SimpleDateFormat ddmmyyyy = new SimpleDateFormat("dd/MM/yyyy");
		ddmmyyyy.setTimeZone(TimeZone.getTimeZone("UTC"));
		
		SimpleDateFormat hhmm = new SimpleDateFormat("HH:mm");
		hhmm.setTimeZone(TimeZone.getTimeZone("UTC"));

		DecimalFormat currency = new DecimalFormat("##,###,###,##0", new DecimalFormatSymbols(new Locale("pt", "BR")));
		
		LocalDateTime now = LocalDateTime.now();
		
		String companyName = request.getCompanyName().length() > 31 ? request.getCompanyName().substring(0, 31) : request.getCompanyName();
		String unitName = request.getUnitName().length() > 24 ? request.getUnitName().substring(0, 24) : request.getUnitName();
		String userName = request.getUserName().length() > 31 ? request.getUserName().substring(0, 31) : request.getUserName();
		String amount = String.format("%15s", currency.format(request.getAmount()));
		
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("                REAL$AFE").append(NEW_LINE);
		buffer.append(NEW_LINE);
		buffer.append(now.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		buffer.append("                         ");
		buffer.append(now.format(DateTimeFormatter.ofPattern("HH:mm"))).append(NEW_LINE);
		buffer.append("----------------------------------------").append(NEW_LINE);
		buffer.append(NEW_LINE);
		buffer.append("Comprovante da Operação: ABERTURA").append(NEW_LINE);
		buffer.append(NEW_LINE);
		buffer.append("NSU: ").append(request.getNsu()).append(NEW_LINE);
		buffer.append("Filial/Unidade: ").append(unitName).append(NEW_LINE);
		buffer.append("Empresa: ").append(companyName).append(NEW_LINE);
		buffer.append("Usuário: ").append(userName).append(NEW_LINE);
		buffer.append(NEW_LINE);
		buffer.append("Terminal: ").append(request.getTerminalId()).append(NEW_LINE);
		buffer.append(NEW_LINE);
		buffer.append("Data           Hora      Valor Existente").append(NEW_LINE);
		buffer.append("----------     -----     ---------------").append(NEW_LINE);
		buffer.append(ddmmyyyy.format(request.getDateTime())).append("     ");
		buffer.append(hhmm.format(request.getDateTime())).append("     ");
		buffer.append(amount).append(NEW_LINE);
		buffer.append(NEW_LINE);
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
	 * Retorna os dados do detalhe da abertura do terminal.
	 * 
	 * @param request - Dados para pesquisa dos detalhes da abertura.
	 * 
	 * @return - Dados do detalhe da abertura do terminal.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	@Override
	public OpeningDetailDTO getOpeningDetail(GetOpeningDetailRequest request) throws ServiceLayerException {

		if (request.getNsuTerminal() == null || request.getNsuTerminal().trim().isEmpty()) {
			throw new ServiceLayerException(getMessage(MessageKeys.NSU_TERMINAL_NOT_INFORMED.getKey()));
		}
		
		OpeningDetailDTO result = openingDetailDAO.getOpeningDetail(request.getNsuTerminal());
		
		return result;
		
	}

	/**
	 * Efetua o fechamento do terminal.
	 * 
	 * @param request - Dados para fechamento do terminal.
	 * 
	 * @return - Status do terminal atualizado.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	@Override
	@Transactional
	public TerminalStatusDTO closeTerminal(CloseTerminalRequest request) throws ServiceLayerException {
		
		TerminalStatusDTO result = null;
		
		try {
		
			// Recupera os dados do status do terminal.
			
			TerminalStatusDTO terminalStatusDTO = getTerminalStatus(request.getTerminalId());
			
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
			transactionLog.setFunctionalityId(Transactions.CLOSING.getCode());
			transactionLog.setAccountingDate(terminalStatusDTO.getAccountingDate());
			transactionLog.setDateTime(request.getDateTime());
			transactionLog.setBankNotes(request.getBankNotes());
			transactionLog.setAmount(request.getAmount());
			
			transactionLogDAO.insert(transactionLog);
			
			// Efetua a gravação dos detalhes do fechamento.
			
			ClosingDetail closingDetail = new ClosingDetail();
			
			closingDetail.setNsuTerminal(nsu);
			closingDetail.setClosingDateTime(request.getDateTime());
			closingDetail.setBankNotesInSafe(request.getBankNotes());
			closingDetail.setAmountInSafe(request.getAmount());
			closingDetail.setLastOpeningDateTime(terminalStatusDTO.getLastOpeningDateTime());
			closingDetail.setLastOpeningBanknotes(terminalStatusDTO.getLastOpeningBanknotes());
			closingDetail.setLastOpeningAmount(terminalStatusDTO.getLastOpeningAmount());
			
			closingDetailDAO.insert(closingDetail);
			
			//Efetua a gravação dos dados do status do terminal.
			
			TerminalStatus transactionStatus = new TerminalStatus();
			
			BeanUtils.copyProperties(terminalStatusDTO, transactionStatus);
			
			transactionStatus.setLastClosingDateTime(request.getDateTime());
			transactionStatus.setLastClosingBanknotes(request.getBankNotes());
			transactionStatus.setLastClosingAmount(request.getAmount());
			transactionStatus.setStatus(TerminalStatuses.CLOSED.getCode());
			
			terminalStatusDAO.update(transactionStatus);
			
			result = getTerminalStatus(request.getTerminalId());
			result.setLastNSU(nsu);
			
			// Efetua a gravação do log de eventos.
			
			EventLogDTO eventLogDTO = new EventLogDTO();
			eventLogDTO.setTerminalId(request.getTerminalId());
			eventLogDTO.setUserId(request.getUserId());
			eventLogDTO.setEventId(EventLogs.EVENT_CLOSE_TERMINAL.getCode());
			eventLogDTO.setEventName(getMessage(EventLogs.EVENT_CLOSE_TERMINAL.getKey()));
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
			eventLogDTO.setEventId(EventLogs.EVENT_CLOSE_TERMINAL.getCode());
			eventLogDTO.setEventName(getMessage(EventLogs.EVENT_CLOSE_TERMINAL.getKey()));
			eventLogDTO.setExtraData(Utils.objectToJson(request));
			eventLogDTO.setMessage(ex.getMessage());
			eventLogDTO.setResultCode(ex.getCode());
			
			createEventLog(eventLogDTO);
			
			throw ex;
			
		}
		
		return result;

	}
	
	/**
	 * Efetua a impressão do recibo de uma operação de fechamento de terminal.
	 * 
	 * @param request - Dados do recibo a ser impresso.
	 * 
	 * @return - Resultado da impressão do recibo.
	 * 
	 * @throws ServiceLayerException
	 */
	
	@Override
	public Integer printCloseTerminalReceipt(PrintCloseTerminalReceiptRequest request) throws ServiceLayerException {

		SimpleDateFormat ddmmyyyy = new SimpleDateFormat("dd/MM/yyyy");
		ddmmyyyy.setTimeZone(TimeZone.getTimeZone("UTC"));
		
		SimpleDateFormat hhmm = new SimpleDateFormat("HH:mm");
		hhmm.setTimeZone(TimeZone.getTimeZone("UTC"));

		DecimalFormat currency = new DecimalFormat("##,###,###,##0", new DecimalFormatSymbols(new Locale("pt", "BR")));
		
		LocalDateTime now = LocalDateTime.now();
		
		String companyName = request.getCompanyName().length() > 31 ? request.getCompanyName().substring(0, 31) : request.getCompanyName();
		String unitName = request.getUnitName().length() > 24 ? request.getUnitName().substring(0, 24) : request.getUnitName();
		String userName = request.getUserName().length() > 31 ? request.getUserName().substring(0, 31) : request.getUserName();
		String amount = String.format("%15s", currency.format(request.getAmount()));
		
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("                REAL$AFE").append(NEW_LINE);
		buffer.append(NEW_LINE);
		buffer.append(now.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		buffer.append("                         ");
		buffer.append(now.format(DateTimeFormatter.ofPattern("HH:mm"))).append(NEW_LINE);
		buffer.append("----------------------------------------").append(NEW_LINE);
		buffer.append(NEW_LINE);
		buffer.append("Comprovante da Operação: FECHAMENTO").append(NEW_LINE);
		buffer.append(NEW_LINE);
		buffer.append("NSU: ").append(request.getNsu()).append(NEW_LINE);
		buffer.append("Filial/Unidade: ").append(unitName).append(NEW_LINE);
		buffer.append("Empresa: ").append(companyName).append(NEW_LINE);
		buffer.append("Usuário: ").append(userName).append(NEW_LINE);
		buffer.append(NEW_LINE);
		buffer.append("Terminal: ").append(request.getTerminalId()).append(NEW_LINE);
		buffer.append(NEW_LINE);
		buffer.append("Data           Hora      Valor Existente").append(NEW_LINE);
		buffer.append("----------     -----     ---------------").append(NEW_LINE);
		buffer.append(ddmmyyyy.format(request.getDateTime())).append("     ");
		buffer.append(hhmm.format(request.getDateTime())).append("     ");
		buffer.append(amount).append(NEW_LINE);
		buffer.append(NEW_LINE);
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
	 * Retorna os dados do detalhe do fechamento do terminal.
	 * 
	 * @param request - Dados para pesquisa dos detalhes do fechamento.
	 * 
	 * @return - Dados do detalhe do fechamento do terminal.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	@Override
	public ClosingDetailDTO getClosingDetail(GetClosingDetailRequest request) throws ServiceLayerException {

		if (request.getNsuTerminal() == null || request.getNsuTerminal().trim().isEmpty()) {
			throw new ServiceLayerException(getMessage(MessageKeys.NSU_TERMINAL_NOT_INFORMED.getKey()));
		}
		
		ClosingDetailDTO result = closingDetailDAO.getClosingDetail(request.getNsuTerminal());
		
		return result;
		
	}

}
