package org.argentinaprograma.entrega3;

import java.util.List;

import org.argentinaprograma.entrega3.models.ImportadorDatos;
import org.argentinaprograma.entrega3.models.Pronostico;
import org.argentinaprograma.entrega3.models.Ronda;

public class UsoPronostico {

	public static void main(String[] args) {

		chequearCantidadArgumentos(args);

		Ronda ronda = ImportadorDatos.crearRonda(args[0]);
		String dBPronosticos = args[1];
		List<Pronostico> pronosticos = ImportadorDatos.crearPronosticos(dBPronosticos, ronda);
		
		Ronda.mostrarPuntuacionGeneral(pronosticos);

	}

	private static void chequearCantidadArgumentos(String[] args) {
		if(args.length != 2) {
			System.out.println("Numero incorrecto de parametros.");
			System.exit(88);
		}
	}

}
