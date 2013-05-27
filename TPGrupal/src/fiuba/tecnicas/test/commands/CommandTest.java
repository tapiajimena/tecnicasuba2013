package fiuba.tecnicas.test.commands;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Test;

import fiuba.tecnicas.modelo.general.Caja;
import fiuba.tecnicas.modelo.general.command.AbrirCajaCommand;
import fiuba.tecnicas.modelo.general.command.ICommand;

public class CommandTest {

	@Test 
	public void testCommandAbrirCajaInicializaCaja() 
	{
		ICommand command = new AbrirCajaCommand();
		command.execute("");
		
    	Calendar cal = Calendar.getInstance();
    	cal.add(Calendar.DATE, 1);
    	SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
    	String fechaActual = format1.format(cal.getTime());  
		
		assertEquals(Caja.getInstance().getFechaDeApertura(),fechaActual);
	
	}
}
