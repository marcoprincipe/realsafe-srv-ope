package br.com.volans.realsafe.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import br.com.volans.realsafe.dao.NSUTerminalDAO;
import br.com.volans.realsafe.dto.NSUTerminalDTO;
import br.com.volans.realsafe.exception.ServiceLayerException;
import br.com.volans.realsafe.model.NSUTerminal;

/**
 * Classe base para implementação dos demais serviços da aplicação.
 * 
 * @author Volans Informática Ltda
 */

public abstract class AbstractService {

	/**
	 * Declaração das variáveis membro
	 */

	@Autowired
	private NSUTerminalDAO nsuTerminalDAO;
	
	@Autowired
	private MessageSource messageSource;
	
	/**
	 * Retorna a mensagem da chave informada.
	 * 
	 * @param key - Chave da mensagem do arquivo de propriedades.
	 * 
	 * @return - Mensagem de erro da chave informada.
	 */
	
	protected String getMessage(String key) {
		return messageSource.getMessage(key, null, null);
	}
	
	/**
	 * Retorna o próximo NSU a ser utilizado.
	 * 
	 * @param terminalId - Identificador do terminal.
	 * 
	 * @return - Dados do novo NSU.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	protected NSUTerminalDTO getNextNSU(String terminalId) throws ServiceLayerException {
		
		NSUTerminalDTO result = null;
		NSUTerminalDTO nsuTerminalDTO = nsuTerminalDAO.select(terminalId);
		
		NSUTerminal nsuTerminal = new NSUTerminal();
		
		nsuTerminal.setTerminalId(nsuTerminalDTO.getTerminalId());
		nsuTerminal.setNsuTerminal(nsuTerminalDTO.getNsuTerminal().add(BigDecimal.ONE));
		
		nsuTerminalDAO.update(nsuTerminal);
		
		result = nsuTerminalDAO.select(terminalId);
		
		return result;
		
	}
	
}
