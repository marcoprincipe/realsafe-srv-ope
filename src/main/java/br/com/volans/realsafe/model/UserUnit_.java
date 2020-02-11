package br.com.volans.realsafe.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * Classe para armazenamento dos dados do metamodel de uma unidade de usuário.
 * 
 * @author Volans Informática Ltda.
 */

@StaticMetamodel(UserUnit.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class UserUnit_ {
	
	/**
	 * Declaração das variáveis membro.
	 */

	public static volatile SingularAttribute<UserUnit, UserUnitPK> pk;
	public static volatile SingularAttribute<UserUnit, Integer> roleId;
	public static volatile SingularAttribute<UserUnit, Group> group;
	public static volatile SingularAttribute<UserUnit, Company> company;
	public static volatile SingularAttribute<UserUnit, Unit> unit;
	public static volatile SingularAttribute<UserUnit, User> user;
	public static volatile SingularAttribute<UserUnit, Role> role;

}
