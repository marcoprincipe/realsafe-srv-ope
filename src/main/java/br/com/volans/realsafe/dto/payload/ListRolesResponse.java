package br.com.volans.realsafe.dto.payload;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.volans.realsafe.dto.RoleDTO;

/**
 * DTO para retorno do serviço de lista de funcionalidades operacionais cadastradas.
 * 
 * @author Volans Informática Ltda.
 */

public class ListRolesResponse implements Serializable {

	/**
	 * Declaração da serial version.
	 */

	private static final long serialVersionUID = 9125744591669767094L;

	/**
	 * Declaração das variáveis membro.
	 */

	private List<RoleDTO> roles;
	
	/**
	 * Construtor default da classe.
	 */
	
	public ListRolesResponse() {
		roles = new ArrayList<RoleDTO>();
	}

	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param roles - Lista dos perfis operacionais a serem retornados.
	 */
	
	public ListRolesResponse(List<RoleDTO> roles) {
		this.roles = roles;
	}

	/**
	 * @return the roles
	 */
	public List<RoleDTO> getRoles() {
		return roles;
	}

	/**
	 * @param roles the roles to set
	 */
	public void setRoles(List<RoleDTO> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		
		builder.append("ListRolesResponse [roles=");
		builder.append(roles);
		builder.append(']');
		
		return builder.toString();
		
	}

}
