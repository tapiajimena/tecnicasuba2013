package fiuba.tecnicas.modelo.general;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import fiuba.tecnicas.modelo.general.command.CommandFactory;
import fiuba.tecnicas.modelo.general.command.ICommand;



public class ProductoFactory {

	private static ProductoFactory INSTANCE;
	private static XmlBeanFactory BEAN_FACTORY;
	
	private ProductoFactory()
	{
		ClassPathResource c = new ClassPathResource("SpringTPGrupalProducto.xml");
		BEAN_FACTORY = new XmlBeanFactory(c);
	}
	
	public static ProductoFactory getInstance()
	{
		if(INSTANCE == null)
			INSTANCE = new ProductoFactory();
		
		return INSTANCE;
		
	}
	
	public Producto getProducto(String codigo)
	{
		Producto producto;
		producto = (Producto)BEAN_FACTORY.getBean(codigo);
		return producto;
	}
	
//	private String getRealNameOfCommandFromInput(String input)
//	{		
//		// le saco los espacios y lo pongo en minuscula.
//		String p = input.toString().replaceAll(" ", "").toLowerCase().concat("command");
//		return p;
//	}
}
