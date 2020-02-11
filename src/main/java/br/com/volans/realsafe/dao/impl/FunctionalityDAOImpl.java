package br.com.volans.realsafe.dao.impl;

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

import br.com.volans.realsafe.dao.FunctionalityDAO;
import br.com.volans.realsafe.dto.FunctionalityDTO;
import br.com.volans.realsafe.model.Functionality;
import br.com.volans.realsafe.model.Functionality_;

/**
 * Implementação da interface do DAO de funcionalidades operacionais.
 * 
 * @author Volans Informática Ltda.
 */

@Repository
public class FunctionalityDAOImpl implements FunctionalityDAO {
	
	/**
	 * Declaração das variáveis membro
	 */
	
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Construtor default da classe
	 */
	
	public FunctionalityDAOImpl() {
		super();
	}
	
	/**
	 * Retorna lista de funcionalidades operacionais da aplicação.
	 * 
	 * @return - Lista de funcionalidades operacionais.
	 */
	
	@Override
	public List<FunctionalityDTO> listAll() {
		
		List<FunctionalityDTO> result = null;
		
		try {
			
			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
			CriteriaQuery<FunctionalityDTO> cq = cb.createQuery(FunctionalityDTO.class);
			
			Root<Functionality> functionality = cq.from(Functionality.class);
			
			cq.multiselect(
				functionality.get(Functionality_.functionalityId),
				functionality.get(Functionality_.name),
				functionality.get(Functionality_.description),
				functionality.get(Functionality_.route),
				functionality.get(Functionality_.status),
				functionality.get(Functionality_.creationDate),
				functionality.get(Functionality_.parentId)
			);
			
			TypedQuery<FunctionalityDTO> query = entityManager.createQuery(cq);
			
			result = query.getResultList();
			
		}
		catch (NoResultException ex) {
			// Nothing to do
		}
		
		return result;
		
	}
	
	/**
	 * Pesquisa pela funcionalidade a partir do identificador informado.
	 * 
	 * @param functionalityId- Identificador da funcionalidade.
	 * 
	 * @return - Dados da funcionalidade pesquisada.
	 */
	
	@Override
	public FunctionalityDTO findById(Long functionalityId) {
		
		FunctionalityDTO result = null;
		
		try {
			
			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
			CriteriaQuery<FunctionalityDTO> cq = cb.createQuery(FunctionalityDTO.class);
			
			Root<Functionality> functionality = cq.from(Functionality.class);
			
			cq.multiselect(
				functionality.get(Functionality_.functionalityId),
				functionality.get(Functionality_.name),
				functionality.get(Functionality_.description),
				functionality.get(Functionality_.route),
				functionality.get(Functionality_.status),
				functionality.get(Functionality_.creationDate),
				functionality.get(Functionality_.parentId)
			);
			
			cq.where(
				cb.equal(functionality.get(Functionality_.functionalityId), functionalityId)
			);
			
			TypedQuery<FunctionalityDTO> query = entityManager.createQuery(cq);
			
			result = query.getSingleResult();
			
		}
		catch (NoResultException ex) {
			// Nothing to do
		}
		
		return result;
		
	}
	
	/**
	 * Inclui uma nova funcionalidade na base de dados.
	 * 
	 * @param functionalityDTO - Dados a serem incluídos.
	 * 
	 * @return - Dados da funcionalidade incluida.
	 */
	
	@Override
	public FunctionalityDTO create(FunctionalityDTO functionalityDTO) {
		
		Functionality functionality = new Functionality();
		
		BeanUtils.copyProperties(functionalityDTO, functionality);
		
		entityManager.persist(functionality);

		return functionalityDTO;
		
	}

}
