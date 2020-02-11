package br.com.volans.realsafe.dto.payload;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DTO para chamada do serviço para pesquisa de grupos por id.
 * 
 * @author Volans Informática Ltda
 */

public class FindGroupByIdRequest implements Serializable {

	/**
	 * Declaração da serial version
	 */
	
	private static final long serialVersionUID = -4967460183692263771L;
	
	/**
	 * Declaração das variáveis membro
	 */
	
	private BigDecimal groupId;

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

	@Override
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		
		builder.append("FindGroupByIdRequest [groupId=");
		builder.append(groupId);
		builder.append("]");
		
		return builder.toString();
		
	}
	
}
