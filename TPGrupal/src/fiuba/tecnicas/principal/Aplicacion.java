package fiuba.tecnicas.principal;

import fiuba.tecnicas.presentacion.ConsoleView;
import fiuba.tecnicas.presentacion.IView;

public class Aplicacion {

	public Aplicacion() {}

	/**
	 * @param args
	 */
	public static void main(String[] args){
		IView consola = new ConsoleView();
		consola.run();
	}
}
