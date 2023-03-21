package miprimerproyecto;

public class Clase3Ejercicio1A {

	public static void main(String[] args) {
		
		String unaCadena = "Hola buenos dias mundo.";
		char letraBuscada = 'H';
		/*
		char letraEnLaCadena;
		
		int apariciones = 0;
		
		for (int i = 0; i < unaCadena.length(); i++) {
			letraEnLaCadena = unaCadena.charAt(i);
			if(letraEnLaCadena == letraBuscada) {
				apariciones++;
			}
		}
		*/
		int apariciones = AparicionDeCaracter.cuentaLetras(unaCadena, letraBuscada);
		System.out.println("Frase: " + unaCadena);
		System.out.println("El caracter \"" + letraBuscada + "\" aparece " + apariciones + " veces.");
	}
}
