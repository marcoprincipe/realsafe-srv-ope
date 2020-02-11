package br.com.volans.realsafe.configuration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Classe para configuração do client rest.
 * 
 * @author Volans Informática Ltda.
 */

@Configuration
public class RestConfiguration {
	
	/**
	 * Configura o template para os clientes rest.
	 * 
	 * @return - Instância do objeto RestTemplate.
	 */
	
	@Bean
	public RestTemplate createRestTemplate() {
		
		return (new RestTemplateBuilder()).build();
		
	}

}
