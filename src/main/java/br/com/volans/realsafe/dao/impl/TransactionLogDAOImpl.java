package br.com.volans.realsafe.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import br.com.volans.realsafe.dao.TransactionLogDAO;
import br.com.volans.realsafe.dto.TransactionLogDTO;
import br.com.volans.realsafe.model.Company;
import br.com.volans.realsafe.model.Company_;
import br.com.volans.realsafe.model.Functionality;
import br.com.volans.realsafe.model.Functionality_;
import br.com.volans.realsafe.model.TransactionLog;
import br.com.volans.realsafe.model.TransactionLog_;
import br.com.volans.realsafe.model.Unit;
import br.com.volans.realsafe.model.Unit_;
import br.com.volans.realsafe.model.User;
import br.com.volans.realsafe.model.UserPK_;
import br.com.volans.realsafe.model.User_;

/**
 * Implementação da interface do DAO de log de transações.
 * 
 * @author Volans Informática Ltda
 */

@Repository
public class TransactionLogDAOImpl implements TransactionLogDAO {
	
	/**
	 * Declaração das variáveis membro
	 */
	
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Construtor default da classe
	 */
	
	public TransactionLogDAOImpl() {
		super();
	}
	
	/**
	 * Efetua a inclusão de um log na tabela.
	 * 
	 * @param transactionLog - Instância da entidade de log de transação.
	 * 
	 * @return - Instância da entidade de log de transação.
	 */
	
	@Override
	public TransactionLog insert(TransactionLog transactionLog) {
		
		entityManager.persist(transactionLog);
		
		return transactionLog;
		
	}
	
	/**
	 * Obtem a lista de linhas de logs de transações de um proprietário de grupos.
	 * 
	 * @param groupOwnerId - Identificador do proprietário de grupos.
	 * 
	 * @return - Lista de linhas do log de transações.
	 */
	
