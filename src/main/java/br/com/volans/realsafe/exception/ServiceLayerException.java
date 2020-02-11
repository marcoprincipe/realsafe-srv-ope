package br.com.volans.realsafe.exception;

/**
 * Classe de exceção da camada de negócio da aplicação.
 * 
 * @author Volans Informática Ltda
 */

public class ServiceLayerException extends RuntimeException {

	/**
	 * Declaração da serial version.
	 */
	
	private static final long serialVersionUID = -4212494038361949035L;

	/**
	 * Construtor default da classe,
	 */
	
	public ServiceLayerException() {
		super();
	}

	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param message - Mensagem de erro da exceção.
	 */
	
	public ServiceLayerException(String message) {
		super(message);
	}

	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param cause - Causa raiz da exceção.
	 */
	
	public ServiceLayerException(Throwable cause) {
		super(cause);
	}

	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param message - Mensagem de erro da exceção.
	 * @param cause - Causa raiz da exceção.
	 */
	public ServiceLayerException(String message, Throwable cause) {
		super(message, cause);
	}

}
