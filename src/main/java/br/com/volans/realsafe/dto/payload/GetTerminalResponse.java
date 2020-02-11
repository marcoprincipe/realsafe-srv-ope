package br.com.volans.realsafe.dto.payload;

import java.io.Serializable;

import br.com.volans.realsafe.dto.TerminalDTO;

/**
 * DTO para retorno do serviço da pesquisa de terminais.
 * 
 * @author Volans Informática Ltda.
 */

public class GetTerminalResponse implements Serializable {

	/**
	 * Declaração da serial version.
	 */
	
	private static final long serialVersionUID = -1099255374198715609L;
	
	/**
	 * Declaração das variáveis membro.
	 */

	private TerminalDTO terminal;

	/**
	 * Construtor default da classe.
	 */
	
	public GetTerminalResponse() {
		terminal = new TerminalDTO();
	}

	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param terminal - Dados do terminal a ser retornado.
	 */
	
	public GetTerminalResponse(TerminalDTO terminal) {
		this.terminal = terminal;
	}

	/**
	 * @return the terminal
	 */
	public TerminalDTO getTerminal() {
		return terminal;
	}

	/**
	 * @param terminal the terminal to set
	 */
	public void setTerminal(TerminalDTO terminal) {
		this.terminal = terminal;
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();
		
		builder.append("GetTerminalResponse [terminal=");
		builder.append(terminal);
		builder.append("]");
		
		return builder.toString();
		
	}
	
}
