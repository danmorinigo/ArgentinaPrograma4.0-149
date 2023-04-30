package miprimerproyecto.Ejercicios;

public class MiPrimerClase {

	public static void main(String[] args) {
		
		int numero = 1;

		// OPERACIONES BASICAS
		int suma   = 10 + 20;		
		int resta  = 15 - 12;
		int mult   = 10 * 3;
		int div    = 8 / 3;
		int modulo = 8 % 3;
				
		System.out.println(modulo);

		int unNum = 20;
		
		while(unNum >= 0){
			
			System.out.println(unNum);
			
			unNum--; //unNum = unNum -1;
		}
		
		System.out.println("Inicia el ciclo FOR");
		
		for(unNum=5;unNum<10;unNum++) {
			
			System.out.println(unNum);
		}
		
		System.out.println("Primer ejercicio del cuestionario");
		
	}

}
