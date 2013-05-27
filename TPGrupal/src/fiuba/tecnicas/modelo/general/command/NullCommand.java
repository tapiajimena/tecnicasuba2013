package fiuba.tecnicas.modelo.general.command;

import fiuba.tecnicas.modelo.comun.Mensaje;
import fiuba.tecnicas.modelo.comun.Resultado;


/**
 * Comando Inexistente
 *
 */
public class NullCommand implements ICommand {

	@Override
	public Resultado execute(String input) {
		return new Resultado(Mensaje.getMensaje("mensaje_ComandoInvalido"));
	}
}
