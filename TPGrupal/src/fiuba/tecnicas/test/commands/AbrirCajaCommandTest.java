package fiuba.tecnicas.test.commands;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Test;

import fiuba.tecnicas.modelo.general.Caja;
import fiuba.tecnicas.modelo.general.SucursalFactory;
import fiuba.tecnicas.modelo.general.command.AbrirCajaCommand;
import fiuba.tecnicas.modelo.general.command.ICommand;

public class AbrirCajaCommandTest {

	@Test 
	public void testCommandAbrirCajaInicializaFechaDeCaja() 
	{
		ICommand command = new AbrirCajaCommand();
		command.execute("uno");
		
    	Calendar cal = Calendar.getInstance();
    	SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
    	String fechaActual = format1.format(cal.getTime());  
		
		assertEquals(Caja.getInstance().getFechaDeApertura(),fechaActual);
	
	}
	
	@Test 
	public void testCommandAbrirCajaSeteaSucursal() 
	{
		ICommand command = new AbrirCajaCommand();
		command.execute("uno");
		
		assertEquals(Caja.getInstance().getSucursal().getDescripcion(),SucursalFactory.SucursalUno().getDescripcion());
	
	}

}
