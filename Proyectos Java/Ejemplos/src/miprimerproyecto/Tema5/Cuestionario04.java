package miprimerproyecto.Tema5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Cuestionario04 {

	public static void main(String[] args) {
		
		//Dado el siguiente código, indique la opción correcta:
		String archivo = "recursos/ArchivoTexto.txt";
		
		try {
			
			for (String linea : Files.readAllLines(Paths.get(archivo))){
				if(linea.startsWith("*")){
					System.out.println(linea);
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		String unaFrase = "hola que tal";
		
		char unaLetra = 'z';
		
		int cantidadDeLetras = contarLetra(unaFrase,unaLetra);
		
		
		System.out.println("La cantidad de veces que aparece la letra "+unaLetra+" es "+cantidadDeLetras);
		
	}
	
	public static int contarLetra(String unaPalabra, char letra){

		int cuenta = 0; //contador

		for (int i = 0; i< unaPalabra.length(); i++){
			if( unaPalabra.charAt(i)  == letra){
				cuenta = cuenta + 1;
			}
		}
		return cuenta;

	}
	
}
