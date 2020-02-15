package br.com.volans.realsafe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.volans.realsafe.dto.EventLogDTO;
import br.com.volans.realsafe.enums.RestResponseCodes;
import br.com.volans.realsafe.rest.RestResponse;
import br.com.volans.realsafe.service.EventLogService;

/**
 * Controller dos serviços de log de eventos.
 * 
 * @author Volans Informática Ltda.
 */

@RestController
@RequestMapping("/api/v1/event-log")
public class EventLogController {

	/**
	 * Declaração das variáveis membro.
	 */
	
	private EventLogService eventLogService;
	
	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param eventLogService - Instância do serviço de log de eventos.
	 */
	
	@Autowired
	public EventLogController(EventLogService eventLogService) {
		this.eventLogService = eventLogService;
	}
	
	/**
	 * Cria o log de evento a partir dos dados informados.
	 *  
	 * @return - Dados do log de evento.
	 */
	
	@RequestMapping(path = "/create", method = RequestMethod.POST)
	public ResponseEntity<RestResponse<EventLogDTO>> create(@RequestBody EventLogDTO request) {

		EventLogDTO result = eventLogService.create(request);
		
		RestResponse<EventLogDTO> restResponse = 
				new RestResponse<EventLogDTO>(RestResponseCodes.OK.getCode(), RestResponseCodes.OK.getDescription(), result);
		
		return new ResponseEntity<RestResponse<EventLogDTO>>(restResponse, HttpStatus.OK);
			
	}

	/**
	 * Excluir um log de evento a partir dos dados informados.
	 *  
	 * @return - Quatidade de linhas afetadas.
	 */
	
	@RequestMapping(path = "/remove", method = RequestMethod.POST)
	public ResponseEntity<RestResponse<Integer>> remove(@RequestBody EventLogDTO request) {

		Integer result = eventLogService.remove(request);
		
		RestResponse<Integer> restResponse = 
				new RestResponse<Integer>(RestResponseCodes.OK.getCode(), RestResponseCodes.OK.getDescription(), result);
		
		return new ResponseEntity<RestResponse<Integer>>(restResponse, HttpStatus.OK);
			
	}	

}
