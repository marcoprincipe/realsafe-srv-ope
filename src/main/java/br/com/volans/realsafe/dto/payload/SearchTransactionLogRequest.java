package br.com.volans.realsafe.dto.payload;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DTO para chamada do serviço para pesquisa de logs de transações.
 * 
 * @author Volans Informática Ltda.
 */

public class SearchTransactionLogRequest implements Serializable {

	/**
	 * Declaração da serial version.
	 */
	
	private static final long serialVersionUID = 4028717781399278319L;
	
	/**
	 * Declaração das variáveis membro
	 */
	
	private BigDecimal groupOwnerId;
	private String nsuTerminal;
	private String startDate;
	private String endDate;
	
	/**
	 * @return the groupOwnerId
	 */
	public BigDecimal getGroupOwnerId() {
		return groupOwnerId;
	}
	
	/**
	 * @param groupOwnerId the groupOwnerId to set
	 */
	public void setGroupOwnerId(BigDecimal groupOwnerId) {
		this.groupOwnerId = groupOwnerId;
	}
	
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
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}
	
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	
	/**
	 * @return the endDate
	 */
	public String getEndDate() {
		return endDate;
	}
	
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();
		
		builder.append("SearchTransactionLogRequest [groupOwnerId=");
		builder.append(groupOwnerId);
		builder.append(", nsuTerminal=");
		builder.append(nsuTerminal);
		builder.append(", startDate=");
		builder.append(startDate);
		builder.append(", endDate=");
		builder.append(endDate);
		builder.append("]");
		
		return builder.toString();
		
	}
	
}
