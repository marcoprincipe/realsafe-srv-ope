package br.com.volans.realsafe.dto.payload;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DTO para chamada do serviço para listar os grupos de um usuário.
 * 
 * @author Volans Informática Ltda.
 */

public class ListUserGroupsRequest implements Serializable {

	/**
	 * Declaração da serial version.
	 */
	
	private static final long serialVersionUID = -2455729608585486231L;
	
	/**
	 * Declaração das variáveis membro
	 */

	private BigDecimal groupOwnerId;
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
		
		builder.append("ListUserGroupsRequest [groupOwnerId=");
		builder.append(groupOwnerId);
		builder.append(", userId=");
		builder.append(userId);
		builder.append("]");
		
		return builder.toString();
		
	}
	
}
