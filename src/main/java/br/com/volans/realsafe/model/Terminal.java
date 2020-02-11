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
 * Classe para armazenamento dos dados do terminal.
 * 
 * @author Volans Informática Ltda
 */

@Entity
@Table(name = "tb_terminal")
public class Terminal implements Serializable {

	/**
	 * Declaração da serial version.
	 */

	private static final long serialVersionUID = 5732914564088599808L;
	
	/**
	 * Declaração das variáveis membro.
	 */

	@Id
	@Column(name = "terminal_id")
	private String terminalId;
	
	@Column(name = "terminal_name")
	private String terminalName;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "creation_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;
	
	@Column(name = "unit_id")
	private BigDecimal unitId;

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
		
		builder.append("Terminal [terminalId=");
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
