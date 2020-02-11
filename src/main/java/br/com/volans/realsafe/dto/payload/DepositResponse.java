package br.com.volans.realsafe.dto.payload;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import br.com.volans.realsafe.driver.depository.dto.BankNoteDTO;

/**
 * DTO para retorno do serviço de uma operação de depósito.
 * 
 * @author Volans Informática Ltda
 */

public class DepositResponse implements Serializable {

	/**
	 * Declaração da serial version.
	 */
	
	private static final long serialVersionUID = 9166646426343999301L;
	
	/**
	 * Declaração das variáveis membro.
	 */

	private String terminalId;
	private String nsuTerminal;
	private Date dateTime;
	private List<BankNoteDTO> bankNotes;
	private BigDecimal amount;
	
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
	public List<BankNoteDTO> getBankNotes() {
		return bankNotes;
	}
	
	/**
	 * @param bankNotes the bankNotes to set
	 */
	public void setBankNotes(List<BankNoteDTO> bankNotes) {
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
		
		builder.append("DepositResponse [terminalId=");
		builder.append(terminalId);
		builder.append(", nsuTerminal=");
		builder.append(nsuTerminal);
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
