package br.com.volans.realsafe.validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Classe com métodos úteis de validação.
 * 
 * @author Volans Informática Ltda
 */

public class Validators {

	/**
	 * Declaração das constantes da classe.
	 */
	
	private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

	/**
	 * Verifica se o email informado é válido.
	 * 
	 * @param email - Email a ser validado.
	 * 
	 * @return
	 */
	
	public static boolean isValidEmail(String email) {
		
		Matcher matcher = EMAIL_PATTERN.matcher(email);
		
		return !matcher.find();
		
	}
	
}
