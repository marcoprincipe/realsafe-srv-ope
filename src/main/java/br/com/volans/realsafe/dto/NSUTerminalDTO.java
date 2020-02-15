package br.com.volans.realsafe.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * DTO para armazenamento dos dados de um NSU de terminal.
 * 
 * @author Volans Informática Ltda.
 */

public class NSUTerminalDTO implements Serializable {

	/**
	 * Declaração da serial version.
	 */
	
	private static final long serialVersionUID = -1315590380342095565L;
	
	/**
	 * Declaração das variáveis membro.
	 */

	private String terminalId;
	private BigDecimal nsuTerminal;
	private BigDecimal nsuEvent;
	private Date currentDateTime;
	
	/**
	 * Construtor default da classe
	 */
	
	public NSUTerminalDTO() {
		super();
	}

	/**
	 * Construtor alternativo da classe
	 * 
	 * @param terminalId
	 * @param nsuTerminal
	 * @param nsuEvent
	 * @param currentDateTime
	 */
	
	public NSUTerminalDTO(String terminalId, BigDecimal nsuTerminal, BigDecimal nsuEvent, Date currentDateTime) {
		this.terminalId = terminalId;
		this.nsuTerminal = nsuTerminal;
		this.nsuEvent = nsuEvent;
		this.currentDateTime = currentDateTime;
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
	 * @return the nsuTerminal
	 */
	public BigDecimal getNsuTerminal() {
		return nsuTerminal;
	}

	/**
	 * @param nsuTerminal the nsuTerminal to set
	 */
	public void setNsuTerminal(BigDecimal nsuTerminal) {
		this.nsuTerminal = nsuTerminal;
	}

	/**
	 * @return the nsuEvent
	 */
	public BigDecimal getNsuEvent() {
		return nsuEvent;
	}

	/**
	 * @param nsuEvent the nsuEvent to set
	 */
	public void setNsuEvent(BigDecimal nsuEvent) {
		this.nsuEvent = nsuEvent;
	}

	/**
	 * @return the currentDateTime
	 */
	public Date getCurrentDateTime() {
		return currentDateTime;
	}

	/**
	 * @param currentDateTime the currentDateTime to set
	 */
	public void setCurrentDateTime(Date currentDateTime) {
		this.currentDateTime = currentDateTime;
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();
		
		builder.append("NSUTerminalDTO [terminalId=");
		builder.append(terminalId);
		builder.append(", nsuTerminal=");
		builder.append(nsuTerminal);
		builder.append(", nsuEvent=");
		builder.append(nsuEvent);
		builder.append(", currentDateTime=");
		builder.append(currentDateTime);
		builder.append("]");
		
		return builder.toString();
		
	}

}
