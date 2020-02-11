package br.com.volans.realsafe.service;

import br.com.volans.realsafe.dto.PrinterStatusDTO;
import br.com.volans.realsafe.exception.ServiceLayerException;

/**
 * Interface para implementação dos serviços de impressora.
 * 
 * @author Volans Informática Ltda
 */

public interface PrinterService {
	
	/**
	 * Efetua a abertura da impressora.
	 * 
	 * @return - Resultado da operação. 
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	Integer open() throws ServiceLayerException;
	
	/**
	 * Efetua o fechamento da impressora.
	 * 
	 * @return - Resultado da operação. 
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	Integer close() throws ServiceLayerException;
	
	/**
	 * Efetua a verificação da impressora.
	 * 
	 * @return - Resultado da verificação. 
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	Integer check() throws ServiceLayerException;
	
	/**
	 * Retorna o status da impressora.
	 * 
	 * @return - Objeto com o status da impressora. 
	 * 
	 * @throws PrinterException - Exceção da impressora.
	 */
	
	PrinterStatusDTO getStatus() throws ServiceLayerException;
	
	/**
	 * Efetua a impressão dos dados informados.
	 * 
	 * @param buffer - Dados a serem impressos.
	 * 
	 * @return - Resultado da impressão.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	Integer print(byte[] buffer) throws ServiceLayerException;
	
	/**
	 * Efetua o corte do papel.
	 * 
	 * @return - Resultado do corte do papel.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	Integer cut() throws ServiceLayerException;
	
	/**
	 * Efetua a inicialização da impressora.
	 * 
	 * @return - Resultado da inicialização. 
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	Integer reset() throws ServiceLayerException;

}
