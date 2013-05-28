package fiuba.tecnicas.modelo.concreto;

import java.util.Iterator;

import fiuba.tecnicas.modelo.general.Categoria;
import fiuba.tecnicas.modelo.general.Compra;
import fiuba.tecnicas.modelo.general.Descuento;
import fiuba.tecnicas.modelo.general.ItemCompra;
import fiuba.tecnicas.modelo.general.MedioDePago;
import fiuba.tecnicas.modelo.general.Oferta;
import fiuba.tecnicas.modelo.general.TipoPago;

public class Oferta10porcientoTarjeta extends Oferta{
		
	@Override
	public void doCalcularDescuetos(Compra compra) {
		double valorDescuento = 0;
		Iterator<ItemCompra> it = compra.getItems().iterator();
		ItemCompra item;
		while(it.hasNext()){
			item = it.next();	
			if(compra.getMedioDePago().getTipoPago().equals(TipoPago.TARJETA)){
				valorDescuento += 0.1*item.getProducto().getPrecio()*item.getCantidad();
				if (item.getPrecioFinal() == (item.getProducto().getPrecio()*item.getCantidad())){
					item.setPrecioFinal((item.getProducto().getPrecio() - 0.1*item.getProducto().getPrecio())*item.getCantidad());					
				}else{
					item.setPrecioFinal(item.getPrecioFinal() - 0.1*item.getProducto().getPrecio());
				}

			}
		}
		compra.addDescuento(new Descuento(valorDescuento,"10% descuento con Tarjeta"));
	}
}
