package br.com.volans.realsafe.service.impl;

import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.volans.realsafe.driver.printer.PrinterDriver;
import br.com.volans.realsafe.dto.PrinterStatusDTO;
import br.com.volans.realsafe.enums.MessageKeys;
import br.com.volans.realsafe.enums.PrinterStatus;
import br.com.volans.realsafe.exception.ServiceLayerException;
import br.com.volans.realsafe.service.AbstractService;
import br.com.volans.realsafe.service.PrinterService;

/**
 * Implementação da interface dos serviços de impressora.
 * 
 * @author Volans Informática Ltda.
 */

@Service
public class PrinterServiceImpl extends AbstractService implements PrinterService {
	
	/**
	 * Declaração das variáveis membro
	 */
	
	private PrinterDriver printerDriver;
	
	/**
	 * Construtor default da classe.
	 * 
	 * @param printerDriver - Instância do driver da impressora a ser utilizado. 
	 */
	
	@Autowired
	public PrinterServiceImpl(PrinterDriver printerDriver) {
		this.printerDriver = printerDriver;
	}
	
	/**
	 * Efetua a abertura da impressora.
	 * 
	 * @return - Resultado da operação. 
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	@Override
	public Integer open() throws ServiceLayerException {
		
		Integer code = printerDriver.open();

		if (code != 0) {
			
			PrinterStatus status = PrinterStatus.getByCode(code);
			
			if (status == null) {
				throw new ServiceLayerException(String.format(getMessage(MessageKeys.PRINTER_STATUS_CODE_NOT_FOUND.getKey()), code));
			}
			
			throw new ServiceLayerException(String.format(getMessage(MessageKeys.OPEN_PRINTER_FAILED.getKey()), getMessage(status.getKey())));

		}
		
		return code;

	}
	
	/**
	 * Efetua o fechamento da impressora.
	 * 
	 * @return - Resultado da operação. 
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	@Override
	public Integer close() throws ServiceLayerException {
		
		Integer code = printerDriver.close();
		
		if (code != 0) {
			
			PrinterStatus status = PrinterStatus.getByCode(code);
			
			if (status == null) {
				throw new ServiceLayerException(String.format(getMessage(MessageKeys.PRINTER_STATUS_CODE_NOT_FOUND.getKey()), code));
			}
			
			throw new ServiceLayerException(String.format(getMessage(MessageKeys.CLOSE_PRINTER_FAILED.getKey()), getMessage(status.getKey())));

		}
		
		return code;
		
	}
	
	/**
	 * Efetua a limpeza dos recursos do serviço.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	@PreDestroy
	public void cleanup() throws ServiceLayerException {
		
		close();

	}
	
	/**
	 * Efetua a verificação da impressora.
	 * 
	 * @return - Resultado da verificação. 
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	@Override
	public Integer check() throws ServiceLayerException {
		return printerDriver.getStatus();
	}
	
	/**
	 * Retorna o status da impressora.
	 * 
	 * @return - Objeto com o status da impressora. 
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	@Override
	public PrinterStatusDTO getStatus() throws ServiceLayerException {
		
		PrinterStatusDTO result = new PrinterStatusDTO();
		
		Integer code = printerDriver.getStatus();
			
		PrinterStatus status = PrinterStatus.getByCode(code);
		
		if (status == null) {
			throw new ServiceLayerException(String.format(getMessage(MessageKeys.PRINTER_STATUS_CODE_NOT_FOUND.getKey()), code));
		}
		
		result.setCode(status.getCode());
		result.setDescription(getMessage(status.getKey()));
		
		return result;
		
	}
	
	/**
	 * Efetua a impressão dos dados informados.
	 * 
	 * @param buffer - Dados a serem impressos.
	 * 
	 * @return - Resultado da impressão.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	@Override
	public Integer print(byte[] buffer) throws ServiceLayerException {
		
		Integer code = printerDriver.print(buffer);
		
		if (code != 0) {
			
			PrinterStatus status = PrinterStatus.getByCode(code);
			
			if (status == null) {
				throw new ServiceLayerException(String.format(getMessage(MessageKeys.PRINTER_STATUS_CODE_NOT_FOUND.getKey()), code));
			}
			
			throw new ServiceLayerException(String.format(getMessage(MessageKeys.PRINT_DOCUMENT_FAILED.getKey()), getMessage(status.getKey())));

		}
		
		return code;
		
	}
	
	/**
	 * Efetua o corte do papel.
	 * 
	 * @return - Resultado do corte do papel.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	@Override
	public Integer cut() throws ServiceLayerException {
		
		Integer code = printerDriver.cut();
		
		if (code != 0) {
			
			PrinterStatus status = PrinterStatus.getByCode(code);
			
			if (status == null) {
				throw new ServiceLayerException(String.format(getMessage(MessageKeys.PRINTER_STATUS_CODE_NOT_FOUND.getKey()), code));
			}
			
			throw new ServiceLayerException(String.format(getMessage(MessageKeys.PAPER_CUT_FAILED.getKey()), getMessage(status.getKey())));

		}
		
		
		return code;
		
	}
	
	/**
	 * Efetua a inicialização da impressora.
	 * 
	 * @return - Resultado da inicialização. 
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	@Override
	public Integer reset() throws ServiceLayerException {
		
		Integer code = printerDriver.reset();
		
		if (code != 0) {
			
			PrinterStatus status = PrinterStatus.getByCode(code);
			
			if (status == null) {
				throw new ServiceLayerException(String.format(getMessage(MessageKeys.PRINTER_STATUS_CODE_NOT_FOUND.getKey()), code));
			}
			
			throw new ServiceLayerException(String.format(getMessage(MessageKeys.PRINTER_RESET_FAILED.getKey()), getMessage(status.getKey())));

		}
		
		return code;
		
	}

}
