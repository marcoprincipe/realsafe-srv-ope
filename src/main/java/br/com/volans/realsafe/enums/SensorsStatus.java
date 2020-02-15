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
	
	SENSORS_OK (0, "sensors.ok"),
	SENSORS_NOT_INITIALIZED (1, "sensors.not.initialized"),
	SENSORS_INVALID_PARMS(2, "sensors.invalid.params"), 
	SENSORS_OPEN_COMM_ERROR(3, "sensors.open.comm.error"), 
	SENSORS_GET_COMM_STATE_ERROR(4, "sensors.get.comm.state.error"), 
	SENSORS_SET_COMM_STATE_ERROR(5, "sensors.set.comm.state.error"), 
	SENSORS_GET_COMM_TIMEOUTS_ERROR(6, "sensors.get.comm.timeouts.error"), 
	SENSORS_SET_COMM_TIMEOUTS_ERROR(7, "sensors.set.comm.timeouts.error"), 
	SENSORS_READ_TIMEOUT(8, "sensors.read.timeout"), 
	SENSORS_ERROR_CREATING_EVENT(9, "sensors.error.creating.event"), 
	SENSORS_COMM_ERROR(10, "sensors.comm.error"), 
	SENSORS_ERROR_CREATING_THREAD(11, "sensors.error.creating.thread"), 
	SENSORS_BUFFER_EMPTY(12, "sensors.buffer.empty"), 
	SENSORS_EVENT_NOT_FOUND(13, "sensors.event.not.found"), 
	SENSORS_INVALID_RESPONSE(14, "sensors.invalid.response"), 
	SENSORS_INVALID_BCC(15, "sensors.invalid.bcc"), 
	SENSORS_COMMAND_ERROR(16, "sensors.command.error"), 
	SENSORS_HARDWARE_NOT_FOUND(17, "sensors.hardware.not.found"), 
	SENSORS_NAK_RECEIVED(18, "sensors.nak.received"), 
	SENSORS_SERVER_NOT_STARTED(50, "sensors.server.not.started"), 
	SENSORS_SERVER_TIMEOUT(51, "sensors.server.timeout"), 
	SENSORS_NOT_IMPLEMENTED(99, "sensors.not.implemented");
	
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
