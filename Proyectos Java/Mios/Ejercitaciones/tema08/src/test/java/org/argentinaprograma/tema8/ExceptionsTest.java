package org.argentinaprograma.tema8;

import org.argentinaprograma.tema8.exceptions.CostoCarritoEsCeroException;
import org.argentinaprograma.tema8.exceptions.DescuentoNoIdentificadoException;
import org.argentinaprograma.tema8.exceptions.MontoMenorADescuentoException;
import org.argentinaprograma.tema8.models.Carrito;
import org.argentinaprograma.tema8.models.Producto;
import org.argentinaprograma.tema8.models.ItemCarrito;
import org.junit.Test;


public class ExceptionsTest extends Exception{
	
	@Test(expected = CostoCarritoEsCeroException.class)
	public void SiCostoCarritoEsCeroLanzaExcepcion() throws DescuentoNoIdentificadoException, CostoCarritoEsCeroException {
		Carrito carrito = new Carrito("%", 50);
		Double costo = carrito.precioSinDescuento();
	}
	
	@Test(expected = DescuentoNoIdentificadoException.class)
	public void SiSeDesconoceTipoDescuentoLanzaExcepcion() throws DescuentoNoIdentificadoException, CostoCarritoEsCeroException {
		Carrito carrito = new Carrito("p", 50);
	}
	
	@Test(expected = MontoMenorADescuentoException.class)
	public void SiElMontoEsMenorAlDescuentoEnDescuentoPorcentajeLanzaExcepcion() throws DescuentoNoIdentificadoException, CostoCarritoEsCeroException, MontoMenorADescuentoException {
		Producto arroz = new Producto("Arroz", 100.0);
		ItemCarrito item = new ItemCarrito(arroz, 2);
		Carrito carrito = new Carrito("%", 150);
		carrito.agregar(item);
		Double aPagar = carrito.precioConDescuento();
	}
	
	@Test(expected = MontoMenorADescuentoException.class)
	public void SiElMontoEsMenorAlDescuentoEnDescuentoFijoLanzaExcepcion() throws DescuentoNoIdentificadoException, CostoCarritoEsCeroException, MontoMenorADescuentoException {
		Producto arroz = new Producto("Arroz", 100.0);
		ItemCarrito item = new ItemCarrito(arroz, 2);
		Carrito carrito = new Carrito("f", 350);
		carrito.agregar(item);
		Double aPagar = carrito.precioConDescuento();
	}
	
	@Test(expected = MontoMenorADescuentoException.class)
	public void SiElMontoEsMenorAlDescuentoEnDescuentoPorcentajeConTopeLanzaExcepcion() throws DescuentoNoIdentificadoException, CostoCarritoEsCeroException, MontoMenorADescuentoException {
		Producto arroz = new Producto("Arroz", 100.0);
		ItemCarrito item = new ItemCarrito(arroz, 2);
		Carrito carrito = new Carrito(150, 350);
		carrito.agregar(item);
		Double aPagar = carrito.precioConDescuento();
	}
}
