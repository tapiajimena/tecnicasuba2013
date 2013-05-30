package fiuba.tecnicas.modelo.concreto;

import fiuba.tecnicas.modelo.general.ItemCompra;
import fiuba.tecnicas.modelo.general.Oferta;

public class Oferta10porcientoTarjeta extends Oferta{
		
	@Override
	public double doCalcularDescuentos(ItemCompra item, double valorDescuento) {
		
		valorDescuento += 0.1*item.getProducto().getPrecio()*item.getCantidad();
		if (item.getPrecioFinal() == (item.getProducto().getPrecio()*item.getCantidad()))
			item.setPrecioFinal((item.getProducto().getPrecio() - 0.1*item.getProducto().getPrecio())*item.getCantidad());					
		else
			item.setPrecioFinal(item.getPrecioFinal() - 0.1*item.getProducto().getPrecio());

		return valorDescuento;
	}
}
