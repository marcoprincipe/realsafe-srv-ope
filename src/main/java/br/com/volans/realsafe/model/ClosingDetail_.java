package br.com.volans.realsafe.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * Classe para armazenamento dos dados do metamodel dos detalhes de um depósito.
 * 
 * @author Volans Informática Ltda
 */

@StaticMetamodel(ClosingDetail.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class ClosingDetail_ {
	
	/**
	 * Declaração das variáveis membro.
	 */
	
	public static volatile SingularAttribute<ClosingDetail, String> nsuTerminal;
	public static volatile SingularAttribute<ClosingDetail, Date> closingDateTime;
	public static volatile SingularAttribute<ClosingDetail, Integer> bankNotesInSafe;
	public static volatile SingularAttribute<ClosingDetail, BigDecimal> amountInSafe;
	public static volatile SingularAttribute<ClosingDetail, Date> lastOpeningDateTime;
	public static volatile SingularAttribute<ClosingDetail, Integer> lastOpeningBanknotes;
	public static volatile SingularAttribute<ClosingDetail, BigDecimal> lastOpeningAmount;

}
