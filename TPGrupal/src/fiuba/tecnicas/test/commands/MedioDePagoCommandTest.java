package fiuba.tecnicas.test.commands;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.tecnicas.modelo.comun.Mensaje;
import fiuba.tecnicas.modelo.general.Caja;
import fiuba.tecnicas.modelo.general.MedioDePago;
import fiuba.tecnicas.modelo.general.Sucursal;
import fiuba.tecnicas.modelo.general.SucursalFactory;
import fiuba.tecnicas.modelo.general.TipoPago;
import fiuba.tecnicas.modelo.general.command.ICommand;
import fiuba.tecnicas.modelo.general.command.MedioDePagoCommand;

public class MedioDePagoCommandTest {
	
	@Test 
	public void testCommandMedioDePagoEjecucionPosteriorIniciarCompra() 
	{	 
		Caja.getInstance().abrir();
		ICommand command = new MedioDePagoCommand();
		
		assertEquals(command.execute("TARJETA,ICBC").getMensaje(),Mensaje.getMensaje("error_ordenEjec_MedioPago"));
	}
	
	@Test 
	public void testCommandMedioDePagoSeteaMedioDePagoEnCompra() 
	{
		Caja.getInstance().abrir();
		Sucursal sucursal = SucursalFactory.SucursalUno();
		Caja.getInstance().addNuevaCompraActiva(sucursal);		
		ICommand command = new MedioDePagoCommand();
		
		command.execute("TARJETA,ICBC Bank");
		
		MedioDePago mediodepago = new MedioDePago(TipoPago.TARJETA, "ICBC Bank","false");
		
		assertEquals(Caja.getInstance().getCompraActiva().getMedioDePago().toString(),mediodepago.toString());
	}
	
	@Test 
	public void testCommandMedioDePagoNoIndicaMedioEnInput() 
	{
		Caja.getInstance().abrir();
		Sucursal sucursal = SucursalFactory.SucursalUno();
		Caja.getInstance().addNuevaCompraActiva(sucursal);		
		ICommand command = new MedioDePagoCommand();
		
		assertEquals(command.execute("").getMensaje(),Mensaje.getMensaje("error_param_MedioPago"));
	}
}
