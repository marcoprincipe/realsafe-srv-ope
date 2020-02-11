package br.com.volans.realsafe.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * Classe para armazenamento dos dados do metamodel de uma funcionalidade de um perfil.
 * 
 * @author Volans Informática Ltda.
 */

@StaticMetamodel(FunctionalityRole.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class FunctionalityRole_ {
	
	/**
	 * Declaração das variáveis membro.
	 */
	
	public static volatile SingularAttribute<FunctionalityRole, FunctionalityRolePK> pk;
	public static volatile SingularAttribute<FunctionalityRole, Role> role;
	public static volatile SingularAttribute<FunctionalityRole, Functionality> functionality;
	public static volatile SingularAttribute<FunctionalityRole, Integer> showOrder;
	public static volatile SingularAttribute<FunctionalityRole, String> accessKey;

}
