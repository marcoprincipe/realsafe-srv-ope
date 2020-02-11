package br.com.volans.realsafe.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * DTO para armazenamento dos dados de um log de transação.
 * 
 * @author Volans Informática Ltda.
 */

public class TransactionLogDTO implements Serializable {

	/**
	 * Declaração da serial version.
	 */
	
	private static final long serialVersionUID = 3036394831311611801L;
	
	/**
	 * Declaração das variáveis membro.
	 */
	
	private BigDecimal groupOwnerId;
	private String terminalId;
	private String nsuTerminal;
	private BigDecimal companyId;
	private String companyName;
	private BigDecimal unitId;
	private String unitName;
	private BigDecimal userId;
	private String userName;
	private Long functionalityId;
	private String functionalityName;
	private Date accountingDate;
	private Date dateTime;
	private Integer bankNotes;
	private BigDecimal amount;
	private String status;
	
	/**
	 * Construtor default da classe.
	 */
	
	public TransactionLogDTO() {
		super();
	}

	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param groupOwnerId
	 * @param terminalId
	 * @param nsuTerminal
	 * @param companyId
	 * @param companyName
	 * @param unitId
	 * @param unitName
	 * @param userId
	 * @param userName
	 * @param functionalityId
	 * @param functionalityName
	 * @param accountingDate
	 * @param dateTime
	 * @param bankNotes
	 * @param amount
	 * @param status
	 */
	
	public TransactionLogDTO(BigDecimal groupOwnerId, String terminalId, String nsuTerminal, 
			BigDecimal companyId, String companyName, BigDecimal unitId, String unitName, BigDecimal userId, 
			String userName, Long functionalityId, String functionalityName, Date accountingDate, Date dateTime, 
			Integer bankNotes, BigDecimal amount, String status) {
		this.groupOwnerId = groupOwnerId;
		this.terminalId = terminalId;
		this.nsuTerminal = nsuTerminal;
		this.companyId = companyId;
		this.companyName = companyName;
		this.unitId = unitId;
		this.unitName = unitName;
		this.userId = userId;
		this.userName = userName;
		this.functionalityId = functionalityId;
		this.functionalityName = functionalityName;
		this.accountingDate = accountingDate;
		this.dateTime = dateTime;
		this.bankNotes = bankNotes;
		this.amount = amount;
		this.status = status;
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
	 * @return the terminalId
	 */
	public String getTerminalId() {
		return terminalId;
	}

	/**
	 * @param terminalId the terminalId to set
	 */
	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}

	/**
	 * @return the nsuTerminal
	 */
	public String getNsuTerminal() {
		return nsuTerminal;
	}

	/**
	 * @param nsuTerminal the nsuTerminal to set
	 */
	public void setNsuTerminal(String nsuTerminal) {
		this.nsuTerminal = nsuTerminal;
	}

	/**
	 * @return the companyId
	 */
	public BigDecimal getCompanyId() {
		return companyId;
	}

	/**
	 * @param companyId the companyId to set
	 */
	public void setCompanyId(BigDecimal companyId) {
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
	public BigDecimal getUnitId() {
		return unitId;
	}

	/**
	 * @param unitId the unitId to set
	 */
	public void setUnitId(BigDecimal unitId) {
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
	 * @return the functionalityId
	 */
	public Long getFunctionalityId() {
		return functionalityId;
	}

	/**
	 * @param functionalityId the functionalityId to set
	 */
	public void setFunctionalityId(Long functionalityId) {
		this.functionalityId = functionalityId;
	}

	/**
	 * @return the functionalityName
	 */
	public String getFunctionalityName() {
		return functionalityName;
	}

	/**
	 * @param functionalityName the functionalityName to set
	 */
	public void setFunctionalityName(String functionalityName) {
		this.functionalityName = functionalityName;
	}

	/**
	 * @return the accountingDate
	 */
	public Date getAccountingDate() {
		return accountingDate;
	}

	/**
	 * @param accountingDate the accountingDate to set
	 */
	public void setAccountingDate(Date accountingDate) {
		this.accountingDate = accountingDate;
	}

	/**
	 * @return the dateTime
	 */
	public Date getDateTime() {
		return dateTime;
	}

	/**
	 * @param dateTime the dateTime to set
	 */
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	/**
	 * @return the bankNotes
	 */
	public Integer getBankNotes() {
		return bankNotes;
	}

	/**
	 * @param bankNotes the bankNotes to set
	 */
	public void setBankNotes(Integer bankNotes) {
		this.bankNotes = bankNotes;
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

	@Override
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		
		builder.append("TransactionLogDTO [groupOwnerId=");
		builder.append(groupOwnerId);
		builder.append(", terminalId=");
		builder.append(terminalId);
		builder.append(", nsuTerminal=");
		builder.append(nsuTerminal);
		builder.append(", companyId=");
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
		builder.append(", functionalityId=");
		builder.append(functionalityId);
		builder.append(", functionalityName=");
		builder.append(functionalityName);
		builder.append(", accountingDate=");
		builder.append(accountingDate);
		builder.append(", dateTime=");
		builder.append(dateTime);
		builder.append(", bankNotes=");
		builder.append(bankNotes);
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", status=");
		builder.append(status);
		builder.append("]");

		return builder.toString();
		
	}
	
}
