package fiuba.tecnicas.modelo.servicios;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ServicioCalendario { 
	
	public static int getDayOfTheWeek(Date d){
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(d);
		return cal.get(Calendar.DAY_OF_WEEK);		
	}
	
	public static int getTodayDayOfTheWeek(){
		Calendar calendar = Calendar.getInstance();
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(calendar.getTime());
		return cal.get(Calendar.DAY_OF_WEEK);		
	}
	
    private static String fechaDeHoy() {
    	Calendar cal = Calendar.getInstance();
    	cal.add(Calendar.DATE, 1);
    	SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
    	return format1.format(cal.getTime());   	
    }
}
