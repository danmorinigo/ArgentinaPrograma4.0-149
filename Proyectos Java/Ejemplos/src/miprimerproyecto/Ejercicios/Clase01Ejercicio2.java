package miprimerproyecto.Ejercicios;

public class Clase01Ejercicio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		float ingresosMensuales = 500000;
		int cantidadVehiculos = 0;  //con una antiguedad menor a 5 años
		int cantidadInmuebles = 0;
		int cantidadVehiculosLujo = 0; //Incluye embarcacion, aeronave o titular de activos societarios

		if(
				ingresosMensuales >= 489083 ||
				cantidadVehiculos >= 3 ||
				cantidadInmuebles >= 3 ||
				cantidadVehiculosLujo > 0
				) {
			
			System.out.println("Es una persona de ingresos altos");
		}else {
			System.out.println("No es una persona de ingresos altos");
		}
			
			
		
		
		
	}

}
