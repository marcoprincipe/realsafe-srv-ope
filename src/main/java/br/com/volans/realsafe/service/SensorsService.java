package br.com.volans.realsafe.service;

import br.com.volans.realsafe.exception.ServiceLayerException;

/**
 * Interface para implementação dos serviços de placa de sensores.
 * 
 * @author Volans Informática Ltda
 */

public interface SensorsService {
	
	/**
	 * Efetua a abertura da placa de sensores.
	 * 
	 * @return - Resultado da operação. 
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócios.
	 */
	
	Integer open() throws ServiceLayerException;
	
	/**
	 * Efetua o fechamento da placa de sensores.
	 * 
	 * @return - Resultado da operação. 
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócios.
	 */
	
	Integer close() throws ServiceLayerException;
	
	/**
	 * Habilita os sensores.
	 * 
	 * @return - Resultado da operação. 
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócios.
	 */
	
	Integer enableSensors() throws ServiceLayerException;
	
	/**
	 * Desabilita os sensores.
	 * 
	 * @return - Resultado da operação. 
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócios.
	 */
	
	Integer disableSensors() throws ServiceLayerException;
	
	/**
	 * Inicializa os sensores.
	 * 
	 * @return - Resultado da operação. 
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócios.
	 */
	
	Integer resetSensors() throws ServiceLayerException;
	
	/**
	 * Recupera o status dos sensores.
	 * 
	 * @return - Resultado da operação. 
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócios.
	 */
	
	Integer getSensors(byte[] sensors) throws ServiceLayerException;
	
	/**
	 * Recupera o flag de alteração dos sensores.
	 * 
	 * @return - Resultado da operação. 
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócios.
	 */
	
	Boolean sensorsChanged() throws ServiceLayerException;
	
	/**
	 * Grava a máscara do sensor informado.
	 * 
	 * @param sensor - Identificador do sensor.
	 * @param mask - Máscara a ser utilizada.
	 * 
	 * @return - Resultado da operação. 
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócios.
	 */
	
	Integer writeMaskByte(int sensor, int mask) throws ServiceLayerException;
	
	/**
	 * Recupera a máscara do sensor informado.
	 * 
	 * @param sensor - Identificador do sensor.
	 * @param mask - Máscara configurada.
	 * 
	 * @return - Resultado da operação. 
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócios.
	 */
	
	Integer readMaskByte(int sensor, int[] mask) throws ServiceLayerException;

}
