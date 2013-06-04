package fiuba.tecnicas.modelo.general;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import fiuba.tecnicas.modelo.comun.Constante;
import fiuba.tecnicas.modelo.general.command.ICommand;


public class SucursalFactory {	
	public static Sucursal SucursalUno()
	{		
		Sucursal s = (Sucursal) SucursalFactory.getSucursalByName("uno");
		s.setDescripcion(Constante.getConstante("nombre_Sucursal_Uno"));
		
		return s;
	}		
	
	public static Sucursal SucursalDos()
	{
		Sucursal s = (Sucursal) SucursalFactory.getSucursalByName("dos");
		s.setDescripcion(Constante.getConstante("nombre_Sucursal_Dos"));
		
		return s;
	}
	
	public static Sucursal SucursalTres()
	{
		Sucursal s = (Sucursal) SucursalFactory.getSucursalByName("tres");
		s.setDescripcion(Constante.getConstante("nombre_Sucursal_Tres"));
		
		return s;
	}
	
	public static Sucursal SucursalSeis()
	{
		Sucursal s = (Sucursal) SucursalFactory.getSucursalByName("seis");
		s.setDescripcion(Constante.getConstante("nombre_Sucursal_Seis"));
		
		return s;
	}
	
	public static XmlBeanFactory getBeanFactory()
	{
		ClassPathResource c = new ClassPathResource("SpringTPGrupalSucursales.xml");
		return new XmlBeanFactory(c);
	}
	
	public static Sucursal getSucursalByName(String input) {
		Sucursal s;
		try
		{
		 	s = (Sucursal) SucursalFactory.getBeanFactory().getBean(getRealNameOfFromInput(input));
		}catch(Exception ex)
		{
			s = getNullSucursal();
		}
		
		return s;
	}
	
	private static Sucursal getNullSucursal()
	{
		return SucursalUno();
	}

	private static String getRealNameOfFromInput(String input)
	{		
		// le saco los espacios y lo pongo en minuscula.
		String p = input.toString().replaceAll(" ", "").toLowerCase().concat("Sucursal");
		return p;
	}

}
