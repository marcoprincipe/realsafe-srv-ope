package br.com.volans.realsafe.service;

import br.com.volans.realsafe.driver.depository.dto.DepositoryCountDTO;
import br.com.volans.realsafe.driver.depository.dto.DepositoryStatusDTO;
import br.com.volans.realsafe.exception.ServiceLayerException;

/**
 * Interface para implementação dos serviços de depositários.
 * 
 * @author Volans Informática Ltda
 */

public interface DepositoryService {
	
	/**
	 * Efetua a abertura do depositário.
	 * 
	 * @return - Resultado da operação. 
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	Integer open() throws ServiceLayerException;
	
	/**
	 * Efetua o fechamento do depositário.
	 * 
	 * @return - Resultado da operação. 
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	Integer close() throws ServiceLayerException;
	
	/**
	 * Efetua a verificação do depositário.
	 * 
	 * @return - Resultado da verificação. 
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	Integer check() throws ServiceLayerException;
	
	/**
	 * Retorna o status do depositário.
	 * 
	 * @return - Objeto com o status do depositário. 
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	DepositoryStatusDTO getStatus() throws ServiceLayerException;
	
	/**
	 * Inicializa a operação de depósito.
	 * 
	 * @return
	 * 
	 * @throws ServiceLayerException
	 */
	
	Integer startDeposit() throws ServiceLayerException;
	
	/**
	 * Efetua o depósito do valor informado.
	 * 
	 * @return - Resultado do depósito.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	Integer deposit() throws ServiceLayerException;
	
	/**
	 * Finaliza a operação de depósito.
	 * 
	 * @return - Objeto com os dados do depósito.
	 * 
	 * @throws ServiceLayerException
	 */
	
	DepositoryCountDTO endDeposit() throws ServiceLayerException;
	
	/**
	 * Efetua a inicialização do depositário.
	 * 
	 * @return - Resultado da inicialização. 
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	Integer reset() throws ServiceLayerException;

}
