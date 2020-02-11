package br.com.volans.realsafe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.volans.realsafe.dto.ClosingDetailDTO;
import br.com.volans.realsafe.dto.OpeningDetailDTO;
import br.com.volans.realsafe.dto.TerminalDTO;
import br.com.volans.realsafe.dto.TerminalParameterDTO;
import br.com.volans.realsafe.dto.TerminalStatusDTO;
import br.com.volans.realsafe.dto.payload.CloseTerminalRequest;
import br.com.volans.realsafe.dto.payload.CloseTerminalResponse;
import br.com.volans.realsafe.dto.payload.GetClosingDetailRequest;
import br.com.volans.realsafe.dto.payload.GetClosingDetailResponse;
import br.com.volans.realsafe.dto.payload.GetOpeningDetailRequest;
import br.com.volans.realsafe.dto.payload.GetOpeningDetailResponse;
import br.com.volans.realsafe.dto.payload.GetTerminalResponse;
import br.com.volans.realsafe.dto.payload.GetTerminalStatusRequest;
import br.com.volans.realsafe.dto.payload.GetTerminalStatusResponse;
import br.com.volans.realsafe.dto.payload.ListTerminalParametersResponse;
import br.com.volans.realsafe.dto.payload.OpenTerminalRequest;
import br.com.volans.realsafe.dto.payload.OpenTerminalResponse;
import br.com.volans.realsafe.dto.payload.PrintCloseTerminalReceiptRequest;
import br.com.volans.realsafe.dto.payload.PrintOpenTerminalReceiptRequest;
import br.com.volans.realsafe.enums.RestResponseCodes;
import br.com.volans.realsafe.rest.RestResponse;
import br.com.volans.realsafe.service.TerminalParameterService;
import br.com.volans.realsafe.service.TerminalService;

/**
 * Controller dos serviços de terminais.
 * 
 * @author Volans Informática Ltda.
 */

@RestController
@RequestMapping("/api/v1/terminal")
public class TerminalController {

	/**
	 * Declaração das variáveis membro.
	 */
	
	private TerminalService terminalService;
	private TerminalParameterService terminalParameterService;
	
	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param terminalService - Instância do serviço de terminais.
	 * @param terminalService - Instância do serviço de parâmetros do terminal.
	 */
	
	@Autowired
	public TerminalController(
			TerminalService terminalService,
			TerminalParameterService terminalParameterService) {
		this.terminalService = terminalService;
		this.terminalParameterService = terminalParameterService;
	}

	/**
	 * Retorna a lista de parâmetros do terminal.
	 *  
	 * @return - Lista de parâmetros do terminal.
	 */
	
	@RequestMapping(path = "/listTerminalParameters", method = RequestMethod.GET)
	public ResponseEntity<RestResponse<ListTerminalParametersResponse>> listTerminalParameters() {

		List<TerminalParameterDTO> parameters = terminalParameterService.listAll();
		
		ListTerminalParametersResponse result = new ListTerminalParametersResponse(parameters);
		
		RestResponse<ListTerminalParametersResponse> restResponse = 
				new RestResponse<ListTerminalParametersResponse>(RestResponseCodes.OK.getCode(), RestResponseCodes.OK.getDescription(), result);
		
		return new ResponseEntity<RestResponse<ListTerminalParametersResponse>>(restResponse, HttpStatus.OK);
		
	}

	/**
	 * Retorna os dados do terminal.
	 *  
	 * @return - Dados do terminal.
	 */
	
	@RequestMapping(path = "/getLocalTerminal", method = RequestMethod.GET)
	public ResponseEntity<RestResponse<GetTerminalResponse>> getLocalTerminal() {

		TerminalDTO terminal = terminalService.getLocalTerminal();
		
		GetTerminalResponse result = new GetTerminalResponse(terminal);
		
		RestResponse<GetTerminalResponse> restResponse = 
				new RestResponse<GetTerminalResponse>(RestResponseCodes.OK.getCode(), RestResponseCodes.OK.getDescription(), result);
		
		return new ResponseEntity<RestResponse<GetTerminalResponse>>(restResponse, HttpStatus.OK);
		
	}

	/**
	 * Retorna os dados do status do terminal informado.
	 * 
	 * @param request - Dados para pesquisa do status do terminal.
	 *  
	 * @return - Dados do status do terminal.
	 */
	
	@RequestMapping(path = "/getTerminalStatus", method = RequestMethod.POST)
	public ResponseEntity<RestResponse<GetTerminalStatusResponse>> getTerminalStatus(@RequestBody GetTerminalStatusRequest request) {

		TerminalStatusDTO terminalStatusDTO = terminalService.getTerminalStatus(request.getTerminalId());
		
		GetTerminalStatusResponse result = new GetTerminalStatusResponse(terminalStatusDTO);
		
		RestResponse<GetTerminalStatusResponse> restResponse = 
				new RestResponse<GetTerminalStatusResponse>(RestResponseCodes.OK.getCode(), RestResponseCodes.OK.getDescription(), result);
		
		return new ResponseEntity<RestResponse<GetTerminalStatusResponse>>(restResponse, HttpStatus.OK);
		
	}

	/**
	 * Efetua a abertura do terminal informado.
	 * 
	 * @param request - Dados para abertura do terminal.
	 *  
	 * @return - Quantidade de linhas atualizadas.
	 */
	
