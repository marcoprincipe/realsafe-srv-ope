package br.com.volans.realsafe.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Classe para armazenamento dos dados da chave primária de um parâmetro.
 * 
 * @author Volans Informática Ltda
 */

@Embeddable
public class ParameterPK implements Serializable {

	/**
	 * Declaração da serial version.
	 */
	
	private static final long serialVersionUID = 2328151768294133855L;
	
	/**
	 * Declaração das variáveis membro.
	 */
	
	@Column(name = "group_owner_id")
	private BigDecimal groupOwnerId;

	@Column(name = "parameter_id")
	private String parameterId;

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
	 * @return the parameterId
	 */
	public String getParameterId() {
		return parameterId;
	}

	/**
	 * @param parameterId the parameterId to set
	 */
	public void setParameterId(String parameterId) {
		this.parameterId = parameterId;
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();
		
		builder.append("ParameterPK [groupOwnerId=");
		builder.append(groupOwnerId);
		builder.append(", parameterId=");
		builder.append(parameterId);
		builder.append("]");
		
		return builder.toString();
		
	}
	
}
