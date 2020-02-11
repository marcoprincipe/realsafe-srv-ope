package br.com.volans.realsafe.service.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.volans.realsafe.dao.CompanyDAO;
import br.com.volans.realsafe.dao.FunctionalityDAO;
import br.com.volans.realsafe.dao.FunctionalityRoleDAO;
import br.com.volans.realsafe.dao.GroupDAO;
import br.com.volans.realsafe.dao.GroupOwnerDAO;
import br.com.volans.realsafe.dao.RoleDAO;
import br.com.volans.realsafe.dao.TerminalDAO;
import br.com.volans.realsafe.dao.UnitDAO;
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
import br.com.volans.realsafe.dto.payload.FindTerminalByIdResponse;
import br.com.volans.realsafe.dto.payload.ListCompanyByGroupOwnerIdRequest;
import br.com.volans.realsafe.dto.payload.ListCompanyByGroupOwnerIdResponse;
import br.com.volans.realsafe.dto.payload.ListFunctionalitiesResponse;
import br.com.volans.realsafe.dto.payload.ListFunctionalitiesRolesResponse;
import br.com.volans.realsafe.dto.payload.ListGroupByGroupOwnerIdRequest;
import br.com.volans.realsafe.dto.payload.ListGroupByGroupOwnerIdResponse;
import br.com.volans.realsafe.dto.payload.ListRolesResponse;
import br.com.volans.realsafe.dto.payload.ListUnitsByGroupOwnerIdRequest;
import br.com.volans.realsafe.dto.payload.ListUnitsByGroupOwnerIdResponse;
import br.com.volans.realsafe.enums.MessageKeys;
import br.com.volans.realsafe.exception.ServiceLayerException;
import br.com.volans.realsafe.rest.RestResponse;
import br.com.volans.realsafe.service.AbstractService;
import br.com.volans.realsafe.service.InitializerService;

/**
 * Implementação da interface dos serviços de inicialização do terminal.
 * 
 * @author Volans Informática Ltda.
 */

@Service
public class InitializerServiceImpl extends AbstractService implements InitializerService {
	
	/**
	 * Declaração das constantes da classe.
	 */
	
	private static final String FIND_GROUP_OWNER_BY_TERMINAL_ID = "http://localhost:8090/realsafe-adm/api/v1/group-owner/findGroupOwnerByTerminalId";
	private static final String LIST_GROUPS_BY_GROUP_OWNER_ID = "http://localhost:8090/realsafe-adm/api/v1/group/listGroupsByGroupOwnerId";
	private static final String LIST_COMPANIES_BY_GROUP_OWNER_ID = "http://localhost:8090/realsafe-adm/api/v1/company/listCompaniesByGroupOwnerId";
	private static final String LIST_UNITS_BY_GROUP_OWNER_ID = "http://localhost:8090/realsafe-adm/api/v1/unit/listUnitsByGroupOwnerId";
	private static final String FIND_TERMINAL_BY_ID = "http://localhost:8090/realsafe-adm/api/v1/terminal/findTerminalById";
	private static final String LIST_FUNCTIONALITIES = "http://localhost:8090/realsafe-adm/api/v1/functionality-ope/listFunctionalitiesOpe";
	private static final String LIST_ROLES = "http://localhost:8090/realsafe-adm/api/v1/role-ope/listRolesOpe";
	private static final String LIST_FUNCTIONALITIES_ROLES = "http://localhost:8090/realsafe-adm/api/v1/functionality-role-ope/listFunctionalitiesRolesOpe";
	
	/**
	 * Declaração das variáveis membro.
	 */
	
