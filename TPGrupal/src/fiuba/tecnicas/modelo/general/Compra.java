package fiuba.tecnicas.modelo.general;

import java.util.ArrayList;

public class Compra {
	private ArrayList<ItemCompra> items;
	private MedioDePago medioDePago;
	private Sucursal sucursal;
	
	public Compra(Sucursal sucursal){
		this.sucursal = sucursal;
		items = new ArrayList<ItemCompra>();
	}
	
	public void addItem(ItemCompra item){
		// Ojo prodria calcular el descuento aca
		items.add(item);
	}
	
	public void CalcularTotal()
	{
		this.sucursal.CalcularDescuentos(this);
	}
}
