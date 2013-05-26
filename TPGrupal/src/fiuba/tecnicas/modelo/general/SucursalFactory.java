package fiuba.tecnicas.modelo.general;

import fiuba.tecnicas.modelo.concreto.Oferta10porcientoFarmacia;


public class SucursalFactory {

	public static Sucursal SucursalUno()
	{
		// Inyectar ofertas genericas

		Sucursal sucursal = new Sucursal();
		
				
		Oferta o = OfertaFactory.getInstance().ConstruiOferta("Oferta10porcientoFarmacia");
		sucursal.setNext(o);

		return sucursal;
	}
}
