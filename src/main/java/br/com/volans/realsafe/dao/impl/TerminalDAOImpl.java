package br.com.volans.realsafe.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import br.com.volans.realsafe.dao.TerminalDAO;
import br.com.volans.realsafe.dto.TerminalDTO;
import br.com.volans.realsafe.model.Terminal;
import br.com.volans.realsafe.model.Terminal_;

/**
 * Implementação da interface do DAO de terminais.
 * 
 * @author Volans Informática Ltda
 */

@Repository
public class TerminalDAOImpl implements TerminalDAO {
	
	/**
	 * Declaração das variáveis membro
	 */
	
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Construtor default da classe
	 */
	
	public TerminalDAOImpl() {
		super();
	}

	/**
	 * Pesquisa pelo terminal a partir do identificador informado.
	 * 
	 * @param terminalId - Identificador do terminal.
	 * 
	 * @return - Dados do terminal.
	 */
	
	@Override
	public TerminalDTO findById(String terminalId) {
		
		TerminalDTO result = null; 
				
		try {
			
			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
			CriteriaQuery<TerminalDTO> cq = cb.createQuery(TerminalDTO.class);
			
			Root<Terminal> terminal = cq.from(Terminal.class);
			
			cq.multiselect(
				terminal.get(Terminal_.terminalId),
				terminal.get(Terminal_.terminalName),
				terminal.get(Terminal_.status),
				terminal.get(Terminal_.creationDate),
				terminal.get(Terminal_.unitId)
			);
			
			cq.where(
				cb.equal(terminal.get(Terminal_.terminalId), terminal)
			);
			
			TypedQuery<TerminalDTO> query = entityManager.createQuery(cq);
			
			result = query.getSingleResult();
			
		}
		catch (NoResultException ex) {
			// Nothing to do
		}
		
		return result;

	}

	/**
	 * Inclui um novo terminal na tabela.
	 * 
	 * @param terminalDTO - Dados do terminal a ser incluido.
	 * 
	 * @return - Dados do terminal incluido.
	 */
	
	@Override
	public TerminalDTO crate(TerminalDTO terminalDTO) {
		
		Terminal terminal = new Terminal();
		
		BeanUtils.copyProperties(terminalDTO, terminal);
		
		entityManager.persist(terminal);
		
		return terminalDTO;
		
	}

	/**
	 * Pesquisa pelo único terminal da tabela local.
	 * 
	 * @return - Dados do terminal.
	 */
	
	@Override
	public TerminalDTO findSingleLocal() {
		
		TerminalDTO result = null; 
				
		try {
			
			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
			CriteriaQuery<TerminalDTO> cq = cb.createQuery(TerminalDTO.class);
			
			Root<Terminal> terminal = cq.from(Terminal.class);
			
			cq.multiselect(
				terminal.get(Terminal_.terminalId),
				terminal.get(Terminal_.terminalName),
				terminal.get(Terminal_.status),
				terminal.get(Terminal_.creationDate),
				terminal.get(Terminal_.unitId)
			);
			
			TypedQuery<TerminalDTO> query = entityManager.createQuery(cq);
			
			query.setMaxResults(1);
			
			result = query.getSingleResult();
			
		}
		catch (NoResultException ex) {
			// Nothing to do
		}
		
		return result;

	}

}
