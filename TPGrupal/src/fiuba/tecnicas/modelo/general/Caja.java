package fiuba.tecnicas.modelo.general;

import java.util.Calendar;
import java.util.Date;

/**
 *	La Caja es un Singleton
 */
public class Caja {
	private static Caja INSTANCE;
	private Calendar fechaDeApertura;

    private Caja() {}
 
    private void setFechaDeHoy() {
    	Date date = new Date();
    	Calendar.getInstance();
    	this.fechaDeApertura.setTime(date);
    	this.fechaDeApertura.set(Calendar.HOUR_OF_DAY, 0);
    	this.fechaDeApertura.set(Calendar.MINUTE, 0);
    	this.fechaDeApertura.set(Calendar.SECOND, 0);
    	this.fechaDeApertura.set(Calendar.MILLISECOND, 0);
    }
    
    public static Caja getInstance() {
    	 if (INSTANCE == null) { 
             INSTANCE = new Caja();
         }
    	 return INSTANCE;
    }
    
    public void abrir() {
    	this.fechaDeApertura = Calendar.getInstance();
    	setFechaDeHoy();
    }
    
    public void cerrar() {}
    
}
