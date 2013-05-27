package fiuba.tecnicas.test.commands;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import fiuba.tecnicas.modelo.general.Caja;
import fiuba.tecnicas.modelo.general.ItemCompra;
import fiuba.tecnicas.modelo.general.command.AbrirCajaCommand;
import fiuba.tecnicas.modelo.general.command.AgregarProductosCommand;
import fiuba.tecnicas.modelo.general.command.ICommand;
import fiuba.tecnicas.modelo.general.command.IniciarCompraCommand;
import fiuba.tecnicas.modelo.general.command.MedioDePagoCommand;
import fiuba.tecnicas.modelo.general.command.VerTotalDescuentosCajaCommand;

public class CommandTest {

	@Test 
	public void testCommandAbrirCajaInicializaFechaDeCaja() 
	{
		ICommand command = new AbrirCajaCommand();
		command.execute("");
		
    	Calendar cal = Calendar.getInstance();
    	SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
    	String fechaActual = format1.format(cal.getTime());  
		
		assertEquals(Caja.getInstance().getFechaDeApertura(),fechaActual);
	
	}
	
	@Test 
	public void testCommandAgregarProductos() 
	{
		ICommand commandAbrirCaja = new AbrirCajaCommand();
		commandAbrirCaja.execute("");
		ICommand commandIniciarCompraCommand = new IniciarCompraCommand();
		commandIniciarCompraCommand.execute("");
		ICommand command = new AgregarProductosCommand();
		command.execute("BG00");
		
		List<ItemCompra> items = Caja.getInstance().getCompraActiva().getItems();
		Iterator<ItemCompra> it_item = items.iterator();
		
		assertTrue(it_item.next().getProducto().getCodigo_producto() == "BGOO");
	
	}
	
	@Test 
	public void testCommandMedioDePagoSeteaMedioDePagoEnCompra() 
	{
		//TODO:
	
	}
	
	@Test 
	public void testCommandVerTotalDescuentosCaja() 
	{
		
		//TODO:
	
	}
	
	@Test 
	public void testCommandVerTotalCaja() 
	{
		//TODO:
	
	}
}
