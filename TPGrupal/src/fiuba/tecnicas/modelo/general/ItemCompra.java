package fiuba.tecnicas.modelo.general;

public class ItemCompra {

	private Producto producto;
	private int cantidad;
	private double precioFinal;
	
	
	public ItemCompra(Producto producto, int cantidad){
		this.producto = producto;
		this.cantidad = cantidad;
	}


	public double getPrecioFinal() {
		// TODO Auto-generated method stub
		return precioFinal;
	}
}