	private RestTemplate restTemplate;
	private GroupOwnerDAO groupOwnerDAO;
	private GroupDAO groupDAO;
	private CompanyDAO companyDAO;
	private UnitDAO unitDAO;
	private FunctionalityDAO functionalityDAO;
	private RoleDAO roleDAO;
	private FunctionalityRoleDAO functionalityRoleDAO;
	private TerminalDAO terminalDAO;
	
	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param restTemplate - Instância do template para acesso aos serviços rest.
	 * @param groupOwnerDAO - Instância do DAO de proprietários de grupos.
	 * @param groupDAO - Instância do DAO de grupos.
	 * @param companyDAO - Instância do DAO de empresas.
	 * @param unitDAO - Instância do DAO de unidades.
	 * @param functionalityDAO - Instância do DAO de funcionalidades.
	 * @param roleDAO - Instância do DAO de perfis de usuário.
	 * @param functionalityRoleDAO - Instância do DAO de funcionalidades X perfis.
	 * @param terminalDAO - Instância do DAO de terminais.
	 */
	
	@Autowired
	public InitializerServiceImpl(RestTemplate restTemplate, GroupOwnerDAO groupOwnerDAO,
			GroupDAO groupDAO, CompanyDAO companyDAO, UnitDAO unitDAO, FunctionalityDAO functionalityDAO,
			RoleDAO roleDAO, FunctionalityRoleDAO functionalityRoleDAO, TerminalDAO terminalDAO) {
		this.restTemplate = restTemplate;
		this.groupOwnerDAO = groupOwnerDAO;
		this.groupDAO = groupDAO;
		this.companyDAO = companyDAO;
		this.unitDAO = unitDAO;
		this.functionalityDAO = functionalityDAO;
		this.roleDAO = roleDAO;
		this.functionalityRoleDAO = functionalityRoleDAO;
		this.terminalDAO = terminalDAO;
	}
	
