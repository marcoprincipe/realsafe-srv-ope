package br.com.volans.realsafe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.volans.realsafe.dto.GroupDTO;
import br.com.volans.realsafe.dto.payload.FindGroupByIdRequest;
import br.com.volans.realsafe.dto.payload.FindGroupByIdResponse;
import br.com.volans.realsafe.dto.payload.ListGroupsResponse;
import br.com.volans.realsafe.enums.RestResponseCodes;
import br.com.volans.realsafe.rest.RestResponse;
import br.com.volans.realsafe.service.GroupService;

/**
 * Controller dos serviços de grupos.
 * 
 * @author Volans Informática Ltda
 */

@RestController
@RequestMapping("/api/v1/group")
public class GroupController {

	/**
	 * Declaração das variáveis membro.
	 */
	
	private GroupService groupService;
	
	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param groupService - Instância do serviço de grupos.
	 */
	
	@Autowired
	public GroupController(GroupService groupService) {
		this.groupService = groupService;
	}

	/**
	 * Retorna o grupo a partir do id informado.
	 *  
	 * @return - O grupo pesquisado.
	 */
	
	@RequestMapping(path = "/findGroupById", method = RequestMethod.POST)
	public ResponseEntity<RestResponse<FindGroupByIdResponse>> findGroupById(@RequestBody FindGroupByIdRequest request) {

		GroupDTO group = groupService.findById(request.getGroupId());
		
		FindGroupByIdResponse result = new FindGroupByIdResponse(group);
		
		RestResponse<FindGroupByIdResponse> restResponse = 
				new RestResponse<FindGroupByIdResponse>(RestResponseCodes.OK.getCode(), RestResponseCodes.OK.getDescription(), result);
		
		return new ResponseEntity<RestResponse<FindGroupByIdResponse>>(restResponse, HttpStatus.OK);
		
	}

	/**
	 * Retorna a lista de grupos cadastrados.
	 *  
	 * @return - Lista de grupos cadastrados.
	 */
	
	@RequestMapping(path = "/listGroups", method = RequestMethod.GET)
	public ResponseEntity<RestResponse<ListGroupsResponse>> listGroups() {

		List<GroupDTO> groups = groupService.listAll();
		
		ListGroupsResponse result = new ListGroupsResponse(groups);
		
		RestResponse<ListGroupsResponse> restResponse = 
				new RestResponse<ListGroupsResponse>(RestResponseCodes.OK.getCode(), RestResponseCodes.OK.getDescription(), result);
		
		return new ResponseEntity<RestResponse<ListGroupsResponse>>(restResponse, HttpStatus.OK);
		
	}
	
}
