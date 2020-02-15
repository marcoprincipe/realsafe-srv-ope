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
	
	PRINTER_OK (0, "printer.ok"),
	PRINTER_LOW_PAPER (101, "printer.low.paper"),
	PRINTER_OUT_OF_PAPER (102, "printer.out.of.paper"),
	PRINTER_OFF_LINE (103, "printer.off.line"),
	PRINTER_TURNED_OFF (104, "printer.turned.off"),
	PRINTER_BUSY (105, "printer.busy"),
	PRINTER_DISCONNECTED_CABLE (106, "printer.disconnected.cable"),
	PRINTER_PRESENTER_ERROR (107, "printer.presenter.error"),
	PRINTER_INVALID_BMP_FILE (108, "printer.invalid.bmp.file"),
	PRINTER_PAPER_JAM(109, "printer.paper.jam");

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
