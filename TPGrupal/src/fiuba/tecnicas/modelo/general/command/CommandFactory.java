package fiuba.tecnicas.modelo.general.command;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import fiuba.tecnicas.modelo.concreto.OfertaGenerica;
import fiuba.tecnicas.modelo.general.Oferta;
import fiuba.tecnicas.modelo.general.Sucursal;

public class CommandFactory {

	private static CommandFactory INSTANCE;
	private static XmlBeanFactory BEAN_FACTORY;
	
	private CommandFactory()
	{
		ClassPathResource c = new ClassPathResource("SpringTPGrupalCommand.xml");
		BEAN_FACTORY = new XmlBeanFactory(c);
	}
	
	public static CommandFactory getInstance()
	{
		if(INSTANCE == null)
			INSTANCE = new CommandFactory();
		
		return INSTANCE;
		
	}
	
	public ICommand getCommand(String nombre)
	{
		ICommand comando;
		try
		{
			comando = (ICommand)BEAN_FACTORY.getBean(getRealNameOfCommandFromInput(nombre));
		}
		catch(Exception ex)
		{
			comando = getNullCommand();
		}
		
		return comando;
	}
	
	private ICommand getNullCommand()
	{
		return (ICommand)BEAN_FACTORY.getBean("nullcommand");
	}
	
	private String getRealNameOfCommandFromInput(String input)
	{		
		// le saco los espacios y lo pongo en minuscula.
		String p = input.toString().replaceAll(" ", "").toLowerCase().concat("command");
		return p;
	}
}
