package br.com.volans.realsafe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.volans.realsafe.dao.DepositDetailDAO;
import br.com.volans.realsafe.dto.DepositDetailDTO;
import br.com.volans.realsafe.dto.payload.ListDepositDetailsRequest;
import br.com.volans.realsafe.enums.MessageKeys;
import br.com.volans.realsafe.exception.ServiceLayerException;
import br.com.volans.realsafe.service.AbstractService;
import br.com.volans.realsafe.service.DepositDetailService;

/**
 * Implementação da interface dos serviços de detalhes de depósito.
 * 
 * @author Volans Informática Ltda
 */

@Service
public class DepositDetailServiceImpl extends AbstractService implements DepositDetailService {
	
	/**
	 * Declaração das variáveis membro
	 */

	private DepositDetailDAO depositDetailDAO;
	
	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param depositDetailDAO - Instância do DAO de detalhes de depósitos.
	 */
	
	@Autowired
	public DepositDetailServiceImpl(DepositDetailDAO depositDetailDAO) {
		this.depositDetailDAO = depositDetailDAO;
	}
	
	/**
	 * Efetua a pesquisa de um detalhe de depósito.
	 * 
	 * @param request - Instância do request de detalhes de depósito.
	 * 
	 * @return - Lista dos DTOs de detalhes de depósito.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	@Override
	public List<DepositDetailDTO> listDepositDetails(ListDepositDetailsRequest request) throws ServiceLayerException {

		if (request.getNsuTerminal() == null || request.getNsuTerminal().trim().isEmpty()) {
			throw new ServiceLayerException(getMessage(MessageKeys.NSU_TERMINAL_NOT_INFORMED.getKey()));
		}
		
		List<DepositDetailDTO> result = depositDetailDAO.listDepositDetails(request.getNsuTerminal());
		
		return result;

	}

}
