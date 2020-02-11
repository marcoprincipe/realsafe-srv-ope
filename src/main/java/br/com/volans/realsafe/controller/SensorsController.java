package br.com.volans.realsafe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.volans.realsafe.enums.RestResponseCodes;
import br.com.volans.realsafe.rest.RestResponse;
import br.com.volans.realsafe.service.SensorsService;

/**
 * Controller dos serviços da placa de sensores.
 * 
 * @author Volans Informática Ltda.
 */

@RestController
@RequestMapping("/api/v1/sensors")
public class SensorsController {

	/**
	 * Declaração das variáveis membro
	 */
	
	private SensorsService sensorsService;
	
	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param sensorsService - Instância do serviço da placa de sensores.
	 */
	
	@Autowired
	public SensorsController(SensorsService sensorsService) {
		this.sensorsService = sensorsService;
	}

	/**
	 * Efetua a abertura da placa de sensores.
	 *  
	 * @return - Resultado da operação.
	 */
	
	@RequestMapping(path = "/open", method = RequestMethod.GET)
	public ResponseEntity<RestResponse<Integer>> open() {

		Integer result = sensorsService.open();
		
		RestResponse<Integer> restResponse = 
				new RestResponse<Integer>(RestResponseCodes.OK.getCode(), RestResponseCodes.OK.getDescription(), result);
		
		return new ResponseEntity<RestResponse<Integer>>(restResponse, HttpStatus.OK);
		
	}

	/**
	 * Efetua o fechamento da placa de sensores.
	 *  
	 * @return - Resultado da operação.
	 */
	
	@RequestMapping(path = "/close", method = RequestMethod.GET)
	public ResponseEntity<RestResponse<Integer>> close() {

		Integer result = sensorsService.close();
		
		RestResponse<Integer> restResponse = 
				new RestResponse<Integer>(RestResponseCodes.OK.getCode(), RestResponseCodes.OK.getDescription(), result);
		
		return new ResponseEntity<RestResponse<Integer>>(restResponse, HttpStatus.OK);
		
	}

	/**
	 * Efetua a checagem do status da impressora.
	 *  
	 * @return - Resultado da checagem do status.
	 */
	
	@RequestMapping(path = "/getSensorsStatus", method = RequestMethod.GET)
	public ResponseEntity<RestResponse<int[]>> getSensorsStatus() {

		byte[] sensors = new byte[24];
		
		sensorsService.getSensors(sensors);
		
		int[] status = new int[24];
		
		for (int index = 0; index < sensors.length; index++) {
			status[index] = (int) (sensors[index] - 0x30);
		}
		
		RestResponse<int[]> restResponse = 
				new RestResponse<int[]>(RestResponseCodes.OK.getCode(), RestResponseCodes.OK.getDescription(), status);
		
		return new ResponseEntity<RestResponse<int[]>>(restResponse, HttpStatus.OK);
		
	}

}
