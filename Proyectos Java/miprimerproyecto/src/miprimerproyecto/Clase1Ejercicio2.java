package miprimerproyecto;

public class Clase1Ejercicio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double ingresos = 489083.5;
		int vehiculosAntiguedadMenor5Anios = 0;
		int inmuebles = 0;
		boolean poseeVehiculoLujoOTitularActivos = false;
		
		if((ingresos >= 489083) || (vehiculosAntiguedadMenor5Anios >= 3) ||
				(inmuebles >= 3) || poseeVehiculoLujoOTitularActivos){
			System.out.println("Pertenece a Segmento Ingresos Altos.");
		}else {
			System.out.println("NO pertenece a Segmento Ingresos Altos.");
		}
	}
}
