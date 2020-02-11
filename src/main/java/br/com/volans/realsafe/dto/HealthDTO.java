package br.com.volans.realsafe.dto;

import java.io.Serializable;

/**
 * DTO para armazenamento dos dados de uma checagem.
 * 
 * @author Volans Informática Ltda.
 */

public class HealthDTO implements Serializable {

	/**
	 * Declaração da serial version.
	 */
	
	private static final long serialVersionUID = -7207317275734105305L;
	
	/**
	 * Declaração das variáveis membro.
	 */
	
	private String name;
	private String version;
	private String timestamp;
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}
	
	/**
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}
	
	/**
	 * @return the timestamp
	 */
	public String getTimestamp() {
		return timestamp;
	}

	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		
		builder.append("HealthDTO [name=");
		builder.append(name);
		builder.append(", version=");
		builder.append(version);
		builder.append(", timestamp=");
		builder.append(timestamp);
		builder.append(']');
		
		return builder.toString();
		
	}
	
}
