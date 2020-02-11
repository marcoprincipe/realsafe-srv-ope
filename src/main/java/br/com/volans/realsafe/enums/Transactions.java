package br.com.volans.realsafe.enums;

/**
 * Enumeração com as transações da aplicação.
 * 
 * @author Volans Informcática Ltda
 */

public enum Transactions {
	
	/**
	 * Declaração das transações disponíveis.
	 */
	
	OPENING(1L, "Abertura contábil"),
	CLOSING(2L, "Fechamento contábil"),
	DEPOSIT(3L, "Depósito de valores"),
	CASH_COLLECTION(10L, "Recolhimento de numerário");

	/**
	 * Declaração das variáveis membro.
	 */
	
	private Long code;
	private String description;
	
	/**
	 * Construtor default da enumeração.
	 * 
	 * @param code - Código da transação.
	 * @param description - Descrição da transação.
	 */
	
	Transactions(Long code, String description) {
		this.code = code;
		this.description = description;
	}

	/**
	 * @return the code
	 */
	public Long getCode() {
		return code;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
}
