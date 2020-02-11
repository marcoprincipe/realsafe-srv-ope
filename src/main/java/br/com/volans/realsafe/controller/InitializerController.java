package br.com.volans.realsafe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.volans.realsafe.dto.CompanyDTO;
import br.com.volans.realsafe.dto.FunctionalityDTO;
import br.com.volans.realsafe.dto.FunctionalityRoleDTO;
import br.com.volans.realsafe.dto.GroupDTO;
import br.com.volans.realsafe.dto.GroupOwnerDTO;
import br.com.volans.realsafe.dto.RoleDTO;
import br.com.volans.realsafe.dto.TerminalDTO;
import br.com.volans.realsafe.dto.UnitDTO;
import br.com.volans.realsafe.dto.payload.FindGroupOwnerByTerminalIdIdRequest;
import br.com.volans.realsafe.dto.payload.FindTerminalByIdRequest;
import br.com.volans.realsafe.dto.payload.ListCompanyByGroupOwnerIdRequest;
import br.com.volans.realsafe.dto.payload.ListGroupByGroupOwnerIdRequest;
import br.com.volans.realsafe.dto.payload.ListUnitsByGroupOwnerIdRequest;
import br.com.volans.realsafe.enums.RestResponseCodes;
import br.com.volans.realsafe.rest.RestResponse;
import br.com.volans.realsafe.service.InitializerService;

/**
 * Controller dos serviços de inicialização do terminal.
 * 
 * @author Volans Informática Ltda
 */

@RestController
@RequestMapping("/api/v1/initializer")
public class InitializerController {

	/**
	 * Declaração das variáveis membro
	 */
	
	private InitializerService initializerService;
	
	/**
	 * Construtor alternativo da classe
	 * 
	 * @param initializerService - Instância do serviço de initialização de terminais.
	 */
	
	@Autowired
	public InitializerController(InitializerService initializerService) {
		this.initializerService = initializerService;
	}

	/**
	 * Retorna o proprietário de grupos a partir do identificador do terminal informado.
	 * 
	 * @param request - Dados para pesquisa.
	 *  
	 * @return - Proprietário de grupos pesquisado.
	 */
	
	@RequestMapping(path = "/downloadGroupOwner", method = RequestMethod.POST)
	public ResponseEntity<RestResponse<GroupOwnerDTO>> findGroupOwnerByTerminalId(@RequestBody FindGroupOwnerByTerminalIdIdRequest request) {

		GroupOwnerDTO result = initializerService.downloadGroupOwner(request.getTerminalId());
		
		RestResponse<GroupOwnerDTO> restResponse = 
				new RestResponse<GroupOwnerDTO>(RestResponseCodes.OK.getCode(), RestResponseCodes.OK.getDescription(), result);
		
		return new ResponseEntity<RestResponse<GroupOwnerDTO>>(restResponse, HttpStatus.OK);
		
	}

	/**
	 * Retorna a lista de grupos a partir do identificador do proprietário de grupos informado.
	 * 
	 * @param request - Dados para pesquisa.
	 *  
	 * @return - Proprietário de grupos pesquisado.
	 */
	
	@RequestMapping(path = "/downloadGroups", method = RequestMethod.POST)
	public ResponseEntity<RestResponse<List<GroupDTO>>> listGroupsByGroupOwnerId(@RequestBody ListGroupByGroupOwnerIdRequest request) {

		List<GroupDTO> result = initializerService.downloadGroups(request.getGroupOwnerId());
		
		RestResponse<List<GroupDTO>> restResponse = 
				new RestResponse<List<GroupDTO>>(RestResponseCodes.OK.getCode(), RestResponseCodes.OK.getDescription(), result);
		
		return new ResponseEntity<RestResponse<List<GroupDTO>>>(restResponse, HttpStatus.OK);
		
	}

	/**
	 * Retorna a lista de empresas a partir do identificador do proprietário de grupos informado.
	 * 
	 * @param request - Dados para pesquisa.
	 *  
	 * @return - Proprietário de grupos pesquisado.
	 */
	
	@RequestMapping(path = "/downloadCompanies", method = RequestMethod.POST)
	public ResponseEntity<RestResponse<List<CompanyDTO>>> listCompaniesByGroupOwnerId(@RequestBody ListCompanyByGroupOwnerIdRequest request) {

		List<CompanyDTO> result = initializerService.downloadCompanies(request.getGroupOwnerId());
		
		RestResponse<List<CompanyDTO>> restResponse = 
				new RestResponse<List<CompanyDTO>>(RestResponseCodes.OK.getCode(), RestResponseCodes.OK.getDescription(), result);
		
		return new ResponseEntity<RestResponse<List<CompanyDTO>>>(restResponse, HttpStatus.OK);
		
	}

