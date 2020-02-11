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
 * Classe para armazenamento dos dados dos detalhes de fechamento de terminal.
 * 
 * @author Volans Informática Ltda
 */

@Entity
@Table(name = "tb_closing_detail")
public class ClosingDetail implements Serializable {

	/**
	 * Declaração da serial version.
	 */

	private static final long serialVersionUID = -6355883114076698031L;
	
	/**
	 * Declaração das variáveis membro.
	 */
	
	@Id
	@Column(name = "nsu_terminal")
	private String nsuTerminal;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "closing_date_time")
	private Date closingDateTime;

	@Column(name = "banknotes_in_safe")
	private Integer bankNotesInSafe;
	
	@Column(name = "amount_in_safe")
	private BigDecimal amountInSafe;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_opening_date_time")
	private Date lastOpeningDateTime;

	@Column(name = "last_opening_banknotes")
	private Integer lastOpeningBanknotes;
	
	@Column(name = "last_opening_amount")
	private BigDecimal lastOpeningAmount;

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
	 * @return the closingDateTime
	 */
	public Date getClosingDateTime() {
		return closingDateTime;
	}

	/**
	 * @param closingDateTime the closingDateTime to set
	 */
	public void setClosingDateTime(Date closingDateTime) {
		this.closingDateTime = closingDateTime;
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

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();
		
		builder.append("ClosingDetail [nsuTerminal=");
		builder.append(nsuTerminal);
		builder.append(", closingDateTime=");
		builder.append(closingDateTime);
		builder.append(", bankNotesInSafe=");
		builder.append(bankNotesInSafe);
		builder.append(", amountInSafe=");
		builder.append(amountInSafe);
		builder.append(", lastOpeningDateTime=");
		builder.append(lastOpeningDateTime);
		builder.append(", lastOpeningBanknotes=");
		builder.append(lastOpeningBanknotes);
		builder.append(", lastOpeningAmount=");
		builder.append(lastOpeningAmount);
		builder.append("]");
		
		return builder.toString();
		
	}
	
}
