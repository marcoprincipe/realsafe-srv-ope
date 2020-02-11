package br.com.volans.realsafe.dao;

import java.sql.Timestamp;

/**
 * Interface para implementação do DAO de checagem do banco de dados.
 * 
 * @author Volans Informática Ltda
 */

public interface HealthDAO {
	
	/**
	 * Seleciona a data e hora corrente
	 * 
	 * @return - Data e hora corrente.
	 */
	
	Timestamp selectTimeStamp();

}
