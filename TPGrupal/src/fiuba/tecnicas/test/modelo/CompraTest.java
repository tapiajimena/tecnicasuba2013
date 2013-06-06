package fiuba.tecnicas.test.modelo;

import java.net.ProxySelector;
import java.util.Iterator;
import junit.framework.Assert;
import org.junit.Test;
import static org.mockito.Mockito.*;

import fiuba.tecnicas.modelo.general.Categoria;
import fiuba.tecnicas.modelo.general.Compra;
import fiuba.tecnicas.modelo.general.Descuento;
import fiuba.tecnicas.modelo.general.ItemCompra;
import fiuba.tecnicas.modelo.general.MedioDePago;
import fiuba.tecnicas.modelo.general.Producto;
import fiuba.tecnicas.modelo.general.ProductoFactory;
import fiuba.tecnicas.modelo.general.Sucursal;
import fiuba.tecnicas.modelo.general.SucursalFactory;
import fiuba.tecnicas.modelo.general.TipoPago;
import fiuba.tecnicas.modelo.servicios.ServicioCalendario;

public class CompraTest {
	
	/*
	 * Test promo 2x1 y 10% de descuento con tarjetas XYZ los jueves
	 */
	@Test
	public void Test2x1Tarjeta(){
		
		ServicioCalendario.getInstancia().setNameDay("JUEVES");
		
		Sucursal sucursal = SucursalFactory.getSucursalByName("uno");
		ItemCompra  itemCoca = new ItemCompra(ProductoFactory.getInstance().getProducto("Coca"),2);
		Compra compra = new Compra(sucursal);
		compra.setMedioDePago(new MedioDePago(TipoPago.TARJETA, "XYZ", "false"));
		compra.addItem(itemCoca);
		
		ItemCompra  itemCepillo = new ItemCompra(ProductoFactory.getInstance().getProducto("CepilloDientes"),1);
		compra.addItem(itemCepillo);
		
		ItemCompra  itemMaceta = new ItemCompra(ProductoFactory.getInstance().getProducto("Maceta"),1);
		compra.addItem(itemMaceta);
		
		
		double totalCompra = compra.CalcularTotal();
		System.out.println(totalCompra);
		Assert.assertEquals(12.60,totalCompra);
		
		Iterator<Descuento> it = compra.getDescuentos().iterator();
		System.out.print("Descuentos aplicados: ");
		while(it.hasNext()){
			Descuento descuento = it.next();
			System.out.println(descuento.getValor()+" pesos por "+descuento.getNombre());
		}
	}
	
	/*
	 * Test promo 2da unidad igual 75% desc en Vinoteca. (Excepto marcas Chandon) y debito el lunes
	 */
	@Test
	public void TestSegundaUnidadLunes(){
		
		ServicioCalendario.getInstancia().setNameDay("LUNES");
		Sucursal sucursal = SucursalFactory.getSucursalByName("dos");
		Compra compra = new Compra(sucursal);
		compra.setMedioDePago(new MedioDePago(TipoPago.DEBITO, "XYZ","false"));
		
		ItemCompra  itemVinoX = new ItemCompra(ProductoFactory.getInstance().getProducto("X"),2);
		compra.addItem(itemVinoX);
		
		ItemCompra  itemChandon = new ItemCompra(ProductoFactory.getInstance().getProducto("Chandon"),2);
		compra.addItem(itemChandon);
		
		ItemCompra  itemCepillo = new ItemCompra(ProductoFactory.getInstance().getProducto("CepilloDientes"),1);
		compra.addItem(itemCepillo);
		
		ItemCompra  itemMaceta = new ItemCompra(ProductoFactory.getInstance().getProducto("Maceta"),1);
		compra.addItem(itemMaceta);
		
		double totalCompra = compra.CalcularTotal();
		
		//Assert.assertEquals(259.20,totalCompra);

		Iterator<Descuento> it = compra.getDescuentos().iterator();
		System.out.print("Descuentos aplicados: ");
		
		while(it.hasNext()){
			Descuento descuento = it.next();
			System.out.println(descuento.getValor()+" pesos por "+descuento.getNombre());
		}
	}
	
