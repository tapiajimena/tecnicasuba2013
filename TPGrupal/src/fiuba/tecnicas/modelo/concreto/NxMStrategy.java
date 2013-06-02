package fiuba.tecnicas.modelo.concreto;

import fiuba.tecnicas.modelo.general.IOfertaStrategy;
import fiuba.tecnicas.modelo.general.ItemCompra;

public class NxMStrategy implements IOfertaStrategy {
		private double n = 0;
		private double m = 0;

		@Override
		public double doCalcularDescuentos(ItemCompra item, double valorDescuento) {
			double aPagar = cantAPagar()*(int)(item.getCantidad()/this.n);
			valorDescuento = item.getProducto().getPrecio()*aPagar;
			
			item.setPrecioFinal(item.getCantidad()*item.getProducto().getPrecio()-valorDescuento);
			
			return valorDescuento;
		}
		
		private double cantAPagar(){
			return (this.n-this.m);
		}
		public double getN() {
			return n;
		}

		public void setN(double n) {
			this.n = n;
		}

		public double getM() {
			return m;
		}

		public void setM(double m) {
			this.m = m;
		}
}
