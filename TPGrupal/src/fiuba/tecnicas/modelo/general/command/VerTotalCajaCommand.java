package fiuba.tecnicas.modelo.general.command;

import fiuba.tecnicas.modelo.comun.Mensaje;
import fiuba.tecnicas.modelo.comun.Resultado;
import fiuba.tecnicas.modelo.general.Caja;

/**
 * Comando para ver el total de la compra realizada
 *
 */
public class VerTotalCajaCommand implements ICommand {

	@Override
	public Resultado execute(String input) {
		String totalCaja = (new Double(Caja.getInstance().getTotalVentasCaja())).toString();
		return new Resultado(Mensaje.getMensaje("mensaje_VerTotalCaja") + " " + totalCaja);
	}

}
