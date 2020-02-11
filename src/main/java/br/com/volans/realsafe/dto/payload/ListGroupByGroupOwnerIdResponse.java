package br.com.volans.realsafe.dto.payload;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.volans.realsafe.dto.GroupDTO;

/**
 * DTO para retorno do serviço de lista de grupos de proprietarios de grupos
 * 
 * @author Volans Informática Ltda
 */

public class ListGroupByGroupOwnerIdResponse implements Serializable {

	/**
	 * Declaração da serial version.
	 */
	
	private static final long serialVersionUID = -2175942585499457275L;
	
	/**
	 * Declaração das variáveis membro.
	 */

	private List<GroupDTO> groups;
	
	/**
	 * Construtor default da classe.
	 */
	
	public ListGroupByGroupOwnerIdResponse() {
		groups = new ArrayList<GroupDTO>();
	}

	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param groups - Lista de grupos de proprietários de grupos a serem retornados.
	 */
	
	public ListGroupByGroupOwnerIdResponse(List<GroupDTO> groups) {
		this.groups = groups;
	}
	

	/**
	 * @return the groups
	 */
	public List<GroupDTO> getGroups() {
		return groups;
	}

	/**
	 * @param groups the groups to set
	 */
	public void setGroups(List<GroupDTO> groups) {
		this.groups = groups;
	}

	@Override
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		
		builder.append("ListGroupByGroupOwnerIdResponse [groups=");
		builder.append(groups);
		builder.append(']');
		
		return builder.toString();
		
	}
}
