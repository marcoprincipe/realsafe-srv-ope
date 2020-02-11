package br.com.volans.realsafe.service;

import br.com.volans.realsafe.dto.ClosingDetailDTO;
import br.com.volans.realsafe.dto.OpeningDetailDTO;
import br.com.volans.realsafe.dto.TerminalDTO;
import br.com.volans.realsafe.dto.TerminalStatusDTO;
import br.com.volans.realsafe.dto.payload.CloseTerminalRequest;
import br.com.volans.realsafe.dto.payload.GetClosingDetailRequest;
import br.com.volans.realsafe.dto.payload.GetOpeningDetailRequest;
import br.com.volans.realsafe.dto.payload.OpenTerminalRequest;
import br.com.volans.realsafe.dto.payload.PrintCloseTerminalReceiptRequest;
import br.com.volans.realsafe.dto.payload.PrintOpenTerminalReceiptRequest;
import br.com.volans.realsafe.exception.ServiceLayerException;

/**
 * Interface para implementação dos serviços de terminais.
 * 
 * @author Volans Informática Ltda.
 */

public interface TerminalService {

	/**
	 * Recupera os dados do terminal local.
	 * 
	 * @return - Dados do terminal.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	TerminalDTO getLocalTerminal() throws ServiceLayerException;

	/**
	 * Recupera os dados do status terminal local.
	 * 
	 * @param terminalId - Identificador do terminal.
	 * 
	 * @return - Dados do status do terminal.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	TerminalStatusDTO getTerminalStatus(String terminalId) throws ServiceLayerException;

	/**
	 * Efetua a abertura do terminal.
	 * 
	 * @param request - Dados para abertura do terminal.
	 * 
	 * @return - Status do terminal atualizado.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	TerminalStatusDTO openTerminal(OpenTerminalRequest request) throws ServiceLayerException;
	
	/**
	 * Efetua a impressão do recibo de uma operação de abertura de terminal.
	 * 
	 * @param request - Dados do recibo a ser impresso.
	 * 
	 * @return - Resultado da impressão do recibo.
	 * 
	 * @throws ServiceLayerException
	 */
	
	Integer printOpenTerminalReceipt(PrintOpenTerminalReceiptRequest request) throws ServiceLayerException;

	/**
	 * Retorna os dados do detalhe da abertura do terminal.
	 * 
	 * @param request - Dados para pesquisa dos detalhes da abertura.
	 * 
	 * @return - Dados do detalhe da abertura do terminal.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	OpeningDetailDTO getOpeningDetail(GetOpeningDetailRequest request) throws ServiceLayerException;

	/**
	 * Efetua o fechamento do terminal.
	 * 
	 * @param request - Dados para fechamento do terminal.
	 * 
	 * @return - Status do terminal atualizado.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	TerminalStatusDTO closeTerminal(CloseTerminalRequest request) throws ServiceLayerException;
	
	/**
	 * Efetua a impressão do recibo de uma operação de fechamento de terminal.
	 * 
	 * @param request - Dados do recibo a ser impresso.
	 * 
	 * @return - Resultado da impressão do recibo.
	 * 
	 * @throws ServiceLayerException
	 */
	
	Integer printCloseTerminalReceipt(PrintCloseTerminalReceiptRequest request) throws ServiceLayerException;

	/**
	 * Retorna os dados do detalhe do fechamento do terminal.
	 * 
	 * @param request - Dados para pesquisa dos detalhes do fechamento.
	 * 
	 * @return - Dados do detalhe do fechamento do terminal.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	ClosingDetailDTO getClosingDetail(GetClosingDetailRequest request) throws ServiceLayerException;

}
