package fiuba.tecnicas.modelo.servicios;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import fiuba.tecnicas.modelo.comun.Constante;
import fiuba.tecnicas.modelo.general.DiaSemana;

public class ServicioCalendario { 
	
	public static int getDayOfTheWeek(Date d){
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(d);
		return cal.get(Calendar.DAY_OF_WEEK);		
	}
	
	public static int getTodayDayOfTheWeek(){
		return getDayOfTheWeek(new Date());		
	}
	
	public static String getTodayDayOfTheWeekToString(){
		int numHoy = getTodayDayOfTheWeek();
		DiaSemana hoy = DiaSemana.values()[numHoy-1];
		return hoy.name();		
	}
	
    public static String fechaDeHoy() {
    	Calendar cal = Calendar.getInstance();
    	SimpleDateFormat format1 = new SimpleDateFormat(Constante.getConstante("formato_fechaDeCaja"));
    	return format1.format(cal.getTime());   	
    }
}
