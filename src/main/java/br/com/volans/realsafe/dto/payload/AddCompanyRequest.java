package br.com.volans.realsafe.dto.payload;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * DTO para chamada da inclusão da empresa.
 * 
 * @author Volans Informática Ltda
 */
public class AddCompanyRequest implements Serializable{

	/**
	 * Declaração da serial version
	 */
	
	private static final long serialVersionUID = -6795777082091742441L;

	/**
	 * Declaração das variáveis membro
	 */
	
	private BigDecimal companyId;
	private String companyName;
	private String businessName;
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
	private String siteAddress;
	private String emailAddress;
	private String additionalInfo;
	private String status;
	private Date creationDate;
	private BigDecimal groupId;
	
	
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
	 * @return the groupId
	 */
	public BigDecimal getGroupId() {
		return groupId;
	}
	/**
	 * @param groupId the groupId to set
	 */
	public void setGroupId(BigDecimal groupId) {
		this.groupId = groupId;
	}	
	
	@Override
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		
		builder.append("AddCompanyRequest [companyId=");
		builder.append(companyId);
		builder.append(", companyName=");
		builder.append(companyName);
		builder.append(", businessName=");
		builder.append(businessName);
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
		builder.append(", groupId=");
		builder.append(groupId);
		builder.append("]");

		return builder.toString();
		
	}
		
}
