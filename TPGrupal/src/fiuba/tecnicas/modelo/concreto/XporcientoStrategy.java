package fiuba.tecnicas.modelo.concreto;
import fiuba.tecnicas.modelo.general.IOfertaStrategy;
import fiuba.tecnicas.modelo.general.ItemCompra;

public class XporcientoStrategy implements IOfertaStrategy {

	private double porcentaje;

	@Override
	public double doCalcularDescuentos(ItemCompra item, double valorDescuento) {
		
		valorDescuento += getFactorPorcentual()*item.getProducto().getPrecio()*item.getCantidad();
		if (item.getPrecioFinal() == (item.getProducto().getPrecio()*item.getCantidad()))
			item.setPrecioFinal((item.getProducto().getPrecio() - getFactorPorcentual()*item.getProducto().getPrecio())*item.getCantidad());					
		else
			item.setPrecioFinal(item.getPrecioFinal() - getFactorPorcentual()*item.getProducto().getPrecio());

		return valorDescuento;
	}
	
	private double getFactorPorcentual()
	{
		double r = (getPorcentaje() / 100);
		return r;
	}

	public double getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(double porcentaje) {
		this.porcentaje = porcentaje;
	}
}