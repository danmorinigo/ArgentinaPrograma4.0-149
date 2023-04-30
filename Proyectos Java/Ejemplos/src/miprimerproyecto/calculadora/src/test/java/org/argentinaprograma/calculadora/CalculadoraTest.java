package org.argentinaprograma.calculadora;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class CalculadoraTest {
	
	@Test
	public void multiplicaCorrectamente() {
		double numero1 = 80.0;
		double numero2 = 3.0;
		double resultadoEsperado = 240.0;
		
		assertEquals(resultadoEsperado, Calculadora.multiplicar(numero1, numero2));
	}
	
	@Test
	public void sumaDosNumerosYDivideElResultadoCorrectamente() {
		double numero1 = 150;
		double numero2 = 180;
		double numero3 = 3;
		double resultadoEsperado = 110;
		double resultadoParcial = Calculadora.sumar(numero1, numero2);
		
		assertEquals(resultadoEsperado, Calculadora.dividir(resultadoParcial, numero3));
	}
	
	@Test
	public void restarDosNumerosYLuegoMultiplicarlosNoDaUnMalResultado() {
		double numero1 = 90;
		double numero2 = 50;
		double numero3 = 5;
		double resultadoNoEsperado = 605;
		double resultadoParcial = Calculadora.restar(numero1, numero2);
		
		assertNotEquals(resultadoNoEsperado, Calculadora.multiplicar(resultadoParcial, numero3));
	}
	
	@Test
	public void sumarDosNumerosYLuegoMultiplicarlosNoDaUnMalResultado() {
		double numero1 = 70;
		double numero2 = 40;
		double numero3 = 25;
		double resultadoNoEsperado = 2700;
		double resultadoParcial = Calculadora.sumar(numero1, numero2);
		
		assertNotEquals(resultadoNoEsperado, Calculadora.multiplicar(resultadoParcial, numero3));
	}
}
