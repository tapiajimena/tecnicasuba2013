package fiuba.tecnicas.modelo.servicios.validacion;

import fiuba.tecnicas.modelo.comun.Constante;
import fiuba.tecnicas.modelo.comun.Resultado;

public class ServicioValidacion {

	public static Resultado validarParametrosMedioPago(String parametros) {
		 return parametros.split(Constante.getConstante("separador_parametros")).length > 1?
				 new Resultado(true) : new Resultado("error_param_MedioPago");
	}

	
}
