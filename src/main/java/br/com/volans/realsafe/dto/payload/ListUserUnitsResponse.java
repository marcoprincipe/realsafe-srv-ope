package br.com.volans.realsafe.dto.payload;

import java.io.Serializable;
import java.util.List;

import br.com.volans.realsafe.dto.UserUnitDTO;

/**
 * DTO para retorno do serviço para pesquisa de unidades de usuários.
 * 
 * @author Volans Informática Ltda.
 */

public class ListUserUnitsResponse implements Serializable {

	/**
	 * Declaração da serial version.
	 */
	
	private static final long serialVersionUID = -8704067488323672747L;

	/**
	 * Declaração das variáveis membro.
	 */

	private List<UserUnitDTO> userUnits;

	/**
	 * Construtor default da classe.
	 */
	
	public ListUserUnitsResponse() {
		super();
	}

	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param userUnits - Lista das unidades do usuário.
	 */
	
	public ListUserUnitsResponse(List<UserUnitDTO> userUnits) {
		this.userUnits = userUnits;
	}

	/**
	 * @return the userUnits
	 */
	public List<UserUnitDTO> getUserUnits() {
		return userUnits;
	}

	/**
	 * @param userUnits the userUnits to set
	 */
	public void setUserUnits(List<UserUnitDTO> userUnits) {
		this.userUnits = userUnits;
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();
		
		builder.append("ListUserUnitsResponse [userUnits=");
		builder.append(userUnits);
		builder.append("]");
		
		return builder.toString();
		
	}

}