package fiuba.tecnicas.modelo.general;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fiuba.tecnicas.principal.Aplicacion;

public abstract class Oferta {
	
	private Oferta next;
	private ArrayList<Caracteristica> caracteristicas;
	
	
	public void setNext(Oferta oferta){
		this.next = oferta;
	}
	
	public Oferta getNext(){
		return this.next;
	}	
	
	public void calcularDescuentos(Compra compra)
	{
		// Aplico el descuento de este eslabon.
		if(aplicoAEstaCompra(compra))
		{
			doCalcularDescuetos(compra);
		}
			

		// Continuo la cadena.
		if (this.next != null) 
			next.calcularDescuentos(compra); 
	}
	
	public abstract void doCalcularDescuetos(Compra compra);
	
	public Boolean aplicoAEstaCompra(Compra compra)
	{
		if(compra == null || this.caracteristicas == null)
			return false;
		
		// Recorro mis caracteristicas y me fijo si estan todas en la compra, si hay alguna que no, me fui, no aplico.
		Iterator<Caracteristica> misCaracteristicas = this.getCaracteristicas().iterator();
		while(misCaracteristicas.hasNext())
		{
			Caracteristica estaCaracteristica = misCaracteristicas.next();
			if(!tieneEstaCaracteristicaMia(compra, estaCaracteristica))
				return false;
		}

		return true;
	}

	private Boolean tieneEstaCaracteristicaMia(Compra compra, Caracteristica estaCaracteristica) {
		Boolean noLaTiene = true;
		Iterator<Caracteristica> susCaracteristicas = compra.getCaracteristicas().iterator();
		while(susCaracteristicas.hasNext() && noLaTiene){
			noLaTiene = (estaCaracteristica.compareTo(susCaracteristicas.next()) != 0);
			if(!noLaTiene)
				break;
		}
		
		return !noLaTiene;
	}

	public ArrayList<Caracteristica> getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(ArrayList<Caracteristica> caracteristicas) {
		this.caracteristicas = caracteristicas;
	}
}
