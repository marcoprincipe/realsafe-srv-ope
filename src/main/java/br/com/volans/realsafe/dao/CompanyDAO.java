package br.com.volans.realsafe.dao;

import java.math.BigDecimal;
import java.util.List;

import br.com.volans.realsafe.dto.CompanyDTO;
import br.com.volans.realsafe.dto.payload.SearchCompaniesRequest;
import br.com.volans.realsafe.dto.payload.SearchCompaniesResponse;

/**
 * Interface para implementação do DAO de empresas.
 * 
 * @author Volans Informática Ltda
 */

public interface CompanyDAO {

	/**
	 * Pesquisa pela empresa a partir do id informado.
	 * 
	 * @param companyId - Identificador da empresa
	 * 
	 * @return - Dados da empresa pesquisada.
	 */
	
	CompanyDTO findById(BigDecimal companyId);
	
	/**
	 * Retorna lista de empresas cadastradas.
	 * 
	 * @return - Lista de empresas cadastradas.
	 */
	
	List<CompanyDTO> listAll();
	
	/**
	 * Efetua a inclusão de uma empresa
	 * 
	 * @param companyDTO - Instância da entidade de uma empresa.
	 * 
	 * @return - Instância da entidade da inserção de uma empresa
	 */

	CompanyDTO create(CompanyDTO companyDTO);
	
	/**
	 * Efetua a atualização de uma empresa
	 * 
	 * @param companyDTO - Instância da entidade de uma empresa.
	 * 
	 * @return - Instância da entidade da atualização de uma empresa
	 */

	CompanyDTO update(CompanyDTO companyDTO);
	
	/**
	 * Efetua a exclusão de uma empresa
	 * 
	 * @param companyDTO - Instância da entidade de uma empresa.
	 * 
	 * @return - Instância da entidade da atualização de uma empresa
	 */

	CompanyDTO remove(CompanyDTO companyDTO);
	
	/**
	 * Seleciona todas as operações da tabela
	 * 
	 * @param request
	 * 
	 * @return
	 */
	
	List<SearchCompaniesResponse> searchCompanies(SearchCompaniesRequest request);
	
}
