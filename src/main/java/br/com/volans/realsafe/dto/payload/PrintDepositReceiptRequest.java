package br.com.volans.realsafe.dto.payload;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import br.com.volans.realsafe.driver.depository.dto.BankNoteDTO;

/**
 * DTO para chamada do serviço de impressão do recibo de depósito.
 * 
 * @author Volans Informática Ltda.
 */

public class PrintDepositReceiptRequest implements Serializable {

	/**
	 * Declaração da serial version.
	 */
	
	private static final long serialVersionUID = -8364644511518673177L;

	/**
	 * Declaração das variáveis membro.
	 */
	
	private String nsuTerminal;
	private String companyName;
	private String unitName;
	private String userName;
	private String terminalId;
	private Date dateTime;
	private List<BankNoteDTO> bankNotes;
	private BigDecimal amount;
	
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
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}
	
	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	/**
	 * @return the unitName
	 */
	public String getUnitName() {
		return unitName;
	}
	
	/**
	 * @param unitName the unitName to set
	 */
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
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
		
		builder.append("PrintDepositReceiptRequest [nsuTerminal=");
		builder.append(nsuTerminal);
		builder.append(", companyName=");
		builder.append(companyName);
		builder.append(", unitName=");
		builder.append(unitName);
		builder.append(", userName=");
		builder.append(userName);
		builder.append(", terminalId=");
		builder.append(terminalId);
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
