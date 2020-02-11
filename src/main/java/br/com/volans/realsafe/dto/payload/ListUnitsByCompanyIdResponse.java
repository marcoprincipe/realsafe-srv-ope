package br.com.volans.realsafe.dto.payload;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.volans.realsafe.dto.UnitDTO;

/**
 * DTO para retorno do serviço de lista de unidades da empresa.
 * 
 * @author Volans Informática Ltda
 */

public class ListUnitsByCompanyIdResponse implements Serializable {

	/**
	 * Declaração da serial version.
	 */
	
	private static final long serialVersionUID = -4121427402412565007L;
	
	/**
	 * Declaração das variáveis membro.
	 */

	private List<UnitDTO> units;
	
	/**
	 * Construtor default da classe.
	 */
	
	public ListUnitsByCompanyIdResponse() {
		units = new ArrayList<UnitDTO>();
	}

	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param units - Lista das unidades a serem retornados.
	 */
	
	public ListUnitsByCompanyIdResponse(List<UnitDTO> units) {
		this.units = units;
	}

	/**
	 * @return the units
	 */
	public List<UnitDTO> getUnits() {
		return units;
	}

	/**
	 * @param units the units to set
	 */
	public void setUnits(List<UnitDTO> units) {
		this.units = units;
	}

	@Override
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		
		builder.append("ListUnitsByCompanyIdResponse [units=");
		builder.append(units);
		builder.append(']');
		
		return builder.toString();
		
	}
	
}
