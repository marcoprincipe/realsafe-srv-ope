package br.com.volans.realsafe.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DTO para chamada do serviço de login de usuários.
 * 
 * @author Volans Informática Ltda
 */

public class LoginDTO implements Serializable {

	/**
	 * Declaração da serial version
	 */
	
	private static final long serialVersionUID = -6425150080572954190L;
	
	/**
	 * Declaração das variáveis membro
	 */

	private BigDecimal groupOwnerId;
	private BigDecimal userId;
	private String password;
	
	/**
	 * @return the groupOwnerId
	 */
	public BigDecimal getGroupOwnerId() {
		return groupOwnerId;
	}
	
	/**
	 * @param groupOwnerId the groupOwnerId to set
	 */
	public void setGroupOwnerId(BigDecimal groupOwnerId) {
		this.groupOwnerId = groupOwnerId;
	}
	
	/**
	 * @return the userId
	 */
	public BigDecimal getUserId() {
		return userId;
	}
	
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(BigDecimal userId) {
		this.userId = userId;
	}
	
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();
		
		builder.append("LoginDTO [groupOwnerId=");
		builder.append(groupOwnerId);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", password=");
		builder.append(password);
		builder.append("]");
		
		return builder.toString();
		
	}
	
}
