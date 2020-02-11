package br.com.volans.realsafe.service;

import br.com.volans.realsafe.dto.HealthDTO;
import br.com.volans.realsafe.exception.SystemException;

/**
 * Interface para implementação do serviço de checagem do banco de dados.
 * 
 * @author Volans Informática Ltda.
 */

public interface HealthService {
	
	/**
	 * Efetua a validação do estado da aplicação.
	 * 
	 * @return - Objeto com os dados da verificação.
	 * 
	 * @throws SystemException - Exceção do sistema.
	 */
	
	HealthDTO checkHealth() throws SystemException;

}
