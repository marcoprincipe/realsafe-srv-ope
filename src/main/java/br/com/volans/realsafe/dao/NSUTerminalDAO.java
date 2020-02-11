package br.com.volans.realsafe.dao;

import br.com.volans.realsafe.dto.NSUTerminalDTO;
import br.com.volans.realsafe.model.NSUTerminal;

/**
 * Interface para implementação do DAO de nsu de terminais.
 * 
 * @author Volans Informática Ltda
 */

public interface NSUTerminalDAO {

	/**
	 * Retorna os dados do nsu do terminal informado.
	 * 
	 * terminalId - Identificador do terminal.
	 * 
	 * @return - Dados do NSU do terminal.
	 */
	
	NSUTerminalDTO select(String terminalId);
	
	/**
	 * Atualiza os dados do nsu do terminal informado.
	 * 
	 * @param nsuTerminal - Dados do NSU a ser atualizado.
	 * 
	 * @return - Quantidade de linhas atualizadas.
	 */
	
	Integer update(NSUTerminal nsuTerminal);

}
