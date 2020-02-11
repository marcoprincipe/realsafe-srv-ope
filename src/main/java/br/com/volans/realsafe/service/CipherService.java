package br.com.volans.realsafe.service;

import br.com.volans.realsafe.exception.SystemException;

/**
 * Interface para implementação dos serviços de criptografia.
 * 
 * @author Volans Informática Ltda
 */

public interface CipherService {
	
	/**
	 * Efetua a geração do hash sha256
	 * 
	 * @param data - Dado para geração do hash.
	 * 
	 * @return - Hash do dado informado.
	 * 
	 * @throws SystemException - Exceção do sistema
	 */
	
	String sha256(String data) throws SystemException;

}
