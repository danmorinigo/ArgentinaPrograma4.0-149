package miprimerproyecto.Ejercicios;

public class Clase01Ejercicios {


	public static void main(String[] args) {
		
		//Imprimir enteros entre dos variables
		int numeroInicio = 6;
		int numeroFinal = 14;
		
		while (numeroInicio <= numeroFinal) {
			System.out.println(numeroInicio++);
		}
		
		numeroInicio = 5;
		numeroFinal = 14;
		
		char paroimpar = 'p';
		
		while (numeroInicio <= numeroFinal) {
			numeroInicio++;
			switch  (paroimpar) {
				case 'p':
					if(numeroInicio % 2 == 0)
						System.out.println(numeroInicio);
				case 'i':
					if(numeroInicio % 2 != 0)
						System.out.println(numeroInicio);
				default:
					System.out.println("Opción incorrecta");
			}
			// numeroInicio+=2;
		}
		
		for(int otroNum=0;otroNum<10;otroNum++){
			System.out.println(otroNum);
		}
		
		if (numeroInicio < numeroFinal) {
			while (numeroFinal != numeroInicio) {
			System.out.println(numeroInicio++);
		}
			System.out.println(numeroFinal);
		} else {
		while (numeroFinal != numeroInicio) {
			System.out.println(numeroInicio--);
		}
			System.out.println(numeroFinal);
		}
	
		
		
		float ingresosMensuales = 25000;
		double ingresosMensualesAltos = 489.083;
		int cantidadVehiculos = 3;
		int antiguedadVehiculos = 5;
		int cantidadInmuebles = 3;
		boolean capacidadEconomicaPlena = true;
		
		
		if (ingresosMensuales >= ingresosMensualesAltos && 
				cantidadVehiculos >= 3 &&
				antiguedadVehiculos < 5 &&
				cantidadInmuebles >= 3 && 
				capacidadEconomicaPlena == true) {
					System.out.println("Usted se encuentra en la categoría de Ingresos Altos");
				} else {
					System.out.println("Usted no pertenece al segmento de Ingresos Altos");
				}
	}
}
