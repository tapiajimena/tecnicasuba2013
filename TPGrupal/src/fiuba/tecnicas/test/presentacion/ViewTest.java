package fiuba.tecnicas.test.presentacion;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.io.IOException;
import org.junit.Test;

import fiuba.tecnicas.modelo.comun.Mensaje;
import fiuba.tecnicas.presentacion.ConsoleView;
import fiuba.tecnicas.presentacion.DomainPresenter;
import fiuba.tecnicas.presentacion.DomainPresenter.IConsoleView;

public class ViewTest {

	@Test
	public void testGetCommandFromInput() throws IOException {
		//Mockeo la consola
		ConsoleView consola = mock(ConsoleView.class);		
		when(consola.getInput()).thenReturn("comandoIngresado / p0001,p0002");
		when(consola.getCommandFromInput(consola.getInput())).thenCallRealMethod();
		
		assertEquals(consola.getCommandFromInput(consola.getInput()),"comandoIngresado");
	}
	
	@Test
	public void testGetParametersFromInput() throws IOException {
		//Mockeo la consola
		ConsoleView consola = mock(ConsoleView.class);		
		when(consola.getInput()).thenReturn("comandoIngresado / p0001,p0002");
		when(consola.getParametersFromInput(consola.getInput())).thenCallRealMethod();
		
		assertEquals(consola.getParametersFromInput(consola.getInput()),"p0001,p0002");
	}
	
	@Test
	public void testInputCommandInexistente() throws IOException {
		//Mockeo la consola
		IConsoleView consola = mock(IConsoleView.class);		
		when(consola.getPresenter()).thenReturn(new DomainPresenter(consola));
		when(consola.getCommandFromInput("")).thenReturn("comandoInvalido");
		
		DomainPresenter presenter = consola.getPresenter();
		
		assertEquals(presenter.getCommand(consola.getCommandFromInput("")).execute("").getMensaje(),Mensaje.getMensaje("mensaje_ComandoInvalido"));
	}
	
	@Test
	public void testInputCommandAbrirCaja() throws IOException {
		//Mockeo la consola
		IConsoleView consola = mock(IConsoleView.class);		
		when(consola.getPresenter()).thenReturn(new DomainPresenter(consola));
		when(consola.getCommandFromInput("")).thenReturn("Abrir Caja");
		
		DomainPresenter presenter = consola.getPresenter();
		
		assertEquals(presenter.getCommand(consola.getCommandFromInput("")).execute("").getMensaje(),Mensaje.getMensaje("mensaje_AbrirCaja"));
	}
	
	@Test
	public void testInputCommandAgregarProductos() throws IOException {
		//Mockeo la consola
		IConsoleView consola = mock(IConsoleView.class);		
		when(consola.getPresenter()).thenReturn(new DomainPresenter(consola));
		when(consola.getCommandFromInput("")).thenReturn("Agregar productos / p0000,p0001");
		when(consola.getParametersFromInput("")).thenReturn("p0000,p0001");
		
		DomainPresenter presenter = consola.getPresenter();
		
		assertEquals(presenter.getCommand(consola.getCommandFromInput("")).execute(consola.getParametersFromInput("")).getMensaje(),Mensaje.getMensaje("mensaje_AgregarProductos"));
	}


}
