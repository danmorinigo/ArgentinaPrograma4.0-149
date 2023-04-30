package org.argentinaprograma.tema7;

import static org.junit.jupiter.api.Assertions.assertEquals;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

import org.argentinaprograma.tema7.models.Carrito;
import org.argentinaprograma.tema7.models.ItemCarrito;
import org.argentinaprograma.tema7.models.Producto;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class PreciosTest {
	
	private Carrito carrito;
	private Double precioFinalTest = 0.0;
	private Producto[] producto;
	private ItemCarrito[] itemCarrito;
	
	@Before
	public void inicializar() {

		String archivoProductos = "src/main/java/org/argentinaprograma/tema7/resources/Productos.txt";
		Path pathProductos = Paths.get(archivoProductos);
		producto = new Producto[6];
		itemCarrito = new ItemCarrito[6];
			
		try {
			for(int i = 0; i < Files.readAllLines(pathProductos).size(); i++) {

				String [] linea = Files.readAllLines(pathProductos).get(i).split(",");
				producto[i] = new Producto();
				producto[i].setNombre(linea[0]);
				producto[i].setPrecio(Double.parseDouble(linea[1]));
				producto[i].setDescripcion(linea[2]);
					
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		//Armo 6 itemCarrito
				
		for(int i = 0; i < 6; i++) {
			itemCarrito[i] = new ItemCarrito(producto[(int)(Math.round(Math.random() * 5))], (int)(Math.round(Math.random() * 9) + 1));
		}
	
	}
	
	@After
	public void finalizar() {
		carrito.listarArticulos();
		System.out.println("SE USO AFTER. precioFinalTest: " + precioFinalTest);
	}
	
	private void armarCarrito() {
		System.out.println("Antes armar carrito");
		for(int i = 0; i < 6; i++) {
			carrito.agregar(itemCarrito[i]);
		}
		System.out.println("Despues armar carrito");
	}
	
	private Double conDosDecimales(Double valorARedondear) {
		return (double)(Math.round(valorARedondear * 100) / 100d);
	}

	@Test
	public void costoFinalBienCalculadoUsandoFor() {
	
		carrito = new Carrito();
		this.armarCarrito();
		
		for(ItemCarrito enCarrito : carrito.getItems()) {
			precioFinalTest += enCarrito.precio();
		}
		
		precioFinalTest = conDosDecimales(precioFinalTest);
		assertEquals(precioFinalTest, carrito.precioSinDescuento());
	}
	
	@Test
	public void costoFinalBienCalculadoUsandoIterator() {
		
		carrito = new Carrito();
		this.armarCarrito();
		
		Iterator<ItemCarrito> iterador = carrito.getItems().iterator();
		while(iterador.hasNext()) {
			ItemCarrito item = iterador.next();
			precioFinalTest += item.precio(); 
		}
		precioFinalTest = conDosDecimales(precioFinalTest);
		assertEquals(precioFinalTest, carrito.precioSinDescuento());
	}
	
	@Test
	public void costoFinalBienCalculadoUsandoMapeo() {
		
		carrito = new Carrito();
		this.armarCarrito();
		
		precioFinalTest = carrito.getItems().stream()
				.mapToDouble(item -> item.precio())
				.map(precio -> precio).sum();
		
		precioFinalTest = conDosDecimales(precioFinalTest);
		assertEquals(precioFinalTest, carrito.precioSinDescuento());
	}
	
	@Test
	public void costoFinalBienCalculadoUsandoMapeoDescuentoFijo() {
		double valorDelDescuento = 85.3;
		carrito = new Carrito("f", valorDelDescuento);
		this.armarCarrito();
		precioFinalTest = carrito.getItems().stream()
				.mapToDouble(item -> item.precio())
				.map(precio -> precio).sum();
		precioFinalTest = conDosDecimales(precioFinalTest);
		assertEquals((precioFinalTest - valorDelDescuento), carrito.precioConDescuento(),5);
	}
	
	@Test
	public void costoFinalBienCalculadoUsandoIteratorDescuentoFijo() {
		double valorDelDescuento = 35.3;
		carrito = new Carrito("f", valorDelDescuento);
		this.armarCarrito();
		Iterator<ItemCarrito> iterador = carrito.getItems().iterator();
		while(iterador.hasNext()) {
			ItemCarrito item = iterador.next();
			precioFinalTest += item.precio();
		}
		precioFinalTest = conDosDecimales(precioFinalTest);
		assertEquals((precioFinalTest - valorDelDescuento), carrito.precioConDescuento());
	}
	
	@Test
	public void costoFinalBienCalculadoUsandoIteratorDescuentoPorcentaje() {
		double valorDelDescuento = 5.0;
		carrito = new Carrito("%", valorDelDescuento);
		this.armarCarrito();
		Iterator<ItemCarrito> iterador = carrito.getItems().iterator();
		while(iterador.hasNext()) {
			ItemCarrito item = iterador.next();
			precioFinalTest += item.precio();
		}
		precioFinalTest = conDosDecimales(precioFinalTest);
		assertEquals((precioFinalTest - conDosDecimales(precioFinalTest * (valorDelDescuento/100))), carrito.precioConDescuento());
	}
	
	@Test
	public void costoFinalBienCalculadoUsandoForDescuentoPorcentaje() {
		double valorDelDescuento = 5.0;
		carrito = new Carrito("%", valorDelDescuento);
		this.armarCarrito();
		for(ItemCarrito item : carrito.getItems()) {
			precioFinalTest += item.precio();
		}
		precioFinalTest = conDosDecimales(precioFinalTest);
		assertEquals((precioFinalTest - conDosDecimales(precioFinalTest * (valorDelDescuento/100))), carrito.precioConDescuento());
		//assertEquals((precioFinalTest - (precioFinalTest * (conDosDecimales(valorDelDescuento/100)))), carrito.precioConDescuento());
	}
	

	@Test
	public void siAplicaDescuentoConTopeYElDescuentoEsMenorAlMaximoPermitidoSeAplicaElDescuentoPedido() {
		double porcentajeADescontar = 5.0;
		double topeDescuento = 100000.0;
		carrito = new Carrito(porcentajeADescontar, topeDescuento);
		this.armarCarrito();
		Iterator<ItemCarrito> items = carrito.getItems().iterator();
		while(items.hasNext()) {
			ItemCarrito item = items.next();
			precioFinalTest += item.precio();
		}
		precioFinalTest = conDosDecimales(precioFinalTest);
		assertEquals((precioFinalTest - conDosDecimales(precioFinalTest * (porcentajeADescontar/100))), carrito.precioConDescuento());
	}
	
	@Test
	public void siAplicaDescuentoConTopeYElDescuentoEsSuperiorAlMaximoPermitidoSeAplicaTopeDeDescuento() {
		double porcentajeADescontar = 50.0;
		double topeDescuento = 1.0;
		carrito = new Carrito(porcentajeADescontar, topeDescuento);
		this.armarCarrito();
		Iterator<ItemCarrito> items = carrito.getItems().iterator();
		while(items.hasNext()) {
			ItemCarrito item = items.next();
			precioFinalTest += item.precio();
		}
		precioFinalTest = conDosDecimales(precioFinalTest);
		assertEquals((precioFinalTest - topeDescuento), carrito.precioConDescuento());
	}

}
