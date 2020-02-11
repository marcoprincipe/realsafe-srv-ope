package br.com.volans.realsafe.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Classe para armazenamento dos dados da chave primária do detalhe de um depósito.
 * 
 * @author Volans Informática Ltda.
 */

@Embeddable
public class DepositDetailPK implements Serializable {

	/**
	 * Declaração da serial version.
	 */

	private static final long serialVersionUID = 1697175285226711980L;
	
	/**
	 * Declaração das variáveis membro.
	 */
	
	@Column(name = "nsu_terminal")
	private String nsuTerminal;
	
	@Column(name = "include_order")
	private Integer includeOrder;

	/**
	 * @return the nsuTerminal
	 */
	public String getNsuTerminal() {
		return nsuTerminal;
	}

	/**
	 * @param nsuTerminal the nsuTerminal to set
	 */
	public void setNsuTerminal(String nsuTerminal) {
		this.nsuTerminal = nsuTerminal;
	}

	/**
	 * @return the includeOrder
	 */
	public Integer getIncludeOrder() {
		return includeOrder;
	}

	/**
	 * @param includeOrder the includeOrder to set
	 */
	public void setIncludeOrder(Integer includeOrder) {
		this.includeOrder = includeOrder;
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();
		
		builder.append("DepositDetailPK [nsuTerminal=");
		builder.append(nsuTerminal);
		builder.append(", includeOrder=");
		builder.append(includeOrder);
		builder.append("]");
		
		return builder.toString();
		
	}
	
}
