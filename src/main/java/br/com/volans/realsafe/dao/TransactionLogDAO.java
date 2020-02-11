package br.com.volans.realsafe.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import br.com.volans.realsafe.dto.TransactionLogDTO;
import br.com.volans.realsafe.model.TransactionLog;

/**
 * Interface para implementação do DAO de log de transações.
 * 
 * @author Volans Informática Ltda
 */

public interface TransactionLogDAO {
	
	/**
	 * Efetua a inclusão de um log na tabela.
	 * 
	 * @param transactionLog - Instância da entidade de log de transações.
	 * 
	 * @return - Instância da entidade de log de transações.
	 */
	
	TransactionLog insert(TransactionLog transactionLog);
	
	/**
	 * Obtem a lista de linhas de logs de transações de um proprietário de grupos.
	 * 
	 * @param groupOwnerId - Identificador do proprietário de grupos.
	 * 
	 * @return - Lista de linhas do log de transações.
	 */
	
	List<TransactionLogDTO> listTransactionLog(BigDecimal groupOwnerId);
	
	/**
	 * Obtem a lista de linhas de logs de transações de um terminal.
	 * 
	 * @param terminalId - Identificador do terminal.
	 * @param status - Identificador do status da transação.
	 * @param functionalityId - Identificador da funcionalidade.
	 * 
	 * @return - Lista de linhas do log de transações.
	 */
	
	List<TransactionLogDTO> listTransactionLog(String terminalId, String status, Long functionalityId);
	
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
	
	List<TransactionLogDTO> searchTransactionLog(BigDecimal groupOwnerId, String nsuTerminal, Date startDate, Date endDate);

}
