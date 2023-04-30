package miprimerproyecto.MemoryStackHeap;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Ejemplo de un programa que pueda ejecutarse y perdurar en el tiempo usando Scanner
//Ejecutar varios procesos
public class EjemploMultiProceso {

	public static void main(String[] args) {
				
		Scanner obj = new Scanner(System.in);
		
		List<String> frasesGuardadas = new ArrayList<String>();
		boolean sigueConsultando = true;
		String textoCapturado;
		while(sigueConsultando) {
			System.out.println("ingrese un texto");
			textoCapturado = obj.nextLine();
			System.out.println("el texto ingresado fue: " + textoCapturado);
		
			frasesGuardadas.add(textoCapturado);
			
			System.out.println("Queres seguir consultando? SI/NO");
			textoCapturado = obj.nextLine();
			if(textoCapturado.equalsIgnoreCase("NO")) {
				sigueConsultando = false;
			}
		}
		
		for(String frase : frasesGuardadas) {
			System.out.println(frase);
		}
		
		
	}

}
