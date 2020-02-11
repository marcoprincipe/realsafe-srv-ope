package br.com.volans.realsafe.dto.payload;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * Classe para armazenamento dos dados do resultado da pesquisa de empresas
 * 
 * @author Volans Informática Ltda.
 */

public class SearchCompaniesResponse implements Serializable {

	/**
	 * Declaração da serial version.
	 */
	
	private static final long serialVersionUID = 7952761811431949291L;

	private BigDecimal companyId;
	private String companyName;
	private String contactName;
	private Integer phoneNumber;
	
	/**
	 *  Construtor default da classe
	 * @param list 
	 */
	public SearchCompaniesResponse(List<SearchCompaniesResponse> list) {
		
	}
	
	/**
	 * Construtor completo
	 * @param companyId
	 * @param companyName
	 * @param contactName
	 * @param phoneNumber
	 */
	public SearchCompaniesResponse(BigDecimal companyId, String companyName, String contactName, Integer phoneNumber) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.contactName = contactName;
		this.phoneNumber = phoneNumber;
	}
	
	/**
	 * @return the companyId
	 */
	public BigDecimal getCompanyId() {
		return companyId;
	}

	/**
	 * @param companyId the companyId to set
	 */
	public void setCompanyId(BigDecimal companyId) {
		this.companyId = companyId;
	}

	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}
	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	/**
	 * @return the contactName
	 */
	public String getContactName() {
		return contactName;
	}
	/**
	 * @param contactName the contactName to set
	 */
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	/**
	 * @return the phoneNumber
	 */
	public Integer getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	/**
	 * (non-Javadoc)
	 * @see java.lang.Object#toString
	 */
	@Override
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		
		builder.append("SearchCompaniesResponse [companyId=");
		builder.append(companyId);
		builder.append(", companyName=");
		builder.append(companyName);
		builder.append(", contactName=");
		builder.append(contactName);
		builder.append(", phoneNumber=");
		builder.append(phoneNumber);
		builder.append("]");
		
		return builder.toString();
	}	

	
}
