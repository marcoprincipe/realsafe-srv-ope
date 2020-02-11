package br.com.volans.realsafe.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Classe para armazenamento dos dados de uma funcionalidade de um perfil.
 * 
 * @author Volans Informática Ltda.
 */

@Entity
@Table(name = "tb_functionality_role")
public class FunctionalityRole implements Serializable {

	/**
	 * Declaração da serial version.
	 */
	
	private static final long serialVersionUID = -4020149696942999357L;
	
	/**
	 * Declaração das variáveis membro.
	 */

	@EmbeddedId
	private FunctionalityRolePK pk;
	
	@ManyToOne
	@JoinColumn(name = "role_id", insertable = false, updatable = false)
	private Role role;
	
	@ManyToOne
	@JoinColumn(name = "functionality_id", insertable = false, updatable = false)
	private Functionality functionality;
	
	@Column(name = "show_order")
	private Integer showOrder;
	
	@Column(name = "access_key")
	private String accessKey;

	/**
	 * @return the pk
	 */
	public FunctionalityRolePK getPk() {
		
		if (pk == null) {
			pk = new FunctionalityRolePK();
		}
		
		return pk;
		
	}

	/**
	 * @param pk the pk to set
	 */
	public void setPk(FunctionalityRolePK pk) {
		this.pk = pk;
	}

	/**
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}

	/**
	 * @return the functionality
	 */
	public Functionality getFunctionality() {
		return functionality;
	}

	/**
	 * @param functionality the functionality to set
	 */
	public void setFunctionality(Functionality functionality) {
		this.functionality = functionality;
	}

	/**
	 * @return the showOrder
	 */
	public Integer getShowOrder() {
		return showOrder;
	}

	/**
	 * @param showOrder the showOrder to set
	 */
	public void setShowOrder(Integer showOrder) {
		this.showOrder = showOrder;
	}
	
	/**
	 * @return the accessKey
	 */
	public String getAccessKey() {
		return accessKey;
	}

	/**
	 * @param accessKey the accessKey to set
	 */
	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();
		
		builder.append("FunctionalityRole [pk=");
		builder.append(pk);
		builder.append(", role=");
		builder.append(role);
		builder.append(", functionality=");
		builder.append(functionality);
		builder.append(", showOrder=");
		builder.append(showOrder);
		builder.append(", accessKey=");
		builder.append(accessKey);
		builder.append("]");
		
		return builder.toString();
		
	}
	
}
