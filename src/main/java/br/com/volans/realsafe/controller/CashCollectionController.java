package br.com.volans.realsafe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.volans.realsafe.dto.DepositDetailDTO;
import br.com.volans.realsafe.dto.TransactionLogDTO;
import br.com.volans.realsafe.dto.payload.CollectCashRequest;
import br.com.volans.realsafe.dto.payload.CollectCashResponse;
import br.com.volans.realsafe.dto.payload.ListCashCollectionDetailsRequest;
import br.com.volans.realsafe.dto.payload.ListCashCollectionDetailsResponse;
import br.com.volans.realsafe.dto.payload.ListCashCollectionRequest;
import br.com.volans.realsafe.dto.payload.ListCashCollectionResponse;
import br.com.volans.realsafe.dto.payload.PrintCollectCashReceiptRequest;
import br.com.volans.realsafe.enums.RestResponseCodes;
import br.com.volans.realsafe.exception.ServiceLayerException;
import br.com.volans.realsafe.rest.RestResponse;
import br.com.volans.realsafe.service.CashCollectionService;

/**
 * Controller dos serviços de recolhimento de numerário.
 * 
 * @author Volans Informática Ltda
 */

@RestController
@RequestMapping("/api/v1/cash-collection")
public class CashCollectionController {

	/**
	 * Declaração das variáveis membro
	 */

	private CashCollectionService cashCollectionService;
	
	/**
	 * Construtor alternativo da classe
	 * 
	 * @param cashCollectionService - Instância do serviço de recolhimento de numerário.
	 */
	
	@Autowired
	public CashCollectionController(CashCollectionService cashCollectionService) {
		this.cashCollectionService = cashCollectionService;
	}
	
	/**
	 * Efetiva a coleta do recolhimento de numerário.
	 * 
	 * @param request - Instância do request de recolhimento de numerário.
	 * 
	 * @return - Quantidade de linhas atualizadas.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	@RequestMapping(path = "/collectCash", method = RequestMethod.POST)
	public ResponseEntity<RestResponse<CollectCashResponse>> collectCash(@RequestBody CollectCashRequest request) {

		CollectCashResponse result = cashCollectionService.collectCash(request);
		
		RestResponse<CollectCashResponse> restResponse = 
				new RestResponse<CollectCashResponse>(RestResponseCodes.OK.getCode(), RestResponseCodes.OK.getDescription(), result);
		
		return new ResponseEntity<RestResponse<CollectCashResponse>>(restResponse, HttpStatus.OK);
		
	}
	
	/**
	 * Efetua a impressão de um comprovante de uma operação de recolhimento de numerário.
	 * 
	 * @param request - Dados para efetuar a impressão.
	 * 
	 * @return - Resultado da impressão do recibo.
	 */
	
	@RequestMapping(path = "/printCollectCashReceipt", method = RequestMethod.POST)
	public ResponseEntity<RestResponse<Integer>> printCollectCashReceipt(@RequestBody PrintCollectCashReceiptRequest request) {

		Integer result = cashCollectionService.printReceipt(request);
		
		RestResponse<Integer> restResponse = 
				new RestResponse<Integer>(RestResponseCodes.OK.getCode(), RestResponseCodes.OK.getDescription(), result);
		
		return new ResponseEntity<RestResponse<Integer>>(restResponse, HttpStatus.OK);
		
	}
	
	/**
	 * Retorna a lista de cédulas do recolhimento de numerário.
	 * 
	 * @param request - Instância do DTO para pesquisa do recolhimento de numerário.
	 *  
	 * @return - Lista de parâmetros do terminal.
	 */
	
	@RequestMapping(path = "/listCashCollection", method = RequestMethod.POST)
	public ResponseEntity<RestResponse<ListCashCollectionResponse>> listCashCollection(@RequestBody ListCashCollectionRequest request) {

		List<DepositDetailDTO> bankNotes = cashCollectionService.listCashCollection(request);
		
		ListCashCollectionResponse result = new ListCashCollectionResponse(bankNotes);
		
		RestResponse<ListCashCollectionResponse> restResponse = 
				new RestResponse<ListCashCollectionResponse>(RestResponseCodes.OK.getCode(), RestResponseCodes.OK.getDescription(), result);
		
		return new ResponseEntity<RestResponse<ListCashCollectionResponse>>(restResponse, HttpStatus.OK);
		
	}
	
	/**
	 * Retorna a lista de logs do recolhimento de numerário.
	 * 
	 * @param request - Instância do DTO para pesquisa dos detalhes do recolhimento de numerário.
	 *  
	 * @return - Lista de parâmetros do terminal.
	 */
	
	@RequestMapping(path = "/listCashCollectionDetails", method = RequestMethod.POST)
	public ResponseEntity<RestResponse<ListCashCollectionDetailsResponse>> listCashCollectionDetails(@RequestBody ListCashCollectionDetailsRequest request) {

		List<TransactionLogDTO> transactionLogs = cashCollectionService.listCashCollectionDetails(request);
		
		ListCashCollectionDetailsResponse result = new ListCashCollectionDetailsResponse(transactionLogs);
		
		RestResponse<ListCashCollectionDetailsResponse> restResponse = 
				new RestResponse<ListCashCollectionDetailsResponse>(RestResponseCodes.OK.getCode(), RestResponseCodes.OK.getDescription(), result);
		
		return new ResponseEntity<RestResponse<ListCashCollectionDetailsResponse>>(restResponse, HttpStatus.OK);
		
	}
	
}
