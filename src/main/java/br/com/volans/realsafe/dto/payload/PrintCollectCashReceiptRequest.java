package br.com.volans.realsafe.dto.payload;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import br.com.volans.realsafe.dto.TransactionLogDTO;

/**
 * DTO para chamada do serviço de impressão do recibo de recolhimento de numerário.
 * 
 * @author Volans Informática Ltda.
 */

public class PrintCollectCashReceiptRequest implements Serializable {

	/**
	 * Declaração da serial version.
	 */

	private static final long serialVersionUID = -5184676443116473943L;

	/**
	 * Declaração das variáveis membro.
	 */
	
	private String nsuTerminal;
	private String terminalId;
	private String companyName;
	private String unitName;
	private String userName;
	private Date dateTime;
	private BigDecimal amount;
	private List<TransactionLogDTO> transactionLogs;
	
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
	 * @return the transactionLogs
	 */
	public List<TransactionLogDTO> getTransactionLogs() {
		return transactionLogs;
	}

	/**
	 * @param transactionLogs the transactionLogs to set
	 */
	public void setTransactionLogs(List<TransactionLogDTO> transactionLogs) {
		this.transactionLogs = transactionLogs;
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();
		
		builder.append("PrintCollectCashReceiptRequest [nsuTerminal=");
		builder.append(nsuTerminal);
		builder.append(", terminalId=");
		builder.append(terminalId);
		builder.append(", companyName=");
		builder.append(companyName);
		builder.append(", unitName=");
		builder.append(unitName);
		builder.append(", userName=");
		builder.append(userName);
		builder.append(", dateTime=");
		builder.append(dateTime);
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", transactionLogs=");
		builder.append(transactionLogs);
		builder.append("]");
		
		return builder.toString();
		
	}
	
}
