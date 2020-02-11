package br.com.volans.realsafe.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Classe para armazenamento dos dados de parâmetros da aplicação.
 * 
 * @author Volans Informática Ltda
 */

@Entity
@Table(name = "tb_parameter")
public class Parameter implements Serializable {

	/**
	 * Declaração da serial version.
	 */
	
	private static final long serialVersionUID = 4926701031399326987L;
	
	/**
	 * Declaração das variáveis membro.
	 */
	
	@EmbeddedId
	private ParameterPK pk;
	
	@Column(name = "parameter_value")
	private String value;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "creation_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;

	/**
	 * @return the parameterPK
	 */
	public ParameterPK gePk() {
		return pk;
	}

	/**
	 * @param parameterPK the parameterPK to set
	 */
	public void setPk(ParameterPK pk) {
		this.pk = pk;
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
		
		builder.append("Parameter [pk=");
		builder.append(pk);
		builder.append(", value=");
		builder.append(value);
		builder.append(", status=");
		builder.append(status);
		builder.append(", creationDate=");
		builder.append(creationDate);
		builder.append("]");
		
		return builder.toString();
		
	}
	
}
