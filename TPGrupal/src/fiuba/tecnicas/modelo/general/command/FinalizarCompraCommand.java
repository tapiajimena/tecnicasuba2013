package fiuba.tecnicas.modelo.general.command;

import fiuba.tecnicas.modelo.comun.Mensaje;
import fiuba.tecnicas.modelo.comun.Resultado;
import fiuba.tecnicas.modelo.general.Caja;

public class FinalizarCompraCommand implements ICommand {

	@Override
	public Resultado execute(String input) {
		Caja.getInstance().cerrarCompraActiva();
		return new Resultado(Mensaje.getMensaje("mensaje_CerrarCompraActiva"));
	}

}
