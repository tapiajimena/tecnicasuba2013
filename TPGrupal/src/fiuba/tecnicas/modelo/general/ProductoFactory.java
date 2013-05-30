package fiuba.tecnicas.modelo.general;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class ProductoFactory {

	private static ProductoFactory INSTANCE_ProdutoFactory;
	private static XmlBeanFactory PRODUCTO_FACTORY;
	
	private ProductoFactory()
	{
		ClassPathResource c = new ClassPathResource("SpringTPGrupalProducto.xml");
		PRODUCTO_FACTORY = new XmlBeanFactory(c);
	}
	
	public static ProductoFactory getInstance()
	{
		if(INSTANCE_ProdutoFactory == null)
			INSTANCE_ProdutoFactory = new ProductoFactory();
		
		return INSTANCE_ProdutoFactory;
		
	}
	
	public Producto getProducto(String codigo)
	{
		Producto producto = null;
		try
		{
			producto = (Producto)PRODUCTO_FACTORY.getBean(codigo.toUpperCase());
		}
		catch(Exception exp)
		{
			
		}
		
		return producto;
	}
	
//	private String getRealNameOfCommandFromInput(String input)
//	{		
//		// le saco los espacios y lo pongo en minuscula.
//		String p = input.toString().replaceAll(" ", "").toLowerCase().concat("command");
//		return p;
//	}
}
