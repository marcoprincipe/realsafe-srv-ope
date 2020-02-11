package br.com.volans.realsafe.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * DTO para armazenamento dos dados de uma linha de um extrato.
 * 
 * @author Volans Informática Ltda.
 */

public class BankStatementLineDTO implements Serializable {

	/**
	 * Declaração da serial version.
	 */

	private static final long serialVersionUID = -5460541658083964089L;
	
	/**
	 * Declaração das variáveis membro.
	 */
	
	private Long companyId;
	private String companyName;
	private Long unitId;
	private String unitName;
	private Long userId;
	private String userName;
	private String userEmail;
	private Long transactionId;
	private String transactionName;
	private Date transactionDate;
	private BigDecimal amount;

	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param companyId - Identificador da empresa.
	 * @param companyName - Nome da empresa.
	 * @param unitId - Identificador da unidade.
	 * @param unitName - Nome da unidade.
	 * @param userId - Identificador do usuário.
	 * @param userName - Nome do usuário.
	 * @param userEmail - Email do usuário.
	 * @param transactionId - Identificador da transação.
	 * @param transactionName - Nome da transação.
	 * @param transactionDate - Data da transação.
	 * @param amount - Valor da transação.
	 */
	
	public BankStatementLineDTO(Long companyId, String companyName, Long unitId, String unitName, Long userId,
		String userName, String userEmail, Long transactionId, String transactionName, Date transactionDate, 
		BigDecimal amount) {
		this.companyId = companyId;
		this.companyName = companyName;
		this.unitId = unitId;
		this.unitName = unitName;
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.transactionId = transactionId;
		this.transactionName = transactionName;
		this.transactionDate = transactionDate;
		this.amount = amount;
	}

	/**
	 * @return the companyId
	 */
	public Long getCompanyId() {
		return companyId;
	}
	
	/**
	 * @param companyId the companyId to set
	 */
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	
	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}
	
	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	/**
	 * @return the unitId
	 */
	public Long getUnitId() {
		return unitId;
	}
	
	/**
	 * @param unitId the unitId to set
	 */
	public void setUnitId(Long unitId) {
		this.unitId = unitId;
	}
	
	/**
	 * @return the unitName
	 */
	public String getUnitName() {
		return unitName;
	}
	
	/**
	 * @param unitName the unitName to set
	 */
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	
	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}
	
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	/**
	 * @return the userEmail
	 */
	public String getUserEmail() {
		return userEmail;
	}
	
	/**
	 * @param userEmail the userEmail to set
	 */
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	/**
	 * @return the transactionId
	 */
	public Long getTransactionId() {
		return transactionId;
	}
	
	/**
	 * @param transactionId the transactionId to set
	 */
	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}
	
	/**
	 * @return the transactionName
	 */
	public String getTransactionName() {
		return transactionName;
	}
	
	/**
	 * @param transactionName the transactionName to set
	 */
	public void setTransactionName(String transactionName) {
		this.transactionName = transactionName;
	}
	
	/**
	 * @return the transactionDate
	 */
	public Date getTransactionDate() {
		return transactionDate;
	}
	
	/**
	 * @param transactionDate the transactionDate to set
	 */
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	
	/**
	 * @return the amount
	 */
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		
		builder.append("BankStatementLineDTO [companyId=");
		builder.append(companyId);
		builder.append(", companyName=");
		builder.append(companyName);
		builder.append(", unitId=");
		builder.append(unitId);
		builder.append(", unitName=");
		builder.append(unitName);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", userName=");
		builder.append(userName);
		builder.append(", userEmail=");
		builder.append(userEmail);
		builder.append(", transactionId=");
		builder.append(transactionId);
		builder.append(", transactionName=");
		builder.append(transactionName);
		builder.append(", transactionDate=");
		builder.append(transactionDate);
		builder.append(", amount=");
		builder.append(amount);
		builder.append(']');
	
		return builder.toString();

	}
	
}
