package br.com.volans.realsafe.dao;

import java.math.BigDecimal;
import java.util.List;

import br.com.volans.realsafe.dto.GroupOwnerDTO;

/**
 * Interface para implementação do DAO de proprietário de grupos.
 * 
 * @author Volans Informática Ltda
 */

public interface GroupOwnerDAO {

	/**
	 * Pesquisa pelo único proprietário de grupos da tabela.
	 * 
	 * @return - Dados do grupo pesquisado.
	 */
	
	GroupOwnerDTO findSingleLocal();

	/**
	 * Retorna lista de proprietarios de grupos cadastrados.
	 * 
	 * @return - Lista de proprietarios de grupos cadastrados.
	 */

	List<GroupOwnerDTO> listAll();

	/**
	 * Pesquisa pelo proprietario de grupo a partir do id informado.
	 * 
	 * @param groupOwnerId - Identificador do proprietario
	 * 
	 * @return - Dados do proprietario pesquisado.
	 */
	
	GroupOwnerDTO findById(BigDecimal groupOwnerId);

	/**
	 * Inclui um novo proprietário da base de dados.
	 * 
	 * @param groupOwnerDTO - Objeto com os dados a serem incluidos.
	 * 
	 * @return - Dados do proprietario incluido.
	 */
	
	GroupOwnerDTO create(GroupOwnerDTO groupOwnerDTO);
	
}
