package br.com.volans.realsafe.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.volans.realsafe.dao.EventLogDAO;
import br.com.volans.realsafe.dto.EventLogDTO;
import br.com.volans.realsafe.dto.NSUTerminalDTO;
import br.com.volans.realsafe.enums.EventLogs;
import br.com.volans.realsafe.enums.MessageKeys;
import br.com.volans.realsafe.exception.ServiceLayerException;
import br.com.volans.realsafe.service.AbstractService;
import br.com.volans.realsafe.service.EventLogService;

/**
 * Implementação da interface dos serviços de log de eventos.
 * 
 * @author Volans Informática Ltda.
 */

@Service
public class EventLogServiceImpl extends AbstractService implements EventLogService {
	
	/**
	 * Declaração das variáveis membro.
	 */
	
	private EventLogDAO eventLogDAO;
	
	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param eventLogDAO - Instância do DAO de log de eventos.
	 */
	
	@Autowired
	public EventLogServiceImpl(EventLogDAO eventLogDAO) {
		this.eventLogDAO = eventLogDAO;
	}
	
	/**
	 * Efetua a inclusão de um log de evento.
	 * 
	 * @param EventLogDTO - Instância do DTO com os dados do log de evento.
	 * 
	 * @return - Instância do DTO com os dados do log de evento.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */

	@Override
	@Transactional
	public EventLogDTO create(EventLogDTO eventLogDTO) throws ServiceLayerException {

		if (eventLogDTO.getTerminalId() == null || eventLogDTO.getTerminalId().trim().isEmpty()) {
			throw new ServiceLayerException(getMessage(MessageKeys.TERMINAL_CODE_NOT_INFORMED.getKey()));
		}

		if (eventLogDTO.getEventId() == null) {
			throw new ServiceLayerException(getMessage(MessageKeys.EVENT_CODE_NOT_INFORMED.getKey()));
		}

		if (eventLogDTO.getEventName() == null || eventLogDTO.getEventName().trim().isEmpty()) {
			throw new ServiceLayerException(getMessage(MessageKeys.EVENT_NAME_NOT_INFORMED.getKey()));
		}
		
		EventLogs eventLog = EventLogs.getByCode(eventLogDTO.getEventId());

		if (eventLog == null) {
			throw new ServiceLayerException(getMessage(MessageKeys.INVALID_EVENT_CODE.getKey()));
		}
		
		NSUTerminalDTO nsuTerminal = getNextNSUEvent(eventLogDTO.getTerminalId());
		String nsuEvent = String.format("%s%07d", eventLogDTO.getTerminalId(), nsuTerminal.getNsuEvent().longValue());
		
		eventLogDTO.setNsuEvent(nsuEvent);
		eventLogDTO.setDateTime(nsuTerminal.getCurrentDateTime());
		
		if (eventLogDTO.getMessage() == null) {
			eventLogDTO.setMessage(getMessage(eventLog.getKey()));
		}
		
		EventLogDTO result = eventLogDAO.create(eventLogDTO);
		
		return result;
		
	}
	
	/**
	 * Efetua a exclusão de um log de evento.
	 * 
	 * @param EventLogDTO - Instância do DTO com os dados do log de evento.
	 * 
	 * @return - Quantidade de linhas afetadas.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */

	@Override
	@Transactional
	public Integer remove(EventLogDTO eventLogDTO) throws ServiceLayerException {

		if (eventLogDTO.getNsuEvent() == null || eventLogDTO.getNsuEvent().trim().isEmpty()) {
			throw new ServiceLayerException(getMessage(MessageKeys.NSU_EVENT_NOT_INFORMED.getKey()));
		}
		
		Integer rowsAffected = eventLogDAO.remove(eventLogDTO);
		
		return rowsAffected;
		
	}

}
