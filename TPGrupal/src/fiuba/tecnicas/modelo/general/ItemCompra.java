package fiuba.tecnicas.modelo.general;

import java.util.ArrayList;

public class ItemCompra {

	private Producto producto;
	private int cantidad;
	private double precioFinal;
	private ArrayList<Caracteristica> caracteristicas;
	
	public ItemCompra() {}
	
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
		this.caracteristicas = new ArrayList<Caracteristica>();
		this.producto = producto;
		this.cantidad = cantidad;
		this.caracteristicas.add(new Caracteristica("PRODUCTO_DESCRIPCION", getProducto().getDescripcion()));
		this.caracteristicas.add(new Caracteristica("CATEGORIA_DESCRIPCION", getProducto().getCategorias().toString()));
	}

	public double getPrecioFinal() {
		return precioFinal;
	}

	public void aumentarCantidadUnidad() {
		this.cantidad++;
		
	}
}
