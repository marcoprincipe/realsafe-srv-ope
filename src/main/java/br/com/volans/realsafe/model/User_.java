package br.com.volans.realsafe.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * Classe para armazenamento dos dados do metamodel de um usuários.
 * 
 * @author Volans Informática Ltda
 */

@StaticMetamodel(User.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class User_ {
	
	/**
	 * Declaração das variáveis membro.
	 */
	
	public static volatile SingularAttribute<User, UserPK> pk;
	public static volatile SingularAttribute<User, String> userCode;
	public static volatile SingularAttribute<User, String> password;
	public static volatile SingularAttribute<User, String> userName;
	public static volatile SingularAttribute<User, BigDecimal> generalRegistration;
	public static volatile SingularAttribute<User, String> address;
	public static volatile SingularAttribute<User, String> addressNumber;
	public static volatile SingularAttribute<User, String> addressComplement;
	public static volatile SingularAttribute<User, String> addressNeighborhood;
	public static volatile SingularAttribute<User, String> cityName;
	public static volatile SingularAttribute<User, String> stateCode;
	public static volatile SingularAttribute<User, String> countryCode;
	public static volatile SingularAttribute<User, Integer> zipCode;
	public static volatile SingularAttribute<User, Integer> phoneCountryCode;
	public static volatile SingularAttribute<User, Integer> phoneAreaCode;
	public static volatile SingularAttribute<User, Integer> phoneNumber;
	public static volatile SingularAttribute<User, String> emailAddress;
	public static volatile SingularAttribute<User, String> additionalInfo;
	public static volatile SingularAttribute<User, String> isBlocked;
	public static volatile SingularAttribute<User, Integer> loginRetries;
	public static volatile SingularAttribute<User, String> status;
	public static volatile SingularAttribute<User, Date> creationDate;

}
