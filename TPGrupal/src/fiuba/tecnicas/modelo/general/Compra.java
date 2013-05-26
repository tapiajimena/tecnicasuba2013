package fiuba.tecnicas.modelo.general;

import java.util.ArrayList;
import java.util.Iterator;
/**
 *	La Compra es un Singleton
 */
public class Compra implements Iterator<ItemCompra>{

	private static Compra INSTANCE;
	private ArrayList<ItemCompra> items;
	private MedioDePago medioDePago;
	private Sucursal sucursal;
	private double totalCompra;
	protected int posicionArray;
	
	private void setSucursal(Sucursal sucursal){
		this.sucursal = sucursal;
	}

	private void setMedioDePago(MedioDePago medioDePago){
		this.medioDePago = medioDePago;
	}	
	
	private Compra(){}

	private double getTotalCompra(){
		Iterator<ItemCompra> it = this.iterator();
		while(it.hasNext()){
			this.totalCompra += it.next().getPrecioFinal();
		}
		return this.totalCompra;
	}

	public MedioDePago getMedioDePago(){
		return this.medioDePago;
	}
	
	public ArrayList<ItemCompra> getItems() {
		return items;
	}

	public void addItem(ItemCompra item){
		// Ojo prodria calcular el descuento aca
		items.add(item);
	}

	public double CalcularTotal()
	{
		this.sucursal.CalcularDescuentos(this);
		return this.getTotalCompra();
	}

	public static Compra getInstance() {
		if (INSTANCE == null) { 
			INSTANCE = new Compra();
		}
		return INSTANCE;
	}

	public void inicializarCompra(Sucursal sucursal, MedioDePago medio_de_pago){
		this.posicionArray = 0;
		this.setMedioDePago(medio_de_pago);
		this.setSucursal(sucursal);
		items = new ArrayList<ItemCompra>();
	}

	public Iterator<ItemCompra> iterator() {
		return items.iterator();
	}

	public boolean hasNext() {
		boolean result;
		if (this.posicionArray < items.size()) { result = true; }
		else { result = false; }
		return result;
	}

	public ItemCompra next() {
		this.posicionArray++;
		return items.get(posicionArray-1);
	}

	public void remove(){
		throw new UnsupportedOperationException("No soportado.");
	}
	
	public void setPosicionArray(int posicionArray) {
		this.posicionArray = posicionArray;
	}
}
