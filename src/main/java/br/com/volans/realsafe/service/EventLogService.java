package br.com.volans.realsafe.service;

import br.com.volans.realsafe.dto.EventLogDTO;
import br.com.volans.realsafe.exception.ServiceLayerException;

/**
 * Interface para implementação dos serviços de log de eventos.
 * 
 * @author Volans Informática Ltda.
 */

public interface EventLogService {
	
	/**
	 * Efetua a inclusão de um log de evento.
	 * 
	 * @param EventLogDTO - Instância do DTO com os dados do log de evento.
	 * 
	 * @return - Instância do DTO com os dados do log de evento.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */

	EventLogDTO create(EventLogDTO eventLogDTO) throws ServiceLayerException;
	
	/**
	 * Efetua a exclusão de um log de evento.
	 * 
	 * @param EventLogDTO - Instância do DTO com os dados do log de evento.
	 * 
	 * @return - Quantidade de linhas afetadas.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */

	Integer remove(EventLogDTO eventLogDTO) throws ServiceLayerException;


}
