package fiuba.tecnicas.test.commands;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Test;

import fiuba.tecnicas.modelo.general.Caja;
import fiuba.tecnicas.modelo.general.SucursalFactory;
import fiuba.tecnicas.modelo.general.command.AbrirCajaCommand;
import fiuba.tecnicas.modelo.general.command.ICommand;
import fiuba.tecnicas.modelo.servicios.ServicioCalendario;

public class AbrirCajaCommandTest {

	@Test 
	public void testCommandAbrirCajaInicializaFechaDeCaja() 
	{
		ServicioCalendario.getInstancia().setNameDay("JUEVES");
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
		ServicioCalendario.getInstancia().setNameDay("JUEVES");
		ICommand command = new AbrirCajaCommand();
		command.execute("SucursalUNO");
		
		assertEquals(Caja.getInstance().getSucursal().getDescripcion(),SucursalFactory.SucursalUno().getDescripcion());
	
	}

}
