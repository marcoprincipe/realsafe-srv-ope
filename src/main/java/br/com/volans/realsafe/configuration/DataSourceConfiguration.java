package br.com.volans.realsafe.configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariDataSource;

/**
 * Classe para configuração do datasource.
 * 
 * @author Volans Informática Ltda
 */

@Configuration
public class DataSourceConfiguration {
	
	/**
	 * Configura o datasource a ser utilizado.
	 * 
	 * @return - Instância do objeto datasource.
	 */
	
	@Bean
	public DataSource dataSource() {
		
		HikariDataSource datasource = new HikariDataSource();
		
		datasource.setJdbcUrl("jdbc:mysql://localhost:3306/realsafe_ope_db?useSSL=false&allowPublicKeyRetrieval=true&useTimezone=true&serverTimezone=UTC");
		datasource.setUsername("realsafe_user");
		datasource.setPassword("R3al$afe");
		datasource.setPoolName("realsafe-pool");
		datasource.setMaximumPoolSize(5);
		datasource.setMaxLifetime(1800000);
		
		return datasource;
		
	}

}
