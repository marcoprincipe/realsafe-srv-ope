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

import br.com.volans.realsafe.dao.TerminalStatusDAO;
import br.com.volans.realsafe.dto.TerminalStatusDTO;
import br.com.volans.realsafe.model.TerminalStatus;
import br.com.volans.realsafe.model.TerminalStatus_;

/**
 * Implementação da interface do DAO de status de terminais.
 * 
 * @author Volans Informática Ltda
 */

@Repository
public class TerminalStatusDAOImpl implements TerminalStatusDAO {
	
	/**
	 * Declaração das variáveis membro
	 */
	
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Construtor default da classe
	 */
	
	public TerminalStatusDAOImpl() {
		super();
	}
	
	/**
	 * Retorna os dados do status do terminal local.
	 * 
	 * @return - Dados do status do terminal.
	 */
	
	@Override
	public TerminalStatusDTO findSingleLocal() {
		
		TerminalStatusDTO result = null; 
				
		try {
			
			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
			CriteriaQuery<TerminalStatusDTO> cq = cb.createQuery(TerminalStatusDTO.class);
			
			Root<TerminalStatus> terminalStatus = cq.from(TerminalStatus.class);
			
			cq.multiselect(
				terminalStatus.get(TerminalStatus_.terminalId),
				terminalStatus.get(TerminalStatus_.accountingDate),
				terminalStatus.get(TerminalStatus_.banknotesInSafe),
				terminalStatus.get(TerminalStatus_.amountInSafe),
				terminalStatus.get(TerminalStatus_.lastOpeningDateTime),
				terminalStatus.get(TerminalStatus_.lastOpeningBanknotes),
				terminalStatus.get(TerminalStatus_.lastOpeningAmount),
				terminalStatus.get(TerminalStatus_.lastClosingDateTime),
				terminalStatus.get(TerminalStatus_.lastClosingBanknotes),
				terminalStatus.get(TerminalStatus_.lastClosingAmount),
				terminalStatus.get(TerminalStatus_.etvClosing),
				terminalStatus.get(TerminalStatus_.status),
				cb.currentTimestamp()
			);
			
			TypedQuery<TerminalStatusDTO> query = entityManager.createQuery(cq);
			
			result = query.getSingleResult();
			
		}
		catch (NoResultException ex) {
			// Nothing to do
		}
		
		return result;

	}
	
	/**
	 * Retorna os dados do status do terminal informado.
	 * 
	 * @param terminalId - Identificador do terminal.
	 * 
	 * @return - Dados do status do terminal.
	 */
	
	@Override
	public TerminalStatusDTO findByTerminalId(String terminalId) {
		
		TerminalStatusDTO result = null; 
				
		try {
			
			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
			CriteriaQuery<TerminalStatusDTO> cq = cb.createQuery(TerminalStatusDTO.class);
			
			Root<TerminalStatus> terminalStatus = cq.from(TerminalStatus.class);
			
			cq.multiselect(
				terminalStatus.get(TerminalStatus_.terminalId),
				terminalStatus.get(TerminalStatus_.accountingDate),
				terminalStatus.get(TerminalStatus_.banknotesInSafe),
				terminalStatus.get(TerminalStatus_.amountInSafe),
				terminalStatus.get(TerminalStatus_.lastOpeningDateTime),
				terminalStatus.get(TerminalStatus_.lastOpeningBanknotes),
				terminalStatus.get(TerminalStatus_.lastOpeningAmount),
				terminalStatus.get(TerminalStatus_.lastClosingDateTime),
				terminalStatus.get(TerminalStatus_.lastClosingBanknotes),
				terminalStatus.get(TerminalStatus_.lastClosingAmount),
				terminalStatus.get(TerminalStatus_.etvClosing),
				terminalStatus.get(TerminalStatus_.status),
				cb.currentTimestamp()
			);
			
			cq.where(
				cb.equal(terminalStatus.get(TerminalStatus_.terminalId), terminalId)
			);
			
			TypedQuery<TerminalStatusDTO> query = entityManager.createQuery(cq);
			
			result = query.getSingleResult();
			
		}
		catch (NoResultException ex) {
			// Nothing to do
		}
		
		return result;

	}
	
	/**
	 * Atualiza o status do terminal.
	 * 
	 * @param terminalStatus - Objeto com os dados a serem atualizados.
	 * 
	 * @return
	 */
	
	@Override
	public Integer update(TerminalStatus terminalStatus) {
		
		Integer rowsAffected = 0; 
				
		try {
			
			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
			CriteriaUpdate<TerminalStatus> update = cb.createCriteriaUpdate(TerminalStatus.class);
			
			Root<TerminalStatus> root = update.from(TerminalStatus.class);
			
			update.set(TerminalStatus_.accountingDate, terminalStatus.getAccountingDate());
			update.set(TerminalStatus_.banknotesInSafe, terminalStatus.getBanknotesInSafe());
			update.set(TerminalStatus_.amountInSafe, terminalStatus.getAmountInSafe());
			update.set(TerminalStatus_.lastOpeningDateTime, terminalStatus.getLastOpeningDateTime());
			update.set(TerminalStatus_.lastOpeningBanknotes, terminalStatus.getLastOpeningBanknotes());
			update.set(TerminalStatus_.lastOpeningAmount, terminalStatus.getLastOpeningAmount());
			update.set(TerminalStatus_.lastClosingDateTime, terminalStatus.getLastClosingDateTime());
			update.set(TerminalStatus_.lastClosingBanknotes, terminalStatus.getLastClosingBanknotes());
			update.set(TerminalStatus_.lastClosingAmount, terminalStatus.getLastClosingAmount());
			update.set(TerminalStatus_.status, terminalStatus.getStatus());
			update.set(TerminalStatus_.etvClosing, terminalStatus.getEtvClosing());
			
			update.where(cb.equal(root.get(TerminalStatus_.terminalId), terminalStatus.getTerminalId()));
			
			rowsAffected = entityManager.createQuery(update).executeUpdate();
			
		}
		catch (NoResultException ex) {
			// Nothing to do
		}
		
		return rowsAffected;

	}

}
