package fiuba.tecnicas.modelo.general;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 *	La Caja es un Singleton
 */
public class Caja {
	private static Caja INSTANCE;
	private String fechaDeApertura;
	private int totalVentasCaja;
	private double totalDescuentos;
	private Map<MedioDePago, Double> totalPorMedioDePago;

    private Caja() {}
 
    private void setFechaDeHoy() {
    	Calendar cal = Calendar.getInstance();
    	cal.add(Calendar.DATE, 1);
    	SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
    	this.fechaDeApertura = format1.format(cal.getTime());   	
    }
    
    public String getFechaDeApertura() {
    	return this.fechaDeApertura;
    }
    
    public static Caja getInstance() {
    	 if (INSTANCE == null) { 
             INSTANCE = new Caja();
         }
    	 return INSTANCE;
    }
    
    public void abrir() {
			setFechaDeHoy();
			this.totalDescuentos = 0;
			this.totalVentasCaja = 0;
			this.totalPorMedioDePago = new HashMap<MedioDePago,Double>();
    }
    
    public void cerrar() {}
    
}
