package fiuba.tecnicas.modelo.general.command;

import fiuba.tecnicas.modelo.comun.Mensaje;
import fiuba.tecnicas.modelo.comun.Resultado;

import fiuba.tecnicas.modelo.general.Compra;

/**
 * Comando que muestra los comandos disponibles
 *
 */
public class HelpCommand implements ICommand {

	@Override
	public Resultado execute(String input) {
		return new Resultado(Mensaje.getMensaje("mensaje_Help"));
	}
}
