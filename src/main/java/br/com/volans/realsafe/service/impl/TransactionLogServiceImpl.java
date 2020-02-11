package br.com.volans.realsafe.service.impl;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.volans.realsafe.dao.TransactionLogDAO;
import br.com.volans.realsafe.dto.TransactionLogDTO;
import br.com.volans.realsafe.dto.payload.PrintBankStatementRequest;
import br.com.volans.realsafe.enums.MessageKeys;
import br.com.volans.realsafe.exception.ServiceLayerException;
import br.com.volans.realsafe.model.TransactionLog;
import br.com.volans.realsafe.service.AbstractService;
import br.com.volans.realsafe.service.PrinterService;
import br.com.volans.realsafe.service.TransactionLogService;

/**
 * Implementação da interface dos serviços de log de transações.
 * 
 * @author Volans Informática Ltda
 */

@Service
public class TransactionLogServiceImpl extends AbstractService implements TransactionLogService {
	
	/**
	 * Declaração das constantes da classe.
	 */
	
	private static final String NEW_LINE = "\n";
	
	/**
	 * Declaração das variáveis membro
	 */

	private TransactionLogDAO transactionLogDAO;
	private PrinterService printerService;
	
	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param transactionLogDAO - Instância do DAO de log de transações.
	 */
	
	@Autowired
	public TransactionLogServiceImpl(
			TransactionLogDAO transactionLogDAO,
			PrinterService printerService) {
		this.transactionLogDAO = transactionLogDAO;
		this.printerService = printerService;
	}
	
	/**
	 * Efetua a inclusão de um log na tabela.
	 * 
	 * @param transactionLogDTO - Instância do DTO de log de transações.
	 * 
	 * @return - Instância do DTO de log de transações.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	@Override
	public TransactionLogDTO insert(TransactionLogDTO transactionLogDTO) throws ServiceLayerException {
		
		checkTransactionData(transactionLogDTO);
		
		TransactionLogDTO result = new TransactionLogDTO();
		
		TransactionLog transactionLog = new TransactionLog();
		
		transactionLog.setNsuTerminal(transactionLogDTO.getNsuTerminal());
		transactionLog.setGroupOwnerId(transactionLogDTO.getGroupOwnerId());
		transactionLog.setUnitId(transactionLogDTO.getUnitId());
		transactionLog.setUserId(transactionLogDTO.getUserId());
		transactionLog.setTerminalId(transactionLogDTO.getTerminalId());
		transactionLog.setFunctionalityId(transactionLogDTO.getFunctionalityId());
		transactionLog.setAmount(transactionLogDTO.getAmount());
		
		transactionLog = transactionLogDAO.insert(transactionLog);
		
		BeanUtils.copyProperties(transactionLog, result);
		
		return result;
	}
	
	/**
	 * Obtem a lista de linhas de logs de transações de um terminal.
	 * 
	 * @param groupOwnerId - Identificador do terminal.
	 * 
	 * @return - Lista de linhas do log de transações.
	 */

	@Override
	public List<TransactionLogDTO> listTransactionLog(String terminalId) throws ServiceLayerException {
		
		return listTransactionLog(terminalId, null, null);
		
	}
	
	/**
	 * Obtem a lista de linhas de logs de transações de um terminal.
	 * 
	 * @param terminalId - Identificador do terminal.
	 * @param status - Identificador do status da transação.
	 * 
	 * @return - Lista de linhas do log de transações.
	 */
	
	@Override
	public List<TransactionLogDTO> listTransactionLog(String terminalId, String status) throws ServiceLayerException {
		
		return listTransactionLog(terminalId, status, null);
		
	}
	
	/**
	 * Obtem a lista de linhas de logs de transações de um terminal.
	 * 
	 * @param terminalId - Identificador do terminal.
	 * @param status - Identificador do status da transação.
	 * @param functionalityId - Identificador da funcionalidade.
	 * 
	 * @return - Lista de linhas do log de transações.
	 */
	
	@Override
	public List<TransactionLogDTO> listTransactionLog(String terminalId, String status, Long functionalityId) throws ServiceLayerException {

		if (terminalId == null || terminalId.trim().isEmpty()) {
			throw new ServiceLayerException(getMessage(MessageKeys.TERMINAL_CODE_NOT_INFORMED.getKey()));
		}
		
		return transactionLogDAO.listTransactionLog(terminalId, status, functionalityId);
		
	}
	
	/**
	 * Obtem a lista de linhas de logs de transações de um proprietário de grupos.
	 * 
	 * @param groupOwnerId - Identificador do proprietário de grupos.
	 * 
	 * @return - Lista de linhas do log de transações.
	 */
	
