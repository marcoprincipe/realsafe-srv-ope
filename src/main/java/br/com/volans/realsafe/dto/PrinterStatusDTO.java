package br.com.volans.realsafe.dto;

import java.io.Serializable;

/**
 * DTO para armazenamento dos dados de status de impressoras.
 * 
 * @author Volans Informática Ltda.
 */

public class PrinterStatusDTO implements Serializable {

	/**
	 * Declaração da serial version.
	 */
	
	private static final long serialVersionUID = -5827342317657741045L;
	
	/**
	 * Declaração das variáveis membro.
	 */

	private Integer code;
	private String description;
	
	/**
	 * @return the code
	 */
	public Integer getCode() {
		return code;
	}
	
	/**
	 * @param code the code to set
	 */
	public void setCode(Integer code) {
		this.code = code;
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

	@Override
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		
		builder.append("PrinterStatusDTO [code=");
		builder.append(code);
		builder.append(", description=");
		builder.append(description);
		builder.append(']');
		
		return builder.toString();
		
	}
	
}
