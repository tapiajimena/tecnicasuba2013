package fiuba.tecnicas.modelo.concreto;
import java.util.Iterator;

import fiuba.tecnicas.modelo.general.Categoria;
import fiuba.tecnicas.modelo.general.Compra;
import fiuba.tecnicas.modelo.general.Descuento;
import fiuba.tecnicas.modelo.general.Oferta;
import fiuba.tecnicas.modelo.general.ItemCompra;

public class Oferta10porcientoFarmacia extends Oferta {

	private Oferta next;

	@Override
	public void setNext(Oferta oferta){
		this.next = oferta;
	}

	@Override
	public void calcularDescuentos (Compra compra){
		compra.setPosicionArray(0);
		double valorDescuento =0;
		Iterator<ItemCompra> it = compra.iterator();
		ItemCompra item;
		while(it.hasNext()){
			item = it.next();	
			if ( item.getProducto().getCategorias().equals(Categoria.FARMACIA)) {
				valorDescuento += 0.1*item.getProducto().getPrecio()*item.getCantidad();
				if (item.getPrecioFinal() == (item.getProducto().getPrecio()*item.getCantidad())){
					item.setPrecioFinal((item.getProducto().getPrecio() - 0.1*item.getProducto().getPrecio())*item.getCantidad());					
				}else{
					item.setPrecioFinal(item.getPrecioFinal() - 0.1*item.getProducto().getPrecio());
				}

			}
		}
		compra.addDescuento(new Descuento(valorDescuento,"10% Farmacia"));
		
		if (this.next != null){ 
			next.calcularDescuentos(compra); 
		}
	}

	@Override
	public Oferta getNext(){
		return this.next;
	}
}
