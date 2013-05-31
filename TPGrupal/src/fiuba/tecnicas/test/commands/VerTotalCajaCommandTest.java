package fiuba.tecnicas.test.commands;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Test;

import fiuba.tecnicas.modelo.comun.Mensaje;
import fiuba.tecnicas.modelo.general.Caja;
import fiuba.tecnicas.modelo.general.Categoria;
import fiuba.tecnicas.modelo.general.Compra;
import fiuba.tecnicas.modelo.general.ItemCompra;
import fiuba.tecnicas.modelo.general.Producto;
import fiuba.tecnicas.modelo.general.ProductoFactory;
import fiuba.tecnicas.modelo.general.Sucursal;
import fiuba.tecnicas.modelo.general.SucursalFactory;
import fiuba.tecnicas.modelo.general.command.ICommand;
import fiuba.tecnicas.modelo.general.command.VerTotalCajaCommand;

public class VerTotalCajaCommandTest {

	@Test 
	public void testCommandVerTotalCaja() 
	{

		Sucursal sucursal = SucursalFactory.SucursalUno();
		Caja.getInstance().abrir();
		Caja.getInstance().addNuevaCompraActiva(sucursal);

		Compra compraActiva = Caja.getInstance().getCompraActiva();
		ItemCompra itemCoca = new ItemCompra(ProductoFactory.getInstance().getProducto("COCA"),2);
		compraActiva.addItem(itemCoca);
		ICommand command = new VerTotalCajaCommand();
		
		//aplica descuento del 2x1
		assertEquals(command.execute("").getMensaje(),Mensaje.getMensaje("mensaje_VerTotalCaja") + " " + "1.0");
	}

}
