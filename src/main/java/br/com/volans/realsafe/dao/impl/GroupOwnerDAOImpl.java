package br.com.volans.realsafe.dao.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import br.com.volans.realsafe.dao.GroupOwnerDAO;
import br.com.volans.realsafe.dto.GroupOwnerDTO;
import br.com.volans.realsafe.model.GroupOwner;
import br.com.volans.realsafe.model.GroupOwner_;

/**
 * Implementação da interface do DAO de proprietário de grupos.
 * 
 * @author Volans Informática Ltda
 */

@Repository
public class GroupOwnerDAOImpl implements GroupOwnerDAO {
	
	/**
	 * Declaração das variáveis membro
	 */
	
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Construtor default da classe
	 */
	
	public GroupOwnerDAOImpl() {
		super();
	}
	
	/**
	 * Pesquisa pelo único proprietário de grupos da tabela.
	 * 
	 * @return - Dados do grupo pesquisado.
	 */
	
	@Override
	public GroupOwnerDTO findSingleLocal() {
		
		GroupOwnerDTO result = null; 
				
		try {
			
			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
			CriteriaQuery<GroupOwnerDTO> cq = cb.createQuery(GroupOwnerDTO.class);
			
			Root<GroupOwner> groupOwner = cq.from(GroupOwner.class);
			
			cq.multiselect(
				groupOwner.get(GroupOwner_.groupOwnerId),
				groupOwner.get(GroupOwner_.groupOwnerName),
				groupOwner.get(GroupOwner_.businessName),
				groupOwner.get(GroupOwner_.contactName),
				groupOwner.get(GroupOwner_.address),
				groupOwner.get(GroupOwner_.addressNumber),
				groupOwner.get(GroupOwner_.addressComplement),
				groupOwner.get(GroupOwner_.addressNeighborhood),
				groupOwner.get(GroupOwner_.cityName),
				groupOwner.get(GroupOwner_.stateCode),
				groupOwner.get(GroupOwner_.countryCode),
				groupOwner.get(GroupOwner_.zipCode),
				groupOwner.get(GroupOwner_.phoneCountryCode),
				groupOwner.get(GroupOwner_.phoneAreaCode),
				groupOwner.get(GroupOwner_.phoneNumber),
				groupOwner.get(GroupOwner_.celCountryCode),
				groupOwner.get(GroupOwner_.celAreaCode),
				groupOwner.get(GroupOwner_.celNumber),
				groupOwner.get(GroupOwner_.stateRegistration),
				groupOwner.get(GroupOwner_.municipalRegistration),
				groupOwner.get(GroupOwner_.siteAddress),
				groupOwner.get(GroupOwner_.emailAddress),
				groupOwner.get(GroupOwner_.additionalInfo),
				groupOwner.get(GroupOwner_.status),
				groupOwner.get(GroupOwner_.creationDate),
				groupOwner.get(GroupOwner_.creationUser),
				groupOwner.get(GroupOwner_.lastUpdate),
				groupOwner.get(GroupOwner_.updateUser)
			);
			
			TypedQuery<GroupOwnerDTO> query = entityManager.createQuery(cq);
			
			query.setMaxResults(1);
			
			result = query.getSingleResult();
			
		}
		catch (NoResultException ex) {
			// Nothing to do
		}
		
		return result;

	}

