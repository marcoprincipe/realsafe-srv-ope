package br.com.volans.realsafe.service.impl;

import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.volans.realsafe.driver.depository.DepositoryDriver;
import br.com.volans.realsafe.driver.depository.dto.DepositoryCountDTO;
import br.com.volans.realsafe.driver.depository.dto.DepositoryStatusDTO;
import br.com.volans.realsafe.enums.DepositoryStatus;
import br.com.volans.realsafe.enums.MessageKeys;
import br.com.volans.realsafe.exception.ServiceLayerException;
import br.com.volans.realsafe.service.AbstractService;
import br.com.volans.realsafe.service.DepositoryService;

/**
 * Implementação da interface dos serviços de depositários.
 * 
 * @author Volans Informática Ltda
 */

@Service
public class DepositoryServiceImpl extends AbstractService implements DepositoryService {
	
	/**
	 * Declaração das variáveis membro
	 */
	
	private DepositoryDriver depositoryDriver;
	
	/**
	 * Construtor default da classe.
	 * 
	 * @param depositoryDriver - Instância do driver do depositário a ser utilizado. 
	 */
	
	@Autowired
	public DepositoryServiceImpl(
			DepositoryDriver depositoryDriver) {
		this.depositoryDriver = depositoryDriver;
	}
	
	/**
	 * Efetua a abertura do depositário.
	 * 
	 * @return - Resultado da operação. 
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	@Override
	public Integer open() throws ServiceLayerException {
		
		Integer code = depositoryDriver.open();

		if (code != 0) {
			
			DepositoryStatus status = DepositoryStatus.getByCode(code);
			
			if (status == null) {
				throw new ServiceLayerException(String.format(getMessage(MessageKeys.DEPOSITORY_STATUS_CODE_NOT_FOUND.getKey()), code));
			}
			
			throw new ServiceLayerException(String.format(getMessage(MessageKeys.OPEN_DEPOSITORY_FAILED.getKey()), getMessage(status.getKey())));

		}
		
		return code;
		
	}
	
	/**
	 * Efetua o fechamento do depositário.
	 * 
	 * @return - Resultado da operação. 
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	@Override
	public Integer close() throws ServiceLayerException {
		
		Integer code = depositoryDriver.close();
		
		if (code != 0) {
			
			DepositoryStatus status = DepositoryStatus.getByCode(code);
			
			if (status == null) {
				throw new ServiceLayerException(String.format(getMessage(MessageKeys.DEPOSITORY_STATUS_CODE_NOT_FOUND.getKey()), code));
			}
			
			throw new ServiceLayerException(String.format(getMessage(MessageKeys.CLOSE_DEPOSITORY_FAILED.getKey()), getMessage(status.getKey())));

		}
		
		return code;
		
	}
	
	/**
	 * Efetua a verificação do depositário.
	 * 
	 * @return - Resultado da verificação. 
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	@Override
	public Integer check() throws ServiceLayerException {
		
		DepositoryStatusDTO result = depositoryDriver.getStatus();
		
		return result.getCode();
		
	}
	
	/**
	 * Efetua o fechamento do depositário.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	@PreDestroy
	public void cleanup() throws ServiceLayerException {

		close();
		
	}
	
	/**
	 * Retorna o status do depositário.
	 * 
	 * @return - Objeto com o status do depositário. 
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	@Override
	public DepositoryStatusDTO getStatus() throws ServiceLayerException {
		
		/*
		DepositoryStatusDTO result = depositoryDriver.getStatus();
		
		DepositoryStatus status = DepositoryStatus.getByCode(result.getCode());
		
		if (status == null) {
			throw new ServiceLayerException(getMessage(MessageKeys.DEPOSITORY_STATUS_CODE_NOT_FOUND.getKey()));
		}
		
		result.setCode(status.getCode());
		result.setDescription(getMessage(status.getKey()));
		*/

		DepositoryStatusDTO result = new DepositoryStatusDTO();

		result.setCode(0);
		result.setDescription("OK");
		
		return result;
		
	}
	
	/**
	 * Inicializa o depositário.
	 * 
	 * @return
	 * 
	 * @throws ServiceLayerException
	 */
	
	@Override
	public Integer startDeposit() throws ServiceLayerException {
		
		Integer result = depositoryDriver.startDeposit();
		
		return result;
		
	}
	
	/**
	 * Efetua o depósito do valor informado.
	 * 
	 * @return - Resultado do depósito.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	@Override
	public Integer deposit() throws ServiceLayerException {
		
		Integer result = depositoryDriver.deposit(10000);
		
		return result;
		
	}
	
	/**
	 * Finaliza a operação de depósito.
	 * 
	 * @param request - Dados para efetuar o depósito.
	 * 
	 * @return - Objeto com os dados do depósito.
	 * 
	 * @throws ServiceLayerException
	 */
	
	@Override
	public DepositoryCountDTO endDeposit() throws ServiceLayerException {
		
		DepositoryCountDTO result = depositoryDriver.endDeposit();
		
		return result;
		
	}
	
	/**
	 * Efetua a inicialização do depositário.
	 * 
	 * @return - Resultado da inicialização. 
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	@Override
	public Integer reset() throws ServiceLayerException {
		return depositoryDriver.reset();
	}

}
