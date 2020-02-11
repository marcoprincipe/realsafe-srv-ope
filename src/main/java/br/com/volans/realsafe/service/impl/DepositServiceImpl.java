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

import br.com.volans.realsafe.dao.DepositDetailDAO;
import br.com.volans.realsafe.dao.TerminalStatusDAO;
import br.com.volans.realsafe.dao.TransactionLogDAO;
import br.com.volans.realsafe.driver.depository.dto.BankNoteDTO;
import br.com.volans.realsafe.dto.NSUTerminalDTO;
import br.com.volans.realsafe.dto.TerminalStatusDTO;
import br.com.volans.realsafe.dto.payload.DepositRequest;
import br.com.volans.realsafe.dto.payload.DepositResponse;
import br.com.volans.realsafe.dto.payload.PrintDepositReceiptRequest;
import br.com.volans.realsafe.enums.MessageKeys;
import br.com.volans.realsafe.enums.Transactions;
import br.com.volans.realsafe.exception.ServiceLayerException;
import br.com.volans.realsafe.model.DepositDetail;
import br.com.volans.realsafe.model.DepositDetailPK;
import br.com.volans.realsafe.model.TerminalStatus;
import br.com.volans.realsafe.model.TransactionLog;
import br.com.volans.realsafe.service.AbstractService;
import br.com.volans.realsafe.service.DepositService;
import br.com.volans.realsafe.service.PrinterService;

/**
 * Implementação da interface dos serviços de logs de transações de depósito.
 * 
 * @author Volans Informática Ltda
 */

@Service
public class DepositServiceImpl extends AbstractService implements DepositService {
	
	/**
	 * Declaração das constantes da classe.
	 */
	
	private static final String NEW_LINE = "\n";
	
	/**
	 * Declaração das variáveis membro
	 */

	private TransactionLogDAO transactionLogDAO;
	private DepositDetailDAO depositDetailDAO;
	private TerminalStatusDAO terminalStatusDAO;
	private PrinterService printerService;
	
	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param transactionLogDAO - Instância do DAO de log de transações.
	 * @param nsuTerminalDAO - Instância do DAO do NSU de terminais.
	 * @param depositDetailDAO - Instância do DAO de detalhes de depósitos.
	 * @param printerService - Instância do serviço de impressão.
	 */
	
	@Autowired
	public DepositServiceImpl(
			TransactionLogDAO transactionLogDAO,
			DepositDetailDAO depositDetailDAO,
			TerminalStatusDAO terminalStatusDAO,
			PrinterService printerService) {
		this.transactionLogDAO = transactionLogDAO;
		this.depositDetailDAO = depositDetailDAO;
		this.terminalStatusDAO = terminalStatusDAO;
		this.printerService = printerService;
	}
	
	/**
	 * Efetua a gravação dos dados de uma operação de depósito.
	 * 
	 * @param request - Dados do depósito a ser gravado.
	 * 
	 * @return - Dados da resposta do depósito.
	 * 
	 * @throws ServiceLayerException
	 */
	
	@Override
	@Transactional
	public DepositResponse deposit(DepositRequest request) throws ServiceLayerException {

		// Verifica os dados informados.
		
		if (request.getTerminalId() == null || request.getTerminalId().trim().isEmpty()) {
			throw new ServiceLayerException(getMessage(MessageKeys.TERMINAL_CODE_NOT_INFORMED.getKey()));
		}
		
		// Obtem os dados do status do terminal.
		
		TerminalStatusDTO terminalStatusDTO = terminalStatusDAO.findByTerminalId(request.getTerminalId());
		
		if (terminalStatusDTO == null) {
			throw new ServiceLayerException(getMessage(MessageKeys.TERMINAL_STATUS_NOT_FOUND.getKey()));
		}
		
		// Obtem o próximo NSU.

		NSUTerminalDTO nsuTerminal = getNextNSU(request.getTerminalId());
		String nsu = String.format("%s%07d", request.getTerminalId(), nsuTerminal.getNsuTerminal().longValue());

		// Sumariza o total de cédulas.
		
		List<BankNoteDTO> bankNotes = request.getBankNotes();
		
		Integer totalBankNotes = 0;

		for (BankNoteDTO bankNote : bankNotes) {
			totalBankNotes += bankNote.getQuantity();
		}
		
		// Efetua a gravação os dados da tabela de transações.
		
		TransactionLog transactionLog = new TransactionLog();
		
		transactionLog.setNsuTerminal(nsu);
		transactionLog.setGroupOwnerId(request.getGroupOwnerId());
		transactionLog.setUnitId(request.getUnitId());
		transactionLog.setUserId(request.getUserId());
		transactionLog.setTerminalId(request.getTerminalId());
		transactionLog.setAccountingDate(terminalStatusDTO.getAccountingDate());
		transactionLog.setDateTime(nsuTerminal.getCurrentDateTime());
		transactionLog.setFunctionalityId(Transactions.DEPOSIT.getCode());
		transactionLog.setBankNotes(totalBankNotes);
		transactionLog.setAmount(request.getAmount());
		
		transactionLogDAO.insert(transactionLog);

		// Efetua a gravação dos dados do detalhe do depósito.
		
		bankNotes = request.getBankNotes();
		
		Integer includeOrder = 0;
		Integer quantity = 0;
		BigDecimal amount = BigDecimal.ZERO;
		
		for (BankNoteDTO bankNote : bankNotes) {
			
			DepositDetail depositDetail = new DepositDetail();
			
			depositDetail.setPk(new DepositDetailPK());
			depositDetail.getPk().setNsuTerminal(nsu);
			depositDetail.getPk().setIncludeOrder(++includeOrder);
			depositDetail.setQuantity(bankNote.getQuantity());
			depositDetail.setAmount(bankNote.getValue());
			
			depositDetailDAO.insert(depositDetail);
			
			amount = amount.add(bankNote.getTotal());
			quantity += bankNote.getQuantity();
			
		}
		
		// Atualiza os dados do status do terminal.
		
		terminalStatusDTO.setBanknotesInSafe(terminalStatusDTO.getBanknotesInSafe() + quantity);
		terminalStatusDTO.setAmountInSafe(terminalStatusDTO.getAmountInSafe().add(amount));
		
		TerminalStatus terminalStatus = new TerminalStatus();
		
		BeanUtils.copyProperties(terminalStatusDTO, terminalStatus);
		
		terminalStatusDAO.update(terminalStatus);
		
		// Cria o objeto com a resposta do depósito.
		
		DepositResponse result = new DepositResponse();
		
		result.setTerminalId(request.getTerminalId());
		result.setNsuTerminal(nsu);
		result.setDateTime(nsuTerminal.getCurrentDateTime());
		result.setBankNotes(request.getBankNotes());
		result.setAmount(request.getAmount());
		
		return result;
		
	}
	
