package br.com.volans.realsafe.dto.payload;

import java.io.Serializable;
import java.util.List;

import br.com.volans.realsafe.dto.UserCompanyDTO;

/**
 * DTO para retorno do serviço para pesquisa de empresas de usuários.
 * 
 * @author Volans Informática Ltda.
 */

public class ListUserCompaniesResponse implements Serializable {

	/**
	 * Declaração da serial version.
	 */
	
	private static final long serialVersionUID = 8533731061135164971L;

	/**
	 * Declaração das variáveis membro.
	 */

	private List<UserCompanyDTO> userCompanies;

	/**
	 * Construtor default da classe.
	 */
	
	public ListUserCompaniesResponse() {
		super();
	}

	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param userCompanies - Lista das empresas do usuário.
	 */
	
	public ListUserCompaniesResponse(List<UserCompanyDTO> userCompanies) {
		this.userCompanies = userCompanies;
	}

	/**
	 * @return the userCompanies
	 */
	public List<UserCompanyDTO> getUserCompanies() {
		return userCompanies;
	}

	/**
	 * @param userCompanies the userCompanies to set
	 */
	public void setUserCompanies(List<UserCompanyDTO> userCompanies) {
		this.userCompanies = userCompanies;
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();
		
		builder.append("ListUserCompaniesResponse [userCompanies=");
		builder.append(userCompanies);
		builder.append("]");
		
		return builder.toString();
		
	}
	
}