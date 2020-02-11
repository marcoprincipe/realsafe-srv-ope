package br.com.volans.realsafe.service.impl;

import java.math.BigDecimal;

import javax.transaction.Transactional;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.volans.realsafe.dao.GroupOwnerDAO;
import br.com.volans.realsafe.dao.ParameterDAO;
import br.com.volans.realsafe.dao.UserDAO;
import br.com.volans.realsafe.dto.GroupOwnerDTO;
import br.com.volans.realsafe.dto.LoginDTO;
import br.com.volans.realsafe.dto.ParameterDTO;
import br.com.volans.realsafe.dto.UserDTO;
import br.com.volans.realsafe.enums.MessageKeys;
import br.com.volans.realsafe.enums.Parameters;
import br.com.volans.realsafe.exception.ServiceLayerException;
import br.com.volans.realsafe.exception.SystemException;
import br.com.volans.realsafe.model.User;
import br.com.volans.realsafe.service.AbstractService;
import br.com.volans.realsafe.service.CipherService;
import br.com.volans.realsafe.service.UserService;

/**
 * Implementação da interface dos serviços de usuários.
 * 
 * @author Volans Informática Ltda
 */

@Service
public class UserServiceImpl extends AbstractService implements UserService {
	
	/**
	 * Declaração das constantes da classe
	 */
	
	private static final String USER_INACTIVE = "I";

	private static final String USER_BLOCKED = "Y";
	private static final String USER_NOT_BLOCKED = "N";
	
	/**
	 * Declaração das variáveis membro
	 */

	private GroupOwnerDAO groupOwnerDAO;
	private UserDAO userDAO;
	private ParameterDAO parameterDAO;
	private CipherService cipherService;

	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param groupOwnerDAO - Instância do DAO de proprietário de grupos.
	 * @param userDAO - Instância do DAO de usuários.
	 * @param parameterDAO - Instância do DAO de parâmetros.
	 * @param cipherService - Instância do serviço de criptografia.
	 */
	
	@Autowired
	public UserServiceImpl(GroupOwnerDAO groupOwnerDAO, UserDAO userDAO, ParameterDAO parameterDAO, CipherService cipherService) {
		this.groupOwnerDAO = groupOwnerDAO;
		this.userDAO = userDAO;
		this.parameterDAO = parameterDAO;
		this.cipherService = cipherService;
	}

	/**
	 * Efetua o login do usuário.
	 * 
	 * @param loginDTO - Objeto com os dados para login.
	 * 
	 * @return - Dados do usuário logado.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócios.
	 */
	
	@Override
	@Transactional(dontRollbackOn = ServiceLayerException.class)
	public UserDTO login(LoginDTO loginDTO) throws ServiceLayerException {
		
		UserDTO userDTO = null;
		
		if (loginDTO.getGroupOwnerId() == null) {
			userDTO = findById(loginDTO.getUserId());
		}
		else {
			userDTO = findById(loginDTO.getGroupOwnerId(), loginDTO.getUserId());
		}

		if (userDTO == null) {
			throw new ServiceLayerException(getMessage(MessageKeys.USER_NOT_FOUND.getKey()));
		}
		
		if (USER_INACTIVE.equals(userDTO.getStatus())) {
			throw new ServiceLayerException(getMessage(MessageKeys.USER_INACTIVE.getKey()));
		}
		
		if (USER_BLOCKED.equals(userDTO.getIsBlocked())) {
			throw new ServiceLayerException(getMessage(MessageKeys.USER_BLOCKED.getKey()));
		}
		
		String hash = cipherService.sha256(loginDTO.getPassword());
		
		User user = new User();
		
		BeanUtils.copyProperties(userDTO, user);
		
		user.getPk().setGroupOwnerId(userDTO.getGroupOwnerId());
		user.getPk().setUserId(userDTO.getUserId());
		
		if (!userDTO.getPassword().equals(hash)) {
			checkLoginRetries(user);
		}
		
		userDTO.setLoginRetries(0);
		userDTO.setIsBlocked(USER_NOT_BLOCKED);
		
		userDAO.updateLogin(user);
		
		userDTO.setPassword("********");
		
		return userDTO;
		
	}
	
	/**
	 * Atualiza a senha de login do usuário.
	 * 
	 * @param userDTO - Instância com os dados do usuário para atualização.
	 * 
	 * @return - Quantidade de linhas atualizadas.
	 */
	
