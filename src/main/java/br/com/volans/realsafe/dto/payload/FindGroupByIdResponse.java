package br.com.volans.realsafe.dto.payload;

import java.io.Serializable;

import br.com.volans.realsafe.dto.GroupDTO;

/**
 * DTO para retorno do serviço para pesquisa de grupos por id.
 * 
 * @author Volans Informática Ltda
 */

public class FindGroupByIdResponse implements Serializable {

	/**
	 * Declaração da serial version
	 */
	
	private static final long serialVersionUID = 3869573693045951428L;
	
	/**
	 * Declaração das variáveis membro
	 */

	private GroupDTO group;

	/**
	 * Construtor default da classe.
	 */
	
	public FindGroupByIdResponse() {
		group = new GroupDTO();
	}

	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param group - Dados do grupo a ser retornado.
	 */
	
	public FindGroupByIdResponse(GroupDTO group) {
		this.group = group;
	}
	
	/**
	 * @return the group
	 */
	public GroupDTO getGroup() {
		return group;
	}

	/**
	 * @param group the group to set
	 */
	public void setGroup(GroupDTO group) {
		this.group = group;
	}

	@Override
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		
		builder.append("FindGroupByIdResponse [group=");
		builder.append(group);
		builder.append("]");
		
		return builder.toString();
		
	}
	
}
