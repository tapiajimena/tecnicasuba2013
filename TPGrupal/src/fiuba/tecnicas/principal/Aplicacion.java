package fiuba.tecnicas.principal;

import java.util.Locale.Category;

import junit.framework.Assert;
import fiuba.tecnicas.modelo.general.Categoria;
import fiuba.tecnicas.modelo.general.Compra;
import fiuba.tecnicas.modelo.general.ItemCompra;
import fiuba.tecnicas.modelo.general.Producto;
import fiuba.tecnicas.modelo.general.MedioDePago;
import fiuba.tecnicas.modelo.general.Sucursal;
import fiuba.tecnicas.modelo.general.SucursalFactory;
import fiuba.tecnicas.modelo.general.TipoPago;
import fiuba.tecnicas.presentacion.ConsoleView;
import fiuba.tecnicas.presentacion.IView;

public class Aplicacion {

	public Aplicacion() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		IView consola = new ConsoleView();
//		consola.run("AbrirCaja");


		// Contexto
//		Sucursal sucursal = new Sucursal();
//		//Compra compra = new Compra(sucursal);
//		ItemCompra  item = new ItemCompra(new Producto(10, "choclo"),5);
//		Compra compra = Compra.getInstance();
//		compra.inicializarCompra(sucursal);
//		compra.addItem(item);
//		// Calculo
//		double totalCompra = Compra.getInstance().CalcularTotal();
//		System.out.println(totalCompra);
		Sucursal sucursal = SucursalFactory.SucursalUno();
		//Compra compra = new Compra(sucursal);
		Compra compra = Compra.getInstance();
		compra.inicializarCompra(sucursal, new MedioDePago(TipoPago.EFECTIVO, ""));
		Compra.getInstance().addItem(new ItemCompra(new Producto(10, "Champagne Extra Brut", "Chandon", Categoria.BEBIDAS),5));
//		Compra.getInstance().addItem(new ItemCompra(new Producto(10, "choclo"),5));
//		Compra.getInstance().addItem(new ItemCompra(new Producto(30, "cafe"),1));
		// Calculo
		double totalCompra = Compra.getInstance().CalcularTotal();
		System.out.println(totalCompra);
	}
}
