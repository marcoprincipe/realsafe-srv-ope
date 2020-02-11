package br.com.volans.realsafe.dto.payload;

import java.io.Serializable;

import br.com.volans.realsafe.dto.UserDTO;

/**
 * DTO para retorno do serviço de login de usuários.
 * 
 * @author Volans Informática Ltda
 */

public class LoginResponse implements Serializable {

	/**
	 * Declaração da serial version
	 */
	
	private static final long serialVersionUID = -8932239088594403183L;
	
	/**
	 * Declaração das variáveis membro
	 */

	private UserDTO user;

	/**
	 * Construtor default da classe
	 */
	
	public LoginResponse() {
		user = new UserDTO();
	}

	/**
	 * Construtor alternativo da classe
	 * 
	 * @param user - Dados do usuário a ser retornado
	 */
	
	public LoginResponse(UserDTO user) {
		this.user = user;
	}

	/**
	 * @return the user
	 */
	public UserDTO getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(UserDTO user) {
		this.user = user;
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();
		
		builder.append("LoginResponse [user=");
		builder.append(user);
		builder.append(']');
		
		return builder.toString();
		
	}
	
}
