package miprimerproyecto.ArraysYColecciones;

public class ClaseConArrays {

	public static void main(String[] args) {
		
		//Lado izquierdo: declaramos el array
		//Lado derecho: asignamos valores
		int numeros[] = new int[3];
		
		numeros[0] = 1;
		numeros[1] = 10;
		numeros[2] = 32;
		
		//otra forma de asignar valores a un array
		int numeros2[] = {1 , 23 , 32};
		
		//otra forma de asignar valores a un array
		int numeros3[] = new int[] {1 , 23 , 32};
		
		System.out.println("Cantidad de elementos que tiene el array: "+numeros.length);
		
		//Lo que sucede en el FOR es lo siguiente:
		//System.out.println("El elemento en la posición 1 es: "+numeros[0]);
		//System.out.println("El elemento en la posición 2 es: "+numeros[1]);
		//System.out.println("El elemento en la posición 3 es: "+numeros[2]);
		for(int i = 0; i < numeros.length ; i++) {
			numeros[i] = numeros[i]*2;
			System.out.println("El elemento en la posición "+(i+1)+" es: "+numeros[i]);
		}
		
		for(int num : numeros2) {
			System.out.println(num);
		}
		
		//Array de letras
		
		char letras[] = {'a','b','c','d'};
		
		for(char letra : letras) {
			System.out.println(letra);
		}
		
	}

}
