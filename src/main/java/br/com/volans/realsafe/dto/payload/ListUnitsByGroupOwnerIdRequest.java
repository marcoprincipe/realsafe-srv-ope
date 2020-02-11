package br.com.volans.realsafe.dto.payload;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DTO para chamada do serviço para pesquisa de unidades por proprietário de grupos.
 * 
 * @author Volans Informática Ltda
 */

public class ListUnitsByGroupOwnerIdRequest implements Serializable {

	/**
	 * Declaração da serial version
	 */
	
	private static final long serialVersionUID = -9037662208035702534L;

	/**
	 * Declaração das variáveis membro
	 */
	
	private BigDecimal groupOwnerId;

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

	@Override
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		
		builder.append("ListUnitsByGroupOwnerIdRequest [groupOwnerId=");
		builder.append(groupOwnerId);
		builder.append(']');
		
		return builder.toString();
		
	}
	
}
