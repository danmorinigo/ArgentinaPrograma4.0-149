package miprimerproyectomio;

public class AparicionDeCaracter {
	public static int cuentaLetras(String frase, char letraBuscada) {
		char letraEnLaCadena;
		int apariciones = 0;
		
		for (int i = 0; i < frase.length(); i++) {
			letraEnLaCadena = frase.charAt(i);
			if(letraEnLaCadena == letraBuscada) {
				apariciones++;
			}
		}
		return apariciones;
	}
}
