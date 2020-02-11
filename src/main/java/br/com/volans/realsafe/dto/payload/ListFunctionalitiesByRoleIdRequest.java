package br.com.volans.realsafe.dto.payload;

import java.io.Serializable;

/**
 * DTO para chamada do serviço para pesquisa de funcionalidades por perfil.
 * 
 * @author Volans Informática Ltda
 */

public class ListFunctionalitiesByRoleIdRequest implements Serializable {

	/**
	 * Declaração da serial version
	 */
	
	private static final long serialVersionUID = -4078139018925797422L;
	
	/**
	 * Declaração das variáveis membro
	 */
	
	private Integer roleId;
	private Integer parentId;
	
	/**
	 * @return the roleId
	 */
	public Integer getRoleId() {
		return roleId;
	}
	
	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	
	/**
	 * @return the parentId
	 */
	public Integer getParentId() {
		return parentId;
	}
	
	/**
	 * @param parentId the parentId to set
	 */
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	@Override
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		
		builder.append("ListFunctionalitiesByRoleIdRequest [roleId=");
		builder.append(roleId);
		builder.append(", parentId=");
		builder.append(parentId);
		builder.append("]");
		
		return builder.toString();
		
	}
	
}