	@RequestMapping(path = "/openTerminal", method = RequestMethod.POST)
	public ResponseEntity<RestResponse<OpenTerminalResponse>> openTerminal(@RequestBody OpenTerminalRequest request) {

		TerminalStatusDTO terminalStatusDTO = terminalService.openTerminal(request);
		
		OpenTerminalResponse result = new OpenTerminalResponse(terminalStatusDTO);
		
		RestResponse<OpenTerminalResponse> restResponse = 
				new RestResponse<OpenTerminalResponse>(RestResponseCodes.OK.getCode(), RestResponseCodes.OK.getDescription(), result);
		
		return new ResponseEntity<RestResponse<OpenTerminalResponse>>(restResponse, HttpStatus.OK);
		
	}
	
	/**
	 * Efetua a impressão de um comprovante de uma operação de abertura de terminal.
	 * 
	 * @param request - Dados para efetuar a impressão.
	 * 
	 * @return - Resultado da impressão do recibo.
	 */
	
	@RequestMapping(path = "/printOpenTerminalReceipt", method = RequestMethod.POST)
	public ResponseEntity<RestResponse<Integer>> printOpenTerminalReceipt(@RequestBody PrintOpenTerminalReceiptRequest request) {

		Integer result = terminalService.printOpenTerminalReceipt(request);
		
		RestResponse<Integer> restResponse = 
				new RestResponse<Integer>(RestResponseCodes.OK.getCode(), RestResponseCodes.OK.getDescription(), result);
		
		return new ResponseEntity<RestResponse<Integer>>(restResponse, HttpStatus.OK);
		
	}
	
	/**
	 * Efetua a impressão de um comprovante de uma operação de abertura de terminal.
	 * 
	 * @param request - Dados para efetuar a impressão.
	 * 
	 * @return - Resultado da impressão do recibo.
	 */
	
	@RequestMapping(path = "/printCloseTerminalReceipt", method = RequestMethod.POST)
	public ResponseEntity<RestResponse<Integer>> printCloseTerminalReceipt(@RequestBody PrintCloseTerminalReceiptRequest request) {

		Integer result = terminalService.printCloseTerminalReceipt(request);
		
		RestResponse<Integer> restResponse = 
				new RestResponse<Integer>(RestResponseCodes.OK.getCode(), RestResponseCodes.OK.getDescription(), result);
		
		return new ResponseEntity<RestResponse<Integer>>(restResponse, HttpStatus.OK);
		
	}

	/**
	 * Recupera os dados do detalhe da abertura do terminal informado.
	 * 
	 * @param request - Dados da abertura do terminal.
	 *  
	 * @return - Quantidade de linhas atualizadas.
	 */
	
	@RequestMapping(path = "/getOpeningDetail", method = RequestMethod.POST)
	public ResponseEntity<RestResponse<GetOpeningDetailResponse>> getOpeningDetail(@RequestBody GetOpeningDetailRequest request) {

		OpeningDetailDTO openingDetailDTO = terminalService.getOpeningDetail(request);
		
		GetOpeningDetailResponse result = new GetOpeningDetailResponse(openingDetailDTO);
		
		RestResponse<GetOpeningDetailResponse> restResponse = 
				new RestResponse<GetOpeningDetailResponse>(RestResponseCodes.OK.getCode(), RestResponseCodes.OK.getDescription(), result);
		
		return new ResponseEntity<RestResponse<GetOpeningDetailResponse>>(restResponse, HttpStatus.OK);
		
	}

	/**
	 * Efetua o fechamento do terminal informado.
	 * 
	 * @param request - Dados para fechamento do terminal.
	 *  
	 * @return - Quantidade de linhas atualizadas.
	 */
	
	@RequestMapping(path = "/closeTerminal", method = RequestMethod.POST)
	public ResponseEntity<RestResponse<CloseTerminalResponse>> closeTerminal(@RequestBody CloseTerminalRequest request) {

		TerminalStatusDTO terminalStatusDTO = terminalService.closeTerminal(request);
		
		CloseTerminalResponse result = new CloseTerminalResponse(terminalStatusDTO);
		
		RestResponse<CloseTerminalResponse> restResponse = 
				new RestResponse<CloseTerminalResponse>(RestResponseCodes.OK.getCode(), RestResponseCodes.OK.getDescription(), result);
		
		return new ResponseEntity<RestResponse<CloseTerminalResponse>>(restResponse, HttpStatus.OK);
		
	}

	/**
	 * Recupera os dados do detalhe do fechamento do terminal informado.
	 * 
	 * @param request - Dados do fechamento do terminal.
	 *  
	 * @return - Quantidade de linhas atualizadas.
	 */
	
	@RequestMapping(path = "/getClosingDetail", method = RequestMethod.POST)
	public ResponseEntity<RestResponse<GetClosingDetailResponse>> getClosingDetail(@RequestBody GetClosingDetailRequest request) {

		ClosingDetailDTO closingDetailDTO = terminalService.getClosingDetail(request);
		
		GetClosingDetailResponse result = new GetClosingDetailResponse(closingDetailDTO);
		
		RestResponse<GetClosingDetailResponse> restResponse = 
				new RestResponse<GetClosingDetailResponse>(RestResponseCodes.OK.getCode(), RestResponseCodes.OK.getDescription(), result);
		
		return new ResponseEntity<RestResponse<GetClosingDetailResponse>>(restResponse, HttpStatus.OK);
		
	}

}
