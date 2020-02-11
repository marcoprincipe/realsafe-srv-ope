package br.com.volans.realsafe.dao.impl;

import java.math.BigDecimal;
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

import br.com.volans.realsafe.dao.UserUnitDAO;
import br.com.volans.realsafe.dto.UserCompanyDTO;
import br.com.volans.realsafe.dto.UserGroupDTO;
import br.com.volans.realsafe.dto.UserUnitDTO;
import br.com.volans.realsafe.exception.ServiceLayerException;
import br.com.volans.realsafe.model.Company;
import br.com.volans.realsafe.model.Company_;
import br.com.volans.realsafe.model.Group;
import br.com.volans.realsafe.model.Group_;
import br.com.volans.realsafe.model.Role;
import br.com.volans.realsafe.model.Role_;
import br.com.volans.realsafe.model.Unit;
import br.com.volans.realsafe.model.Unit_;
import br.com.volans.realsafe.model.User;
import br.com.volans.realsafe.model.UserPK_;
import br.com.volans.realsafe.model.UserUnit;
import br.com.volans.realsafe.model.UserUnitPK_;
import br.com.volans.realsafe.model.UserUnit_;
import br.com.volans.realsafe.model.User_;

/**
 * Implementação da interface do DAO de unidades de usuários.
 * 
 * @author Volans Informática Ltda.
 */

@Repository
public class UserUnitDAOImpl implements UserUnitDAO {
	
	/**
	 * Declaração das variáveis membro
	 */
	
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Construtor default da classe
	 */
	
	public UserUnitDAOImpl() {
		super();
	}
	
	/**
	 * Retorna a lista de grupos de um usuário.
	 * 
	 * @param groupOwnerId - Identificador do proprietário do grupo.
	 * @param groupId - Identificador do grupo.
	 * @param companyId - Identificador da empresa.
	 * @param userId - Identificador do usuário.
	 * 
	 * @return Lista de grupos de um usuário.
	 */
	
	@Override
	public List<UserUnitDTO> listByUserId(BigDecimal groupOwnerId, BigDecimal groupId, BigDecimal companyId, BigDecimal userId) {
		
		List<UserUnitDTO> result = null;
		
		try {
			
			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
			CriteriaQuery<UserUnitDTO> cq = cb.createQuery(UserUnitDTO.class);
			
			Root<UserUnit> userUnit = cq.from(UserUnit.class);
			Join<UserUnit, Group> group = userUnit.join(UserUnit_.group);
			Join<UserUnit, Company> company = userUnit.join(UserUnit_.company);
			Join<UserUnit, Unit> unit = userUnit.join(UserUnit_.unit);
			Join<UserUnit, User> user = userUnit.join(UserUnit_.user);
			Join<UserUnit, Role> role = userUnit.join(UserUnit_.role);
			
			cq.multiselect(
				group.get(Group_.groupId),
				group.get(Group_.groupName),
				company.get(Company_.companyId),
				company.get(Company_.companyName),
				unit.get(Unit_.unitId),
				unit.get(Unit_.unitName),
				user.get(User_.pk).get(UserPK_.userId),
				user.get(User_.userName),
				role.get(Role_.roleId),
				role.get(Role_.initial),
				role.get(Role_.name)
			);
			
			cq.where(
				cb.equal(userUnit.get(UserUnit_.pk).get(UserUnitPK_.groupOwnerId), groupOwnerId),
				cb.and(cb.equal(userUnit.get(UserUnit_.pk).get(UserUnitPK_.userId), userId))
			);
			
			cq.orderBy(cb.asc(unit.get(Unit_.unitName)));
			
			TypedQuery<UserUnitDTO> query = entityManager.createQuery(cq);
			
			result = query.getResultList();
			
		}
		catch (NoResultException ex) {
			// Nothing to do
		}
		
		return result;
		
	}
	
