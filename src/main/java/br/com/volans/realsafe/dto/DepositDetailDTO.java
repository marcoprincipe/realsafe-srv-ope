package br.com.volans.realsafe.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DTO para armazenamento dos dados de um detalhe de depósito.
 * 
 * @author Volans Informática Ltda.
 */

public class DepositDetailDTO implements Serializable {

	/**
	 * Declaração da serial version.
	 */
	
	private static final long serialVersionUID = -587735267684201530L;
	
	/**
	 * Declaração das variáveis membro.
	 */

	private Long quantity;
	private BigDecimal amount;
	
	/**
	 * Construtor default da classe
	 */
	
	public DepositDetailDTO() {
		super();
	}
	
	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param quantity
	 * @param amount
	 */

	public DepositDetailDTO(Long quantity, BigDecimal amount) {
		this.quantity = quantity;
		this.amount = amount;
	}

	/**
	 * @return the quantity
	 */
	public Long getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the amount
	 */
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();
		
		builder.append("DepositDetailDTO [quantity=");
		builder.append(quantity);
		builder.append(", amount=");
		builder.append(amount);
		builder.append("]");
		
		return builder.toString();
		
	}
	
}
