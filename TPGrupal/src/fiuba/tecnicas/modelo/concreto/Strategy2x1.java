package fiuba.tecnicas.modelo.concreto;

import fiuba.tecnicas.modelo.general.IOfertaStrategy;
import fiuba.tecnicas.modelo.general.ItemCompra;

public class Strategy2x1 implements IOfertaStrategy{	
	
	private double precioPares = 0;
	private double precioImpares = 0;
	
	public Strategy2x1()
	{
		Inicializame();
	}

	public double doCalcularDescuentos(ItemCompra item, double valorDescuento) {
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

		return valorDescuento;
	}

	private void Inicializame() {
		this.precioImpares = 0;
		this.precioPares = 0;
	}
}
