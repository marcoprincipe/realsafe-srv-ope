package br.com.volans.realsafe.service;

import java.util.List;

import br.com.volans.realsafe.dto.FunctionalityRoleDTO;
import br.com.volans.realsafe.exception.ServiceLayerException;

/**
 * Interface para implementação dos serviços de funcionalidades de perfis.
 * 
 * @author Volans Informática Ltda
 */

public interface FunctionalityRoleService {

	/**
	 * Pesquisa pelas funcionalidades a partir do id do perfil informado.
	 * 
	 * @param roleId - Identificador do perfil.
	 * @param parentId - Identificador da funcionalidade pai.
	 * 
	 * @return - Lista de funcionalidades do perfil.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	List<FunctionalityRoleDTO> listFunctionalitiesByRoleId(Integer roleId, Integer parentId) throws ServiceLayerException;

}
