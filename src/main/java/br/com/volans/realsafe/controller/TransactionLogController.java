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
import br.com.volans.realsafe.dto.payload.ListDepositDetailsRequest;
import br.com.volans.realsafe.dto.payload.ListDepositDetailsResponse;
import br.com.volans.realsafe.dto.payload.ListTransactionLogRequest;
import br.com.volans.realsafe.dto.payload.ListTransactionLogResponse;
import br.com.volans.realsafe.dto.payload.PrintBankStatementRequest;
import br.com.volans.realsafe.dto.payload.SearchTransactionLogRequest;
import br.com.volans.realsafe.dto.payload.SearchTransactionLogResponse;
import br.com.volans.realsafe.enums.RestResponseCodes;
import br.com.volans.realsafe.enums.TransactionStatuses;
import br.com.volans.realsafe.enums.Transactions;
import br.com.volans.realsafe.rest.RestResponse;
import br.com.volans.realsafe.service.DepositDetailService;
import br.com.volans.realsafe.service.TransactionLogService;

/**
 * Controller dos serviços de logs de transações.
 * 
 * @author Volans Informática Ltda
 */

@RestController
@RequestMapping("/api/v1/transaction-log")
public class TransactionLogController {

	/**
	 * Declaração das variáveis membro
	 */
	
	private TransactionLogService transactionLogService;
	private DepositDetailService depositDetailService;
	
	/**
	 * Construtor alternativo da classe
	 * 
	 * @param transactionLogService - Instância do serviço de logs de transações.
	 * @param depositDetailService - Instância do serviço de depósitos.
	 */
	
	@Autowired
	public TransactionLogController(
			TransactionLogService transactionLogService,
			DepositDetailService depositDetailService) {
		this.transactionLogService = transactionLogService;
		this.depositDetailService = depositDetailService;
	}
	
	/**
	 * Retorna a lista dos logs de transações.
	 *  
	 * @return - Lista dos logs de transações.
	 */
	
	@RequestMapping(path = "/listTransactionsByTerminal", method = RequestMethod.POST)
	public ResponseEntity<RestResponse<ListTransactionLogResponse>> listTransactionsByTerminal(@RequestBody ListTransactionLogRequest request) {

		List<TransactionLogDTO> transactionLogs = transactionLogService.listTransactionLog(request.getTerminalId());
		
		ListTransactionLogResponse result = new ListTransactionLogResponse(transactionLogs);
		
		RestResponse<ListTransactionLogResponse> restResponse = 
				new RestResponse<ListTransactionLogResponse>(RestResponseCodes.OK.getCode(), RestResponseCodes.OK.getDescription(), result);
		
		return new ResponseEntity<RestResponse<ListTransactionLogResponse>>(restResponse, HttpStatus.OK);
		
	}
	
	/**
	 * Retorna a lista dos logs de transações.
	 *  
	 * @return - Lista dos logs de transações.
	 */
	
	@RequestMapping(path = "/listPedentDeposits", method = RequestMethod.POST)
	public ResponseEntity<RestResponse<ListTransactionLogResponse>> listPedentDeposits(@RequestBody ListTransactionLogRequest request) {

		List<TransactionLogDTO> transactionLogs = 
				transactionLogService.listTransactionLog(request.getTerminalId(), TransactionStatuses.PENDENT.getCode(), Transactions.DEPOSIT.getCode());
		
		ListTransactionLogResponse result = new ListTransactionLogResponse(transactionLogs);
		
		RestResponse<ListTransactionLogResponse> restResponse = 
				new RestResponse<ListTransactionLogResponse>(RestResponseCodes.OK.getCode(), RestResponseCodes.OK.getDescription(), result);
		
		return new ResponseEntity<RestResponse<ListTransactionLogResponse>>(restResponse, HttpStatus.OK);
		
	}

	/**
	 * Retorna a lista dos logs de transações.
	 *  
	 * @return - Lista dos logs de transações.
	 */
	
	@RequestMapping(path = "/listTransactionsByGroupOwner", method = RequestMethod.POST)
	public ResponseEntity<RestResponse<ListTransactionLogResponse>> listTransactionsByGroupOwner(@RequestBody ListTransactionLogRequest request) {

		List<TransactionLogDTO> transactionLogs = transactionLogService.listTransactionLog(request.getGroupOwnerId());
		
		ListTransactionLogResponse result = new ListTransactionLogResponse(transactionLogs);
		
		RestResponse<ListTransactionLogResponse> restResponse = 
				new RestResponse<ListTransactionLogResponse>(RestResponseCodes.OK.getCode(), RestResponseCodes.OK.getDescription(), result);
		
		return new ResponseEntity<RestResponse<ListTransactionLogResponse>>(restResponse, HttpStatus.OK);
		
	}

	/**
	 * Retorna a lista dos detalhes de depósito.
	 *  
	 * @return - Lista dos logs de transações.
	 */
	
	@RequestMapping(path = "/listDepositDetails", method = RequestMethod.POST)
	public ResponseEntity<RestResponse<ListDepositDetailsResponse>> listDepositDetails(@RequestBody ListDepositDetailsRequest request) {
		
		List<DepositDetailDTO> depositDetails = depositDetailService.listDepositDetails(request);
		
		ListDepositDetailsResponse result = new ListDepositDetailsResponse(depositDetails);
		
		RestResponse<ListDepositDetailsResponse> restResponse = 
				new RestResponse<ListDepositDetailsResponse>(RestResponseCodes.OK.getCode(), RestResponseCodes.OK.getDescription(), result);
		
		return new ResponseEntity<RestResponse<ListDepositDetailsResponse>>(restResponse, HttpStatus.OK);
		
	}

	/**
	 * Retorna a lista dos logs de transações.
	 *  
	 * @return - Lista dos logs de transações.
	 */
	
	@RequestMapping(path = "/searchTransactionLog", method = RequestMethod.POST)
	public ResponseEntity<RestResponse<SearchTransactionLogResponse>> searchTransactionLog(@RequestBody SearchTransactionLogRequest request) {

		List<TransactionLogDTO> transactionLogs = transactionLogService.
				searchTransactionLog(request.getGroupOwnerId(), request.getNsuTerminal(), request.getStartDate(), request.getEndDate());
		
		SearchTransactionLogResponse result = new SearchTransactionLogResponse(transactionLogs);
		
		RestResponse<SearchTransactionLogResponse> restResponse = 
				new RestResponse<SearchTransactionLogResponse>(RestResponseCodes.OK.getCode(), RestResponseCodes.OK.getDescription(), result);
		
		return new ResponseEntity<RestResponse<SearchTransactionLogResponse>>(restResponse, HttpStatus.OK);
		
	}
	
	/**
	 * Efetua a impressão do extrato de transações.
	 * 
	 * @param request - Dados para efetuar a impressão.
	 * 
	 * @return - Resultado da impressão do recibo.
	 */
	
	@RequestMapping(path = "/printBankStatement", method = RequestMethod.POST)
	public ResponseEntity<RestResponse<Integer>> printBankStatement(@RequestBody PrintBankStatementRequest request) {

		Integer result = transactionLogService.printBankStatement(request);
		
		RestResponse<Integer> restResponse = 
				new RestResponse<Integer>(RestResponseCodes.OK.getCode(), RestResponseCodes.OK.getDescription(), result);
		
		return new ResponseEntity<RestResponse<Integer>>(restResponse, HttpStatus.OK);
		
	}

}
