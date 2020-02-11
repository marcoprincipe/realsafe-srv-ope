package br.com.volans.realsafe.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import br.com.volans.realsafe.dao.CompanyDAO;
import br.com.volans.realsafe.dto.CompanyDTO;
import br.com.volans.realsafe.dto.payload.SearchCompaniesRequest;
import br.com.volans.realsafe.dto.payload.SearchCompaniesResponse;
import br.com.volans.realsafe.model.Company;
import br.com.volans.realsafe.model.Company_;

/**
 * Implementação da interface do DAO de empresas.
 * 
 * @author Volans Informática Ltda
 */

@Repository
public class CompanyDAOImpl implements CompanyDAO {
	
	/**
	 * Declaração das variáveis membro
	 */
	
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Construtor default da classe
	 */
	
	public CompanyDAOImpl() {
		super();
	}
	
	/**
	 * Pesquisa pela empresa a partir do id informado.
	 * 
	 * @param id - Identificador da empresa
	 * 
	 * @return - Dados da empresa pesquisada.
	 */
	
	@Override
	public CompanyDTO findById(BigDecimal companyId) {
		
		CompanyDTO result = null; 
				
		try {
			
			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
			CriteriaQuery<CompanyDTO> cq = cb.createQuery(CompanyDTO.class);
			
			Root<Company> company = cq.from(Company.class);
			
			cq.multiselect(
				company.get(Company_.companyId),
				company.get(Company_.companyName),
				company.get(Company_.businessName),
				company.get(Company_.contactName),
				company.get(Company_.address),
				company.get(Company_.addressNumber),
				company.get(Company_.addressComplement),
				company.get(Company_.addressNeighborhood),
				company.get(Company_.cityName),
				company.get(Company_.stateCode),
				company.get(Company_.countryCode),
				company.get(Company_.zipCode),
				company.get(Company_.phoneCountryCode),
				company.get(Company_.phoneAreaCode),
				company.get(Company_.phoneNumber),
				company.get(Company_.celCountryCode),
				company.get(Company_.celAreaCode),
				company.get(Company_.celNumber),
				company.get(Company_.stateRegistration),
				company.get(Company_.municipalRegistration),
				company.get(Company_.siteAddress),
				company.get(Company_.emailAddress),
				company.get(Company_.additionalInfo),
				company.get(Company_.status),
				company.get(Company_.creationDate),
				company.get(Company_.creationUser),
				company.get(Company_.lastUpdate),
				company.get(Company_.updateUser),
				company.get(Company_.groupId)
			);
			
			cq.where(
				cb.equal(company.get(Company_.companyId), companyId)
			);
			
			TypedQuery<CompanyDTO> query = entityManager.createQuery(cq);
			
			result = query.getSingleResult();
			
		}
		catch (NoResultException ex) {
			// Nothing to do
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
		
		List<CompanyDTO> result = null;
		
		try {
			
			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
			CriteriaQuery<CompanyDTO> cq = cb.createQuery(CompanyDTO.class);
			
			Root<Company> company = cq.from(Company.class);
			
			cq.multiselect(
				company.get(Company_.companyId),
				company.get(Company_.companyName),
				company.get(Company_.businessName),
				company.get(Company_.contactName),
				company.get(Company_.address),
				company.get(Company_.addressNumber),
				company.get(Company_.addressComplement),
				company.get(Company_.addressNeighborhood),
				company.get(Company_.cityName),
				company.get(Company_.stateCode),
				company.get(Company_.countryCode),
				company.get(Company_.zipCode),
				company.get(Company_.phoneCountryCode),
				company.get(Company_.phoneAreaCode),
				company.get(Company_.phoneNumber),
				company.get(Company_.celCountryCode),
				company.get(Company_.celAreaCode),
				company.get(Company_.celNumber),
				company.get(Company_.stateRegistration),
				company.get(Company_.municipalRegistration),
				company.get(Company_.siteAddress),
				company.get(Company_.emailAddress),
				company.get(Company_.additionalInfo),
				company.get(Company_.status),
				company.get(Company_.creationDate),
				company.get(Company_.creationUser),
				company.get(Company_.lastUpdate),
				company.get(Company_.updateUser),
				company.get(Company_.groupId)
			);
			
			TypedQuery<CompanyDTO> query = entityManager.createQuery(cq);
			
			result = query.getResultList();
			
		}
		catch (NoResultException ex) {
			// Nothing to do
		}
		
		return result;
		
	}
	
	/**
	 * Efetua a inclusão de uma empresa
	 * 
	 * @param companyDTO - Instância da entidade de uma empresa.
	 * 
	 * @return - Instância da entidade da inserção de uma empresa
	 */
	
	@Override
	public CompanyDTO create(CompanyDTO companyDTO) {
		
		Company company = new Company();
		
		BeanUtils.copyProperties(companyDTO, company);
		
		entityManager.persist(company);
		
		return companyDTO;
		
	}

	/**
	 * Efetua a atualização de uma empresa
	 * 
	 * @param companyDTO - Instância da entidade de uma empresa.
	 * 
	 * @return - Instância da entidade da atualização de uma empresa
	 */
	
	@Override
	public CompanyDTO update(CompanyDTO companyDTO) {
		
		Company company = new Company();
		
		BeanUtils.copyProperties(companyDTO, company);
		
		entityManager.persist(company);
		
		return companyDTO;
	}
	
	/**
	 * Efetua a exclusão de uma empresa
	 * 
	 * @param companyDTO - Instância da entidade de uma empresa.
	 * 
	 * @return - Instância da entidade da atualização de uma empresa
	 */

	@Override
	public CompanyDTO remove(CompanyDTO companyDTO) {
		
		Company company = new Company();
		
		BeanUtils.copyProperties(companyDTO, company);
	
		Object obj = entityManager.merge(company);
		
		entityManager.remove(obj);
		
		return companyDTO;
	}
	
	/**
	 * Seleciona todas as operações da tabela
	 * 
	 * @param request
	 * 
	 * @return
	 */
	
	@Override
	public List<SearchCompaniesResponse> searchCompanies(SearchCompaniesRequest request) {
		
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<SearchCompaniesResponse> query = cb.createQuery(SearchCompaniesResponse.class);
		
		Root<Company> company = query.from(Company.class);
		
		query.select(cb.construct(SearchCompaniesResponse.class,
			company.get(Company_.companyId),				
			company.get(Company_.companyName),
			company.get(Company_.contactName),
			company.get(Company_.phoneNumber)
		));

		List<Predicate> predicates = new ArrayList<>();
		
		if (request != null) {
			
			if (request.getGroupId() != null) {
				predicates.add(cb.equal(company.get(Company_.groupId), request.getGroupId()));
			}
			
		}
		
		query.where(predicates.toArray(new Predicate[predicates.size()]));
		
		query.orderBy(cb.asc(company.get(Company_.companyName)));
		
		TypedQuery<SearchCompaniesResponse> typedQuery = entityManager.createQuery(query);
		
		List<SearchCompaniesResponse> list = typedQuery.getResultList();
		
		return list;
		
	}

}
