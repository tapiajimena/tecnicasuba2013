package fiuba.tecnicas.presentacion;

public interface IView {
	//public String inicializarCaja();
	//public void cargarItemsCompra(List<ItemCompra> items);
	//public double getMontoTotalCompra();
	public DomainPresenter getPresenter();
	void run();
}
