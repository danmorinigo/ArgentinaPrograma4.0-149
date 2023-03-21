package miprimerproyecto;

public class Clase3Ejercicio1 {

	public static void main(String[] args) {
		
		String unaCadena = "Hola buenos dias mundo.";
		char letraBuscada = 'H';
		
		int apariciones = AparicionDeCaracter.cuentaLetras(unaCadena, letraBuscada);
		System.out.println("Frase: " + unaCadena);
		System.out.println("El caracter \"" + letraBuscada + "\" aparece " + apariciones + " veces.");
	
		System.out.println("Ordenar un vector de 3 enteros");
		System.out.println("------------------------------");
		
		int[] vectorAOrdenar = {500, 5, 100};
		OrdenaVector.ordenar(vectorAOrdenar, true);
		for(int numero : vectorAOrdenar) {
			System.out.println(numero);
		}
		
		System.out.println("Dado un numero X sumar los que son mayores a X");
		System.out.println("----------------------------------------------");
		
		int[] unVector = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
		int numeroDeControl = 95;
		int resultado = ManejoVectorInt.sumarMayoresQue(unVector, numeroDeControl);
		System.out.println("Resultado: " + resultado);
	
		System.out.println("Desplazamiento caracteres en una cadena");
		System.out.println("---------------------------------------");
		
		String nuevaCadena = "hola que tal";
		int desplazamiento = 2;
		String desplazado = ManejoCodificacionString.dezplazarCaracter(nuevaCadena, desplazamiento);
		System.out.println(nuevaCadena);
		System.out.println(desplazado);
	}
}
