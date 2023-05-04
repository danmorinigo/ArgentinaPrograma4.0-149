package org.argentinaprograma.entrega2;

import org.junit.Before;
import org.junit.Test;
import org.argentinaprograma.entrega2.exceptions.IdPartidoNoEncontradoException;
import org.argentinaprograma.entrega2.exceptions.ErrorCantidadCamposException;
import org.argentinaprograma.entrega2.exceptions.ErrorNumericoException;
import org.argentinaprograma.entrega2.models.Equipo;
import org.argentinaprograma.entrega2.models.ImportadorDatos;
import org.argentinaprograma.entrega2.models.Partido;
import org.argentinaprograma.entrega2.models.Ronda;

public class ExceptionsTest extends Exception{
	
	private Equipo equipoA;
	private Equipo equipoB;
	private Partido partido;
	private Ronda ronda;
	private String participante = "Pedro";
	
	@Before
	public void inicializar() {
		equipoA = new Equipo("Boca");
		equipoB = new Equipo("River");
		partido = new Partido();
		ronda = new Ronda();
	}
	
	@Test(expected = IdPartidoNoEncontradoException.class)
	public void siNoExisteIdPartidoLanzaExcepcion()
			throws IdPartidoNoEncontradoException {
		
		partido.setId(1);
		partido.setRonda(1);
		partido.setEquipo1(equipoA);
		partido.setEquipo2(equipoB);
		partido.setGolesEquipo1(0);
		partido.setGolesEquipo2(0);
		ronda.agregarPartidos(partido);
		
		System.out.println(ronda.partido(2).getGolesEquipo1());
	}

	@Test(expected = ErrorCantidadCamposException.class)
	public void siLineaLeidaNoTiene6CamposLanzaExcepcion()
			throws ErrorCantidadCamposException {
		String[] lineaConMalosCampos = "1,Argentina,1,Belgica".split(",");
		
		ImportadorDatos.chequearCantidadCampos(lineaConMalosCampos);
	}
	
	@Test(expected = ErrorNumericoException.class)
	public void siCamposGolesNoSonEnterosPositivosLanzaExcepcion()
			throws ErrorNumericoException {
		String regEx = "[0-9]+";
		String[] lineaConMalosGoles = "4,1,Canada,1,2.1,Nicaragua".split(",");
		ImportadorDatos.chequearCamposGoles(lineaConMalosGoles, regEx);
	}
}
