package fiuba.tecnicas.modelo.concreto;
import java.util.Iterator;

import fiuba.tecnicas.modelo.general.Compra;
import fiuba.tecnicas.modelo.general.Oferta;
import fiuba.tecnicas.modelo.general.ItemCompra;

public class OfertaGenerica extends Oferta {

	private Oferta next;

	@Override
	public void setNext(Oferta oferta){
		this.next = oferta;
	}

	@Override
	public void calcularDescuentos (Compra compra){
		Iterator<ItemCompra> it = compra.iterator();
		while(it.hasNext()){
			if (it.next().getProducto().getDescripcion() == "choclo") {
				it.next().setPrecioFinal(it.next().getPrecioFinal() - 0.1*it.next().getPrecioFinal());
			}else if (this.next != null){ 
				next.calcularDescuentos(compra); 
			}
		}
	}

	@Override
	public Oferta getNext(){
		return this.next;
	}

}
