package br.com.volans.realsafe.dto.payload;

import java.io.Serializable;
import java.util.List;

import br.com.volans.realsafe.dto.UserGroupDTO;

/**
 * DTO para retorno do serviço para pesquisa de grupos de usuários.
 * 
 * @author Volans Informática Ltda.
 */

public class ListUserGroupsResponse implements Serializable {

	/**
	 * Declaração da serial version.
	 */
	
	private static final long serialVersionUID = -4708360265153469076L;
	
	/**
	 * Declaração das variáveis membro.
	 */

	private List<UserGroupDTO> userGroups;

	/**
	 * Construtor default da classe.
	 */
	
	public ListUserGroupsResponse() {
		super();
	}

	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param userGroups - Lista dos grupos do usuário.
	 */
	
	public ListUserGroupsResponse(List<UserGroupDTO> userGroups) {
		this.userGroups = userGroups;
	}

	/**
	 * @return the userGroups
	 */
	public List<UserGroupDTO> getUserGroups() {
		return userGroups;
	}

	/**
	 * @param userGroups the userGroups to set
	 */
	public void setUserGroups(List<UserGroupDTO> userGroups) {
		this.userGroups = userGroups;
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();
		
		builder.append("ListUserGroupsResponse [userGroups=");
		builder.append(userGroups);
		builder.append("]");
		
		return builder.toString();
		
	}
	
}