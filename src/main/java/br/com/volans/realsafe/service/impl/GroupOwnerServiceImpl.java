package br.com.volans.realsafe.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.volans.realsafe.dao.GroupOwnerDAO;
import br.com.volans.realsafe.dto.GroupOwnerDTO;
import br.com.volans.realsafe.enums.MessageKeys;
import br.com.volans.realsafe.exception.ServiceLayerException;
import br.com.volans.realsafe.service.AbstractService;
import br.com.volans.realsafe.service.GroupOwnerService;

/**
 * Implementação da interface dos serviços de proprietário de grupos.
 * 
 * @author Volans Informática Ltda.
 */

@Service
public class GroupOwnerServiceImpl extends AbstractService implements GroupOwnerService {
	
	/**
	 * Declaração das variáveis membro.
	 */

	private GroupOwnerDAO groupOwnerDAO;

	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param groupOwnerDAO - Instância do DAO de proprietário de grupos.
	 */
	
	@Autowired
	public GroupOwnerServiceImpl(GroupOwnerDAO groupOwnerDAO) {
		this.groupOwnerDAO = groupOwnerDAO;
	}

	/**
	 * Recupera os dados do proprietário de grupos local.
	 * 
	 * @return - Dados do proprietário de grupos.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	@Override
	public GroupOwnerDTO getLocalGroupOwner() throws ServiceLayerException {
		
		GroupOwnerDTO result = groupOwnerDAO.findSingleLocal();
		
		return result;
		
	}

	/**
	 * Retorna lista de proprietarios de grupos cadastradas.
	 * 
	 * @return - Lista de proprietarios de grupos cadastradas.
	 */
	
	@Override
	public List<GroupOwnerDTO> listAll() {
		
		List<GroupOwnerDTO> result = groupOwnerDAO.listAll();
		
		if (result == null || result.size() == 0) {
			throw new ServiceLayerException(getMessage(MessageKeys.NO_GROUP_OWNER_FOUND.getKey()));
		}
		
		return result;
	}

	/**
	 * Pesquisa pelo proprietario de grupo a partir do id informado.
	 * 
	 * @param id - Identificador do proprietario
	 * 
	 * @return - Dados da proprietario de grupo pesquisado.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	@Override
	public GroupOwnerDTO findById(BigDecimal groupOwnerId) throws ServiceLayerException {
		
		if (groupOwnerId == null) {
			throw new ServiceLayerException(getMessage(MessageKeys.GROUP_OWNER_CODE_NOT_INFORMED.getKey()));
		}
		
		if (groupOwnerId.longValue() <= 0) {
			throw new ServiceLayerException(getMessage(MessageKeys.INVALID_GROUP_OWNER_CODE.getKey()));
		}
		
		GroupOwnerDTO result = groupOwnerDAO.findById(groupOwnerId);
		
		if (result == null) {
			throw new ServiceLayerException(getMessage(MessageKeys.NO_GROUP_OWNER_FOUND.getKey()));
		}
		
		return result;
	}

}
