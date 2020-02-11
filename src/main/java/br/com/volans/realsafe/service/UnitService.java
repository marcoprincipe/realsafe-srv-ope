package br.com.volans.realsafe.service;

import java.math.BigDecimal;
import java.util.List;

import br.com.volans.realsafe.dto.UnitDTO;
import br.com.volans.realsafe.exception.ServiceLayerException;

/**
 * Interface para implementação dos serviços de unidades.
 * 
 * @author Volans Informática Ltda
 */

public interface UnitService {
	
	/**
	 * Pesquisa pela unidade a partir do id informado.
	 * 
	 * @param id - Identificador da unidade
	 * 
	 * @return - Dados da unidade pesquisada.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	UnitDTO findById(BigDecimal unitId) throws ServiceLayerException;
	
	/**
	 * Lista as unidades a partir do identificador da empresa informado.
	 * 
	 * @param companyId - Identificador da empresa.
	 * 
	 * @return - Lista das unidades da empresa informada.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	List<UnitDTO> listByCompanyId(BigDecimal companyId) throws ServiceLayerException;

}
