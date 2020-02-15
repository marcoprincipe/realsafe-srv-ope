package br.com.volans.realsafe.util;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Classe com métodos úteis da aplicação.
 * 
 * @author Volans Informática Ltda
 */

public class Utils {

	/**
	 * Retorna o valor da variável informada.
	 * 
	 * @param variable - Nome da variável para pesquisa.
	 * 
	 * @return Valor da variável pesquisada.
	 */
	
	public static String getVariable(String variable) {

		return Utils.getVariable(variable, null);
		
	}

	/**
	 * Retorna o valor da variável informada.
	 * 
	 * @param variable - Nome da variável para pesquisa.
	 * @param defaultValue - Valor default da variável.
	 * 
	 * @return Valor da variável pesquisada.
	 */
	
	public static String getVariable(String variable, String defaultValue) {
		
		String result = System.getenv(variable);
		
		if (result == null) {
			result = System.getProperty(variable);
		}
		
		if (result == null) {
			result = defaultValue;
		}

		return result;
		
	}

	/**
	 * Retorna a data e hora corrente.
	 * 
	 * @return Data e hora corrente UTC.
	 */
	
	public static LocalDateTime getNowFromUTC() {
		
		return ZonedDateTime.now(ZoneOffset.UTC).toLocalDateTime();
		
	}
	
	/**
	 * Converte o objeto informado para uma string JSON.
	 * 
	 * @param object - Objeto a ser convertido.
	 * 
	 * @return - String no formato JSON.
	 */
	
	public static String objectToJson(Object object) {
		
		String json = null;

		try {
			
			ObjectMapper mapper = new ObjectMapper();

			json = mapper.writeValueAsString(object);
			
		} 
		catch (JsonProcessingException ex) {
			
			json = "";
			
		}
		
		return json;
		
	}
	
}
