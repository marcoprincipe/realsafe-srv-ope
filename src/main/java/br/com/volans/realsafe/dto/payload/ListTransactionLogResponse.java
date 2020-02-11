package br.com.volans.realsafe.dto.payload;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.volans.realsafe.dto.TransactionLogDTO;

/**
 * DTO para retorno do serviço de lista de logs de transações.
 * 
 * @author Volans Informática Ltda.
 */

public class ListTransactionLogResponse implements Serializable {

	/**
	 * Declaração da serial version.
	 */
	
	private static final long serialVersionUID = 2666870613154304793L;

	/**
	 * Declaração das variáveis membro.
	 */

	private List<TransactionLogDTO> transactionLogs;
	
	/**
	 * Construtor default da classe.
	 */
	
	public ListTransactionLogResponse() {
		transactionLogs = new ArrayList<TransactionLogDTO>();
	}

	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param statements - Lista dos logs de transações a serem retornados.
	 */
	
	public ListTransactionLogResponse(List<TransactionLogDTO> transactionLogs) {
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
	public void seTransactionLogs(List<TransactionLogDTO> transactionLogs) {
		this.transactionLogs = transactionLogs;
	}

	@Override
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		
		builder.append("ListTransactionLogResponse [transactionLogs=");
		builder.append(transactionLogs);
		builder.append(']');
		
		return builder.toString();
		
	}
	
}
