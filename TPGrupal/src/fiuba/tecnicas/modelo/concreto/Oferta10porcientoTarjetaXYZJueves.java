package fiuba.tecnicas.modelo.concreto;

import java.util.Iterator;

import fiuba.tecnicas.modelo.general.Compra;
import fiuba.tecnicas.modelo.general.Descuento;
import fiuba.tecnicas.modelo.general.ItemCompra;
import fiuba.tecnicas.modelo.general.Oferta;
import fiuba.tecnicas.modelo.general.TipoPago;

public class Oferta10porcientoTarjetaXYZJueves extends Oferta{
	private Oferta next;

	@Override
	public double doCalcularDescuentos(ItemCompra item, double valorDescuento) {
		if (item.getPrecioFinal() == (item.getProducto().getPrecio()*item.getCantidad())){
			item.setPrecioFinal((item.getProducto().getPrecio() - 0.1*item.getProducto().getPrecio())*item.getCantidad());
			valorDescuento += 0.1*item.getProducto().getPrecio()*item.getCantidad();
		}else{
			item.setPrecioFinal(item.getPrecioFinal() - 0.1*item.getProducto().getPrecio());
			valorDescuento+=0.1*item.getProducto().getPrecio();
		}
		return valorDescuento;
	}
}
