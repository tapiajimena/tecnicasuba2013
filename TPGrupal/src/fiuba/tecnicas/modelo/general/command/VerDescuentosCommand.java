package fiuba.tecnicas.modelo.general.command;

import javax.print.DocFlavor;

import fiuba.tecnicas.modelo.comun.Resultado;
import fiuba.tecnicas.modelo.general.Caja;

/**
 * Comando que muestra los descuentos aplicados en una compra.
 *
 */
public class VerDescuentosCommand implements ICommand {

	@Override
	public Resultado execute(String input) {
		String totalDescuentos = (new Double(Caja.getInstance().getTotalDescuentosCaja())).toString();
		return new Resultado(totalDescuentos);
	}

}
