package br.com.volans.realsafe.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.Root;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import br.com.volans.realsafe.dao.EventLogDAO;
import br.com.volans.realsafe.dto.EventLogDTO;
import br.com.volans.realsafe.model.EventLog;
import br.com.volans.realsafe.model.EventLog_;

/**
 * Implementação da interface do DAO de log de eventos.
 * 
 * @author Volans Informática Ltda.
 */

@Repository
public class EventLogDAOImpl implements EventLogDAO {
	
	/**
	 * Declaração das variáveis membro,
	 */
	
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Construtor default da classe.
	 */
	
	public EventLogDAOImpl() {
		super();
	}
	
	/**
	 * Efetua a inclusão de um log de evento.
	 * 
	 * @param EventLogDTO - Instância do DTO com os dados do log de evento.
	 * 
	 * @return - Instância do DTO com os dados do log de evento.
	 */

	@Override
	public EventLogDTO create(EventLogDTO eventLogDTO) {

		EventLog eventLog = new EventLog();
		
		BeanUtils.copyProperties(eventLogDTO, eventLog);
		
		entityManager.persist(eventLog);
		
		return eventLogDTO;
		
	}
	
	/**
	 * Efetua a exclusão de um log de evento
	 * 
	 * @param EventLogDTO - Instância do DTO com os dados do log de evento.
	 * 
	 * @return - Quantidade de linhas afetadas
	 */

	@Override
	public Integer remove(EventLogDTO eventLogDTO) {
		
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaDelete<EventLog> delete = cb.createCriteriaDelete(EventLog.class);
		
		Root<EventLog> root = delete.from(EventLog.class);
		
		delete.where(
			cb.equal(root.get(EventLog_.nsuEvent), eventLogDTO.getNsuEvent())
		);

		Integer rowsAffected = entityManager.createQuery(delete).executeUpdate();
		
		return rowsAffected;

	}

}
