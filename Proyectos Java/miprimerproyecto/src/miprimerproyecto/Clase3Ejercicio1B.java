package miprimerproyecto;

public class Clase3Ejercicio1B {

	public static void main(String[] args) {
		int numeroA = 75;
		int numeroB = 1000;
		int numeroC = 750;
		int numeroAuxiliar;
		boolean ordenAscendente = true;
		int[] numerosOrdenados = {numeroA, numeroB, numeroC};
		
		if(ordenAscendente){
			if(numerosOrdenados[1] < numerosOrdenados[0]) {
				numeroAuxiliar = numerosOrdenados[0];
				numerosOrdenados[0] = numerosOrdenados[1];
				numerosOrdenados[1] = numeroAuxiliar;
			}
			if(numerosOrdenados[2] < numerosOrdenados[1]) {
				numeroAuxiliar = numerosOrdenados[1];
				numerosOrdenados[1] = numerosOrdenados[2];
				numerosOrdenados[2] = numeroAuxiliar;
			}
			if(numerosOrdenados[1] < numerosOrdenados[0]) {
				numeroAuxiliar = numerosOrdenados[0];
				numerosOrdenados[0] = numerosOrdenados[1];
				numerosOrdenados[1] = numeroAuxiliar;
			}
		}else{
			if(numerosOrdenados[1] > numerosOrdenados[0]) {
				numeroAuxiliar = numerosOrdenados[0];
				numerosOrdenados[0] = numerosOrdenados[1];
				numerosOrdenados[1] = numeroAuxiliar;
			}
			if(numerosOrdenados[2] > numerosOrdenados[1]) {
				numeroAuxiliar = numerosOrdenados[1];
				numerosOrdenados[1] = numerosOrdenados[2];
				numerosOrdenados[2] = numeroAuxiliar;
			}
			if(numerosOrdenados[1] > numerosOrdenados[0]) {
				numeroAuxiliar = numerosOrdenados[0];
				numerosOrdenados[0] = numerosOrdenados[1];
				numerosOrdenados[1] = numeroAuxiliar;
			}
			
		}
		for(int numero : numerosOrdenados) {
			System.out.println(numero);
		}
	}

}
