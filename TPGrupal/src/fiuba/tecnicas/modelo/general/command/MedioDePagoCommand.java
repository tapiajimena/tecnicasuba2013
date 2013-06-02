package fiuba.tecnicas.modelo.general.command;

import fiuba.tecnicas.modelo.comun.Mensaje;
import fiuba.tecnicas.modelo.comun.Resultado;
import fiuba.tecnicas.modelo.general.Caja;
import fiuba.tecnicas.modelo.general.Compra;
import fiuba.tecnicas.modelo.servicios.validacion.ServicioValidacion;

/**
 * Comando para indicar el medio de pago de la compra.
 *
 */
public class MedioDePagoCommand implements ICommand {

	@Override
	public Resultado execute(String input) {
		
		Compra compraActiva = Caja.getInstance().getCompraActiva();		
		Resultado resultado = ServicioValidacion.validarEjecucionComandoMedioDePago(input, compraActiva);
		if (resultado.getExito()) {
			compraActiva.setMedioDePago(extraerTipoPago(input),extraerBanco(input),"false");
			return new Resultado(Mensaje.getMensaje("mensaje_MedioDePago") + compraActiva.getMedioDePago().toString());
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
