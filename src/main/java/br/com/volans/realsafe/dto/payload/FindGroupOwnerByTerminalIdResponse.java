package br.com.volans.realsafe.dto.payload;

import java.io.Serializable;

import br.com.volans.realsafe.dto.GroupOwnerDTO;

/**
 * DTO para retorno do serviço para pesquisa de proprietarios de grupos pelo id do terminal.
 * 
 * @author Volans Informática Ltda
 */

public class FindGroupOwnerByTerminalIdResponse implements Serializable {

	/**
	 * Declaração da serial version
	 */
	
	private static final long serialVersionUID = 1828919613083171528L;

	/**
	 * Declaração das variáveis membro
	 */

	private GroupOwnerDTO groupOwner;
	
	/**
	 * @return the groupOwner
	 */
	public GroupOwnerDTO getGroupOwner() {
		return groupOwner;
	}

	/**
	 * @param groupOwner the groupOwner to set
	 */
	public void setGroupOwner(GroupOwnerDTO groupOwner) {
		this.groupOwner = groupOwner;
	}

	/**
	 * Construtor default da classe.
	 */
	
	public FindGroupOwnerByTerminalIdResponse() {
		groupOwner = new GroupOwnerDTO();
	}

	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param groupOwner - Dados do proprietário do grupo a ser retornado.
	 */
	
	public FindGroupOwnerByTerminalIdResponse(GroupOwnerDTO groupOwner) {
		this.groupOwner = groupOwner;
	}

	@Override
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		
		builder.append("FindGroupOwnerByTerminalIdResponse [groupOwner=");
		builder.append(groupOwner);
		builder.append("]");
		
		return builder.toString();
		
	}
}
