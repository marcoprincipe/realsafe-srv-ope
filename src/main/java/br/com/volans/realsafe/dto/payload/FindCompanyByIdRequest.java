package br.com.volans.realsafe.dto.payload;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DTO para chamada do serviço para pesquisa de empresas por id.
 * 
 * @author Volans Informática Ltda.
 */

public class FindCompanyByIdRequest implements Serializable {

	/**
	 * Declaração da serial version.
	 */
	
	private static final long serialVersionUID = 1999061610377469667L;
	
	/**
	 * Declaração das variáveis membro
	 */
	
	private BigDecimal companyId;

	/**
	 * @return the companyId
	 */
	public BigDecimal getCompanyId() {
		return companyId;
	}

	/**
	 * @param companyId the companyId to set
	 */
	public void setCompanyId(BigDecimal companyId) {
		this.companyId = companyId;
	}

	@Override
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		
		builder.append("FindCompanyByIdRequest [companyId=");
		builder.append(companyId);
		builder.append(']');
		
		return builder.toString();
		
	}

}
