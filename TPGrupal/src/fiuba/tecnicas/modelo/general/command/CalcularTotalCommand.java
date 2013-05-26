package fiuba.tecnicas.modelo.general.command;

import fiuba.tecnicas.modelo.comun.Resultado;

import fiuba.tecnicas.modelo.general.Compra;

public class CalcularTotalCommand implements ICommand {

	/*
	 * TODO Este lo hace Lucas.
	 */
	@Override
	public Resultado execute(String input) {
		String stringCosto = new Double(Compra.getInstance().CalcularTotal()).toString();
		return new Resultado("La Compra tiene un Costo de" + stringCosto);
	}
}
