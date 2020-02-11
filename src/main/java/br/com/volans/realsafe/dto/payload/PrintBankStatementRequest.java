package br.com.volans.realsafe.dto.payload;

import java.io.Serializable;
import java.util.List;

import br.com.volans.realsafe.dto.TransactionLogDTO;

/**
 * DTO para chamada do serviço de impressão do extrato de transações.
 * 
 * @author Volans Informática Ltda.
 */

public class PrintBankStatementRequest implements Serializable {

	/**
	 * Declaração da serial version.
	 */

	private static final long serialVersionUID = 5933276859041239100L;

	/**
	 * Declaração das variáveis membro.
	 */
	
	private String companyName;
	private String unitName;
	private String userName;
	private String terminalId;
	private List<TransactionLogDTO> transactionLogs;
	
	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}
	
	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	/**
	 * @return the unitName
	 */
	public String getUnitName() {
		return unitName;
	}
	
	/**
	 * @param unitName the unitName to set
	 */
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	/**
	 * @return the terminalId
	 */
	public String getTerminalId() {
		return terminalId;
	}
	
	/**
	 * @param terminalId the terminalId to set
	 */
	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
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
		
		builder.append("PrintBankStatementRequest [companyName=");
		builder.append(companyName);
		builder.append(", unitName=");
		builder.append(unitName);
		builder.append(", userName=");
		builder.append(userName);
		builder.append(", terminalId=");
		builder.append(terminalId);
		builder.append(", transactionLogs=");
		builder.append(transactionLogs);
		builder.append("]");
		
		return builder.toString();
		
	}
	
}
