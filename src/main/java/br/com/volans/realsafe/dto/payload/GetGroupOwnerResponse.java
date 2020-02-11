package br.com.volans.realsafe.dto.payload;

import java.io.Serializable;

import br.com.volans.realsafe.dto.GroupOwnerDTO;

/**
 * DTO para retorno do serviço da pesquisa de proprietário de grupos.
 * 
 * @author Volans Informática Ltda.
 */

public class GetGroupOwnerResponse implements Serializable {

	/**
	 * Declaração da serial version.
	 */
	
	private static final long serialVersionUID = 7848430830250153991L;
	
	/**
	 * Declaração das variáveis membro.
	 */

	private GroupOwnerDTO groupOwner;

	/**
	 * Construtor default da classe.
	 */
	
	public GetGroupOwnerResponse() {
		groupOwner = new GroupOwnerDTO();
	}

	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param groupOwner - Dados do proprietário de grupos a ser retornado.
	 */
	
	public GetGroupOwnerResponse(GroupOwnerDTO groupOwner) {
		this.groupOwner = groupOwner;
	}

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

	@Override
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		
		builder.append("GetGroupOwnerResponse [groupOwner=");
		builder.append(groupOwner);
		builder.append("]");
		
		return builder.toString();
		
	}
	
	

}
