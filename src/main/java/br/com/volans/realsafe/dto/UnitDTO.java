package br.com.volans.realsafe.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * DTO para armazenamento dos dados de uma unidade.
 * 
 * @author Volans Informática Ltda.
 */

public class UnitDTO implements Serializable {

	/**
	 * Declaração da serial version.
	 */
	
	private static final long serialVersionUID = -2943075849307270001L;
	
	/**
	 * Declaração das variáveis membro.
	 */
	
	/**
	 * Declaração das variáveis membro.
	 */

	private BigDecimal unitId;
	private String unitName;
	private String businessName;
	private String contactName;
	private String address;
	private String addressNumber;
	private String addressComplement;
	private String addressNeighborhood;
	private String cityName;
	private String stateCode;
	private String countryCode;
	private Integer zipCode;
	private Integer phoneCountryCode;
	private Integer phoneAreaCode;
	private Integer phoneNumber;
	private Integer celCountryCode;
	private Integer celAreaCode;
	private Integer celNumber;
	private Integer stateRegistration;
	private Integer municipalRegistration;
	private String siteAddress;
	private String emailAddress;
	private String additionalInfo;
	private String status;
	private Date creationDate;
	private BigDecimal creationUser;
	private Date lastUpdate;
	private BigDecimal updateUser;
	private BigDecimal companyId;
	
	/**
	 * Construtor default da classe.
	 */
	
	public UnitDTO() {
		super();
	}

	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param unitId
	 * @param unitName
	 * @param businessName
	 * @param contactName
	 * @param address
	 * @param addressNumber
	 * @param addressComplement
	 * @param addressNeighborhood
	 * @param cityName
	 * @param stateCode
	 * @param countryCode
	 * @param zipCode
	 * @param phoneCountryCode
	 * @param phoneAreaCode
	 * @param phoneNumber
	 * @param celCountryCode
	 * @param celAreaCode
	 * @param celNumber
	 * @param stateRegistration
	 * @param municipalRegistration
	 * @param siteAddress
	 * @param emailAddress
	 * @param additionalInfo
	 * @param status
	 * @param creationDate
	 * @param creationUser
	 * @param lastUpdate
	 * @param updateUser
	 * @param companyId
	 */
	
	public UnitDTO(BigDecimal unitId, String unitName, String businessName, String contactName, String address,
			String addressNumber, String addressComplement, String addressNeighborhood, String cityName,
			String stateCode, String countryCode, Integer zipCode, Integer phoneCountryCode, Integer phoneAreaCode,
			Integer phoneNumber, Integer celCountryCode, Integer celAreaCode, Integer celNumber,
			Integer stateRegistration, Integer municipalRegistration, String siteAddress, String emailAddress,
			String additionalInfo, String status, Date creationDate, BigDecimal creationUser, Date lastUpdate,
			BigDecimal updateUser, BigDecimal companyId) {
		this.unitId = unitId;
		this.unitName = unitName;
		this.businessName = businessName;
		this.contactName = contactName;
		this.address = address;
		this.addressNumber = addressNumber;
		this.addressComplement = addressComplement;
		this.addressNeighborhood = addressNeighborhood;
		this.cityName = cityName;
		this.stateCode = stateCode;
		this.countryCode = countryCode;
		this.zipCode = zipCode;
		this.phoneCountryCode = phoneCountryCode;
		this.phoneAreaCode = phoneAreaCode;
		this.phoneNumber = phoneNumber;
		this.celCountryCode = celCountryCode;
		this.celAreaCode = celAreaCode;
		this.celNumber = celNumber;
		this.stateRegistration = stateRegistration;
		this.municipalRegistration = municipalRegistration;
		this.siteAddress = siteAddress;
		this.emailAddress = emailAddress;
		this.additionalInfo = additionalInfo;
		this.status = status;
		this.creationDate = creationDate;
		this.creationUser = creationUser;
		this.lastUpdate = lastUpdate;
		this.updateUser = updateUser;
		this.companyId = companyId;
	}

