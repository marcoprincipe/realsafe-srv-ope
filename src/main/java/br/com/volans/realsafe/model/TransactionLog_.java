package br.com.volans.realsafe.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * Classe para armazenamento dos dados do metamodel de um log de transação.
 * 
 * @author Volans Informática Ltda
 */

@StaticMetamodel(TransactionLog.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class TransactionLog_ {
	
	/**
	 * Declaração das variáveis membro.
	 */
	
	public static volatile SingularAttribute<TransactionLog, String> nsuTerminal;
	public static volatile SingularAttribute<TransactionLog, BigDecimal> groupOwnerId;
	public static volatile SingularAttribute<TransactionLog, BigDecimal> unitId;
	public static volatile SingularAttribute<TransactionLog, BigDecimal> userId;
	public static volatile SingularAttribute<TransactionLog, String> terminalId;
	public static volatile SingularAttribute<TransactionLog, Date> accountingDate;
	public static volatile SingularAttribute<TransactionLog, Date> dateTime;
	public static volatile SingularAttribute<TransactionLog, Integer> functionalityId;
	public static volatile SingularAttribute<TransactionLog, Integer> bankNotes;
	public static volatile SingularAttribute<TransactionLog, BigDecimal> amount;
	public static volatile SingularAttribute<TransactionLog, String> status;
	public static volatile SingularAttribute<TransactionLog, String> etvClosing;
	public static volatile SingularAttribute<TransactionLog, Unit> unit;
	public static volatile SingularAttribute<TransactionLog, User> user;
	public static volatile SingularAttribute<TransactionLog, Functionality> functionality;

}
