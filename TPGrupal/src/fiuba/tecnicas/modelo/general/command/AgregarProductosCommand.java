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
		if (input.isEmpty()) return new Resultado(Mensaje.getMensaje("error_param_AgregarProducto"));
		
		Compra compra = Caja.getInstance().getCompraActiva();
		if (compra == null) return new Resultado(Mensaje.getMensaje("mensaje_inicializar_compra"));
		
		if (compra != null) {
			String[] listaCodigosNuevos = input.split(Constante.getConstante("separador_parametros"));
			Set<Entry<Producto, Integer>> productosNuevos = obtenerListaProductosDeCompra(listaCodigosNuevos);
			Caja.getInstance().getCompraActiva().agregarItemsCompra(productosNuevos);
			}
			return new Resultado(Mensaje.getMensaje("mensaje_AgregarProducto"));
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
