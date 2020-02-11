package br.com.volans.realsafe.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * Classe para armazenamento dos dados do metamodel de um grupo.
 * 
 * @author Volans Informática Ltda
 */

@StaticMetamodel(Group.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class Group_ {
	
	/**
	 * Declaração das variáveis membro.
	 */
	
	public static volatile SingularAttribute<Group, BigDecimal> groupId;
	public static volatile SingularAttribute<Group, String> groupName;
	public static volatile SingularAttribute<Group, String> businessName;
	public static volatile SingularAttribute<Group, String> contactName;
	public static volatile SingularAttribute<Group, String> address;
	public static volatile SingularAttribute<Group, String> addressNumber;
	public static volatile SingularAttribute<Group, String> addressComplement;
	public static volatile SingularAttribute<Group, String> addressNeighborhood;
	public static volatile SingularAttribute<Group, String> cityName;
	public static volatile SingularAttribute<Group, String> stateCode;
	public static volatile SingularAttribute<Group, String> countryCode;
	public static volatile SingularAttribute<Group, Integer> zipCode;
	public static volatile SingularAttribute<Group, Integer> phoneCountryCode;
	public static volatile SingularAttribute<Group, Integer> phoneAreaCode;
	public static volatile SingularAttribute<Group, Integer> phoneNumber;
	public static volatile SingularAttribute<Group, Integer> celCountryCode;
	public static volatile SingularAttribute<Group, Integer> celAreaCode;
	public static volatile SingularAttribute<Group, Integer> celNumber;
	public static volatile SingularAttribute<Group, BigDecimal> stateRegistration;
	public static volatile SingularAttribute<Group, BigDecimal> municipalRegistration;
	public static volatile SingularAttribute<Group, String> siteAddress;
	public static volatile SingularAttribute<Group, String> emailAddress;
	public static volatile SingularAttribute<Group, String> additionalInfo;
	public static volatile SingularAttribute<Group, String> status;
	public static volatile SingularAttribute<Group, Date> creationDate;
	public static volatile SingularAttribute<Group, BigDecimal> creationUser;
	public static volatile SingularAttribute<Group, Date> lastUpdate;
	public static volatile SingularAttribute<Group, BigDecimal> updateUser;
	public static volatile SingularAttribute<Group, BigDecimal> groupOwnerId;
	public static volatile SingularAttribute<Group, GroupOwner> groupOwner;

}
