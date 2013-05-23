package fiuba.tecnicas.modelo.general;

public abstract class Oferta {

	private Oferta oferta;
	
	public void calcularDescuentos(Compra compra) {
		
		// Aplico el descuento de este eslabon.
		doCalcularDescuetos(compra);

		// Continuo la cadena.
		oferta.calcularDescuentos(compra);
	}
	
	public abstract void doCalcularDescuetos(Compra compra);

}
