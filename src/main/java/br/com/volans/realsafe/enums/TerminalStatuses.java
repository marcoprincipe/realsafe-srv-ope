package br.com.volans.realsafe.enums;

/**
 * Enumeração com os status do terminal.
 * 
 * @author Volans Informcática Ltda
 */

public enum TerminalStatuses {
	
	/**
	 * Declaração dos status disponíveis.
	 */
	
	OPEN ("O", "terminal.is.open"),
	CLOSED ("C", "terminal.is.closed");

	/**
	 * Declaração das variáveis membro.
	 */
	
	private String code;
	private String key;
	
	/**
	 * Construtor default da enumeração.
	 * 
	 * @param code - Código do status.
	 * @param key - Chave do arquivo de mensagens.
	 */
	
	TerminalStatuses(String code, String key) {
		this.code = code;
		this.key = key;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}
	
	/**
	 * Retorna o status a partir do código informado.
	 * 
	 * @param code - Código a ser pesquisado.
	 * 
	 * @return - Objeto com o status encontrado.
	 */
	
	public static TerminalStatuses getByCode(String code) {
		
		for (TerminalStatuses status : TerminalStatuses.values()) {
			if (status.getCode().equalsIgnoreCase(code)) {
				return status;
			}
		}
		
		return null;
		
	}
	
}
