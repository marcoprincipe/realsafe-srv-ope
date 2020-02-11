package br.com.volans.realsafe.service;

import java.math.BigDecimal;
import java.util.List;

import br.com.volans.realsafe.dto.TransactionLogDTO;
import br.com.volans.realsafe.dto.payload.PrintBankStatementRequest;
import br.com.volans.realsafe.exception.ServiceLayerException;

/**
 * Interface para implementação dos serviços de log de transações.
 * 
 * @author Volans Informática Ltda
 */

public interface TransactionLogService {
	
	/**
	 * Efetua a inclusão de um log na tabela.
	 * 
	 * @param transactionLogDTO - Instância do DTO de log de transação.
	 * 
	 * @return - Instância do DTO de log de transação.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	TransactionLogDTO insert(TransactionLogDTO transactionLogDTO) throws ServiceLayerException;
	
	/**
	 * Obtem a lista de linhas de logs de transações de um terminal.
	 * 
	 * @param terminalId - Identificador do terminal.
	 * 
	 * @return - Lista de linhas do log de transações.
	 */
	
	List<TransactionLogDTO> listTransactionLog(String terminalId) throws ServiceLayerException;
	
	/**
	 * Obtem a lista de linhas de logs de transações de um terminal.
	 * 
	 * @param terminalId - Identificador do terminal.
	 * @param status - Identificador do status da transação.
	 * 
	 * @return - Lista de linhas do log de transações.
	 */
	
	List<TransactionLogDTO> listTransactionLog(String terminalId, String status) throws ServiceLayerException;
	
	/**
	 * Obtem a lista de linhas de logs de transações de um terminal.
	 * 
	 * @param terminalId - Identificador do terminal.
	 * @param status - Identificador do status da transação.
	 * @param functionalityId - Identificador da funcionalidade.
	 * 
	 * @return - Lista de linhas do log de transações.
	 */
	
	List<TransactionLogDTO> listTransactionLog(String terminalId, String status, Long functionalityId) throws ServiceLayerException;
	
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
	
	List<TransactionLogDTO> searchTransactionLog(BigDecimal groupOwnerId, String nsuTerminal, String startDate, String endDate) throws ServiceLayerException;
	
	/**
	 * Obtem a lista de linhas de logs de transações de um proprietário de grupos.
	 * 
	 * @param groupOwnerId - Identificador do proprietário de grupos.
	 * 
	 * @return - Lista de linhas do log de transações.
	 */
	
	List<TransactionLogDTO> listTransactionLog(BigDecimal groupOwnerId) throws ServiceLayerException;
	
	/**
	 * Efetua a impressão dos logs de transação de um extrato.
	 * 
	 * @param request - Objeto com os dados do extrato a ser impresso.
	 * 
	 * @return - Resultado a operação.
	 */
	
	Integer printBankStatement(PrintBankStatementRequest request) throws ServiceLayerException;

}
