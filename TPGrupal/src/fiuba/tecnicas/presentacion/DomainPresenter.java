package fiuba.tecnicas.presentacion;

import fiuba.tecnicas.modelo.comun.Mensaje;
import fiuba.tecnicas.modelo.comun.Resultado;
import fiuba.tecnicas.modelo.general.command.CommandFactory;
import fiuba.tecnicas.modelo.general.command.ICommand;

public class DomainPresenter {

	private IConsoleView view;
	
	public interface IConsoleView extends IView {
		//Agrego componentes especificos de la vista de consola
		public String getCommandFromInput(String input);
		public String getParametersFromInput(String input);
		public String getInput();
	}
	
	public DomainPresenter(IConsoleView view) {
		this.view = view;
	}
	
	public String getMensajeBienvenida() {
		return Mensaje.getMensaje("mensaje_Bienvenida");
	}
	
	public Boolean quitAplicacion(String input) {
		return input.equals(Mensaje.getMensaje("mensaje_exit"));
	}

	public ICommand getCommand(String input) {
		return (ICommand) CommandFactory.getInstance().getCommand(input);
	}
	
	public Resultado executeCommand(String input) {
		return new Resultado(getCommand(this.view.getCommandFromInput(input)).execute(this.view.getParametersFromInput(input)).getMensaje());
	}
}
