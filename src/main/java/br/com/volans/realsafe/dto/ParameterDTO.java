package br.com.volans.realsafe.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO para armazenamento dos dados de um parâmetro.
 * 
 * @author Volans Informática Ltda
 */

public class ParameterDTO implements Serializable {

	/**
	 * Declaração da serial version
	 */
	
	private static final long serialVersionUID = 6302496972563382219L;
	
	/**
	 * Declaração das variáveis membro.
	 */
	
	private String parameterId;
	private String value;
	private String status;
	private Date creationDate;
	
	/**
	 * Construtor default da classe.
	 */
	
	public ParameterDTO() {
		super();
	}
	
	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param parameterId - Identificador do parâmetro.
	 * @param value - Valor do parâmetro.
	 * @param status - Status do parâmetro.
	 * @param creationDate - Data de criação do parâmetro.
	 */
	
	public ParameterDTO(String parameterId, String value, String status, Date creationDate) {
		this.parameterId = parameterId;
		this.value = value;
		this.status = status;
		this.creationDate = creationDate;
	}

	/**
	 * @return the parameterId
	 */
	public String getParameterId() {
		return parameterId;
	}
	
	/**
	 * @param parameterId the parameterId to set
	 */
	public void setParameterId(String parameterId) {
		this.parameterId = parameterId;
	}
	
	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	
	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
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
	
	/**
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		
		builder.append("ParameterDTO [parameterId=");
		builder.append(parameterId);
		builder.append(", value=");
		builder.append(value);
		builder.append(", status=");
		builder.append(status);
		builder.append(", creationDate=");
		builder.append(creationDate);
		builder.append(']');
		
		return builder.toString();
		
	}

}
