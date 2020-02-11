package br.com.volans.realsafe.dto.payload;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.volans.realsafe.dto.TransactionLogDTO;

/**
 * DTO para retorno do serviço de lista de recolhimento de numerário.
 * 
 * @author Volans Informática Ltda.
 */

public class ListCashCollectionDetailsResponse implements Serializable {

	/**
	 * Declaração da serial version.
	 */
	
	private static final long serialVersionUID = 2223555265258055205L;

	/**
	 * Declaração das variáveis membro.
	 */

	private List<TransactionLogDTO> transactionLogs;
	
	/**
	 * Construtor default da classe.
	 */
	
	public ListCashCollectionDetailsResponse() {
		transactionLogs = new ArrayList<TransactionLogDTO>();
	}

	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param transactionLogs - Lista dos detalhes do recolhimento de numerário.
	 */
	
	public ListCashCollectionDetailsResponse(List<TransactionLogDTO> transactionLogs) {
		this.transactionLogs = transactionLogs;
	}

	/**
	 * @return the transactionLogs
	 */
	public List<TransactionLogDTO> getTransactionLogs() {
		return transactionLogs;
	}

	/**
	 * @param transactionLogs the transactionLogs to set
	 */
	public void setTransactionLogs(List<TransactionLogDTO> transactionLogs) {
		this.transactionLogs = transactionLogs;
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();
		
		builder.append("ListCashCollectionDetailsResponse [transactionLogs=");
		builder.append(transactionLogs);
		builder.append("]");
		
		return builder.toString();
		
	}
	
}
