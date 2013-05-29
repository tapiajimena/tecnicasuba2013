package fiuba.tecnicas.modelo.general.command;

import fiuba.tecnicas.modelo.comun.Resultado;

import fiuba.tecnicas.modelo.general.Caja;

public class CalcularTotalCompraCommand implements ICommand {

	@Override
	public Resultado execute(String input) {
		String stringCosto = new Double(Caja.getInstance().getCompraActiva().CalcularTotal()).toString();
		return new Resultado("La Compra tiene un Costo de" + stringCosto);
	}
}
