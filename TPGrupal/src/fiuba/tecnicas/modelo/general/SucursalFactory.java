package fiuba.tecnicas.modelo.general;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import fiuba.tecnicas.modelo.comun.Constante;
import fiuba.tecnicas.modelo.concreto.Oferta10porcientoFarmacia;
import fiuba.tecnicas.modelo.concreto.Oferta10porcientoTarjeta;
import fiuba.tecnicas.modelo.concreto.Oferta10porcientoTarjetaJueves;
import fiuba.tecnicas.modelo.concreto.Oferta2x1;


public class SucursalFactory {
	
	
	
	public static Sucursal SucursalUno()
	{
		
		Sucursal s = (Sucursal) SucursalFactory.getBeanFactory().getBean("SucursalConCadenaUno");
		s.setDescripcion(Constante.getConstante("nombre_Sucursal_Uno"));
		
		/* ESTO SE MOVIO A SPRING PARA DARLE LA POSIBILIDAD DE CAMBIAR EN TIEMPO DE EJECUCION!!!
		 * 
		 * 
		Sucursal sucursal = new Sucursal(Constante.getConstante("nombre_Sucursal_Uno"));

		Oferta o10F = OfertaFactory.getInstance().ConstruiOferta("Oferta10porcientoFarmacia");
		sucursal.setNext(o10F);

		Oferta o2x1 = OfertaFactory.getInstance().ConstruiOferta("Oferta2x1");
		((Oferta10porcientoFarmacia)o10F).setNext(o2x1);

		Oferta o10T = OfertaFactory.getInstance().ConstruiOferta("Oferta10porcientoTarjeta");
		((Oferta2x1)o2x1).setNext(o10T);

		Oferta o10Tj = OfertaFactory.getInstance().ConstruiOferta("Oferta10porcientoTarjetaJueves");			
		((Oferta10porcientoTarjeta)o10T).setNext(o10Tj);
		*/
		
		return s;
	}

	public static Sucursal SucursalDos(){
		Sucursal s = (Sucursal) SucursalFactory.getBeanFactory().getBean("SucursalConCadenaUno");
		s.setDescripcion(Constante.getConstante("nombre_Sucursal_Dos"));
		
		/* ESTO SE MOVIO A SPRING PARA DARLE LA POSIBILIDAD DE CAMBIAR EN TIEMPO DE EJECUCION!!!
		 * 
		 * 
		
		Sucursal sucursal = new Sucursal(Constante.getConstante("nombre_Sucursal_Dos"));

		Oferta o10F = OfertaFactory.getInstance().ConstruiOferta("Oferta10porcientoFarmacia");
		sucursal.setNext(o10F);

		Oferta o2x1 = OfertaFactory.getInstance().ConstruiOferta("Oferta2x1");
		((Oferta10porcientoFarmacia)o10F).setNext(o2x1);

		Oferta o10T = OfertaFactory.getInstance().ConstruiOferta("Oferta10porcientoTarjeta");
		((Oferta2x1)o2x1).setNext(o10T);

		Oferta o10Tj = OfertaFactory.getInstance().ConstruiOferta("Oferta10porcientoTarjetaJueves");			
		((Oferta10porcientoTarjeta)o10T).setNext(o10Tj);
		
		return sucursal;
		*/
		
		return s;
	}

	public static Sucursal SucursalTres(){
		
		Sucursal s = (Sucursal) SucursalFactory.getBeanFactory().getBean("SucursalConCadenaUno");
		s.setDescripcion(Constante.getConstante("nombre_Sucursal_Tres"));
		
		/* ESTO SE MOVIO A SPRING PARA DARLE LA POSIBILIDAD DE CAMBIAR EN TIEMPO DE EJECUCION!!!
		 * 
		 * 
		Sucursal sucursal = new Sucursal(Constante.getConstante("nombre_Sucursal_Tres"));

		Oferta o10F = OfertaFactory.getInstance().ConstruiOferta("Oferta10porcientoFarmacia");
		sucursal.setNext(o10F);

		Oferta o2x1 = OfertaFactory.getInstance().ConstruiOferta("Oferta2x1");
		((Oferta10porcientoFarmacia)o10F).setNext(o2x1);

		Oferta o10T = OfertaFactory.getInstance().ConstruiOferta("Oferta10porcientoTarjeta");
		((Oferta2x1)o2x1).setNext(o10T);

		Oferta o10Tj = OfertaFactory.getInstance().ConstruiOferta("Oferta10porcientoTarjetaJueves");			
		((Oferta10porcientoTarjeta)o10T).setNext(o10Tj);

		return sucursal;
		*/
		
		return s;
	}

	public static Sucursal SucursalCuatro(){
		
		Sucursal s = (Sucursal) SucursalFactory.getBeanFactory().getBean("SucursalConCadenaCuatro");
		s.setDescripcion(Constante.getConstante("nombre_Sucursal_Cuatro"));
		
		/* ESTO SE MOVIO A SPRING PARA DARLE LA POSIBILIDAD DE CAMBIAR EN TIEMPO DE EJECUCION!!!
		 * 
		 * 
		Sucursal sucursal = new Sucursal(Constante.getConstante("nombre_Sucursal_Cuatro"));

		Oferta o2x1 = OfertaFactory.getInstance().ConstruiOferta("Oferta2x1");
		sucursal.setNext(o2x1);
		Oferta o10Tj = OfertaFactory.getInstance().ConstruiOferta("Oferta10porcientoTarjetaJueves");
		((Oferta2x1)o2x1).setNext(o10Tj);
		
		return sucursal;
		*/
		
		return s;



		
	}
	
	public static XmlBeanFactory getBeanFactory()
	{
		ClassPathResource c = new ClassPathResource("SpringTPGrupalSucursales.xml");
		return new XmlBeanFactory(c);
	}

}
