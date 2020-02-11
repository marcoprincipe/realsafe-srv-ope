package br.com.volans.realsafe.dto.payload;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.volans.realsafe.dto.CompanyDTO;

/**
 * DTO para retorno do serviço de lista de empresas cadastradas.
 * 
 * @author Volans Informática Ltda
 */

public class ListCompaniesResponse implements Serializable {

	/**
	 * Declaração da serial version.
	 */
	
	private static final long serialVersionUID = 1474357802085762103L;
	
	/**
	 * Declaração das variáveis membro.
	 */

	private List<CompanyDTO> companies;
	
	/**
	 * Construtor default da classe.
	 */
	
	public ListCompaniesResponse() {
		companies = new ArrayList<CompanyDTO>();
	}

	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param companies - Lista das empresas a serem retornados.
	 */
	
	public ListCompaniesResponse(List<CompanyDTO> companies) {
		this.companies = companies;
	}

	/**
	 * @return the companies
	 */
	public List<CompanyDTO> getCompanies() {
		return companies;
	}

	/**
	 * @param companies the companies to set
	 */
	public void setCompanies(List<CompanyDTO> companies) {
		this.companies = companies;
	}

	@Override
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		
		builder.append("ListCompaniesResponse [companies=");
		builder.append(companies);
		builder.append(']');
		
		return builder.toString();
		
	}

}
