package miprimerproyecto;

public class Guia1Ejercicio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int numeroInicio = 4;
		int numeroFinal = 15;
		int numeroAMostrar = numeroInicio;
		
		System.out.println("PUNTO A)");
		System.out.println("Mostrar todos los numeros");
		System.out.println("-------");
		while (numeroAMostrar <= numeroFinal) {
			System.out.println(numeroAMostrar);
			numeroAMostrar = numeroAMostrar + 1;
		}
		
		
		System.out.println("PUNTO B)");
		System.out.println("Mostrar numeros PARES");
		System.out.println("-------");
		
		numeroAMostrar = numeroInicio;
		
		while (numeroAMostrar <= numeroFinal) {
			if(numeroAMostrar % 2 == 0) {
			
				System.out.println(numeroAMostrar);
				
			}
			
			numeroAMostrar = numeroAMostrar + 1;
		}
	
		System.out.println("PUNTO C)");
		System.out.println("Mostrar numeros PARES - Eligiendo");
		System.out.println("-------");
		
		numeroAMostrar = numeroInicio;
	
		boolean mostrarPares = true;
		while (numeroAMostrar <= numeroFinal) {
			if (mostrarPares == true) {
				if(numeroAMostrar % 2 == 0) {
					System.out.println(numeroAMostrar);
				}	
			}else{
				if(numeroAMostrar % 2 != 0) {
					System.out.println(numeroAMostrar);
				}	
			}
			
			numeroAMostrar = numeroAMostrar + 1;
		}
		
		System.out.println("PUNTO D)");
		System.out.println("Igual a PUNTO B) pero orden inverso");
		System.out.println("-------");
		for(int i = numeroFinal; i >= numeroInicio; i--) {
			if(i % 2 == 0) {
				System.out.println(i);
			}
		}
	}

}
