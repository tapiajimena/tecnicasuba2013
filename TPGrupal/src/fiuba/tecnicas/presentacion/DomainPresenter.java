package fiuba.tecnicas.presentacion;

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
}
