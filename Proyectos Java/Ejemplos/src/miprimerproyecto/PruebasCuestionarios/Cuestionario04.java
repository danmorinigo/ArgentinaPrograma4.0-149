package miprimerproyecto.PruebasCuestionarios;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Cuestionario04 {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		String rutaRelativa = "recursos/ArchivoTexto.txt";
	
		try {
			for(String linea : Files.readAllLines(Paths.get(rutaRelativa))) {
				if(linea.startsWith("*")){
					System.out.println(linea);
				}			
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Analizar proceso de encode y decode
		Scanner scn = new Scanner(System.in);
		
		System.out.println("Ingresa una frase");
		
		String frase = scn.nextLine();
		
		System.out.println("Ingresa el desplazamiento que queres realizar");
		
		int desplazamiento = Integer.parseInt(scn.nextLine());
		
		System.out.println(desplazamientoString(frase,desplazamiento));
		
		//Otra pregunta del cuestionario
		
		//System.out.println("Cantidad de veces que aparece la letra en el String: "+contarLetra("",'c'));

	}
	
	public static int contarLetra(String unaPalabra, char letra){

		int cuenta = 0; //contador que nos permite justamente contar las veces que aparece el char letra

		for (int i = 0; i<unaPalabra.length(); i++){
			if( unaPalabra.charAt(i)  == letra){
				cuenta = cuenta + 1;
			}
		}
		return cuenta;
	}
	
	public static String desplazamientoString(String frase, int desplazamiento) {
		
		byte[] decodedBytes = frase.getBytes();
		
		for(int j = 0; j < decodedBytes.length; j++) {
			decodedBytes[j] = (byte) (decodedBytes[j] + desplazamiento);
		}
		
		return new String(decodedBytes);		
	}

}