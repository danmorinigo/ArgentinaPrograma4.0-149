package miprimerproyecto.Ejercicios;

public class ClaseConMetodos {

	public static void main(String[] args) {
		
		int vectorNumeros[] = {10,20,30,50,-2,50,-10};
		
		System.out.println(sumatoriaDeNumeros(vectorNumeros));

	}
	
	public static int sumatoriaDeNumeros(int vectorNumeros[]) {
		int sumatoriaDeNumeros = 0;
		for(int num : vectorNumeros) {
			sumatoriaDeNumeros = sumatoriaDeNumeros + num;
		}		
		return sumatoriaDeNumeros;		
	}
	
}
