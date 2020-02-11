package br.com.volans.realsafe.dto.payload;

import java.io.Serializable;

/**
 * DTO para retorno do serviço da pesquisa de terminais.
 * 
 * @author Volans Informática Ltda.
 */

public class FindTerminalByIdRequest implements Serializable {

	/**
	 * Declaração da serial version.
	 */
	
	private static final long serialVersionUID = -5619487691568547680L;
	
	/**
	 * Declaração das variáveis membro
	 */
	
	private String terminalId;

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

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();
		
		builder.append("FindTerminalByIdRequest [terminalId=");
		builder.append(terminalId);
		builder.append("]");
		
		return builder.toString();
		
	}
	
}
