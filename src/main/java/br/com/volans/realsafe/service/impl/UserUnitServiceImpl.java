package br.com.volans.realsafe.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.volans.realsafe.dao.GroupOwnerDAO;
import br.com.volans.realsafe.dao.UserUnitDAO;
import br.com.volans.realsafe.dto.GroupOwnerDTO;
import br.com.volans.realsafe.dto.UserCompanyDTO;
import br.com.volans.realsafe.dto.UserGroupDTO;
import br.com.volans.realsafe.dto.UserUnitDTO;
import br.com.volans.realsafe.enums.MessageKeys;
import br.com.volans.realsafe.exception.ServiceLayerException;
import br.com.volans.realsafe.service.AbstractService;
import br.com.volans.realsafe.service.UserUnitService;

/**
 * Implementação da interface dos serviços de unidades de usuários.
 * 
 * @author Volans Informática Ltda.
 */

@Service
public class UserUnitServiceImpl extends AbstractService implements UserUnitService {
	
	/**
	 * Declaração das variáveis membro
	 */

	private GroupOwnerDAO groupOwnerDAO;
	private UserUnitDAO userUnitDAO;

	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param groupOwnerDAO - Instância do DAO de proprietário de grupos.
	 * @param userUnitDAO - Instância do DAO de unidades de usuários.
	 */
	
	@Autowired
	public UserUnitServiceImpl(GroupOwnerDAO groupOwnerDAO, UserUnitDAO userUnitDAO) {
		this.groupOwnerDAO = groupOwnerDAO;
		this.userUnitDAO = userUnitDAO;
	}
	
