package br.com.volans.realsafe.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe para armazenamento dos dados do nsu de um terminal.
 * 
 * @author Volans Informática Ltda
 */

@Entity
@Table(name = "tb_nsu_terminal")
public class NSUTerminal implements Serializable {

	/**
	 * Declaração da serial version.
	 */

	private static final long serialVersionUID = 3163538228305634193L;
	
	/**
	 * Declaração das variáveis membro.
	 */

	@Id
	@Column(name = "terminal_id")
	private String terminalId;

	@Column(name = "nsu_terminal")
	private BigDecimal nsuTerminal;

	@Column(name = "nsu_event")
	private BigDecimal nsuEvent;

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

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();
		
		builder.append("NSUTerminal [terminalId=");
		builder.append(terminalId);
		builder.append(", nsuTerminal=");
		builder.append(nsuTerminal);
		builder.append(", nsuEvent=");
		builder.append(nsuEvent);
		builder.append("]");
		
		return builder.toString();
		
	}
	
}
