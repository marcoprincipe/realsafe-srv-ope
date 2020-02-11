package br.com.volans.realsafe.model;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * Classe para armazenamento dos dados do metamodle de funcionalidades.
 * 
 * @author Volans Informática Ltda
 */

@StaticMetamodel(Functionality.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class Functionality_ {
	
	/**
	 * Declaração das variáveis membro.
	 */
	
	public static volatile SingularAttribute<Functionality, Long> functionalityId;
	public static volatile SingularAttribute<Functionality, String> name;
	public static volatile SingularAttribute<Functionality, String> description;
	public static volatile SingularAttribute<Functionality, String> route;
	public static volatile SingularAttribute<Functionality, String> status;
	public static volatile SingularAttribute<Functionality, Date> creationDate;
	public static volatile SingularAttribute<Functionality, Long> parentId;

}
