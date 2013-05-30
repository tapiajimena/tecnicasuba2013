package fiuba.tecnicas.modelo.general;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import fiuba.tecnicas.modelo.comun.Constante;


public class SucursalFactory {	
	public static Sucursal SucursalUno()
	{		
		Sucursal s = (Sucursal) SucursalFactory.getBeanFactory().getBean("SucursalConCadenaUno");
		s.setDescripcion(Constante.getConstante("nombre_Sucursal_Uno"));
		
		return s;
	}		
	
	public static Sucursal SucursalDos()
	{
		Sucursal s = (Sucursal) SucursalFactory.getBeanFactory().getBean("SucursalConCadenaDos");
		s.setDescripcion(Constante.getConstante("nombre_Sucursal_Dos"));
		
		return s;
	}
	
	public static Sucursal SucursalTres()
	{
		Sucursal s = (Sucursal) SucursalFactory.getBeanFactory().getBean("SucursalConCadenaTres");
		s.setDescripcion(Constante.getConstante("nombre_Sucursal_Tres"));
		
		return s;
	}
	
	public static XmlBeanFactory getBeanFactory()
	{
		ClassPathResource c = new ClassPathResource("SpringTPGrupalSucursales.xml");
		return new XmlBeanFactory(c);
	}
	
	public static Sucursal getSucursalByName(String input) {
		//TODO: No setea la descripcion, porque solo llama al bean. 
		//return (Sucursal) SucursalFactory.getBeanFactory().getBean(input);
		//TODO: Solo se ve la sucursal UNO
		Sucursal s = (Sucursal) SucursalFactory.getBeanFactory().getBean(getRealNameOfFromInput(input));
		s.setDescripcion(Constante.getConstante("nombre_Sucursal_Uno"));
		
		return s;
	}
	
	private static String getRealNameOfFromInput(String input)
	{		
		// le saco los espacios y lo pongo en minuscula.
		String p = input.toString().replaceAll(" ", "").toLowerCase().concat("Sucursal");
		return p;
	}

}
