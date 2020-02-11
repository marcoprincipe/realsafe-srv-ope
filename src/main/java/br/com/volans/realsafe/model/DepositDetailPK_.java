package br.com.volans.realsafe.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * Classe para armazenamento dos dados do metamodel da chave primária da tabela de detalhes de depósitos.
 * 
 * @author Volans Informática Ltda.
 */

@StaticMetamodel(DepositDetailPK.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public class DepositDetailPK_ {
	
	/**
	 * Declaração das variáveis membro.
	 */
	
	public static volatile SingularAttribute<DepositDetailPK, String> nsuTerminal;
	public static volatile SingularAttribute<DepositDetailPK, Integer> includeOrder;

}