	/**
	 * Retorna a lista de unidades a partir do identificador do proprietário de grupos informado.
	 * 
	 * @param request - Dados para pesquisa.
	 *  
	 * @return - Lista de unidades pesquisadas.
	 */
	
	@RequestMapping(path = "/downloadUnits", method = RequestMethod.POST)
	public ResponseEntity<RestResponse<List<UnitDTO>>> listUnitsByGroupOwnerId(@RequestBody ListUnitsByGroupOwnerIdRequest request) {

		List<UnitDTO> result = initializerService.downloadUnits(request.getGroupOwnerId());
		
		RestResponse<List<UnitDTO>> restResponse = 
				new RestResponse<List<UnitDTO>>(RestResponseCodes.OK.getCode(), RestResponseCodes.OK.getDescription(), result);
		
		return new ResponseEntity<RestResponse<List<UnitDTO>>>(restResponse, HttpStatus.OK);
		
	}

	/**
	 * Retorna o terminal a partir do id informado.
	 * 
	 * @param request - Dados para pesquisa.
	 *  
	 * @return - Lista de unidades pesquisadas.
	 */
	
	@RequestMapping(path = "/downloadTerminal", method = RequestMethod.POST)
	public ResponseEntity<RestResponse<TerminalDTO>> FindTerminalById(@RequestBody FindTerminalByIdRequest request) {

		TerminalDTO result = initializerService.downloadTerminal(request.getTerminalId());
		
		RestResponse<TerminalDTO> restResponse = 
				new RestResponse<TerminalDTO>(RestResponseCodes.OK.getCode(), RestResponseCodes.OK.getDescription(), result);
		
		return new ResponseEntity<RestResponse<TerminalDTO>>(restResponse, HttpStatus.OK);
		
	}

	/**
	 * Retorna a lista de funcionalidades operacionais.
	 *  
	 * @return - Lista de funcionalidades pesquisadas.
	 */
	
	@RequestMapping(path = "/downloadFunctionalities", method = RequestMethod.GET)
	public ResponseEntity<RestResponse<List<FunctionalityDTO>>> downloadFunctionalities() {

		List<FunctionalityDTO> result = initializerService.downloadFunctionalities();
		
		RestResponse<List<FunctionalityDTO>> restResponse = 
				new RestResponse<List<FunctionalityDTO>>(RestResponseCodes.OK.getCode(), RestResponseCodes.OK.getDescription(), result);
		
		return new ResponseEntity<RestResponse<List<FunctionalityDTO>>>(restResponse, HttpStatus.OK);
		
	}

	/**
	 * Retorna a lista de perfis de usuário.
	 *  
	 * @return - Lista de perfis de usuário pesquisados.
	 */
	
	@RequestMapping(path = "/downloadRoles", method = RequestMethod.GET)
	public ResponseEntity<RestResponse<List<RoleDTO>>> downloadRoles() {

		List<RoleDTO> result = initializerService.downloadRoles();
		
		RestResponse<List<RoleDTO>> restResponse = 
				new RestResponse<List<RoleDTO>>(RestResponseCodes.OK.getCode(), RestResponseCodes.OK.getDescription(), result);
		
		return new ResponseEntity<RestResponse<List<RoleDTO>>>(restResponse, HttpStatus.OK);
		
	}

	/**
	 * Retorna a lista de funcionalidades X perfis de usuário.
	 *  
	 * @return - Lista de funcionalidades X perfis de usuário pesquisados.
	 */
	
	@RequestMapping(path = "/downloadFunctionalityRoles", method = RequestMethod.GET)
	public ResponseEntity<RestResponse<List<FunctionalityRoleDTO>>> downloadFunctionalityRoles() {

		List<FunctionalityRoleDTO> result = initializerService.downloadFunctionalityRoles();
		
		RestResponse<List<FunctionalityRoleDTO>> restResponse = 
				new RestResponse<List<FunctionalityRoleDTO>>(RestResponseCodes.OK.getCode(), RestResponseCodes.OK.getDescription(), result);
		
		return new ResponseEntity<RestResponse<List<FunctionalityRoleDTO>>>(restResponse, HttpStatus.OK);
		
	}

}
