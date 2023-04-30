package miprimerproyecto.StringsEncodeYDecode;

import java.util.Scanner;

public class EncodeYDecode {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		
		System.out.println("Ingresa una frase");
		
		String frase = scn.nextLine();
		
		System.out.println("Ingresa el desplazamiento deseado");
		
		int desplazamiento = scn.nextInt();
		
		//Encode: transformar el String en el código numérico
		byte[] decodedBytes = frase.getBytes();
		
		for(int j = 0; j < decodedBytes.length ; j++) {
			decodedBytes[j] = (byte) (decodedBytes[j] + desplazamiento);
		}
		
		
		//Decode: recuperar el String a partir del array de bytes
		frase = new String(decodedBytes);
		
		System.out.println(frase);
		
	}
	
}
