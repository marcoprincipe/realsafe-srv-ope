package br.com.volans.realsafe.model;

import java.math.BigDecimal;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * Classe para armazenamento dos dados do metamodel dos detalhes de um depósito.
 * 
 * @author Volans Informática Ltda
 */

@StaticMetamodel(DepositDetail.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class DepositDetail_ {
	
	/**
	 * Declaração das variáveis membro.
	 */
	
	public static volatile SingularAttribute<DepositDetail, DepositDetailPK> pk;
	public static volatile SingularAttribute<DepositDetail, Long> quantity;
	public static volatile SingularAttribute<DepositDetail, BigDecimal> amount;
	public static volatile SingularAttribute<DepositDetail, Unit> unit;
	public static volatile SingularAttribute<DepositDetail, User> user;

}
