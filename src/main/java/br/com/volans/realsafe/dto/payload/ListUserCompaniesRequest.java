package br.com.volans.realsafe.dto.payload;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DTO para chamada do serviço para listar as empresas de um usuário.
 * 
 * @author Volans Informática Ltda.
 */

public class ListUserCompaniesRequest implements Serializable {

	/**
	 * Declaração da serial version.
	 */
	
	private static final long serialVersionUID = -1987619798560945494L;

	/**
	 * Declaração das variáveis membro
	 */

	private BigDecimal groupOwnerId;
	private BigDecimal groupId;
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
		
		builder.append("ListUserCompaniesRequest [groupOwnerId=");
		builder.append(groupOwnerId);
		builder.append(", groupId=");
		builder.append(groupId);
		builder.append(", userId=");
		builder.append(userId);
		builder.append("]");
		
		return builder.toString();
		
	}
	
}
