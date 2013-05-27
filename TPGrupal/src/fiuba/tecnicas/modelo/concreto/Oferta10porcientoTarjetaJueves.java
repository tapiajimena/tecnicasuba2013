package fiuba.tecnicas.modelo.concreto;

import java.util.Iterator;

import fiuba.tecnicas.modelo.general.Compra;
import fiuba.tecnicas.modelo.general.Descuento;
import fiuba.tecnicas.modelo.general.ItemCompra;
import fiuba.tecnicas.modelo.general.Oferta;
import fiuba.tecnicas.modelo.general.TipoPago;

public class Oferta10porcientoTarjetaJueves extends Oferta{
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
			if(compra.getMedioDePago().getTipoPago().equals(TipoPago.TARJETA) && compra.getDiaDeCompra()==5){
				valorDescuento += 0.1*item.getProducto().getPrecio()*item.getCantidad();
				
				item.setPrecioFinal((item.getProducto().getPrecio() - 0.1*item.getProducto().getPrecio())*item.getCantidad());
			}
		}
		compra.addDescuento(new Descuento(valorDescuento,"10% Tarjeta los Jueves"));
		
		if (this.next != null){ 
			next.calcularDescuentos(compra); 
		}
	}

	@Override
	public Oferta getNext(){
		return this.next;
	}		
}
