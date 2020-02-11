package br.com.volans.realsafe.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.volans.realsafe.dao.UnitDAO;
import br.com.volans.realsafe.dto.UnitDTO;
import br.com.volans.realsafe.enums.MessageKeys;
import br.com.volans.realsafe.exception.ServiceLayerException;
import br.com.volans.realsafe.service.AbstractService;
import br.com.volans.realsafe.service.UnitService;

/**
 * Implementação da interface dos serviços de unidades.
 * 
 * @author Volans Informática Ltda
 */

@Service
public class UnitServiceImpl extends AbstractService implements UnitService {
	
	/**
	 * Declaração das variáveis membro
	 */
	
	private UnitDAO unitDAO;

	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param unitDAO - Instância do DAO de unidades.
	 */
	
	@Autowired
	public UnitServiceImpl(UnitDAO unitDAO) {
		this.unitDAO = unitDAO;
	}
	
	/**
	 * Pesquisa pela unidade a partir do id informado.
	 * 
	 * @param id - Identificador da unidade
	 * 
	 * @return - Dados da unidade pesquisada.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	@Override
	public UnitDTO findById(BigDecimal unitId) throws ServiceLayerException {
		
		if (unitId == null) {
			throw new ServiceLayerException(getMessage(MessageKeys.UNIT_CODE_NOT_INFORMED.getKey()));
		}
		
		if (unitId.longValue() <= 0) {
			throw new ServiceLayerException(getMessage(MessageKeys.INVALID_UNIT_CODE.getKey()));
		}
		
		UnitDTO result = unitDAO.findById(unitId);
		
		if (result == null) {
			throw new ServiceLayerException(getMessage(MessageKeys.UNIT_NOT_FOUND.getKey()));
		}
		
		return result;
	}
	
	/**
	 * Lista as unidades a partir do identificador da empresa informado.
	 * 
	 * @param companyId - Identificador da empresa.
	 * 
	 * @return - Lista das unidades da empresa informada.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	@Override
	public List<UnitDTO> listByCompanyId(BigDecimal companyId) throws ServiceLayerException {
		
		if (companyId == null) {
			throw new ServiceLayerException(getMessage(MessageKeys.COMPANY_CODE_NOT_INFORMED.getKey()));
		}
		
		if (companyId.longValue() <= 0) {
			throw new ServiceLayerException(getMessage(MessageKeys.INVALID_COMPANY_CODE.getKey()));
		}

		List<UnitDTO> result = unitDAO.listByCompanyId(companyId);
		
		if (result == null || result.size() == 0) {
			throw new ServiceLayerException(getMessage(MessageKeys.NO_UNIT_FOUND.getKey()));
		}
		
		return result;
		
	}

}
