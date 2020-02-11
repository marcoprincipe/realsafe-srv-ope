package br.com.volans.realsafe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.volans.realsafe.dao.TerminalParameterDAO;
import br.com.volans.realsafe.dto.TerminalParameterDTO;
import br.com.volans.realsafe.enums.MessageKeys;
import br.com.volans.realsafe.exception.ServiceLayerException;
import br.com.volans.realsafe.service.AbstractService;
import br.com.volans.realsafe.service.TerminalParameterService;

/**
 * Implementação da interface dos serviços de parâmetros do terminal.
 * 
 * @author Volans Informática Ltda.
 */

@Service
public class TerminalParameterServiceImpl extends AbstractService implements TerminalParameterService {
	
	/**
	 * Declaração das variáveis membro.
	 */

	private TerminalParameterDAO terminalParameterDAO;

	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param terminalParameterDAO - Instância do DAO de parâmetros do terminal.
	 */
	
	@Autowired
	public TerminalParameterServiceImpl(
			TerminalParameterDAO terminalParameterDAO) {
		this.terminalParameterDAO = terminalParameterDAO;
	}
	/**
	 * Seleciona um parâmetro a partir do seu id.
	 * 
	 * @param parameterId - Identificador do parâmetro.
	 * 
	 * @return - DTO com os dados do parâmetro informado.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	@Override
	public TerminalParameterDTO findById(String parameterId) {

		if (parameterId == null || parameterId.trim().isEmpty()) {
			throw new ServiceLayerException(getMessage(MessageKeys.PARAMETER_CODE_NOT_INFORMED.getKey()));
		}
		
		TerminalParameterDTO result = terminalParameterDAO.findById(parameterId);
		
		if (result == null) {
			throw new ServiceLayerException(String.format(getMessage(MessageKeys.PARAMETER_NOT_FOUND.getKey()), parameterId));
		}
		
		return result;
		
	}
	
	/**
	 * Lista todos os parâmetros da tabela.
	 * 
	 * @return - Lista de todos os parâmetros da tabela.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	@Override
	public List<TerminalParameterDTO> listAll() {

		List<TerminalParameterDTO> result = terminalParameterDAO.listAll();
		
		return result;
		
	}

}
