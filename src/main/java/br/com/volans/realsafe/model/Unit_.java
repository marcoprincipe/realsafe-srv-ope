package br.com.volans.realsafe.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * Classe para armazenamento dos dados do metamodel de uma unidade.
 * 
 * @author Volans Informática Ltda
 */

@StaticMetamodel(Unit.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class Unit_ {
	
	/**
	 * Declaração das variáveis membro.
	 */

	public static volatile SingularAttribute<Unit, BigDecimal> unitId;
	public static volatile SingularAttribute<Unit, String> unitName;
	public static volatile SingularAttribute<Unit, String> businessName;
	public static volatile SingularAttribute<Unit, String> contactName;
	public static volatile SingularAttribute<Unit, String> address;
	public static volatile SingularAttribute<Unit, String> addressNumber;
	public static volatile SingularAttribute<Unit, String> addressComplement;
	public static volatile SingularAttribute<Unit, String> addressNeighborhood;
	public static volatile SingularAttribute<Unit, String> cityName;
	public static volatile SingularAttribute<Unit, String> stateCode;
	public static volatile SingularAttribute<Unit, String> countryCode;
	public static volatile SingularAttribute<Unit, Integer> zipCode;
	public static volatile SingularAttribute<Unit, Integer> phoneCountryCode;
	public static volatile SingularAttribute<Unit, Integer> phoneAreaCode;
	public static volatile SingularAttribute<Unit, Integer> phoneNumber;
	public static volatile SingularAttribute<Unit, Integer> celCountryCode;
	public static volatile SingularAttribute<Unit, Integer> celAreaCode;
	public static volatile SingularAttribute<Unit, Integer> celNumber;
	public static volatile SingularAttribute<Unit, Integer> stateRegistration;
	public static volatile SingularAttribute<Unit, Integer> municipalRegistration;
	public static volatile SingularAttribute<Unit, String> siteAddress;
	public static volatile SingularAttribute<Unit, String> emailAddress;
	public static volatile SingularAttribute<Unit, String> additionalInfo;
	public static volatile SingularAttribute<Unit, String> status;
	public static volatile SingularAttribute<Unit, Date> creationDate;
	public static volatile SingularAttribute<Unit, BigDecimal> creationUser;
	public static volatile SingularAttribute<Unit, Date> lastUpdate;
	public static volatile SingularAttribute<Unit, BigDecimal> updateUser;
	public static volatile SingularAttribute<Unit, BigDecimal> companyId;
	public static volatile SingularAttribute<Unit, Company> company;

}