	/**
	 * Efetua o download dos dados da tabela de proprietário de grupos.
	 * 
	 * @param terminalId - Identificador do terminal.
	 * 
	 * @return - Dados do proprietário de grupos do terminal.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	@Override
	@Transactional
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public GroupOwnerDTO downloadGroupOwner(String terminalId) throws ServiceLayerException {
		
		GroupOwnerDTO result = null;
		
		if (terminalId == null || terminalId.trim().isEmpty()) {
			throw new ServiceLayerException(getMessage(MessageKeys.TERMINAL_CODE_NOT_INFORMED.getKey()));
		}
				
		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE);
		
		FindGroupOwnerByTerminalIdIdRequest request = new FindGroupOwnerByTerminalIdIdRequest();
		request.setTerminalId(terminalId);
		
		HttpEntity<FindGroupOwnerByTerminalIdIdRequest> entity = new HttpEntity<FindGroupOwnerByTerminalIdIdRequest>(request, headers);
	
		ResponseEntity<RestResponse> response = restTemplate.postForEntity(FIND_GROUP_OWNER_BY_TERMINAL_ID, entity, RestResponse.class);

		try {
		
			RestResponse<GroupOwnerDTO> restResponse = (RestResponse<GroupOwnerDTO>) convertToObject(response.getBody(), RestResponse.class);

			result = (GroupOwnerDTO) convertToObject(restResponse.getData(), GroupOwnerDTO.class);
			
			GroupOwnerDTO groupOwnerDb = groupOwnerDAO.findById(result.getGroupOwnerId());
			
			if (groupOwnerDb != null) {
				return groupOwnerDb;
			}
			
			groupOwnerDAO.create(result);
			
		}
		catch (Exception ex) {
			
			throw new ServiceLayerException(ex);
			
		}
		
		return result;

	}
	
	/**
	 * Efetua o download dos dados da tabela de grupos.
	 * 
	 * @param request - Dados para pesquisa dos grupos.
	 * 
	 * @return - Lista com os dados dos grupos.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	@Override
	@Transactional
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<GroupDTO> downloadGroups(BigDecimal groupOwnerId) throws ServiceLayerException {
		
		List<GroupDTO> result = null;

		try {
			
			if (groupOwnerId == null) {
				throw new ServiceLayerException(getMessage(MessageKeys.GROUP_OWNER_CODE_NOT_INFORMED.getKey()));
			}
			
			if (groupOwnerId.compareTo(BigDecimal.ZERO) <= 0) {
				throw new ServiceLayerException(getMessage(MessageKeys.INVALID_GROUP_OWNER_CODE.getKey()));
			}
			
			HttpHeaders headers = new HttpHeaders();
			headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE);
			
			ListGroupByGroupOwnerIdRequest request = new ListGroupByGroupOwnerIdRequest();
			request.setGroupOwnerId(groupOwnerId);
			
			HttpEntity<ListGroupByGroupOwnerIdRequest> entity = new HttpEntity<ListGroupByGroupOwnerIdRequest>(request, headers);
		
			ResponseEntity<RestResponse> responseEntity = restTemplate.postForEntity(LIST_GROUPS_BY_GROUP_OWNER_ID, entity, RestResponse.class);
		
			RestResponse<ListGroupByGroupOwnerIdResponse> restResponse = (RestResponse<ListGroupByGroupOwnerIdResponse>) convertToObject(responseEntity.getBody(), RestResponse.class);
			
			ListGroupByGroupOwnerIdResponse data = convertToObject(restResponse.getData(), ListGroupByGroupOwnerIdResponse.class);
			
			result = data.getGroups();
			
			for (GroupDTO group : result) {
				
				GroupDTO groupDb = groupDAO.findById(group.getGroupId());
				
				if (groupDb != null) {
					continue;
				}
				
				groupDAO.create(group);
				
			}
			
		}
		catch (Exception ex) {
			
			throw new ServiceLayerException(ex);
			
		}
		
		return result;
		
	}
	
	/**
	 * Efetua o download dos dados da tabela de empresas.
	 * 
	 * @param groupOwnerId - Identificador do proprietário de empresas.
	 * 
	 * @return - Lista com os dados das empresas.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	@Override
	@Transactional
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<CompanyDTO> downloadCompanies(BigDecimal groupOwnerId) throws ServiceLayerException {
		
		List<CompanyDTO> result = null;

		try {
			
			if (groupOwnerId == null) {
				throw new ServiceLayerException(getMessage(MessageKeys.GROUP_OWNER_CODE_NOT_INFORMED.getKey()));
			}
			
			if (groupOwnerId.compareTo(BigDecimal.ZERO) <= 0) {
				throw new ServiceLayerException(getMessage(MessageKeys.INVALID_GROUP_OWNER_CODE.getKey()));
			}
			
			HttpHeaders headers = new HttpHeaders();
			headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE);
			
			ListCompanyByGroupOwnerIdRequest request = new ListCompanyByGroupOwnerIdRequest();
			request.setGroupOwnerId(groupOwnerId);
			
			HttpEntity<ListCompanyByGroupOwnerIdRequest> entity = new HttpEntity<ListCompanyByGroupOwnerIdRequest>(request, headers);
		
			ResponseEntity<RestResponse> responseEntity = restTemplate.postForEntity(LIST_COMPANIES_BY_GROUP_OWNER_ID, entity, RestResponse.class);
		
			RestResponse<ListCompanyByGroupOwnerIdResponse> restResponse = (RestResponse<ListCompanyByGroupOwnerIdResponse>) convertToObject(responseEntity.getBody(), RestResponse.class);
			
			ListCompanyByGroupOwnerIdResponse data = convertToObject(restResponse.getData(), ListCompanyByGroupOwnerIdResponse.class);
			
			result = data.getCompanies();
			
			for (CompanyDTO company : result) {
				
				CompanyDTO companyDb = companyDAO.findById(company.getCompanyId());
				
				if (companyDb != null) {
					continue;
				}
				
				companyDAO.create(company);
				
			}
			
		}
		catch (Exception ex) {
			
			throw new ServiceLayerException(ex);
			
		}
		
		return result;
		
	}
	
	/**
	 * Efetua o download dos dados da tabela de unidades.
	 * 
	 * @param groupOwnerId - Identificador do proprietário de empresas.
	 * 
	 * @return - Lista com os dados das unidades.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	@Override
	@Transactional
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<UnitDTO> downloadUnits(BigDecimal groupOwnerId) throws ServiceLayerException {
		
		List<UnitDTO> result = null;

		try {
			
			if (groupOwnerId == null) {
				throw new ServiceLayerException(getMessage(MessageKeys.GROUP_OWNER_CODE_NOT_INFORMED.getKey()));
			}
			
			if (groupOwnerId.compareTo(BigDecimal.ZERO) <= 0) {
				throw new ServiceLayerException(getMessage(MessageKeys.INVALID_GROUP_OWNER_CODE.getKey()));
			}
			
			HttpHeaders headers = new HttpHeaders();
			headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE);
			
			ListUnitsByGroupOwnerIdRequest request = new ListUnitsByGroupOwnerIdRequest();
			request.setGroupOwnerId(groupOwnerId);
			
			HttpEntity<ListUnitsByGroupOwnerIdRequest> entity = new HttpEntity<ListUnitsByGroupOwnerIdRequest>(request, headers);
		
			ResponseEntity<RestResponse> responseEntity = restTemplate.postForEntity(LIST_UNITS_BY_GROUP_OWNER_ID, entity, RestResponse.class);
		
			RestResponse<ListUnitsByGroupOwnerIdResponse> restResponse = (RestResponse<ListUnitsByGroupOwnerIdResponse>) convertToObject(responseEntity.getBody(), RestResponse.class);
			
			ListUnitsByGroupOwnerIdResponse data = convertToObject(restResponse.getData(), ListUnitsByGroupOwnerIdResponse.class);
			
			result = data.getUnits();
			
			for (UnitDTO unit : result) {
				
				UnitDTO unitDb = unitDAO.findById(unit.getUnitId());
				
				if (unitDb != null) {
					continue;
				}
				
				unitDAO.create(unit);
				
			}
			
		}
		catch (Exception ex) {
			
			throw new ServiceLayerException(ex);
			
		}
		
		return result;
		
	}
	
	/**
	 * Efetua o download dos dados da tabela de terminais.
	 * 
	 * @param terminalId - Identificador do terminal.
	 * 
	 * @return - Dados do terminal.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	@Override
	@Transactional
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public TerminalDTO downloadTerminal(String terminalId) throws ServiceLayerException {
		
		TerminalDTO result = null;
		
		if (terminalId == null || terminalId.trim().isEmpty()) {
			throw new ServiceLayerException(getMessage(MessageKeys.TERMINAL_CODE_NOT_INFORMED.getKey()));
		}
				
		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE);
		
		FindTerminalByIdRequest request = new FindTerminalByIdRequest();
		request.setTerminalId(terminalId);
		
		HttpEntity<FindTerminalByIdRequest> entity = new HttpEntity<FindTerminalByIdRequest>(request, headers);
	
		ResponseEntity<RestResponse> responseEntity = restTemplate.postForEntity(FIND_TERMINAL_BY_ID, entity, RestResponse.class);

		try {
		
			RestResponse<FindTerminalByIdResponse> restResponse = (RestResponse<FindTerminalByIdResponse>) convertToObject(responseEntity.getBody(), RestResponse.class);

			FindTerminalByIdResponse response = (FindTerminalByIdResponse) convertToObject(restResponse.getData(), FindTerminalByIdResponse.class);
			
			result = response.getTerminal();
			
			TerminalDTO terminalDb = terminalDAO.findById(result.getTerminalId());
			
			if (terminalDb != null) {
				return terminalDb;
			}
			
			terminalDAO.crate(result);
			
		}
		catch (Exception ex) {
			
			throw new ServiceLayerException(ex);
			
		}
		
		return result;

	}
	
	/**
	 * Efetua o download dos dados da tabela de funcionalidades.
	 * 
	 * @return - Lista com os dados das funcionalidades.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	@Override
	@Transactional
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<FunctionalityDTO> downloadFunctionalities() throws ServiceLayerException {
		
		List<FunctionalityDTO> result = null;

		try {
			
			HttpHeaders headers = new HttpHeaders();
			headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE);
		
			ResponseEntity<RestResponse> responseEntity = restTemplate.getForEntity(LIST_FUNCTIONALITIES, RestResponse.class, headers);
		
			RestResponse<ListFunctionalitiesResponse> restResponse = (RestResponse<ListFunctionalitiesResponse>) convertToObject(responseEntity.getBody(), RestResponse.class);
			
			ListFunctionalitiesResponse data = convertToObject(restResponse.getData(), ListFunctionalitiesResponse.class);
			
			result = data.getFunctionalities();
			
			for (FunctionalityDTO functionality : result) {
				
				FunctionalityDTO functionalityDb = functionalityDAO.findById(functionality.getFunctionalityId());
				
				if (functionalityDb != null) {
					continue;
				}
				
				functionalityDAO.create(functionality);
				
			}
			
		}
		catch (Exception ex) {
			
			throw new ServiceLayerException(ex);
			
		}
		
		return result;
		
	}
	
	/**
	 * Efetua o download dos dados da tabela de perfis de usuários.
	 * 
	 * @return - Lista com os dados dos perfis de usuário.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	@Override
	@Transactional
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<RoleDTO> downloadRoles() throws ServiceLayerException {
		
		List<RoleDTO> result = null;

		try {
			
			HttpHeaders headers = new HttpHeaders();
			headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE);
		
			ResponseEntity<RestResponse> responseEntity = restTemplate.getForEntity(LIST_ROLES, RestResponse.class, headers);
		
			RestResponse<ListRolesResponse> restResponse = (RestResponse<ListRolesResponse>) convertToObject(responseEntity.getBody(), RestResponse.class);
			
			ListRolesResponse data = convertToObject(restResponse.getData(), ListRolesResponse.class);
			
			result = data.getRoles();
			
			for (RoleDTO role : result) {
				
				RoleDTO roleDb = roleDAO.findById(role.getRoleId());
				
				if (roleDb != null) {
					continue;
				}
				
				roleDAO.create(role);
				
			}
			
		}
		catch (Exception ex) {
			
			throw new ServiceLayerException(ex);
			
		}
		
		return result;
		
	}
	
	/**
	 * Efetua o download dos dados da tabela de funcionalidades X perfis de usuários.
	 * 
	 * @return - Lista com os dados das funcionalides X perfis de usuário.
	 * 
	 * @throws ServiceLayerException - Exceção da camada de negócio.
	 */
	
