package br.com.volans.realsafe.dto.payload;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.volans.realsafe.dto.CompanyDTO;

/**
 * DTO para retorno do serviço de lista de grupos de proprietarios de grupos
 * 
 * @author Volans Informática Ltda
 */

public class ListCompanyByGroupOwnerIdResponse implements Serializable {

	/**
	 * Declaração da serial version.
	 */
	
	private static final long serialVersionUID = 752769690739666742L;
	
	/**
	 * Declaração das variáveis membro.
	 */

	private List<CompanyDTO> companies;
	
	/**
	 * Construtor default da classe.
	 */
	
	public ListCompanyByGroupOwnerIdResponse() {
		companies = new ArrayList<CompanyDTO>();
	}

	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param companies - Lista de empresas de proprietários de grupos a serem retornados.
	 */
	
	public ListCompanyByGroupOwnerIdResponse(List<CompanyDTO> companies) {
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
		
		builder.append("ListCompanyByGroupOwnerIdResponse [companies=");
		builder.append(companies);
		builder.append(']');
		
		return builder.toString();
		
	}
}
