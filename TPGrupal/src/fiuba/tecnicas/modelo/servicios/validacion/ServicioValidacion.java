package fiuba.tecnicas.modelo.servicios.validacion;

import fiuba.tecnicas.modelo.comun.Constante;
import fiuba.tecnicas.modelo.comun.Mensaje;
import fiuba.tecnicas.modelo.comun.Resultado;
import fiuba.tecnicas.modelo.general.Compra;

public class ServicioValidacion {
	
	public static Resultado validarEjecucionComandoAgregarProductos(Compra compra) {
		if (compra != null && !compra.getItems().isEmpty()) return new Resultado(true);
		else return new Resultado("error_ordenEjec_CalcularTotalCompra");
	}
	
	public static Resultado validarEjecucionComandoMedioDePago(String parametros, Compra compraActiva) {
		if (compraActiva == null) return new Resultado(Mensaje.getMensaje("error_ordenEjec_MedioPago"),false);
		if (compraActiva != null && !validarParametrosMedioPago(parametros))
			return new Resultado(Mensaje.getMensaje("error_param_MedioPago"),false);
		else return new Resultado(true);
	}
	
	private static boolean validarParametrosMedioPago(String parametros) {
		 return (parametros.split(Constante.getConstante("separador_parametros"))).length > 1;
	}
	
}
