package org.argentinaprograma.entrega3.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Equipo {
	private String nombre;
	private String descripcion;
	
	public Equipo(String nombre) {
		this.nombre = nombre;
		this.descripcion = "Sin Descripcion";
	}
	
	public boolean esEl(Equipo equipo1) {
		if(this.getNombre().equals(equipo1.getNombre())) {
			return true;
		}
		return false;
	}
}
