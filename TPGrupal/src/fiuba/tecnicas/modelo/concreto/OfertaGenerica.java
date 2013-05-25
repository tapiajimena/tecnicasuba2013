package fiuba.tecnicas.modelo.concreto;

import java.util.Iterator;

import fiuba.tecnicas.modelo.general.Compra;
import fiuba.tecnicas.modelo.general.ItemCompra;
import fiuba.tecnicas.modelo.general.Oferta;

public class OfertaGenerica extends Oferta {

	private Oferta next;
	
	@Override
	public void setNext(Oferta oferta){

	}

	@Override
	public void calcularDescuentos (Compra compra){

	}

	@Override
	public Oferta getNext(){
		return this.next;
	}

}
