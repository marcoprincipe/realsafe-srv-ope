package br.com.volans.realsafe.dto.payload;

import java.io.Serializable;

/**
 * DTO para chamada do serviço para pesquisa de detalhes de depóstio.
 * 
 * @author Volans Informática Ltda.
 */

public class ListDepositDetailsRequest implements Serializable {

	/**
	 * Declaração da serial version.
	 */
	
	private static final long serialVersionUID = 2953216189658906408L;
	
	/**
	 * Declaração das variáveis membro.
	 */

	private String nsuTerminal;

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

	@Override
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		
		builder.append("ListDepositDetailsRequest [nsuTerminal=");
		builder.append(nsuTerminal);
		builder.append("]");
		
		return builder.toString();
		
	}
	
}
