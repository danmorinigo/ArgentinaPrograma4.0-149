package tema4;

import java.util.Scanner;

public class Ejercicio1A {

	public static void main(String[] args) {

		ordenarNumeros(1000, 5, 60, "d");
	
	}

	public static void ordenarNumeros(int num1, int num2, int num3, String criterioOrden) {
		
		int numeroAuxiliar;
		int[] vector = {num1, num2, num3};
		
		if(criterioOrden.equalsIgnoreCase("a")){
			System.out.println("Orden Ascendente");
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
			System.out.println("Orden Descendente");
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
		System.out.println("Orden original ->\t" + num1 + " " + num2 + " "
		+ num3);
		System.out.println("Resultado ->\t\t" + vector[0] + " " + vector[1] + " "
				+ vector[2]);
	}
	
	public static void ordenarNumeros() {
		
		Scanner entrada = new Scanner(System.in);

		System.out.print("Ingrese numeroA: ");
		int num1 = entrada.nextInt();
		System.out.print("Ingrese numeroB: ");
		int num2 = entrada.nextInt();
		System.out.print("Ingrese numeroC: ");
		int num3 = entrada.nextInt();
	
		System.out.print("Ingrese orden [ a / d]: ");
		String criterio = entrada.next();	
		
		ordenarNumeros(num1, num2, num3, criterio);
		
		entrada.close();
		/*
		int numeroAuxiliar;
		int[] vector = {num1, num2, num3};
		
		if(criterio.equalsIgnoreCase("a")){
			System.out.println("Orden Ascendente");
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
			System.out.println("Orden Descendente");
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
		System.out.println("Orden original ->\t" + num1 + " " + num2 + " " + num3);
		System.out.println("Resultado ->\t\t" + vector[0] + " " + vector[1] + " " + vector[2]);
		*/
	}
}
