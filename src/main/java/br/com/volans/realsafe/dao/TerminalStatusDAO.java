package br.com.volans.realsafe.dao;

import br.com.volans.realsafe.dto.TerminalStatusDTO;
import br.com.volans.realsafe.model.TerminalStatus;

/**
 * Interface para implementação do DAO de status de terminais.
 * 
 * @author Volans Informática Ltda
 */

public interface TerminalStatusDAO {
	
	/**
	 * Retorna os dados do status do terminal local.
	 * 
	 * @return - Dados do status do terminal.
	 */
	
	TerminalStatusDTO findSingleLocal();
	
	/**
	 * Retorna os dados do status do terminal informado.
	 * 
	 * @param terminalId - Identificador do terminal.
	 * 
	 * @return - Dados do status do terminal.
	 */
	
	TerminalStatusDTO findByTerminalId(String terminalId);
	
	/**
	 * Atualiza o status do terminal.
	 * 
	 * @param terminalStatus - Objeto com os dados a serem atualizados.
	 * 
	 * @return - Quantidade de linhas atualizadas.
	 */
	
	Integer update(TerminalStatus terminalStatus);

}
