package fiuba.tecnicas.test.commands;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Test;

import fiuba.tecnicas.modelo.general.Caja;
import fiuba.tecnicas.modelo.general.Categoria;
import fiuba.tecnicas.modelo.general.Compra;
import fiuba.tecnicas.modelo.general.ItemCompra;
import fiuba.tecnicas.modelo.general.Producto;
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
		ItemCompra item = new ItemCompra(new Producto(10.0,"desc","marca", Categoria.FARMACIA),2);
		compraActiva.addItem(item);
		
		ICommand command = new VerTotalCajaCommand();
		command.execute("");
		
		//Sacar del precio final el descunto
		assertTrue(Caja.getInstance().getTotalVentasCaja() == 10.0);
	}

}
