package fiuba.tecnicas.modelo.concreto;

import fiuba.tecnicas.modelo.general.Compra;
import fiuba.tecnicas.modelo.general.ItemCompra;
import fiuba.tecnicas.modelo.general.Oferta;

public class OfertaGenerica extends Oferta {

	@Override
	public double doCalcularDescuentos(ItemCompra item, double valorDescuento) {
		return 0;
	}

}
