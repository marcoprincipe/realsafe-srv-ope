package br.com.volans.realsafe.enums;

/**
 * Enumeração com os códigos de log de eventos.
 * 
 * @author Volans Informcática Ltda.
 */

public enum EventLogs {
	
	/**
	 * Declaração dos status disponíveis.
	 */
	
	EVENT_INITIALIZATION(1L, "event.initialization"),
	EVENT_LOGIN(2L, "event.login"),
	EVENT_OPEN_TERMINAL(3L, "event.open.terminal"),
	EVENT_DEPOSIT(4L, "event.deposit"),
	EVENT_CASH_COLLECTION(5L, "event.cash.collection"),
	EVENT_CLOSE_TERMINAL(6L, "event.close.terminal"),
	EVENT_CHANGE_PASSWORD(7L, "event.change.password"),
	EVENT_CHECK_SENSORS(99L, "event.check.sensors"),
	
	SENSORS_OK(-3000L, "sensors.ok"),
	SENSORS_POUCH_PRESENT (-3001L, "pouch.present"),
	SENSORS_POUCH_NOT_PRESENT (-3002L, "pouch.not.present"),
	SENSORS_SAFE_DOOR_CLOSED (-3003L, "safe.door.closed"),
	SENSORS_SAFE_DOOR_OPEN (-3004L, "safe.door.open"),
	SENSORS_NO_VIBRATION_DETECTED (-3005L, "no.vibration.detected"),
	SENSORS_VIBRATION_DETECTED(-3006L, "vibration.detected");

	/**
	 * Declaração das variáveis membro.
	 */
	
	private Long code;
	private String key;
	
	/**
	 * Construtor default da enumeração.
	 * 
	 * @param code - Código do status.
	 * @param key - Chave do arquivo de mensagens.
	 */
	
	EventLogs(Long code, String key) {
		this.code = code;
		this.key = key;
	}

	/**
	 * @return the code
	 */
	public Long getCode() {
		return code;
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}
	
	/**
	 * Retorna o evento de log a partir do código informado.
	 * 
	 * @param code - Código a ser pesquisado.
	 * 
	 * @return - Objeto com o evento do log encontrado.
	 */
	
	public static EventLogs getByCode(Long code) {
		
		for (EventLogs eventLog : EventLogs.values()) {
			if (eventLog.getCode() == code) {
				return eventLog;
			}
		}
		
		return null;
		
	}
	

}
