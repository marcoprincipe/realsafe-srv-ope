package br.com.volans.realsafe.rest;

import java.io.Serializable;

/**
 * Classe para retorno da execução de recursos rest.
 * 
 * @author Volans Informática Ltda
 */

public class RestResponse<T> implements Serializable {

	/**
	 * Declaração da serial version.
	 */
	
	private static final long serialVersionUID = -4148405964177131993L;
	
	/**
	 * Declaração das variáveis membro.
	 */
	
	private Integer code;
	private String message;
	private T data;

	/**
	 * Construtor default da classe.
	 */
	
	public RestResponse() {
		super();
	}
	
	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param message - Mensagem do serviço.
	 */
	
	public RestResponse(String message) {
		this(-1, message);
	}
	
	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param code - Código de resposta do serviço.
	 * @param message - Mensagem do serviço.
	 * @param data - Dados de retorno do serviços
	 */
	
	public RestResponse(Integer code, String message) {
		this(code, message, null);
	}
	
	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param code - Código de resposta do serviço.
	 * @param message - Mensagem do serviço.
	 * @param data - Dados de retorno do serviços
	 */
	
	public RestResponse(Integer code, String message, T data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}
	
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
	 * @return the data
	 */
	public T getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();
		
		builder.append("RestResponse [code=");
		builder.append(code);
		builder.append(", message=");
		builder.append(message);
		builder.append(", data=");
		builder.append(data);
		builder.append(']');
		
		return builder.toString();
		
	}
	
}