	@Override
	@Transactional
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<FunctionalityRoleDTO> downloadFunctionalityRoles() throws ServiceLayerException {
		
		List<FunctionalityRoleDTO> result = null;

		try {
			
			HttpHeaders headers = new HttpHeaders();
			headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE);
		
			ResponseEntity<RestResponse> responseEntity = restTemplate.getForEntity(LIST_FUNCTIONALITIES_ROLES, RestResponse.class, headers);
		
			RestResponse<ListFunctionalitiesRolesResponse> restResponse = (RestResponse<ListFunctionalitiesRolesResponse>) convertToObject(responseEntity.getBody(), RestResponse.class);
			
			ListFunctionalitiesRolesResponse data = convertToObject(restResponse.getData(), ListFunctionalitiesRolesResponse.class);
			
			result = data.getFunctionalitiesRoes();
			
			for (FunctionalityRoleDTO functionalityRole : result) {
				
				FunctionalityRoleDTO functionalityRoleDb = functionalityRoleDAO.findById(functionalityRole.getRoleId(), functionalityRole.getFunctionalityId());
				
				if (functionalityRoleDb != null) {
					continue;
				}
				
				functionalityRoleDAO.create(functionalityRole);
				
			}
			
		}
		catch (Exception ex) {
			
			throw new ServiceLayerException(ex);
			
		}
		
		return result;
		
	}

	/**
	 * Efetua a conversão dos dados informados para o objeto da classe informada.
	 * 
	 * @param value - Dados a serem convertidos.
	 * @param clazz - Classe de destino para conversão.
	 * 
	 * @return - Objeto com os dados convertidos.
	 * 
	 * @throws Exception 
	 */
	
	@SuppressWarnings("unchecked")
	private <T> T convertToObject(Object value, Class<?> clazz) throws Exception {
		
		ObjectMapper mapper = new ObjectMapper();
		
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		String json = mapper.writeValueAsString(value);
		
		T result = (T) mapper.readValue(json, clazz);
		
		return result;
		
	}
	
}
