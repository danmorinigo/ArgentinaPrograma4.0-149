package miprimerproyectomio;

public class OrdenaVector {

	public static void ordenar(int[] vector, boolean ordenAscendente) {
		int numeroAuxiliar;
		
		if(ordenAscendente){
			if(vector[1] < vector[0]) {
				numeroAuxiliar = vector[0];
				vector[0] = vector[1];
				vector[1] = numeroAuxiliar;
			}
			if(vector[2] < vector[1]) {
				numeroAuxiliar = vector[1];
				vector[1] = vector[2];
				vector[2] = numeroAuxiliar;
			}
			if(vector[1] < vector[0]) {
				numeroAuxiliar = vector[0];
				vector[0] = vector[1];
				vector[1] = numeroAuxiliar;
			}
		}else{
			if(vector[1] > vector[0]) {
				numeroAuxiliar = vector[0];
				vector[0] = vector[1];
				vector[1] = numeroAuxiliar;
			}
			if(vector[2] > vector[1]) {
				numeroAuxiliar = vector[1];
				vector[1] = vector[2];
				vector[2] = numeroAuxiliar;
			}
			if(vector[1] > vector[0]) {
				numeroAuxiliar = vector[0];
				vector[0] = vector[1];
				vector[1] = numeroAuxiliar;
			}
			
		}
	}

}
