package br.com.volans.realsafe.dao.impl;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import br.com.volans.realsafe.dao.ParameterDAO;
import br.com.volans.realsafe.dto.ParameterDTO;
import br.com.volans.realsafe.model.Parameter;

/**
 * Implementação da interface do DAO de parâmetros.
 * 
 * @author Volans Informática Ltda
 */

@Repository
public class ParameterDAOImpl implements ParameterDAO {
	
	/**
	 * Declaração das variáveis membro
	 */
	
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Construtor default da classe
	 */
	
	public ParameterDAOImpl() {
		super();
	}

	/**
	 * Pesquisa pelo parâmetro a partir do id informado.
	 * 
	 * @param groupOwnerId - Identificador do proprietário de grupos.
	 * @param parameterId - Identificador do parâmetro.
	 * 
	 * @return - Dados do parâmetro pesquisado.
	 */
	
	@Override
	public ParameterDTO findById(BigDecimal groupOwnerId, String parameterId) {
		
		ParameterDTO result = null;
		
		try {
			
			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
			CriteriaQuery<ParameterDTO> cq = cb.createQuery(ParameterDTO.class);
			
			Root<Parameter> parameter = cq.from(Parameter.class);
			
			cq.multiselect(
				parameter.get("pk").get("parameterId"),
				parameter.get("value"),
				parameter.get("status"),
				parameter.get("creationDate")
			);
			
			cq.where(
				cb.equal(parameter.get("pk").get("groupOwnerId"), groupOwnerId),
				cb.and(cb.equal(parameter.get("pk").get("parameterId"), parameterId))
			);
			
			TypedQuery<ParameterDTO> query = entityManager.createQuery(cq);
			
			result = query.getSingleResult();
			
		}
		catch (NoResultException ex) {
			// Nothing to do
		}
		
		return result;
		
	}

}
