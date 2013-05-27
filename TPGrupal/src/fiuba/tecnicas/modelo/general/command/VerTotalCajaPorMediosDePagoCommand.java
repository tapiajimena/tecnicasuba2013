package fiuba.tecnicas.modelo.general.command;

import java.util.Map;

import fiuba.tecnicas.modelo.comun.Resultado;
import fiuba.tecnicas.modelo.general.Caja;
import fiuba.tecnicas.modelo.general.MedioDePago;

public class VerTotalCajaPorMediosDePagoCommand implements ICommand{
	private Map<Double,MedioDePago> comprasPorMedioPago; 
	
	@Override
	public Resultado execute(String input) {
		this.comprasPorMedioPago = Caja.getInstance().getTotalPorMedioDePago();
		return new Resultado(this.toString());
	}
	
	@Override
	public String toString(){
		// TODO recorrer el hash map y armar el string "L]UCAS"!
		return "Hola";
	}

}
