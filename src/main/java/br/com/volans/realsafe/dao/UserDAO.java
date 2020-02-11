package br.com.volans.realsafe.dao;

import java.math.BigDecimal;

import br.com.volans.realsafe.dto.UserDTO;
import br.com.volans.realsafe.model.User;

/**
 * Interface para implementação do DAO de usuários.
 * 
 * @author Volans Informática Ltda
 */

public interface UserDAO {

	/**
	 * Pesquisa pelo usuário a partir do id informado.
	 * 
	 * @param groupOwerId - Identificador do proprietário dos grupos;
	 * @param userId - Indentificador do usuário.
	 * 
	 * @return - Dados do usuário pesquisado.
	 */
	
	UserDTO findById(BigDecimal groupOwerId, BigDecimal userId);
	
	/**
	 * Atualiza os dados de login do usuário.
	 * 
	 * @param user - Instância com os dados do usuário para atualização.
	 * 
	 * @return - Quantidade de linhas atualizadas.
	 */
	
	Integer updateLogin(User user);
	
	/**
	 * Atualiza a senha de login do usuário.
	 * 
	 * @param user - Instância com os dados do usuário para atualização.
	 * 
	 * @return - Quantidade de linhas atualizadas.
	 */
	
	Integer updatePassword(User user);

}
