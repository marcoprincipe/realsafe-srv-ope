package br.com.volans.realsafe.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * Classe para armazenamento dos dados do metamodel do proprietário do grupo.
 * 
 * @author Volans Informática Ltda
 */

@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GroupOwner.class)
public abstract class GroupOwner_ {
	
	/**
	 * Declaração das variáveis membro.
	 */
	
	public static volatile SingularAttribute<GroupOwner, BigDecimal> groupOwnerId;
	public static volatile SingularAttribute<GroupOwner, String> groupOwnerName;
	public static volatile SingularAttribute<GroupOwner, String> businessName;
	public static volatile SingularAttribute<GroupOwner, String> contactName;
	public static volatile SingularAttribute<GroupOwner, String> address;
	public static volatile SingularAttribute<GroupOwner, String> addressNumber;
	public static volatile SingularAttribute<GroupOwner, String> addressComplement;
	public static volatile SingularAttribute<GroupOwner, String> addressNeighborhood;
	public static volatile SingularAttribute<GroupOwner, String> cityName;
	public static volatile SingularAttribute<GroupOwner, String> stateCode;
	public static volatile SingularAttribute<GroupOwner, String> countryCode;
	public static volatile SingularAttribute<GroupOwner, Integer> zipCode;
	public static volatile SingularAttribute<GroupOwner, Integer> phoneCountryCode;
	public static volatile SingularAttribute<GroupOwner, Integer> phoneAreaCode;
	public static volatile SingularAttribute<GroupOwner, Integer> phoneNumber;
	public static volatile SingularAttribute<GroupOwner, Integer> celCountryCode;
	public static volatile SingularAttribute<GroupOwner, Integer> celAreaCode;
	public static volatile SingularAttribute<GroupOwner, Integer> celNumber;
	public static volatile SingularAttribute<GroupOwner, BigDecimal> stateRegistration;
	public static volatile SingularAttribute<GroupOwner, BigDecimal> municipalRegistration;
	public static volatile SingularAttribute<GroupOwner, String> siteAddress;
	public static volatile SingularAttribute<GroupOwner, String> emailAddress;
	public static volatile SingularAttribute<GroupOwner, String> additionalInfo;
	public static volatile SingularAttribute<GroupOwner, String> status;
	public static volatile SingularAttribute<GroupOwner, Date> creationDate;
	public static volatile SingularAttribute<GroupOwner, BigDecimal> creationUser;
	public static volatile SingularAttribute<GroupOwner, Date> lastUpdate;
	public static volatile SingularAttribute<GroupOwner, BigDecimal> updateUser;

}
