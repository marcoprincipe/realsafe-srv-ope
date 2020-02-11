package br.com.volans.realsafe.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * Classe para armazenamento dos dados do metamodel do nsu de um terminal.
 * 
 * @author Volans Informática Ltda
 */

@StaticMetamodel(NSUTerminal.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class NSUTerminal_ {
	
	/**
	 * Declaração das variáveis membro.
	 */
	
	public static volatile SingularAttribute<NSUTerminal, String> terminalId;
	public static volatile SingularAttribute<NSUTerminal, BigDecimal> nsuTerminal;
	public static volatile SingularAttribute<NSUTerminal, Date> currentDateTime;

}
