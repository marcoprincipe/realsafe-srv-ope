package br.com.volans.realsafe.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Classe para configuração do cors da aplicação.
 * 
 * @author Volans Informática Ltda
 */

@Configuration
public class CorsConfiguration {

	/**
	 * Retorna a instância do configurador WebMvcConfigurer.
	 * 
	 * @return - Instância do configurador WebMvcConfigurer.
	 */
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		
		return new WebMvcConfigurer() {

			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.
					addMapping("/**").
					allowedOrigins("*").
					allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS");
			}
			
		};
		
	}
	
}
