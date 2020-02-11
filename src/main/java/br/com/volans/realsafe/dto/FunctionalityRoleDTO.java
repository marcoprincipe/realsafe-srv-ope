package br.com.volans.realsafe.dto;

import java.io.Serializable;

/**
 * DTO para armazenamento dos dados de uma funcionalidade de um perfil.
 * 
 * @author Volans Informática Ltda.
 */

public class FunctionalityRoleDTO implements Serializable {

	/**
	 * Declaração da serial version.
	 */
	
	private static final long serialVersionUID = -1603367824394504101L;
	
	/**
	 * Declaração das variáveis membro.
	 */

	private Long roleId;
	private String roleInitial;
	private String roleName;
	private Long functionalityId;
	private String functionalityName;
	private String functionalityDescription;
	private String functionalityRoute;
	private Long functionalityParentId;
	private Integer functionalityShowOrder;
	private String functionalityAccessKey;
	
	/**
	 * Construtor default da classe.
	 */
	
	public FunctionalityRoleDTO() {
		super();
	}

	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param roleId
	 * @param roleInitial
	 * @param roleName
	 * @param functionalityId
	 * @param functionalityName
	 * @param functionalityDescription
	 * @param functionalityRoute
	 * @param functionalityParentId
	 * @param functionalityShowOrder
	 * @param functionalityAccessKey
	 */

	public FunctionalityRoleDTO(Long roleId, String roleInitial, String roleName, Long functionalityId,
			String functionalityName, String functionalityDescription, String functionalityRoute,
			Long functionalityParentId, Integer functionalityShowOrder, String functionalityAccessKey) {
		this.roleId = roleId;
		this.roleInitial = roleInitial;
		this.roleName = roleName;
		this.functionalityId = functionalityId;
		this.functionalityName = functionalityName;
		this.functionalityDescription = functionalityDescription;
		this.functionalityRoute = functionalityRoute;
		this.functionalityParentId = functionalityParentId;
		this.functionalityShowOrder = functionalityShowOrder;
		this.functionalityAccessKey = functionalityAccessKey;
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
	 * @return the roleInitial
	 */
	public String getRoleInitial() {
		return roleInitial;
	}

	/**
	 * @param roleInitial the roleInitial to set
	 */
	public void setRoleInitial(String roleInitial) {
		this.roleInitial = roleInitial;
	}

	/**
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * @param roleName the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
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

	/**
	 * @return the functionalityName
	 */
	public String getFunctionalityName() {
		return functionalityName;
	}

	/**
	 * @param functionalityName the functionalityName to set
	 */
	public void setFunctionalityName(String functionalityName) {
		this.functionalityName = functionalityName;
	}

	/**
	 * @return the functionalityDescription
	 */
	public String getFunctionalityDescription() {
		return functionalityDescription;
	}

	/**
	 * @param functionalityDescription the functionalityDescription to set
	 */
	public void setFunctionalityDescription(String functionalityDescription) {
		this.functionalityDescription = functionalityDescription;
	}

	/**
	 * @return the functionalityRoute
	 */
	public String getFunctionalityRoute() {
		return functionalityRoute;
	}

	/**
	 * @param functionalityRoute the functionalityRoute to set
	 */
	public void setFunctionalityRoute(String functionalityRoute) {
		this.functionalityRoute = functionalityRoute;
	}

	/**
	 * @return the functionalityParentId
	 */
	public Long getFunctionalityParentId() {
		return functionalityParentId;
	}

	/**
	 * @param functionalityParentId the functionalityParentId to set
	 */
	public void setFunctionalityParentId(Long functionalityParentId) {
		this.functionalityParentId = functionalityParentId;
	}
	
	/**
	 * @return the functionalityShowOrder
	 */
	public Integer getFunctionalityShowOrder() {
		return functionalityShowOrder;
	}

	/**
	 * @param functionalityShowOrder the functionalityShowOrder to set
	 */
	public void setFunctionalityShowOrder(Integer functionalityShowOrder) {
		this.functionalityShowOrder = functionalityShowOrder;
	}
	
	/**
	 * @return the functionalityAccessKey
	 */
	public String getFunctionalityAccessKey() {
		return functionalityAccessKey;
	}

	/**
	 * @param functionalityAccessKey the functionalityAccessKey to set
	 */
	public void setFunctionalityAccessKey(String functionalityAccessKey) {
		this.functionalityAccessKey = functionalityAccessKey;
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();
		
		builder.append("FunctionalityRoleDTO [roleId=");
		builder.append(roleId);
		builder.append(", roleInitial=");
		builder.append(roleInitial);
		builder.append(", roleName=");
		builder.append(roleName);
		builder.append(", functionalityId=");
		builder.append(functionalityId);
		builder.append(", functionalityName=");
		builder.append(functionalityName);
		builder.append(", functionalityDescription=");
		builder.append(functionalityDescription);
		builder.append(", functionalityRoute=");
		builder.append(functionalityRoute);
		builder.append(", functionalityParentId=");
		builder.append(functionalityParentId);
		builder.append(", functionalityShowOrder=");
		builder.append(functionalityShowOrder);
		builder.append(", functionalityAccessKey=");
		builder.append(functionalityAccessKey);
		builder.append("]");
		
		return builder.toString();
		
	}
	
}