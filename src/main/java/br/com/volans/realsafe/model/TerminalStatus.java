package br.com.volans.realsafe.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Classe para armazenamento dos dados do terminal.
 * 
 * @author Volans Informática Ltda
 */

@Entity
@Table(name = "tb_terminal_status")
public class TerminalStatus implements Serializable {

	/**
	 * Declaração da serial version.
	 */

	private static final long serialVersionUID = -2904785341296406826L;
	
	/**
	 * Declaração das variáveis membro.
	 */

	@Id
	@Column(name = "terminal_id")
	private String terminalId;
	
	@Column(name = "accounting_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date accountingDate;
	
	@Column(name = "banknotes_in_safe")
	private Integer banknotesInSafe;
	
	@Column(name = "amount_in_safe")
	private BigDecimal amountInSafe;

	@Column(name = "last_opening_date_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastOpeningDateTime;

	@Column(name = "last_opening_banknotes")
	private Integer lastOpeningBanknotes;
	
	@Column(name = "last_opening_amount")
	private BigDecimal lastOpeningAmount;

	@Column(name = "last_closing_date_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastClosingDateTime;

	@Column(name = "last_closing_banknotes")
	private Integer lastClosingBanknotes;
	
	@Column(name = "last_closing_amount")
	private BigDecimal lastClosingAmount;
	
	@Column(name = "etv_closing")
	private String etvClosing;
	
	@Column(name = "status")
	private String status;

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
	 * @return the banknotesInSafe
	 */
	public Integer getBanknotesInSafe() {
		return banknotesInSafe;
	}

	/**
	 * @param banknotesInSafe the banknotesInSafe to set
	 */
	public void setBanknotesInSafe(Integer banknotesInSafe) {
		this.banknotesInSafe = banknotesInSafe;
	}

	/**
	 * @return the amountInSafe
	 */
	public BigDecimal getAmountInSafe() {
		return amountInSafe;
	}

	/**
	 * @param amountInSafe the amountInSafe to set
	 */
	public void setAmountInSafe(BigDecimal amountInSafe) {
		this.amountInSafe = amountInSafe;
	}

	/**
	 * @return the lastOpeningDateTime
	 */
	public Date getLastOpeningDateTime() {
		return lastOpeningDateTime;
	}

	/**
	 * @param lastOpeningDateTime the lastOpeningDateTime to set
	 */
	public void setLastOpeningDateTime(Date lastOpeningDateTime) {
		this.lastOpeningDateTime = lastOpeningDateTime;
	}

	/**
	 * @return the lastOpeningBanknotes
	 */
	public Integer getLastOpeningBanknotes() {
		return lastOpeningBanknotes;
	}

	/**
	 * @param lastOpeningBanknotes the lastOpeningBanknotes to set
	 */
	public void setLastOpeningBanknotes(Integer lastOpeningBanknotes) {
		this.lastOpeningBanknotes = lastOpeningBanknotes;
	}

	/**
	 * @return the lastOpeningAmount
	 */
	public BigDecimal getLastOpeningAmount() {
		return lastOpeningAmount;
	}

	/**
	 * @param lastOpeningAmount the lastOpeningAmount to set
	 */
	public void setLastOpeningAmount(BigDecimal lastOpeningAmount) {
		this.lastOpeningAmount = lastOpeningAmount;
	}

	/**
	 * @return the lastClosingDateTime
	 */
	public Date getLastClosingDateTime() {
		return lastClosingDateTime;
	}

	/**
	 * @param lastClosingDateTime the lastClosingDateTime to set
	 */
	public void setLastClosingDateTime(Date lastClosingDateTime) {
		this.lastClosingDateTime = lastClosingDateTime;
	}

	/**
	 * @return the lastClosingBanknotes
	 */
	public Integer getLastClosingBanknotes() {
		return lastClosingBanknotes;
	}

	/**
	 * @param lastClosingBanknotes the lastClosingBanknotes to set
	 */
	public void setLastClosingBanknotes(Integer lastClosingBanknotes) {
		this.lastClosingBanknotes = lastClosingBanknotes;
	}

	/**
	 * @return the lastClosingAmount
	 */
	public BigDecimal getLastClosingAmount() {
		return lastClosingAmount;
	}

	/**
	 * @param lastClosingAmount the lastClosingAmount to set
	 */
	public void setLastClosingAmount(BigDecimal lastClosingAmount) {
		this.lastClosingAmount = lastClosingAmount;
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
		
		builder.append("TerminalStatus [terminalId=");
		builder.append(terminalId);
		builder.append(", accountingDate=");
		builder.append(accountingDate);
		builder.append(", banknotesInSafe=");
		builder.append(banknotesInSafe);
		builder.append(", amountInSafe=");
		builder.append(amountInSafe);
		builder.append(", lastOpeningDateTime=");
		builder.append(lastOpeningDateTime);
		builder.append(", lastOpeningBanknotes=");
		builder.append(lastOpeningBanknotes);
		builder.append(", lastOpeningAmount=");
		builder.append(lastOpeningAmount);
		builder.append(", lastClosingDateTime=");
		builder.append(lastClosingDateTime);
		builder.append(", lastClosingBanknotes=");
		builder.append(lastClosingBanknotes);
		builder.append(", lastClosingAmount=");
		builder.append(lastClosingAmount);
		builder.append(", etvClosing=");
		builder.append(etvClosing);
		builder.append(", status=");
		builder.append(status);
		builder.append("]");
		
		return builder.toString();
		
	}
	
}
