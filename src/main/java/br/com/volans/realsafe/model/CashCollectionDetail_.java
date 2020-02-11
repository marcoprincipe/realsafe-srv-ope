package br.com.volans.realsafe.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * Classe para armazenamento dos dados do metamodel dos detalhes de um recolhimento de numerário.
 * 
 * @author Volans Informática Ltda
 */

@StaticMetamodel(CashCollectionDetail.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public class CashCollectionDetail_ {
	
	/**
	 * Declaração das variáveis membro.
	 */
	
	public static volatile SingularAttribute<CashCollectionDetail, String> nsuTerminal;
	public static volatile SingularAttribute<CashCollectionDetail, String> cashCollectionNsu;
	public static volatile SingularAttribute<CashCollectionDetail, TransactionLog> transactionLog;

}
