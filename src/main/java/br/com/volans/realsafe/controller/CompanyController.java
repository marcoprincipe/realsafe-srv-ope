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
import br.com.volans.realsafe.dto.payload.FindCompanyByIdRequest;
import br.com.volans.realsafe.dto.payload.FindCompanyByIdResponse;
import br.com.volans.realsafe.dto.payload.ListCompaniesResponse;
import br.com.volans.realsafe.dto.payload.SearchCompaniesRequest;
import br.com.volans.realsafe.dto.payload.SearchCompaniesResponse;
import br.com.volans.realsafe.enums.RestResponseCodes;
import br.com.volans.realsafe.rest.RestResponse;
import br.com.volans.realsafe.service.CompanyService;

/**
 * Controller dos serviços de empresas.
 * 
 * @author Volans Informática Ltda
 */

@RestController
@RequestMapping("/api/v1/company")
public class CompanyController {

	/**
	 * Declaração das variáveis membro
	 */
	
	private CompanyService companyService;
	
	/**
	 * Construtor alternativo da classe
	 * 
	 * @param companyService - Instância do serviço de empresas.
	 */
	
	@Autowired
	public CompanyController(CompanyService companyService) {
		this.companyService = companyService;
	}

	/**
	 * Retorna a empresa a partir do id informado.
	 *  
	 * @return - A empresa pesquisada.
	 */
	
	@RequestMapping(path = "/findCompanyById", method = RequestMethod.POST)
	public ResponseEntity<RestResponse<FindCompanyByIdResponse>> findCompanyById(@RequestBody FindCompanyByIdRequest request) {

		CompanyDTO company = companyService.findById(request.getCompanyId());
		
		FindCompanyByIdResponse result = new FindCompanyByIdResponse(company);
		
		RestResponse<FindCompanyByIdResponse> restResponse = 
				new RestResponse<FindCompanyByIdResponse>(RestResponseCodes.OK.getCode(), RestResponseCodes.OK.getDescription(), result);
		
		return new ResponseEntity<RestResponse<FindCompanyByIdResponse>>(restResponse, HttpStatus.OK);
		
	}

	/**
	 * Retorna a lista de empresas cadastradas.
	 *  
	 * @return - Lista de empresas cadastradas.
	 */
	
	@RequestMapping(path = "/listCompanies", method = RequestMethod.GET)
	public ResponseEntity<RestResponse<ListCompaniesResponse>> listCompanies() {

		List<CompanyDTO> companies = companyService.listAll();
		
		ListCompaniesResponse result = new ListCompaniesResponse(companies);
		
		RestResponse<ListCompaniesResponse> restResponse = 
				new RestResponse<ListCompaniesResponse>(RestResponseCodes.OK.getCode(), RestResponseCodes.OK.getDescription(), result);
		
		return new ResponseEntity<RestResponse<ListCompaniesResponse>>(restResponse, HttpStatus.OK);
		
	}

	/**
	 * Criar a empresa a partir dos dados informados.
	 *  
	 * @return - A empresa cadastrada.
	 */
	
	@RequestMapping(path = "/create", method = RequestMethod.POST)
	public ResponseEntity<RestResponse<CompanyDTO>> create(@RequestBody CompanyDTO request) {

		CompanyDTO result = companyService.create(request);
		
		RestResponse<CompanyDTO> restResponse = 
				new RestResponse<CompanyDTO>(RestResponseCodes.OK.getCode(), RestResponseCodes.OK.getDescription(), result);
		
		return new ResponseEntity<RestResponse<CompanyDTO>>(restResponse, HttpStatus.OK);
			
	}
	
	/**
	 * Atualizar a empresa a partir dos dados informados.
	 *  
	 * @return - A empresa atualizada.
	 */
	
	@RequestMapping(path = "/update", method = RequestMethod.POST)
	public ResponseEntity<RestResponse<CompanyDTO>> update(@RequestBody CompanyDTO request) {

		CompanyDTO result = companyService.update(request);
		
		RestResponse<CompanyDTO> restResponse = 
				new RestResponse<CompanyDTO>(RestResponseCodes.OK.getCode(), RestResponseCodes.OK.getDescription(), result);
		
		return new ResponseEntity<RestResponse<CompanyDTO>>(restResponse, HttpStatus.OK);
			
	}

	/**
	 * Excluir a empresa a partir dos dados informados.
	 *  
	 * @return - A empresa atualizada.
	 */
	
	@RequestMapping(path = "/remove", method = RequestMethod.POST)
	public ResponseEntity<RestResponse<CompanyDTO>> remove(@RequestBody CompanyDTO request) {

		CompanyDTO result = companyService.remove(request);
		
		RestResponse<CompanyDTO> restResponse = 
				new RestResponse<CompanyDTO>(RestResponseCodes.OK.getCode(), RestResponseCodes.OK.getDescription(), result);
		
		return new ResponseEntity<RestResponse<CompanyDTO>>(restResponse, HttpStatus.OK);
			
	}	

	/**

	* Seleciona as empresas a partir dos dados informados

	* @return

	*/

	@RequestMapping(value = "/searchCompanies", method = RequestMethod.POST)
	public ResponseEntity<RestResponse<List<SearchCompaniesResponse>>> searchCompanies(@RequestBody SearchCompaniesRequest request) {

		List<SearchCompaniesResponse> result = companyService.searchCompanies(request);
		
		RestResponse<List<SearchCompaniesResponse>> restResponse = 
				new RestResponse<List<SearchCompaniesResponse>>(RestResponseCodes.OK.getCode(), RestResponseCodes.OK.getDescription(), result);
		
		return new ResponseEntity<RestResponse<List<SearchCompaniesResponse>>>(restResponse, HttpStatus.OK);		
		
			
	}	
	
	
}
