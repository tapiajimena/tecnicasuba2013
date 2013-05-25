package fiuba.tecnicas.modelo.general;

import fiuba.tecnicas.modelo.concreto.Oferta10porcientoFarmacia;


public class SucursalFactory {

	public static Sucursal SucursalUno()
	{
		// Inyectar ofertas genericas

		Sucursal sucursal = new Sucursal();
		Oferta10porcientoFarmacia ofG10 = new Oferta10porcientoFarmacia();
		sucursal.setNext(ofG10);

		return sucursal;
	}
}
