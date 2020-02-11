package br.com.volans.realsafe.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.volans.realsafe.dao.GroupDAO;
import br.com.volans.realsafe.dto.GroupDTO;
import br.com.volans.realsafe.enums.MessageKeys;
import br.com.volans.realsafe.exception.ServiceLayerException;
import br.com.volans.realsafe.service.AbstractService;
import br.com.volans.realsafe.service.GroupService;

/**
 * Implementação da interface dos serviços de grupos.
 * 
 * @author Volans Informática Ltda
 */

@Service
public class GroupServiceImpl extends AbstractService implements GroupService {
	
	/**
	 * Declaração das variáveis membro
	 */

	private GroupDAO groupDAO;

	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param groupDAO - Instância do DAO de grupos.
	 */
	
	@Autowired
	public GroupServiceImpl(GroupDAO groupDAO) {
		this.groupDAO = groupDAO;
	}

	/**
	 * Pesquisa pelo group a partir do id informado.
	 * 
	 * @param groupId - Identificador do grupo.
	 * 
	 * @return - Dados do grupo pesquisado.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	@Override
	public GroupDTO findById(BigDecimal groupId) throws ServiceLayerException {
		
		if (groupId == null) {
			throw new ServiceLayerException(getMessage(MessageKeys.GROUP_CODE_NOT_INFORMED.getKey()));
		}
		
		if (groupId.longValue() <= 0) {
			throw new ServiceLayerException(getMessage(MessageKeys.INVALID_GROUP_CODE.getKey()));
		}
		
		GroupDTO result = groupDAO.findById(groupId);
		
		if (result == null) {
			throw new ServiceLayerException(getMessage(MessageKeys.GROUP_NOT_FOUND.getKey()));
		}
		
		return result;
		
	}
	
	/**
	 * Retorna lista de grupos cadastrados.
	 * 
	 * @return - Lista de grupos cadastrados.
	 */
	
	@Override
	public List<GroupDTO> listAll() {
		
		List<GroupDTO> result = groupDAO.listAll();
		
		if (result == null || result.size() == 0) {
			throw new ServiceLayerException(getMessage(MessageKeys.NO_GROUP_FOUND.getKey()));
		}
		
		return result;

	}

}
