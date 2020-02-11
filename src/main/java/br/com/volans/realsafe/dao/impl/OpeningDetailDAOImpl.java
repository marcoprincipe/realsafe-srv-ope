package br.com.volans.realsafe.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import br.com.volans.realsafe.dao.OpeningDetailDAO;
import br.com.volans.realsafe.dto.OpeningDetailDTO;
import br.com.volans.realsafe.model.OpeningDetail;
import br.com.volans.realsafe.model.OpeningDetail_;

/**
 * Implementação da interface do DAO de detalhes de abertura.
 * 
 * @author Volans Informática Ltda.
 */

@Repository
public class OpeningDetailDAOImpl implements OpeningDetailDAO {
	
	/**
	 * Declaração das variáveis membro
	 */
	
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Construtor default da classe
	 */
	
	public OpeningDetailDAOImpl() {
		super();
	}
	
	/**
	 * Efetua a inclusão de um detalhe de depósito.
	 * 
	 * @param openingDetail - Instância da entidade de detalhes de abertura.
	 * 
	 * @return - Instância da entidade de detalhes de abertura.
	 */
	
	@Override
	public OpeningDetail insert(OpeningDetail openingDetail) {
		
		entityManager.persist(openingDetail);
		
		return openingDetail;
		
	}
	
	/**
	 * Efetua a pesquisa de um detalhe de abertura.
	 * 
	 * @param nsuTerminal - NSU da transação.
	 * 
	 * @return - DTO com os detalhes da abertura.
	 */
	
	@Override
	public OpeningDetailDTO getOpeningDetail(String nsuTerminal) {
		
		OpeningDetailDTO result = null;
		
		try {
			
			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
			CriteriaQuery<OpeningDetailDTO> cq = cb.createQuery(OpeningDetailDTO.class);
			
			Root<OpeningDetail> openingDetail = cq.from(OpeningDetail.class);
			
			cq.multiselect(
				openingDetail.get(OpeningDetail_.nsuTerminal),
				openingDetail.get(OpeningDetail_.accountingDate),
				openingDetail.get(OpeningDetail_.openingDateTime),
				openingDetail.get(OpeningDetail_.bankNotesInSafe),
				openingDetail.get(OpeningDetail_.amountInSafe),
				openingDetail.get(OpeningDetail_.lastClosingDateTime),
				openingDetail.get(OpeningDetail_.lastClosingBanknotes),
				openingDetail.get(OpeningDetail_.lastClosingAmount),
				openingDetail.get(OpeningDetail_.etvClosing)
			);
			
			cq.where(
				cb.and(
					cb.equal(openingDetail.get(OpeningDetail_.nsuTerminal), nsuTerminal)
				)
			);
			
			TypedQuery<OpeningDetailDTO> query = entityManager.createQuery(cq);
			
			result = query.getSingleResult();
			
		}
		catch (NoResultException ex) {
			// Nothing to do
		}
		
		return result;
		
	}

}
