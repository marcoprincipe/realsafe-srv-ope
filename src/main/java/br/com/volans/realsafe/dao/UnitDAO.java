package br.com.volans.realsafe.dao;

import java.math.BigDecimal;
import java.util.List;

import br.com.volans.realsafe.dto.UnitDTO;

/**
 * Interface para implementação do DAO de unidades.
 * 
 * @author Volans Informática Ltda
 */

public interface UnitDAO {

	/**
	 * Pesquisa pela unidade a partir do id informado.
	 * 
	 * @param unitId - Identificador da unidade
	 * 
	 * @return - Dados da unidade pesquisada.
	 */
	
	UnitDTO findById(BigDecimal unitId);
	
	/**
	 * Lista as unidades a partir do identificador da empresa informado.
	 * 
	 * @param companyId - Identificador da empresa.
	 * 
	 * @return - Lista das unidades da empresa informada.
	 */
	
	List<UnitDTO> listByCompanyId(BigDecimal companyId);
	
	/**
	 * Efetua a inclusão de uma filial
	 * 
	 * @param unitDTO - Instância da entidade de uma filial.
	 * 
	 * @return - Instância da entidade da inserção de uma filial.
	 */

	UnitDTO create(UnitDTO unitDTO);

}
