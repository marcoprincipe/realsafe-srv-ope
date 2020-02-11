package br.com.volans.realsafe.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import br.com.volans.realsafe.dao.FunctionalityRoleDAO;
import br.com.volans.realsafe.dto.FunctionalityRoleDTO;
import br.com.volans.realsafe.model.Functionality;
import br.com.volans.realsafe.model.FunctionalityRole;
import br.com.volans.realsafe.model.FunctionalityRolePK_;
import br.com.volans.realsafe.model.FunctionalityRole_;
import br.com.volans.realsafe.model.Functionality_;
import br.com.volans.realsafe.model.Role;
import br.com.volans.realsafe.model.Role_;

/**
 * Implementação da interface do DAO de funcionalidades de perfis.
 * 
 * @author Volans Informática Ltda
 */

@Repository
public class FunctionalityRoleDAOImpl implements FunctionalityRoleDAO {
	
	/**
	 * Declaração das variáveis membro
	 */
	
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Construtor default da classe
	 */
	
	public FunctionalityRoleDAOImpl() {
		super();
	}
	
	/**
	 * Pesquisa pelas funcionalidades / perfis a partir da chave primária informada.
	 * 
	 * @param roleId - Identificador do perfil.
	 * @param functionalityId - Identificador da funcionalidade.
	 * 
	 * @return - Lista de funcionalidades do perfil.
	 */
	
	@Override
	public FunctionalityRoleDTO findById(Long roleId, Long functionalityId) {
		
		FunctionalityRoleDTO result = null;
		
		try {
			
			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
			CriteriaQuery<FunctionalityRoleDTO> cq = cb.createQuery(FunctionalityRoleDTO.class);
			
			Root<FunctionalityRole> functionalityRole = cq.from(FunctionalityRole.class);
			Join<FunctionalityRole, Role> role = functionalityRole.join(FunctionalityRole_.role);
			Join<FunctionalityRole, Functionality> functionality = functionalityRole.join(FunctionalityRole_.functionality);
			
			cq.multiselect(
				role.get(Role_.roleId),
				role.get(Role_.initial),
				role.get(Role_.name),
				functionality.get(Functionality_.functionalityId),
				functionality.get(Functionality_.name),
				functionality.get(Functionality_.description),
				functionality.get(Functionality_.route),
				functionality.get(Functionality_.parentId),
				functionalityRole.get(FunctionalityRole_.showOrder),
				functionalityRole.get(FunctionalityRole_.accessKey)
			);

			cq.where(
				cb.and(
					cb.equal(functionalityRole.get(FunctionalityRole_.pk).get(FunctionalityRolePK_.functionalityId), functionalityId),
					cb.equal(functionalityRole.get(FunctionalityRole_.pk).get(FunctionalityRolePK_.roleId), roleId)
				)
			);
			
			TypedQuery<FunctionalityRoleDTO> query = entityManager.createQuery(cq);
			
			result = query.getSingleResult();
			
		}
		catch (NoResultException ex) {
			// Nothing to do
		}
		
		return result;
		
	}
	
	/**
	 * Efetua a inclusão da funcionalidade / perfil na tabela.
	 * 
	 * @param functionalityRoleDTO - Dados a serem incluídos.
	 * 
	 * @return - Dados da funcionalidade / perfil incluido.
	 */
	
	@Override
	public FunctionalityRoleDTO create(FunctionalityRoleDTO functionalityRoleDTO) {
		
		FunctionalityRole functionalityRole = new FunctionalityRole();
		
		functionalityRole.getPk().setFunctionalityId(functionalityRoleDTO.getFunctionalityId());
		functionalityRole.getPk().setRoleId(functionalityRoleDTO.getRoleId());
		functionalityRole.setAccessKey(functionalityRoleDTO.getFunctionalityAccessKey());
		functionalityRole.setShowOrder(functionalityRoleDTO.getFunctionalityShowOrder());
		
		entityManager.persist(functionalityRole);
		
		return functionalityRoleDTO;
		
	}

	/**
	 * Pesquisa pelas funcionalidades a partir do id do perfil informado.
	 * 
	 * @param roleId - Identificador do perfil.
	 * @param parentId - Identificador da funcionalidade pai.
	 * 
	 * @return - Lista de funcionalidades do perfil.
	 */
	
	@Override
	public List<FunctionalityRoleDTO> listFunctionalitiesByRoleId(Integer roleId, Integer parentId) {
		
		List<FunctionalityRoleDTO> result = null;
		
		try {
			
			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
			CriteriaQuery<FunctionalityRoleDTO> cq = cb.createQuery(FunctionalityRoleDTO.class);
			
			Root<FunctionalityRole> functionalityRole = cq.from(FunctionalityRole.class);
			Join<FunctionalityRole, Role> role = functionalityRole.join(FunctionalityRole_.role);
			Join<FunctionalityRole, Functionality> functionality = functionalityRole.join(FunctionalityRole_.functionality);
			
			cq.multiselect(
				role.get(Role_.roleId),
				role.get(Role_.initial),
				role.get(Role_.name),
				functionality.get(Functionality_.functionalityId),
				functionality.get(Functionality_.name),
				functionality.get(Functionality_.description),
				functionality.get(Functionality_.route),
				functionality.get(Functionality_.parentId),
				functionalityRole.get(FunctionalityRole_.showOrder),
				functionalityRole.get(FunctionalityRole_.accessKey)
			);
			
			if (parentId == null) {
				cq.where(
					cb.and(
						cb.equal(role.get(Role_.roleId), roleId),
						cb.isNull(functionality.get(Functionality_.parentId))
					)
				);
			}
			else {
				cq.where(
					cb.and(
						cb.equal(role.get(Role_.roleId), roleId),
						cb.equal(functionality.get(Functionality_.parentId), parentId)
					)
				);
			}
			
			cq.orderBy(cb.asc(functionalityRole.get(FunctionalityRole_.showOrder)));
			
			TypedQuery<FunctionalityRoleDTO> query = entityManager.createQuery(cq);
			
			result = query.getResultList();
			
		}
		catch (NoResultException ex) {
			// Nothing to do
		}
		
		return result;
		
	}

}
