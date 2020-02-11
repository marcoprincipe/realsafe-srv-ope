package br.com.volans.realsafe.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import br.com.volans.realsafe.dao.RoleDAO;
import br.com.volans.realsafe.dto.RoleDTO;
import br.com.volans.realsafe.model.Role;
import br.com.volans.realsafe.model.Role_;

/**
 * Implementação da interface do DAO de perfis operacionais.
 * 
 * @author Volans Informática Ltda.
 */

@Repository
public class RoleDAOImpl implements RoleDAO {
	
	/**
	 * Declaração das variáveis membro
	 */
	
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Construtor default da classe
	 */
	
	public RoleDAOImpl() {
		super();
	}
	
	/**
	 * Pesquisa pelo perfil de usuário a partir do identificador informado.
	 * 
	 * @param roleId - Identificador do perfil de usuário.
	 * 
	 * @return - Dados do perfil pesquisado
	 */
	
	@Override
	public RoleDTO findById(Long roleId) {
		
		RoleDTO result = null;
		
		try {
			
			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
			CriteriaQuery<RoleDTO> cq = cb.createQuery(RoleDTO.class);
			
			Root<Role> role = cq.from(Role.class);
			
			cq.multiselect(
				role.get(Role_.roleId),
				role.get(Role_.initial),
				role.get(Role_.name),
				role.get(Role_.status),
				role.get(Role_.creationDate)
			);
			
			cq.where(
				cb.equal(role.get(Role_.roleId), roleId)
			);
			
			TypedQuery<RoleDTO> query = entityManager.createQuery(cq);
			
			result = query.getSingleResult();
			
		}
		catch (NoResultException ex) {
			// Nothing to do
		}
		
		return result;
		
	}
	
	/**
	 * Inclui um novo perfil de usuário na tabela.
	 * 
	 * @param roleDTO - Dados do perfil a serem incluidos.
	 * 
	 * @return - Dados do perfil incluido
	 */
	
	@Override
	public RoleDTO create(RoleDTO roleDTO) {
		
		Role role = new Role();
		
		BeanUtils.copyProperties(roleDTO, role);
		
		entityManager.persist(role);
		
		return roleDTO;
		
	}
	
	/**
	 * Retorna lista de perfis operacionais da aplicação.
	 * 
	 * @return - Lista de perfis operacionais.
	 */
	
	@Override
	public List<RoleDTO> listAll() {
		
		List<RoleDTO> result = null;
		
		try {
			
			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
			CriteriaQuery<RoleDTO> cq = cb.createQuery(RoleDTO.class);
			
			Root<Role> role = cq.from(Role.class);
			
			cq.multiselect(
				role.get(Role_.roleId),
				role.get(Role_.initial),
				role.get(Role_.name),
				role.get(Role_.status),
				role.get(Role_.creationDate)
			);
			
			TypedQuery<RoleDTO> query = entityManager.createQuery(cq);
			
			result = query.getResultList();
			
		}
		catch (NoResultException ex) {
			// Nothing to do
		}
		
		return result;
		
	}

}
