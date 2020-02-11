package br.com.volans.realsafe.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.volans.realsafe.dao.TerminalStatusDAO;
import br.com.volans.realsafe.dto.TerminalStatusDTO;
import br.com.volans.realsafe.exception.ServiceLayerException;
import br.com.volans.realsafe.service.AbstractService;
import br.com.volans.realsafe.service.TerminalStatusService;

/**
 * Implementação da interface dos serviços de status de terminais.
 * 
 * @author Volans Informática Ltda.
 */

@Service
public class TerminalStatusServiceImpl extends AbstractService implements TerminalStatusService {
	
	/**
	 * Declaração das variáveis membro.
	 */

	private TerminalStatusDAO terminalStatusDAO;

	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param terminalStatusDAO - Instância do DAO de status de terminais.
	 */
	
	@Autowired
	public TerminalStatusServiceImpl(TerminalStatusDAO terminalStatusDAO) {
		this.terminalStatusDAO = terminalStatusDAO;
	}

	/**
	 * Recupera os dados do status terminal local.
	 * 
	 * @return - Dados do status terminal local.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	@Override
	public TerminalStatusDTO getLocalTerminalStatus() throws ServiceLayerException {
		return terminalStatusDAO.findSingleLocal();
	}
	
}
