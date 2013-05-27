package fiuba.tecnicas.modelo.concreto;

import java.util.Iterator;

import fiuba.tecnicas.modelo.general.Compra;
import fiuba.tecnicas.modelo.general.Descuento;
import fiuba.tecnicas.modelo.general.ItemCompra;
import fiuba.tecnicas.modelo.general.Oferta;

public class Oferta2x1 extends Oferta{	
	private Oferta next;

	@Override
	public void setNext(Oferta oferta){
		this.next = oferta;
	}

	@Override
	public void calcularDescuentos (Compra compra){
		compra.setPosicionArray(0);
		Iterator<ItemCompra> it = compra.iterator();
		ItemCompra item;
		double valorDescuento = 0;
		
		while(it.hasNext()){
			item = it.next();				
			
			if ( item.getProducto().getDescripcion() == "Coca") {
				double precioPares = (int)item.getCantidad()/2 * item.getProducto().getPrecio();
				double precioImpares = item.getProducto().getPrecio() * (item.getCantidad() - 2 * ((int) item.getCantidad()/2));
				
				valorDescuento += precioPares;
				
				item.setPrecioFinal(precioPares + precioImpares);				
			}
		}
		compra.addDescuento(new Descuento(valorDescuento,"2 x 1"));
		
		if (this.next != null){ 
			next.calcularDescuentos(compra); 
		}
	}

	@Override
	public Oferta getNext(){
		return this.next;
	}
}
