package br.com.volans.realsafe.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Classe para armazenamento dos dados do proprietário do grupo.
 * 
 * @author Volans Informática Ltda
 */

@Entity
@Table(name = "tb_group_owner")
public class GroupOwner implements Serializable {

	/**
	 * Declaração da serial version.
	 */
	
	private static final long serialVersionUID = -5954065962053872594L;

	/**
	 * Declaração das variáveis membro.
	 */

	@Id
	@Column(name = "group_owner_id")
	private BigDecimal groupOwnerId;

	@Column(name = "group_owner_name")
	private String groupOwnerName;
	
	@Column(name = "business_name")
	private String businessName;

	@Column(name = "contact_name")
	private String contactName;

	@Column(name = "address")
	private String address;
	
	@Column(name = "address_number")
	private String addressNumber;
	
	@Column(name = "address_complement")
	private String addressComplement;
	
	@Column(name = "address_neighborhood")
	private String addressNeighborhood;
	
	@Column(name = "city_name")
	private String cityName;
	
	@Column(name = "state_code")
	private String stateCode;
	
	@Column(name = "country_code")
	private String countryCode;
	
	@Column(name = "zip_code")
	private Integer zipCode;
	
	@Column(name = "phone_country_code")
	private Integer phoneCountryCode;
	
	@Column(name = "phone_area_code")
	private Integer phoneAreaCode;
	
	@Column(name = "phone_number")
	private Integer phoneNumber;
	
	@Column(name = "cel_country_code")
	private Integer celCountryCode;
	
	@Column(name = "cel_area_code")
	private Integer celAreaCode;
	
	@Column(name = "cel_number")
	private Integer celNumber;
	
	@Column(name = "state_registration")
	private BigDecimal stateRegistration;

	@Column(name = "municipal_registration")
	private BigDecimal municipalRegistration;
	
	@Column(name = "site_address")
	private String siteAddress;
	
	@Column(name = "email_address")
	private String emailAddress;
	
	@Column(name = "additional_info")
	private String additionalInfo;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "creation_date", insertable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;

	@Column(name = "creation_user")
	private BigDecimal creationUser;
	
	@Column(name = "last_update", insertable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdate;

	@Column(name = "update_user")
	private BigDecimal updateUser;

	/**
	 * @return the groupOwnerId
	 */
	public BigDecimal getGroupOwnerId() {
		return groupOwnerId;
	}

	/**
	 * @param groupOwnerId the groupOwnerId to set
	 */
	public void setGroupOwnerId(BigDecimal groupOwnerId) {
		this.groupOwnerId = groupOwnerId;
	}

	/**
	 * @return the groupOwnerName
	 */
	public String getGroupOwnerName() {
		return groupOwnerName;
	}

	/**
	 * @param groupOwnerName the groupOwnerName to set
	 */
	public void setGroupOwnerName(String groupOwnerName) {
		this.groupOwnerName = groupOwnerName;
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
	public BigDecimal getStateRegistration() {
		return stateRegistration;
	}

	/**
	 * @param stateRegistration the stateRegistration to set
	 */
	public void setStateRegistration(BigDecimal stateRegistration) {
		this.stateRegistration = stateRegistration;
	}

	/**
	 * @return the municipalRegistration
	 */
	public BigDecimal getMunicipalRegistration() {
		return municipalRegistration;
	}

	/**
	 * @param municipalRegistration the municipalRegistration to set
	 */
	public void setMunicipalRegistration(BigDecimal municipalRegistration) {
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

	@Override
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		
		builder.append("GroupOwner [groupOwnerId=");
		builder.append(groupOwnerId);
		builder.append(", groupOwnerName=");
		builder.append(groupOwnerName);
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
		builder.append("]");
	
		return builder.toString();

	}
	
}
