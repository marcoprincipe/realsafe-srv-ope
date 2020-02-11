package br.com.volans.realsafe.service;

import java.math.BigDecimal;
import java.util.List;

import br.com.volans.realsafe.dto.GroupDTO;
import br.com.volans.realsafe.exception.ServiceLayerException;

/**
 * Interface para implementação dos serviços de grupos.
 * 
 * @author Volans Informática Ltda
 */

public interface GroupService {

	/**
	 * Pesquisa pelo group a partir do id informado.
	 * 
	 * @param groupId - Identificador do grupo.
	 * 
	 * @return - Dados do grupo pesquisado.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	GroupDTO findById(BigDecimal groupId) throws ServiceLayerException;
	
	/**
	 * Retorna lista de grupos cadastrados.
	 * 
	 * @return - Lista de grupos cadastrados.
	 */
	
	List<GroupDTO> listAll();
	
}
