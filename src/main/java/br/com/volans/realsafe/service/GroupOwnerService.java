package br.com.volans.realsafe.service;

import java.math.BigDecimal;
import java.util.List;

import br.com.volans.realsafe.dto.GroupOwnerDTO;
import br.com.volans.realsafe.exception.ServiceLayerException;

/**
 * Interface para implementação dos serviços de proprietário de grupos.
 * 
 * @author Volans Informática Ltda.
 */

public interface GroupOwnerService {

	/**
	 * Recupera os dados do proprietário de grupos local.
	 * 
	 * @return - Dados do proprietário de grupos.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	GroupOwnerDTO getLocalGroupOwner() throws ServiceLayerException;
	
	/**
	 * Retorna lista de proprietarios de grupo cadastrados.
	 * 
	 * @return - Lista de proprietarios cadastrados.
	 */
	
	List<GroupOwnerDTO> listAll();
	
	/**
	 * Pesquisa pelo proprietario de grupo a partir do id informado.
	 * 
	 * @param groupOwnerId - Identificador do proprietario.
	 * 
	 * @return - Dados do proprietario pesquisado.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	GroupOwnerDTO findById(BigDecimal groupOwnerId) throws ServiceLayerException;

}
