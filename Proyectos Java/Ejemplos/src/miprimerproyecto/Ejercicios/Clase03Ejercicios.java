package miprimerproyecto.Ejercicios;

import java.util.Arrays;
import java.util.Collections;


public class Clase03Ejercicios {

	public static void main(String[] args) {
		
		System.out.println("a) Dado un String y una letra, que cuente la cantidad de apariciones de la letra en\r\n"
				+ "el String\r\n");
		
		String variableString = "Dado un String y una letra, que cuente la cantidad de apariciones";
		char unaLetra = 'n';
		int cantVecesDeAparicion = 0;
		
		for(int i = 0; i < variableString.length();i++) {
			if(variableString.charAt(i) == unaLetra) {
				cantVecesDeAparicion++;
			}
		}
		
		System.out.println("La cantidad de veces que aparece la letra: "+unaLetra+" es: "+cantVecesDeAparicion);
		
		
		System.out.println("b) Dados 3 números y un orden (ascendente o decreciente) que ordene los\r\n"
				+ "mismos y los retorne en un vector de 3\r\n");
		
		//Uso Integer para poder utilizar el metodo sort con reverseOrder
		Integer numeros[] = {-2,23,0};
		boolean ascendente = true; //false
		
		if(ascendente) {
			//Ordenamos de menor a mayor
			Arrays.sort(numeros);
		}else {
			//Ordenar de mayor a menor
			Arrays.sort(numeros, Collections.reverseOrder());
			
			//int[] reverseArr = IntStream.rangeClosed(1, arr.length).map(i -> arr[arr.length-i]).toArray();
		}
		for(int elemento : numeros) {
			System.out.println(elemento);
		}
				
		System.out.println("c) dado un vector de números, y un número X, que sume todos los números > X y retorne el resultado");
		
		int vectorNumeros[] = {10,20,30,50,-2,50,-10};
		int sumatoriaDeNumeros = 0;
		
		for(int num : vectorNumeros) {
			if(num >= 20) {
				sumatoriaDeNumeros = sumatoriaDeNumeros + num;
			}
		}
		
		System.out.println("La sumatoria de números mayores o iguales a 20 es:"+sumatoriaDeNumeros);
		
		
		String hola = "hola";
		
		byte[] decodedBytes = hola.getBytes();
		
		hola = new String(decodedBytes);
		
		System.out.println(hola);
		
		for(int j = 0; j < decodedBytes.length; j++) {
			decodedBytes[j] = (byte) (decodedBytes[j] + 1);
		}
		
		hola = new String(decodedBytes);
		
		System.out.println(hola);

	}

}
