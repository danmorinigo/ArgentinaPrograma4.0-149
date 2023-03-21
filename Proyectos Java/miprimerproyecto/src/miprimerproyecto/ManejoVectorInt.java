package miprimerproyecto;

public class ManejoVectorInt {

	public static int sumarMayoresQue(int[] vector, int numeroDeControl) {
		int resultado = 0;
		System.out.println("Numeros en el vector:");
		for(int numero : vector) {
			System.out.print(numero + " ");
		}
		System.out.println();
		System.out.println("Se suman:");
		for(int numero : vector) {
			if(numero > numeroDeControl) {
				System.out.print(numero + " ");
				resultado += numero;
			}
		}
		System.out.println();
		System.out.println("--------------");
		return resultado;
	}

}
