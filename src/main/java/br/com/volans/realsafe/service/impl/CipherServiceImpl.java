package br.com.volans.realsafe.service.impl;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Service;

import br.com.volans.realsafe.exception.SystemException;
import br.com.volans.realsafe.service.AbstractService;
import br.com.volans.realsafe.service.CipherService;

/**
 * Implementação da interface dos serviços de criptografia.
 * 
 * @author Volans Informática Ltda
 */

@Service
public class CipherServiceImpl extends AbstractService implements CipherService {
	
	/**
	 * Declaração das constantes da classe
	 */
	
	private static final String DIGEST_ALGORITHM = "sha-256";
	
	/**
	 * Efetua a geração do hash sha256
	 * 
	 * @param data - Dado para geração do hash.
	 * 
	 * @return - Hash do dado informado.
	 * 
	 * @throws SystemException - Exceção do sistema
	 */
	
	@Override
	public String sha256(String data) throws SystemException {

		StringBuffer hash = new StringBuffer();
		
		try {
			
			MessageDigest digest = MessageDigest.getInstance(DIGEST_ALGORITHM);
			
			byte[] bytes = digest.digest(data.getBytes(StandardCharsets.UTF_8));
			
			for (Integer index = 0; index < bytes.length; index++) {
				hash.append(String.format("%02x", bytes[index] & 0xff));
			}
			
		} 
		catch (NoSuchAlgorithmException ex) {
			
			throw new SystemException(ex);
			
		}
		
		return hash.toString();
		
	}

}
