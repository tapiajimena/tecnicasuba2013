package fiuba.tecnicas.modelo.concreto;

import java.util.Iterator;

import fiuba.tecnicas.modelo.general.Compra;
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
		while(it.hasNext()){
			item = it.next();	
			if ( item.getProducto().getDescripcion() == "Coca") {
				item.setPrecioFinal((item.getCantidad()/2)* item.getProducto().getPrecio());
				//item.setPrecioFinal((item.getProducto().getPrecio() - 0.1*item.getProducto().getPrecio())*item.getCantidad());
			}
		}
	
		if (this.next != null){ 
			next.calcularDescuentos(compra); 
		}
	}

	@Override
	public Oferta getNext(){
		return this.next;
	}
}
