package br.com.volans.realsafe.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Classe para armazenamento dos dados de uma unidade de usuário.
 * 
 * @author Volans Informática Ltda.
 */

@Entity
@Table(name = "tb_user_unit")
public class UserUnit implements Serializable {

	/**
	 * Declaração da serial version.
	 */
	
	private static final long serialVersionUID = 193221263177735441L;
	
	/**
	 * Declaração das variáveis membro.
	 */
	
	@EmbeddedId
	private UserUnitPK pk;
	
	@Column(name = "role_id")
	private Integer roleId;
	
	@ManyToOne
	@JoinColumn(name = "unit_id", insertable = false, updatable = false)
	private Unit unit;
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "group_owner_id", insertable = false, updatable = false), 
		@JoinColumn(name = "user_id", insertable = false, updatable = false)
	})
	private User user;

	@ManyToOne
	@JoinColumn(name = "role_id", insertable = false, updatable = false)
	private Role role;

	/**
	 * @return the pk
	 */
	public UserUnitPK getPk() {
		return pk;
	}

	/**
	 * @param pk the pk to set
	 */
	public void setPk(UserUnitPK pk) {
		this.pk = pk;
	}

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
	 * @return the unit
	 */
	public Unit getUnit() {
		return unit;
	}

	/**
	 * @param unit the unit to set
	 */
	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();
		
		builder.append("UserUnit [pk=");
		builder.append(pk);
		builder.append(", roleId=");
		builder.append(roleId);
		builder.append(", unit=");
		builder.append(unit);
		builder.append(", user=");
		builder.append(user);
		builder.append(", role=");
		builder.append(role);
		builder.append("]");
		
		return builder.toString();
		
	}
	
}