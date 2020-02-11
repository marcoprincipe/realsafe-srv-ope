package br.com.volans.realsafe.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * DTO para armazenamento dos dados do terminal.
 * 
 * @author Volans Informática Ltda.
 */

public class TerminalDTO implements Serializable {

	/**
	 * Declaração da serial version.
	 */

	private static final long serialVersionUID = 3348109655687878857L;
	
	/**
	 * Declaração das variáveis membro.
	 */

	private String terminalId;
	private String terminalName;
	private String status;
	private Date creationDate;
	private BigDecimal unitId;
	
	/**
	 * Construtor default da classe.
	 */
	
	public TerminalDTO() {
		super();
	}
	
	
	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param terminalId
	 * @param terminalName
	 * @param status
	 * @param creationDate
	 * @param unitId
	 */
	
	public TerminalDTO(String terminalId, String terminalName, String status,
			Date creationDate, BigDecimal unitId) {
		this.terminalId = terminalId;
		this.terminalName = terminalName;
		this.status = status;
		this.creationDate = creationDate;
		this.unitId = unitId;
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
	 * @return the terminalName
	 */
	public String getTerminalName() {
		return terminalName;
	}
	
	/**
	 * @param terminalName the terminalName to set
	 */
	public void setTerminalName(String terminalName) {
		this.terminalName = terminalName;
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
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * @return the unitId
	 */
	public BigDecimal getUnitId() {
		return unitId;
	}
	
	/**
	 * @param unitId the unitId to set
	 */
	public void setUnitId(BigDecimal unitId) {
		this.unitId = unitId;
	}


	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();
		
		builder.append("TerminalDTO [terminalId=");
		builder.append(terminalId);
		builder.append(", terminalName=");
		builder.append(terminalName);
		builder.append(", status=");
		builder.append(status);
		builder.append(", creationDate=");
		builder.append(creationDate);
		builder.append(", unitId=");
		builder.append(unitId);
		builder.append("]");
		
		return builder.toString();
		
	}
	
}
