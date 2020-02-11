package br.com.volans.realsafe.dao.impl;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import br.com.volans.realsafe.dao.UserDAO;
import br.com.volans.realsafe.dto.UserDTO;
import br.com.volans.realsafe.model.User;
import br.com.volans.realsafe.model.UserPK_;
import br.com.volans.realsafe.model.User_;

/**
 * Implementação da interface do DAO de usuários.
 * 
 * @author Volans Informática Ltda
 */

@Repository
public class UserDAOImpl implements UserDAO {
	
	/**
	 * Declaração das variáveis membro
	 */
	
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Construtor default da classe
	 */
	
	public UserDAOImpl() {
		super();
	}

	/**
	 * Pesquisa pelo usuário a partir do id informado.
	 * 
	 * @param groupOwerId - Identificador do proprietário dos grupos;
	 * @param userId - Indentificador do usuário.
	 * 
	 * @return - Dados do usuário pesquisado.
	 */
	
	@Override
	public UserDTO findById(BigDecimal groupOwerId, BigDecimal userId) {
		
		UserDTO result = null;
		
		try {
			
			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
			CriteriaQuery<UserDTO> cq = cb.createQuery(UserDTO.class);
			
			Root<User> user = cq.from(User.class);
			
			cq.multiselect(
				user.get(User_.pk).get(UserPK_.groupOwnerId),
				user.get(User_.pk).get(UserPK_.userId),
				user.get(User_.userName),
				user.get(User_.emailAddress),
				user.get(User_.password),
				user.get(User_.isBlocked),
				user.get(User_.loginRetries),
				user.get(User_.status),
				user.get(User_.creationDate)
			);
			
			cq.where(
				cb.equal(user.get(User_.pk).get(UserPK_.groupOwnerId), groupOwerId),
				cb.and(cb.equal(user.get(User_.pk).get(UserPK_.userId), userId))
			);
			
			TypedQuery<UserDTO> query = entityManager.createQuery(cq);
			
			result = query.getSingleResult();
			
		}
		catch (NoResultException ex) {
			// Nothing to do
		}
		
		return result;
		
	}
	
	/**
	 * Atualiza os dados de login do usuário.
	 * 
	 * @param user - Instância com os dados do usuário para atualização.
	 * 
	 * @return - Quantidade de linhas atualizadas.
	 */
	
	@Override
	public Integer updateLogin(User user) {
		
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaUpdate<User> update = cb.createCriteriaUpdate(User.class);
		
		Root<User> root = update.from(User.class);
		
		update.set(User_.loginRetries, user.getLoginRetries());
		update.set(User_.isBlocked, user.getIsBlocked());
		
		update.where(
			cb.equal(root.get(User_.pk).get(UserPK_.groupOwnerId), user.getPk().getGroupOwnerId()),
			cb.and(cb.equal(root.get(User_.pk).get(UserPK_.userId), user.getPk().getUserId()))
		);

		Integer rowsAffected = entityManager.createQuery(update).executeUpdate();
		
		return rowsAffected;
		
	}
	
	/**
	 * Atualiza a senha de login do usuário.
	 * 
	 * @param user - Instância com os dados do usuário para atualização.
	 * 
	 * @return - Quantidade de linhas atualizadas.
	 */
	
	@Override
	public Integer updatePassword(User user) {
		
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaUpdate<User> update = cb.createCriteriaUpdate(User.class);
		
		Root<User> root = update.from(User.class);
		
		update.set(User_.password, user.getPassword());
		
		update.where(
			cb.equal(root.get(User_.pk).get(UserPK_.groupOwnerId), user.getPk().getGroupOwnerId()),
			cb.and(cb.equal(root.get(User_.pk).get(UserPK_.userId), user.getPk().getUserId()))
		);

		Integer rowsAffected = entityManager.createQuery(update).executeUpdate();
		
		return rowsAffected;
		
	}

}
