package br.com.volans.realsafe.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * Classe para armazenamento dos dados do metamodle de logs de evento.
 * 
 * @author Volans Informática Ltda
 */

@StaticMetamodel(EventLog.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public class EventLog_ {
	
	/**
	 * Declaração das variáveis membro.
	 */
	
	public static volatile SingularAttribute<EventLog, String> nsuEvent;
	public static volatile SingularAttribute<EventLog, String> terminalId;
	public static volatile SingularAttribute<EventLog, BigDecimal> userId;
	public static volatile SingularAttribute<EventLog, Date> dateTime;
	public static volatile SingularAttribute<EventLog, Long> eventId;
	public static volatile SingularAttribute<EventLog, String> eventName;
	public static volatile SingularAttribute<EventLog, String> nsuTransaction;
	public static volatile SingularAttribute<EventLog, Long> resultCode;
	public static volatile SingularAttribute<EventLog, String> message;
	public static volatile SingularAttribute<EventLog, String> extraData;
	public static volatile SingularAttribute<EventLog, String> status;

}
