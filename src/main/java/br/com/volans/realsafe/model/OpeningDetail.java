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
 * Classe para armazenamento dos dados dos detalhes de abertura de terminal.
 * 
 * @author Volans Informática Ltda
 */

@Entity
@Table(name = "tb_opening_detail")
public class OpeningDetail implements Serializable {

	/**
	 * Declaração da serial version.
	 */

	private static final long serialVersionUID = 9206795289458615254L;
	
	/**
	 * Declaração das variáveis membro.
	 */

	@Id
	@Column(name = "nsu_terminal")
	private String nsuTerminal;

	@Column(name = "accounting_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date accountingDate;

	@Column(name = "opening_date_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date openingDateTime;

	@Column(name = "banknotes_in_safe")
	private Integer bankNotesInSafe;
	
	@Column(name = "amount_in_safe")
	private BigDecimal amountInSafe;

	@Column(name = "last_closing_date_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastClosingDateTime;

	@Column(name = "last_closing_banknotes")
	private Integer lastClosingBanknotes;
	
	@Column(name = "last_closing_amount")
	private BigDecimal lastClosingAmount;

	@Column(name = "etv_closing")
	private String etvClosing;

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
	 * @return the openingDateTime
	 */
	public Date getOpeningDateTime() {
		return openingDateTime;
	}

	/**
	 * @param openingDateTime the openingDateTime to set
	 */
	public void setOpeningDateTime(Date openingDateTime) {
		this.openingDateTime = openingDateTime;
	}

	/**
	 * @return the bankNotesInSafe
	 */
	public Integer getBankNotesInSafe() {
		return bankNotesInSafe;
	}

	/**
	 * @param bankNotesInSafe the bankNotesInSafe to set
	 */
	public void setBankNotesInSafe(Integer bankNotesInSafe) {
		this.bankNotesInSafe = bankNotesInSafe;
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

	@Override
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		
		builder.append("OpeningDetail [nsuTerminal=");
		builder.append(nsuTerminal);
		builder.append(", accountingDate=");
		builder.append(accountingDate);
		builder.append(", openingDateTime=");
		builder.append(openingDateTime);
		builder.append(", bankNotesInSafe=");
		builder.append(bankNotesInSafe);
		builder.append(", amountInSafe=");
		builder.append(amountInSafe);
		builder.append(", lastClosingDateTime=");
		builder.append(lastClosingDateTime);
		builder.append(", lastClosingBanknotes=");
		builder.append(lastClosingBanknotes);
		builder.append(", lastClosingAmount=");
		builder.append(lastClosingAmount);
		builder.append(", etvClosing=");
		builder.append(etvClosing);
		builder.append("]");
	
		return builder.toString();

	}
	
}
