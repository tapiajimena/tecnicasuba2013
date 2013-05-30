package fiuba.tecnicas.modelo.concreto;

import java.util.Iterator;

import fiuba.tecnicas.modelo.general.Compra;
import fiuba.tecnicas.modelo.general.Descuento;
import fiuba.tecnicas.modelo.general.ItemCompra;
import fiuba.tecnicas.modelo.general.Oferta;
import fiuba.tecnicas.modelo.general.TipoPago;

public class Oferta10porcientoDebitoLunes extends Oferta{
	@Override
	public double doCalcularDescuentos(ItemCompra item, double valorDescuento) {
		if (item.getPrecioFinal() == (item.getProducto().getPrecio()*item.getCantidad())){
			item.setPrecioFinal((item.getProducto().getPrecio()*item.getCantidad() *0.90));
		}else{
			item.setPrecioFinal(item.getPrecioFinal() *0.90);
		}
		valorDescuento += (item.getPrecioFinal()/0.9)*0.1;
		return valorDescuento;
	}
}
