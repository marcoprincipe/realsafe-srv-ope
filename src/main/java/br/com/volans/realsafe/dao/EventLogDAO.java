package br.com.volans.realsafe.dao;

import br.com.volans.realsafe.dto.EventLogDTO;

/**
 * Interface para implementação do DAO de log de eventos.
 * 
 * @author Volans Informática Ltda.
 */

public interface EventLogDAO {
	
	/**
	 * Efetua a inclusão de um log de evento.
	 * 
	 * @param EventLogDTO - Instância do DTO com os dados do log de evento.
	 * 
	 * @return - Instância do DTO com os dados do log de evento.
	 */

	EventLogDTO create(EventLogDTO eventLogDTO);
	
	/**
	 * Efetua a exclusão de um log de evento
	 * 
	 * @param EventLogDTO - Instância do DTO com os dados do log de evento.
	 * 
	 * @return - Quantidade de linhas afetadas
	 */

	Integer remove(EventLogDTO eventLogDTO);

}
