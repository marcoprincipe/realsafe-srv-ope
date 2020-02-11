package br.com.volans.realsafe.service;

import br.com.volans.realsafe.dto.TerminalStatusDTO;
import br.com.volans.realsafe.exception.ServiceLayerException;

/**
 * Interface para implementação dos serviços de status de terminais.
 * 
 * @author Volans Informática Ltda.
 */

public interface TerminalStatusService {

	/**
	 * Recupera os dados do status terminal local.
	 * 
	 * @return - Dados do status terminal local.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	TerminalStatusDTO getLocalTerminalStatus() throws ServiceLayerException;

}