	/**
	 * Efetua a impressão do recibo de uma operação de depósito.
	 * 
	 * @param request - Dados do recibo a ser impresso.
	 * 
	 * @return - Resultado da impressão do recibo.
	 * 
	 * @throws ServiceLayerException
	 */
	
	@Override
	public Integer printReceipt(PrintDepositReceiptRequest request) throws ServiceLayerException {

		SimpleDateFormat ddmmyyyy = new SimpleDateFormat("dd/MM/yyyy");
		ddmmyyyy.setTimeZone(TimeZone.getTimeZone("UTC"));
		
		SimpleDateFormat hhmm = new SimpleDateFormat("HH:mm");
		hhmm.setTimeZone(TimeZone.getTimeZone("UTC"));

		DecimalFormat quantity = new DecimalFormat("###0");
		DecimalFormat bankNoteValue = new DecimalFormat("##0");
		DecimalFormat totalBanknote = new DecimalFormat("##,###,###,##0", new DecimalFormatSymbols(new Locale("pt", "BR")));
		
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
		buffer.append("Comprovante da Operação: DEPÓSITO").append(NEW_LINE);
		buffer.append(NEW_LINE);
		buffer.append("NSU: ").append(request.getNsuTerminal()).append(NEW_LINE);
		buffer.append("Filial/Unidade: ").append(unitName).append(NEW_LINE);
		buffer.append("Empresa: ").append(companyName).append(NEW_LINE);
		buffer.append("Usuário: ").append(userName).append(NEW_LINE);
		buffer.append(NEW_LINE);
		buffer.append("Terminal: ").append(request.getTerminalId()).append(NEW_LINE);
		buffer.append(NEW_LINE);
		buffer.append("Data       Hora  Qtd  Céd Valor Depósito").append(NEW_LINE);
		buffer.append("---------- ----- ---- --- --------------").append(NEW_LINE);
		
		for (BankNoteDTO bankNoteDTO : request.getBankNotes()) {
			buffer.append(ddmmyyyy.format(request.getDateTime())).append(" ");
			buffer.append(hhmm.format(request.getDateTime())).append(" ");
			buffer.append(String.format("%4s",quantity.format(bankNoteDTO.getQuantity()))).append(" ");
			buffer.append(String.format("%3s",bankNoteValue.format(bankNoteDTO.getValue()))).append(" ");
			buffer.append(String.format("%14s",totalBanknote.format(bankNoteDTO.getTotal())));
			buffer.append(NEW_LINE);
		}
		
		buffer.append(NEW_LINE);
		buffer.append("Total Depositado:      R$").append(" ");
		buffer.append(String.format("%14s",totalBanknote.format(request.getAmount())));
		buffer.append(NEW_LINE);
		buffer.append("----------------------------------------");
		
		try {
			
			printerService.print(buffer.toString().getBytes("UTF-8"));

			printerService.cut();

		} 
		catch (UnsupportedEncodingException ex) {

			throw new ServiceLayerException(ex);
		
		}
		
		return 0;
		
	}

}
