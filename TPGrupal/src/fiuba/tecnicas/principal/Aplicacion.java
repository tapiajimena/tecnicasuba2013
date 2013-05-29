package fiuba.tecnicas.principal;

import fiuba.tecnicas.modelo.general.Sucursal;
import fiuba.tecnicas.modelo.general.SucursalFactory;
import fiuba.tecnicas.presentacion.ConsoleView;
import fiuba.tecnicas.presentacion.IView;

public class Aplicacion {

	public Aplicacion() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args){
		IView consola = new ConsoleView();
		consola.run();
	}
}
