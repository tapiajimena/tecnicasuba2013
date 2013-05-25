package fiuba.tecnicas.modelo.general;

public class ItemCompra {

	private Producto producto;
	private int cantidad;
	private double precioFinal;
	
	public Producto getProducto() {
		return producto;
	}


	public void setProducto(Producto producto) {
		this.producto = producto;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public void setPrecioFinal(double precioFinal) {
		this.precioFinal = precioFinal;
	}


	public ItemCompra(Producto producto, int cantidad){
		this.producto = producto;
		this.cantidad = cantidad;
	}


	public double getPrecioFinal() {
		return precioFinal;
	}
}
