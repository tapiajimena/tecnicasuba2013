package fiuba.tecnicas.presentacion;

import java.util.List;

import fiuba.tecnicas.modelo.general.ItemCompra;

public interface IView {
	public String inicializarCaja();
	public void cargarItemsCompra(List<ItemCompra> items);
	public double getMontoTotalCompra();
	public void run();
}
