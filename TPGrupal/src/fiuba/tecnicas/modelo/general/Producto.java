package fiuba.tecnicas.modelo.general;

public class Producto {

	private String codigo_producto;
	private Categoria categorias;
	private double precio;
	private String marca;
	private String descripcion;
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Producto() {}
	
	public Producto(double precio, String descripcion, String marca, Categoria categoria){
		this.categorias = categoria;
		this.precio = precio;
		this.marca = marca;
		this.descripcion = descripcion;
	}
	
//	public void addCategoria(Categoria categoria){
//		this.categorias.add(categoria);
//	}
	
//	public ArrayList<Categoria> getCategorias() {
//		return categorias;
//	}

//	public void setCategorias(ArrayList<Categoria> categorias) {
//		this.categorias = categorias;
//	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public double getPrecio() {
		return precio;
	}
	public Categoria getCategorias() {
		return categorias;
	}

	public void setCategorias(Categoria categorias) {
		this.categorias = categorias;
	}
	public String getCodigo_producto() {
		return codigo_producto;
	}

	public void setCodigo_producto(String codigoProducto) {
		codigo_producto = codigoProducto;
	}
}
