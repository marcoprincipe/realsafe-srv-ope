package br.com.volans.realsafe.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Classe para armazenamento dos dados dos detalhes de um depósito.
 * 
 * @author Volans Informática Ltda
 */

@Entity
@Table(name = "tb_deposit_detail")
public class DepositDetail implements Serializable {

	/**
	 * Declaração da serial version.
	 */

	private static final long serialVersionUID = 7650446387661514722L;
	
	/**
	 * Declaração das variáveis membro.
	 */

	@EmbeddedId
	private DepositDetailPK pk;
	
	@Column(name = "quantity")
	private Integer quantity;
	
	@Column(name = "amount")
	private BigDecimal amount;

	/**
	 * @return the pk
	 */
	public DepositDetailPK getPk() {
		return pk;
	}

	/**
	 * @param pk the pk to set
	 */
	public void setPk(DepositDetailPK pk) {
		this.pk = pk;
	}

	/**
	 * @return the quantity
	 */
	public Integer getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(Integer quantity) {
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
		
		builder.append("DepositDetail [pk=");
		builder.append(pk);
		builder.append(", quantity=");
		builder.append(quantity);
		builder.append(", amount=");
		builder.append(amount);
		builder.append("]");
		
		return builder.toString();
		
	}
	
}
