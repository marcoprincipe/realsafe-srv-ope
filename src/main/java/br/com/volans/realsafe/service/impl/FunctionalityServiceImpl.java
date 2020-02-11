package br.com.volans.realsafe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.volans.realsafe.dao.FunctionalityDAO;
import br.com.volans.realsafe.dto.FunctionalityDTO;
import br.com.volans.realsafe.enums.MessageKeys;
import br.com.volans.realsafe.exception.ServiceLayerException;
import br.com.volans.realsafe.service.AbstractService;
import br.com.volans.realsafe.service.FunctionalityService;

/**
 * Implementação da interface dos serviços de funcionalidades operacionais.
 * 
 * @author Volans Informática Ltda.
 */

@Service
public class FunctionalityServiceImpl extends AbstractService implements FunctionalityService {
	
	/**
	 * Declaração das variáveis membro.
	 */
	
	private FunctionalityDAO functionalityDAO;

	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param functionalityOpeDAO - Instância do DAO de funcionalidades operacionais.
	 */

	@Autowired
	public FunctionalityServiceImpl(FunctionalityDAO functionalityDAO) {
		this.functionalityDAO = functionalityDAO;
	}
	
	/**
	 * Pesquisa pela funcionalidade a partir do identificador informado.
	 * 
	 * @param functionalityId- Identificador da funcionalidade.
	 * 
	 * @return - Dados da funcionalidade pesquisada.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	@Override
	public FunctionalityDTO findById(Long functionalityId) throws ServiceLayerException {
		
		if (functionalityId == null) {
			throw new ServiceLayerException(getMessage(MessageKeys.FUNCTIONALITY_CODE_NOT_INFORMED.getKey()));
		}
		
		if (functionalityId <= 0) {
			throw new ServiceLayerException(getMessage(MessageKeys.INVALID_FUNCTIONALITY_CODE.getKey()));
		}
		
		FunctionalityDTO result = functionalityDAO.findById(functionalityId);
		
		return result;
		
	}
	
	/**
	 * Inclui uma nova funcionalidade na base de dados.
	 * 
	 * @param functionalityDTO - Dados a serem incluídos.
	 * 
	 * @return - Dados da funcionalidade incluida.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	@Override
	public FunctionalityDTO create(FunctionalityDTO functionalityDTO) throws ServiceLayerException {
		
		if (functionalityDTO == null || functionalityDTO.getFunctionalityId() == null) {
			throw new ServiceLayerException(getMessage(MessageKeys.FUNCTIONALITY_CODE_NOT_INFORMED.getKey()));
		}
		
		if (functionalityDTO.getFunctionalityId() <= 0) {
			throw new ServiceLayerException(getMessage(MessageKeys.INVALID_FUNCTIONALITY_CODE.getKey()));
		}

		FunctionalityDTO result = functionalityDAO.create(functionalityDTO);
		
		return result;
		
	}
	
	/**
	 * Retorna lista de funcionalidades operacionais da aplicação.
	 * 
	 * @return - Lista de funcionalidades operacionais.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	@Override
	public List<FunctionalityDTO> listAll() throws ServiceLayerException {

		List<FunctionalityDTO> result = functionalityDAO.listAll();
		
		return result;
		
	}

}