	public List<TransactionLogDTO> listTransactionLog(BigDecimal groupOwnerId) throws ServiceLayerException {
		
		if (groupOwnerId == null) {
			throw new ServiceLayerException(getMessage(MessageKeys.GROUP_OWNER_CODE_NOT_INFORMED.getKey()));
		}
		
		if (groupOwnerId.compareTo(BigDecimal.ZERO) <= 0) {
			throw new ServiceLayerException(getMessage(MessageKeys.INVALID_GROUP_OWNER_CODE.getKey()));
		}
		
		return transactionLogDAO.listTransactionLog(groupOwnerId);
		
	}
	
	/**
	 * Verifica os dados do log de transações.
	 * 
	 * @param transactionLogDTO - Instância do DTO de log de transações.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	private void checkTransactionData(TransactionLogDTO transactionLogDTO) throws ServiceLayerException {
		
		if (transactionLogDTO.getNsuTerminal() == null || transactionLogDTO.getNsuTerminal().trim().isEmpty()) {
			throw new ServiceLayerException(getMessage(MessageKeys.NSU_TERMINAL_NOT_INFORMED.getKey()));
		}
		
		if (transactionLogDTO.getGroupOwnerId() == null) {
			throw new ServiceLayerException(getMessage(MessageKeys.GROUP_OWNER_CODE_NOT_INFORMED.getKey()));
		}
		
		if (transactionLogDTO.getGroupOwnerId().compareTo(BigDecimal.ZERO) <= 0) {
			throw new ServiceLayerException(getMessage(MessageKeys.INVALID_GROUP_OWNER_CODE.getKey()));
		}
		
		if (transactionLogDTO.getUnitId() == null) {
			throw new ServiceLayerException(getMessage(MessageKeys.UNIT_CODE_NOT_INFORMED.getKey()));
		}
		
		if (transactionLogDTO.getUnitId().compareTo(BigDecimal.ZERO) <= 0) {
			throw new ServiceLayerException(getMessage(MessageKeys.INVALID_UNIT_CODE.getKey()));
		}
		
		if (transactionLogDTO.getUserId() == null) {
			throw new ServiceLayerException(getMessage(MessageKeys.USER_CODE_NOT_INFORMED.getKey()));
		}
		
		if (transactionLogDTO.getUserId().compareTo(BigDecimal.ZERO) <= 0) {
			throw new ServiceLayerException(getMessage(MessageKeys.INVALID_USER_CODE.getKey()));
		}
		
		if (transactionLogDTO.getTerminalId() == null || transactionLogDTO.getTerminalId().trim().isEmpty()) {
			throw new ServiceLayerException(getMessage(MessageKeys.TERMINAL_CODE_NOT_INFORMED.getKey()));
		}

		if (transactionLogDTO.getFunctionalityId() == null) {
			throw new ServiceLayerException(getMessage(MessageKeys.FUNCTIONALITY_CODE_NOT_INFORMED.getKey()));
		}

		if (transactionLogDTO.getFunctionalityId().longValue() <= 0) {
			throw new ServiceLayerException(getMessage(MessageKeys.INVALID_FUNCTIONALITY_CODE.getKey()));
		}
		
		if (transactionLogDTO.getAmount() == null) {
			throw new ServiceLayerException(getMessage(MessageKeys.TRANSACTION_AMOUNT_NOT_INFORMED.getKey()));
		}
		
		if (transactionLogDTO.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
			throw new ServiceLayerException(getMessage(MessageKeys.INVALID_TRANSACTION_AMOUNT.getKey()));
		}
		
	}
	
	/**
	 * Obtem a lista de linhas de logs de transações.
	 * 
	 * @param groupOwnerId - Identificador do proprietário de grupos.
	 * @param nsuTerminal - Identificador da transação.
	 * @param startDate - Data inicial para pesquisa.
	 * @param endDate - Data final para pesquisa.
	 * 
	 * @return - Lista de linhas do log de transações.
	 */
	
	@Override
	public List<TransactionLogDTO> searchTransactionLog(BigDecimal groupOwnerId, String nsuTerminal, String startDate, String endDate) throws ServiceLayerException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sdf.setLenient(false);
		
		if ((nsuTerminal == null || nsuTerminal.trim().isEmpty()) && 
			(startDate == null || startDate.trim().isEmpty()) && 
			(endDate == null || endDate.trim().isEmpty())) {
			throw new ServiceLayerException(getMessage(MessageKeys.NO_PARAMETER_INFORMED.getKey()));
		}
		
		if (groupOwnerId == null) {
			throw new ServiceLayerException(getMessage(MessageKeys.GROUP_OWNER_CODE_NOT_INFORMED.getKey()));
		}
		
		if (groupOwnerId.compareTo(BigDecimal.ZERO) <= 0) {
			throw new ServiceLayerException(getMessage(MessageKeys.INVALID_GROUP_OWNER_CODE.getKey()));
		}
		
		if ((startDate == null || startDate.trim().isEmpty()) && 
			(endDate != null && !endDate.trim().isEmpty())) {
			throw new ServiceLayerException(getMessage(MessageKeys.INITIAL_DATE_NOT_INFORMED.getKey()));
		}
		
