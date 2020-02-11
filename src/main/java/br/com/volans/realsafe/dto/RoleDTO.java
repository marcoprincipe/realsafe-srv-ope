package br.com.volans.realsafe.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO para armazenamento dos dados de um perfil.
 * 
 * @author Volans Informática Ltda.
 */

public class RoleDTO implements Serializable {

	/**
	 * Declaração da serial version.
	 */
	
	private static final long serialVersionUID = -6417743051318800847L;
	
	/**
	 * Declaração das variáveis membro.
	 */
	
	private Long roleId;
	private String initial;
	private String name;
	private String status;
	private Date creationDate;

	/**
	 * Construtor default da classe.
	 */
	
	public RoleDTO() {
		super();
	}

	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param roleId
	 * @param initial
	 * @param name
	 * @param status
	 * @param creationDate
	 */

	public RoleDTO(Long roleId, String initial, String name, String status, Date creationDate) {
		this.roleId = roleId;
		this.initial = initial;
		this.name = name;
		this.status = status;
		this.creationDate = creationDate;
	}

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
	 * @return the initial
	 */
	public String getInitial() {
		return initial;
	}

	/**
	 * @param initial the initial to set
	 */
	public void setInitial(String initial) {
		this.initial = initial;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();
		
		builder.append("RoleDTO [roleId=");
		builder.append(roleId);
		builder.append(", initial=");
		builder.append(initial);
		builder.append(", name=");
		builder.append(name);
		builder.append(", status=");
		builder.append(status);
		builder.append(", creationDate=");
		builder.append(creationDate);
		builder.append("]");
		
		return builder.toString();
		
	}	
	
}
