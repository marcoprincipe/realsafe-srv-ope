package br.com.volans.realsafe.enums;

/**
 * Enumeração com os status de depositários.
 * 
 * @author Volans Informcática Ltda
 */

public enum DepositoryStatus {
	
	/**
	 * Declaração dos status disponíveis.
	 */
	
	OFF_LINE(-1, "depository.is.offline"),
	ON_LINE(0, "depository.is.online");

	/**
	 * Declaração das variáveis membro.
	 */
	
	private Integer code;
	private String key;
	
	/**
	 * Construtor default da enumeração.
	 * 
	 * @param code - Código do status.
	 * @param key - Chave do arquivo de mensagens.
	 */
	
	DepositoryStatus(Integer code, String key) {
		this.code = code;
		this.key = key;
	}

	/**
	 * @return the code
	 */
	public Integer getCode() {
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
	
	public static DepositoryStatus getByCode(Integer code) {
		
		for (DepositoryStatus status : DepositoryStatus.values()) {
			if (status.getCode() == code) {
				return status;
			}
		}
		
		return null;
		
	}
	
}
