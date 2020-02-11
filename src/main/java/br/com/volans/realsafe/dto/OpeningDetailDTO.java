package br.com.volans.realsafe.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * DTO para armazenamento dos dados de um detalhe de abertura.
 * 
 * @author Volans Informática Ltda.
 */

public class OpeningDetailDTO implements Serializable {

	/**
	 * Declaração da serial version.
	 */
	
	private static final long serialVersionUID = 5989691823742704573L;
	
	/**
	 * Declaração das variáveis membro.
	 */

	private String nsuTerminal;
	private Date accountingDate;
	private Date openingDateTime;
	private Integer bankNotesInSafe;
	private BigDecimal amountInSafe;
	private Date lastClosingDateTime;
	private Integer lastClosingBanknotes;
	private BigDecimal lastClosingAmount;
	private String etvClosing;
	
	/**
	 * Construtor default da classe
	 */
	
	public OpeningDetailDTO() {
		super();
	}

	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param nsuTerminal
	 * @param accountingDate
	 * @param openingDateTime
	 * @param bankNotesInSafe
	 * @param amountInSafe
	 * @param lastClosingDateTime
	 * @param lastClosingBanknotes
	 * @param lastClosingAmount
	 * @param etvClosing
	 */

	public OpeningDetailDTO(String nsuTerminal, Date accountingDate, Date openingDateTime, Integer bankNotesInSafe,
			BigDecimal amountInSafe, Date lastClosingDateTime, Integer lastClosingBanknotes,
			BigDecimal lastClosingAmount, String etvClosing) {
		this.nsuTerminal = nsuTerminal;
		this.accountingDate = accountingDate;
		this.openingDateTime = openingDateTime;
		this.bankNotesInSafe = bankNotesInSafe;
		this.amountInSafe = amountInSafe;
		this.lastClosingDateTime = lastClosingDateTime;
		this.lastClosingBanknotes = lastClosingBanknotes;
		this.lastClosingAmount = lastClosingAmount;
		this.etvClosing = etvClosing;
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
		
		builder.append("OpeningDetailDTO [nsuTerminal=");
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
