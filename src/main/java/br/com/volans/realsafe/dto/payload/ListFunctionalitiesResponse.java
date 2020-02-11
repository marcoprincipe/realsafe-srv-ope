package br.com.volans.realsafe.dto.payload;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.volans.realsafe.dto.FunctionalityDTO;

/**
 * DTO para retorno do serviço de lista de funcionalidades operacionais cadastradas.
 * 
 * @author Volans Informática Ltda.
 */

public class ListFunctionalitiesResponse implements Serializable {

	/**
	 * Declaração da serial version.
	 */
	
	private static final long serialVersionUID = -4593959093076349787L;

	/**
	 * Declaração das variáveis membro.
	 */

	private List<FunctionalityDTO> functionalities;
	
	/**
	 * Construtor default da classe.
	 */
	
	public ListFunctionalitiesResponse() {
		functionalities = new ArrayList<FunctionalityDTO>();
	}

	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param functionalities - Lista das funcionalidades operacionais a serem retornados.
	 */
	
	public ListFunctionalitiesResponse(List<FunctionalityDTO> functionalities) {
		this.functionalities = functionalities;
	}

	/**
	 * @return the functionalities
	 */
	public List<FunctionalityDTO> getFunctionalities() {
		return functionalities;
	}

	/**
	 * @param functionalities the functionalities to set
	 */
	public void setFunctionalities(List<FunctionalityDTO> functionalities) {
		this.functionalities = functionalities;
	}

	@Override
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		
		builder.append("ListFunctionalitiesOpeResponse [functionalities=");
		builder.append(functionalities);
		builder.append(']');
		
		return builder.toString();
		
	}

}
