package br.com.volans.realsafe.service;

import java.util.List;

import br.com.volans.realsafe.dto.FunctionalityDTO;
import br.com.volans.realsafe.exception.ServiceLayerException;

/**
 * Interface para implementação dos serviços de funcionalidades operacionais.
 * 
 * @author Volans Informática Ltda.
 */

public interface FunctionalityService {
	
	/**
	 * Pesquisa pela funcionalidade a partir do identificador informado.
	 * 
	 * @param functionalityId- Identificador da funcionalidade.
	 * 
	 * @return - Dados da funcionalidade pesquisada.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	FunctionalityDTO findById(Long functionalityId) throws ServiceLayerException;
	
	/**
	 * Inclui uma nova funcionalidade na base de dados.
	 * 
	 * @param functionalityDTO - Dados a serem incluídos.
	 * 
	 * @return - Dados da funcionalidade incluida.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	FunctionalityDTO create(FunctionalityDTO functionalityDTO) throws ServiceLayerException;
	
	/**
	 * Retorna lista de funcionalidades operacionais da aplicação.
	 * 
	 * @return - Lista de funcionalidades operacionais.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	List<FunctionalityDTO> listAll() throws ServiceLayerException;

}
