package fiuba.tecnicas.modelo.concreto;

import java.util.Iterator;

import fiuba.tecnicas.modelo.general.Categoria;
import fiuba.tecnicas.modelo.general.Compra;
import fiuba.tecnicas.modelo.general.Descuento;
import fiuba.tecnicas.modelo.general.IOfertaStrategy;
import fiuba.tecnicas.modelo.general.ItemCompra;
import fiuba.tecnicas.modelo.general.Oferta;

public class SegundaUnidadXPorcientoStrategy implements IOfertaStrategy{
	private double precioPares = 0;
	private double precioImpares = 0;
	private double porcentaje;

	public SegundaUnidadXPorcientoStrategy(){
		this.precioPares = 0;
		this.precioImpares = 0;
	}
	@Override
	public double doCalcularDescuentos(ItemCompra item, double valorDescuento) {
		precioPares = (int)item.getCantidad()/2 * item.getProducto().getPrecio()+(int)item.getCantidad()/2 * item.getProducto().getPrecio()*0.25;
		precioImpares = item.getProducto().getPrecio() * (item.getCantidad() - 2 * ((int) item.getCantidad()/2));
		valorDescuento += (int)item.getCantidad()/2 * item.getProducto().getPrecio()*0.75;
		if (item.getPrecioFinal() == (item.getProducto().getPrecio()*item.getCantidad())){
			item.setPrecioFinal(precioPares + precioImpares);
		}else {
			precioPares = (int)item.getCantidad()/2 * (item.getPrecioFinal()/2);
			precioImpares = (item.getPrecioFinal()/2) * (item.getCantidad() - 2 * ((int) item.getCantidad()/2));
			item.setPrecioFinal(precioPares + precioImpares);
		}
		return valorDescuento;
	}
	
	private double getFactorPorcentual()
	{
		return (porcentaje / 100);
	}
	
	public double getPorcentaje() {
		return porcentaje;
	}
	public void setPorcentaje(double porcentaje) {
		this.porcentaje = porcentaje;
	}

}
