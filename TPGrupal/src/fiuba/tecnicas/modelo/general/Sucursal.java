package fiuba.tecnicas.modelo.general;

import java.util.Iterator;

public class Sucursal {
	
	private Oferta chainOferta;
	
	public void setNext(Oferta oferta){
		this.chainOferta = oferta;
	}
	public Sucursal(){}

	public void CalcularDescuentos(Compra compra){
// Setteo todos los precios iniciales de cada item y luego aplico las ofertas.
		Iterator<ItemCompra> it = compra.iterator();
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
}
