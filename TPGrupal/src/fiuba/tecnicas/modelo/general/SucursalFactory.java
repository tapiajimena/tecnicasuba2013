package fiuba.tecnicas.modelo.general;

import fiuba.tecnicas.modelo.concreto.Oferta10porciento;
import fiuba.tecnicas.modelo.concreto.Oferta20porciento;

public class SucursalFactory {

	public static Sucursal SucursalUno()
	{
		// Inyectar ofertas genericas

		Sucursal sucursal = new Sucursal();
		Oferta10porciento ofG10 = new Oferta10porciento();
		sucursal.setNext(ofG10);
		
		Oferta20porciento ofG20 = new Oferta20porciento();
		ofG10.setNext(ofG20);
		
		return sucursal;
	}
}
