package br.com.volans.realsafe.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO para armazenamento dos dados de uma funcionalidade.
 * 
 * @author Volans Informática Ltda.
 */

public class FunctionalityDTO implements Serializable {

	/**
	 * Declaração da serial version.
	 */
	
	private static final long serialVersionUID = -2866893844438079236L;
	
	/**
	 * Declaração das variáveis membro.
	 */

	private Long functionalityId;
	private String name;
	private String description;
	private String route;
	private String status;
	private Date creationDate;
	private Long parentId;

	/**
	 * Construtor default da classe.
	 */
	
	public FunctionalityDTO() {
		super();
	}

	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param functionalityId
	 * @param name
	 * @param description
	 * @param route
	 * @param status
	 * @param creationDate
	 * @param parentId
	 */

	public FunctionalityDTO(Long functionalityId, String name, String description, 
			String route, String status, Date creationDate, Long parentId) {
		this.functionalityId = functionalityId;
		this.name = name;
		this.description = description;
		this.route = route;
		this.status = status;
		this.creationDate = creationDate;
		this.parentId = parentId;
	}

	/**
	 * @return the functionalityId
	 */
	public Long getFunctionalityId() {
		return functionalityId;
	}

	/**
	 * @param functionalityId the functionalityId to set
	 */
	public void setFunctionalityId(Long functionalityId) {
		this.functionalityId = functionalityId;
	}

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
	 * @return the route
	 */
	public String getRoute() {
		return route;
	}

	/**
	 * @param route the route to set
	 */
	public void setRoute(String route) {
		this.route = route;
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

	/**
	 * @return the parentId
	 */
	public Long getParentId() {
		return parentId;
	}

	/**
	 * @param parentId the parentId to set
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();
		
		builder.append("FunctionalityDTO [functionalityId=");
		builder.append(functionalityId);
		builder.append(", name=");
		builder.append(name);
		builder.append(", description=");
		builder.append(description);
		builder.append(", route=");
		builder.append(route);
		builder.append(", status=");
		builder.append(status);
		builder.append(", creationDate=");
		builder.append(creationDate);
		builder.append(", parentId=");
		builder.append(parentId);
		builder.append("]");
		
		return builder.toString();
		
	}
	
}
