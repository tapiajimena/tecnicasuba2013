package fiuba.tecnicas.test.servicios;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;

import fiuba.tecnicas.modelo.general.DiaSemana;
import fiuba.tecnicas.modelo.servicios.ServicioCalendario;

public class ServiciosTest {

	@Test
	public void testGetTodayDayOfTheWeek() {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(new Date());
		int numHoy = cal.get(Calendar.DAY_OF_WEEK);
		DiaSemana hoy = DiaSemana.values()[numHoy];

		assertTrue(ServicioCalendario.getTodayDayOfTheWeek()==hoy.ordinal());
	}
	
	@Test
	public void testGetTodayDayOfTheWeekToString(){
		int numHoy = ServicioCalendario.getTodayDayOfTheWeek();
		DiaSemana hoy = DiaSemana.values()[numHoy-1];
		
		System.out.print(hoy.name());
		assertEquals(hoy.name(),ServicioCalendario.getTodayDayOfTheWeekToString());
	}

}
