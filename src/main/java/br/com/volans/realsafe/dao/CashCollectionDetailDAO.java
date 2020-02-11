package br.com.volans.realsafe.dao;

import java.util.List;

import br.com.volans.realsafe.dto.TransactionLogDTO;

/**
 * Interface para implementação do DAO de detalhes do recolhimento de numerário.
 * 
 * @author Volans Informática Ltda.
 */

public interface CashCollectionDetailDAO {
	
	/**
	 * Efetua a inclusão dos detalhes de um recolhimento de numerário.
	 * 
	 * @param nsu - Novo NSU do terminal.
	 * @param terminalId - Identificador do terminal.
	 * @param status - Identificador do status da transação.
	 * @param functionalityId - Identificador da funcionalidade.
	 * 
	 * @return - Quantidade de linhas incluídas.
	 */
	
	Integer insert(String nsu, String terminalId, String status, Long functionalityId);
	
	/**
	 * Retorna a lista de detalhes de um recolhimento de numerário.
	 * 
	 * @param cashCollectionNsu - NSU do recolhimento de numerário.
	 * 
	 * @return - Lista de detalhes de um recolhimento de numerário.
	 */
	
	List<TransactionLogDTO> listCashCollectionDetails(String cashCollectionNsu);

}
