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
			this.setTotalDescuentos(0);
			this.setTotalVentasCaja(0);
			this.setTotalPorMedioDePago(new HashMap<MedioDePago,Double>());
    }

	public int getTotalVentasCaja() {
		return totalVentasCaja;
	}

	public void setTotalVentasCaja(int totalVentasCaja) {
		this.totalVentasCaja = totalVentasCaja;
	}

	public double getTotalDescuentos() {
		return totalDescuentos;
	}

	public void setTotalDescuentos(double totalDescuentos) {
		this.totalDescuentos = totalDescuentos;
	}

	public Map<MedioDePago, Double> getTotalPorMedioDePago() {
		return totalPorMedioDePago;
	}

	public void setTotalPorMedioDePago(Map<MedioDePago, Double> totalPorMedioDePago) {
		this.totalPorMedioDePago = totalPorMedioDePago;
	}
    
}
