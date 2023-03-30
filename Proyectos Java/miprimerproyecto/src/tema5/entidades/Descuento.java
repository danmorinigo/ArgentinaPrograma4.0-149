package tema5.entidades;

public abstract class Descuento {
	
	protected Double valor;

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	public abstract Double getValor();
	
	public abstract Double aplicarDescuento(Double monto);
	
}
