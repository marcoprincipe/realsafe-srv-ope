package br.com.volans.realsafe.service;

import java.util.List;

import br.com.volans.realsafe.dto.DepositDetailDTO;
import br.com.volans.realsafe.dto.payload.ListDepositDetailsRequest;
import br.com.volans.realsafe.exception.ServiceLayerException;

/**
 * Interface para implementação dos serviços de detalhes de depósitos.
 * 
 * @author Volans Informática Ltda
 */

public interface DepositDetailService {
	
	/**
	 * Efetua a pesquisa de um detalhe de depósito.
	 * 
	 * @param request - Instância do request de detalhes de depósito.
	 * 
	 * @return - Lista dos DTOs de detalhes de depósito.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	List<DepositDetailDTO> listDepositDetails(ListDepositDetailsRequest request) throws ServiceLayerException;
	
}