	/**
	 * Retorna a lista de grupos de um usuário.
	 * 
	 * @param groupOwnerId - Identificador do proprietário do grupo.
	 * @param userId - Identificador do usuário.
	 * 
	 * @return Lista de grupos de um usuário.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	@Override
	public List<UserGroupDTO> listUserGroups(BigDecimal groupOwnerId, BigDecimal userId) {
		
		List<UserGroupDTO> result = null;
		
		try {
			
			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
			CriteriaQuery<UserGroupDTO> cq = cb.createQuery(UserGroupDTO.class);
			
			Root<UserUnit> userUnit = cq.from(UserUnit.class);
			Join<UserUnit, Unit> unit = userUnit.join(UserUnit_.unit);
			Join<Unit, Company> company = unit.join(Unit_.company);
			Join<Company, Group> group = company.join(Company_.group);
			Join<UserUnit, User> user = userUnit.join(UserUnit_.user);
			Join<UserUnit, Role> role = userUnit.join(UserUnit_.role);
			
			cq.multiselect(
				group.get(Group_.groupId),
				group.get(Group_.groupName),
				user.get(User_.pk).get(UserPK_.userId),
				user.get(User_.userName),
				role.get(Role_.roleId),
				role.get(Role_.initial),
				role.get(Role_.name)
			).distinct(true);
			
			cq.where(
				cb.equal(userUnit.get(UserUnit_.pk).get(UserUnitPK_.groupOwnerId), groupOwnerId),
				cb.and(cb.equal(userUnit.get(UserUnit_.pk).get(UserUnitPK_.userId), userId))
			);
			
			cq.orderBy(cb.asc(unit.get(Unit_.unitName)));
			
			TypedQuery<UserGroupDTO> query = entityManager.createQuery(cq);
			
			result = query.getResultList();
			
		}
		catch (NoResultException ex) {
			// Nothing to do
		}
		
		return result;
		
	}
	
	/**
	 * Retorna a lista de empresas de um usuário.
	 * 
	 * @param groupOwnerId - Identificador do proprietário do grupo.
	 * @param userId - Identificador do usuário.
	 * @param groupId - Identificador do grupo.
	 * 
	 * @return Lista de grupos de um usuário.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	@Override
	public List<UserCompanyDTO> listUserCompanies(BigDecimal groupOwnerId, BigDecimal userId, BigDecimal groupId) {
		
		List<UserCompanyDTO> result = null;
		
		try {
			
			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
			CriteriaQuery<UserCompanyDTO> cq = cb.createQuery(UserCompanyDTO.class);
			
			Root<UserUnit> userUnit = cq.from(UserUnit.class);
			Join<UserUnit, Unit> unit = userUnit.join(UserUnit_.unit);
			Join<Unit, Company> company = unit.join(Unit_.company);
			Join<Company, Group> group = company.join(Company_.group);
			Join<UserUnit, User> user = userUnit.join(UserUnit_.user);
			Join<UserUnit, Role> role = userUnit.join(UserUnit_.role);
			
			cq.multiselect(
				group.get(Group_.groupId),
				group.get(Group_.groupName),
				company.get(Company_.companyId),
				company.get(Company_.companyName),
				user.get(User_.pk).get(UserPK_.userId),
				user.get(User_.userName),
				role.get(Role_.roleId),
				role.get(Role_.initial),
				role.get(Role_.name)
			).distinct(true);
			
			cq.where(
				cb.equal(userUnit.get(UserUnit_.pk).get(UserUnitPK_.groupOwnerId), groupOwnerId),
				cb.and(cb.equal(userUnit.get(UserUnit_.pk).get(UserUnitPK_.userId), userId)),
				cb.and(cb.equal(company.get(Company_.groupId), groupId))
			);
			
			cq.orderBy(cb.asc(unit.get(Unit_.unitName)));
			
			TypedQuery<UserCompanyDTO> query = entityManager.createQuery(cq);
			
			result = query.getResultList();
			
		}
		catch (NoResultException ex) {
			// Nothing to do
		}
		
		return result;
		
	}
	
	/**
	 * Retorna a lista de unidades de uma empresa de um usuário.
	 * 
	 * @param groupOwnerId - Identificador do proprietário do grupo.
	 * @param userId - Identificador do usuário.
	 * @param groupId - Identificador do grupo.
	 * @param companyId - Identificador da empresa.
	 * 
	 * @return Lista de grupos de um usuário.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	@Override
	public List<UserUnitDTO> listUserUnits(BigDecimal groupOwnerId, BigDecimal userId, BigDecimal groupId, BigDecimal companyId) {
		
		List<UserUnitDTO> result = null;
		
		try {
			
			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
			CriteriaQuery<UserUnitDTO> cq = cb.createQuery(UserUnitDTO.class);
			
			Root<UserUnit> userUnit = cq.from(UserUnit.class);
			Join<UserUnit, Unit> unit = userUnit.join(UserUnit_.unit);
			Join<Unit, Company> company = unit.join(Unit_.company);
			Join<Company, Group> group = company.join(Company_.group);
			Join<UserUnit, User> user = userUnit.join(UserUnit_.user);
			Join<UserUnit, Role> role = userUnit.join(UserUnit_.role);
			
			cq.multiselect(
				group.get(Group_.groupId),
				group.get(Group_.groupName),
				company.get(Company_.companyId),
				company.get(Company_.companyName),
				unit.get(Unit_.unitId),
				unit.get(Unit_.unitName),
				user.get(User_.pk).get(UserPK_.userId),
				user.get(User_.userName),
				role.get(Role_.roleId),
				role.get(Role_.initial),
				role.get(Role_.name)
			).distinct(true);
			
			cq.where(
				cb.equal(userUnit.get(UserUnit_.pk).get(UserUnitPK_.groupOwnerId), groupOwnerId),
				cb.and(cb.equal(userUnit.get(UserUnit_.pk).get(UserUnitPK_.userId), userId)),
				cb.and(cb.equal(group.get(Group_.groupId), groupId)),
				cb.and(cb.equal(company.get(Company_.companyId), companyId))
			);
			
			cq.orderBy(cb.asc(unit.get(Unit_.unitName)));
			
			TypedQuery<UserUnitDTO> query = entityManager.createQuery(cq);
			
			result = query.getResultList();
			
		}
		catch (NoResultException ex) {
			// Nothing to do
		}
		
		return result;
		
	}

}
