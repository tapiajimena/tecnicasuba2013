package fiuba.tecnicas.modelo.concreto;
import fiuba.tecnicas.modelo.general.IOfertaStrategy;
import fiuba.tecnicas.modelo.general.ItemCompra;

public class XporcientoStrategy implements IOfertaStrategy {

	private double porcentaje;

	@Override
	public double doCalcularDescuentos(ItemCompra item, double valorDescuento) {
		
		/*
		if (item.getPrecioFinal() == (item.getProducto().getPrecio()*item.getCantidad())){
			item.setPrecioFinal((item.getProducto().getPrecio() - getFactorPorcentual()*item.getProducto().getPrecio())*item.getCantidad());					
			valorDescuento += getFactorPorcentual() * item.getProducto().getPrecio() * item.getCantidad();
		}
		else{*/
			valorDescuento =  getFactorPorcentual() * item.getPrecioFinal();
			item.setPrecioFinal(item.getPrecioFinal() - valorDescuento);
		/*}*/
		
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