	/**
	 * Retorna a lista de unidades de um usuário.
	 * 
	 * @param groupId - Identificador do grupo.
	 * @param companyId - Identificador da empresa.
	 * @param userId - Identificador do usuário.
	 * 
	 * @return Lista de unidades de um usuário.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	@Override
	public List<UserUnitDTO> listByUserId(BigDecimal groupId, BigDecimal companyId, BigDecimal userId) throws ServiceLayerException {
		
		GroupOwnerDTO groupOwnerDTO = groupOwnerDAO.findSingleLocal();
		
		if (groupOwnerDTO == null) {
			throw new ServiceLayerException(getMessage(MessageKeys.NO_GROUP_OWNER_FOUND.getKey()));
		}
		
		return listByUserId(groupOwnerDTO.getGroupOwnerId(), groupId, companyId, userId);
		
	}
	
	/**
	 * Retorna a lista de unidades de um usuário.
	 * 
	 * @param groupOwnerId - Identificador do proprietário do grupo.
	 * @param groupId - Identificador do grupo.
	 * @param companyId - Identificador da empresa.
	 * @param userId - Identificador do usuário.
	 * 
	 * @return Lista de unidades de um usuário.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	@Override
	public List<UserUnitDTO> listByUserId(BigDecimal groupOwnerId, BigDecimal groupId, BigDecimal companyId, BigDecimal userId) throws ServiceLayerException {
		
		if (groupOwnerId == null) {
			throw new ServiceLayerException(getMessage(MessageKeys.GROUP_OWNER_CODE_NOT_INFORMED.getKey()));
		}

		if (groupOwnerId.longValue() <= 0) {
			throw new ServiceLayerException(getMessage(MessageKeys.INVALID_GROUP_OWNER_CODE.getKey()));
		}
		
		if (groupId == null) {
			throw new ServiceLayerException(getMessage(MessageKeys.GROUP_CODE_NOT_INFORMED.getKey()));
		}

		if (groupId.longValue() <= 0) {
			throw new ServiceLayerException(getMessage(MessageKeys.INVALID_GROUP_CODE.getKey()));
		}
		
		if (companyId == null) {
			throw new ServiceLayerException(getMessage(MessageKeys.COMPANY_CODE_NOT_INFORMED.getKey()));
		}

		if (companyId.longValue() <= 0) {
			throw new ServiceLayerException(getMessage(MessageKeys.INVALID_COMPANY_CODE.getKey()));
		}
		
		if (userId == null) {
			throw new ServiceLayerException(getMessage(MessageKeys.USER_CODE_NOT_INFORMED.getKey()));
		}

		if (userId.longValue() <= 0) {
			throw new ServiceLayerException(getMessage(MessageKeys.INVALID_USER_CODE.getKey()));
		}
		
		List<UserUnitDTO> result = userUnitDAO.listByUserId(groupOwnerId, groupId, companyId, userId);
		
		return result;
		
	}
	
	/**
	 * Retorna a lista de grupos de um usuário.
	 * 
	 * @param groupOwnerId - Identificador do proprietário do grupo.
	 * @param userId - Identificador do usuário.
	 * 
	 * @return Lista de grupos de um usuário.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	@Override
	public List<UserGroupDTO> listUserGroups(BigDecimal groupOwnerId, BigDecimal userId) throws ServiceLayerException {
		
		if (groupOwnerId == null) {
			throw new ServiceLayerException(getMessage(MessageKeys.GROUP_OWNER_CODE_NOT_INFORMED.getKey()));
		}

		if (groupOwnerId.longValue() <= 0) {
			throw new ServiceLayerException(getMessage(MessageKeys.INVALID_GROUP_OWNER_CODE.getKey()));
		}
		
		if (userId == null) {
			throw new ServiceLayerException(getMessage(MessageKeys.USER_CODE_NOT_INFORMED.getKey()));
		}

		if (userId.longValue() <= 0) {
			throw new ServiceLayerException(getMessage(MessageKeys.INVALID_USER_CODE.getKey()));
		}
		
		List<UserGroupDTO> result = userUnitDAO.listUserGroups(groupOwnerId, userId);
		
		return result;
		
	}
	
	/**
	 * Retorna a lista de empresas de um usuário.
	 * 
	 * @param groupOwnerId - Identificador do proprietário do grupo.
	 * @param userId - Identificador do usuário.
	 * @param groupId - Identificador do grupo.
	 * 
	 * @return Lista de grupos de um usuário.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	@Override
	public List<UserCompanyDTO> listUserCompanies(BigDecimal groupOwnerId, BigDecimal userId, BigDecimal groupId) throws ServiceLayerException {
		
		if (groupOwnerId == null) {
			throw new ServiceLayerException(getMessage(MessageKeys.GROUP_OWNER_CODE_NOT_INFORMED.getKey()));
		}

		if (groupOwnerId.longValue() <= 0) {
			throw new ServiceLayerException(getMessage(MessageKeys.INVALID_GROUP_OWNER_CODE.getKey()));
		}
		
		if (userId == null) {
			throw new ServiceLayerException(getMessage(MessageKeys.USER_CODE_NOT_INFORMED.getKey()));
		}

		if (userId.longValue() <= 0) {
			throw new ServiceLayerException(getMessage(MessageKeys.INVALID_USER_CODE.getKey()));
		}
		
		if (groupId == null) {
			throw new ServiceLayerException(getMessage(MessageKeys.GROUP_CODE_NOT_INFORMED.getKey()));
		}

		if (groupId.longValue() <= 0) {
			throw new ServiceLayerException(getMessage(MessageKeys.INVALID_GROUP_CODE.getKey()));
		}
		
		List<UserCompanyDTO> result = userUnitDAO.listUserCompanies(groupOwnerId, userId, groupId);
		
		return result;
		
	}
	
	/**
	 * Retorna a lista de unidades de uma empresa de um usuário.
	 * 
	 * @param groupOwnerId - Identificador do proprietário do grupo.
	 * @param userId - Identificador do usuário.
	 * @param groupId - Identificador do grupo.
	 * @param companyId - Identificador da empresa.
	 * 
	 * @return Lista de grupos de um usuário.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	@Override
	public List<UserUnitDTO> listUserUnits(BigDecimal groupOwnerId, BigDecimal userId, BigDecimal groupId, BigDecimal companyId) throws ServiceLayerException {
		
		if (groupOwnerId == null) {
			throw new ServiceLayerException(getMessage(MessageKeys.GROUP_OWNER_CODE_NOT_INFORMED.getKey()));
		}

		if (groupOwnerId.longValue() <= 0) {
			throw new ServiceLayerException(getMessage(MessageKeys.INVALID_GROUP_OWNER_CODE.getKey()));
		}
		
		if (userId == null) {
			throw new ServiceLayerException(getMessage(MessageKeys.USER_CODE_NOT_INFORMED.getKey()));
		}

		if (userId.longValue() <= 0) {
			throw new ServiceLayerException(getMessage(MessageKeys.INVALID_USER_CODE.getKey()));
		}
		
		if (groupId == null) {
			throw new ServiceLayerException(getMessage(MessageKeys.GROUP_CODE_NOT_INFORMED.getKey()));
		}

		if (groupId.longValue() <= 0) {
			throw new ServiceLayerException(getMessage(MessageKeys.INVALID_GROUP_CODE.getKey()));
		}
		
		if (companyId == null) {
			throw new ServiceLayerException(getMessage(MessageKeys.COMPANY_CODE_NOT_INFORMED.getKey()));
		}

		if (companyId.longValue() <= 0) {
			throw new ServiceLayerException(getMessage(MessageKeys.INVALID_COMPANY_CODE.getKey()));
		}
		
		List<UserUnitDTO> result = userUnitDAO.listUserUnits(groupOwnerId, userId, groupId, companyId);
		
		return result;
		
	}

}
