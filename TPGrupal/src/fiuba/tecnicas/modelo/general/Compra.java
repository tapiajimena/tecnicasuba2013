package fiuba.tecnicas.modelo.general;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fiuba.tecnicas.modelo.servicios.ServicioCalendario;

public class Compra {
	private ArrayList<ItemCompra> items;
	private MedioDePago medioDePago;
	private Sucursal sucursal;
	private double totalCompra;
	private ArrayList<Descuento> descuentos;
	private String diaDeCompra;
	private ArrayList<Caracteristica> caracteristicas;

	public Sucursal getSucursal() {
		return this.sucursal;
	}

	public void setMedioDePago(String medioDePago, String banco) {
		this.medioDePago = new MedioDePago(TipoPago.valueOf(medioDePago), banco);
		this.caracteristicas.add(new Caracteristica("MEDIODEPAGO_DESCRIPCION", medioDePago, CaracteristicaAplicoA.COMPRA));
		this.caracteristicas.add(new Caracteristica("MEDIODEPAGO_DESCRIPCION_ENTIDAD", banco, CaracteristicaAplicoA.COMPRA));

	}

	public void setMedioDePago(MedioDePago medioDePago) {
		this.medioDePago = medioDePago;
		this.caracteristicas.add(new Caracteristica("MEDIODEPAGO_DESCRIPCION", medioDePago.getTipoPago().toString(), CaracteristicaAplicoA.COMPRA));
		this.caracteristicas.add(new Caracteristica("MEDIODEPAGO_DESCRIPCION_ENTIDAD", medioDePago.getBanco(), CaracteristicaAplicoA.COMPRA));
	}

	public Compra(Sucursal sucursal) {
		this.items = new ArrayList<ItemCompra>();
		this.diaDeCompra = ServicioCalendario.getTodayDayOfTheWeekToString();
		this.sucursal = sucursal;
		this.caracteristicas = new ArrayList<Caracteristica>();
		this.descuentos = new ArrayList<Descuento>();
		this.caracteristicas.add(new Caracteristica("COMPRA_DIA", getDiaDeCompra(), CaracteristicaAplicoA.COMPRA));
	}

	public double getTotalCompraConDescuentos() {
		Iterator<ItemCompra> it = this.items.iterator();
		while (it.hasNext()) {
			this.totalCompra += it.next().getPrecioFinal();
		}
		return this.totalCompra;
	}

	public double getTotalCompraSinDescuentos() {
		Iterator<ItemCompra> it = this.items.iterator();
		while (it.hasNext()) {
			this.totalCompra += it.next().getPrecioFinal();
		}
		return this.totalCompra;
	}

	// Calcula monto total descontado en la compra
	public double getTotalDescuentosEnCompra() {
		double totalDescuentos = 0;
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
		//TODO sacar esto!!!
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
		this.sucursal.CalcularDescuentos(this);
		return this.getTotalCompraConDescuentos();
	}

	public ArrayList<Caracteristica> getCaracteristicas() {
		return caracteristicas;
	}

}
