package br.com.volans.realsafe.dto.payload;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * DTO para chamada do serviço para coleta no recolhimento de numerário.
 * 
 * @author Volans Informática Ltda.
 */

public class CollectCashRequest implements Serializable {

	/**
	 * Declaração da serial version.
	 */
	
	private static final long serialVersionUID = -7848218539861599452L;

	/**
	 * Declaração das variáveis membro.
	 */

	private BigDecimal groupOwnerId;
	private String terminalId;
	private BigDecimal unitId;
	private BigDecimal userId;
	private Date dateTime;
	private Integer bankNotes;
	private BigDecimal amount;
	
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

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();
		
		builder.append("CollectCashRequest [groupOwnerId=");
		builder.append(groupOwnerId);
		builder.append(", terminalId=");
		builder.append(terminalId);
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
		builder.append("]");
		
		return builder.toString();
		
	}
	
}
