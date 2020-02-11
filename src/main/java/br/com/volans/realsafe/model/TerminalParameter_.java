package br.com.volans.realsafe.model;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * Classe para armazenamento dos dados do metamodel dos parâmetros do terminal.
 * 
 * @author Volans Informática Ltda.
 */

@StaticMetamodel(TerminalParameter.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public class TerminalParameter_ {
	
	/**
	 * Declaração das variáveis membro.
	 */
	
	public static volatile SingularAttribute<TerminalParameter, String> parameterId;
	public static volatile SingularAttribute<TerminalParameter, String> parameterValue;
	public static volatile SingularAttribute<TerminalParameter, String> description;
	public static volatile SingularAttribute<TerminalParameter, String> status;
	public static volatile SingularAttribute<TerminalParameter, Date> creationDate;

}
