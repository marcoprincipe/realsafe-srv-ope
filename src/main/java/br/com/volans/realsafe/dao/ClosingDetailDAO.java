package br.com.volans.realsafe.dao;

import br.com.volans.realsafe.dto.ClosingDetailDTO;
import br.com.volans.realsafe.model.ClosingDetail;

/**
 * Interface para implementação do DAO de detalhes de fechamento.
 * 
 * @author Volans Informática Ltda
 */

public interface ClosingDetailDAO {
	
	/**
	 * Efetua a inclusão de um detalhe de fechamento.
	 * 
	 * @param closingDetail - Instância da entidade de detalhes de fechamento.
	 * 
	 * @return - Instância da entidade de detalhes de fechamamento.
	 */
	
	ClosingDetail insert(ClosingDetail closingDetail);
	
	/**
	 * Efetua a pesquisa de um detalhe de fechamento.
	 * 
	 * @param nsuTerminal - NSU da transação.
	 * 
	 * @return - DTO com os detalhes do fechamento.
	 */
	
	ClosingDetailDTO getClosingDetail(String nsuTerminal);

}
