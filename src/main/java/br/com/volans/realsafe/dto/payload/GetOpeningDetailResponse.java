package br.com.volans.realsafe.dto.payload;

import java.io.Serializable;

import br.com.volans.realsafe.dto.OpeningDetailDTO;

/**
 * DTO para retorno do serviço de detalhes de abertura.
 * 
 * @author Volans Informática Ltda.
 */

public class GetOpeningDetailResponse implements Serializable {

	/**
	 * Declaração da serial version.
	 */
	
	private static final long serialVersionUID = 8240466855247897072L;

	/**
	 * Declaração das variáveis membro.
	 */
	
	private OpeningDetailDTO openingDetail;
	
	/**
	 * Construtor default da classe.
	 */
	
	public GetOpeningDetailResponse() {
		openingDetail = new OpeningDetailDTO();
	}

	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param openingDetail - Detalhes da abertura a serem retornados.
	 */
	
	public GetOpeningDetailResponse(OpeningDetailDTO openingDetail) {
		this.openingDetail = openingDetail;
	}

	/**
	 * @return the openingDetail
	 */
	public OpeningDetailDTO getOpeningDetail() {
		return openingDetail;
	}

	/**
	 * @param openingDetail the openingDetail to set
	 */
	public void setOpeningDetail(OpeningDetailDTO openingDetail) {
		this.openingDetail = openingDetail;
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();
		
		builder.append("GetOpeningDetailResponse [openingDetail=");
		builder.append(openingDetail);
		builder.append("]");
		
		return builder.toString();
		
	}
	
}
