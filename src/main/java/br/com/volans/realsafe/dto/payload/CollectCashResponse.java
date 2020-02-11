package br.com.volans.realsafe.dto.payload;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO para retorno do serviço de coleta no recolhimento de numerário.
 * 
 * @author Volans Informática Ltda.
 */

public class CollectCashResponse implements Serializable {

	/**
	 * Declaração da serial version.
	 */
	
	private static final long serialVersionUID = 5198037570033719706L;

	/**
	 * Declaração das variáveis membro.
	 */

	private Integer rowsAffected;
	private Date dateTime;
	private String nsuTerminal;
	
	/**
	 * Construtor default da classe.
	 */
	
	public CollectCashResponse() {
	}

	/**
	 * @return the rowsAffected
	 */
	public Integer getRowsAffected() {
		return rowsAffected;
	}

	/**
	 * @param rowsAffected the rowsAffected to set
	 */
	public void setRowsAffected(Integer rowsAffected) {
		this.rowsAffected = rowsAffected;
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
	 * @return the nsuTerminal
	 */
	public String getNsuTerminal() {
		return nsuTerminal;
	}

	/**
	 * @param nsuTerminal the nsuTerminal to set
	 */
	public void setNsuTerminal(String nsuTerminal) {
		this.nsuTerminal = nsuTerminal;
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();
		
		builder.append("CollectCashResponse [rowsAffected=");
		builder.append(rowsAffected);
		builder.append(", dateTime=");
		builder.append(dateTime);
		builder.append(", nsuTerminal=");
		builder.append(nsuTerminal);
		builder.append("]");
		
		return builder.toString();
		
	}
	
}
