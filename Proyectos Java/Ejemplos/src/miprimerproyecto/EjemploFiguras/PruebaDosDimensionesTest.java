package miprimerproyecto.EjemploFiguras;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PruebaDosDimensionesTest {

	@DisplayName("Dado las medidas de un triángulo, validar el calculo de área")
	@Test
	void testTriangulo() {
		
		Triangulo triangulo1 = new Triangulo();
		
		triangulo1.base = 2.0;
		triangulo1.altura = 2.0;
		
		Assertions.assertEquals(triangulo1.calcularArea(), 2.0);
		
		triangulo1.clasificacion = "Rectangulo";
		Assertions.assertTrue(triangulo1.clasificacion.equals("Rectangulo"));
		
		Assertions.assertTrue(triangulo1.dimension == "Dos dimensiones");
		
	}
	
	@DisplayName("Dado las medidas de un cuadrado, validar el calculo de área")
	@Test
	void testCuadrado() {
		
		Cuadrado cuadrado1 = new Cuadrado();
		
		cuadrado1.base = 2.0;
		cuadrado1.altura = 2.0;
		
		Assertions.assertEquals(cuadrado1.calcularArea(), 2.0);
		
	}
	
	@DisplayName("Dado un triangulo y cuadrado, validar que el calculo de área sea distinto")
	@Test
	void testArea() {
		
		Cuadrado cuadrado1 = new Cuadrado();
		
		cuadrado1.base = 2.0;
		cuadrado1.altura = 2.0;
		
		Triangulo triangulo1 = new Triangulo();
		
		triangulo1.base = 2.0;
		triangulo1.altura = 2.0;
		
		Assertions.assertNotEquals(cuadrado1.calcularArea(), triangulo1.calcularArea());
		
	}

}
