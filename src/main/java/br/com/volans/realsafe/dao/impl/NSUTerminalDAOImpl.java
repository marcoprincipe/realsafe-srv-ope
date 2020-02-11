package br.com.volans.realsafe.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import br.com.volans.realsafe.dao.NSUTerminalDAO;
import br.com.volans.realsafe.dto.NSUTerminalDTO;
import br.com.volans.realsafe.model.NSUTerminal;
import br.com.volans.realsafe.model.NSUTerminal_;

/**
 * Implementação da interface do DAO de nsu de terminais.
 * 
 * @author Volans Informática Ltda
 */

@Repository
public class NSUTerminalDAOImpl implements NSUTerminalDAO {
	
	/**
	 * Declaração das variáveis membro
	 */
	
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Construtor default da classe
	 */
	
	public NSUTerminalDAOImpl() {
		super();
	}

	/**
	 * Retorna os dados do nsu do terminal informado.
	 * 
	 * terminalId - Identificador do terminal.
	 * 
	 * @return - Dados do NSU do terminal.
	 */
	
	@Override
	public NSUTerminalDTO select(String terminalId) {
		
		NSUTerminalDTO result = null; 
				
		try {
			
			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
			CriteriaQuery<NSUTerminalDTO> cq = cb.createQuery(NSUTerminalDTO.class);
			
			Root<NSUTerminal> nsuTerminal = cq.from(NSUTerminal.class);
			
			cq.multiselect(
				nsuTerminal.get(NSUTerminal_.terminalId),
				nsuTerminal.get(NSUTerminal_.nsuTerminal),
				cb.currentTimestamp()
			);
			
			cq.where(cb.equal(nsuTerminal.get(NSUTerminal_.terminalId), terminalId));
			
			TypedQuery<NSUTerminalDTO> query = entityManager.createQuery(cq);
			
			query.setMaxResults(1);
			
			result = query.getSingleResult();
			
		}
		catch (NoResultException ex) {
			// Nothing to do
		}
		
		return result;

	}
	
	/**
	 * Atualiza os dados do nsu do terminal informado.
	 * 
	 * @param nsuTerminal - Dados do NSU a ser atualizado.
	 * 
	 * @return - Quantidade de linhas atualizadas.
	 */
	
	@Override
	public Integer update(NSUTerminal nsuTerminal) {
		
		Integer rowsAffected = 0; 
				
		try {
			
			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
			CriteriaUpdate<NSUTerminal> update = cb.createCriteriaUpdate(NSUTerminal.class);
			
			Root<NSUTerminal> root = update.from(NSUTerminal.class);
			
			update.set(NSUTerminal_.nsuTerminal, nsuTerminal.getNsuTerminal());
			
			update.where(cb.equal(root.get(NSUTerminal_.terminalId), nsuTerminal.getTerminalId()));
			
			rowsAffected = entityManager.createQuery(update).executeUpdate();
			
		}
		catch (NoResultException ex) {
			// Nothing to do
		}
		
		return rowsAffected;
		
	}

}
