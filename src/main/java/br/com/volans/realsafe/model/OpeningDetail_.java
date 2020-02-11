package br.com.volans.realsafe.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * Classe para armazenamento dos dados do metamodel dos detalhes de abertura de terminal.
 * 
 * @author Volans Informática Ltda
 */

@StaticMetamodel(OpeningDetail.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class OpeningDetail_ {
	
	/**
	 * Declaração das variáveis membro.
	 */
	
	public static volatile SingularAttribute<OpeningDetail, String> nsuTerminal;
	public static volatile SingularAttribute<OpeningDetail, Date> accountingDate;
	public static volatile SingularAttribute<OpeningDetail, Date> openingDateTime;
	public static volatile SingularAttribute<OpeningDetail, Integer> bankNotesInSafe;
	public static volatile SingularAttribute<OpeningDetail, BigDecimal> amountInSafe;
	public static volatile SingularAttribute<OpeningDetail, Date> lastClosingDateTime;
	public static volatile SingularAttribute<OpeningDetail, Integer> lastClosingBanknotes;
	public static volatile SingularAttribute<OpeningDetail, BigDecimal> lastClosingAmount;
	public static volatile SingularAttribute<OpeningDetail, String> etvClosing;

}
