package br.com.volans.realsafe.dto.payload;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.volans.realsafe.dto.TerminalParameterDTO;

/**
 * DTO para retorno do serviço de lista de parâmetros do terminal.
 * 
 * @author Volans Informática Ltda.
 */

public class ListTerminalParametersResponse implements Serializable {

	/**
	 * Declaração da serial version.
	 */
	
	private static final long serialVersionUID = 678459246045114876L;

	/**
	 * Declaração das variáveis membro.
	 */
	
	private List<TerminalParameterDTO> parameters;

	/**
	 * Construtor default da classe.
	 */
	
	public ListTerminalParametersResponse() {
		parameters = new ArrayList<TerminalParameterDTO>();
	}

	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param parameters
	 */
	
	public ListTerminalParametersResponse(List<TerminalParameterDTO> parameters) {
		this.parameters = parameters;
	}

	/**
	 * @return the parameters
	 */
	public List<TerminalParameterDTO> getParameters() {
		return parameters;
	}

	/**
	 * @param parameters the parameters to set
	 */
	public void setParameters(List<TerminalParameterDTO> parameters) {
		this.parameters = parameters;
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();
		
		builder.append("ListTerminalParametersResponse [parameters=");
		builder.append(parameters);
		builder.append("]");
		
		return builder.toString();
		
	}
	
}
