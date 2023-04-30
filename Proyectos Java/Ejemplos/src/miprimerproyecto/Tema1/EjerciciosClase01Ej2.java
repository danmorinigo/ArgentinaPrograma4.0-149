package miprimerproyecto.Tema1;

public class EjerciciosClase01Ej2 {

	public static void main(String[] args) {
		
		float ingresoMensual = 50000;
		int cantVehiculosAntMenor5Anos = 1; //vehiculos con una antiguedad menores a 5 años
		int cantInmuebles = 0;
		int cantVehiculosDeLujo = 0; // puede ser una embarcación, una aeronave o ser titular de sociedad
	
		if(
				ingresoMensual >= 489083 ||
				cantVehiculosAntMenor5Anos >= 3 ||
				cantInmuebles >= 3 ||
				cantVehiculosDeLujo > 0
				) {
			System.out.println("El hogar pertenece al segmento de clase alta");
		}else {
			System.out.println("El hogar NO pertenece al segmento de clase alta");
		}
	
	}

}
