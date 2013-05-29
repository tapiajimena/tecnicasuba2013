package fiuba.tecnicas.modelo.general;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import fiuba.tecnicas.modelo.comun.Resultado;
import fiuba.tecnicas.modelo.servicios.ServicioCalendario;

/**
 *	La Caja es un Singleton
 */
public class Caja {
	
	private static Caja INSTANCE;
	private String fechaDeApertura;
	private Map<MedioDePago, Double> totalPorMedioDePago;
	private HashMap<Boolean,Compra> comprasDeCaja;
	private Sucursal sucursal;

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
			this.setTotalPorMedioDePago(new HashMap<MedioDePago,Double>());
    }

	public double getTotalVentasCaja() {
		double totalVentas = 0;
		if (!this.comprasDeCaja.isEmpty()) {
			Iterator<Compra> it_Compra = this.comprasDeCaja.values().iterator();
			while (it_Compra.hasNext()) {
				totalVentas += it_Compra.next().getTotalCompraConDescuentos();
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
		//TODO:getTotalPorMedioDePago LO HACE LUCAS, fijate que me parece que la clave,valor estan mal
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
	
	public Resultado addNuevaCompraActiva(Sucursal sucursal) {
		Resultado resultado = new Resultado(false);
		if(sucursal != null) {
			resultado.setExito(true);
			this.comprasDeCaja.put(true, new Compra(sucursal));
		}
		return resultado;
	}
	
	private void setTotalPorMedioDePago (Map<MedioDePago,Double> totalMedioPago){
		this.totalPorMedioDePago = totalMedioPago;
	}

	public Sucursal getSucursal() {
		return sucursal;
	}

	public void setSucursal(String sucursal) {
		//TODO: get sucursal con nombre amistoso por input de pantalla en el abrir caja
		this.sucursal = SucursalFactory.getSucursalByName(sucursal);
	}
}
