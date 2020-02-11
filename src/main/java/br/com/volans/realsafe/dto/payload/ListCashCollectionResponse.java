package br.com.volans.realsafe.dto.payload;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.volans.realsafe.dto.DepositDetailDTO;

/**
 * DTO para retorno do serviço de lista de recolhimento de numerário.
 * 
 * @author Volans Informática Ltda.
 */

public class ListCashCollectionResponse implements Serializable {

	/**
	 * Declaração da serial version.
	 */
	
	private static final long serialVersionUID = -4816304679862670216L;
	
	/**
	 * Declaração das variáveis membro.
	 */
	
	private List<DepositDetailDTO> bankNotes;
	
	/**
	 * Construtor default da classe.
	 */
	
	public ListCashCollectionResponse() {
		bankNotes = new ArrayList<DepositDetailDTO>();
	}

	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param bankNotes - Lista dos detalhes de depósito a serem retornados.
	 */
	
	public ListCashCollectionResponse(List<DepositDetailDTO> bankNotes) {
		this.bankNotes = bankNotes;
	}

	/**
	 * @return the bankNotes
	 */
	public List<DepositDetailDTO> getBankNotes() {
		return bankNotes;
	}

	/**
	 * @param bankNotes the bankNotes to set
	 */
	public void setBankNotes(List<DepositDetailDTO> bankNotes) {
		this.bankNotes = bankNotes;
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();
		
		builder.append("ListCashCollectionResponse [bankNotes=");
		builder.append(bankNotes);
		builder.append("]");
		
		return builder.toString();
		
	}
	
}
