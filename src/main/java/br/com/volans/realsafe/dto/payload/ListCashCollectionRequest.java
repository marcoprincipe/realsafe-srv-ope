package br.com.volans.realsafe.dto.payload;

import java.io.Serializable;

/**
 * DTO para chamada do serviço para pesquisa de recolhimento de numerário.
 * 
 * @author Volans Informática Ltda.
 */

public class ListCashCollectionRequest implements Serializable {

	/**
	 * Declaração da serial version.
	 */
	
	private static final long serialVersionUID = -1080180542190006570L;
	
	/**
	 * Declaração das variáveis membro.
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
		
		builder.append("ListCashCollectionRequest [terminalId=");
		builder.append(terminalId);
		builder.append("]");
		
		return builder.toString();
		
	}

}
