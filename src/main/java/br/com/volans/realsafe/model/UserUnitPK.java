package br.com.volans.realsafe.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Classe para armazenamento dos dados da chave primária de uma unidade de usuário.
 * 
 * @author Volans Informática Ltda
 */

@Embeddable
public class UserUnitPK implements Serializable {

	/**
	 * Declaração da serial version.
	 */

	private static final long serialVersionUID = -3315332023844471928L;
	
	/**
	 * Declaração das variáveis membro.
	 */

	@Column(name = "group_owner_id")
	private BigDecimal groupOwnerId;

	@Column(name = "unit_id")
	private BigDecimal unitId;
	
	@Column(name = "user_id")
	private BigDecimal userId;

	/**
	 * @return the groupOwnerId
	 */
	public BigDecimal getGroupOwnerId() {
		return groupOwnerId;
	}

	/**
	 * @param groupOwnerId the groupOwnerId to set
	 */
	public void setGroupOwnerId(BigDecimal groupOwnerId) {
		this.groupOwnerId = groupOwnerId;
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

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();
		
		builder.append("UserUnitPK [groupOwnerId=");
		builder.append(groupOwnerId);
		builder.append(", unitId=");
		builder.append(unitId);
		builder.append(", userId=");
		builder.append(userId);
		builder.append("]");
		
		return builder.toString();
		
	}

}
