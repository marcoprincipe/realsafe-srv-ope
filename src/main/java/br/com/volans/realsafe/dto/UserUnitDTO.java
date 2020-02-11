package br.com.volans.realsafe.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DTO para armazenamento dos dados de uma unidade de um usuário.
 * 
 * @author Volans Informática Ltda.
 */

public class UserUnitDTO implements Serializable {

	/**
	 * Declaração da serial version.
	 */
	
	private static final long serialVersionUID = 1612689138674837457L;
	
	/**
	 * Declaração das variáveis membro.
	 */

	private BigDecimal groupId;
	private String groupName;
	private BigDecimal companyId;
	private String companyName;
	private BigDecimal unitId;
	private String unitName;
	private BigDecimal userId;
	private String userName;
	private Long roleId;
	private String roleInitial;
	private String roleName;
	
	/**
	 * Construtor default da classe.
	 */

	public UserUnitDTO() {
		super();
	}
	
	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param groupId
	 * @param groupName
	 * @param companyId
	 * @param companyName
	 * @param unitId
	 * @param unitName
	 * @param userId
	 * @param userName
	 * @param roleId
	 * @param roleInitial
	 * @param roleName
	 */
	public UserUnitDTO(BigDecimal groupId, String groupName, BigDecimal companyId, String companyName,
			BigDecimal unitId, String unitName, BigDecimal userId, String userName, Long roleId, String roleInitial,
			String roleName) {
		this.groupId = groupId;
		this.groupName = groupName;
		this.companyId = companyId;
		this.companyName = companyName;
		this.unitId = unitId;
		this.unitName = unitName;
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
	 * @return the companyId
	 */
	public BigDecimal getCompanyId() {
		return companyId;
	}
	
	/**
	 * @param companyId the companyId to set
	 */
	public void setCompanyId(BigDecimal companyId) {
		this.companyId = companyId;
	}
	
	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}
	
	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	/**
	 * @return the unitId
	 */
	public BigDecimal getUnitId() {
		return unitId;
	}
	
	/**
	 * @param unitId the unitId to set
	 */
	public void setUnitId(BigDecimal unitId) {
		this.unitId = unitId;
	}
	
	/**
	 * @return the unitName
	 */
	public String getUnitName() {
		return unitName;
	}
	
	/**
	 * @param unitName the unitName to set
	 */
	public void setUnitName(String unitName) {
		this.unitName = unitName;
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

}
