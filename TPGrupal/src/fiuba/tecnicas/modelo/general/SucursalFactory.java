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
	
	public static Sucursal SucursalDos(){
		Sucursal sucursal = new Sucursal();
		
		Oferta oferta = OfertaFactory.getInstance().ConstruiOferta("Oferta2x1");
		sucursal.setNext(oferta);
		
		return sucursal;
	}
	
	public static Sucursal SucursalTres(){
		Sucursal sucursal = new Sucursal();
		
		Oferta oferta = OfertaFactory.getInstance().ConstruiOferta("Oferta10porcientoTarjeta");
		sucursal.setNext(oferta);
		
		return sucursal;
	}
}
