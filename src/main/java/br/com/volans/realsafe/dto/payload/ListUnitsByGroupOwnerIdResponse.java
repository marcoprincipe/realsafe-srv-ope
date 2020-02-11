package br.com.volans.realsafe.dto.payload;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.volans.realsafe.dto.UnitDTO;

/**
 * DTO para retorno do serviço de lista de unidades de proprietário de grupos.
 * 
 * @author Volans Informática Ltda
 */

public class ListUnitsByGroupOwnerIdResponse implements Serializable {

	/**
	 * Declaração da serial version.
	 */

	private static final long serialVersionUID = -5187214278074289476L;

	/**
	 * Declaração das variáveis membro.
	 */

	private List<UnitDTO> units;
	
	/**
	 * Construtor default da classe.
	 */
	
	public ListUnitsByGroupOwnerIdResponse() {
		units = new ArrayList<UnitDTO>();
	}

	/**
	 * Construtor alternativo da classe.
	 * 
	 * @param units - Lista das unidades a serem retornados.
	 */
	
	public ListUnitsByGroupOwnerIdResponse(List<UnitDTO> units) {
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
		
		builder.append("ListUnitsByGroupOwnerIdResponse [units=");
		builder.append(units);
		builder.append(']');
		
		return builder.toString();
		
	}
	
}
