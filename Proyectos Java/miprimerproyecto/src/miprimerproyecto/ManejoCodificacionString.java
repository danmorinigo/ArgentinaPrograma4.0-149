package miprimerproyecto;

public class ManejoCodificacionString {
	private static String abecedario = " abcdefghijklmnñopqrstuvwxyz";
	
	public static String dezplazarCaracter(String cadena, int desplazamiento) {
		char[] fraseEnVector = new char[cadena.length()];
		char caracterEvaluado;
		for (int i = 0; i < cadena.length(); i++) {
			caracterEvaluado = cadena.charAt(i);
			int lugarEnAbecedario = abecedario.indexOf(caracterEvaluado);
			int nuevoLugarEnAbecedario = lugarEnAbecedario + desplazamiento;
			if (nuevoLugarEnAbecedario >= abecedario.length()) {
				nuevoLugarEnAbecedario -= abecedario.length();
			}
			fraseEnVector[i] = abecedario.charAt(nuevoLugarEnAbecedario);
		}
		String fraseNueva = new String(fraseEnVector);
		return fraseNueva;
	}
}
