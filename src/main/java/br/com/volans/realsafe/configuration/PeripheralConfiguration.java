package br.com.volans.realsafe.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import br.com.volans.realsafe.driver.depository.DepositoryDriver;
import br.com.volans.realsafe.driver.printer.PrinterDriver;
import br.com.volans.realsafe.driver.sensors.SensorsDriver;
import br.com.volans.realsafe.util.Utils;

/**
 * Classe para configuração dos periféricos.
 * 
 * @author Volans Informática Ltda
 */

@Configuration
@PropertySource("classpath:configuration/peripheral.properties")
public class PeripheralConfiguration {
	
	/**
	 * Declaração do logger da classe
	 */
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PeripheralConfiguration.class);
	
	/**
	 * Declaração das constantes da classe
	 */
	
	private static String PRINTER_DRIVER_VARIABLE = "PRINTER_DRIVER";
	private static String DEPOSITORY_DRIVER_VARIABLE = "DEPOSITORY_DRIVER";
	private static String SENSORS_DRIVER_VARIABLE = "SENSORS_DRIVER";
	
	/**
	 * Declaração das variáveis membro
	 */
	
	@Value("${printer.driver}")
	private String defaultPrinterDriverName;

	@Value("${depository.driver}")
	private String defaultDepositoryDriverName;

	@Value("${sensors.driver}")
	private String defaultSensorsDriverName;
	
	private ApplicationContext context;
	
	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param context - Intância do application context do spring boot;
	 */
	
	@Autowired
	public PeripheralConfiguration(ApplicationContext context) {
		this.context = context;
	}
	
	/**
	 * Retorna a instância do driver da impressora
	 * 
	 * @return - Instância do driver da impressora configurada.
	 */
	
	@Bean
	public PrinterDriver printerDriver() {
		
		String driverName = Utils.getVariable(PRINTER_DRIVER_VARIABLE, defaultPrinterDriverName);
		
		PrinterDriver driver = (PrinterDriver) context.getBean(driverName);
		
		if (LOGGER.isInfoEnabled()) {
			LOGGER.warn(String.format("*** Using printer driver : %s", driverName));
		}
		
		return driver;
		
	}
	
	/**
	 * Retorna a instância do driver do depositário.
	 * 
	 * @return - Instância do driver do depositário configurado.
	 */
	
	@Bean
	public DepositoryDriver depositoryDriver() {
		
		String driverName = Utils.getVariable(DEPOSITORY_DRIVER_VARIABLE, defaultDepositoryDriverName);
		
		DepositoryDriver driver = (DepositoryDriver) context.getBean(driverName);
		
		if (LOGGER.isInfoEnabled()) {
			LOGGER.warn(String.format("*** Using depository driver : %s", driverName));
		}
		
		return driver;
		
	}
	
	/**
	 * Retorna a instância do driver do depositário.
	 * 
	 * @return - Instância do driver do depositário configurado.
	 */
	
	@Bean
	public SensorsDriver sensorsDriver() {
		
		String driverName = Utils.getVariable(SENSORS_DRIVER_VARIABLE, defaultSensorsDriverName);
		
		SensorsDriver driver = (SensorsDriver) context.getBean(driverName);
		
		if (LOGGER.isInfoEnabled()) {
			LOGGER.warn(String.format("*** Using sensor board driver : %s", driverName));
		}
		
		return driver;
		
	}

}
