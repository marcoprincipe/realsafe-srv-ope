package br.com.volans.realsafe.dao;

import br.com.volans.realsafe.dto.TerminalDTO;

/**
 * Interface para implementação do DAO de terminais.
 * 
 * @author Volans Informática Ltda
 */

public interface TerminalDAO {

	/**
	 * Pesquisa pelo terminal a partir do identificador informado.
	 * 
	 * @param terminalId - Identificador do terminal.
	 * 
	 * @return - Dados do terminal.
	 */
	
	TerminalDTO findById(String terminalId);

	/**
	 * Inclui um novo terminal na tabela.
	 * 
	 * @param terminalDTO - Dados do terminal a ser incluido.
	 * 
	 * @return - Dados do terminal incluido.
	 */
	
	TerminalDTO crate(TerminalDTO terminalDTO);

	/**
	 * Pesquisa pelo único terminal da tabela local.
	 * 
	 * @return - Dados do terminal.
	 */
	
	TerminalDTO findSingleLocal();

}
