package br.com.volans.realsafe.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import br.com.volans.realsafe.dao.CashCollectionDetailDAO;
import br.com.volans.realsafe.dto.TransactionLogDTO;
import br.com.volans.realsafe.model.CashCollectionDetail;
import br.com.volans.realsafe.model.CashCollectionDetail_;
import br.com.volans.realsafe.model.Company;
import br.com.volans.realsafe.model.Company_;
import br.com.volans.realsafe.model.Functionality;
import br.com.volans.realsafe.model.Functionality_;
import br.com.volans.realsafe.model.TransactionLog;
import br.com.volans.realsafe.model.TransactionLog_;
import br.com.volans.realsafe.model.Unit;
import br.com.volans.realsafe.model.Unit_;
import br.com.volans.realsafe.model.User;
import br.com.volans.realsafe.model.User_;

/**
 * Implementação da interface do DAO de detalhes do recolhimento de numerário.
 * 
 * @author Volans Informática Ltda.
 */

@Repository
public class CashCollectionDetailDAOImpl implements CashCollectionDetailDAO {
	
	/**
	 * Declaração das variáveis membro
	 */
	
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Construtor default da classe
	 */
	
	public CashCollectionDetailDAOImpl() {
		super();
	}
	
	/**
	 * Efetua a inclusão dos detalhes de um recolhimento de numerário.
	 * 
	 * @param nsu - Novo NSU do terminal.
	 * @param terminalId - Identificador do terminal.
	 * @param status - Identificador do status da transação.
	 * @param functionalityId - Identificador da funcionalidade.
	 * 
	 * @return - Quantidade de linhas incluídas.
	 */
	@Override
	public Integer insert(String nsu, String terminalId, String status, Long functionalityId) {
		
		Query query = entityManager.createNamedQuery("insert_cash_collection_details");
		
		query.setParameter("nsu", nsu);
		query.setParameter("terminalId", terminalId);
		query.setParameter("status", status);
		query.setParameter("functionalityId", functionalityId);
		
		Integer rowsAffected = query.executeUpdate();
		
		return rowsAffected;
	}
	
	/**
	 * Retorna a lista de detalhes de um recolhimento de numerário.
	 * 
	 * @param cashCollectionNsu - NSU do recolhimento de numerário.
	 * 
	 * @return
	 */
	
	@Override
	public List<TransactionLogDTO> listCashCollectionDetails(String cashCollectionNsu) {
		
		List<TransactionLogDTO> result = null;
		
		try {
			
			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
			CriteriaQuery<TransactionLogDTO> cq = cb.createQuery(TransactionLogDTO.class);
			
			Root<CashCollectionDetail> cashCollectionDetail = cq.from(CashCollectionDetail.class);

			Join<CashCollectionDetail, TransactionLog> transactionLog  = cashCollectionDetail.join(CashCollectionDetail_.transactionLog);
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

			cq.where(
				cb.equal(cashCollectionDetail.get(CashCollectionDetail_.cashCollectionNsu), cashCollectionNsu)
			);
			
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
