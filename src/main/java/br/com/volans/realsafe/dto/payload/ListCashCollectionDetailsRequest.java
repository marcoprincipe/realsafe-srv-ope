package br.com.volans.realsafe.dto.payload;

import java.io.Serializable;

/**
 * DTO para chamada do serviço para pesquisa de recolhimento de numerário.
 * 
 * @author Volans Informática Ltda.
 */

public class ListCashCollectionDetailsRequest implements Serializable {

	/**
	 * Declaração da serial version.
	 */
	
	private static final long serialVersionUID = -5466834018543147688L;

	/**
	 * Declaração das variáveis membro.
	 */

	private String cashCollectionNsu;

	/**
	 * @return the cashCollectionNsu
	 */
	public String getCashCollectionNsu() {
		return cashCollectionNsu;
	}

	/**
	 * @param cashCollectionNsu the cashCollectionNsu to set
	 */
	public void setCashCollectionNsu(String cashCollectionNsu) {
		this.cashCollectionNsu = cashCollectionNsu;
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();
		
		builder.append("ListCashCollectionDetailsRequest [cashCollectionNsu=");
		builder.append(cashCollectionNsu);
		builder.append("]");
		
		return builder.toString();
		
	}
	
}
