package fiuba.tecnicas.test.presenter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fiuba.tecnicas.presentacion.ConsoleView;
import fiuba.tecnicas.presentacion.DomainPresenter;
import fiuba.tecnicas.presentacion.DomainPresenter.IConsoleView;
import fiuba.tecnicas.presentacion.IView;

public class PresenterTest {

	@Test
	public void testAbrirCajaMuestraEstadoCaja() {
		IConsoleView consola = new ConsoleView();
		DomainPresenter presenter = consola.getPresenter();
		
		presenter.abrirCaja();
		assertEquals(consola.getMensaje(),"Bienvenido!");
	}
	
	
	
	public void testCargarProductos(){
		IView consola = new ConsoleView();
		String[] productos = { "1", "2", "3"};
		
		assertEquals("","");
	}
	
	public void testObtenerMontoTotalCompra(){
	}

}
