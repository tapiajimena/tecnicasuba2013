package fiuba.tecnicas.modelo.general;

import java.util.Iterator;

public class Sucursal {
	
	private Oferta chainOferta;
	private String descripcion;
	
	public void setNext(Oferta oferta){
		this.chainOferta = oferta;
	}
	
	public Sucursal()
	{
		
	}
	
	public Sucursal(String nombreSucursal) {
		this.setDescripcion(nombreSucursal);
	}

	public void CalcularDescuentos(Compra compra){
// Setteo todos los precios iniciales de cada item y luego aplico las ofertas.
		Iterator<ItemCompra> it = compra.getItems().iterator();
		ItemCompra item;
		while(it.hasNext()){
			item = it.next();	
			item.setPrecioFinal(item.getProducto().getPrecio()*item.getCantidad());
		}
		chainOferta.calcularDescuentos(compra);
	}
	
	public Oferta getNext(){
		return this.chainOferta;
	}
	
	public String toString() {
		return this.getDescripcion();
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
