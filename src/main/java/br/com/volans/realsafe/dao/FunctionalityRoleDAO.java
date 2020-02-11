package br.com.volans.realsafe.dao;

import java.util.List;

import br.com.volans.realsafe.dto.FunctionalityRoleDTO;

/**
 * Interface para implementação do DAO de funcionalidades de perfis.
 * 
 * @author Volans Informática Ltda.
 */

public interface FunctionalityRoleDAO {
	
	/**
	 * Pesquisa pelas funcionalidades / perfis a partir da chave primária informada.
	 * 
	 * @param roleId - Identificador do perfil.
	 * @param functionalityId - Identificador da funcionalidade.
	 * 
	 * @return - Lista de funcionalidades do perfil.
	 */
	
	FunctionalityRoleDTO findById(Long roleId, Long functionalityId);
	
	/**
	 * Efetua a inclusão da funcionalidade / perfil na tabela.
	 * 
	 * @param functionalityRoleDTO - Dados a serem incluídos.
	 * 
	 * @return - Dados da funcionalidade / perfil incluido.
	 */
	
	FunctionalityRoleDTO create(FunctionalityRoleDTO functionalityRoleDTO);
	
	/**
	 * Pesquisa pelas funcionalidades a partir do id do perfil informado.
	 * 
	 * @param roleId - Identificador do perfil.
	 * @param parentId - Identificador da funcionalidade pai.
	 * 
	 * @return - Lista de funcionalidades do perfil.
	 */
	
	List<FunctionalityRoleDTO> listFunctionalitiesByRoleId(Integer roleId, Integer parentId);

}
