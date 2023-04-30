package miprimerproyecto.Tema3;

import java.util.Arrays;
import java.util.Collections;

public class EjerciciosTema03 {

	public static void main(String[] args) {
		
		//a) Dado un String y una letra, que cuente la cantidad de apariciones de la letra en el String

		String variableString = "Dado un String y una letra";
		char unaLetra = 'u';
		int cantVecesDeAparicion = 0;
		
		char letraDelString;
		
		for(int i = 0 ;  i < variableString.length() ; i++) {
			letraDelString = variableString.charAt(i);
			if(letraDelString == unaLetra) {
				cantVecesDeAparicion++;
			}		
		}
		
		System.out.println("Cantidad de apariciones de la letra \""+unaLetra+"\":"+cantVecesDeAparicion);
		
		System.out.println("b) Dados 3 números y un orden (ascendente o decreciente) que ordene los mismos y los retorne en un vector de 3");
		
		Integer numeros[] = {-2,23,0,10,2,-10};
		boolean ascendente = true;
		
		if(ascendente) {
			//Ordenamos de menor a mayor
			Arrays.sort(numeros);
		}else {
			//Ordenamos de mayor a menor
			Arrays.sort(numeros, Collections.reverseOrder());
		}
		
		for(int elemento : numeros) {
			System.out.println(elemento);
		}
		
		System.out.println("c) dado un vector de números, y un número X, que sume todos los números > X y retorne el resultado");
		
		int vectorNumeros[] = {10,20,30,50,-2,50,-10};
		int sumatoriaDeNumeros = 0;
		int x = 30;
		for(int num : vectorNumeros) {
			if(num >= x) {
				sumatoriaDeNumeros = sumatoriaDeNumeros + num;
			}
		}
		
	}

}
