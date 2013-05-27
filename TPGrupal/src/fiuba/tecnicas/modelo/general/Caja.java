package fiuba.tecnicas.modelo.general;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *	La Caja es un Singleton
 */
public class Caja {
	private static Caja INSTANCE;
	private String fechaDeApertura;
	//private Map<MedioDePago, Double> totalPorMedioDePago;
	private HashMap<Integer,Compra> comprasDeCaja;

    private Caja() {
    	this.comprasDeCaja = new HashMap<Integer,Compra>();
    }
 
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
			//this.setTotalPorMedioDePago(new HashMap<MedioDePago,Double>());
    }

	public double getTotalVentasCaja() {
		double totalVentas = 0;
		if (!this.comprasDeCaja.isEmpty()) {
			Iterator<Compra> it_Compra = this.comprasDeCaja.values().iterator();
			while (it_Compra.hasNext()) {
				totalVentas += it_Compra.next().getTotalCompra();
			}
		}
		return totalVentas;
	}

	public double getTotalDescuentosCaja() {
		double totalDescuentos = 0;
		if (!this.comprasDeCaja.isEmpty()) {
			Iterator<Compra> it_Compra = this.comprasDeCaja.values().iterator();
			while (it_Compra.hasNext()) {
				//totalDescuentos += it_Compra.next();
			}
		}
		return totalDescuentos;
	}

	public Map<MedioDePago, Double> getTotalPorMedioDePago() {
		return null;
	}

	public Map<Integer,Compra> getComprasDeCaja() {
		return comprasDeCaja;
	}
}
