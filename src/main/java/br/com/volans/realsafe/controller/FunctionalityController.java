package br.com.volans.realsafe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.volans.realsafe.dto.FunctionalityRoleDTO;
import br.com.volans.realsafe.dto.payload.ListFunctionalitiesByRoleIdRequest;
import br.com.volans.realsafe.dto.payload.ListFunctionalitiesByRoleIdResponse;
import br.com.volans.realsafe.enums.RestResponseCodes;
import br.com.volans.realsafe.rest.RestResponse;
import br.com.volans.realsafe.service.FunctionalityRoleService;

/**
 * Controller dos serviços de funcionalidades.
 * 
 * @author Volans Informática Ltda.
 */

@RestController
@RequestMapping("/api/v1/functionality")
public class FunctionalityController {

	/**
	 * Declaração das variáveis membro
	 */
	
	private FunctionalityRoleService functionalityRoleService;
	
	/**
	 * Construtor alternativo da classe
	 * 
	 * @param functionalityRoleService - Instância do serviço de funcionalidades de perfis.
	 */
	
	@Autowired
	public FunctionalityController(FunctionalityRoleService functionalityRoleService) {
		this.functionalityRoleService = functionalityRoleService;
	}
	
	/**
	 * Retorna a lista de grupos de um do usuário.
	 *  
	 *  @param request - Parâmetros para pesquisa dos grupos.
	 *  
	 * @return - Lista de grupos do usuário.
	 */
	
	@RequestMapping(path = "/listFunctionalitiesByRoleId", method = RequestMethod.POST)
	public ResponseEntity<RestResponse<ListFunctionalitiesByRoleIdResponse>> listFunctionalitiesByRoleId(@RequestBody ListFunctionalitiesByRoleIdRequest request) {
		
		List<FunctionalityRoleDTO> functionalitiesRole = 
				functionalityRoleService.listFunctionalitiesByRoleId(request.getRoleId(), request.getParentId());
		
		ListFunctionalitiesByRoleIdResponse result = new ListFunctionalitiesByRoleIdResponse(functionalitiesRole);
		
		RestResponse<ListFunctionalitiesByRoleIdResponse> restResponse = 
				new RestResponse<ListFunctionalitiesByRoleIdResponse>(RestResponseCodes.OK.getCode(), RestResponseCodes.OK.getDescription(), result);
		
		return new ResponseEntity<RestResponse<ListFunctionalitiesByRoleIdResponse>>(restResponse, HttpStatus.OK);
		
	}

}
