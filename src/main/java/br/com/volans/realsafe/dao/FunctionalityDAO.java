package br.com.volans.realsafe.dao;

import java.util.List;

import br.com.volans.realsafe.dto.FunctionalityDTO;

/**
 * Interface para implementação do DAO de funcionalidades operacionais.
 * 
 * @author Volans Informática Ltda.
 */

public interface FunctionalityDAO {
	
	/**
	 * Pesquisa pela funcionalidade a partir do identificador informado.
	 * 
	 * @param functionalityId- Identificador da funcionalidade.
	 * 
	 * @return - Dados da funcionalidade pesquisada.
	 */
	
	FunctionalityDTO findById(Long functionalityId);
	
	/**
	 * Inclui uma nova funcionalidade na base de dados.
	 * 
	 * @param functionalityDTO - Dados a serem incluídos.
	 * 
	 * @return - Dados da funcionalidade incluida.
	 */
	
	FunctionalityDTO create(FunctionalityDTO functionalityDTO);
	
	/**
	 * Retorna lista de funcionalidades operacionais da aplicação.
	 * 
	 * @return - Lista de funcionalidades operacionais.
	 */
	
	List<FunctionalityDTO> listAll();

}
