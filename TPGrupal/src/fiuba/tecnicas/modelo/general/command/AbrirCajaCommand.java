package fiuba.tecnicas.modelo.general.command;

import fiuba.tecnicas.modelo.comun.Mensaje;
import fiuba.tecnicas.modelo.comun.Resultado;
import fiuba.tecnicas.modelo.general.Caja;
import fiuba.tecnicas.modelo.general.Sucursal;
import fiuba.tecnicas.modelo.general.SucursalFactory;

/**
 * Comando para Abrir la Caja Inicializa la caja.
 * 
 */
public class AbrirCajaCommand implements ICommand {

	@Override
	public Resultado execute(String input) {
		Caja.getInstance().abrir();
		if (!input.isEmpty()) {
			Sucursal sucursal = SucursalFactory.getSucursalByName(input);
			if (sucursal != null) {
				Caja.getInstance().setSucursal(sucursal);
			}
			return new Resultado(Mensaje.getMensaje("mensaje_AbrirCaja"));
		} else {
			return new Resultado(Mensaje.getMensaje("error_param_AbrirCaja"));
		}

	}

}
