package fiuba.tecnicas.modelo.general;

import java.util.ArrayList;

public class Sucursal {
	
	private Oferta chainOferta;
	
	public Sucursal(Oferta oferta){
		this.chainOferta = oferta;
	}
	
	public void CalcularDescuentos(Compra compra)
	{
		chainOferta.CalcularDescuentos(compra);
	}
	
}
