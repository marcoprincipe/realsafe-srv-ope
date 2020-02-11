package br.com.volans.realsafe.enums;

/**
 * Enumeração com as chaves da tabela de parâmetros.
 * 
 * @author Volans Informcática Ltda
 */

public enum RestResponseCodes {
	
	/**
	 * Declaração das chaves dos parâmetros
	 */
	
	UNKNOWN_ERROR(-1, "Erro não previsto"),
	OK(0, "ok"),
	SERVICE_ERROR(1, "Erro de negócio");

	/**
	 * Declaração das variáveis membro
	 */
	
	private Integer code;
	private String description;

	/**
	 * Construtor default da enumeração.
	 * 
	 * @param code - Código do erro.
	 * @param description - Descrição do erro.
	 */
	
	RestResponseCodes(Integer code, String description) {
		this.code = code;
		this.description = description;
	}

	/**
	 * @return the code
	 */
	public Integer getCode() {
		return code;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
}
