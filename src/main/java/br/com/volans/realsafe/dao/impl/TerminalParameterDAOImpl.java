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

import br.com.volans.realsafe.dao.TerminalParameterDAO;
import br.com.volans.realsafe.dto.TerminalParameterDTO;
import br.com.volans.realsafe.model.TerminalParameter;
import br.com.volans.realsafe.model.TerminalParameter_;

/**
 * Implementação da interface do DAO de parâmetros do terminal.
 * 
 * @author Volans Informática Ltda.
 */

@Repository
public class TerminalParameterDAOImpl implements TerminalParameterDAO {
	
	/**
	 * Declaração das variáveis membro
	 */
	
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Construtor default da classe
	 */
	
	public TerminalParameterDAOImpl() {
		super();
	}
	
	/**
	 * Seleciona um parâmetro a partir do seu id.
	 * 
	 * @param parameterId - Identificador do parâmetro.
	 * 
	 * @return - DTO com os dados do parâmetro informado.
	 */
	
	@Override
	public TerminalParameterDTO findById(String parameterId) {
		
		TerminalParameterDTO result = null; 
				
		try {
			
			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
			CriteriaQuery<TerminalParameterDTO> cq = cb.createQuery(TerminalParameterDTO.class);
			
			Root<TerminalParameter> terminalParameter = cq.from(TerminalParameter.class);
			
			cq.multiselect(
				terminalParameter.get(TerminalParameter_.parameterId),
				terminalParameter.get(TerminalParameter_.parameterValue),
				terminalParameter.get(TerminalParameter_.description),
				terminalParameter.get(TerminalParameter_.status),
				terminalParameter.get(TerminalParameter_.creationDate)
			);
			
			cq.where(
				cb.equal(terminalParameter.get(TerminalParameter_.parameterId), parameterId)
			);
			
			TypedQuery<TerminalParameterDTO> query = entityManager.createQuery(cq);
			
			result = query.getSingleResult();
			
		}
		catch (NoResultException ex) {
			// Nothing to do
		}
		
		return result;

	}
	
	/**
	 * Lista todos os parâmetros da tabela.
	 * 
	 * @return - Lista de todos os parâmetros da tabela.
	 */
	
	@Override
	public List<TerminalParameterDTO> listAll() {
		
		List<TerminalParameterDTO> result = null; 
				
		try {
			
			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
			CriteriaQuery<TerminalParameterDTO> cq = cb.createQuery(TerminalParameterDTO.class);
			
			Root<TerminalParameter> terminalParameter = cq.from(TerminalParameter.class);
			
			cq.multiselect(
				terminalParameter.get(TerminalParameter_.parameterId),
				terminalParameter.get(TerminalParameter_.parameterValue),
				terminalParameter.get(TerminalParameter_.description),
				terminalParameter.get(TerminalParameter_.status),
				terminalParameter.get(TerminalParameter_.creationDate)
			);
			
			TypedQuery<TerminalParameterDTO> query = entityManager.createQuery(cq);
			
			result = query.getResultList();
			
		}
		catch (NoResultException ex) {
			// Nothing to do
		}
		
		return result;

	}

}
