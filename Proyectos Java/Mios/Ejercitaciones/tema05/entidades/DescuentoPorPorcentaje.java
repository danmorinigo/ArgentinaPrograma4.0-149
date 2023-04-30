package tema5.entidades;

public class DescuentoPorPorcentaje extends Descuento{

	@Override
	public Double aplicarDescuento(Double monto) {

		return (monto - (monto * (valor / 100.0)));
	}

	@Override
	public Double getValor() {
		
		return valor;
	}

	
}
