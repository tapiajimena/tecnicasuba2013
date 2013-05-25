package fiuba.tecnicas.modelo.general;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import fiuba.tecnicas.modelo.concreto.OfertaGenerica;

public class OfertaFactory {

	private static OfertaFactory INSTANCE;
	private static XmlBeanFactory BEAN_FACTORY;
	
	private OfertaFactory()
	{
		ClassPathResource c = new ClassPathResource("SpringTPGrupalOfertas.xml");
		BEAN_FACTORY = new XmlBeanFactory(c);
	}
	
	public static OfertaFactory getInstance()
	{
		if(INSTANCE == null)
			INSTANCE = new OfertaFactory();
		
		return INSTANCE;
		
	}
	
	public static Oferta ConstruiOferta(Sucursal sucursal)
	{
		return (Oferta) BEAN_FACTORY.getBean("OfertaGenerica");
	}
	
	public Oferta ConstruiOferta(String nombre)
	{
		return (Oferta)BEAN_FACTORY.getBean(nombre);
	}
}
