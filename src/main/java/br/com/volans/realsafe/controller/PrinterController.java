package br.com.volans.realsafe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.volans.realsafe.dto.PrinterStatusDTO;
import br.com.volans.realsafe.enums.RestResponseCodes;
import br.com.volans.realsafe.rest.RestResponse;
import br.com.volans.realsafe.service.PrinterService;

/**
 * Controller dos serviços de impressora.
 * 
 * @author Volans Informática Ltda
 */

@RestController
@RequestMapping("/api/v1/printer")
public class PrinterController {

	/**
	 * Declaração das variáveis membro
	 */
	
	private PrinterService printerService;
	
	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param printerService - Instância do serviço de impressoras.
	 */
	
	@Autowired
	public PrinterController(PrinterService printerService) {
		this.printerService = printerService;
	}

	/**
	 * Efetua a abertura da impressora.
	 *  
	 * @return - Resultado da operação.
	 */
	
	@RequestMapping(path = "/open", method = RequestMethod.GET)
	public ResponseEntity<RestResponse<Integer>> open() {

		Integer result = printerService.open();
		
		RestResponse<Integer> restResponse = 
				new RestResponse<Integer>(RestResponseCodes.OK.getCode(), RestResponseCodes.OK.getDescription(), result);
		
		return new ResponseEntity<RestResponse<Integer>>(restResponse, HttpStatus.OK);
		
	}

	/**
	 * Efetua o fechamento da impressora.
	 *  
	 * @return - Resultado da operação.
	 */
	
	@RequestMapping(path = "/close", method = RequestMethod.GET)
	public ResponseEntity<RestResponse<Integer>> close() {

		Integer result = printerService.close();
		
		RestResponse<Integer> restResponse = 
				new RestResponse<Integer>(RestResponseCodes.OK.getCode(), RestResponseCodes.OK.getDescription(), result);
		
		return new ResponseEntity<RestResponse<Integer>>(restResponse, HttpStatus.OK);
		
	}

	/**
	 * Efetua a checagem do status da impressora.
	 *  
	 * @return - Resultado da checagem do status.
	 */
	
	@RequestMapping(path = "/check", method = RequestMethod.GET)
	public ResponseEntity<RestResponse<Integer>> check() {

		Integer result = printerService.check();
		
		RestResponse<Integer> restResponse = 
				new RestResponse<Integer>(RestResponseCodes.OK.getCode(), RestResponseCodes.OK.getDescription(), result);
		
		return new ResponseEntity<RestResponse<Integer>>(restResponse, HttpStatus.OK);
		
	}

	/**
	 * Retorna o status da impressora.
	 *  
	 * @return - Resultado da checagem do status.
	 */
	
	@RequestMapping(path = "/getStatus", method = RequestMethod.GET)
	public ResponseEntity<RestResponse<PrinterStatusDTO>> getStatus() {

		PrinterStatusDTO result = printerService.getStatus();
		
		RestResponse<PrinterStatusDTO> restResponse = 
				new RestResponse<PrinterStatusDTO>(RestResponseCodes.OK.getCode(), RestResponseCodes.OK.getDescription(), result);
		
		return new ResponseEntity<RestResponse<PrinterStatusDTO>>(restResponse, HttpStatus.OK);
		
	}

	/**
	 * Efetua a impressão dos dados informados.
	 *  
	 * @return - Resultado da impressão dos dados.
	 */
	
	@RequestMapping(path = "/print", method = RequestMethod.POST)
	public ResponseEntity<RestResponse<Integer>> print(@RequestBody String data) {

		Integer result = printerService.print(data.getBytes());
		
		RestResponse<Integer> restResponse = 
				new RestResponse<Integer>(RestResponseCodes.OK.getCode(), RestResponseCodes.OK.getDescription(), result);
		
		return new ResponseEntity<RestResponse<Integer>>(restResponse, HttpStatus.OK);
		
	}

	/**
	 * Efetua a inicialização da impressora.
	 *  
	 * @return - Resultado da inicialização da impressora.
	 */
	
	@RequestMapping(path = "/reset", method = RequestMethod.GET)
	public ResponseEntity<RestResponse<Integer>> reset() {

		Integer result = printerService.reset();
		
		RestResponse<Integer> restResponse = 
				new RestResponse<Integer>(RestResponseCodes.OK.getCode(), RestResponseCodes.OK.getDescription(), result);
		
		return new ResponseEntity<RestResponse<Integer>>(restResponse, HttpStatus.OK);
		
	}

}
