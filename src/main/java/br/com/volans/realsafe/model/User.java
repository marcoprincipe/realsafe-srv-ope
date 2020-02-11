package br.com.volans.realsafe.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Classe para armazenamento dos dados de um usuário.
 * 
 * @author Volans Informática Ltda
 */

@Entity
@Table(name = "tb_user")
public class User implements Serializable {

	/**
	 * Declaração da serial version.
	 */
	
	private static final long serialVersionUID = -4441196515306706900L;
	
	/**
	 * Declaração das variáveis membro.
	 */

	@EmbeddedId
	private UserPK pk;

	@Column(name = "user_code")
	private String userCode;

	@Column(name = "password")
	private String password;

	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "general_registration")
	private BigDecimal generalRegistration;

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
	
	@Column(name = "email_address")
	private String emailAddress;
	
	@Column(name = "additional_info")
	private String additionalInfo;
	
	@Column(name = "is_blocked")
	private String isBlocked;
	
	@Column(name = "login_retries")
	private Integer loginRetries;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "creation_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;
	
	/**
	 * Construtor default da classe.
	 */

	public User() {
		pk = new UserPK();
	}

	/**
	 * @return the userPK
	 */
	public UserPK getPk() {
		return pk;
	}

	/**
	 * @param userPK the userPK to set
	 */
	public void setPk(UserPK userPK) {
		this.pk = userPK;
	}

	/**
	 * @return the userCode
	 */
	public String getUserCode() {
		return userCode;
	}

	/**
	 * @param userCode the userCode to set
	 */
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the generalRegistration
	 */
	public BigDecimal getGeneralRegistration() {
		return generalRegistration;
	}

	/**
	 * @param generalRegistration the generalRegistration to set
	 */
	public void setGeneralRegistration(BigDecimal generalRegistration) {
		this.generalRegistration = generalRegistration;
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
	 * @return the isBlocked
	 */
	public String getIsBlocked() {
		return isBlocked;
	}

	/**
	 * @param isBlocked the isBlocked to set
	 */
	public void setIsBlocked(String isBlocked) {
		this.isBlocked = isBlocked;
	}

	/**
	 * @return the loginRetries
	 */
	public Integer getLoginRetries() {
		return loginRetries;
	}

	/**
	 * @param loginRetries the loginRetries to set
	 */
	public void setLoginRetries(Integer loginRetries) {
		this.loginRetries = loginRetries;
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

	@Override
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		
		builder.append("User [userPK=");
		builder.append(pk);
		builder.append(", userCode=");
		builder.append(userCode);
		builder.append(", password=");
		builder.append(password);
		builder.append(", userName=");
		builder.append(userName);
		builder.append(", generalRegistration=");
		builder.append(generalRegistration);
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
		builder.append(", emailAddress=");
		builder.append(emailAddress);
		builder.append(", additionalInfo=");
		builder.append(additionalInfo);
		builder.append(", isBlocked=");
		builder.append(isBlocked);
		builder.append(", loginRetries=");
		builder.append(loginRetries);
		builder.append(", status=");
		builder.append(status);
		builder.append(", creationDate=");
		builder.append(creationDate);
		builder.append("]");

		return builder.toString();
		
	}
	
}
