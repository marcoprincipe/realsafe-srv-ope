package br.com.volans.realsafe.dto.payload;

import java.io.Serializable;

import br.com.volans.realsafe.dto.CompanyDTO;

/**
 * DTO para retorno do serviço para pesquisa de empresas por id.
 * 
 * @author Volans Informática Ltda.
 */

public class FindCompanyByIdResponse implements Serializable {

	/**
	 * Declaração da serial version.
	 */
	
	private static final long serialVersionUID = 7723894283542371656L;
	
	/**
	 * Declaração das variáveis membro.
	 */

	private CompanyDTO company;

	/**
	 * Construtor default da classe.
	 */
	
	public FindCompanyByIdResponse() {
		company = new CompanyDTO();
	}

	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param company - Dados da empresa a ser retornada.
	 */
	
	public FindCompanyByIdResponse(CompanyDTO company) {
		this.company = company;
	}

	/**
	 * @return the company
	 */
	public CompanyDTO getCompany() {
		return company;
	}

	/**
	 * @param company the company to set
	 */
	public void setCompany(CompanyDTO company) {
		this.company = company;
	}

	@Override
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		
		builder.append("FindCompanyByIdResponse [company=");
		builder.append(company);
		builder.append(']');
		
		return builder.toString();
	
	}
	
}
