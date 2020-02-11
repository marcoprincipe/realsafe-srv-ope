package br.com.volans.realsafe.dto.payload;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.volans.realsafe.dto.GroupDTO;

/**
 * DTO para retorno do serviço de lista de grupos cadastrados.
 * 
 * @author Volans Informática Ltda
 */

public class ListGroupsResponse implements Serializable {

	/**
	 * Declaração da serial version.
	 */
	
	private static final long serialVersionUID = -4734537820514037415L;

	/**
	 * Declaração das variáveis membro.
	 */

	private List<GroupDTO> groups;
	
	/**
	 * Construtor default da classe.
	 */
	
	public ListGroupsResponse() {
		groups = new ArrayList<GroupDTO>();
	}

	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param companies - Lista dos grupos a serem retornados.
	 */
	
	public ListGroupsResponse(List<GroupDTO> groups) {
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
		
		builder.append("ListGroupsResponse [groups=");
		builder.append(groups);
		builder.append("]");
		
		return builder.toString();
		
	}
	
}
