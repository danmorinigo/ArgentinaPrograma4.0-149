package org.argentinaprograma.entrega3.models;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.argentinaprograma.entrega3.exceptions.IdPartidoNoEncontradoException;

import com.opencsv.bean.CsvBindByPosition;

public class Pronostico {

	private static int creadorId = 1;
	
	private int id;
	private String participante;
	private int id_partido;
	private String ganaEquipoA;
	private String empate;
	private String ganaEquipoB;
	private Equipo equipoA;
	private Ronda ronda;
	
	public Pronostico() {
		this.id = creadorId;
		creadorId++;
	}
	
	public Pronostico(String participante, int id_partido,
			String ganaEquipoA, String empate, String ganaEquipoB,
			Ronda ronda)
					throws IdPartidoNoEncontradoException {
		this.id = creadorId;
		this.participante = participante;
		this.id_partido = id_partido;
		this.ganaEquipoA = ganaEquipoA;
		this.empate = empate;
		this.ganaEquipoB = ganaEquipoB;
		this.ronda = ronda;
		this.equipoA = this.ronda.partido(id_partido).getEquipo1();
		
		creadorId++;
	}
	
	public int getId() {
		return this.id;
	}
	
	public int puntos() {
		try {
			if(ronda.partido(id_partido).resultado(equipoA).equals(resultadoEquipoA())) {
				return 1;
			}
		} catch (IdPartidoNoEncontradoException e) {
			System.out.print("Error, partido con id: " + id_partido + " no existe. | ");
		}
		return 0;
	}

	public int idDelPartido() {
		return id_partido;
	}

	public ResultadoEnum resultadoEquipoA() {
		if(ganaEquipoA.equalsIgnoreCase("x")) {
			return ResultadoEnum.GANADOR;
		}else if(ganaEquipoB.equalsIgnoreCase("x")) {
			return ResultadoEnum.PERDEDOR;
		}
		return ResultadoEnum.EMPATE;
	}

	public void mostrarPronostico() {
		System.out.print("Pronistico partido " + id_partido + "---> " );
		if(resultadoEquipoA() == ResultadoEnum.GANADOR) {
			System.out.println("Gana: " + equipoA.getNombre());
		}else if(resultadoEquipoA() == ResultadoEnum.PERDEDOR) {
			try {
				System.out.println("Gana: " + this.ronda.partido(id_partido).getEquipo2().getNombre());
			} catch (IdPartidoNoEncontradoException e) {
			}
		}else {
			System.out.println("EMPATE");
		}
	}

	/*public void inicializarCon(Ronda ronda) 
			throws IdPartidoNoEncontradoException {
		this.ronda = ronda;
		this.equipoA = this.ronda.partido(id_partido).getEquipo1();
	}*/

	public int getId_partido() {
		return id_partido;
	}

	public void setId_partido(int id_partido) {
		this.id_partido = id_partido;
	}

	public String getGanaEquipoA() {
		return ganaEquipoA;
	}

	public void setGanaEquipoA(String ganaEquipoA) {
		this.ganaEquipoA = ganaEquipoA;
	}

	public String getEmpate() {
		return empate;
	}

	public void setEmpate(String empate) {
		this.empate = empate;
	}

	public String getGanaEquipoB() {
		return ganaEquipoB;
	}

	public void setGanaEquipoB(String ganaEquipoB) {
		this.ganaEquipoB = ganaEquipoB;
	}

	public Equipo getEquipoA() {
		return equipoA;
	}

	public void setEquipoA(Equipo equipoA) {
		this.equipoA = equipoA;
	}

	public Ronda getRonda() {
		return ronda;
	}

	public void setRonda(Ronda ronda) {
		this.ronda = ronda;
	}

	public String getParticipante() {
		return participante;
	}

	public void setParticipante(String participante) {
		this.participante = participante;
	}

	
}
