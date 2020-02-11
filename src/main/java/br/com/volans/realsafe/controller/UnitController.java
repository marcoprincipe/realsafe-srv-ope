package br.com.volans.realsafe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.volans.realsafe.dto.UnitDTO;
import br.com.volans.realsafe.dto.payload.ListUnitsByCompanyIdRequest;
import br.com.volans.realsafe.dto.payload.ListUnitsByCompanyIdResponse;
import br.com.volans.realsafe.enums.RestResponseCodes;
import br.com.volans.realsafe.rest.RestResponse;
import br.com.volans.realsafe.service.UnitService;

/**
 * Controller dos serviços de unidades.
 * 
 * @author Volans Informática Ltda
 */

@RestController
@RequestMapping("/api/v1/unit")
public class UnitController {

	/**
	 * Declaração das variáveis membro
	 */

	private UnitService unitService;
	
	/**
	 * Construtor alternativo da classe
	 * 
	 * @param unitService - Instância do serviço de unidades.
	 */
	
	@Autowired
	public UnitController(UnitService unitService) {
		this.unitService = unitService;
	}
	
	/**
	 * Retorna a lista de unidades cadastradas para a empresa.
	 * 
	 * @param request - Dados para pesquisa das unidades.
	 * 
	 * @return - Lista de unidades cadastradas para a empresa.
	 */
	
	@RequestMapping(path = "/listUnitsByCompanyId", method = RequestMethod.POST)
	public ResponseEntity<RestResponse<ListUnitsByCompanyIdResponse>> listUnitsByCompanyId(@RequestBody ListUnitsByCompanyIdRequest request) {
		
		List<UnitDTO> units = unitService.listByCompanyId(request.getCompanyId());
		
		ListUnitsByCompanyIdResponse result = new ListUnitsByCompanyIdResponse(units);
		
		RestResponse<ListUnitsByCompanyIdResponse> restResponse = 
				new RestResponse<ListUnitsByCompanyIdResponse>(RestResponseCodes.OK.getCode(), RestResponseCodes.OK.getDescription(), result);
		
		return new ResponseEntity<RestResponse<ListUnitsByCompanyIdResponse>>(restResponse, HttpStatus.OK);
		
	}

}
