package br.com.volans.realsafe.dao;

import br.com.volans.realsafe.dto.OpeningDetailDTO;
import br.com.volans.realsafe.model.OpeningDetail;

/**
 * Interface para implementação do DAO de detalhes de abertura.
 * 
 * @author Volans Informática Ltda
 */

public interface OpeningDetailDAO {
	
	/**
	 * Efetua a inclusão de um detalhe de abertura.
	 * 
	 * @param openingDetail - Instância da entidade de detalhes de abertura.
	 * 
	 * @return - Instância da entidade de detalhes de abertura.
	 */
	
	OpeningDetail insert(OpeningDetail openingDetail);
	
	/**
	 * Efetua a pesquisa de um detalhe de abertura.
	 * 
	 * @param nsuTerminal - NSU da transação.
	 * 
	 * @return - DTO com os detalhes da abertura.
	 */
	
	OpeningDetailDTO getOpeningDetail(String nsuTerminal);

}
