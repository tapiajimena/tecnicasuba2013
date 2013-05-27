package fiuba.tecnicas.modelo.general;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;

public class Compra {
	private ArrayList<ItemCompra> items;
	private MedioDePago medioDePago;
	private Sucursal sucursal;
	private double totalCompra;
	private ArrayList<Descuento> descuentos;
	private DiaSemana diaDeCompra;
	
	private void setSucursal(Sucursal sucursal){
		this.sucursal = sucursal;
	}

	public void setMedioDePago(String medioDePago, String banco){
		this.medioDePago = new MedioDePago(TipoPago.valueOf(medioDePago),banco);
	}	
	
	public Compra(){
		this.items = new ArrayList<ItemCompra>();
		//this.diaDeCompra = DiaSemana.values()[Calendar.getInstance().DAY_OF_WEEK];
	}
	
	public static int getDayOfTheWeek(Date d){
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(d);
		return cal.get(Calendar.DAY_OF_WEEK);		
	}

	//Calcula el monto total de la compra CON DESCUENTOS
	public double getTotalCompra(){
		Iterator<ItemCompra> it = this.items.iterator();
		while(it.hasNext()){
			this.totalCompra += it.next().getPrecioFinal();
		}
		return this.totalCompra;
	}
	
	//Calcula el monto total de la compra SIN DESCUENTOS
	public double getTotal(){
		Iterator<ItemCompra> it = this.items.iterator();
		while(it.hasNext()){
			this.totalCompra += it.next().getPrecioFinal();
		}
		return this.totalCompra;
	}
	
	//Calcula monto total descontado en la compra
	public double getTotalDescuentosEnCompra() {
		double totalDescuentos = 0;
		Iterator<Descuento> it = this.descuentos.iterator();
		while(it.hasNext()){
			totalDescuentos += it.next().getValor();
		}
		return totalDescuentos;
	}

	public MedioDePago getMedioDePago(){
		return this.medioDePago;
	}
	
	public ArrayList<ItemCompra> getItems() {
		return items;
	}

	
	public String getDiaDeCompra(){
		return this.diaDeCompra.name();
	}
	
	public void addItem(ItemCompra item){
		// Ojo prodria calcular el descuento aca
		items.add(item);
	}
	
	public void addDescuento(Descuento descuento){
		descuentos.add(descuento);
	}

	public double CalcularTotal()
	{
		this.sucursal.CalcularDescuentos(this);
		return this.getTotalCompra();
	}

	public void setDiaCompra(int numeroDia){
		this.diaDeCompra = DiaSemana.values()[numeroDia];
	}
	
	public void inicializarCompra(Sucursal sucursal, MedioDePago medio_de_pago, Calendar fechaCompra){
		inicializarCompra(sucursal,medio_de_pago);
		this.diaDeCompra = DiaSemana.values()[fechaCompra.DAY_OF_WEEK];
	}
	
	public void inicializarCompra(Sucursal sucursal, MedioDePago medio_de_pago){
		//TODO:this.setMedioDePago(medio_de_pago);
		this.setSucursal(sucursal);
		items = new ArrayList<ItemCompra>();
		descuentos = new ArrayList<Descuento>();
	}
}
