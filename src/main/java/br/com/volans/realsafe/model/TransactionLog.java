package br.com.volans.realsafe.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Classe para armazenamento dos dados de log de transações.
 * 
 * @author Volans Informática Ltda
 */

@Entity
@Table(name = "tb_transaction_log")
public class TransactionLog implements Serializable {

	/**
	 * Declaração da serial version.
	 */
	
	private static final long serialVersionUID = -169136156381791918L;
	
	/**
	 * Declaração das variáveis membro.
	 */

	@Id
	@Column(name = "nsu_terminal")
	private String nsuTerminal;
	
	@Column(name = "group_owner_id")
	private BigDecimal groupOwnerId;
	
	@Column(name = "unit_id")
	private BigDecimal unitId;
	
	@Column(name = "user_id")
	private BigDecimal userId;

	@Column(name = "terminal_id")
	private String terminalId;
	
	@Column(name = "accounting_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date accountingDate;
	
	@Column(name = "date_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateTime;
	
	@Column(name = "functionality_id")
	private Long functionalityId;
	
	@Column(name = "banknotes")
	private Integer bankNotes;
	
	@Column(name = "amount", precision = 11, scale = 2)
	private BigDecimal amount;
	
	@Column(name = "status", insertable = false)
	private String status;
	
	@ManyToOne
	@JoinColumn(name = "unit_id", insertable = false, updatable = false)
	private Unit unit;
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "group_owner_id", insertable = false, updatable = false), 
		@JoinColumn(name = "user_id", insertable = false, updatable = false)
	})
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "functionality_id", insertable = false, updatable = false)
	private Functionality functionality;

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

	/**
	 * @return the unit
	 */
	public Unit getUnit() {
		return unit;
	}

	/**
	 * @param unit the unit to set
	 */
	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the functionality
	 */
	public Functionality getFunctionality() {
		return functionality;
	}

	/**
	 * @param functionality the functionality to set
	 */
	public void setFunctionality(Functionality functionality) {
		this.functionality = functionality;
	}

	@Override
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		
		builder.append("TransactionLog [nsuTerminal=");
		builder.append(nsuTerminal);
		builder.append(", groupOwnerId=");
		builder.append(groupOwnerId);
		builder.append(", unitId=");
		builder.append(unitId);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", terminalId=");
		builder.append(terminalId);
		builder.append(", accountingDate=");
		builder.append(accountingDate);
		builder.append(", dateTime=");
		builder.append(dateTime);
		builder.append(", functionalityId=");
		builder.append(functionalityId);
		builder.append(", bankNotes=");
		builder.append(bankNotes);
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", status=");
		builder.append(status);
		builder.append(", unit=");
		builder.append(unit);
		builder.append(", user=");
		builder.append(user);
		builder.append(", functionality=");
		builder.append(functionality);
		builder.append("]");
		
		return builder.toString();
		
	}
	
}
