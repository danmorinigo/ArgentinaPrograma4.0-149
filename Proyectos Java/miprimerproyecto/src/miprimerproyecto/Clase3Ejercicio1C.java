package miprimerproyecto;

public class Clase3Ejercicio1C {

	public static void main(String[] args) {
		int[] numeros = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
		int numeroDeControl = 25;
		int resultado = 0;
		System.out.println("Numeros en el vector:");
		for(int numero : numeros) {
			System.out.print(numero + " ");
		}
		System.out.println();
		System.out.println("Se suman:");
		for(int numero : numeros) {
			if(numero > numeroDeControl) {
				System.out.print(numero + " ");
				resultado += numero;
			}
		}
		System.out.println();
		System.out.println("--------------");
		System.out.println("Resultado: " + resultado);
		
	}

}
