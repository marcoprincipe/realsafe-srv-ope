package br.com.volans.realsafe.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * Classe para armazenamento dos dados do metamodel da chave primária de uma funcionalidade de um perfil.
 * 
 * @author Volans Informática Ltda.
 */

@StaticMetamodel(FunctionalityRolePK.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class FunctionalityRolePK_ {
	
	/**
	 * Declaração das variáveis membro.
	 */
	
	public static volatile SingularAttribute<FunctionalityRolePK, Long> roleId;
	public static volatile SingularAttribute<FunctionalityRolePK, Long> functionalityId;

}
