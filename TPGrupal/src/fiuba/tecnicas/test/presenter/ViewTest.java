package fiuba.tecnicas.test.presenter;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.tecnicas.modelo.general.command.ICommand;
import fiuba.tecnicas.presentacion.ConsoleView;
import fiuba.tecnicas.presentacion.DomainPresenter;
import fiuba.tecnicas.presentacion.DomainPresenter.IConsoleView;

public class ViewTest {

	@Test
	public void test() {
		IConsoleView consola = new ConsoleView();
		DomainPresenter presenter = consola.getPresenter();
		String input = "ABRIR CAJA";
		
		ICommand c = presenter.getCommand(input);
		
		
		assertEquals(c.execute(input).getMensaje(),"Bienvenido!");
	}

}
