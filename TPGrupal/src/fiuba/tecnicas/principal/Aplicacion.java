package fiuba.tecnicas.principal;

import fiuba.tecnicas.presentacion.ConsoleView;
import fiuba.tecnicas.presentacion.IView;
import fiuba.tecnicas.test.commands.VerTotalDescuentosCommandTest;
import fiuba.tecnicas.test.modelo.CompraTest;

public class Aplicacion {

	public Aplicacion() {}

	/**
	 * @param args
	 */
	public static void main(String[] args){
	/*	IView consola = new ConsoleView();
		consola.run();*/
		CompraTest compra = new CompraTest();
		//compra.TestSegundaUnidadLunes();
		//compra.TestNxMTarjeta();
		compra.TestJubilado();
	}
}
