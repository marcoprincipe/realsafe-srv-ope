package br.com.volans.realsafe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.volans.realsafe.dao.FunctionalityRoleDAO;
import br.com.volans.realsafe.dto.FunctionalityRoleDTO;
import br.com.volans.realsafe.enums.MessageKeys;
import br.com.volans.realsafe.exception.ServiceLayerException;
import br.com.volans.realsafe.service.AbstractService;
import br.com.volans.realsafe.service.FunctionalityRoleService;

/**
 * Implementação da interface dos serviços de funcionalidades de perfis.
 * 
 * @author Volans Informática Ltda
 */

@Service
public class FunctionalityRoleServiceImpl extends AbstractService implements FunctionalityRoleService {
	
	/**
	 * Declaração das variáveis membro
	 */

	private FunctionalityRoleDAO functionalityRoleDAO;

	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param functionalityRoleDAO - Instância do DAO de funcionalidades de perfis.
	 */
	
	@Autowired
	public FunctionalityRoleServiceImpl(FunctionalityRoleDAO functionalityRoleDAO) {
		this.functionalityRoleDAO = functionalityRoleDAO;
	}

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
	
	@Override
	public List<FunctionalityRoleDTO> listFunctionalitiesByRoleId(Integer roleId, Integer parentId)  throws ServiceLayerException {
		
		if (roleId == null) {
			throw new ServiceLayerException(getMessage(MessageKeys.ROLE_NOT_INFORMED.getKey()));
		}

		if (roleId <= 0) {
			throw new ServiceLayerException(getMessage(MessageKeys.INVALID_ROLE_CODE.getKey()));
		}

		List<FunctionalityRoleDTO> result = functionalityRoleDAO.listFunctionalitiesByRoleId(roleId, parentId);
		
		return result;
		
	}

}
