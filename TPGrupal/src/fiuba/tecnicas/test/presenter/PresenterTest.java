package fiuba.tecnicas.test.presenter;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.mockito.Mockito.*;

import fiuba.tecnicas.modelo.general.Caja;
import fiuba.tecnicas.presentacion.ConsoleView;
import fiuba.tecnicas.presentacion.DomainPresenter;
import fiuba.tecnicas.presentacion.DomainPresenter.IConsoleView;
import fiuba.tecnicas.presentacion.IView;

public class PresenterTest {

	@Test
	public void testAbrirCajaIncializaCaja() {
		//Mockeo la consola
		IConsoleView consola = mock(IConsoleView.class);		
		when(consola.getPresenter()).thenReturn(new DomainPresenter(consola));
		when(consola.getCommandFromInput()).thenReturn("Abrir caja");
		
		DomainPresenter presenter = consola.getPresenter();
		presenter.abrirCaja();
		
		assertEquals("","");
		
	}

	public void testCargarProductos(){
		IView consola = new ConsoleView();
		String[] productos = { "1", "2", "3"};
		
	//	List mockedList = mock(List.class);
		
		assertEquals("","");
	}
	
	public void testObtenerMontoTotalCompra(){
	}

}
