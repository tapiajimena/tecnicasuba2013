package fiuba.tecnicas.test.modelo;

import static org.junit.Assert.*;
import org.junit.Test;

import fiuba.tecnicas.modelo.comun.Constante;
import fiuba.tecnicas.modelo.general.Caja;
import fiuba.tecnicas.modelo.general.Compra;
import fiuba.tecnicas.modelo.general.SucursalFactory;
import fiuba.tecnicas.modelo.servicios.ServicioCalendario;

public class CajaTest {

	
	@Test
	public void testFechaDelDiaSeteadaCorrectamente() {
		Caja.getInstance().abrir();
		
		assertEquals(Caja.getInstance().getFechaDeApertura(),ServicioCalendario.fechaDeHoy());
	}
	
	@Test
	public void testaddNuevaCompraActiva() {
		Caja.getInstance().abrir();
		Caja.getInstance().addNuevaCompraActiva(SucursalFactory.SucursalUno());
		
		assertNotNull(Caja.getInstance().getCompraActiva());
		
	}
	
	@Test
	public void testCerrarCompraActiva() {
		Caja.getInstance().abrir();
		Caja.getInstance().addNuevaCompraActiva(SucursalFactory.SucursalUno());
		Caja.getInstance().cerrarCompraActiva();
		
		assertNull(Caja.getInstance().getCompraActiva());
		
	}

}
