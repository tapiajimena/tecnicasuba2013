package fiuba.tecnicas.modelo.general.command;

import fiuba.tecnicas.modelo.comun.Mensaje;
import fiuba.tecnicas.modelo.comun.Resultado;
import fiuba.tecnicas.modelo.general.Caja;

/**
 * TODO: que carajo hace este command? ademas de cerrar la caja
 *
 */
public class CerrarCajaCommand implements ICommand {

	@Override
	public Resultado execute(String input) {
		//Mostrar estos campos
		//Caja.getInstance().getTotalDescuentos();
		Caja.getInstance().getTotalPorMedioDePago();
		Caja.getInstance().getTotalVentasCaja();
		return new Resultado(Mensaje.getMensaje("mensaje_cerrarCaja"));
	}

}
