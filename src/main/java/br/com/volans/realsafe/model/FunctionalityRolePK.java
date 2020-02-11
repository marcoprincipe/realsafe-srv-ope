package br.com.volans.realsafe.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Classe para armazenamento dos dados da chave primária de uma funcionalidade de um perfil.
 * 
 * @author Volans Informática Ltda.
 */

@Embeddable
public class FunctionalityRolePK implements Serializable {

	/**
	 * Declaração da serial version.
	 */

	private static final long serialVersionUID = -4087083341076740598L;
	
	/**
	 * Declaração das variáveis membro.
	 */

	@Column(name = "role_id")
	private Long roleId;
	
	@Column(name = "functionality_id")
	private Long functionalityId;

	/**
	 * @return the roleId
	 */
	public Long getRoleId() {
		return roleId;
	}

	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	/**
	 * @return the functionalityId
	 */
	public Long getFunctionalityId() {
		return functionalityId;
	}

	/**
	 * @param functionalityId the functionalityId to set
	 */
	public void setFunctionalityId(Long functionalityId) {
		this.functionalityId = functionalityId;
	}

	@Override
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		
		builder.append("FunctionalityRoleKey [roleId=");
		builder.append(roleId);
		builder.append(", functionalityId=");
		builder.append(functionalityId);
		builder.append("]");

		return builder.toString();
		
	}

}
