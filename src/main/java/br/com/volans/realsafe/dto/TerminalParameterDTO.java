package br.com.volans.realsafe.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO para armazenamento dos dados de um parâmetro do terminal.
 * 
 * @author Volans Informática Ltda.
 */

public class TerminalParameterDTO implements Serializable {

	/**
	 * Declaração da serial version.
	 */

	private static final long serialVersionUID = 9114395667820321636L;
	
	/**
	 * Declaração das variáveis membro.
	 */

	private String parameterId;
	private String parameterValue;
	private String description;
	private String status;
	private Date creationDate;
	
	/**
	 * Construtor default da classe.
	 */
	
	public TerminalParameterDTO() {
		super();
	}

	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param parameterId
	 * @param parameterValue
	 * @param description
	 * @param status
	 * @param creationDate
	 */
	public TerminalParameterDTO(String parameterId, String parameterValue, String description, String status,
			Date creationDate) {
		this.parameterId = parameterId;
		this.parameterValue = parameterValue;
		this.description = description;
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
	 * @return the parameterValue
	 */
	public String getParameterValue() {
		return parameterValue;
	}

	/**
	 * @param parameterValue the parameterValue to set
	 */
	public void setParameterValue(String parameterValue) {
		this.parameterValue = parameterValue;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
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
		
		builder.append("TerminalParameterDTO [parameterId=");
		builder.append(parameterId);
		builder.append(", parameterValue=");
		builder.append(parameterValue);
		builder.append(", description=");
		builder.append(description);
		builder.append(", status=");
		builder.append(status);
		builder.append(", creationDate=");
		builder.append(creationDate);
		builder.append("]");
		
		return builder.toString();
		
	}
	
}
