package br.com.volans.realsafe.service;

import java.util.List;

import br.com.volans.realsafe.dto.DepositDetailDTO;
import br.com.volans.realsafe.dto.TransactionLogDTO;
import br.com.volans.realsafe.dto.payload.CollectCashRequest;
import br.com.volans.realsafe.dto.payload.CollectCashResponse;
import br.com.volans.realsafe.dto.payload.ListCashCollectionDetailsRequest;
import br.com.volans.realsafe.dto.payload.ListCashCollectionRequest;
import br.com.volans.realsafe.dto.payload.PrintCollectCashReceiptRequest;
import br.com.volans.realsafe.exception.ServiceLayerException;

/**
 * Interface para implementação dos serviços de recolhimento de numerário.
 * 
 * @author Volans Informática Ltda
 */

public interface CashCollectionService {
	
	/**
	 * Efetiva a coleta do recolhimento de numerário.
	 * 
	 * @param request - Instância do request de recolhimento de numerário.
	 * 
	 * @return - DTO com os dados do resultado da execução.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	CollectCashResponse collectCash(CollectCashRequest request) throws ServiceLayerException;
	
	/**
	 * Efetua a impressão do recibo de uma operação de recolhimento de numerário.
	 * 
	 * @param request - Dados do recibo a ser impresso.
	 * 
	 * @return - Resultado da impressão do recibo.
	 * 
	 * @throws ServiceLayerException
	 */
	
	Integer printReceipt(PrintCollectCashReceiptRequest request) throws ServiceLayerException;
	
	/**
	 * Retorna a lista de detalhes de um recolhimento de numerário.
	 * 
	 * @param request - Instância do request de detalhes do recolhimento de numerário.
	 * 
	 * @return - Lista de detalhes de um recolhimento de numerário.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	List<TransactionLogDTO> listCashCollectionDetails(ListCashCollectionDetailsRequest request) throws ServiceLayerException;
	
	/**
	 * Efetua a pesquisa do recolhimento de numerário.
	 * 
	 * @param request - Instância do request de recolhimento de numerário.
	 * 
	 * @return - DTO com os detalhes do recolhimento do numerário.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	List<DepositDetailDTO> listCashCollection(ListCashCollectionRequest request) throws ServiceLayerException;

}
