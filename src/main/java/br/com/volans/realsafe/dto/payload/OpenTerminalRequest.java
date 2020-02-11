package br.com.volans.realsafe.dto.payload;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * DTO para chamada do serviço de abertura do terminal.
 * 
 * @author Volans Informática Ltda.
 */

public class OpenTerminalRequest implements Serializable {

	/**
	 * Declaração da serial version.
	 */
	
	private static final long serialVersionUID = -4670735388648568671L;
	
	/**
	 * Declaração das variáveis membro.
	 */
	
	private BigDecimal groupOwnerId;
	private String terminalId;
	private String accountingDate;
	private BigDecimal unitId;
	private BigDecimal userId;
	private Date dateTime;
	private Integer bankNotes;
	private BigDecimal amount;
	private String etvClosing;
	
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
	 * @return the accountingDate
	 */
	public String getAccountingDate() {
		return accountingDate;
	}
	
	/**
	 * @param accountingDate the accountingDate to set
	 */
	public void setAccountingDate(String accountingDate) {
		this.accountingDate = accountingDate;
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
	 * @return the etvClosing
	 */
	public String getEtvClosing() {
		return etvClosing;
	}

	/**
	 * @param etvClosing the etvClosing to set
	 */
	public void setEtvClosing(String etvClosing) {
		this.etvClosing = etvClosing;
	}

	@Override
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		
		builder.append("OpenTerminalRequest [groupOwnerId=");
		builder.append(groupOwnerId);
		builder.append(", terminalId=");
		builder.append(terminalId);
		builder.append(", accountingDate=");
		builder.append(accountingDate);
		builder.append(", unitId=");
		builder.append(unitId);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", dateTime=");
		builder.append(dateTime);
		builder.append(", bankNotes=");
		builder.append(bankNotes);
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", etvClosing=");
		builder.append(etvClosing);
		builder.append("]");
	
		return builder.toString();

	}
	
}
