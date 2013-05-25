package fiuba.tecnicas.modelo.general.command;

import fiuba.tecnicas.modelo.general.Compra;

public interface IOfertar {
	public void setNext(IOfertar oferta);
	public IOfertar getNext();
	public Void aplicarOferta(Compra compra);
}
