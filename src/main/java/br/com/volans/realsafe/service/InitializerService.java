package br.com.volans.realsafe.service;

import java.math.BigDecimal;
import java.util.List;

import br.com.volans.realsafe.dto.CompanyDTO;
import br.com.volans.realsafe.dto.FunctionalityDTO;
import br.com.volans.realsafe.dto.FunctionalityRoleDTO;
import br.com.volans.realsafe.dto.GroupDTO;
import br.com.volans.realsafe.dto.GroupOwnerDTO;
import br.com.volans.realsafe.dto.RoleDTO;
import br.com.volans.realsafe.dto.TerminalDTO;
import br.com.volans.realsafe.dto.UnitDTO;
import br.com.volans.realsafe.exception.ServiceLayerException;

/**
 * Interface para implementação dos serviços de inicialização do terminal.
 * 
 * @author Volans Informática Ltda.
 */

public interface InitializerService {
	
	/**
	 * Efetua o download dos dados da tabela de proprietário de grupos.
	 * 
	 * @param terminalId - Identificador do terminal.
	 * 
	 * @return - Dados do proprietário de grupos do terminal.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	GroupOwnerDTO downloadGroupOwner(String terminalId) throws ServiceLayerException;
	
	/**
	 * Efetua o download dos dados da tabela de grupos.
	 * 
	 * @param groupOwnerId - Identificador do proprietário de grupos.
	 * 
	 * @return - Lista com os dados dos grupos.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	List<GroupDTO> downloadGroups(BigDecimal groupOwnerId) throws ServiceLayerException;
	
	/**
	 * Efetua o download dos dados da tabela de empresas.
	 * 
	 * @param groupOwnerId - Identificador do proprietário de empresas.
	 * 
	 * @return - Lista com os dados das empresas.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	List<CompanyDTO> downloadCompanies(BigDecimal groupOwnerId) throws ServiceLayerException;
	
	/**
	 * Efetua o download dos dados da tabela de unidades.
	 * 
	 * @param groupOwnerId - Identificador do proprietário de empresas.
	 * 
	 * @return - Lista com os dados das unidades.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	List<UnitDTO> downloadUnits(BigDecimal groupOwnerId) throws ServiceLayerException;
	
	/**
	 * Efetua o download dos dados da tabela de terminais.
	 * 
	 * @param terminalId - Identificador do terminal.
	 * 
	 * @return - Dados do terminal.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	TerminalDTO downloadTerminal(String terminalId) throws ServiceLayerException;
	
	/**
	 * Efetua o download dos dados da tabela de funcionalidades.
	 * 
	 * @return - Lista com os dados das funcionalidades.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	List<FunctionalityDTO> downloadFunctionalities() throws ServiceLayerException;
	
	/**
	 * Efetua o download dos dados da tabela de perfis de usuários.
	 * 
	 * @return - Lista com os dados dos perfis de usuário.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	List<RoleDTO> downloadRoles() throws ServiceLayerException;
	
	/**
	 * Efetua o download dos dados da tabela de funcionalidades X perfis de usuários.
	 * 
	 * @return - Lista com os dados das funcionalides X perfis de usuário.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	List<FunctionalityRoleDTO> downloadFunctionalityRoles() throws ServiceLayerException;

}
