package fiuba.tecnicas.test.presenter;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.io.IOException;
import org.junit.Test;

import fiuba.tecnicas.modelo.comun.Mensaje;
import fiuba.tecnicas.presentacion.DomainPresenter;
import fiuba.tecnicas.presentacion.DomainPresenter.IConsoleView;

public class ViewTest {

	@Test
	public void testInputCommandInexistente() throws IOException {
		//Mockeo la consola
		IConsoleView consola = mock(IConsoleView.class);		
		when(consola.getPresenter()).thenReturn(new DomainPresenter(consola));
		when(consola.getCommandFromInput()).thenReturn("comandoInvalido");
		
		DomainPresenter presenter = consola.getPresenter();
		
		assertEquals(presenter.getCommand(consola.getCommandFromInput()).execute("").getMensaje(),Mensaje.getMensaje("mensaje_ComandoInvalido"));
	}
	
	@Test
	public void testInputCommandAbrirCaja() throws IOException {
		//Mockeo la consola
		IConsoleView consola = mock(IConsoleView.class);		
		when(consola.getPresenter()).thenReturn(new DomainPresenter(consola));
		when(consola.getCommandFromInput()).thenReturn("Abrir Caja");
		
		DomainPresenter presenter = consola.getPresenter();
		
		assertEquals(presenter.getCommand(consola.getCommandFromInput()).execute("").getMensaje(),Mensaje.getMensaje("mensaje_AbrirCaja"));
	}

}
