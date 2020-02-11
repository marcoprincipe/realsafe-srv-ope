package br.com.volans.realsafe.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import br.com.volans.realsafe.dao.CashCollectionDAO;
import br.com.volans.realsafe.dto.DepositDetailDTO;
import br.com.volans.realsafe.dto.TransactionLogDTO;
import br.com.volans.realsafe.enums.TransactionStatuses;
import br.com.volans.realsafe.enums.Transactions;
import br.com.volans.realsafe.model.DepositDetail;
import br.com.volans.realsafe.model.DepositDetailPK_;
import br.com.volans.realsafe.model.DepositDetail_;
import br.com.volans.realsafe.model.Functionality;
import br.com.volans.realsafe.model.Functionality_;
import br.com.volans.realsafe.model.TransactionLog;
import br.com.volans.realsafe.model.TransactionLog_;
import br.com.volans.realsafe.model.Unit;
import br.com.volans.realsafe.model.Unit_;
import br.com.volans.realsafe.model.User;
import br.com.volans.realsafe.model.User_;

/**
 * Implementação da interface do DAO de recolhimento de numerário.
 * 
 * @author Volans Informática Ltda
 */

@Repository
public class CashCollectionDAOImpl implements CashCollectionDAO {
	
	/**
	 * Declaração das variáveis membro
	 */
	
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Construtor default da classe
	 */
	
	public CashCollectionDAOImpl() {
		super();
	}
	
	/**
	 * Efetiva a coleta do recolhimento de numerário.
	 * 
	 * @param terminalId - Identificador do terminal.
	 * 
	 * @return - DTO com os detalhes da coleta do recolhimento do numerário.
	 */
	
	@Override
	public Integer collectCash(String terminalId) {
		
		Integer rowsAffected = 0; 
				
		try {
			
			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
			
			CriteriaUpdate<TransactionLog> cq = cb.createCriteriaUpdate(TransactionLog.class);
			Root<TransactionLog> root = cq.from(TransactionLog.class);
			
			cq.set(
				TransactionLog_.status, TransactionStatuses.COLLECTED.getCode()
			);
			
			cq.where(
				cb.and(
					cb.equal(root.get(TransactionLog_.terminalId), terminalId),
					cb.equal(root.get(TransactionLog_.functionalityId), Transactions.DEPOSIT.getCode()),
					cb.equal(root.get(TransactionLog_.status), TransactionStatuses.PENDENT.getCode())
				)
			);
			
			rowsAffected = entityManager.createQuery(cq).executeUpdate();
			
		}
		catch (NoResultException ex) {
			// Nothing to do
		}
		
		return rowsAffected;
		
	}
	
	/**
	 * Efetua a pesquisa dos logs para o recolhimento de numerário.
	 * 
	 * @param terminalId - Identificador do terminal.
	 * 
	 * @return - DTO com os logs para o recolhimento de numerário.
	 */
	
	@Override
	public List<TransactionLogDTO> listCashCollectionLogs(String terminalId) {
		
		List<TransactionLogDTO> result = null;
		
		try {
			
			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
			CriteriaQuery<TransactionLogDTO> cq = cb.createQuery(TransactionLogDTO.class);
			
			Root<TransactionLog> transactionLog = cq.from(TransactionLog.class);
	
			Join<TransactionLog, Unit> unit = transactionLog.join(TransactionLog_.unit);
			Join<TransactionLog, User> user = transactionLog.join(TransactionLog_.user);
			Join<TransactionLog, Functionality> functionality = transactionLog.join(TransactionLog_.functionality);
			
			cq.multiselect(
				transactionLog.get(TransactionLog_.groupOwnerId),
				transactionLog.get(TransactionLog_.terminalId),
				transactionLog.get(TransactionLog_.nsuTerminal),
				transactionLog.get(TransactionLog_.unitId),
				unit.get(Unit_.unitName),
				transactionLog.get(TransactionLog_.userId),
				user.get(User_.userName),
				transactionLog.get(TransactionLog_.functionalityId),
				functionality.get(Functionality_.name),
				transactionLog.get(TransactionLog_.accountingDate),
				transactionLog.get(TransactionLog_.dateTime),
				transactionLog.get(TransactionLog_.amount),
				transactionLog.get(TransactionLog_.status)
			);
			
			if (terminalId != null) {
				cq.where(
					cb.and(
						cb.equal(transactionLog.get(TransactionLog_.terminalId), terminalId)),
						cb.equal(transactionLog.get(TransactionLog_.functionalityId), Transactions.DEPOSIT.getCode()),
						cb.equal(transactionLog.get(TransactionLog_.status), TransactionStatuses.PENDENT.getCode())
				);
			}
			
			TypedQuery<TransactionLogDTO> query = entityManager.createQuery(cq);
			
			result = query.getResultList();
			
		}
		catch (NoResultException ex) {
			// Nothing to do
		}
		
		return result;
		
	}
	
	/**
	 * Efetua a pesquisa do recolhimento de numerário.
	 * 
	 * @param terminalId - Identificador do terminal.
	 * 
	 * @return - DTO com os detalhes do recolhimento do numerário.
	 */
	
	@Override
	public List<DepositDetailDTO> listCashCollection(String terminalId) {
		
		List<DepositDetailDTO> result = null;
		
		try {
			
			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
			
			CriteriaQuery<DepositDetailDTO> cq = cb.createQuery(DepositDetailDTO.class);
			
			Root<TransactionLog> transactionLog = cq.from(TransactionLog.class);
			Root<DepositDetail> depositDetail = cq.from(DepositDetail.class);
			
			cq.multiselect(
				cb.sum(depositDetail.get(DepositDetail_.quantity)),
				depositDetail.get(DepositDetail_.amount)
			);
			
			cq.where(
				cb.and(
					cb.equal(transactionLog.get(TransactionLog_.terminalId), terminalId),
					cb.equal(transactionLog.get(TransactionLog_.functionalityId), Transactions.DEPOSIT.getCode()),
					cb.equal(depositDetail.get(DepositDetail_.pk).get(DepositDetailPK_.nsuTerminal), transactionLog.get(TransactionLog_.nsuTerminal)),
					cb.equal(transactionLog.get(TransactionLog_.status), TransactionStatuses.PENDENT.getCode())
				)
			);
			
			cq.groupBy(
				depositDetail.get(DepositDetail_.amount)
			);
			
			cq.orderBy(
				cb.desc(depositDetail.get(DepositDetail_.amount))
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
