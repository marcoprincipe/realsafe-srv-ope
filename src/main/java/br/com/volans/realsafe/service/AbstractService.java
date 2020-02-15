package br.com.volans.realsafe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import br.com.volans.realsafe.dao.NSUTerminalDAO;
import br.com.volans.realsafe.dto.EventLogDTO;
import br.com.volans.realsafe.dto.NSUTerminalDTO;
import br.com.volans.realsafe.dto.TerminalDTO;
import br.com.volans.realsafe.enums.MessageKeys;
import br.com.volans.realsafe.exception.ServiceLayerException;

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
	private TerminalService terminalService;
	
	@Autowired
	private NSUTerminalDAO nsuTerminalDAO;
	
	@Autowired
	private EventLogService eventLogService;
	
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
	
	protected NSUTerminalDTO getNextNSUTerminal(String terminalId) throws ServiceLayerException {
		
		nsuTerminalDAO.incNSUTerminal(terminalId);
		
		NSUTerminalDTO result = nsuTerminalDAO.select(terminalId);
		
		return result;
		
	}
	
	/**
	 * Retorna o próximo NSU de evento a ser utilizado.
	 * 
	 * @param terminalId - Identificador do terminal.
	 * 
	 * @return - Dados do novo NSU.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	protected NSUTerminalDTO getNextNSUEvent(String terminalId) throws ServiceLayerException {
		
		nsuTerminalDAO.incNSUEvent(terminalId);
		
		NSUTerminalDTO result = nsuTerminalDAO.select(terminalId);
		
		return result;
		
	}
	
	/**
	 * Efetua a gravação do evento de log.
	 * 
	 * @param eventLogDTO - DTO com os dados a serem gravados.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	protected EventLogDTO createEventLog(EventLogDTO eventLogDTO) throws ServiceLayerException {
		
		if (eventLogDTO.getTerminalId() == null || eventLogDTO.getTerminalId().trim().isEmpty()) {
			
			TerminalDTO terminalDTO = terminalService.getLocalTerminal();
			
			if (terminalDTO == null) {
				throw new ServiceLayerException(getMessage(MessageKeys.LOCAL_TERMINAL_NOT_FOUND.getKey()));
			}
			
			eventLogDTO.setTerminalId(terminalDTO.getTerminalId());
			
		}
		
		EventLogDTO result = eventLogService.create(eventLogDTO);
		
		return result;
		
	}
	
}
