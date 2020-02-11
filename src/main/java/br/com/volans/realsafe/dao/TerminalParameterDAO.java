package br.com.volans.realsafe.dao;

import java.util.List;

import br.com.volans.realsafe.dto.TerminalParameterDTO;

/**
 * Interface para implementação do DAO de parâmetros do terminal.
 * 
 * @author Volans Informática Ltda.
 */

public interface TerminalParameterDAO {
	
	/**
	 * Seleciona um parâmetro a partir do seu id.
	 * 
	 * @param parameterId - Identificador do parâmetro.
	 * 
	 * @return - DTO com os dados do parâmetro informado.
	 */
	
	TerminalParameterDTO findById(String parameterId);
	
	/**
	 * Lista todos os parâmetros da tabela.
	 * 
	 * @return - Lista de todos os parâmetros da tabela.
	 */
	
	List<TerminalParameterDTO> listAll();

}
