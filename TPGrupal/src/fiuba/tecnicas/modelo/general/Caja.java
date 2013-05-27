package fiuba.tecnicas.modelo.general;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import fiuba.tecnicas.modelo.servicios.ServicioCalendario;

/**
 *	La Caja es un Singleton
 */
public class Caja {
	
	private static Caja INSTANCE;
	private String fechaDeApertura;
	//private Map<Double, MedioDePago> totalPorMedioDePago;
	private HashMap<Boolean,Compra> comprasDeCaja;

    private Caja() {
    	this.comprasDeCaja = new HashMap<Boolean,Compra>();
    }
 
    private void setFechaDeHoy() {
    	this.fechaDeApertura = ServicioCalendario.fechaDeHoy(); 	
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
				totalDescuentos += it_Compra.next().getTotalDescuentosEnCompra();
			}
		}
		return totalDescuentos;
	}

	public Map<Double,MedioDePago> getTotalPorMedioDePago() {
		//TODO:getTotalPorMedioDePago
		return null;
	}

	public Map<Boolean,Compra> getComprasDeCaja() {
		return comprasDeCaja;
	}
	
	public List<Compra> getListaComprasDeCaja() {
		return (List<Compra>)comprasDeCaja.values();
	}
	
	//Solamente puede haber una compra activa por caja a la vez
	public Compra getCompraActiva() {
		return this.comprasDeCaja.get(true);
	}
	
	public void addNuevaCompraActiva(Sucursal sucursal) {
		this.comprasDeCaja.put(true, new Compra(sucursal));
	}
}
