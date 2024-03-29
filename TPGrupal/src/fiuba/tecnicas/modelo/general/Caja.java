package fiuba.tecnicas.modelo.general;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.Comparator;
import java.util.*;
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

	public String obtenerListaProductosCantidad(){
		Map<String, Integer> productos = new HashMap<String, Integer>();
		Iterator<Compra> it_Compra = getComprasDeCaja().iterator();
		ItemCompra item;
		while (it_Compra.hasNext()) {
			Iterator<ItemCompra> it = it_Compra.next().getItems().iterator();
			while (it.hasNext()) {
				item = it.next();
				Producto productoNuevo = item.getProducto();
				if (productoNuevo != null) {
					if (productos.containsKey(productoNuevo.getDescripcion())) {
						int cantidad = productos.get(productoNuevo.getDescripcion()) + item.getCantidad();
						productos.remove(productoNuevo.getDescripcion());
						productos.put(productoNuevo.getDescripcion(), cantidad);
					} else {
						productos.put(productoNuevo.getDescripcion(), item.getCantidad());
					}
				}
			}
		}
		
		return (sortByComparator(productos, false).entrySet().toString());
	}

    private static Map<String, Integer> sortByComparator(Map<String, Integer> unsortMap, final boolean order){

        List<Entry<String, Integer>> list = new LinkedList<Entry<String,Integer>>(unsortMap.entrySet());
        Collections.sort(list, new Comparator<Entry<String, Integer>>(){
            public int compare(Entry<String, Integer> o1,
                    Entry<String, Integer> o2){
                if (order){
                    return o1.getValue().compareTo(o2.getValue());
                }else{
                    return o2.getValue().compareTo(o1.getValue());
                }
            }
        });

        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        for (Entry<String, Integer> entry : list){
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }
}