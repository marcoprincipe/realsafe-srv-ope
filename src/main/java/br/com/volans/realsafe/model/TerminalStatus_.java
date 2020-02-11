package br.com.volans.realsafe.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * Classe para armazenamento dos dados do metamodel da tabela de status de terminais.
 * 
 * @author Volans Informática Ltda.
 */

@StaticMetamodel(TerminalStatus.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public class TerminalStatus_ {
	
	/**
	 * Declaração das variáveis membro.
	 */
	
	public static volatile SingularAttribute<TerminalStatus, String> terminalId;
	public static volatile SingularAttribute<TerminalStatus, Date> accountingDate;
	public static volatile SingularAttribute<TerminalStatus, Integer> banknotesInSafe;
	public static volatile SingularAttribute<TerminalStatus, BigDecimal> amountInSafe;
	public static volatile SingularAttribute<TerminalStatus, Date> lastOpeningDateTime;
	public static volatile SingularAttribute<TerminalStatus, Integer> lastOpeningBanknotes;
	public static volatile SingularAttribute<TerminalStatus, BigDecimal> lastOpeningAmount;
	public static volatile SingularAttribute<TerminalStatus, Date> lastClosingDateTime;
	public static volatile SingularAttribute<TerminalStatus, Integer> lastClosingBanknotes;
	public static volatile SingularAttribute<TerminalStatus, BigDecimal> lastClosingAmount;
	public static volatile SingularAttribute<TerminalStatus, String> etvClosing;
	public static volatile SingularAttribute<TerminalStatus, String> status;
	
}
