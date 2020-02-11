package br.com.volans.realsafe.dao;

import java.util.List;

import br.com.volans.realsafe.dto.DepositDetailDTO;
import br.com.volans.realsafe.model.DepositDetail;

/**
 * Interface para implementação do DAO de detalhes de depósitos.
 * 
 * @author Volans Informática Ltda
 */

public interface DepositDetailDAO {
	
	/**
	 * Efetua a inclusão de um detalhe de depósito.
	 * 
	 * @param depositDetail - Instância da entidade de detalhes de depósito.
	 * 
	 * @return - Instância da entidade de detalhes de depósito.
	 */
	
	DepositDetail insert(DepositDetail depositDetail);
	
	/**
	 * Efetua a pesquisa de um detalhe de depósito.
	 * 
	 * @param nsuTerminal - NSU da transação.
	 * 
	 * @return - Lista dos DTOs de detalhes de depósito.
	 */
	
	List<DepositDetailDTO> listDepositDetails(String nsuTerminal);

}
