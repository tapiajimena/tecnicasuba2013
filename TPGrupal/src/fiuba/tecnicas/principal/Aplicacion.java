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
		//CompraTest compra = new CompraTest();
		//compra.TestCompraDescuentoTarjeta10PorCien();
		//compra.TestCompra2x1();
		//compra.TestCompraTarjeta10Porciento();
		//compra.TestCompra10PorcientoFarmacia();

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
		Sucursal sucursal = SucursalFactory.SucursalTres();
		//Compra compra = new Compra(sucursal);
		//Compra compra = Compra.getInstance();
		//compra.inicializarCompra(sucursal, new MedioDePago(TipoPago.TARJETA, ""),Calendar.getInstance());
		//Compra.getInstance().addItem(new ItemCompra(new Producto(10, "Champagne Extra Brut", "Chandon", Categoria.BEBIDAS),5));
		//Compra.getInstance().addItem(new ItemCompra(new Producto(10, "Ibuprofeno", "Ibupirac", Categoria.FARMACIA),5));
		//Compra.getInstance().addItem(new ItemCompra(new Producto(10, "Coca", "Coca Cola", Categoria.BEBIDAS),2));

		//double totalCompra = Compra.getInstance().CalcularTotal();
			
		//System.out.println(totalCompra);
	}
}
