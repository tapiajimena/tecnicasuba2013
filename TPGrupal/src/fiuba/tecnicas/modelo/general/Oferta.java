package fiuba.tecnicas.modelo.general;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fiuba.tecnicas.principal.Aplicacion;

public class Oferta {
	
	private Oferta next;
	private ArrayList<Caracteristica> caracteristicas;
	private String nombre;
	private IOfertaStrategy strategy;
	
	
	public void setNext(Oferta oferta){
		this.next = oferta;
	}
	
	public Oferta getNext(){
		return this.next;
	}	
	
	public void calcularDescuentos(Compra compra)
	{
		// Aplico el descuento de este eslabon.
		if(aplicoAEstaSerieDeCaracteristicas(compra.getCaracteristicas(), 
				this.getCaracteristicasEspecificas(CaracteristicaAplicoA.COMPRA)))
			recorrerItemsYCalcularDescuentos(compra);

		// Continuo la cadena.
		if (this.next != null) 
			next.calcularDescuentos(compra); 
	}
	
	private ArrayList<Caracteristica> getCaracteristicasEspecificas(CaracteristicaAplicoA tipoDeObjeto) {
		ArrayList<Caracteristica> _sub = new ArrayList<Caracteristica>();
		Iterator<Caracteristica> it = this.getCaracteristicas().iterator();
		while(it.hasNext())
		{
			Caracteristica c = it.next();
			if(c.getObjetoAlQueAplico() == tipoDeObjeto)
				_sub.add(c);
		}
		return _sub;
	}

	public void recorrerItemsYCalcularDescuentos(Compra compra)
	{
		Iterator<ItemCompra> it = compra.getItems().iterator();
		ItemCompra item;
		double valorDescuento = 0;

		while(it.hasNext()){
			item = it.next();
			if(aplicoAEstaSerieDeCaracteristicas(item.getCaracteristicas(), 
					this.getCaracteristicasEspecificas(CaracteristicaAplicoA.ITEM)))
				valorDescuento = doCalcularDescuentos(item, valorDescuento);
		}

		compra.addDescuento(new Descuento(valorDescuento,getNombre()));
	}
	
	public double doCalcularDescuentos(ItemCompra item, double valorDescuento)
	{
		return this.getStrategy().doCalcularDescuentos(item, valorDescuento);
	}
	
	public ArrayList<Caracteristica> getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(ArrayList<Caracteristica> caracteristicas) {
		this.caracteristicas = caracteristicas;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	private Boolean aplicoAEstaSerieDeCaracteristicas(ArrayList<Caracteristica> serie, ArrayList<Caracteristica> subConjuntoDeMias)
	{
		if(serie == null || subConjuntoDeMias == null)
			return false;
		
		// Recorro mis caracteristicas y me fijo si estan todas en la compra, si hay alguna que no, me fui, no aplico.
		Iterator<Caracteristica> misCaracteristicas = subConjuntoDeMias.iterator();
		while(misCaracteristicas.hasNext())
		{
			Caracteristica estaCaracteristica = misCaracteristicas.next();
			if(!tieneEstaCaracteristicaMia(serie, estaCaracteristica))
				return false;
		}

		return true;
	}

	private Boolean tieneEstaCaracteristicaMia(ArrayList<Caracteristica> caracteristicasNoMias, Caracteristica estaCaracteristica) {
		Boolean noLaTiene = true;
		Iterator<Caracteristica> susCaracteristicas = caracteristicasNoMias.iterator();
		while(susCaracteristicas.hasNext() && noLaTiene){
			Caracteristica s = susCaracteristicas.next();
			noLaTiene = (estaCaracteristica.compareTo(s) != 0);
			if(!noLaTiene)
				break;
		}
		
		return !noLaTiene;
	}

	public IOfertaStrategy getStrategy() {
		return strategy;
	}

	public void setStrategy(IOfertaStrategy strategy) {
		this.strategy = strategy;
	}
}
