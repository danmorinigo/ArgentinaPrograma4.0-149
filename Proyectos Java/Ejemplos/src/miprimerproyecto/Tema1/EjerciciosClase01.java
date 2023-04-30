package miprimerproyecto.Tema1;

public class EjerciciosClase01 {

	public static void main(String[] args) {
		
		System.out.println("Resolucion item A del punto 1");
		
		int numeroInicio = 0;
		int numeroFin = 14;
		// Se deberían mostrar los números:
		
		while(numeroInicio <= numeroFin) {
			
			System.out.println(numeroInicio);
			
			numeroInicio++;
			
		}
		
		System.out.println("Resolucion item B del punto 1");
		
		numeroInicio = 5;
		numeroFin = 14;
		// Se deberían mostrar los números:
		
		while(numeroInicio <= numeroFin) {
			
			if( (numeroInicio % 2) == 0) {
				System.out.println(numeroInicio);
			}
			
			numeroInicio++;
			
		}
		
		System.out.println("Resolucion item C del punto 1");
		
		numeroInicio = 5;
		numeroFin = 14;
		// Se deberían mostrar los números:
		
		boolean imprimirLosPares = true; //true -> un número par ; false -> un número impar
		
		while(numeroInicio <= numeroFin) {
			
			if(numeroInicio % 2 == 0 && imprimirLosPares) {
				System.out.println(numeroInicio);
			}
			
			if(numeroInicio % 2 != 0 && !imprimirLosPares) {
				System.out.println(numeroInicio);
			}
			numeroInicio++;
			
		}
		
		
		System.out.println("Resolucion Opcional item C del punto 1");
		
		numeroInicio = 5;
		numeroFin = 14;
		// Se deberían mostrar los números:
		
		char imprimir = 'i'; //p -> un número par ; i -> impares
		
		while(numeroInicio <= numeroFin) {
			
			switch(imprimir) {
				case 'p':
					if(numeroInicio % 2 == 0) {
						System.out.println(numeroInicio);
					}
					break;
				case 'i':
					if(numeroInicio % 2 != 0) {
						System.out.println(numeroInicio);
					}
					break;
				default:
					System.out.println("Opcion incorrecta");
				
				}
				numeroInicio++;
			}
		
		
		System.out.println("Resolucion item D del punto 1");
		
		//numeroInicio = 0;  Si uso for, podría no inicializar la variable
		numeroFin = 0;
		
		for(numeroInicio = 14;numeroInicio >= numeroFin;numeroInicio--){
			System.out.println(numeroInicio);
		}
		
		
	}

}
