package fiuba.tecnicas.test.commands;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.tecnicas.modelo.general.Caja;
import fiuba.tecnicas.modelo.general.Categoria;
import fiuba.tecnicas.modelo.general.ItemCompra;
import fiuba.tecnicas.modelo.general.MedioDePago;
import fiuba.tecnicas.modelo.general.Producto;
import fiuba.tecnicas.modelo.general.Sucursal;
import fiuba.tecnicas.modelo.general.SucursalFactory;
import fiuba.tecnicas.modelo.general.TipoPago;
import fiuba.tecnicas.modelo.general.command.ICommand;
import fiuba.tecnicas.modelo.general.command.VerTotalDescuentosCajaCommand;

public class VerTotalDescuentosCommandTest {

	@Test 
	public void testCommandVerTotalDescuentosCaja() 
	{
		
		Caja.getInstance().abrir();
		Sucursal sucursal = SucursalFactory.SucursalUno();
		Caja.getInstance().addNuevaCompraActiva(sucursal);
		Caja.getInstance().getCompraActiva().setMedioDePago(new MedioDePago(TipoPago.TARJETA,"ICBC"));
		Caja.getInstance().getCompraActiva().addItem(new ItemCompra(new Producto(10.0,"COCA","COCA",Categoria.BEBIDAS),2));
		Caja.getInstance().cerrarCompraActiva();

		ICommand command = new VerTotalDescuentosCajaCommand();
		
		command.execute("");
		
		System.out.println(command.execute("").getMensaje());
	
	}
}
