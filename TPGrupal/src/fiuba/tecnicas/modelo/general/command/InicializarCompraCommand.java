package fiuba.tecnicas.modelo.general.command;

import fiuba.tecnicas.modelo.comun.Mensaje;
import fiuba.tecnicas.modelo.comun.Resultado;
import fiuba.tecnicas.modelo.general.Caja;
import fiuba.tecnicas.modelo.general.Compra;
import fiuba.tecnicas.modelo.general.MedioDePago;
import fiuba.tecnicas.modelo.general.Sucursal;
import fiuba.tecnicas.modelo.general.TipoPago;

public class InicializarCompraCommand implements ICommand {

	@Override
	public Resultado execute(String input) {
		Compra compra = Compra.getInstance();
		compra.inicializarCompra(new Sucursal(), new MedioDePago(TipoPago.EFECTIVO, ""));
		return new Resultado("Compra incializada correctamente");
	}

}
