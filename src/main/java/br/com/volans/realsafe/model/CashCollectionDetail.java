package br.com.volans.realsafe.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Classe para armazenamento dos dados dos detalhes de um depósito.
 * 
 * @author Volans Informática Ltda
 */

@Entity
@Table(name = "tb_cash_collection_detail")
@NamedQueries({
	@NamedQuery(
		name = "insert_cash_collection_details",
		query = "INSERT INTO CashCollectionDetail(nsuTerminal, cashCollectionNsu) " +
				"SELECT tl.nsuTerminal, :nsu FROM TransactionLog tl " +
				"WHERE tl.terminalId = :terminalId AND tl.status = :status AND tl.functionalityId = :functionalityId"
	)
})
public class CashCollectionDetail implements Serializable {

	/**
	 * Declaração da serial version.
	 */

	private static final long serialVersionUID = 2649240074854611643L;
	
	/**
	 * Declaração das variáveis membro.
	 */
	
	@Id
	@Column(name = "nsu_terminal")
	private String nsuTerminal;
	
	@Column(name = "cash_collection_nsu")
	private String cashCollectionNsu;
	
	@ManyToOne()
	@JoinColumn(name = "nsu_terminal", insertable = false, updatable = false)
	private TransactionLog transactionLog;

	/**
	 * @return the nsuTerminal
	 */
	public String getNsuTerminal() {
		return nsuTerminal;
	}

	/**
	 * @param nsuTerminal the nsuTerminal to set
	 */
	public void setNsuTerminal(String nsuTerminal) {
		this.nsuTerminal = nsuTerminal;
	}

	/**
	 * @return the cashCollectionNsu
	 */
	public String getCashCollectionNsu() {
		return cashCollectionNsu;
	}

	/**
	 * @param cashCollectionNsu the cashCollectionNsu to set
	 */
	public void setCashCollectionNsu(String cashCollectionNsu) {
		this.cashCollectionNsu = cashCollectionNsu;
	}
	
	/**
	 * @return the transactionLog
	 */
	public TransactionLog getTransactionLog() {
		return transactionLog;
	}

	/**
	 * @param transactionLog the transactionLog to set
	 */
	public void setTransactionLog(TransactionLog transactionLog) {
		this.transactionLog = transactionLog;
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();
		
		builder.append("CashCollectionDetail [nsuTerminal=");
		builder.append(nsuTerminal);
		builder.append(", cashCollectionNsu=");
		builder.append(cashCollectionNsu);
		builder.append(", transactionLog=");
		builder.append(transactionLog);
		builder.append("]");
		
		return builder.toString();
		
	}
	
}