	@Override
	public List<GroupOwnerDTO> listAll() {
		
		List<GroupOwnerDTO> result = null;
		
		try {
			
			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
			CriteriaQuery<GroupOwnerDTO> cq = cb.createQuery(GroupOwnerDTO.class);
			
			Root<GroupOwner> groupOwner = cq.from(GroupOwner.class);
			
			cq.multiselect(
				groupOwner.get(GroupOwner_.groupOwnerId),
				groupOwner.get(GroupOwner_.groupOwnerName),
				groupOwner.get(GroupOwner_.businessName),
				groupOwner.get(GroupOwner_.contactName),
				groupOwner.get(GroupOwner_.address),
				groupOwner.get(GroupOwner_.addressNumber),
				groupOwner.get(GroupOwner_.addressComplement),
				groupOwner.get(GroupOwner_.addressNeighborhood),
				groupOwner.get(GroupOwner_.cityName),
				groupOwner.get(GroupOwner_.stateCode),
				groupOwner.get(GroupOwner_.countryCode),
				groupOwner.get(GroupOwner_.zipCode),
				groupOwner.get(GroupOwner_.phoneCountryCode),
				groupOwner.get(GroupOwner_.phoneAreaCode),
				groupOwner.get(GroupOwner_.phoneNumber),
				groupOwner.get(GroupOwner_.celCountryCode),
				groupOwner.get(GroupOwner_.celAreaCode),
				groupOwner.get(GroupOwner_.celNumber),
				groupOwner.get(GroupOwner_.stateRegistration),
				groupOwner.get(GroupOwner_.municipalRegistration),
				groupOwner.get(GroupOwner_.siteAddress),
				groupOwner.get(GroupOwner_.emailAddress),
				groupOwner.get(GroupOwner_.additionalInfo),
				groupOwner.get(GroupOwner_.status),
				groupOwner.get(GroupOwner_.creationDate),
				groupOwner.get(GroupOwner_.creationUser),
				groupOwner.get(GroupOwner_.lastUpdate),
				groupOwner.get(GroupOwner_.updateUser)
			);
			
			TypedQuery<GroupOwnerDTO> query = entityManager.createQuery(cq);
			
			result = query.getResultList();
			
		}
		catch (NoResultException ex) {
			// Nothing to do
		}
		
		return result;
	}

	/**
	 * Pesquisa pelo proprietario de grupo a partir do id informado.
	 * 
	 * @param id - Identificador do proprietario
	 * 
	 * @return - Dados do proprietario pesquisado.
	 */
	
	@Override
	public GroupOwnerDTO findById(BigDecimal groupOwnerId) {
		
		GroupOwnerDTO result = null; 
		
		try {
			
			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
			CriteriaQuery<GroupOwnerDTO> cq = cb.createQuery(GroupOwnerDTO.class);
			
			Root<GroupOwner> groupOwner = cq.from(GroupOwner.class);
			
			cq.multiselect(
				groupOwner.get(GroupOwner_.groupOwnerId),
				groupOwner.get(GroupOwner_.groupOwnerName),
				groupOwner.get(GroupOwner_.businessName),
				groupOwner.get(GroupOwner_.contactName),
				groupOwner.get(GroupOwner_.address),
				groupOwner.get(GroupOwner_.addressNumber),
				groupOwner.get(GroupOwner_.addressComplement),
				groupOwner.get(GroupOwner_.addressNeighborhood),
				groupOwner.get(GroupOwner_.cityName),
				groupOwner.get(GroupOwner_.stateCode),
				groupOwner.get(GroupOwner_.countryCode),
				groupOwner.get(GroupOwner_.zipCode),
				groupOwner.get(GroupOwner_.phoneCountryCode),
				groupOwner.get(GroupOwner_.phoneAreaCode),
				groupOwner.get(GroupOwner_.phoneNumber),
				groupOwner.get(GroupOwner_.celCountryCode),
				groupOwner.get(GroupOwner_.celAreaCode),
				groupOwner.get(GroupOwner_.celNumber),
				groupOwner.get(GroupOwner_.stateRegistration),
				groupOwner.get(GroupOwner_.municipalRegistration),
				groupOwner.get(GroupOwner_.siteAddress),
				groupOwner.get(GroupOwner_.emailAddress),
				groupOwner.get(GroupOwner_.additionalInfo),
				groupOwner.get(GroupOwner_.status),
				groupOwner.get(GroupOwner_.creationDate),
				groupOwner.get(GroupOwner_.creationUser),
				groupOwner.get(GroupOwner_.lastUpdate),
				groupOwner.get(GroupOwner_.updateUser)
			);
			
			cq.where(
				cb.equal(groupOwner.get(GroupOwner_.groupOwnerId), groupOwnerId)
			);
			
			TypedQuery<GroupOwnerDTO> query = entityManager.createQuery(cq);
			
			result = query.getSingleResult();
			
		}
		catch (NoResultException ex) {
			// Nothing to do
		}
		
		return result;
		
	}

	/**
	 * Inclui um novo proprietário da base de dados.
	 * 
	 * @param groupOwner - Objeto com os dados a serem incluidos.
	 * 
	 * @return - Dados do proprietario incluido.
	 */
	
	@Override
	public GroupOwnerDTO create(GroupOwnerDTO groupOwnerDTO) {
		
		GroupOwner groupOwner = new GroupOwner();
		
		BeanUtils.copyProperties(groupOwnerDTO, groupOwner);
		
		entityManager.persist(groupOwner);
		
		return groupOwnerDTO;
		
	}

}
