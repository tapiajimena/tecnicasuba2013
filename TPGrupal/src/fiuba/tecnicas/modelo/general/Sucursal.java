package fiuba.tecnicas.modelo.general;


public class Sucursal {
	
	private Oferta chainOferta;
	
	public Sucursal(Oferta chain){
		chainOferta = chain;
	}

	public void CalcularDescuentos(Compra compra)
	{
		chainOferta.calcularDescuentos(compra);
	}
}
