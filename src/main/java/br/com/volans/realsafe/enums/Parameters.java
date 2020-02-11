package br.com.volans.realsafe.enums;

/**
 * Enumeração com as chaves da tabela de parâmetros.
 * 
 * @author Volans Informcática Ltda
 */

public enum Parameters {
	
	/**
	 * Declaração das chaves dos parâmetros
	 */
	
	MAX_LOGIN_RETRIES("max.login.retries", "Quantidade máxima de tentativas de login");

	/**
	 * Declaração das variáveis membro
	 */
	
	private String parameterId;
	private String description;

	/**
	 * Construtor default da enumeração.
	 * 
	 * @param parameterId - Identificador único do parâmetro.
	 * @param description - Descrição do parâmetro.
	 */
	
	Parameters(String parameterId, String description) {
		this.parameterId = parameterId;
		this.description = description;
	}

	/**
	 * @return the parameterId
	 */
	public String getParameterId() {
		return parameterId;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
}
