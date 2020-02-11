package br.com.volans.realsafe.service;

import br.com.volans.realsafe.dto.payload.DepositRequest;
import br.com.volans.realsafe.dto.payload.DepositResponse;
import br.com.volans.realsafe.dto.payload.PrintDepositReceiptRequest;
import br.com.volans.realsafe.exception.ServiceLayerException;

/**
 * Interface para implementação dos serviços de transações de depósito.
 * 
 * @author Volans Informática Ltda
 */

public interface DepositService {
	
	/**
	 * Efetua a gravação dos dados de uma operação de depósito.
	 * 
	 * @param request - Dados do depósito a ser gravado.
	 * 
	 * @return - Dados da resposta do depósito.
	 * 
	 * @throws ServiceLayerException
	 */
	
	DepositResponse deposit(DepositRequest request) throws ServiceLayerException;
	
	/**
	 * Efetua a impressão do recibo de uma operação de depósito.
	 * 
	 * @param request - Dados do recibo a ser impresso.
	 * 
	 * @return - Resultado da impressão do recibo.
	 * 
	 * @throws ServiceLayerException
	 */
	
	Integer printReceipt(PrintDepositReceiptRequest request) throws ServiceLayerException;

}
