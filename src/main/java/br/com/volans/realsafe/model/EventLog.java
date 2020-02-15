package br.com.volans.realsafe.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Classe para armazenamento dos dados dde um log de evento.
 * 
 * @author Volans Informática Ltda
 */

@Entity
@Table(name = "tb_event_log")
public class EventLog implements Serializable {

	/**
	 * Declaração da serial version.
	 */
	
	private static final long serialVersionUID = -5222438715326864642L;
	
	/**
	 * Declaração das variáveis membro.
	 */
	
	@Id
	@Column(name = "nsu_event")
	private String nsuEvent;

	@Column(name = "terminal_id")
	private String terminalId;
	
	@Column(name = "user_id")
	private BigDecimal userId;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_time", insertable = false, updatable = false)
	private Date dateTime;
	
	@Column(name = "event_id")
	private Long eventId;
	
	@Column(name = "event_name")
	private String eventName;
	
	@Column(name = "nsu_transaction")
	private String nsuTransaction;
	
	@Column(name = "result_code")
	private Long resultCode;
	
	@Column(name = "message")
	private String message;
	
	@Column(name = "extra_data")
	private String extraData;
	
	@Column(name = "status", insertable = false)
	private String status;

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
		
		builder.append("EventLog [nsuEvent=");
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
