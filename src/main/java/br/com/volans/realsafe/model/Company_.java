package br.com.volans.realsafe.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * Classe para armazenamento dos dados do metamodel de uma empresa.
 * 
 * @author Volans Informática Ltda
 */

@StaticMetamodel(Company.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class Company_ {
	
	/**
	 * Declaração das variáveis membro.
	 */
	
	public static volatile SingularAttribute<Company, BigDecimal> companyId;
	public static volatile SingularAttribute<Company, String> companyName;
	public static volatile SingularAttribute<Company, String> businessName;
	public static volatile SingularAttribute<Company, String> contactName;
	public static volatile SingularAttribute<Company, String> address;
	public static volatile SingularAttribute<Company, String> addressNumber;
	public static volatile SingularAttribute<Company, String> addressComplement;
	public static volatile SingularAttribute<Company, String> addressNeighborhood;
	public static volatile SingularAttribute<Company, String> cityName;
	public static volatile SingularAttribute<Company, String> stateCode;
	public static volatile SingularAttribute<Company, String> countryCode;
	public static volatile SingularAttribute<Company, Integer> zipCode;
	public static volatile SingularAttribute<Company, Integer> phoneCountryCode;
	public static volatile SingularAttribute<Company, Integer> phoneAreaCode;
	public static volatile SingularAttribute<Company, Integer> phoneNumber;
	public static volatile SingularAttribute<Company, Integer> celCountryCode;
	public static volatile SingularAttribute<Company, Integer> celAreaCode;
	public static volatile SingularAttribute<Company, Integer> celNumber;
	public static volatile SingularAttribute<Company, Integer> stateRegistration;
	public static volatile SingularAttribute<Company, Integer> municipalRegistration;
	public static volatile SingularAttribute<Company, String> siteAddress;
	public static volatile SingularAttribute<Company, String> emailAddress;
	public static volatile SingularAttribute<Company, String> additionalInfo;
	public static volatile SingularAttribute<Company, String> status;
	public static volatile SingularAttribute<Company, Date> creationDate;
	public static volatile SingularAttribute<Company, BigDecimal> creationUser;
	public static volatile SingularAttribute<Company, Date> lastUpdate;
	public static volatile SingularAttribute<Company, BigDecimal> updateUser;
	public static volatile SingularAttribute<Company, BigDecimal> groupId;
	public static volatile SingularAttribute<Company, Group> group;
	
}
