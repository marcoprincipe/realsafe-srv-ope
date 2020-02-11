package br.com.volans.realsafe.model;

import java.math.BigDecimal;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * Classe para armazenamento dos dados do metamodel da chave primária de um usuário.
 * 
 * @author Volans Informática Ltda
 */

@StaticMetamodel(UserPK.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class UserPK_ {
	
	/**
	 * Declaração das variáveis membro.
	 */

	public static volatile SingularAttribute<UserPK, BigDecimal> groupOwnerId;
	public static volatile SingularAttribute<UserPK, BigDecimal> userId;

}
