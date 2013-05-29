package fiuba.tecnicas.modelo.general.command;

import fiuba.tecnicas.modelo.comun.Mensaje;
import fiuba.tecnicas.modelo.comun.Resultado;

import fiuba.tecnicas.modelo.general.Caja;
import fiuba.tecnicas.modelo.general.Compra;
import fiuba.tecnicas.modelo.servicios.validacion.ServicioValidacion;

public class CalcularTotalCompraCommand implements ICommand {

	@Override
	public Resultado execute(String input) {
		Compra compraActiva = Caja.getInstance().getCompraActiva();
		Resultado resultado = ServicioValidacion.validarEjecucionComandoAgregarProductos(compraActiva);
		if (resultado.getExito()) {
			String stringCosto = new Double(compraActiva.CalcularTotal()).toString();
			resultado.setMensaje(Mensaje.getMensaje("mensaje_CalcularTotalCompra")+ " " + stringCosto);
		}
		return resultado;
	}
}
