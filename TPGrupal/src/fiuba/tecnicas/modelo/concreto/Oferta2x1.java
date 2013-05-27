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
		double precioPares = 0;
		double precioImpares = 0;

		while(it.hasNext()){
			item = it.next();				

			if ( item.getProducto().getDescripcion() == "Coca") {					

				precioPares = (int)item.getCantidad()/2 * item.getProducto().getPrecio();
				precioImpares = item.getProducto().getPrecio() * (item.getCantidad() - 2 * ((int) item.getCantidad()/2));
				valorDescuento += precioPares;
				if (item.getPrecioFinal() == (item.getProducto().getPrecio()*item.getCantidad())){
					item.setPrecioFinal(precioPares + precioImpares);
				}else {
					precioPares = (int)item.getCantidad()/2 * (item.getPrecioFinal()/2);
					precioImpares = (item.getPrecioFinal()/2) * (item.getCantidad() - 2 * ((int) item.getCantidad()/2));
					item.setPrecioFinal(precioPares + precioImpares);
				}
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
