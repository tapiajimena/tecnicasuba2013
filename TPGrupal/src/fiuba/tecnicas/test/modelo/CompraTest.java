package fiuba.tecnicas.test.modelo;

import junit.framework.Assert;

import org.junit.Test;

import fiuba.tecnicas.modelo.general.Compra;
import fiuba.tecnicas.modelo.general.ItemCompra;
import fiuba.tecnicas.modelo.general.Producto;
import fiuba.tecnicas.modelo.general.Sucursal;
import fiuba.tecnicas.modelo.general.SucursalFactory;

public class CompraTest {

	@Test
	public void TestCompraDescuentoTarjeta10PorCien() 
	{
		// Contexto
		Sucursal sucursal = SucursalFactory.SucursalUno();
		//Compra compra = new Compra(sucursal);
		ItemCompra  item = new ItemCompra(new Producto(10, "Chandon"),5);
		Compra compra = Compra.getInstance();
		compra.inicializarCompra(sucursal);
		Compra.getInstance().addItem(item);
		
		// Calculo
		double totalCompra = Compra.getInstance().CalcularTotal();
		System.out.println(totalCompra);
		Assert.assertEquals(item.getPrecioFinal(), 50.0);

		
	}
}
