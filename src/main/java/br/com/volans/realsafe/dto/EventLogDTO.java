package br.com.volans.realsafe.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * DTO para armazenamento dos dados de um log de evento.
 * 
 * @author Volans Informática Ltda.
 */

public class EventLogDTO implements Serializable {

	/**
	 * Declaração da serial version.
	 */
	
	private static final long serialVersionUID = -4439338937783784643L;

	/**
	 * Declaração das variáveis membro
	 */

	private String nsuEvent;
	private String terminalId;
	private BigDecimal userId;
	private Date dateTime;
	private Long eventId;
	private String eventName;
	private String nsuTransaction;
	private Long resultCode;
	private String message;
	private String extraData;
	private String status;
	
	/**
	 * Construtor default da classe.
	 */
	
	public EventLogDTO() {
		super();
	}

	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param nsuEvent
	 * @param terminalId
	 * @param userId
	 * @param dateTime
	 * @param eventId
	 * @param eventName
	 * @param nsuTransaction
	 * @param resultCode
	 * @param message
	 * @param extraData
	 * @param status
	 */
	
	public EventLogDTO(String nsuEvent, String terminalId, BigDecimal userId, Date dateTime, Long eventId,
			String eventName, String nsuTransaction, Long resultCode, String message, String extraData, String status) {
		this.nsuEvent = nsuEvent;
		this.terminalId = terminalId;
		this.userId = userId;
		this.dateTime = dateTime;
		this.eventId = eventId;
		this.eventName = eventName;
		this.nsuTransaction = nsuTransaction;
		this.resultCode = resultCode;
		this.message = message;
		this.extraData = extraData;
		this.status = status;
	}

	/**
	 * @return the nsuEvent
	 */
	public String getNsuEvent() {
		return nsuEvent;
	}

	/**
	 * @param nsuEvent the nsuEvent to set
	 */
	public void setNsuEvent(String nsuEvent) {
		this.nsuEvent = nsuEvent;
	}

	/**
	 * @return the terminalId
	 */
	public String getTerminalId() {
		return terminalId;
	}

	/**
	 * @param terminalId the terminalId to set
	 */
	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}

	/**
	 * @return the userId
	 */
	public BigDecimal getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(BigDecimal userId) {
		this.userId = userId;
	}

	/**
	 * @return the dateTime
	 */
	public Date getDateTime() {
		return dateTime;
	}

	/**
	 * @param dateTime the dateTime to set
	 */
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	/**
	 * @return the eventId
	 */
	public Long getEventId() {
		return eventId;
	}

	/**
	 * @param eventId the eventId to set
	 */
	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	/**
	 * @return the eventName
	 */
	public String getEventName() {
		return eventName;
	}

	/**
	 * @param eventName the eventName to set
	 */
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	/**
	 * @return the nsuTransaction
	 */
	public String getNsuTransaction() {
		return nsuTransaction;
	}

	/**
	 * @param nsuTransaction the nsuTransaction to set
	 */
	public void setNsuTransaction(String nsuTransaction) {
		this.nsuTransaction = nsuTransaction;
	}

	/**
	 * @return the resultCode
	 */
	public Long getResultCode() {
		return resultCode;
	}

	/**
	 * @param resultCode the resultCode to set
	 */
	public void setResultCode(Long resultCode) {
		this.resultCode = resultCode;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the extraData
	 */
	public String getExtraData() {
		return extraData;
	}

	/**
	 * @param extraData the extraData to set
	 */
	public void setExtraData(String extraData) {
		this.extraData = extraData;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();
		
		builder.append("EventLogDTO [nsuEvent=");
		builder.append(nsuEvent);
		builder.append(", terminalId=");
		builder.append(terminalId);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", dateTime=");
		builder.append(dateTime);
		builder.append(", eventId=");
		builder.append(eventId);
		builder.append(", eventName=");
		builder.append(eventName);
		builder.append(", nsuTransaction=");
		builder.append(nsuTransaction);
		builder.append(", resultCode=");
		builder.append(resultCode);
		builder.append(", message=");
		builder.append(message);
		builder.append(", extraData=");
		builder.append(extraData);
		builder.append(", status=");
		builder.append(status);
		builder.append("]");
		
		return builder.toString();
		
	}

}
