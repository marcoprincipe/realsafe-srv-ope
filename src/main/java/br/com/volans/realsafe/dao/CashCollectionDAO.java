package br.com.volans.realsafe.dao;

import java.util.List;

import br.com.volans.realsafe.dto.DepositDetailDTO;
import br.com.volans.realsafe.dto.TransactionLogDTO;

/**
 * Interface para implementação do DAO de recolhimento de numerário.
 * 
 * @author Volans Informática Ltda.
 */

public interface CashCollectionDAO {
	
	/**
	 * Efetiva a coleta do recolhimento de numerário.
	 * 
	 * @param terminalId - Identificador do terminal.
	 * 
	 * @return - Quantidade de linhas atualizadas.
	 */
	
	Integer collectCash(String terminalId);
	
	/**
	 * Efetua a pesquisa do recolhimento de numerário.
	 * 
	 * @param terminalId - Identificador do terminal.
	 * 
	 * @return - DTO com os detalhes do recolhimento do numerário.
	 */
	
	List<DepositDetailDTO> listCashCollection(String terminalId);
	
	/**
	 * Efetua a pesquisa dos logs para o recolhimento de numerário.
	 * 
	 * @param terminalId - Identificador do terminal.
	 * 
	 * @return - DTO com os logs para o recolhimento de numerário.
	 */
	
	List<TransactionLogDTO> listCashCollectionLogs(String terminalId);

}
