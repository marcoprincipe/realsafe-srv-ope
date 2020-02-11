package br.com.volans.realsafe.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * DTO para armazenamento dos dados de um usuário.
 * 
 * @author Volans Informática Ltda
 */

public class UserDTO implements Serializable {

	/**
	 * Declaração da serial version.
	 */
	
	private static final long serialVersionUID = -4548174256287705978L;
	
	/**
	 * Declaração das variáveis membro.
	 */
	
	private BigDecimal groupOwnerId;
	private BigDecimal userId;
	private String name;
	private String email;
	private String password;
	private String isBlocked;
	private Integer loginRetries;
	private String status;
	private Date creationDate;
	
	/**
	 * Construtor default da classe.
	 */
	
	public UserDTO() {
		super();
	}
	
	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param groupOwnerId
	 * @param userId
	 * @param name
	 * @param email
	 * @param password
	 * @param isBlocked
	 * @param loginRetries
	 * @param status
	 * @param creationDate
	 */

	public UserDTO(BigDecimal groupOwnerId, BigDecimal userId, String name, String email, String password,
			String isBlocked, Integer loginRetries, String status, Date creationDate) {
		this.groupOwnerId = groupOwnerId;
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.isBlocked = isBlocked;
		this.loginRetries = loginRetries;
		this.status = status;
		this.creationDate = creationDate;
	}



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
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
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
	
	/**
	 * @return the isBlocked
	 */
	public String getIsBlocked() {
		return isBlocked;
	}
	
	/**
	 * @param isBlocked the isBlocked to set
	 */
	public void setIsBlocked(String isBlocked) {
		this.isBlocked = isBlocked;
	}
	
	/**
	 * @return the loginRetries
	 */
	public Integer getLoginRetries() {
		return loginRetries;
	}
	
	/**
	 * @param loginRetries the loginRetries to set
	 */
	public void setLoginRetries(Integer loginRetries) {
		this.loginRetries = loginRetries;
	}
	
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();
		
		builder.append("UserDTO [groupOwnerId=");
		builder.append(groupOwnerId);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", name=");
		builder.append(name);
		builder.append(", email=");
		builder.append(email);
		builder.append(", password=");
		builder.append(password);
		builder.append(", isBlocked=");
		builder.append(isBlocked);
		builder.append(", loginRetries=");
		builder.append(loginRetries);
		builder.append(", status=");
		builder.append(status);
		builder.append(", creationDate=");
		builder.append(creationDate);
		builder.append("]");
		
		return builder.toString();
		
	}
	
}
