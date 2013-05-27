package fiuba.tecnicas.modelo.general.command;

import fiuba.tecnicas.modelo.comun.Mensaje;
import fiuba.tecnicas.modelo.comun.Resultado;
import fiuba.tecnicas.modelo.servicios.validacion.ServicioValidacion;

/**
 * Comando para indicar el medio de pago de la compra.
 *
 */
public class MedioDePagoCommand implements ICommand {

	@Override
	public Resultado execute(String input) {
		Resultado resultado = ServicioValidacion.validarParametrosMedioPago(input);
		if (resultado.getExito()) {
			//Caja.getCurrentCompra().setMedioDePago(extraerTipoPago(input),extraerBanco(input));
			return new Resultado(Mensaje.getMensaje("mensaje_MedioDePago")); //+ Caja.getCurrentCompra().getMedioDePago().toString() +".\n");
		}
		return resultado;
		
	}
	
	private String extraerBanco(String input) {
		return input.split(",")[1];
	}
	
	private String extraerTipoPago(String input) {
		return input.split(",")[0];
	}
}
