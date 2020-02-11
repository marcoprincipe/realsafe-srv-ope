package br.com.volans.realsafe.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * Classe para armazenamento dos dados do metamodel de terminais.
 * 
 * @author Volans Informática Ltda
 */

@StaticMetamodel(Terminal.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public class Terminal_ {
	
	/**
	 * Declaração das variáveis membro.
	 */
	
	public static volatile SingularAttribute<Terminal, String> terminalId;
	public static volatile SingularAttribute<Terminal, String> terminalName;
	public static volatile SingularAttribute<Terminal, String> status;
	public static volatile SingularAttribute<Terminal, Date> creationDate;
	public static volatile SingularAttribute<Terminal, BigDecimal> unitId;

}
