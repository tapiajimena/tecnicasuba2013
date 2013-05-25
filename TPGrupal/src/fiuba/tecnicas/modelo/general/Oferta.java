package fiuba.tecnicas.modelo.general;

public abstract class Oferta {
	public abstract void setNext(Oferta oferta);
	public abstract void calcularDescuentos(Compra compra);
//	{
//		
//		// Aplico el descuento de este eslabon.
//		doCalcularDescuetos(compra);
//
//		// Continuo la cadena.
//		oferta.calcularDescuentos(compra);
//	}
	
	public abstract Oferta getNext();
//	public abstract void doCalcularDescuetos(Compra compra);

}
