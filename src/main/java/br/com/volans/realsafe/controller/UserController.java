package br.com.volans.realsafe.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.volans.realsafe.dto.LoginDTO;
import br.com.volans.realsafe.dto.UserCompanyDTO;
import br.com.volans.realsafe.dto.UserDTO;
import br.com.volans.realsafe.dto.UserGroupDTO;
import br.com.volans.realsafe.dto.UserUnitDTO;
import br.com.volans.realsafe.dto.payload.ListUserCompaniesRequest;
import br.com.volans.realsafe.dto.payload.ListUserCompaniesResponse;
import br.com.volans.realsafe.dto.payload.ListUserGroupsRequest;
import br.com.volans.realsafe.dto.payload.ListUserGroupsResponse;
import br.com.volans.realsafe.dto.payload.ListUserUnitsRequest;
import br.com.volans.realsafe.dto.payload.ListUserUnitsResponse;
import br.com.volans.realsafe.dto.payload.LoginRequest;
import br.com.volans.realsafe.dto.payload.LoginResponse;
import br.com.volans.realsafe.dto.payload.UpdatePasswordRequest;
import br.com.volans.realsafe.enums.RestResponseCodes;
import br.com.volans.realsafe.rest.RestResponse;
import br.com.volans.realsafe.service.UserService;
import br.com.volans.realsafe.service.UserUnitService;

/**
 * Controller dos serviços de usuários.
 * 
 * @author Volans Informática Ltda
 */

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

	/**
	 * Declaração das variáveis membro
	 */

	private UserService userService;
	private UserUnitService userUnitService;
	
	/**
	 * Construtor alternativo da classe
	 * 
	 * @param userService - Instância do serviço de usuários.
	 * @param userUnitService - Instância do serviço de unidades de usuários.
	 */
	
	@Autowired
	public UserController(UserService userService, UserUnitService userUnitService) {
		this.userService = userService;
		this.userUnitService = userUnitService;
	}
	
	/**
	 * Efetua o login do usuário.
	 *  
	 * @return - Dados do usuário logado.
	 */
	
	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public ResponseEntity<RestResponse<LoginResponse>> findCompanyById(@RequestBody LoginRequest request) {

		LoginDTO loginDTO = new LoginDTO();
		
		BeanUtils.copyProperties(request, loginDTO);
		
		UserDTO userDTO = userService.login(loginDTO);
		
		LoginResponse result = new LoginResponse(userDTO);
		
		RestResponse<LoginResponse> restResponse = 
				new RestResponse<LoginResponse>(RestResponseCodes.OK.getCode(), RestResponseCodes.OK.getDescription(), result);
		
		return new ResponseEntity<RestResponse<LoginResponse>>(restResponse, HttpStatus.OK);
		
	}
	
	/**
	 * Efetua o login do usuário.
	 *  
	 * @return - Dados do usuário logado.
	 */
	
	@RequestMapping(path = "/changePassword", method = RequestMethod.POST)
	public ResponseEntity<RestResponse<Integer>> changePassword(@RequestBody UpdatePasswordRequest request) {

		UserDTO userDTO = new UserDTO();
		
		BeanUtils.copyProperties(request, userDTO);
		
		Integer rowsAffected = userService.updatePassword(userDTO);
		
		RestResponse<Integer> restResponse = 
				new RestResponse<Integer>(RestResponseCodes.OK.getCode(), RestResponseCodes.OK.getDescription(), rowsAffected);
		
		return new ResponseEntity<RestResponse<Integer>>(restResponse, HttpStatus.OK);
		
	}
	
	/**
	 * Retorna a lista de grupos de um do usuário.
	 *  
	 *  @param request - Parâmetros para pesquisa dos grupos.
	 *  
	 * @return - Lista de grupos do usuário.
	 */
	
	@RequestMapping(path = "/listUserGroups", method = RequestMethod.POST)
	public ResponseEntity<RestResponse<ListUserGroupsResponse>> listUserGroups(@RequestBody ListUserGroupsRequest request) {
		
		List<UserGroupDTO> userGroups = userUnitService.listUserGroups(request.getGroupOwnerId(), request.getUserId());
		
		ListUserGroupsResponse result = new ListUserGroupsResponse(userGroups);
		
		RestResponse<ListUserGroupsResponse> restResponse = 
				new RestResponse<ListUserGroupsResponse>(RestResponseCodes.OK.getCode(), RestResponseCodes.OK.getDescription(), result);
		
		return new ResponseEntity<RestResponse<ListUserGroupsResponse>>(restResponse, HttpStatus.OK);
		
	}
	
	/**
	 * Retorna a lista de empresas de um do usuário.
	 *  
	 *  @param request - Parâmetros para pesquisa das empresas.
	 *  
	 * @return - Lista de empresas do usuário.
	 */
	
	@RequestMapping(path = "/listUserCompanies", method = RequestMethod.POST)
	public ResponseEntity<RestResponse<ListUserCompaniesResponse>> listUserCompanies(@RequestBody ListUserCompaniesRequest request) {
		
		List<UserCompanyDTO> userCompanies = userUnitService.listUserCompanies(request.getGroupOwnerId(), request.getUserId(), request.getGroupId());
		
		ListUserCompaniesResponse result = new ListUserCompaniesResponse(userCompanies);
		
		RestResponse<ListUserCompaniesResponse> restResponse = 
				new RestResponse<ListUserCompaniesResponse>(RestResponseCodes.OK.getCode(), RestResponseCodes.OK.getDescription(), result);
		
		return new ResponseEntity<RestResponse<ListUserCompaniesResponse>>(restResponse, HttpStatus.OK);
		
	}
	
	/**
	 * Retorna a lista de unidades de um do usuário.
	 *  
	 *  @param request - Parâmetros para pesquisa das unidades.
	 *  
	 * @return - Lista de unidades do usuário.
	 */
	
	@RequestMapping(path = "/listUserUnits", method = RequestMethod.POST)
	public ResponseEntity<RestResponse<ListUserUnitsResponse>> listUserUnits(@RequestBody ListUserUnitsRequest request) {
		
		List<UserUnitDTO> userUnits = userUnitService.listUserUnits(request.getGroupOwnerId(), request.getUserId(), request.getGroupId(), request.getCompanyId());
		
		ListUserUnitsResponse result = new ListUserUnitsResponse(userUnits);
		
		RestResponse<ListUserUnitsResponse> restResponse = 
				new RestResponse<ListUserUnitsResponse>(RestResponseCodes.OK.getCode(), RestResponseCodes.OK.getDescription(), result);
		
		return new ResponseEntity<RestResponse<ListUserUnitsResponse>>(restResponse, HttpStatus.OK);
		
	}
	
}
