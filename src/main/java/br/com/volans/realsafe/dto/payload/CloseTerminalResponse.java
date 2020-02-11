package br.com.volans.realsafe.dto.payload;

import java.io.Serializable;

import br.com.volans.realsafe.dto.TerminalStatusDTO;

/**
 * DTO para retorno do serviço de fechamento de terminal.
 * 
 * @author Volans Informática Ltda.
 */

public class CloseTerminalResponse implements Serializable {

	/**
	 * Declaração da serial version.
	 */
	
	private static final long serialVersionUID = -1373952452622982646L;

	/**
	 * Declaração das variáveis membro.
	 */
	
	private TerminalStatusDTO terminalStatus;

	/**
	 * Construtor default da classe.
	 */
	
	public CloseTerminalResponse() {
		terminalStatus = new TerminalStatusDTO();
	}

	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param terminalStatus
	 */
	
	public CloseTerminalResponse(TerminalStatusDTO terminalStatus) {
		this.terminalStatus = terminalStatus;
	}

	/**
	 * @return the terminalStatus
	 */
	public TerminalStatusDTO getTerminalStatus() {
		return terminalStatus;
	}

	/**
	 * @param terminalStatus the terminalStatus to set
	 */
	public void setTerminalStatus(TerminalStatusDTO terminalStatus) {
		this.terminalStatus = terminalStatus;
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();
		
		builder.append("CloseTerminalResponse [terminalStatus=");
		builder.append(terminalStatus);
		builder.append("]");
		
		return builder.toString();
		
	}
	
}
