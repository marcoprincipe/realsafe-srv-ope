package br.com.volans.realsafe.dto.payload;

import java.io.Serializable;

/**
 * DTO para retorno do serviço de status de impressora.
 * 
 * @author Volans Informática Ltda
 */

public class GetPrinterStatusResponse implements Serializable {

	/**
	 * Declaração da serial version.
	 */
	
	private static final long serialVersionUID = -34426565735387900L;
	
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
		
		builder.append("GetPrinterStatusResponse [code=");
		builder.append(code);
		builder.append(", description=");
		builder.append(description);
		builder.append(']');
		
		return builder.toString();
		
	}
	
}