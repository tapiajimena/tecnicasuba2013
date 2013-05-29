package fiuba.tecnicas.modelo.servicios.validacion;

import fiuba.tecnicas.modelo.comun.Constante;
import fiuba.tecnicas.modelo.comun.Resultado;
import fiuba.tecnicas.modelo.general.Compra;

public class ServicioValidacion {

	public static Resultado validarParametrosMedioPago(String parametros) {
		 return parametros.split(Constante.getConstante("separador_parametros")).length > 1?
				 new Resultado(true) : new Resultado("error_param_MedioPago");
	}
	
	public static Resultado validarEjecucionComandoAgregarProductos(Compra compra) {
		if (compra != null && !compra.getItems().isEmpty()) return new Resultado(true);
		else return new Resultado("error_ordenParam_CalcularTotalCompra");
	}
	
}
