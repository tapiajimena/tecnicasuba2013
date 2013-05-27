package fiuba.tecnicas.modelo.general.command;

import fiuba.tecnicas.modelo.comun.Resultado;
import fiuba.tecnicas.modelo.general.Caja;
import fiuba.tecnicas.modelo.general.SucursalFactory;

/**
 * Comando para iniciar una compra.
 * Inicializa la compra en la caja con fecha, sucursal y medio de pago.
 *
 */
public class IniciarCompraCommand implements ICommand {

	@Override
	public Resultado execute(String input) {
		//TODO:agregar sucursal dependiendo de input?
		Caja.getInstance().addNuevaCompraActiva(null);
		return null;
	}

}
