package fiuba.tecnicas.modelo.concreto;

import java.util.Iterator;

import fiuba.tecnicas.modelo.general.Compra;
import fiuba.tecnicas.modelo.general.Descuento;
import fiuba.tecnicas.modelo.general.ItemCompra;
import fiuba.tecnicas.modelo.general.Oferta;
import fiuba.tecnicas.modelo.general.TipoPago;

public class Oferta10porcientoTarjeta extends Oferta{
		
	@Override
	public double doCalcularDescuentos(ItemCompra item, double valorDescuento) {
		
		//	if(compra.getMedioDePago().getTipoPago().equals(TipoPago.TARJETA)){
				valorDescuento += 0.1*item.getProducto().getPrecio()*item.getCantidad();
				if (item.getPrecioFinal() == (item.getProducto().getPrecio()*item.getCantidad())){
					item.setPrecioFinal((item.getProducto().getPrecio() - 0.1*item.getProducto().getPrecio())*item.getCantidad());					
				}else{
					item.setPrecioFinal(item.getPrecioFinal() - 0.1*item.getProducto().getPrecio());
				}

			//}
		return valorDescuento;
	}
}
