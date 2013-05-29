package fiuba.tecnicas.test.commands;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;

import org.junit.Test;

import fiuba.tecnicas.modelo.comun.Mensaje;
import fiuba.tecnicas.modelo.general.Caja;
import fiuba.tecnicas.modelo.general.ItemCompra;
import fiuba.tecnicas.modelo.general.Producto;
import fiuba.tecnicas.modelo.general.command.AbrirCajaCommand;
import fiuba.tecnicas.modelo.general.command.AgregarProductosCommand;
import fiuba.tecnicas.modelo.general.command.ICommand;
import fiuba.tecnicas.modelo.general.command.IniciarCompraCommand;

public class AgregarProductosCommandTest {

	@Test 
	public void testCommandAgregarProductosProductoNuevo() 
	{
		ICommand commandAbrirCaja = new AbrirCajaCommand();
		commandAbrirCaja.execute("");
		ICommand commandIniciarCompraCommand = new IniciarCompraCommand();
		commandIniciarCompraCommand.execute("");
		ICommand command = new AgregarProductosCommand();
		command.execute("BGAA");
		
		List<ItemCompra> items = Caja.getInstance().getCompraActiva().getItems();
		
		assertEquals(items.get(0).getProducto().getCodigo_producto(),"0000");
	
	}

	@Test 
	public void testCommandAgregarProductosProductosNuevos() 
	{
		ICommand commandAbrirCaja = new AbrirCajaCommand();
		commandAbrirCaja.execute("");
		ICommand commandIniciarCompraCommand = new IniciarCompraCommand();
		commandIniciarCompraCommand.execute("");
		ICommand command = new AgregarProductosCommand();
		command.execute("BGAA,BFAA,BVAA");
		
		List<ItemCompra> items = Caja.getInstance().getCompraActiva().getItems();
		
		assertTrue(items.size() == 3);
	
	}
	
	@Test 
	public void testCommandAgregarProductosProductoRepetido() 
	{
		ICommand commandAbrirCaja = new AbrirCajaCommand();
		commandAbrirCaja.execute("");
		ICommand commandIniciarCompraCommand = new IniciarCompraCommand();
		commandIniciarCompraCommand.execute("");
		ICommand command = new AgregarProductosCommand();
		command.execute("BGAA,BGAA");
		
		List<ItemCompra> items = Caja.getInstance().getCompraActiva().getItems();
		
		assertTrue(items.get(0).getCantidad() == 2);
	
	}
	
	@Test 
	public void testCommandAgregarProductosProductoCodigoVacio() 
	{
		ICommand commandAbrirCaja = new AbrirCajaCommand();
		commandAbrirCaja.execute("");
		ICommand commandIniciarCompraCommand = new IniciarCompraCommand();
		commandIniciarCompraCommand.execute("");
		ICommand command = new AgregarProductosCommand();
		
		
		assertEquals(command.execute("").getMensaje(),Mensaje.getMensaje("mensaje_inicializar_compra"));
	
	}


}