	/*
	 * Test promo 2da unidad igual 75% desc en Vinoteca. (Excepto marcas Chandon) y debito el lunes
	 */
	@Test
	public void MarcaXYZ(){
		
		ServicioCalendario.getInstancia().setNameDay("LUNES");
		Sucursal sucursal = SucursalFactory.getSucursalByName("tres");
		Compra compra = new Compra(sucursal);
		
		ItemCompra  itemV = new ItemCompra(ProductoFactory.getInstance().getProducto("VinoELL"),2);
		
		compra.addItem(itemV);
		
		ItemCompra  itemC = new ItemCompra(ProductoFactory.getInstance().getProducto("VinoXYZ"),1);
		compra.addItem(itemC);
		
		ItemCompra  itemCepillo = new ItemCompra(ProductoFactory.getInstance().getProducto("VinoLLL"),1);
		compra.addItem(itemCepillo);

		double totalCompra = compra.CalcularTotal();
		System.out.println(totalCompra);
		
		
		Iterator<Descuento> it = compra.getDescuentos().iterator();
		System.out.print("Descuentos aplicados: ");
		while(it.hasNext()){
			Descuento descuento = it.next();
			System.out.println(descuento.getValor()+" pesos por "+descuento.getNombre());
		}
		
		Assert.assertEquals(68.0,totalCompra);
	}
	
	@Test
	public void TestNxMTarjeta(){
		
		Sucursal sucursal = SucursalFactory.getSucursalByName("cuatro");
		ItemCompra  itemCoca = new ItemCompra(ProductoFactory.getInstance().getProducto("Coca"),3);
		Compra compra = new Compra(sucursal);
		compra.setMedioDePago(new MedioDePago(TipoPago.TARJETA, "XYZ","false"));
		compra.addItem(itemCoca);
		
		ItemCompra  itemCepillo = new ItemCompra(ProductoFactory.getInstance().getProducto("CepilloDientes"),1);
		compra.addItem(itemCepillo);
		
		ItemCompra  itemMaceta = new ItemCompra(ProductoFactory.getInstance().getProducto("Maceta"),1);
		compra.addItem(itemMaceta);
		
		
		double totalCompra = compra.CalcularTotal();
		System.out.println(totalCompra);
		//Assert.assertEquals(15.00,totalCompra);
		
		Iterator<Descuento> it = compra.getDescuentos().iterator();
		System.out.print("Descuentos aplicados: ");
		while(it.hasNext()){
			Descuento descuento = it.next();
			System.out.println(descuento.getValor()+" pesos por "+descuento.getNombre());
		}
	}

	@Test
	public void TestJubilado(){		
		Sucursal sucursal = SucursalFactory.getSucursalByName("cinco");

		Compra compra = new Compra(sucursal);

		compra.setMedioDePago(new MedioDePago(TipoPago.DEBITO, "XYZ", "true"));
		
		ItemCompra  itemMaceta = new ItemCompra(ProductoFactory.getInstance().getProducto("Maceta"),1);
		compra.addItem(itemMaceta);
		
		ItemCompra  itemLamparita = new ItemCompra(ProductoFactory.getInstance().getProducto("Lamparita"),2);
		compra.addItem(itemLamparita);
		
		double totalCompra = compra.CalcularTotal();
		System.out.println(totalCompra);
		Assert.assertEquals(36.00,totalCompra);
		
		Iterator<Descuento> it = compra.getDescuentos().iterator();
		System.out.print("Descuentos aplicados: ");
		while(it.hasNext()){
			Descuento descuento = it.next();
			System.out.println(descuento.getValor()+" pesos por "+descuento.getNombre());
		}
	}
	
	@Test
	public void TestBono(){		
		Sucursal sucursal = SucursalFactory.getSucursalByName("seis");

		Compra compra = new Compra(sucursal);

		compra.setMedioDePago(new MedioDePago(TipoPago.DEBITO, "XYZ", "true"));
		
		ItemCompra  itemCoca = new ItemCompra(ProductoFactory.getInstance().getProducto("Coca"),10);
		compra.addItem(itemCoca);
		
		double totalCompra = compra.CalcularTotal();
		System.out.println(totalCompra);
		Assert.assertEquals(5.0,totalCompra);
		
		Iterator<Descuento> it = compra.getDescuentos().iterator();
		System.out.println("Descuentos aplicados: ");
		while(it.hasNext()){
			Descuento descuento = it.next();
			System.out.println(descuento.getValor()+" pesos por "+descuento.getNombre());
		}
		
		Iterator<Descuento> i = compra.getBonos().iterator();
		System.out.print("Bono: ");
		while(i.hasNext()){
			Descuento bono = i.next();
			System.out.println(bono.getValor()+" pesos por "+bono.getNombre());
		}
	}
}
