package br.com.volans.realsafe.dao;

import java.math.BigDecimal;
import java.util.List;

import br.com.volans.realsafe.dto.UserCompanyDTO;
import br.com.volans.realsafe.dto.UserGroupDTO;
import br.com.volans.realsafe.dto.UserUnitDTO;
import br.com.volans.realsafe.exception.ServiceLayerException;

/**
 * Interface para implementação do DAO de unidades de usuários.
 * 
 * @author Volans Informática Ltda.
 */

public interface UserUnitDAO {
	
	/**
	 * Retorna a lista de grupos de um usuário.
	 * 
	 * @param groupOwnerId - Identificador do proprietário do grupo.
	 * @param groupId - Identificador do grupo.
	 * @param companyId - Identificador da empresa.
	 * @param userId - Identificador do usuário.
	 * 
	 * @return Lista de grupos de um usuário.
	 */
	
	List<UserUnitDTO> listByUserId(BigDecimal groupOwnerId, BigDecimal groupId, BigDecimal companyId, BigDecimal userId);
	
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
	
	List<UserGroupDTO> listUserGroups(BigDecimal groupOwnerId, BigDecimal userId);
	
	/**
	 * Retorna a lista de empresas de um grupo de um usuário.
	 * 
	 * @param groupOwnerId - Identificador do proprietário do grupo.
	 * @param userId - Identificador do usuário.
	 * @param groupId - Identificador do grupo.
	 * 
	 * @return Lista de grupos de um usuário.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	List<UserCompanyDTO> listUserCompanies(BigDecimal groupOwnerId, BigDecimal userId, BigDecimal groupId);
	
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
	
	List<UserUnitDTO> listUserUnits(BigDecimal groupOwnerId, BigDecimal userId, BigDecimal groupId, BigDecimal companyId);

}
