package br.com.volans.realsafe.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.volans.realsafe.dto.HealthDTO;
import br.com.volans.realsafe.enums.RestResponseCodes;
import br.com.volans.realsafe.rest.RestResponse;
import br.com.volans.realsafe.service.HealthService;

/**
 * Controller dos serviços de checagem da aplicação.
 * 
 * @author Volans Informática Ltda.
 */

@RestController
@RequestMapping("/api/v1/health")
public class HealthController {

	/**
	 * Declaração das variáveis membro.
	 */
	
	private HealthService healthService;
	
	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param healthService - Instância do serviço de checagem da aplicação.
	 */
	
	public HealthController(HealthService healthService) {
		this.healthService = healthService;
	}

	/**
	 * Efetua a verificação do status da aplicação
	 * 
	 * @return - Dados da verificação da checagem.
	 */
	
	@RequestMapping(path = "/check", method = RequestMethod.GET)
	public ResponseEntity<RestResponse<HealthDTO>> check() {
		
		HealthDTO result = healthService.checkHealth();
		
		RestResponse<HealthDTO> restResponse = 
				new RestResponse<HealthDTO>(RestResponseCodes.OK.getCode(), RestResponseCodes.OK.getDescription(), result);
		
		return new ResponseEntity<RestResponse<HealthDTO>>(restResponse, HttpStatus.OK);
		
	}
	
}
