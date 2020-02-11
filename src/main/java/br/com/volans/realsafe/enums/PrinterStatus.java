package br.com.volans.realsafe.enums;

/**
 * Enumeração com os status de impressoras.
 * 
 * @author Volans Informcática Ltda
 */

public enum PrinterStatus {
	
	/**
	 * Declaração dos status disponíveis.
	 */
	
	ON_LINE (0, "printer.is.online"),
	OFF_LINE (-1, "printer.is.offline"),
	BUSY (-2, "printer.is.busy"),
	JAM(-3, "printer.jam");

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
	
	PrinterStatus(Integer code, String key) {
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
	
	public static PrinterStatus getByCode(Integer code) {
		
		for (PrinterStatus status : PrinterStatus.values()) {
			if (status.getCode() == code) {
				return status;
			}
		}
		
		return null;
		
	}
	
}
