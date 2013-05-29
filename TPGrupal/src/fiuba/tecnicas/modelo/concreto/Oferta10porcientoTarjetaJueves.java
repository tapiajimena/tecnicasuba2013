package fiuba.tecnicas.modelo.concreto;

import java.util.Iterator;

import fiuba.tecnicas.modelo.general.Compra;
import fiuba.tecnicas.modelo.general.Descuento;
import fiuba.tecnicas.modelo.general.ItemCompra;
import fiuba.tecnicas.modelo.general.Oferta;
import fiuba.tecnicas.modelo.general.TipoPago;

public class Oferta10porcientoTarjetaJueves extends Oferta{
	
	@Override
	public void doCalcularDescuetos(Compra compra) {
		
		Iterator<ItemCompra> it = compra.getItems().iterator();
		ItemCompra item;
		double valorDescuento = 0;
		while(it.hasNext()){
			item = it.next();	
			//if(compra.getMedioDePago().getTipoPago().equals(TipoPago.TARJETA) && compra.getDiaDeCompra()=="JUEVES"){
				valorDescuento += 0.1*item.getProducto().getPrecio()*item.getCantidad();
				if (item.getPrecioFinal() == (item.getProducto().getPrecio()*item.getCantidad())){
					item.setPrecioFinal((item.getProducto().getPrecio() - 0.1*item.getProducto().getPrecio())*item.getCantidad());					
				}else{
					item.setPrecioFinal(item.getPrecioFinal() - 0.1*item.getProducto().getPrecio());
				}

			//}
		}
		compra.addDescuento(new Descuento(valorDescuento,"10% Tarjeta los Jueves"));
		
	}		
}
