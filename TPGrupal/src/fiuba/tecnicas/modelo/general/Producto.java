package fiuba.tecnicas.modelo.general;

import java.util.ArrayList;

public class Producto {

	private ArrayList<Categoria> categorias;
	private double precio;
	private String descripcion;
	
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Producto(double precio, String descripcion){
		this.categorias = new ArrayList<Categoria>();
		this.precio = precio;
		this.descripcion = descripcion;
	}
	
	public void addCategoria(Categoria categoria){
		this.categorias.add(categoria);
	}
	
}