	@Override
	@Transactional
	public Integer updatePassword(UserDTO userDTO) throws ServiceLayerException {
		
		UserDTO userDBDTO = null;

		if (userDTO.getPassword() == null || userDTO.getPassword().trim().isEmpty()) {
			throw new ServiceLayerException(getMessage(MessageKeys.PASSWORD_NOT_INFORMED.getKey()));
		}
		
		if (!checkPassword(userDTO.getPassword())) {
			throw new ServiceLayerException(getMessage(MessageKeys.INVALID_PASSWORD_FORMAT.getKey()));
		}
		
		if (userDTO.getGroupOwnerId() == null) {
			userDBDTO = findById(userDTO.getUserId());
		}
		else {
			userDBDTO = findById(userDTO.getGroupOwnerId(), userDTO.getUserId());
		}
		
		if (userDBDTO == null) {
			throw new ServiceLayerException(getMessage(MessageKeys.USER_NOT_FOUND.getKey()));
		}
		
		String hash = cipherService.sha256(userDTO.getPassword());
		
		User user = new User();
		
		BeanUtils.copyProperties(userDBDTO, user);
		
		user.getPk().setGroupOwnerId(userDTO.getGroupOwnerId());
		user.getPk().setUserId(userDTO.getUserId());
		user.setPassword(hash);
		
		Integer rowsAffected = userDAO.updatePassword(user);

		return rowsAffected;
		
	}

	/**
	 * Pesquisa pelo usuário a partir do id informado.
	 * 
	 * @param userId - Indentificador do usuário.
	 * 
	 * @return - Dados do usuário pesquisado.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	@Override
	public UserDTO findById(BigDecimal userId) throws ServiceLayerException {
		
		GroupOwnerDTO groupOwnerDTO = groupOwnerDAO.findSingleLocal();
		
		if (groupOwnerDTO == null) {
			throw new ServiceLayerException(getMessage(MessageKeys.NO_GROUP_OWNER_FOUND.getKey()));
		}
		
		return userDAO.findById(groupOwnerDTO.getGroupOwnerId(), userId);
		
	}

	/**
	 * Pesquisa pelo usuário a partir do id informado.
	 * 
	 * @param groupOwnerId - Identificador do proprietário dos grupos.
	 * @param userId - Indentificador do usuário.
	 * 
	 * @return - Dados do usuário pesquisado.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	@Override
	public UserDTO findById(BigDecimal groupOwnerId, BigDecimal userId) throws ServiceLayerException {
		
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
		
		UserDTO userDTO = userDAO.findById(groupOwnerId, userId);
		
		return userDTO;
		
	}

	/**
	 * Efetua a validação da senha informada.
	 * 
	 * @param password- Senha a ser validada.
	 * 
	 * @return - Indicativo de senha válida.
	 */
	
	private Boolean checkPassword(String password) {
		
		String pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
		
		if (!password.matches(pattern)) {
			return false;
		}
		
		return true;
		
	}
	
	/**
	 * Verifica a quantidade de tentativas de login.
	 * 
	 * @param loginDTO - Objeto com os dados para login.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócios.
	 */
	
	private void checkLoginRetries(User user) throws ServiceException, SystemException {

		ParameterDTO parameterDTO = 
				parameterDAO.findById(user.getPk().getGroupOwnerId(), Parameters.MAX_LOGIN_RETRIES.getParameterId());
		
		if (parameterDTO == null) {
			throw new ServiceLayerException(getMessage(MessageKeys.INVALID_USERNAME_OR_PASSWORD.getKey()));
		}
			
		Integer maxLoginRetries = Integer.parseInt(parameterDTO.getValue());

		if (maxLoginRetries == 0) {
			throw new ServiceLayerException(getMessage(MessageKeys.INVALID_USERNAME_OR_PASSWORD.getKey()));
		}
		
		Integer userLoginRetries = user.getLoginRetries() + 1;
		
		user.setLoginRetries(userLoginRetries);
		
		if (userLoginRetries == maxLoginRetries) {
			user.setIsBlocked(USER_BLOCKED);
		}
		
		userDAO.updateLogin(user);
		
		if (USER_BLOCKED.equals(user.getIsBlocked())) {
			throw new ServiceLayerException(getMessage(MessageKeys.USER_BLOCKED.getKey()));
		}
		else {
			throw new ServiceLayerException(String.format(getMessage(MessageKeys.INVALID_RETRY_USERNAME_OR_PASSWORD.getKey()), userLoginRetries, maxLoginRetries));
		}
		
	}

}
