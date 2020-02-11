package br.com.volans.realsafe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.volans.realsafe.driver.depository.dto.DepositoryCountDTO;
import br.com.volans.realsafe.driver.depository.dto.DepositoryStatusDTO;
import br.com.volans.realsafe.enums.RestResponseCodes;
import br.com.volans.realsafe.exception.ServiceLayerException;
import br.com.volans.realsafe.rest.RestResponse;
import br.com.volans.realsafe.service.DepositoryService;

/**
 * Controller dos serviços de depositários.
 * 
 * @author Volans Informática Ltda
 */

@RestController
@RequestMapping("/api/v1/depository")
public class DepositoryController {

	/**
	 * Declaração das variáveis membro
	 */
	
	private DepositoryService depositoryService;
	
	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param printerService - Instância do serviço de depositários.
	 */
	
	@Autowired
	public DepositoryController(DepositoryService depositoryService) {
		this.depositoryService = depositoryService;
	}
	
	/**
	 * Efetua a abertura do depositário.
	 * 
	 * @return - Resultado da operação. 
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	@RequestMapping(path = "/open", method = RequestMethod.GET)
	public ResponseEntity<RestResponse<Integer>> open() {

		Integer result = depositoryService.open();
		
		RestResponse<Integer> restResponse = 
				new RestResponse<Integer>(RestResponseCodes.OK.getCode(), RestResponseCodes.OK.getDescription(), result);
		
		return new ResponseEntity<RestResponse<Integer>>(restResponse, HttpStatus.OK);
		
	}
	
	/**
	 * Efetua o fechamento do depositário.
	 * 
	 * @return - Resultado da operação. 
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	@RequestMapping(path = "/close", method = RequestMethod.GET)
	public ResponseEntity<RestResponse<Integer>> close() {

		Integer result = depositoryService.close();
		
		RestResponse<Integer> restResponse = 
				new RestResponse<Integer>(RestResponseCodes.OK.getCode(), RestResponseCodes.OK.getDescription(), result);
		
		return new ResponseEntity<RestResponse<Integer>>(restResponse, HttpStatus.OK);
		
	}

	/**
	 * Efetua a checagem do status do depositário.
	 *  
	 * @return - Resultado da checagem do status.
	 */
	
	@RequestMapping(path = "/check", method = RequestMethod.GET)
	public ResponseEntity<RestResponse<Integer>> check() {

		Integer result = 0 /*depositoryService.check()*/;
		
		
		RestResponse<Integer> restResponse = 
				new RestResponse<Integer>(RestResponseCodes.OK.getCode(), RestResponseCodes.OK.getDescription(), result);
		
		return new ResponseEntity<RestResponse<Integer>>(restResponse, HttpStatus.OK);
		
	}

	/**
	 * Retorna o status do depositário.
	 *  
	 * @return - Resultado da checagem do status.
	 */
	
	@RequestMapping(path = "/getStatus", method = RequestMethod.GET)
	public ResponseEntity<RestResponse<DepositoryStatusDTO>> getStatus() {

		DepositoryStatusDTO result = new DepositoryStatusDTO();  /*depositoryService.getStatus()*/;
		
		result.setCode(0);
		result.setDescription("OK");
		
		RestResponse<DepositoryStatusDTO> restResponse = 
				new RestResponse<DepositoryStatusDTO>(RestResponseCodes.OK.getCode(), RestResponseCodes.OK.getDescription(), result);
		
		return new ResponseEntity<RestResponse<DepositoryStatusDTO>>(restResponse, HttpStatus.OK);
		
	}

	/**
	 * Inicializa o depositário.
	 *  
	 * @return - Resultado da inicialização do depositário.
	 */
	
	@RequestMapping(path = "/startDeposit", method = RequestMethod.GET)
	public ResponseEntity<RestResponse<Integer>> startDeposit() {

		Integer result = depositoryService.startDeposit();
		
		RestResponse<Integer> restResponse = 
				new RestResponse<Integer>(RestResponseCodes.OK.getCode(), RestResponseCodes.OK.getDescription(), result);
		
		return new ResponseEntity<RestResponse<Integer>>(restResponse, HttpStatus.OK);
		
	}

	/**
	 * Efetua o depósito do valor informado.
	 * 
	 * @return - Resultado da operação.
	 */
	
	@RequestMapping(path = "/deposit", method = RequestMethod.GET)
	public ResponseEntity<RestResponse<Integer>> deposit() {

		Integer result = depositoryService.deposit();
		
		RestResponse<Integer> restResponse = 
				new RestResponse<Integer>(RestResponseCodes.OK.getCode(), RestResponseCodes.OK.getDescription(), result);
		
		return new ResponseEntity<RestResponse<Integer>>(restResponse, HttpStatus.OK);
		
	}

	/**
	 * Finaliza a operação de depósito.
	 * 
	 * @param request - Dados para efetuar o depósito.
	 * 
	 * @return - Resultado da operação de depósito.
	 */
	
	@RequestMapping(path = "/endDeposit", method = RequestMethod.GET)
	public ResponseEntity<RestResponse<DepositoryCountDTO>> endDeposit() {

		DepositoryCountDTO result = depositoryService.endDeposit();
		
		RestResponse<DepositoryCountDTO> restResponse = 
				new RestResponse<DepositoryCountDTO>(RestResponseCodes.OK.getCode(), RestResponseCodes.OK.getDescription(), result);
		
		return new ResponseEntity<RestResponse<DepositoryCountDTO>>(restResponse, HttpStatus.OK);
		
	}

	/**
	 * Efetua a inicialização do depositário.
	 *  
	 * @return - Resultado da inicialização do depositário.
	 */
	
	@RequestMapping(path = "/reset", method = RequestMethod.GET)
	public ResponseEntity<RestResponse<Integer>> reset() {

		Integer result = depositoryService.reset();
		
		RestResponse<Integer> restResponse = 
				new RestResponse<Integer>(RestResponseCodes.OK.getCode(), RestResponseCodes.OK.getDescription(), result);
		
		return new ResponseEntity<RestResponse<Integer>>(restResponse, HttpStatus.OK);
		
	}

}
