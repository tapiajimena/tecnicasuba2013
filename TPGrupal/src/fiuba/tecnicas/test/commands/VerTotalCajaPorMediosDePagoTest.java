package fiuba.tecnicas.test.commands;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.tecnicas.modelo.comun.Mensaje;
import fiuba.tecnicas.modelo.general.Caja;
import fiuba.tecnicas.modelo.general.Categoria;
import fiuba.tecnicas.modelo.general.ItemCompra;
import fiuba.tecnicas.modelo.general.MedioDePago;
import fiuba.tecnicas.modelo.general.Producto;
import fiuba.tecnicas.modelo.general.Sucursal;
import fiuba.tecnicas.modelo.general.SucursalFactory;
import fiuba.tecnicas.modelo.general.TipoPago;
import fiuba.tecnicas.modelo.general.command.ICommand;
import fiuba.tecnicas.modelo.general.command.VerTotalCajaPorMediosDePagoCommand;
import fiuba.tecnicas.modelo.servicios.ServicioCalendario;

public class VerTotalCajaPorMediosDePagoTest {

	@Test
	public void testCommandVerTotalCajaXMedioPagoCalculaTotal() {
		
		ServicioCalendario.getInstancia().setNameDay("JUEVES");
		Caja.getInstance().abrir();
		Sucursal sucursal = SucursalFactory.SucursalUno();
		Caja.getInstance().addNuevaCompraActiva(sucursal);
		Caja.getInstance().getCompraActiva().setMedioDePago(new MedioDePago(TipoPago.TARJETA,"ICBC","false"));
		Caja.getInstance().getCompraActiva().addItem(new ItemCompra(new Producto(10.0,"desc","marca",Categoria.ALIMENTOS),3));
		Caja.getInstance().getCompraActiva().addItem(new ItemCompra(new Producto(5.0,"desc","marca",Categoria.ALIMENTOS),2));
		Caja.getInstance().cerrarCompraActiva();
		Caja.getInstance().addNuevaCompraActiva(sucursal);
		Caja.getInstance().getCompraActiva().setMedioDePago(new MedioDePago(TipoPago.EFECTIVO,"","false"));
		Caja.getInstance().getCompraActiva().addItem(new ItemCompra(new Producto(5.0,"desc","marca",Categoria.ALIMENTOS),2));
		Caja.getInstance().cerrarCompraActiva();
		
		ICommand command = new VerTotalCajaPorMediosDePagoCommand();

		//Aplica la oferta del 10% con tarjeta
		assertEquals("Los totales calculados por medio de pago son: [TARJETA=36.0, DEBITO=0.0, EFECTIVO=10.0]",command.execute("").getMensaje());
		
		
	}

}
