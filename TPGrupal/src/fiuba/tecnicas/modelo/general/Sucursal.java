package fiuba.tecnicas.modelo.general;

import java.util.Iterator;

public class Sucursal {
	
	private Oferta chainOferta;
	private String descripcion;
	
	public void setNext(Oferta oferta){
		this.chainOferta = oferta;
	}
		
	public Sucursal(String nombreSucursal) {
		this.setDescripcion(nombreSucursal);
	}
	
	public Sucursal(){
	}

	public void CalcularDescuentos(Compra compra){
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
