package fiuba.tecnicas.modelo.general;

import fiuba.tecnicas.modelo.concreto.OfertaGenerica;

public class SucursalFactory {

	
	public static Sucursal SucursalUno()
	{
		// Inyectar ofertas genericas
		Oferta o = new OfertaGenerica();
		
		// Retornar
		return new Sucursal(o);
	}
}
