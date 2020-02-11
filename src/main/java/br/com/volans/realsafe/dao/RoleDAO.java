package br.com.volans.realsafe.dao;

import java.util.List;

import br.com.volans.realsafe.dto.RoleDTO;

/**
 * Interface para implementação do DAO de perfis operacionais.
 * 
 * @author Volans Informática Ltda.
 */

public interface RoleDAO {
	
	/**
	 * Pesquisa pelo perfil de usuário a partir do identificador informado.
	 * 
	 * @param roleId - Identificador do perfil de usuário.
	 * 
	 * @return - Dados do perfil pesquisado
	 */
	
	RoleDTO findById(Long roleId);
	
	/**
	 * Inclui um novo perfil de usuário na tabela.
	 * 
	 * @param roleDTO - Dados do perfil a serem incluidos.
	 * 
	 * @return - Dados do perfil incluido
	 */
	
	RoleDTO create(RoleDTO roleDTO);
	
	/**
	 * Retorna lista de perfis operacionais da aplicação.
	 * 
	 * @return - Lista de perfis operacionais.
	 */
	
	List<RoleDTO> listAll();

}
