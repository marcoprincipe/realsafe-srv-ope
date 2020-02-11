package br.com.volans.realsafe.dto.payload;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.volans.realsafe.dto.GroupOwnerDTO;

/**
 * DTO para retorno do serviço de lista de proprietarios de grupos
 * 
 * @author Volans Informática Ltda
 */

public class ListGroupOwnerResponse implements Serializable {

	/**
	 * Declaração da serial version.
	 */
	
	private static final long serialVersionUID = -2175942585499457275L;
	
	/**
	 * Declaração das variáveis membro.
	 */

	private List<GroupOwnerDTO> groupOwners;
	
	/**
	 * Construtor default da classe.
	 */
	
	public ListGroupOwnerResponse() {
		groupOwners = new ArrayList<GroupOwnerDTO>();
	}

	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param groupOwner - Lista de proprietários de grupos a serem retornados.
	 */
	
	public ListGroupOwnerResponse(List<GroupOwnerDTO> groupOwners) {
		this.groupOwners = groupOwners;
	}
	
	/**
	 * @return the groupOwners
	 */
	public List<GroupOwnerDTO> getGroupOwners() {
		return groupOwners;
	}

	/**
	 * @param groupOwners the groupOwners to set
	 */
	public void setGroupOwner(List<GroupOwnerDTO> groupOwners) {
		this.groupOwners = groupOwners;
	}

	@Override
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		
		builder.append("ListGroupOwnerResponse [groupOwners=");
		builder.append(groupOwners);
		builder.append(']');
		
		return builder.toString();
		
	}
}
