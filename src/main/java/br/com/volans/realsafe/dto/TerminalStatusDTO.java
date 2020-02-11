package br.com.volans.realsafe.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * DTO para armazenamento dos dados do status de um terminal.
 * 
 * @author Volans Informática Ltda.
 */

public class TerminalStatusDTO implements Serializable {

	/**
	 * Declaração da serial version.
	 */
	
	private static final long serialVersionUID = -8096478796917033538L;
	
	/**
	 * Declaração das variáveis membro.
	 */
	
	private String terminalId;
	private Date accountingDate;
	private Integer banknotesInSafe;
	private BigDecimal amountInSafe;
	private Date lastOpeningDateTime;
	private Integer lastOpeningBanknotes;
	private BigDecimal lastOpeningAmount;
	private Date lastClosingDateTime;
	private Integer lastClosingBanknotes;
	private BigDecimal lastClosingAmount;
	private String etvClosing;
	private String status;
	private Date dbDateTime;
	private String lastNSU;

	/**
	 * Construtor default da classe.
	 */
	
	public TerminalStatusDTO() {
		super();
	}

	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param terminalId
	 * @param accountingDate
	 * @param banknotesInSafe
	 * @param amountInSafe
	 * @param lastOpeningDateTime
	 * @param lastOpeningBanknotes
	 * @param lastOpeningAmount
	 * @param lastClosingDateTime
	 * @param lastClosingBanknotes
	 * @param lastClosingAmount
	 * @param etvClosing
	 * @param status
	 * @param dbDateTime
	 */
	
	public TerminalStatusDTO(String terminalId, Date accountingDate, Integer banknotesInSafe, BigDecimal amountInSafe,
			Date lastOpeningDateTime, Integer lastOpeningBanknotes, BigDecimal lastOpeningAmount,
			Date lastClosingDateTime, Integer lastClosingBanknotes, BigDecimal lastClosingAmount, String etvClosing,
			String status, Date dbDateTime) {
		this.terminalId = terminalId;
		this.accountingDate = accountingDate;
		this.banknotesInSafe = banknotesInSafe;
		this.amountInSafe = amountInSafe;
		this.lastOpeningDateTime = lastOpeningDateTime;
		this.lastOpeningBanknotes = lastOpeningBanknotes;
		this.lastOpeningAmount = lastOpeningAmount;
		this.lastClosingDateTime = lastClosingDateTime;
		this.lastClosingBanknotes = lastClosingBanknotes;
		this.lastClosingAmount = lastClosingAmount;
		this.etvClosing = etvClosing;
		this.status = status;
		this.dbDateTime = dbDateTime;
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

	/**
	 * @return the dbDateTime
	 */
	public Date getDbDateTime() {
		return dbDateTime;
	}

	/**
	 * @param dbDateTime the dbDateTime to set
	 */
	public void setDbDateTime(Date dbDateTime) {
		this.dbDateTime = dbDateTime;
	}
	
	/**
	 * @return the lastNSU
	 */
	public String getLastNSU() {
		return lastNSU;
	}

	/**
	 * @param lastNSU the lastNSU to set
	 */
	public void setLastNSU(String lastNSU) {
		this.lastNSU = lastNSU;
	}

	@Override
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		
		builder.append("TerminalStatusDTO [terminalId=");
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
		builder.append(", dbDateTime=");
		builder.append(dbDateTime);
		builder.append(", lastNSU=");
		builder.append(lastNSU);
		builder.append("]");

		return builder.toString();
		
	}
	
}
