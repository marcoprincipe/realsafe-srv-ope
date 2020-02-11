package br.com.volans.realsafe.model;

import java.math.BigDecimal;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * Classe para armazenamento dos dados do metamodel da chave primária de uma unidade de usuário.
 * 
 * @author Volans Informática Ltda
 */

@StaticMetamodel(UserUnitPK.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class UserUnitPK_ {
	
	/**
	 * Declaração das variáveis membro.
	 */

	public static volatile SingularAttribute<UserUnitPK, BigDecimal> groupOwnerId;
	public static volatile SingularAttribute<UserUnitPK, BigDecimal> unitId;
	public static volatile SingularAttribute<UserUnitPK, BigDecimal> userId;

}
