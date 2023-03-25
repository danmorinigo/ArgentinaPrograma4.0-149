package miprimerproyectomio;

public class ManejoCodificacionString {
	private static String abecedario = ", !abcdefghijklmnñopqrstuvwxyz";
	
	public static String dezplazarCaracter(String cadena, int desplazamiento) {
		char[] fraseEnVector = new char[cadena.length()];
		char caracterEvaluado;
		for (int i = 0; i < cadena.length(); i++) {
			caracterEvaluado = cadena.charAt(i);
			if (caracterEvaluado == '\n') {
				fraseEnVector[i] = caracterEvaluado;
			}else{
				int lugarEnAbecedario = abecedario.indexOf(caracterEvaluado);
				int nuevoLugarEnAbecedario = lugarEnAbecedario + desplazamiento;
				if(desplazamiento > 0) {
					if (nuevoLugarEnAbecedario >= abecedario.length()) {
						nuevoLugarEnAbecedario -= abecedario.length();
					}
				}else {
					if (nuevoLugarEnAbecedario < 0 ) {
						nuevoLugarEnAbecedario += abecedario.length();
					}
				}
				fraseEnVector[i] = abecedario.charAt(nuevoLugarEnAbecedario);
			}
		}
		String fraseNueva = new String(fraseEnVector);
		return fraseNueva;
	}
}
