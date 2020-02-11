package br.com.volans.realsafe.dto.payload;

import java.io.Serializable;

/**
 * DTO para chamada do serviço para pesquisa de proprietários de grupos pelo id do terminal.
 * 
 * @author Volans Informática Ltda
 */

public class FindGroupOwnerByTerminalIdIdRequest implements Serializable {

	/**
	 * Declaração da serial version
	 */

	private static final long serialVersionUID = 2989875340451103140L;
	
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
		
		builder.append("FindGroupOwnerByTerminalIdIdRequest [terminalId=");
		builder.append(terminalId);
		builder.append("]");
		
		return builder.toString();
		
	}
	
}
