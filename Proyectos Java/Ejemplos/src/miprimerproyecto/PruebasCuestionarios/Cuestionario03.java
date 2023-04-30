package miprimerproyecto.PruebasCuestionarios;

public class Cuestionario03 {

	public static void main(String[] args) {
		
		//Primer pregunta
		// No se puede escribir la letra contrabarra “\“ en una cadena ya que es el carácter de “escape”
		
		System.out.println(" \t  \n \"  \'  \\    ");
		
		//SEGUNDA PREGUNTA DEL CUESTIONARIO
		//Cual es la salida de la siguiente sentencia: "hola que tal?".toUpperCase().replace("hola","chau");
		
		String txt = "hola que tal?";
		
		System.out.println(txt.toUpperCase().replace("hola", "chau"));
		
		System.out.println(txt.replace("hola", "chau").toUpperCase());
		
		//Tercer pregunta
		//Si tenemos el siguiente array: "int numeros[] = new int[]{1,37,16};"¿qué valor es numeros[2] ?
		
		int numeros[] = {1,37,16};
		
		System.out.println(numeros[2]);
		
		//Cuarta pregunta
		//Dada la siguiente sentencia: String[] separado = "3_tristes tigres_del_13".split("_") , indique la opción correcta:
		
		String unString = "3_tristes tigres_del_13";
		
		String[] separado = unString.split("_"); // Retornaria algo así: {"3","tristes tigres","del","13"}
		
		System.out.println(separado[1]);
		
		//Quinta pregunta
		// Ciclo for 
		
		
		char letras[] = {'a','b','c','d'};

		int numeros2[] = new int[]{1,37,16};

		for(int i=0;     i<numeros2.length    ;     i++){
			if (numeros2[i] < 30) {
				System.out.println(letras[i+1]);
			} else {
				System.out.println(numeros2[i]);
			}
		}
		
		
		
		
	}

}
