package br.com.volans.realsafe.dto.payload;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DTO para chamada do serviço para listar as unidades de um usuário.
 * 
 * @author Volans Informática Ltda.
 */

public class ListUserUnitsRequest implements Serializable {

	/**
	 * Declaração da serial version.
	 */
	
	private static final long serialVersionUID = 8670911951649870985L;

	/**
	 * Declaração das variáveis membro
	 */

	private BigDecimal groupOwnerId;
	private BigDecimal groupId;
	private BigDecimal companyId;
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
		
		builder.append("ListUserUnitsRequest [groupOwnerId=");
		builder.append(groupOwnerId);
		builder.append(", groupId=");
		builder.append(groupId);
		builder.append(", companyId=");
		builder.append(companyId);
		builder.append(", userId=");
		builder.append(userId);
		builder.append("]");
		
		return builder.toString();
		
	}

}
