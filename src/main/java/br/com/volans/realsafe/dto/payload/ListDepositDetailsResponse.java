package br.com.volans.realsafe.dto.payload;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.volans.realsafe.dto.DepositDetailDTO;

/**
 * DTO para retorno do serviço de lista de detalhes de depóstiso.
 * 
 * @author Volans Informática Ltda.
 */

public class ListDepositDetailsResponse implements Serializable {

	/**
	 * Declaração da serial version.
	 */
	
	private static final long serialVersionUID = 4850488286178821484L;

	/**
	 * Declaração das variáveis membro.
	 */
	
	private List<DepositDetailDTO> depositDetails;
	
	/**
	 * Construtor default da classe.
	 */
	
	public ListDepositDetailsResponse() {
		depositDetails = new ArrayList<DepositDetailDTO>();
	}

	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param depositDetails - Lista dos detalhes de depósito a serem retornados.
	 */
	
	public ListDepositDetailsResponse(List<DepositDetailDTO> depositDetails) {
		this.depositDetails = depositDetails;
	}

	/**
	 * @return the depositDetails
	 */
	public List<DepositDetailDTO> getDepositDetails() {
		return depositDetails;
	}

	/**
	 * @param depositDetails the depositDetails to set
	 */
	public void setDepositDetails(List<DepositDetailDTO> depositDetails) {
		this.depositDetails = depositDetails;
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();
		
		builder.append("ListDepositDetailsResponse [depositDetails=");
		builder.append(depositDetails);
		builder.append("]");
		
		return builder.toString();
		
	}
	
}
