package br.com.volans.realsafe.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import br.com.volans.realsafe.enums.RestResponseCodes;
import br.com.volans.realsafe.exception.ServiceLayerException;
import br.com.volans.realsafe.rest.RestResponse;

/**
 * Controller advice para tratamento das exceções da aplicação.
 * 
 * @author Volans Informática
 */

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	/**
	 * Declaração do logger da classe
	 */
	
	private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	/**
	 * Efetua o tratamento da exceção da camada de negócio.
	 * 
	 * @param ex - Intância da exceção lançada.
	 * @param request - Intância da solicitação web.
	 */
	
	@ExceptionHandler(ServiceLayerException.class)
	public ResponseEntity<RestResponse<String>> handleServiceLayerException(ServiceLayerException ex, WebRequest request) {
		
		LOGGER.error(ex.getMessage(), ex);
		
		RestResponse<String> response = 
				new RestResponse<String>(RestResponseCodes.SERVICE_ERROR.getCode(), ex.getMessage());
		
		return new ResponseEntity<RestResponse<String>>(response, null, HttpStatus.BAD_REQUEST);
		
	}
	
	/**
	 * Efetua o tratamento da exceção genérica.
	 * 
	 * @param ex - Intância da exceção lançada.
	 * @param request - Intância da solicitação web.
	 */
	
	@ExceptionHandler({ Exception.class, RuntimeException.class })
	public ResponseEntity<RestResponse<String>> handleGenericException(Exception ex, WebRequest request) {
		
		LOGGER.error(ex.getMessage(), ex);
		
		RestResponse<String> response = 
				new RestResponse<String>(RestResponseCodes.UNKNOWN_ERROR.getCode(), ex.getMessage());
		
		return new ResponseEntity<RestResponse<String>>(response, null, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}

}
