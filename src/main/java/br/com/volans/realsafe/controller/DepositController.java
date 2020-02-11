package br.com.volans.realsafe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.volans.realsafe.dto.payload.DepositRequest;
import br.com.volans.realsafe.dto.payload.DepositResponse;
import br.com.volans.realsafe.dto.payload.PrintDepositReceiptRequest;
import br.com.volans.realsafe.enums.RestResponseCodes;
import br.com.volans.realsafe.rest.RestResponse;
import br.com.volans.realsafe.service.DepositService;

/**
 * Controller dos serviços de transações de depósito.
 * 
 * @author Volans Informática Ltda
 */

@RestController
@RequestMapping("/api/v1/deposit")
public class DepositController {

	/**
	 * Declaração das variáveis membro
	 */

	private DepositService depositService;
	
	/**
	 * Construtor alternativo da classe
	 * 
	 * @param depositService - Instância do serviço de transações de depósito.
	 */
	
	@Autowired
	public DepositController(DepositService depositService) {
		this.depositService = depositService;
	}
	
	/**
	 * Efetua a gravação dos dados de uma operação de depósito.
	 * 
	 * @param request - Dados para efetuar o depósito.
	 * 
	 * @return - Resultado da operação de depósito.
	 */
	
	@RequestMapping(path = "/deposit", method = RequestMethod.POST)
	public ResponseEntity<RestResponse<DepositResponse>> logDepositTransaction(@RequestBody DepositRequest request) {

		DepositResponse result = depositService.deposit(request);
		
		RestResponse<DepositResponse> restResponse = 
				new RestResponse<DepositResponse>(RestResponseCodes.OK.getCode(), RestResponseCodes.OK.getDescription(), result);
		
		return new ResponseEntity<RestResponse<DepositResponse>>(restResponse, HttpStatus.OK);
		
	}
	
	/**
	 * Efetua a impressão de um comprovante de uma operação de depósito.
	 * 
	 * @param request - Dados para efetuar a impressão.
	 * 
	 * @return - Resultado da impressão do recibo.
	 */
	
	@RequestMapping(path = "/printDepositReceipt", method = RequestMethod.POST)
	public ResponseEntity<RestResponse<Integer>> printDepositReceipt(@RequestBody PrintDepositReceiptRequest request) {

		Integer result = depositService.printReceipt(request);
		
		RestResponse<Integer> restResponse = 
				new RestResponse<Integer>(RestResponseCodes.OK.getCode(), RestResponseCodes.OK.getDescription(), result);
		
		return new ResponseEntity<RestResponse<Integer>>(restResponse, HttpStatus.OK);
		
	}

}
