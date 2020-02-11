package br.com.volans.realsafe.service;

import java.math.BigDecimal;

import br.com.volans.realsafe.dto.LoginDTO;
import br.com.volans.realsafe.dto.UserDTO;
import br.com.volans.realsafe.exception.ServiceLayerException;

/**
 * Interface para implementação dos serviços de usuários.
 * 
 * @author Volans Informática Ltda
 */

public interface UserService {

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
	
	UserDTO findById(BigDecimal groupOwnerId, BigDecimal userId) throws ServiceLayerException;

	/**
	 * Pesquisa pelo usuário a partir do id informado.
	 * 
	 * @param userId - Indentificador do usuário.
	 * 
	 * @return - Dados do usuário pesquisado.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	UserDTO findById(BigDecimal userId) throws ServiceLayerException;
	
	/**
	 * Efetua o login do usuário.
	 * 
	 * @param loginDTO - Objeto com os dados para login.
	 * 
	 * @return - Dados do usuário logado.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócios.
	 */
	
	UserDTO login(LoginDTO loginDTO) throws ServiceLayerException;
	
	/**
	 * Atualiza a senha de login do usuário.
	 * 
	 * @param userDTO - Instância com os dados do usuário para atualização.
	 * 
	 * @return - Quantidade de linhas atualizadas.
	 */
	
	Integer updatePassword(UserDTO userDTO) throws ServiceLayerException;

}
