package br.com.volans.realsafe.dao;

import java.math.BigDecimal;

import br.com.volans.realsafe.dto.ParameterDTO;

/**
 * Interface para implementação do DAO de parâmetros.
 * 
 * @author Volans Informática Ltda.
 */

public interface ParameterDAO {

	/**
	 * Pesquisa pelo parâmetro a partir do id informado.
	 * 
	 * @param groupOwnerId - Identificador do proprietário de grupos.
	 * @param parameterId - Identificador do parâmetro.
	 * 
	 * @return - Dados do parâmetro pesquisado.
	 */
	
	ParameterDTO findById(BigDecimal groupOwnerId, String parameterId);

}
