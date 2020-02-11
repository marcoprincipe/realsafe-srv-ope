package br.com.volans.realsafe.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import br.com.volans.realsafe.dao.DepositDetailDAO;
import br.com.volans.realsafe.dto.DepositDetailDTO;
import br.com.volans.realsafe.model.DepositDetail;
import br.com.volans.realsafe.model.DepositDetailPK_;
import br.com.volans.realsafe.model.DepositDetail_;

/**
 * Implementação da interface do DAO de detalhes de depósito.
 * 
 * @author Volans Informática Ltda
 */

@Repository
public class DepositDetailDAOImpl implements DepositDetailDAO {
	
	/**
	 * Declaração das variáveis membro
	 */
	
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Construtor default da classe
	 */
	
	public DepositDetailDAOImpl() {
		super();
	}
	
	/**
	 * Efetua a inclusão de um detalhe de depósito.
	 * 
	 * @param depositDetail - Instância da entidade de detalhes de depósito.
	 * 
	 * @return - Instância da entidade de detalhes de depósito.
	 */
	
	@Override
	public DepositDetail insert(DepositDetail depositDetail) {
		
		entityManager.persist(depositDetail);
		
		return depositDetail;
		
	}
	
	/**
	 * Efetua a pesquisa de um detalhe de depósito.
	 * 
	 * @param nsuTerminal - NSU da transação.
	 * 
	 * @return - Lista dos DTOs de detalhes de depósito.
	 */
	
	@Override
	public List<DepositDetailDTO> listDepositDetails(String nsuTerminal) {
		
		List<DepositDetailDTO> result = null;
		
		try {
			
			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
			CriteriaQuery<DepositDetailDTO> cq = cb.createQuery(DepositDetailDTO.class);
			
			Root<DepositDetail> depositDetail = cq.from(DepositDetail.class);
			
			cq.multiselect(
				depositDetail.get(DepositDetail_.quantity).as(Long.class),
				depositDetail.get(DepositDetail_.amount)
			);
			
			cq.where(
				cb.and(
					cb.equal(depositDetail.get(DepositDetail_.pk).get(DepositDetailPK_.nsuTerminal), nsuTerminal)
				)
			);
			
			TypedQuery<DepositDetailDTO> query = entityManager.createQuery(cq);
			
			result = query.getResultList();
			
		}
		catch (NoResultException ex) {
			// Nothing to do
		}
		
		return result;
		
	}
	
}
