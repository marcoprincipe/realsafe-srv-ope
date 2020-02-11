package br.com.volans.realsafe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.volans.realsafe.dto.GroupOwnerDTO;
import br.com.volans.realsafe.dto.payload.FindGroupOwnerByIdRequest;
import br.com.volans.realsafe.dto.payload.FindGroupOwnerByIdResponse;
import br.com.volans.realsafe.dto.payload.GetGroupOwnerResponse;
import br.com.volans.realsafe.dto.payload.ListGroupOwnerResponse;
import br.com.volans.realsafe.enums.RestResponseCodes;
import br.com.volans.realsafe.rest.RestResponse;
import br.com.volans.realsafe.service.GroupOwnerService;

/**
 * Controller dos serviços de proprietário de grupos.
 * 
 * @author Volans Informática Ltda.
 */

@RestController
@RequestMapping("/api/v1/group-owner")
public class GroupOwnerController {

	/**
	 * Declaração das variáveis membro.
	 */
	
	private GroupOwnerService groupOwnerService;
	
	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param groupOwnerService - Instância do serviço de proprietário de grupos.
	 */
	
	@Autowired
	public GroupOwnerController(GroupOwnerService groupOwnerService) {
		this.groupOwnerService = groupOwnerService;
	}

	/**
	 * Retorna os dados do proprietário de grupos local.
	 *  
	 * @return - Dados do proprietário de grupos.
	 */
	
	@RequestMapping(path = "/getLocalGroupOwner", method = RequestMethod.GET)
	public ResponseEntity<RestResponse<GetGroupOwnerResponse>> getLocalGroupOwner() {

		GroupOwnerDTO groupOwner = groupOwnerService.getLocalGroupOwner();
		
		GetGroupOwnerResponse result = new GetGroupOwnerResponse(groupOwner);
		
		RestResponse<GetGroupOwnerResponse> restResponse = 
				new RestResponse<GetGroupOwnerResponse>(RestResponseCodes.OK.getCode(), RestResponseCodes.OK.getDescription(), result);
		
		return new ResponseEntity<RestResponse<GetGroupOwnerResponse>>(restResponse, HttpStatus.OK);
		
	}
	
	/**
	 * Retorna a lista de proprietarios de grupos cadastrados.
	 *  
	 * @return - Lista de proprietarios de grupos cadastrados.
	 */
	
	@RequestMapping(path = "/listGroupOwner", method = RequestMethod.GET)
	public ResponseEntity<RestResponse<ListGroupOwnerResponse>> listGroupOwner() {

		List<GroupOwnerDTO> groupOwner = groupOwnerService.listAll();
		
		ListGroupOwnerResponse result = new ListGroupOwnerResponse(groupOwner);
		
		RestResponse<ListGroupOwnerResponse> restResponse = 
				new RestResponse<ListGroupOwnerResponse>(RestResponseCodes.OK.getCode(), RestResponseCodes.OK.getDescription(), result);
		
		return new ResponseEntity<RestResponse<ListGroupOwnerResponse>>(restResponse, HttpStatus.OK);
		
	}

	/**
	 * Retorna a proprietario de grupo a partir do id informado.
	 *  
	 * @return - O proprietario de grupo pesquisado.
	 */
	
	@RequestMapping(path = "/findGroupOwnerById", method = RequestMethod.POST)
	public ResponseEntity<RestResponse<FindGroupOwnerByIdResponse>> findGroupOwnerById(@RequestBody FindGroupOwnerByIdRequest request) {

		GroupOwnerDTO groupOwner = groupOwnerService.findById(request.getGroupOwnerId());
		
		FindGroupOwnerByIdResponse result = new FindGroupOwnerByIdResponse(groupOwner);
		
		RestResponse<FindGroupOwnerByIdResponse> restResponse = 
				new RestResponse<FindGroupOwnerByIdResponse>(RestResponseCodes.OK.getCode(), RestResponseCodes.OK.getDescription(), result);
		
		return new ResponseEntity<RestResponse<FindGroupOwnerByIdResponse>>(restResponse, HttpStatus.OK);
		
	}
	
	
	
}
