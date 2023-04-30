package miprimerproyecto.PruebasCuestionarios;

public class Cuestionario01 {

	public static void main(String[] args) {
		
		int i = 6;

		while(i > 0) {// solo va a ingresar cuando el valor de i sea > 0
			System.out.println("i ingresa con el valor de:"+i);
			if (i < 3) {  //Solo va a ingresar cuando el valor de i < 3
				i = i + 1;
				System.out.println("Ingreso al if, y el valor de i ahora es:"+i);
			}

			i = i - 2; // Le asigna a I.. el valor de i - 2
			// i = 0
			System.out.println(i); //Imprime el valor de i

		}
		
		System.out.println("Prueba de un IF");
		
		int variable = 4;
		
		if(variable == 3) {
			
			System.out.println("Si la variable vale 3");
			
		}else {
			
			System.out.println("La variable no vale 3");
			
		}
		
		
	}

}
