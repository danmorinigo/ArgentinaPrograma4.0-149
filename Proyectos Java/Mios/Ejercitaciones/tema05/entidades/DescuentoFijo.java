package tema5.entidades;

public class DescuentoFijo extends Descuento {

	@Override
	public Double aplicarDescuento(Double monto) {

		return (monto - valor);
	}

	@Override
	public Double getValor() {
		
		return valor;
	}

}
