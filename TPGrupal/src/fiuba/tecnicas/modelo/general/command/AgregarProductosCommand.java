package fiuba.tecnicas.modelo.general.command;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import fiuba.tecnicas.modelo.comun.Constante;
import fiuba.tecnicas.modelo.comun.Mensaje;
import fiuba.tecnicas.modelo.comun.Resultado;
import fiuba.tecnicas.modelo.general.Caja;
import fiuba.tecnicas.modelo.general.Compra;
import fiuba.tecnicas.modelo.general.ItemCompra;
import fiuba.tecnicas.modelo.general.Producto;
import fiuba.tecnicas.modelo.general.ProductoFactory;

/**
 * Comando para agregar productos Agrega los productos correspondientes a una
 * compra.
 * 
 */
public class AgregarProductosCommand implements ICommand {

	@Override
	public Resultado execute(String input) {
		Compra compra = Caja.getInstance().getCompraActiva();

		if (compra != null && !input.isEmpty()) {
			String[] listaCodigosNuevos;
			listaCodigosNuevos = input.split(Constante
					.getConstante("separador_parametros"));

			Set<Entry<Producto, Integer>> productosNuevos = obtenerListaProductosDeCompra(listaCodigosNuevos);
			Iterator<Entry<Producto, Integer>> it_productosNuevos = productosNuevos
					.iterator();

			while (it_productosNuevos.hasNext()) {
				Entry<Producto, Integer> productoNuevo = it_productosNuevos
						.next();
				ItemCompra itemNuevo = new ItemCompra(productoNuevo.getKey(),
						productoNuevo.getValue());
				if (!compra.getItems().isEmpty()
						&& compra.getItems().contains(itemNuevo)) {
					int index = compra.getItems().indexOf(itemNuevo);
					compra.getItems().get(index)
							.aumentarCantidad(productoNuevo.getValue());
				} else {
					compra.addItem(itemNuevo);
				}
			}
			return new Resultado(Mensaje.getMensaje("mensaje_AgregarProducto"));
		} else {
			if (input.isEmpty())
				return new Resultado(
						Mensaje.getMensaje("error_param_AgregarProducto"));
			return new Resultado(
					Mensaje.getMensaje("mensaje_inicializar_compra"));
		}
	}

	private Set<Entry<Producto, Integer>> obtenerListaProductosDeCompra(
			String[] codigosProductos) {
		Map<Producto, Integer> productos = new HashMap<Producto, Integer>();
		for (int i = 0; i < codigosProductos.length; i++) {
			Producto productoNuevo = ProductoFactory.getInstance().getProducto(
					codigosProductos[i]);
			if (productoNuevo != null) {
				if (productos.containsKey(productoNuevo)) {
					int cantidad = productos.get(productoNuevo);
					cantidad++;
					productos.remove(productoNuevo);
					productos.put(productoNuevo, cantidad);
				} else {
					productos.put(productoNuevo, 1);
				}
			}
		}
		return productos.entrySet();
	}
}
