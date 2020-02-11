package br.com.volans.realsafe.dao;

import java.math.BigDecimal;
import java.util.List;

import br.com.volans.realsafe.dto.GroupDTO;

/**
 * Interface para implementação do DAO de grupos.
 * 
 * @author Volans Informática Ltda
 */

public interface GroupDAO {

	/**
	 * Pesquisa pelo grupo a partir do id informado.
	 * 
	 * @param groupId - Identificador do grupo.
	 * 
	 * @return - Dados do grupo pesquisado.
	 */
	
	GroupDTO findById(BigDecimal groupId);
	
	/**
	 * Retorna lista de grupos cadastrados.
	 * 
	 * @return - Lista de grupos cadastrados.
	 */
	
	List<GroupDTO> listAll();

	/**
	 * Inclui um novo grupo na base de dados.
	 * 
	 * @param groupDTO - Objeto com os dados a serem incluidos.
	 * 
	 * @return - Dados do grupo incluido.
	 */
	
	GroupDTO create(GroupDTO groupDTO);

}
