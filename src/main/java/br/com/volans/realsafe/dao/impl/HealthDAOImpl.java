package br.com.volans.realsafe.dao.impl;

import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.volans.realsafe.dao.HealthDAO;

/**
 * Implementação da interface do DAO de checagem do banco de dados.
 * 
 * @author Volans Informática Ltda
 */

@Repository
public class HealthDAOImpl implements HealthDAO {
	
	/**
	 * Declaração das variáveis membro
	 */
	
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Construtor default da classe.
	 */
	
	public HealthDAOImpl() {
		super();
	}
	
	/**
	 * Seleciona a data e hora corrente
	 * 
	 * @return - Data e hora corrente.
	 */
	
	@Override
	public Timestamp selectTimeStamp() {
		
		Timestamp result = null;
		
		Query query = entityManager.createNativeQuery("SELECT CURRENT_TIMESTAMP();");
		
		result = (Timestamp) query.getSingleResult();
		
		return result;
		
	}

}
