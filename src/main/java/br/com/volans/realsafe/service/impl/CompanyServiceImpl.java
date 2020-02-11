package br.com.volans.realsafe.service.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.volans.realsafe.dao.CompanyDAO;
import br.com.volans.realsafe.dto.CompanyDTO;
import br.com.volans.realsafe.dto.payload.SearchCompaniesRequest;
import br.com.volans.realsafe.dto.payload.SearchCompaniesResponse;
import br.com.volans.realsafe.enums.MessageKeys;
import br.com.volans.realsafe.exception.ServiceLayerException;
import br.com.volans.realsafe.service.AbstractService;
import br.com.volans.realsafe.service.CompanyService;

/**
 * Implementação da interface dos serviços de empresas.
 * 
 * @author Volans Informática Ltda.
 */

@Service
public class CompanyServiceImpl extends AbstractService implements CompanyService {
	
	/**
	 * Declaração das variáveis membro.
	 */

	private CompanyDAO companyDAO;
	

	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param companyDAO - Instância do DAO de empresas.
	 */
	
	@Autowired
	public CompanyServiceImpl(CompanyDAO companyDAO) {
		this.companyDAO = companyDAO;
	}
	
	/**
	 * Pesquisa pela empresa a partir do id informado.
	 * 
	 * @param id - Identificador da empresa
	 * 
	 * @return - Dados da empresa pesquisada.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	@Override
	public CompanyDTO findById(BigDecimal companyId) throws ServiceLayerException {
		
		if (companyId == null) {
			throw new ServiceLayerException(getMessage(MessageKeys.COMPANY_CODE_NOT_INFORMED.getKey()));
		}
		
		if (companyId.longValue() <= 0) {
			throw new ServiceLayerException(getMessage(MessageKeys.INVALID_COMPANY_CODE.getKey()));
		}
		
		CompanyDTO result = companyDAO.findById(companyId);
		
		if (result == null) {
			throw new ServiceLayerException(getMessage(MessageKeys.COMPANY_NOT_FOUND.getKey()));
		}
		
		return result;
		
	}
	
	/**
	 * Retorna lista de empresas cadastradas.
	 * 
	 * @return - Lista de empresas cadastradas.
	 */
	
	@Override
	public List<CompanyDTO> listAll() {
		
		List<CompanyDTO> result = companyDAO.listAll();
		
		if (result == null || result.size() == 0) {
			throw new ServiceLayerException(getMessage(MessageKeys.NO_COMPANY_FOUND.getKey()));
		}
		
		return result;

	}

	/**
	 * Insere uma empresa.
	 * 
	 * @param companyDTO - Dados para efetuar adição de uma empresa.
	 * 
	 * @return - Objeto com os dados do cadastro de empresa.
	 * 
	 * @throws ServiceLayerException
	 */
	
	@Override
	@Transactional
	public CompanyDTO create(CompanyDTO companyDTO) throws ServiceLayerException {
		
		companyDAO.create(companyDTO);
		
		return companyDTO;
	}

	/**
	 * Atualiza uma empresa.
	 * 
	 * @param companyDTO - Dados para efetuar atualização de uma empresa.
	 * 
	 * @return - Objeto com os dados do cadastro de empresa.
	 * 
	 * @throws ServiceLayerException
	 */
	
	@Override
	@Transactional
	public CompanyDTO update(CompanyDTO companyDTO) throws ServiceLayerException {
		
		companyDAO.update(companyDTO);
		
		return companyDTO;
	}


	/**
	 * Exclui uma empresa.
	 * 
	 * @param companyDTO - Dados para efetuar exclusão de uma empresa.
	 * 
	 * @return - Objeto com os dados do cadastro de empresa.
	 * 
	 * @throws ServiceLayerException
	 */	
	@Override
	@Transactional
	public CompanyDTO remove(CompanyDTO companyDTO) throws ServiceLayerException {
	
		companyDAO.remove(companyDTO);
				
		return companyDTO;
	}

	/**
	 * Pesquisa de empresas a partir dos dados informados.
	 * 
	 * @param request - Instância do request de pesquisa de empresas.
	 * 
	 * @return - Dados das empresas.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	@Override
	@Transactional
	public List<SearchCompaniesResponse> searchCompanies(SearchCompaniesRequest request) throws ServiceLayerException {
		
		// Verifica os dados informados.
		
		if (request.getGroupId() == null || request.getGroupId().equals(new BigDecimal("0"))) {
			throw new ServiceLayerException(getMessage(MessageKeys.GROUP_CODE_NOT_INFORMED.getKey()));
		}

		return companyDAO.searchCompanies(request);
		
	}

}
