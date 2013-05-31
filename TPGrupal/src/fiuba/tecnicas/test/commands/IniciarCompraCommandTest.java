package fiuba.tecnicas.test.commands;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.tecnicas.modelo.comun.Mensaje;
import fiuba.tecnicas.modelo.general.Caja;
import fiuba.tecnicas.modelo.general.SucursalFactory;
import fiuba.tecnicas.modelo.general.command.AbrirCajaCommand;
import fiuba.tecnicas.modelo.general.command.ICommand;
import fiuba.tecnicas.modelo.general.command.IniciarCompraCommand;

public class IniciarCompraCommandTest {

	@Test 
	public void testCommandIniciarCompraAgregaCompraValidaAperturaDeCaja() 
	{
		
		ICommand command = new IniciarCompraCommand();
		
		assertEquals(command.execute("").getMensaje(),Mensaje.getMensaje("error_ordenEjec_IniciarCompra"));
	}
	
	@Test 
	public void testCommandIniciarCompraAgregaCompraNuevaALaCaja() 
	{
		Caja.getInstance().abrir();
		Caja.getInstance().setSucursal(SucursalFactory.SucursalUno());
		ICommand command = new IniciarCompraCommand();
		command.execute("");
		
		assertNotNull(Caja.getInstance().getCompraActiva());
	
	}

}
