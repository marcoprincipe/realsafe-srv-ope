package br.com.volans.realsafe.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import br.com.volans.realsafe.dao.ClosingDetailDAO;
import br.com.volans.realsafe.dto.ClosingDetailDTO;
import br.com.volans.realsafe.model.ClosingDetail;
import br.com.volans.realsafe.model.ClosingDetail_;

/**
 * Implementação da interface do DAO de detalhes de fechamento.
 * 
 * @author Volans Informática Ltda
 */

@Repository
public class ClosingDetailDAOImpl implements ClosingDetailDAO {
	
	/**
	 * Declaração das variáveis membro
	 */
	
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Construtor default da classe
	 */
	
	public ClosingDetailDAOImpl() {
		super();
	}
	
	/**
	 * Efetua a inclusão de um detalhe de fechamento.
	 * 
	 * @param closingDetail - Instância da entidade de detalhes de fechamento.
	 * 
	 * @return - Instância da entidade de detalhes de fechamamento.
	 */
	
	@Override
	public ClosingDetail insert(ClosingDetail closingDetail) {
		
		entityManager.persist(closingDetail);
		
		return closingDetail;
		
	}
	
	/**
	 * Efetua a pesquisa de um detalhe de fechamento.
	 * 
	 * @param nsuTerminal - NSU da transação.
	 * 
	 * @return - DTO com os detalhes do fechamento.
	 */
	
	@Override
	public ClosingDetailDTO getClosingDetail(String nsuTerminal) {
		
		ClosingDetailDTO result = null;
		
		try {
			
			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
			CriteriaQuery<ClosingDetailDTO> cq = cb.createQuery(ClosingDetailDTO.class);
			
			Root<ClosingDetail> closingDetail = cq.from(ClosingDetail.class);
			
			cq.multiselect(
				closingDetail.get(ClosingDetail_.nsuTerminal),
				closingDetail.get(ClosingDetail_.closingDateTime),
				closingDetail.get(ClosingDetail_.bankNotesInSafe),
				closingDetail.get(ClosingDetail_.amountInSafe),
				closingDetail.get(ClosingDetail_.lastOpeningDateTime),
				closingDetail.get(ClosingDetail_.lastOpeningBanknotes),
				closingDetail.get(ClosingDetail_.lastOpeningAmount)
			);
			
			cq.where(
				cb.and(
					cb.equal(closingDetail.get(ClosingDetail_.nsuTerminal), nsuTerminal)
				)
			);
			
			TypedQuery<ClosingDetailDTO> query = entityManager.createQuery(cq);
			
			result = query.getSingleResult();
			
		}
		catch (NoResultException ex) {
			// Nothing to do
		}
		
		return result;

	}

}
