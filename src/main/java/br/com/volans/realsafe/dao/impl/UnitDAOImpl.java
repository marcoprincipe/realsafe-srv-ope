package br.com.volans.realsafe.dao.impl;

import java.math.BigDecimal;
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

import br.com.volans.realsafe.dao.UnitDAO;
import br.com.volans.realsafe.dto.UnitDTO;
import br.com.volans.realsafe.model.Unit;
import br.com.volans.realsafe.model.Unit_;

/**
 * Implementação da interface do DAO de unidades.
 * 
 * @author Volans Informática Ltda
 */

@Repository
public class UnitDAOImpl implements UnitDAO {
	
	/**
	 * Declaração das variáveis membro
	 */
	
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Construtor default da classe
	 */
	
	public UnitDAOImpl() {
		super();
	}

	/**
	 * Pesquisa pela unidade a partir do id informado.
	 * 
	 * @param unitId - Identificador da unidade
	 * 
	 * @return - Dados da unidade pesquisada.
	 */
	
	@Override
	public UnitDTO findById(BigDecimal unitId) {
		
		UnitDTO result = null;
		
		try {
			
			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
			CriteriaQuery<UnitDTO> cq = cb.createQuery(UnitDTO.class);
			
			Root<Unit> unit = cq.from(Unit.class);
			
			cq.multiselect(
				unit.get(Unit_.unitId),
				unit.get(Unit_.unitName),
				unit.get(Unit_.businessName),
				unit.get(Unit_.contactName),
				unit.get(Unit_.address),
				unit.get(Unit_.addressNumber),
				unit.get(Unit_.addressComplement),
				unit.get(Unit_.addressNeighborhood),
				unit.get(Unit_.cityName),
				unit.get(Unit_.stateCode),
				unit.get(Unit_.countryCode),
				unit.get(Unit_.zipCode),
				unit.get(Unit_.phoneCountryCode),
				unit.get(Unit_.phoneAreaCode),
				unit.get(Unit_.phoneNumber),
				unit.get(Unit_.celCountryCode),
				unit.get(Unit_.celAreaCode),
				unit.get(Unit_.celNumber),
				unit.get(Unit_.stateRegistration),
				unit.get(Unit_.municipalRegistration),
				unit.get(Unit_.siteAddress),
				unit.get(Unit_.emailAddress),
				unit.get(Unit_.additionalInfo),
				unit.get(Unit_.status),
				unit.get(Unit_.creationDate),
				unit.get(Unit_.creationUser),
				unit.get(Unit_.lastUpdate),
				unit.get(Unit_.updateUser),
				unit.get(Unit_.companyId)
			);
			
			cq.where(
				cb.equal(unit.get(Unit_.unitId), unitId)
			);
	
			TypedQuery<UnitDTO> query = entityManager.createQuery(cq);

			result = query.getSingleResult();
			
		}
		catch (NoResultException ex) {
			// Nothing to do
		}
		
		return result;
		
	}
	
	/**
	 * Lista as unidades a partir do identificador da empresa informado.
	 * 
	 * @param companyId - Identificador da empresa.
	 * 
	 * @return - Lista das unidades da empresa informada.
	 */

	@Override
	public List<UnitDTO> listByCompanyId(BigDecimal companyId) {

		List<UnitDTO> result = null;
		
		try {
			
			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
			CriteriaQuery<UnitDTO> cq = cb.createQuery(UnitDTO.class);
			
			Root<Unit> unit = cq.from(Unit.class);
			
			cq.multiselect(
				unit.get(Unit_.unitId),
				unit.get(Unit_.unitName),
				unit.get(Unit_.businessName),
				unit.get(Unit_.contactName),
				unit.get(Unit_.address),
				unit.get(Unit_.addressNumber),
				unit.get(Unit_.addressComplement),
				unit.get(Unit_.addressNeighborhood),
				unit.get(Unit_.cityName),
				unit.get(Unit_.stateCode),
				unit.get(Unit_.countryCode),
				unit.get(Unit_.zipCode),
				unit.get(Unit_.phoneCountryCode),
				unit.get(Unit_.phoneAreaCode),
				unit.get(Unit_.phoneNumber),
				unit.get(Unit_.celCountryCode),
				unit.get(Unit_.celAreaCode),
				unit.get(Unit_.celNumber),
				unit.get(Unit_.stateRegistration),
				unit.get(Unit_.municipalRegistration),
				unit.get(Unit_.siteAddress),
				unit.get(Unit_.emailAddress),
				unit.get(Unit_.additionalInfo),
				unit.get(Unit_.status),
				unit.get(Unit_.creationDate),
				unit.get(Unit_.creationUser),
				unit.get(Unit_.lastUpdate),
				unit.get(Unit_.updateUser),
				unit.get(Unit_.companyId)
			);
	
			cq.where(cb.equal(unit.get(Unit_.companyId), companyId));
			
			TypedQuery<UnitDTO> query = entityManager.createQuery(cq);
			
			result = query.getResultList();
			
		}
		catch (NoResultException ex) {
			// Nothing to do
		}
		
		return result;
		
	}

	/**
	 * Efetua a inclusão de uma filial
	 * 
	 * @param unitDTO - Instância da entidade de uma filial.
	 * 
	 * @return - Instância da entidade da inserção de uma filial
	 */
	
	@Override
	public UnitDTO create(UnitDTO unitDTO) {

		Unit unit = new Unit();
		
		BeanUtils.copyProperties(unitDTO, unit);
		
		entityManager.persist(unit);
		
		return unitDTO;
		
	}

}
