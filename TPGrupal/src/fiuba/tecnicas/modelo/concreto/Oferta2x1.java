package fiuba.tecnicas.modelo.concreto;

import java.util.Iterator;

import fiuba.tecnicas.modelo.general.Compra;
import fiuba.tecnicas.modelo.general.Descuento;
import fiuba.tecnicas.modelo.general.ItemCompra;
import fiuba.tecnicas.modelo.general.Oferta;

public class Oferta2x1 extends Oferta{	
	
	private double precioPares = 0;
	private double precioImpares = 0;

	public Oferta2x1()
	{
		this.precioPares = 0;
		this.precioImpares = 0;
	}

	@Override
	public void doCalcularDescuetos(Compra compra) {
		Iterator<ItemCompra> it = compra.getItems().iterator();
		ItemCompra item;
		double valorDescuento = 0;

		while(it.hasNext()){
			item = it.next();				

			
			//if ( item.getProducto().getDescripcion() == "Coca") {					

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
			//}
		}

		compra.addDescuento(new Descuento(valorDescuento,"2 x 1"));
		Inicializame();

	}

	private void Inicializame() {
		this.precioImpares = 0;
		this.precioPares = 0;
	}
}
