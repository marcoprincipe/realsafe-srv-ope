package br.com.volans.realsafe.dto.payload;

import java.io.Serializable;

import br.com.volans.realsafe.dto.ClosingDetailDTO;

/**
 * DTO para retorno do serviço de detalhes de fechamento.
 * 
 * @author Volans Informática Ltda.
 */

public class GetClosingDetailResponse implements Serializable {

	/**
	 * Declaração da serial version.
	 */
	
	private static final long serialVersionUID = 5306887110376257032L;

	/**
	 * Declaração das variáveis membro.
	 */
	
	private ClosingDetailDTO closingDetail;
	
	/**
	 * Construtor default da classe.
	 */
	
	public GetClosingDetailResponse() {
		closingDetail = new ClosingDetailDTO();
	}

	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param closingDetail - Detalhes do fechamento a serem retornados.
	 */
	
	public GetClosingDetailResponse(ClosingDetailDTO closingDetail) {
		this.closingDetail = closingDetail;
	}

	/**
	 * @return the closingDetail
	 */
	public ClosingDetailDTO getClosingDetail() {
		return closingDetail;
	}

	/**
	 * @param closingDetail the closingDetail to set
	 */
	public void setClosingDetail(ClosingDetailDTO closingDetail) {
		this.closingDetail = closingDetail;
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();
		
		builder.append("GetClosingDetailResponse [closingDetail=");
		builder.append(closingDetail);
		builder.append("]");
		
		return builder.toString();
		
	}

}
