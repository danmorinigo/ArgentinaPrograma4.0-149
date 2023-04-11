package org.argentinaprograma.tema9.models;


import java.time.LocalDate;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Persona {
	
	private String nombre;
	private String apellido;
	private LocalDate fechaNacimiento;

}
