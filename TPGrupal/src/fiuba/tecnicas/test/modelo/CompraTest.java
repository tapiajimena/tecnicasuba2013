package fiuba.tecnicas.test.modelo;

import static org.junit.Assert.*;

import java.util.ArrayList;

import javax.security.auth.Subject;

import junit.framework.Assert;

import org.junit.Test;

import fiuba.tecnicas.modelo.general.Compra;
import fiuba.tecnicas.modelo.general.ItemCompra;
import fiuba.tecnicas.modelo.general.Oferta;
import fiuba.tecnicas.modelo.general.Producto;
import fiuba.tecnicas.modelo.general.Sucursal;

public class CompraTest {

	@Test
	public void TestCompraDescuentoTarjeta10PorCien() {
		Sucursal sucursal = new Sucursal(new Oferta());
		Compra compra = new Compra(sucursal);
		ItemCompra  item = new ItemCompra(new Producto(10, "Chandon"),5);
		compra.addItem(item);
		compra.CalcularTotal();
		
		Assert.assertEquals(item.getPrecioFinal(), 10);
		
	}

}
