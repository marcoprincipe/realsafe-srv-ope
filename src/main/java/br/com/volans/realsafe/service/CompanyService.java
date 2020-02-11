package br.com.volans.realsafe.service;

import java.math.BigDecimal;
import java.util.List;

import br.com.volans.realsafe.dto.CompanyDTO;
import br.com.volans.realsafe.dto.payload.SearchCompaniesRequest;
import br.com.volans.realsafe.dto.payload.SearchCompaniesResponse;
import br.com.volans.realsafe.exception.ServiceLayerException;

/**
 * Interface para implementação dos serviços de empresas.
 * 
 * @author Volans Informática Ltda.
 */

public interface CompanyService {

	/**
	 * Pesquisa pela empresa a partir do id informado.
	 * 
	 * @param companyId - Identificador da empresa.
	 * 
	 * @return - Dados da empresa pesquisada.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	CompanyDTO findById(BigDecimal companyId) throws ServiceLayerException;
	
	/**
	 * Retorna lista de empresas cadastradas.
	 * 
	 * @return - Lista de empresas cadastradas.
	 */
	
	List<CompanyDTO> listAll();
	
	
	/**
	 * Efetua a inclusão de uma empresa.
	 * 
	 * @param companyDTO - Dados para efetuar a inclusão de uma empresa.
	 * 
	 * @return - Objeto com os dados inclusão de uma empresa.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */	
	
	CompanyDTO create(CompanyDTO companyDTO) throws ServiceLayerException;

	/**
	 * Efetua a atualização de uma empresa.
	 * 
	 * @param companyDTO - Dados para efetuar a atualização de uma empresa.
	 * 
	 * @return - Objeto com os dados atualização de uma empresa.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */	
	
	CompanyDTO update(CompanyDTO companyDTO) throws ServiceLayerException;	
	
	/**
	 * Efetua a exclusão de uma empresa.
	 * 
	 * @param companyDTO - Dados para efetuar a exclusão de uma empresa.
	 * 
	 * @return - Objeto com os dados atualização de uma empresa.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */	
	
	CompanyDTO remove(CompanyDTO companyDTO) throws ServiceLayerException;

	/**
	 * Retorna a lista de empresas.
	 * 
	 * @param request - Dados para efetuar a pesquisa.
	 * 
	 * @return - Objeto com os dados da pesquisa.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	List<SearchCompaniesResponse> searchCompanies(SearchCompaniesRequest request) throws ServiceLayerException;
}