		if ((startDate != null && !startDate.trim().isEmpty()) && 
			(endDate == null || endDate.trim().isEmpty())) {
			throw new ServiceLayerException(getMessage(MessageKeys.FINAL_DATE_NOT_INFORMED.getKey()));
		}
		
		String nsuPattern = "^([A-Z]{3})([0-9]{12})$";
		
		if (nsuTerminal != null && !nsuTerminal.trim().isEmpty()) {
			if (!nsuTerminal.matches(nsuPattern)) {
				throw new ServiceLayerException(getMessage(MessageKeys.INVALID_NSU_FORMAT.getKey()));
			}
		}
		
		Date initialDate = null;
		
		try {
			
			if (startDate != null) {
				StringBuffer strInitial = new StringBuffer(startDate).append(" 00:00:00");
				initialDate = sdf.parse(strInitial.toString());
			}
			
		}
		catch (ParseException ex) {
			throw new ServiceLayerException(getMessage(MessageKeys.INVALID_INITIAL_DATE.getKey()));
		}
		
		Date finalDate = null;
		
		try {
			
			if (endDate != null) {
				StringBuffer strFinal = new StringBuffer(endDate).append(" 23:59:59");
				finalDate = sdf.parse(strFinal.toString());
			}
			
		}
		catch (ParseException ex) {
			throw new ServiceLayerException(getMessage(MessageKeys.INVALID_FINAL_DATE.getKey()));
		}
		
		if (initialDate != null && finalDate != null) {
			if (initialDate.compareTo(finalDate) > 0) {
				throw new ServiceLayerException(getMessage(MessageKeys.INITIAL_DATE_GREATER_THAN_FINAL.getKey()));
			}
		}
		
		return transactionLogDAO.searchTransactionLog(groupOwnerId, nsuTerminal, initialDate, finalDate);
		
	}
	
	/**
	 * Efetua a impressão dos logs de transação de um extrato.
	 * 
	 * @param request - Objeto com os dados do extrato a ser impresso.
	 * 
	 * @return - Resultado a operação.
	 */
	
	@Override
	public Integer printBankStatement(PrintBankStatementRequest request) throws ServiceLayerException {

		SimpleDateFormat ddmmyyyy = new SimpleDateFormat("dd/MM/yyyy");
		ddmmyyyy.setTimeZone(TimeZone.getTimeZone("UTC"));
		
		SimpleDateFormat hhmm = new SimpleDateFormat("HH:mm");
		hhmm.setTimeZone(TimeZone.getTimeZone("UTC"));

		DecimalFormat currency = new DecimalFormat("###,##0", new DecimalFormatSymbols(new Locale("pt", "BR")));
		
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
		buffer.append("Comprovante da Operação: EXTRATO").append(NEW_LINE);
		buffer.append(NEW_LINE);
		buffer.append("Filial/Unidade: ").append(unitName).append(NEW_LINE);
		buffer.append("Empresa: ").append(companyName).append(NEW_LINE);
		buffer.append("Usuário: ").append(userName).append(NEW_LINE);
		buffer.append(NEW_LINE);
		buffer.append("Terminal: ").append(request.getTerminalId()).append(NEW_LINE);
		
		String currentCompanyUnit = "";
		String previousCompanyUnit = "";
		
		for (TransactionLogDTO transactionLog : request.getTransactionLogs()) {
			
			currentCompanyUnit = transactionLog.getCompanyName() + "/" + transactionLog.getUnitName();
			
			if (!previousCompanyUnit.equals(currentCompanyUnit)) {
				buffer.append(NEW_LINE);
				buffer.append("Empresa: ").append(transactionLog.getCompanyName().length() > 40 ? transactionLog.getCompanyName().substring(0,  40) : transactionLog.getCompanyName()).append(NEW_LINE);
				buffer.append("Filial/Unidade: ").append(transactionLog.getUnitName().length() > 40 ? transactionLog.getCompanyName().substring(0,  40) : transactionLog.getUnitName()).append(NEW_LINE);
				buffer.append(NEW_LINE);
				buffer.append("Data       Hora  Trans. Usuário  Valores").append(NEW_LINE);
				buffer.append("---------- ----- ------ ------- --------").append(NEW_LINE);
				previousCompanyUnit = currentCompanyUnit;
			}
			
			buffer.append(ddmmyyyy.format(transactionLog.getDateTime())).append(" ");
			buffer.append(hhmm.format(transactionLog.getDateTime())).append(" ");
			String transaction = transactionLog.getFunctionalityName().length() > 6 ? transactionLog.getFunctionalityName().substring(0, 6) : transactionLog.getFunctionalityName();
			buffer.append(transaction).append(" ");
			String userTrans = transactionLog.getUserName().length() > 7 ? transactionLog.getUserName().substring(0, 7) : transactionLog.getUserName();
			buffer.append(userTrans).append(" ");
			buffer.append(String.format("%8s",currency.format(transactionLog.getAmount())));
			buffer.append(NEW_LINE);
			
		}
		
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
