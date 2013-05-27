package fiuba.tecnicas.modelo.general;

import fiuba.tecnicas.modelo.concreto.Oferta10porcientoFarmacia;
import fiuba.tecnicas.modelo.concreto.Oferta10porcientoTarjeta;
import fiuba.tecnicas.modelo.concreto.Oferta10porcientoTarjetaJueves;
import fiuba.tecnicas.modelo.concreto.Oferta2x1;


public class SucursalFactory {

	public static Sucursal SucursalUno()
	{
		// Inyectar ofertas genericas

		Sucursal sucursal = new Sucursal();

		Oferta o10F = OfertaFactory.getInstance().ConstruiOferta("Oferta10porcientoFarmacia");
		sucursal.setNext(o10F);

		Oferta o2x1 = OfertaFactory.getInstance().ConstruiOferta("Oferta2x1");
		((Oferta10porcientoFarmacia)o10F).setNext(o2x1);

		Oferta o10T = OfertaFactory.getInstance().ConstruiOferta("Oferta10porcientoTarjeta");
		((Oferta2x1)o2x1).setNext(o10T);

		Oferta o10Tj = OfertaFactory.getInstance().ConstruiOferta("Oferta10porcientoTarjetaJueves");			
		((Oferta10porcientoTarjeta)o10T).setNext(o10Tj);

		return sucursal;
	}

	public static Sucursal SucursalDos(){
		Sucursal sucursal = new Sucursal();

		Oferta o10F = OfertaFactory.getInstance().ConstruiOferta("Oferta10porcientoFarmacia");
		sucursal.setNext(o10F);

		Oferta o2x1 = OfertaFactory.getInstance().ConstruiOferta("Oferta2x1");
		((Oferta10porcientoFarmacia)o10F).setNext(o2x1);

		Oferta o10T = OfertaFactory.getInstance().ConstruiOferta("Oferta10porcientoTarjeta");
		((Oferta2x1)o2x1).setNext(o10T);

		Oferta o10Tj = OfertaFactory.getInstance().ConstruiOferta("Oferta10porcientoTarjetaJueves");			
		((Oferta10porcientoTarjeta)o10T).setNext(o10Tj);

		return sucursal;
	}

	public static Sucursal SucursalTres(){
		Sucursal sucursal = new Sucursal();

		Oferta o10F = OfertaFactory.getInstance().ConstruiOferta("Oferta10porcientoFarmacia");
		sucursal.setNext(o10F);

		Oferta o2x1 = OfertaFactory.getInstance().ConstruiOferta("Oferta2x1");
		((Oferta10porcientoFarmacia)o10F).setNext(o2x1);

		Oferta o10T = OfertaFactory.getInstance().ConstruiOferta("Oferta10porcientoTarjeta");
		((Oferta2x1)o2x1).setNext(o10T);

		Oferta o10Tj = OfertaFactory.getInstance().ConstruiOferta("Oferta10porcientoTarjetaJueves");			
		((Oferta10porcientoTarjeta)o10T).setNext(o10Tj);

		return sucursal;
	}

	public static Sucursal SucursalCuatro(){
		Sucursal sucursal = new Sucursal();

		Oferta o2x1 = OfertaFactory.getInstance().ConstruiOferta("Oferta2x1");
		sucursal.setNext(o2x1);
		Oferta o10Tj = OfertaFactory.getInstance().ConstruiOferta("Oferta10porcientoTarjetaJueves");
		((Oferta2x1)o2x1).setNext(o10Tj);




		return sucursal;
	}
}
