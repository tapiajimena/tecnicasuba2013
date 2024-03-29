package fiuba.tecnicas.test.commands;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.tecnicas.modelo.general.Caja;
import fiuba.tecnicas.modelo.general.Categoria;
import fiuba.tecnicas.modelo.general.Compra;
import fiuba.tecnicas.modelo.general.ItemCompra;
import fiuba.tecnicas.modelo.general.MedioDePago;
import fiuba.tecnicas.modelo.general.Producto;
import fiuba.tecnicas.modelo.general.Sucursal;
import fiuba.tecnicas.modelo.general.SucursalFactory;
import fiuba.tecnicas.modelo.general.TipoPago;
import fiuba.tecnicas.modelo.general.command.ICommand;
import fiuba.tecnicas.modelo.general.command.VerTotalDescuentosCajaCommand;
import fiuba.tecnicas.modelo.servicios.ServicioCalendario;

public class VerTotalDescuentosCommandTest {

	@Test 
	public void testCommandVerTotalDescuentosCaja() 
	{
		ServicioCalendario.getInstancia().setNameDay("JUEVES");
		Caja.getInstance().abrir();
		Sucursal sucursal = SucursalFactory.SucursalUno();
		Caja.getInstance().setSucursal(sucursal);
		Caja.getInstance().addNuevaCompraActiva(sucursal);
		Caja.getInstance().getCompraActiva().setMedioDePago(new MedioDePago(TipoPago.TARJETA,"ICBC","false"));
		Caja.getInstance().getCompraActiva().addItem(new ItemCompra(new Producto(10.0,"COCA","COCA",Categoria.BEBIDAS),1));
		sucursal.CalcularDescuentos(Caja.getInstance().getCompraActiva());
		Caja.getInstance().getCompraActiva().CalcularTotal();
		Caja.getInstance().cerrarCompraActiva();

		ICommand command = new VerTotalDescuentosCajaCommand();
		
		assertEquals(command.execute("").getMensaje(),"1.0");
	
	}
}
