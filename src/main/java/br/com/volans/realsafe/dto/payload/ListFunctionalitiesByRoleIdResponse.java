package br.com.volans.realsafe.dto.payload;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.volans.realsafe.dto.FunctionalityRoleDTO;

/**
 * DTO para retorno do serviço de lista de funcionalidades de perfis.
 * 
 * @author Volans Informática Ltda
 */

public class ListFunctionalitiesByRoleIdResponse implements Serializable {

	/**
	 * Declaração da serial version.
	 */
	
	private static final long serialVersionUID = -3077753659604165197L;
	
	/**
	 * Declaração das variáveis membro.
	 */

	private List<FunctionalityRoleDTO> functionalitiesRole;
	
	/**
	 * Construtor default da classe.
	 */
	
	public ListFunctionalitiesByRoleIdResponse() {
		functionalitiesRole = new ArrayList<FunctionalityRoleDTO>();
	}	

	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param functionalitiesRole - Lista das funcionalidades do perfil a serem retornados.
	 */
	
	public ListFunctionalitiesByRoleIdResponse(List<FunctionalityRoleDTO> functionalitiesRole) {
		this.functionalitiesRole = functionalitiesRole;
	}

	/**
	 * @return the functionalitiesRole
	 */
	public List<FunctionalityRoleDTO> getFunctionalitiesRole() {
		return functionalitiesRole;
	}

	/**
	 * @param functionalitiesRole the functionalitiesRole to set
	 */
	public void setFunctionalitiesRole(List<FunctionalityRoleDTO> functionalitiesRole) {
		this.functionalitiesRole = functionalitiesRole;
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();
		
		builder.append("ListFunctionalitiesByRoleIdResponse [functionalitiesRole=");
		builder.append(functionalitiesRole);
		builder.append("]");
		
		return builder.toString();
		
	}	
	
}
