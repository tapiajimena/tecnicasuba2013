package fiuba.tecnicas.modelo.general;

import fiuba.tecnicas.modelo.concreto.OfertaGenerica;

public class OfertaFactory {

	static Oferta ConstruiOferta(Sucursal sucursal)
	{
		return new OfertaGenerica();
	}
}
