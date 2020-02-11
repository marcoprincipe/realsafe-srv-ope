package br.com.volans.realsafe.enums;

/**
 * Enumeração com os status das transações.
 * 
 * @author Volans Informcática Ltda
 */

public enum TransactionStatuses {
	
	/**
	 * Declaração dos status disponíveis.
	 */
	
	PENDENT ("P", "transaction.not.collected"),
	COLLECTED ("C", "transaction.collected");

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
	
	TransactionStatuses(String code, String key) {
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
	
	public static TransactionStatuses getByCode(String code) {
		
		for (TransactionStatuses status : TransactionStatuses.values()) {
			if (status.getCode().equalsIgnoreCase(code)) {
				return status;
			}
		}
		
		return null;
		
	}
	
}
