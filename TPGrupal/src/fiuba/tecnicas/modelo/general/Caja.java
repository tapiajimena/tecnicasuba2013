package fiuba.tecnicas.modelo.general;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import fiuba.tecnicas.modelo.comun.Resultado;
import fiuba.tecnicas.modelo.servicios.ServicioCalendario;

/**
 *	La Caja es un Singleton
 */
public class Caja {
	
	private static Caja INSTANCE;
	private String fechaDeApertura;
	private HashMap<String,Double> totalPorMedioDePago;
	private HashMap<Boolean,List<Compra>> comprasDeCaja;
	private Sucursal sucursal;

    private Caja() {
    	this.comprasDeCaja = new HashMap<Boolean,List<Compra>>();
    	this.totalPorMedioDePago = new HashMap<String,Double>();
    }
 
    private void setFechaDeApertura() {
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
			setFechaDeApertura();
			inicializarListaCompras();
    }
    
    private void inicializarListaCompras() {
    	List<Compra> compraActiva = new ArrayList<Compra>();
    	List<Compra> compraInactiva = new ArrayList<Compra>();
    	this.comprasDeCaja.put(false, compraActiva);
		this.comprasDeCaja.put(true, compraInactiva);
    }

	public double getTotalVentasCaja() {
		double totalVentas = 0;
		if (!this.comprasDeCaja.isEmpty()) {
			Iterator<Compra> it_Compra = getComprasDeCaja().iterator();
			while (it_Compra.hasNext()) {
				totalVentas += it_Compra.next().getTotalCompra();
			}
		}
		return totalVentas;
	}

	public double getTotalDescuentosCaja() {
		double totalDescuentos = 0;
		if (!this.comprasDeCaja.isEmpty()) {
			Iterator<Compra> it_Compra = getComprasDeCaja().iterator();
			while (it_Compra.hasNext()) {
				totalDescuentos += it_Compra.next().getTotalDescuentosCompra();
			}
		}
		return totalDescuentos;
	}
	
	public List<Compra> getComprasDeCaja() {
		List<Compra> compras = new ArrayList<Compra>();	
		Iterator<List<Compra>> it_ComprasCaja = this.comprasDeCaja.values().iterator();
		while (it_ComprasCaja.hasNext()) {
			compras.addAll(it_ComprasCaja.next());
		}
		return compras;
	}
	
	//Solamente puede haber una compra activa por caja a la vez
	public Compra getCompraActiva() {
		if (this.comprasDeCaja != null && this.comprasDeCaja.get(true) != null && !this.comprasDeCaja.get(true).isEmpty())
		return this.comprasDeCaja.get(true).get(0);
		else return null;
	}
	
	public Resultado addNuevaCompraActiva(Sucursal sucursal) {
		Resultado resultado = new Resultado(false);
		if(sucursal != null) {
			resultado.setExito(true);
			this.comprasDeCaja.get(true).clear();
			this.comprasDeCaja.get(true).add(new Compra(sucursal));
		}
		return resultado;
	}
	
	public void setTotalPorMedioDePago (HashMap<String, Double> mediosDePago){
		List<Compra> comprasDeCaja = this.getComprasDeCaja();

		if (comprasDeCaja != null && !comprasDeCaja.isEmpty()) {
			Iterator<Compra> it_comprasDeCaja = comprasDeCaja.iterator();

			while (it_comprasDeCaja.hasNext()) {
				Compra compra = it_comprasDeCaja.next();
				MedioDePago medioUsado = compra.getMedioDePago();
				if (mediosDePago.containsKey(medioUsado.getTipoPago().name())) {
					double totalAux = mediosDePago.get(medioUsado.getTipoPago().name());
					totalAux += compra.getTotalCompra();
					mediosDePago.remove(medioUsado);
					mediosDePago.put(medioUsado.getTipoPago().name(), totalAux);
				}
			}
		}
		this.totalPorMedioDePago = mediosDePago;
	}
	
	public HashMap<String, Double> getTotalPorMedioDePago (){
		return this.totalPorMedioDePago;
	}

	public Sucursal getSucursal() {
		return sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

	public void cerrarCompraActiva() {
		Compra compra = this.comprasDeCaja.get(true).get(0);
		this.comprasDeCaja.get(true).clear();
		this.comprasDeCaja.get(false).add(compra);
	}
}