	/**
	 * @return the unitId
	 */
	public BigDecimal getUnitId() {
		return unitId;
	}

	/**
	 * @param unitId the unitId to set
	 */
	public void setUnitId(BigDecimal unitId) {
		this.unitId = unitId;
	}

	/**
	 * @return the unitName
	 */
	public String getUnitName() {
		return unitName;
	}

	/**
	 * @param unitName the unitName to set
	 */
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	/**
	 * @return the businessName
	 */
	public String getBusinessName() {
		return businessName;
	}

	/**
	 * @param businessName the businessName to set
	 */
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
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
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the addressNumber
	 */
	public String getAddressNumber() {
		return addressNumber;
	}

	/**
	 * @param addressNumber the addressNumber to set
	 */
	public void setAddressNumber(String addressNumber) {
		this.addressNumber = addressNumber;
	}

	/**
	 * @return the addressComplement
	 */
	public String getAddressComplement() {
		return addressComplement;
	}

	/**
	 * @param addressComplement the addressComplement to set
	 */
	public void setAddressComplement(String addressComplement) {
		this.addressComplement = addressComplement;
	}

	/**
	 * @return the addressNeighborhood
	 */
	public String getAddressNeighborhood() {
		return addressNeighborhood;
	}

	/**
	 * @param addressNeighborhood the addressNeighborhood to set
	 */
	public void setAddressNeighborhood(String addressNeighborhood) {
		this.addressNeighborhood = addressNeighborhood;
	}

	/**
	 * @return the cityName
	 */
	public String getCityName() {
		return cityName;
	}

	/**
	 * @param cityName the cityName to set
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	/**
	 * @return the stateCode
	 */
	public String getStateCode() {
		return stateCode;
	}

	/**
	 * @param stateCode the stateCode to set
	 */
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	/**
	 * @return the countryCode
	 */
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * @param countryCode the countryCode to set
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	/**
	 * @return the zipCode
	 */
	public Integer getZipCode() {
		return zipCode;
	}

	/**
	 * @param zipCode the zipCode to set
	 */
	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * @return the phoneCountryCode
	 */
	public Integer getPhoneCountryCode() {
		return phoneCountryCode;
	}

	/**
	 * @param phoneCountryCode the phoneCountryCode to set
	 */
	public void setPhoneCountryCode(Integer phoneCountryCode) {
		this.phoneCountryCode = phoneCountryCode;
	}

	/**
	 * @return the phoneAreaCode
	 */
	public Integer getPhoneAreaCode() {
		return phoneAreaCode;
	}

