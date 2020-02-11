package br.com.volans.realsafe.model;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * Classe para armazenamento dos dados do metamodle de perfis.
 * 
 * @author Volans Informática Ltda
 */

@StaticMetamodel(Role.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class Role_ {
	
	/**
	 * Declaração das variáveis membro.
	 */
	
	public static volatile SingularAttribute<Role, Long> roleId;
	public static volatile SingularAttribute<Role, String> initial;
	public static volatile SingularAttribute<Role, String> name;
	public static volatile SingularAttribute<Role, String> status;
	public static volatile SingularAttribute<Role, Date> creationDate;

}
