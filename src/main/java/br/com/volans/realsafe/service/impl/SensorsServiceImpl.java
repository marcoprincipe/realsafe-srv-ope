package br.com.volans.realsafe.service.impl;

import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.volans.realsafe.driver.sensors.SensorsDriver;
import br.com.volans.realsafe.enums.MessageKeys;
import br.com.volans.realsafe.enums.SensorsStatus;
import br.com.volans.realsafe.exception.ServiceLayerException;
import br.com.volans.realsafe.service.AbstractService;
import br.com.volans.realsafe.service.SensorsService;

/**
 * Implementação da interface dos serviços de placa de sensores.
 * 
 * @author Volans Informática Ltda.
 */

@Service
public class SensorsServiceImpl extends AbstractService implements SensorsService {
	
	/**
	 * Declaração das variáveis membro
	 */
	
	private SensorsDriver sensorsDriver;
	
	/**
	 * Construtor default da classe.
	 * 
	 * @param sensorsDriver - Instância do driver da placa de sensores a ser utilizada. 
	 */
	
	@Autowired
	public SensorsServiceImpl(SensorsDriver sensorsDriver) {
		this.sensorsDriver = sensorsDriver;
	}
	
	/**
	 * Efetua a abertura da placa de sensores.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */

	public Integer open() throws ServiceLayerException {
		
		Integer code = sensorsDriver.open();

		if (code != 0) {
			
			SensorsStatus status = SensorsStatus.getByCode(code);
			
			if (status == null) {
				throw new ServiceLayerException(String.format(getMessage(MessageKeys.SENSORS_STATUS_CODE_NOT_FOUND.getKey()), code));
			}
			
			throw new ServiceLayerException(String.format(getMessage(MessageKeys.OPEN_SENSORS_FAILED.getKey()), getMessage(status.getKey())));

		}
		
		code = enableSensors();
		
		return code;
		
	}
	
	/**
	 * Efetua o fechamento da placa de sensores.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	@PreDestroy
	public Integer close() throws ServiceLayerException {
		
		disableSensors();
		
		Integer code = sensorsDriver.close();
		
		if (code != 0) {
			
			SensorsStatus status = SensorsStatus.getByCode(code);
			
			if (status == null) {
				throw new ServiceLayerException(String.format(getMessage(MessageKeys.SENSORS_STATUS_CODE_NOT_FOUND.getKey()), code));
			}
			
			throw new ServiceLayerException(String.format(getMessage(MessageKeys.CLOSE_SENSORS_FAILED.getKey()), getMessage(status.getKey())));

		}
		
		return code;

	}
	
	/**
	 * Efetua o fechamento da placa de sensores.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	@PreDestroy
	public void cleanup() throws ServiceLayerException {
		
		close();
		
	}
	
	/**
	 * Habilita os sensores.
	 * 
	 * @return - Resultado da operação. 
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócios.
	 */
	
	@Override
	public Integer enableSensors() throws ServiceLayerException {

		Integer code = sensorsDriver.enableSensors();
		
		if (code != 0) {
			
			SensorsStatus status = SensorsStatus.getByCode(code);
			
			if (status == null) {
				throw new ServiceLayerException(String.format(getMessage(MessageKeys.SENSORS_STATUS_CODE_NOT_FOUND.getKey()), code));
			}
			
			throw new ServiceLayerException(String.format(getMessage(MessageKeys.ENABLE_SENSORS_FAILED.getKey()), getMessage(status.getKey())));

		}

		return code;
		
	}
	
	/**
	 * Desabilita os sensores.
	 * 
	 * @return - Resultado da operação. 
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócios.
	 */
	
	@Override
	public Integer disableSensors() throws ServiceLayerException {

		Integer code = sensorsDriver.disableSensors();
		
		if (code != 0) {
			
			SensorsStatus status = SensorsStatus.getByCode(code);
			
			if (status == null) {
				throw new ServiceLayerException(String.format(getMessage(MessageKeys.SENSORS_STATUS_CODE_NOT_FOUND.getKey()), code));
			}
			
			throw new ServiceLayerException(String.format(getMessage(MessageKeys.DISABLE_SENSORS_FAILED.getKey()), getMessage(status.getKey())));

		}

		return code;
		
	}
	
	/**
	 * Inicializa os sensores.
	 * 
	 * @return - Resultado da operação. 
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócios.
	 */
	
	@Override
	public Integer resetSensors() throws ServiceLayerException {

		Integer code = sensorsDriver.resetSensors();
		
		if (code != 0) {
			
			SensorsStatus status = SensorsStatus.getByCode(code);
			
			if (status == null) {
				throw new ServiceLayerException(String.format(getMessage(MessageKeys.SENSORS_STATUS_CODE_NOT_FOUND.getKey()), code));
			}
			
			throw new ServiceLayerException(String.format(getMessage(MessageKeys.RESET_SENSORS_FAILED.getKey()), getMessage(status.getKey())));

		}

		return code;
		
	}
	
	/**
	 * Recupera o status dos sensores.
	 * 
	 * @return - Resultado da operação. 
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócios.
	 */
	
	@Override
	public Integer getSensors(byte[] sensors) throws ServiceLayerException {

		Integer code = sensorsDriver.getSensors(sensors);
		
		if (code != 0) {
			
			SensorsStatus status = SensorsStatus.getByCode(code);
			
			if (status == null) {
				throw new ServiceLayerException(String.format(getMessage(MessageKeys.SENSORS_STATUS_CODE_NOT_FOUND.getKey()), code));
			}
			
			throw new ServiceLayerException(String.format(getMessage(MessageKeys.GET_SENSORS_FAILED.getKey()), getMessage(status.getKey())));

		}

		return code;
		
	}
	
	/**
	 * Recupera o flag de alteração dos sensores.
	 * 
	 * @return - Resultado da operação. 
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócios.
	 */
	
	@Override
	public Boolean sensorsChanged() throws ServiceLayerException {

		Boolean result = sensorsDriver.sensorsChanged();

		return result;
		
	}
	
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
	
	@Override
	public Integer writeMaskByte(int sensor, int mask) throws ServiceLayerException {

		Integer code = sensorsDriver.writeMaskByte(sensor, mask);
		
		if (code != 0) {
			
			SensorsStatus status = SensorsStatus.getByCode(code);
			
			if (status == null) {
				throw new ServiceLayerException(String.format(getMessage(MessageKeys.SENSORS_STATUS_CODE_NOT_FOUND.getKey()), code));
			}
			
			throw new ServiceLayerException(String.format(getMessage(MessageKeys.WRITE_MASK_FAILED.getKey()), getMessage(status.getKey())));

		}

		return code;
		
	}
	
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
	
	@Override
	public Integer readMaskByte(int sensor, int[] mask) throws ServiceLayerException {

		Integer code = sensorsDriver.readMaskByte(sensor, mask);
		
		if (code != 0) {
			
			SensorsStatus status = SensorsStatus.getByCode(code);
			
			if (status == null) {
				throw new ServiceLayerException(String.format(getMessage(MessageKeys.SENSORS_STATUS_CODE_NOT_FOUND.getKey()), code));
			}
			
			throw new ServiceLayerException(String.format(getMessage(MessageKeys.READ_MASK_FAILED.getKey()), getMessage(status.getKey())));

		}

		return code;
		
	}

}
