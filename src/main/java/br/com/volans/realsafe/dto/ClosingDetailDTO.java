package br.com.volans.realsafe.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * DTO para armazenamento dos dados de um detalhe de fechamento.
 * 
 * @author Volans Informática Ltda.
 */

public class ClosingDetailDTO implements Serializable {

	/**
	 * Declaração da serial version.
	 */
	
	private static final long serialVersionUID = 1782047664256976253L;
	
	/**
	 * Declaração das variáveis membro.
	 */
	
	private String nsuTerminal;
	private Date closingDateTime;
	private Integer bankNotesInSafe;
	private BigDecimal amountInSafe;
	private Date lastOpeningDateTime;
	private Integer lastOpeningBanknotes;
	private BigDecimal lastOpeningAmount;

	/**
	 * Construtor default da classe.
	 */
	
	public ClosingDetailDTO() {
		super();
	}

	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param nsuTerminal
	 * @param closingDateTime
	 * @param bankNotesInSafe
	 * @param amountInSafe
	 * @param lastOpeningDateTime
	 * @param lastOpeningBanknotes
	 * @param lastOpeningAmount
	 */

	public ClosingDetailDTO(String nsuTerminal, Date closingDateTime, Integer bankNotesInSafe, BigDecimal amountInSafe,
			Date lastOpeningDateTime, Integer lastOpeningBanknotes, BigDecimal lastOpeningAmount) {
		this.nsuTerminal = nsuTerminal;
		this.closingDateTime = closingDateTime;
		this.bankNotesInSafe = bankNotesInSafe;
		this.amountInSafe = amountInSafe;
		this.lastOpeningDateTime = lastOpeningDateTime;
		this.lastOpeningBanknotes = lastOpeningBanknotes;
		this.lastOpeningAmount = lastOpeningAmount;
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
		
		builder.append("ClosingDetailDTO [nsuTerminal=");
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
