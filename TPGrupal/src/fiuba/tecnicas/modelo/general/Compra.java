package fiuba.tecnicas.modelo.general;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;

import fiuba.tecnicas.modelo.servicios.ServicioCalendario;

public class Compra {
	private ArrayList<ItemCompra> items;
	private MedioDePago medioDePago;
	private Sucursal sucursal;
	private double totalCompra;
	private ArrayList<Descuento> descuentos;
	private String diaDeCompra;
	private ArrayList<Caracteristica> caracteristicas;

	public Compra() {}
	
	public Compra(Sucursal sucursal) {
		this.totalCompra = 0.0;
		this.items = new ArrayList<ItemCompra>();
		this.diaDeCompra = ServicioCalendario.getTodayDayOfTheWeekToString();
		this.sucursal = sucursal;
		this.caracteristicas = new ArrayList<Caracteristica>();
		this.descuentos = new ArrayList<Descuento>();
		this.caracteristicas.add(new Caracteristica("COMPRA_DIA", getDiaDeCompra(), CaracteristicaAplicoA.COMPRA));
	}
	
	public void agregarItemsCompra(Set<Entry<Producto, Integer>> listaProductos) {	
		Iterator<Entry<Producto, Integer>> it_productosNuevos = listaProductos.iterator();
		while (it_productosNuevos.hasNext()) {
			Entry<Producto, Integer> productoNuevo = it_productosNuevos.next();
			ItemCompra itemNuevo = new ItemCompra(productoNuevo.getKey(), productoNuevo.getValue());
			if (!this.items.isEmpty() && this.getItems().contains(itemNuevo)) {
				int index = this.items.indexOf(itemNuevo);
				this.items.get(index).aumentarCantidad(productoNuevo.getValue());
			} else {
				this.addItem(itemNuevo);
			}
		}
	}
	
	public Sucursal getSucursal() {
		return this.sucursal;
	}

	public void setMedioDePago(String medioDePago, String banco, String isJubilado) {
		this.medioDePago = new MedioDePago(TipoPago.valueOf(medioDePago), banco, isJubilado);
		this.caracteristicas.add(new Caracteristica("MEDIODEPAGO_DESCRIPCION", medioDePago, CaracteristicaAplicoA.COMPRA));
		this.caracteristicas.add(new Caracteristica("MEDIODEPAGO_DESCRIPCION_ENTIDAD", banco, CaracteristicaAplicoA.COMPRA));
		this.caracteristicas.add(new Caracteristica("IS_JUBILADO", isJubilado, CaracteristicaAplicoA.COMPRA));
	}

	public void setMedioDePago(MedioDePago medioDePago) {
		this.medioDePago = medioDePago;
		this.caracteristicas.add(new Caracteristica("MEDIODEPAGO_DESCRIPCION", medioDePago.getTipoPago().toString(), CaracteristicaAplicoA.COMPRA));
		this.caracteristicas.add(new Caracteristica("MEDIODEPAGO_DESCRIPCION_ENTIDAD", medioDePago.getBanco(), CaracteristicaAplicoA.COMPRA));
		this.caracteristicas.add(new Caracteristica("IS_JUBILADO",medioDePago.getIsJubilado(), CaracteristicaAplicoA.COMPRA));
	}

	public double getTotalCompraSinDescuentos() {
		this.totalCompra = 0.0;
		Iterator<ItemCompra> it = this.items.iterator();
		while (it.hasNext()) {
			this.totalCompra += it.next().getPrecioFinal();
		}
		return this.totalCompra;
	}

	// Calcula monto total descontado en la compra
	public double getTotalDescuentosCompra() {
		double totalDescuentos = 0.0;
		Iterator<Descuento> it = this.descuentos.iterator();
		while (it.hasNext()) {
			totalDescuentos += it.next().getValor();
		}
		return totalDescuentos;
	}

	public MedioDePago getMedioDePago() {
		return this.medioDePago;
	}

	public ArrayList<ItemCompra> getItems() {
		return items;
	}

	public ArrayList<Descuento> getDescuentos() {
		return this.descuentos;
	}

	public String getDiaDeCompra() {

		return ServicioCalendario.getTodayDayOfTheWeekToString();
	}
	
	public void setDiaDeCompra(String dia)
	{
		diaDeCompra = dia;
	}

	
	public void addItem(ItemCompra item){
		
		items.add(item);
	}

	public void addDescuento(Descuento descuento) {
		descuentos.add(descuento);
	}

	public double CalcularTotal() {
		if(this.descuentos.isEmpty()) this.sucursal.CalcularDescuentos(this);
		Iterator<ItemCompra> it = this.items.iterator();
		double total = 0.0;
		while (it.hasNext()) {
			total += it.next().getPrecioFinal();
		}
		return total;
	}

	public ArrayList<Caracteristica> getCaracteristicas() {
		return caracteristicas;
	}
	
	public double getTotalCompra() {
		if (this.totalCompra == 0.0) return CalcularTotal();
		else return this.totalCompra;
	}

}
