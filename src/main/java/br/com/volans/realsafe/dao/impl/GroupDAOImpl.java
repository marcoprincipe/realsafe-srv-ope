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

import br.com.volans.realsafe.dao.GroupDAO;
import br.com.volans.realsafe.dto.GroupDTO;
import br.com.volans.realsafe.model.Group;
import br.com.volans.realsafe.model.Group_;

/**
 * Implementação da interface do DAO de grupos.
 * 
 * @author Volans Informática Ltda
 */

@Repository
public class GroupDAOImpl implements GroupDAO {
	
	/**
	 * Declaração das variáveis membro
	 */
	
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Construtor default da classe
	 */
	
	public GroupDAOImpl() {
		super();
	}

	/**
	 * Pesquisa pelo grupo a partir do id informado.
	 * 
	 * @param groupId - Identificador do grupo.
	 * 
	 * @return - Dados do grupo pesquisado.
	 */
	
	@Override
	public GroupDTO findById(BigDecimal groupId) {
		
		GroupDTO result = null; 
				
		try {
			
			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
			CriteriaQuery<GroupDTO> cq = cb.createQuery(GroupDTO.class);
			
			Root<Group> group = cq.from(Group.class);
			
			cq.multiselect(
				group.get(Group_.groupId),
				group.get(Group_.groupName),
				group.get(Group_.businessName),
				group.get(Group_.contactName),
				group.get(Group_.address),
				group.get(Group_.addressNumber),
				group.get(Group_.addressComplement),
				group.get(Group_.addressNeighborhood),
				group.get(Group_.cityName),
				group.get(Group_.stateCode),
				group.get(Group_.countryCode),
				group.get(Group_.zipCode),
				group.get(Group_.phoneCountryCode),
				group.get(Group_.phoneAreaCode),
				group.get(Group_.phoneNumber),
				group.get(Group_.celCountryCode),
				group.get(Group_.celAreaCode),
				group.get(Group_.celNumber),
				group.get(Group_.stateRegistration),
				group.get(Group_.municipalRegistration),
				group.get(Group_.siteAddress),
				group.get(Group_.emailAddress),
				group.get(Group_.additionalInfo),
				group.get(Group_.status),
				group.get(Group_.creationDate),
				group.get(Group_.creationUser),
				group.get(Group_.lastUpdate),
				group.get(Group_.updateUser),
				group.get(Group_.groupOwnerId)
			);
			
			cq.where(
				cb.equal(group.get(Group_.groupId), groupId)
			);
			
			TypedQuery<GroupDTO> query = entityManager.createQuery(cq);
			
			result = query.getSingleResult();
			
		}
		catch (NoResultException ex) {
			// Nothing to do
		}
		
		return result;
		
	}
	
	/**
	 * Retorna lista de grupos cadastrados.
	 * 
	 * @return - Lista de grupos cadastrados.
	 */
	
	@Override
	public List<GroupDTO> listAll() {
		
		List<GroupDTO> result = null;
		
		try {
			
			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
			CriteriaQuery<GroupDTO> cq = cb.createQuery(GroupDTO.class);
			
			Root<Group> group = cq.from(Group.class);
			
			cq.multiselect(
				group.get(Group_.groupId),
				group.get(Group_.groupName),
				group.get(Group_.businessName),
				group.get(Group_.contactName),
				group.get(Group_.address),
				group.get(Group_.addressNumber),
				group.get(Group_.addressComplement),
				group.get(Group_.addressNeighborhood),
				group.get(Group_.cityName),
				group.get(Group_.stateCode),
				group.get(Group_.countryCode),
				group.get(Group_.zipCode),
				group.get(Group_.phoneCountryCode),
				group.get(Group_.phoneAreaCode),
				group.get(Group_.phoneNumber),
				group.get(Group_.celCountryCode),
				group.get(Group_.celAreaCode),
				group.get(Group_.celNumber),
				group.get(Group_.stateRegistration),
				group.get(Group_.municipalRegistration),
				group.get(Group_.siteAddress),
				group.get(Group_.emailAddress),
				group.get(Group_.additionalInfo),
				group.get(Group_.status),
				group.get(Group_.creationDate),
				group.get(Group_.creationUser),
				group.get(Group_.lastUpdate),
				group.get(Group_.updateUser),
				group.get(Group_.groupOwnerId)

			);
			
			TypedQuery<GroupDTO> query = entityManager.createQuery(cq);
			
			result = query.getResultList();
			
		}
		catch (NoResultException ex) {
			// Nothing to do
		}
		
		return result;
		
	}

	/**
	 * Inclui um novo grupo na base de dados.
	 * 
	 * @param group - Objeto com os dados a serem incluidos.
	 * 
	 * @return - Dados do grupo incluido.
	 */
	
	@Override
	public GroupDTO create(GroupDTO groupDTO) {

		Group group = new Group();
		
		BeanUtils.copyProperties(groupDTO, group);
		
		entityManager.persist(group);
		
		return groupDTO;
		
	}

}
