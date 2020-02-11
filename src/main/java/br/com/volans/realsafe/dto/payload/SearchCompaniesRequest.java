
package br.com.volans.realsafe.dto.payload;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Classe para armazenamento dos dados para pesquisa de empresas
 * 
 * @author Volans Informática Ltda.
 */

public class SearchCompaniesRequest implements Serializable {
	
	/**
	 * Declaração da serial version.
	 */
	
	private static final long serialVersionUID = 2166259589464556746L;
	
	/**
	 *  Declaração das variáveis membro
	 */
	
	private BigDecimal groupId;
	
	/**
	 *  Construtor default da classe
	 */
	public SearchCompaniesRequest() {
	}

	/**
	 * @return the groupId
	 */
	public BigDecimal getGroupId() {
		return groupId;
	}

	/**
	 * @param groupId the groupId to set
	 */
	public void setGroupId(BigDecimal groupId) {
		this.groupId = groupId;
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();
		
		builder.append("SearchCompaniesRequest [groupId=");
		builder.append(groupId);
		builder.append("]");
		
		return builder.toString();
		
	}
	
}
