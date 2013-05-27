package fiuba.tecnicas.test.modelo;


import java.util.Calendar;

import junit.framework.Assert;
import org.junit.Test;
import static org.mockito.Mockito.*;

import fiuba.tecnicas.modelo.general.Categoria;
import fiuba.tecnicas.modelo.general.Compra;
import fiuba.tecnicas.modelo.general.ItemCompra;
import fiuba.tecnicas.modelo.general.MedioDePago;
import fiuba.tecnicas.modelo.general.Producto;
import fiuba.tecnicas.modelo.general.Sucursal;
import fiuba.tecnicas.modelo.general.SucursalFactory;
import fiuba.tecnicas.modelo.general.TipoPago;
import fiuba.tecnicas.modelo.servicios.ServicioCalendario;

public class CompraTest {
	
	@Test 
	public void testCompraSetFecha() 
	{
		Compra compra = new Compra(null);
		String diaHoy = ServicioCalendario.getTodayDayOfTheWeekToString();
		
		Assert.assertEquals(compra.getDiaDeCompra(),diaHoy);	
	}
	
	@Test 
	public void testCompraAddItem() 
	{
		Compra compra = new Compra(null);
		ItemCompra item = mock(ItemCompra.class);
		item.setProducto(null);
		item.setCantidad(2);
		item.setPrecioFinal(10);
		
		compra.addItem(item);
		
		Assert.assertTrue(compra.getItems().contains(item));	
	}
	
	@Test 
	public void TestCompra10PorcientoFarmacia() 
	{
		// Contexto
		Sucursal sucursal = SucursalFactory.SucursalUno();
		Compra compra = new Compra(sucursal);
		ItemCompra  itemConDescuento = new ItemCompra(new Producto(10, "Ibuprofeno", "Ibupirac", Categoria.FARMACIA),5);
		compra.inicializarCompra(sucursal, new MedioDePago(TipoPago.EFECTIVO, ""));
		compra.addItem(itemConDescuento);
		
		ItemCompra itemSinDescuento = new ItemCompra(new Producto(1,"Coca","Coca Cola",Categoria.BEBIDAS),10);
		compra.addItem(itemSinDescuento);
		
		// Calculo
		double totalCompra = compra.CalcularTotal();
		System.out.println(totalCompra);
		Assert.assertEquals(totalCompra, 55.0);	
	}
	
	@Test
	public void TestCompra2x1(){
		Sucursal sucursal = SucursalFactory.SucursalDos();
		ItemCompra item = new ItemCompra(new Producto(1,"Coca","Coca Cola",Categoria.BEBIDAS),12);
		Compra compra = new Compra(sucursal);
		compra.inicializarCompra(sucursal, new MedioDePago(TipoPago.EFECTIVO,""));
		compra.addItem(item);
		
		double totalCompra = compra.CalcularTotal();
		System.out.println("Total sin descuentos: "+totalCompra);
		Assert.assertEquals(item.getPrecioFinal(), 6.0);
	}	
	
	@Test
	public void TestCompraTarjeta10Porciento(){
		Sucursal sucursal = SucursalFactory.SucursalTres();
		ItemCompra  item = new ItemCompra(new Producto(10, "Champagne Extra Brut", "Chandon", Categoria.BEBIDAS),5);
		Compra compra = new Compra(sucursal);
		compra.inicializarCompra(sucursal, new MedioDePago(TipoPago.TARJETA, "XYZ"));
		compra.addItem(item);
		
		double totalCompra = compra.CalcularTotal();
		System.out.println(totalCompra);
		Assert.assertEquals(totalCompra, 45.0);
	}
	
	@Test
	public void TestCompraTarjeta10PorcientoJueves(){
		Sucursal sucursal = SucursalFactory.SucursalCuatro();
		ItemCompra  item = new ItemCompra(new Producto(10, "Champagne Extra Brut", "Chandon", Categoria.BEBIDAS),5);
		Compra compra = new Compra(sucursal);
		compra.inicializarCompra(sucursal, new MedioDePago(TipoPago.TARJETA, "XYZ"),Calendar.getInstance());
		compra.addItem(item);
		
		double totalCompra = compra.CalcularTotal();
		System.out.println(totalCompra);
		Assert.assertEquals(totalCompra, 45.0);
	}
}
