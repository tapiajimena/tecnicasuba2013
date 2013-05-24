package fiuba.tecnicas.presentacion;

import fiuba.tecnicas.modelo.general.command.AbrirCajaCommand;
import fiuba.tecnicas.modelo.general.command.ICommand;

public class DomainPresenter {

	private IConsoleView view;
	
	public interface IConsoleView extends IView {
		//Agrego componentes especificos de la vista de consola
		void setMensaje(String mensaje);
		String getMensaje();
	}
	
	public DomainPresenter(IConsoleView view) {
		this.view = view;
	}
	
	public void abrirCaja() {
		//InicializoCaja
		view.setMensaje("Bienvenido!");
	}
	
	public double calcularMontoTotalCompra() {
		return 0;
	}

	public ICommand getCommand(String input) {
		
		return new AbrirCajaCommand();
	}
}
