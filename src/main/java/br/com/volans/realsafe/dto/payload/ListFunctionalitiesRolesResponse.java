package br.com.volans.realsafe.dto.payload;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.volans.realsafe.dto.FunctionalityRoleDTO;

/**
 * DTO para retorno do serviço de lista de funcionalidades X perfis operacionais cadastradas.
 * 
 * @author Volans Informática Ltda.
 */

public class ListFunctionalitiesRolesResponse implements Serializable {

	/**
	 * Declaração da serial version.
	 */

	private static final long serialVersionUID = 5982419846370410196L;

	/**
	 * Declaração das variáveis membro.
	 */

	private List<FunctionalityRoleDTO> functionalitiesRoles;
	
	/**
	 * Construtor default da classe.
	 */
	
	public ListFunctionalitiesRolesResponse() {
		functionalitiesRoles = new ArrayList<FunctionalityRoleDTO>();
	}

	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param functionalities - Lista das funcionalidades operacionais a serem retornados.
	 */
	
	public ListFunctionalitiesRolesResponse(List<FunctionalityRoleDTO> functionalitiesRoles) {
		this.functionalitiesRoles = functionalitiesRoles;
	}

	/**
	 * @return the functionalitiesRoles
	 */
	public List<FunctionalityRoleDTO> getFunctionalitiesRoes() {
		return functionalitiesRoles;
	}

	/**
	 * @param functionalitiesRoles the functionalitiesRoles to set
	 */
	public void setFunctionalitiesRoles(List<FunctionalityRoleDTO> functionalitiesRoles) {
		this.functionalitiesRoles = functionalitiesRoles;
	}

	@Override
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		
		builder.append("ListFunctionalitiesRolesOpeResponse [functionalitiesRoles=");
		builder.append(functionalitiesRoles);
		builder.append(']');
		
		return builder.toString();
		
	}

}
