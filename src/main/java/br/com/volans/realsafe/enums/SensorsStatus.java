package br.com.volans.realsafe.enums;

/**
 * Enumeração com os status de placas de sensores.
 * 
 * @author Volans Informcática Ltda
 */

public enum SensorsStatus {
	
	/**
	 * Declaração dos status disponíveis.
	 */
	
	ON_LINE (0, "sensors.is.online"),
	OFF_LINE (-1, "sensors.is.offline");

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
	
	SensorsStatus(Integer code, String key) {
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
	
	public static SensorsStatus getByCode(Integer code) {
		
		for (SensorsStatus status : SensorsStatus.values()) {
			if (status.getCode() == code) {
				return status;
			}
		}
		
		return null;
		
	}
	
}
