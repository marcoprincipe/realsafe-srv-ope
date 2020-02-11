package br.com.volans.realsafe.dto.payload;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DTO para chamada do serviço para pesquisa de unidades por id de empresas.
 * 
 * @author Volans Informática Ltda
 */

public class ListUnitsByCompanyIdRequest implements Serializable {

	/**
	 * Declaração da serial version
	 */
	
	private static final long serialVersionUID = 2130439727496651568L;
	
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
		
		builder.append("ListUnitsByCompanyIdRequest [companyId=");
		builder.append(companyId);
		builder.append(']');
		
		return builder.toString();
		
	}
	
}
