package org.argentinaprograma.tema9.models;

import java.util.List;
import java.util.ArrayList;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.Singular;


public class Persona {
	@Setter @Getter @NonNull
	private String nombre;
}
