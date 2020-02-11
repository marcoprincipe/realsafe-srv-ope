package br.com.volans.realsafe.exception;

/**
 * Classe de exceção genérica do sistema.
 * 
 * @author Volans Informática Ltda
 */

public class SystemException extends RuntimeException {

	/**
	 * Declaração da serial version.
	 */

	private static final long serialVersionUID = -1398974184183402116L;

	/**
	 * Construtor default da classe,
	 */
	
	public SystemException() {
		super();
	}

	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param message - Mensagem de erro da exceção.
	 */
	
	public SystemException(String message) {
		super(message);
	}

	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param cause - Causa raiz da exceção.
	 */
	
	public SystemException(Throwable cause) {
		super(cause);
	}

	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param message - Mensagem de erro da exceção.
	 * @param cause - Causa raiz da exceção.
	 */

	public SystemException(String message, Throwable cause) {
		super(message, cause);
	}

}