	@Override
	public List<TransactionLogDTO> listTransactionLog(BigDecimal groupOwnerId) {
		
		List<TransactionLogDTO> result = null;
		
		try {
			
			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
			CriteriaQuery<TransactionLogDTO> cq = cb.createQuery(TransactionLogDTO.class);
			
			Root<TransactionLog> transactionLog = cq.from(TransactionLog.class);
	
			Join<TransactionLog, Unit> unit = transactionLog.join(TransactionLog_.unit);
			Join<Unit, Company> company = unit.join(Unit_.company);
			Join<TransactionLog, User> user = transactionLog.join(TransactionLog_.user);
			Join<TransactionLog, Functionality> functionality = transactionLog.join(TransactionLog_.functionality);
			
			cq.multiselect(
				transactionLog.get(TransactionLog_.groupOwnerId),
				transactionLog.get(TransactionLog_.terminalId),
				transactionLog.get(TransactionLog_.nsuTerminal),
				company.get(Company_.companyId),
				company.get(Company_.companyName),
				transactionLog.get(TransactionLog_.unitId),
				unit.get(Unit_.unitName),
				transactionLog.get(TransactionLog_.userId),
				user.get(User_.userName),
				transactionLog.get(TransactionLog_.functionalityId),
				functionality.get(Functionality_.name),
				transactionLog.get(TransactionLog_.accountingDate),
				transactionLog.get(TransactionLog_.dateTime),
				transactionLog.get(TransactionLog_.bankNotes),
				transactionLog.get(TransactionLog_.amount),
				transactionLog.get(TransactionLog_.status)
			);
			
			if (groupOwnerId != null) {
				cq.where(
					cb.equal(user.get(User_.pk).get(UserPK_.groupOwnerId), groupOwnerId)
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
	 * Obtem a lista de linhas de logs de transações de um terminal.
	 * 
	 * @param terminalId - Identificador do terminal.
	 * @param status - Identificador do status da transação.
	 * @param functionalityId - Identificador da funcionalidade.
	 * 
	 * @return - Lista de linhas do log de transações.
	 */
	
	@Override
	public List<TransactionLogDTO> listTransactionLog(String terminalId, String status, Long functionalityId) {
		
		List<TransactionLogDTO> result = null;
		
		try {
			
			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
			CriteriaQuery<TransactionLogDTO> cq = cb.createQuery(TransactionLogDTO.class);
			
			Root<TransactionLog> transactionLog = cq.from(TransactionLog.class);
	
			Join<TransactionLog, Unit> unit = transactionLog.join(TransactionLog_.unit);
			Join<Unit, Company> company = unit.join(Unit_.company);
			Join<TransactionLog, User> user = transactionLog.join(TransactionLog_.user);
			Join<TransactionLog, Functionality> functionality = transactionLog.join(TransactionLog_.functionality);
			
			cq.multiselect(
				transactionLog.get(TransactionLog_.groupOwnerId),
				transactionLog.get(TransactionLog_.terminalId),
				transactionLog.get(TransactionLog_.nsuTerminal),
				company.get(Company_.companyId),
				company.get(Company_.companyName),
				transactionLog.get(TransactionLog_.unitId),
				unit.get(Unit_.unitName),
				transactionLog.get(TransactionLog_.userId),
				user.get(User_.userName),
				transactionLog.get(TransactionLog_.functionalityId),
				functionality.get(Functionality_.name),
				transactionLog.get(TransactionLog_.accountingDate),
				transactionLog.get(TransactionLog_.dateTime),
				transactionLog.get(TransactionLog_.bankNotes),
				transactionLog.get(TransactionLog_.amount),
				transactionLog.get(TransactionLog_.status)
			);
			
			List<Predicate> predicates = new ArrayList<Predicate>();
			
			if (terminalId != null) {
				predicates.add(cb.equal(transactionLog.get(TransactionLog_.terminalId), terminalId));
			}

			if (status != null) {
				predicates.add(cb.equal(transactionLog.get(TransactionLog_.status), status));
			}

			if (functionalityId != null && functionalityId > 0L) {
				predicates.add(cb.equal(transactionLog.get(TransactionLog_.functionalityId), functionalityId));
			}
			
			if (predicates.size() > 0) {
				cq.where(
					cb.and(predicates.toArray(new Predicate[predicates.size()]))
				);
			}
			
			cq.orderBy(
				cb.asc(company.get(Company_.companyName)),
				cb.asc(unit.get(Unit_.unitName)),
				cb.desc(transactionLog.get(TransactionLog_.dateTime))
			);
			
			TypedQuery<TransactionLogDTO> query = entityManager.createQuery(cq);
			
			result = query.getResultList();
			
		}
		catch (NoResultException ex) {
			// Nothing to do
		}
		
		return result;
		
	}
	
	/**
	 * Obtem a lista de linhas de logs de transações.
	 * 
	 * @param groupOwnerId - Identificador do proprietário de grupos.
	 * @param nsuTerminal - Identificador da transação.
	 * @param startDate - Data inicial para pesquisa.
	 * @param endDate - Data final para pesquisa.
	 * 
	 * @return - Lista de linhas do log de transações.
	 */
	
	@Override
	public List<TransactionLogDTO> searchTransactionLog(BigDecimal groupOwnerId, String nsuTerminal, Date startDate, Date endDate) {
		
		List<TransactionLogDTO> result = null;
		
		try {
			
			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
			CriteriaQuery<TransactionLogDTO> cq = cb.createQuery(TransactionLogDTO.class);
			
			Root<TransactionLog> transactionLog = cq.from(TransactionLog.class);
	
			Join<TransactionLog, Unit> unit = transactionLog.join(TransactionLog_.unit);
			Join<Unit, Company> company = unit.join(Unit_.company);
			Join<TransactionLog, User> user = transactionLog.join(TransactionLog_.user);
			Join<TransactionLog, Functionality> functionality = transactionLog.join(TransactionLog_.functionality);
			
			cq.multiselect(
				transactionLog.get(TransactionLog_.groupOwnerId),
				transactionLog.get(TransactionLog_.terminalId),
				transactionLog.get(TransactionLog_.nsuTerminal),
				company.get(Company_.companyId),
				company.get(Company_.companyName),
				transactionLog.get(TransactionLog_.unitId),
				unit.get(Unit_.unitName),
				transactionLog.get(TransactionLog_.userId),
				user.get(User_.userName),
				transactionLog.get(TransactionLog_.functionalityId),
				functionality.get(Functionality_.name),
				transactionLog.get(TransactionLog_.accountingDate),
				transactionLog.get(TransactionLog_.dateTime),
				transactionLog.get(TransactionLog_.bankNotes),
				transactionLog.get(TransactionLog_.amount),
				transactionLog.get(TransactionLog_.status)
			);
			
			List<Predicate> predicates = new ArrayList<Predicate>();
			
			if (groupOwnerId != null) {
				predicates.add(cb.equal(transactionLog.get(TransactionLog_.groupOwnerId), groupOwnerId));
			}
			
			if (nsuTerminal != null && !nsuTerminal.trim().isEmpty()) {
				predicates.add(cb.equal(transactionLog.get(TransactionLog_.nsuTerminal), nsuTerminal));
			}

			if (startDate != null) {
				predicates.add(cb.greaterThanOrEqualTo(transactionLog.get(TransactionLog_.dateTime), startDate));
			}

			if (endDate != null) {
				predicates.add(cb.lessThanOrEqualTo(transactionLog.get(TransactionLog_.dateTime), endDate));
			}
			
			if (predicates.size() > 0) {
				cq.where(
					cb.and(predicates.toArray(new Predicate[predicates.size()]))
				);
			}
			
			cq.orderBy(cb.desc(transactionLog.get(TransactionLog_.dateTime)));
			
			TypedQuery<TransactionLogDTO> query = entityManager.createQuery(cq);
			
			result = query.getResultList();
			
		}
		catch (NoResultException ex) {
			// Nothing to do
		}
		
		return result;
		
	}

}
