package miprimerproyecto.Ejercicios;

public class Clase01Ejercicio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int numeroInicio = 5;
		int numeroFin = 14;
		// Se deberían mostrar los números:
		//5,6,7,8,9,10,11,12,13,14

		while(numeroInicio <= numeroFin) {
			
			System.out.println(numeroInicio);
			numeroInicio++;  
		}
		
		System.out.println("Termino el punto A");
		System.out.println("Numero de inicio vale:"+numeroInicio);
		System.out.println("Numero de fin vale:"+numeroFin);
		
		
		System.out.println("Iniciamos el punto B");
		
		numeroInicio = 5;
		numeroFin = 14;
		
	
		while(numeroInicio <= numeroFin) {
			
			if(numeroInicio % 2  == 0) {
				System.out.println(numeroInicio);
			}
			numeroInicio++;  
		}
		
		System.out.println("Termino el punto B");
		System.out.println("Numero de inicio vale:"+numeroInicio);
		System.out.println("Numero de fin vale:"+numeroFin);
	
		System.out.println("Iniciamos el punto C");
		
		numeroInicio = 5;
		numeroFin = 14;
		boolean esPar = false; // true = esPar ... false = No es par
		
		
		while(numeroInicio <= numeroFin) {
			
			if(numeroInicio % 2  == 0 && esPar) {
				System.out.println(numeroInicio);
			}
			//Creamos instrucciones que implican que el numeroInicio sea impar.
			if(numeroInicio % 2  != 0 && !esPar){
				System.out.println(numeroInicio);
			}
			
			numeroInicio++;  
		}
		
		
		numeroInicio = 5;
		numeroFin = 14;
		char parOImpar = 'p'; // p es par .. i es impar
		
		while(numeroInicio <= numeroFin) {
			
			switch (parOImpar) {
				case 'p':
					if(numeroInicio % 2  == 0) {
						System.out.println(numeroInicio);
					}
					break;
				case 'i':
					if(numeroInicio % 2 != 0) {
						System.out.println(numeroInicio);
					}
					break;
				default:
					System.out.println("Opción ingresada incorrecta");
					break;
			}
			
			numeroInicio++;  
		}
		
		for(numeroInicio = 5;numeroInicio <= numeroFin; numeroInicio++) {
			System.out.println(numeroInicio);
		}
		
		
		
	}

}
