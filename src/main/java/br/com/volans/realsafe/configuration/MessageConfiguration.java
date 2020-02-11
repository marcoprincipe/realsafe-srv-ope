package br.com.volans.realsafe.configuration;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * Classe para configuração do arquivo de mensagens.
 * 
 * @author Volans Informática Ltda
 */

@Configuration
public class MessageConfiguration {
	
	/**
	 * Configura o arquivo de mensagens.
	 * 
	 * @return - Instância do objeto de mensagens.
	 */
	
	@Bean
	public MessageSource messageSource() {
		
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("i18n/messages");
		messageSource.setUseCodeAsDefaultMessage(true);
		
		return messageSource;
		
	}

}
