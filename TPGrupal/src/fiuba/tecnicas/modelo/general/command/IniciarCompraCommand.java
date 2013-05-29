package fiuba.tecnicas.modelo.general.command;

import fiuba.tecnicas.modelo.comun.Mensaje;
import fiuba.tecnicas.modelo.comun.Resultado;
import fiuba.tecnicas.modelo.general.Caja;
/**
 * Comando para iniciar una compra.
 * Inicializa la compra en la caja con fecha, sucursal y medio de pago.
 *
 */
public class IniciarCompraCommand implements ICommand {

	@Override
	public Resultado execute(String input) {
		Resultado resultadoInciarCompraActiva = Caja.getInstance().addNuevaCompraActiva(Caja.getInstance().getSucursal());
		if (resultadoInciarCompraActiva.getExito())
				resultadoInciarCompraActiva.setMensaje(Mensaje.getMensaje("mensaje_CompraIniciada"));
				else resultadoInciarCompraActiva.setMensaje(Mensaje.getMensaje("error_ordenEjec_IniciarCompra"));
		return resultadoInciarCompraActiva;
	}

}
