package br.com.volans.realsafe.dto.payload;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * DTO para chamada do serviço de impressão do recibo de depósito.
 * 
 * @author Volans Informática Ltda.
 */

public class PrintCloseTerminalReceiptRequest implements Serializable {

	/**
	 * Declaração da serial version.
	 */

	private static final long serialVersionUID = -7863164933876618852L;

	/**
	 * Declaração das variáveis membro.
	 */
	
	private String nsu;
	private String unitName;
	private String companyName;
	private String userName;
	private String terminalId;
	private Date dateTime;
	private BigDecimal amount;
	
	/**
	 * @return the nsu
	 */
	public String getNsu() {
		return nsu;
	}
	
	/**
	 * @param nsu the nsu to set
	 */
	public void setNsu(String nsu) {
		this.nsu = nsu;
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
		
		builder.append("PrintCloseTerminalReceiptRequest [nsu=");
		builder.append(nsu);
		builder.append(", unitName=");
		builder.append(unitName);
		builder.append(", companyName=");
		builder.append(companyName);
		builder.append(", userName=");
		builder.append(userName);
		builder.append(", terminalId=");
		builder.append(terminalId);
		builder.append(", dateTime=");
		builder.append(dateTime);
		builder.append(", amount=");
		builder.append(amount);
		builder.append("]");

		return builder.toString();
		
	}
	
}
