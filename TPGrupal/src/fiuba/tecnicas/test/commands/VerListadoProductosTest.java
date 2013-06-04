package fiuba.tecnicas.test.commands;

import static org.junit.Assert.*;
import org.junit.Test;
import fiuba.tecnicas.modelo.general.Caja;
import fiuba.tecnicas.modelo.general.Sucursal;
import fiuba.tecnicas.modelo.general.SucursalFactory;
import fiuba.tecnicas.modelo.general.command.AgregarProductosCommand;
import fiuba.tecnicas.modelo.general.command.ICommand;

public class VerListadoProductosTest {

	@Test 
	public void testCommandVerTotalCaja() 
	{	
		Sucursal sucursal = SucursalFactory.SucursalUno();
		Caja.getInstance().abrir();
		Caja.getInstance().addNuevaCompraActiva(sucursal);
		ICommand command = new AgregarProductosCommand();
		command.execute("COCA,COCA,SPRITE,COCA,SPRITE,MACETA");
		Caja.getInstance().cerrarCompraActiva();
		
		Caja.getInstance().addNuevaCompraActiva(sucursal);
		ICommand command2 = new AgregarProductosCommand();
		command2.execute("SPRITE,SPRITE,SPRITE,COCA,MACETA,MACETA,SPRITE,MACETA,MACETA");
		Caja.getInstance().cerrarCompraActiva();
		assertEquals("[Sprite =6, Maceta=5, Coca=4]", Caja.getInstance().obtenerListaProductosCantidad());
	}
}
