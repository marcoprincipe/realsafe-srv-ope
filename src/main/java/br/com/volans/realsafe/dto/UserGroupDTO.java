package br.com.volans.realsafe.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DTO para armazenamento dos dados de um grupo de um usuário.
 * 
 * @author Volans Informática Ltda.
 */

public class UserGroupDTO implements Serializable {

	/**
	 * Declaração da serial version.
	 */
	
	private static final long serialVersionUID = -7497621369073816925L;
	
	/**
	 * Declaração das variáveis membro.
	 */

	private BigDecimal groupId;
	private String groupName;
	private BigDecimal userId;
	private String userName;
	private Long roleId;
	private String roleInitial;
	private String roleName;
	
	/**
	 * Construtor default da classe.
	 */
	
	public UserGroupDTO() {
		super();
	}
	
	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param groupId
	 * @param groupName
	 * @param userId
	 * @param userName
	 * @param roleId
	 * @param roleInitial
	 * @param roleName
	 */
	
	public UserGroupDTO(BigDecimal groupId, String groupName, BigDecimal userId, String userName, Long roleId,
			String roleInitial, String roleName) {
		this.groupId = groupId;
		this.groupName = groupName;
		this.userId = userId;
		this.userName = userName;
		this.roleId = roleId;
		this.roleInitial = roleInitial;
		this.roleName = roleName;
	}

	/**
	 * @return the groupId
	 */
	public BigDecimal getGroupId() {
		return groupId;
	}
	
	/**
	 * @param groupId the groupId to set
	 */
	public void setGroupId(BigDecimal groupId) {
		this.groupId = groupId;
	}
	
	/**
	 * @return the groupName
	 */
	public String getGroupName() {
		return groupName;
	}
	
	/**
	 * @param groupName the groupName to set
	 */
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	/**
	 * @return the userId
	 */
	public BigDecimal getUserId() {
		return userId;
	}
	
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(BigDecimal userId) {
		this.userId = userId;
	}
	
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
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

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();
		
		builder.append("UserGroupDTO [groupId=");
		builder.append(groupId);
		builder.append(", groupName=");
		builder.append(groupName);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", userName=");
		builder.append(userName);
		builder.append(", roleId=");
		builder.append(roleId);
		builder.append(", roleInitial=");
		builder.append(roleInitial);
		builder.append(", roleName=");
		builder.append(roleName);
		builder.append("]");
		
		return builder.toString();
		
	}
	
}
