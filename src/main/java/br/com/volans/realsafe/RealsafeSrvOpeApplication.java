package br.com.volans.realsafe;

import java.io.File;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Classe para inicialização da aplicação.
 * 
 * @author Volans Informática Ltda.
 */

@SpringBootApplication
public class RealsafeSrvOpeApplication {
	
	/**
	 * Declaração das constantes da classe.
	 */

	private static String PROC_FILE_PATH = "C:\\Aplic\\data\\realsafe-ope.proc";
	
	/**
	 * Entry-point principal da classe.
	 * 
	 * @param args - Argumentos para execução da aplicação.
	 */
	
	public static void main(String[] args) {
		
		SpringApplication.run(RealsafeSrvOpeApplication.class, args);
		
	}
	
	/**
	 * Efetua a gravação do arquivo de inicialização da aplicação.
	 * 
	 * @return
	 */
	
	@Bean
	public CommandLineRunner execute() {
		
		return (args) -> {
			
			File file = new File(PROC_FILE_PATH);
			
			if (file.exists()) {
				file.delete();
			}
			
			file.createNewFile();
			
		};

	}

}
