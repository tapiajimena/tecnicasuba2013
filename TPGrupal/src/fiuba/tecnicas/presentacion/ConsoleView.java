package fiuba.tecnicas.presentacion;

import java.util.List;

import fiuba.tecnicas.modelo.general.ItemCompra;
import fiuba.tecnicas.presentacion.DomainPresenter.IConsoleView;

public class ConsoleView implements IConsoleView{
	private DomainPresenter presenter;
	private String mensaje;
	
	public ConsoleView() {
		presenter = new DomainPresenter(this);
	}

	@Override
	public String inicializarCaja() {
		presenter.abrirCaja();
		System.out.print(mensaje);
		return null;
	}

	@Override
	public void cargarItemsCompra(List<ItemCompra> items) {
		
	}

	@Override
	public double getMontoTotalCompra() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	

	@Override
	public void run() {
		System.out.print(presenter.getCommand("AbrirCaja").execute("").getMensaje());
		cargarItemsCompra(null);
		System.out.print(getMontoTotalCompra());
		
	}
	@Override
	public DomainPresenter getPresenter() {
		
		return this.presenter;
	}

}
