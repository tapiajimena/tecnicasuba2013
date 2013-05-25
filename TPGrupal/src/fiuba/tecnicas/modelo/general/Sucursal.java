package fiuba.tecnicas.modelo.general;

import fiuba.tecnicas.modelo.concreto.OfertaGenerica;


public class Sucursal {
	
	private Oferta chainOferta;
	
	public void setNext(Oferta oferta){
		this.chainOferta = oferta;
	}
	public Sucursal(Oferta chain){
		chainOferta = chain;
	}

	public void CalcularDescuentos(Compra compra){
		OfertaGenerica ofG = new OfertaGenerica();
		this.setNext(ofG);
		chainOferta.calcularDescuentos(compra);
	}
	
	public Oferta getNext(){
		return this.chainOferta;
	}
}
