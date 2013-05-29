package fiuba.tecnicas.test.modelo;

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
		item.setProducto(new Producto(10.0,"desc","marca",Categoria.ALIMENTOS));

		compra.addItem(item);
		
		Assert.assertTrue(compra.getItems().contains(item));	
	}
	
	/*
	 * Test promo 2x1 y 10% de descuento con tarjetas XYZ los jueves
	 */
	@Test
	public void Test2x1Tarjeta(){
		Sucursal sucursal = SucursalFactory.SucursalTres();
		ItemCompra  itemCoca = new ItemCompra(new Producto(1, "Coca", "Coca Cola", Categoria.BEBIDAS),2);
		Compra compra = new Compra(sucursal);
		compra.setMedioDePago(new MedioDePago(TipoPago.TARJETA, "XYZ"));
		compra.addItem(itemCoca);
		
		ItemCompra  itemCepillo = new ItemCompra(new Producto(3, "Cepillo Dientes", "Colgate", Categoria.FARMACIA),1);
		compra.addItem(itemCepillo);
		
		ItemCompra  itemMaceta = new ItemCompra(new Producto(10, "Maceta", "Macetas", Categoria.JARDINERIA),1);
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
		Sucursal sucursal = SucursalFactory.SucursalDos();
		ItemCompra  itemVinoX = new ItemCompra(new Producto(100, "X", "X", Categoria.VINOS),2);
		Compra compra = new Compra(sucursal);
		compra.setMedioDePago(new MedioDePago(TipoPago.DEBITO, "XYZ"));
		compra.addItem(itemVinoX);
		
		ItemCompra  itemChandon = new ItemCompra(new Producto(75, "Chandon", "Chandon", Categoria.VINOS),2);
		compra.addItem(itemChandon);
		
		ItemCompra  itemCepillo = new ItemCompra(new Producto(3, "Cepillo Dientes", "Colgate", Categoria.FARMACIA),1);
		compra.addItem(itemCepillo);
		
		ItemCompra  itemMaceta = new ItemCompra(new Producto(10, "Maceta", "Macetas", Categoria.JARDINERIA),1);
		compra.addItem(itemMaceta);
		
		double totalCompra = compra.CalcularTotal();
		System.out.println(totalCompra);
		Assert.assertEquals(259.20,totalCompra);
		
		Iterator<Descuento> it = compra.getDescuentos().iterator();
		System.out.print("Descuentos aplicados: ");
		while(it.hasNext()){
			Descuento descuento = it.next();
			System.out.println(descuento.getValor()+" pesos por "+descuento.getNombre());
		}
	}
}
