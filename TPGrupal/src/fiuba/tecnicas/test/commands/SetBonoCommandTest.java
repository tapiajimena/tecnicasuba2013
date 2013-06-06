package fiuba.tecnicas.test.commands;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.security.Provider.Service;
import java.util.Iterator;

import org.junit.Test;

import fiuba.tecnicas.modelo.comun.Mensaje;
import fiuba.tecnicas.modelo.general.Caja;
import fiuba.tecnicas.modelo.general.Categoria;
import fiuba.tecnicas.modelo.general.Compra;
import fiuba.tecnicas.modelo.general.Descuento;
import fiuba.tecnicas.modelo.general.ItemCompra;
import fiuba.tecnicas.modelo.general.Producto;
import fiuba.tecnicas.modelo.general.ProductoFactory;
import fiuba.tecnicas.modelo.general.Sucursal;
import fiuba.tecnicas.modelo.general.SucursalFactory;
import fiuba.tecnicas.modelo.general.command.ICommand;
import fiuba.tecnicas.modelo.general.command.SetBonoCommand;
import fiuba.tecnicas.modelo.servicios.ServicioCalendario;

public class SetBonoCommandTest {

	
	public void testCommandSetBono() 
	{	
		Sucursal sucursal = SucursalFactory.SucursalSeis();
		Caja.getInstance().abrir();
		Caja.getInstance().addNuevaCompraActiva(sucursal);

		Compra compraActiva = Caja.getInstance().getCompraActiva();
		ItemCompra itemCoca = new ItemCompra(ProductoFactory.getInstance().getProducto("COCA"),10);
		compraActiva.addItem(itemCoca);
		ICommand command = new SetBonoCommand();
		
		System.out.println(command.execute("10").getMensaje());
		
		//aplica descuento del 2x1
		assertEquals(command.execute("10").getMensaje(),Mensaje.getMensaje("mensaje_CalcularTotalCompra") + " " + "8.0");

	}

}
