package fiuba.tecnicas.modelo.general.command;

import java.util.ArrayList;
import java.util.Iterator;

import fiuba.tecnicas.modelo.comun.Resultado;
import fiuba.tecnicas.modelo.general.Compra;
import fiuba.tecnicas.modelo.general.ItemCompra;
import fiuba.tecnicas.modelo.general.Producto;
import fiuba.tecnicas.modelo.general.ProductoFactory;

public class AgregarProductosCommand implements ICommand {

	@Override
	public Resultado execute(String input) {
		String[] listaCodigos;
		listaCodigos = input.split("\\,");
		ProductoFactory pf = ProductoFactory.getInstance();
		Compra compra = Compra.getInstance();
		Iterator<ItemCompra> it = compra.iterator();
		boolean isagregado = false;
		for (int x=0;x<listaCodigos.length;x++){
			Producto p = pf.getProducto(listaCodigos[x]);
			while (it.hasNext() && !isagregado){
				ItemCompra item = it.next(); 
				if (item.getProducto().getCodigo_producto() == p.getCodigo_producto()){
					item.setCantidad(item.getCantidad() + 1);
					isagregado = true;
				}
			}
			if (!isagregado){
				compra.addItem(new ItemCompra(p, 1));
			}
		}
		return new Resultado("Productos agregados a la compra");
	}
}
