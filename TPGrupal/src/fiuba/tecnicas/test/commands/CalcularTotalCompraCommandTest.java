package fiuba.tecnicas.test.commands;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Test;

import fiuba.tecnicas.modelo.general.Caja;
import fiuba.tecnicas.modelo.general.ItemCompra;
import fiuba.tecnicas.modelo.general.ProductoFactory;
import fiuba.tecnicas.modelo.general.Sucursal;
import fiuba.tecnicas.modelo.general.SucursalFactory;
import fiuba.tecnicas.modelo.general.command.AbrirCajaCommand;
import fiuba.tecnicas.modelo.general.command.ICommand;

public class CalcularTotalCompraCommandTest {

	@Test 
	public void testCommandCalcularTotalCompraObtieneTotalCompra() 
	{
		Caja.getInstance().abrir();
		Sucursal sucursal = SucursalFactory.SucursalUno();
		Caja.getInstance().addNuevaCompraActiva(sucursal);
		Caja.getInstance().getCompraActiva().addItem(new ItemCompra(ProductoFactory.getInstance().getProducto("COCA"),2));
		
		//Se aplica la oferta 2x1
		assertTrue(Caja.getInstance().getTotalVentasCaja() == 1.0);
	}

}
