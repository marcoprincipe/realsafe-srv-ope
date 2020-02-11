package br.com.volans.realsafe.service;

import java.util.List;

import br.com.volans.realsafe.dto.TerminalParameterDTO;
import br.com.volans.realsafe.exception.ServiceLayerException;

/**
 * Interface para implementação dos serviços de parâmetros do terminal.
 * 
 * @author Volans Informática Ltda.
 */

public interface TerminalParameterService {
	
	/**
	 * Seleciona um parâmetro a partir do seu id.
	 * 
	 * @param parameterId - Identificador do parâmetro.
	 * 
	 * @return - DTO com os dados do parâmetro informado.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	TerminalParameterDTO findById(String parameterId) throws ServiceLayerException;
	
	/**
	 * Lista todos os parâmetros da tabela.
	 * 
	 * @return - Lista de todos os parâmetros da tabela.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	List<TerminalParameterDTO> listAll() throws ServiceLayerException;

}