	/**
	 * @param phoneAreaCode the phoneAreaCode to set
	 */
	public void setPhoneAreaCode(Integer phoneAreaCode) {
		this.phoneAreaCode = phoneAreaCode;
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
	 * @return the celCountryCode
	 */
	public Integer getCelCountryCode() {
		return celCountryCode;
	}

	/**
	 * @param celCountryCode the celCountryCode to set
	 */
	public void setCelCountryCode(Integer celCountryCode) {
		this.celCountryCode = celCountryCode;
	}

	/**
	 * @return the celAreaCode
	 */
	public Integer getCelAreaCode() {
		return celAreaCode;
	}

	/**
	 * @param celAreaCode the celAreaCode to set
	 */
	public void setCelAreaCode(Integer celAreaCode) {
		this.celAreaCode = celAreaCode;
	}

	/**
	 * @return the celNumber
	 */
	public Integer getCelNumber() {
		return celNumber;
	}

	/**
	 * @param celNumber the celNumber to set
	 */
	public void setCelNumber(Integer celNumber) {
		this.celNumber = celNumber;
	}

	/**
	 * @return the stateRegistration
	 */
	public Integer getStateRegistration() {
		return stateRegistration;
	}

	/**
	 * @param stateRegistration the stateRegistration to set
	 */
	public void setStateRegistration(Integer stateRegistration) {
		this.stateRegistration = stateRegistration;
	}

	/**
	 * @return the municipalRegistration
	 */
	public Integer getMunicipalRegistration() {
		return municipalRegistration;
	}

	/**
	 * @param municipalRegistration the municipalRegistration to set
	 */
	public void setMunicipalRegistration(Integer municipalRegistration) {
		this.municipalRegistration = municipalRegistration;
	}

	/**
	 * @return the siteAddress
	 */
	public String getSiteAddress() {
		return siteAddress;
	}

	/**
	 * @param siteAddress the siteAddress to set
	 */
	public void setSiteAddress(String siteAddress) {
		this.siteAddress = siteAddress;
	}

	/**
	 * @return the emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * @param emailAddress the emailAddress to set
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	/**
	 * @return the additionalInfo
	 */
	public String getAdditionalInfo() {
		return additionalInfo;
	}

	/**
	 * @param additionalInfo the additionalInfo to set
	 */
	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * @return the creationUser
	 */
	public BigDecimal getCreationUser() {
		return creationUser;
	}

	/**
	 * @param creationUser the creationUser to set
	 */
	public void setCreationUser(BigDecimal creationUser) {
		this.creationUser = creationUser;
	}

	/**
	 * @return the lastUpdate
	 */
	public Date getLastUpdate() {
		return lastUpdate;
	}

	/**
	 * @param lastUpdate the lastUpdate to set
	 */
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	/**
	 * @return the updateUser
	 */
	public BigDecimal getUpdateUser() {
		return updateUser;
	}

	/**
	 * @param updateUser the updateUser to set
	 */
	public void setUpdateUser(BigDecimal updateUser) {
		this.updateUser = updateUser;
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

	@Override
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		
		builder.append("UnitDTO [unitId=");
		builder.append(unitId);
		builder.append(", unitName=");
		builder.append(unitName);
		builder.append(", businessName=");
		builder.append(businessName);
		builder.append(", contactName=");
		builder.append(contactName);
		builder.append(", address=");
		builder.append(address);
		builder.append(", addressNumber=");
		builder.append(addressNumber);
		builder.append(", addressComplement=");
		builder.append(addressComplement);
		builder.append(", addressNeighborhood=");
		builder.append(addressNeighborhood);
		builder.append(", cityName=");
		builder.append(cityName);
		builder.append(", stateCode=");
		builder.append(stateCode);
		builder.append(", countryCode=");
		builder.append(countryCode);
		builder.append(", zipCode=");
		builder.append(zipCode);
		builder.append(", phoneCountryCode=");
		builder.append(phoneCountryCode);
		builder.append(", phoneAreaCode=");
		builder.append(phoneAreaCode);
		builder.append(", phoneNumber=");
		builder.append(phoneNumber);
		builder.append(", celCountryCode=");
		builder.append(celCountryCode);
		builder.append(", celAreaCode=");
		builder.append(celAreaCode);
		builder.append(", celNumber=");
		builder.append(celNumber);
		builder.append(", stateRegistration=");
		builder.append(stateRegistration);
		builder.append(", municipalRegistration=");
		builder.append(municipalRegistration);
		builder.append(", siteAddress=");
		builder.append(siteAddress);
		builder.append(", emailAddress=");
		builder.append(emailAddress);
		builder.append(", additionalInfo=");
		builder.append(additionalInfo);
		builder.append(", status=");
		builder.append(status);
		builder.append(", creationDate=");
		builder.append(creationDate);
		builder.append(", creationUser=");
		builder.append(creationUser);
		builder.append(", lastUpdate=");
		builder.append(lastUpdate);
		builder.append(", updateUser=");
		builder.append(updateUser);
		builder.append(", companyId=");
		builder.append(companyId);
		builder.append("]");
	
		return builder.toString();

	}

}
