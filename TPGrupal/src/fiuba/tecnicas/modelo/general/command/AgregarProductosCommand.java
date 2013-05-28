package fiuba.tecnicas.modelo.general.command;

import java.util.Iterator;

import fiuba.tecnicas.modelo.comun.Constante;
import fiuba.tecnicas.modelo.comun.Mensaje;
import fiuba.tecnicas.modelo.comun.Resultado;
import fiuba.tecnicas.modelo.general.Caja;
import fiuba.tecnicas.modelo.general.Compra;
import fiuba.tecnicas.modelo.general.ItemCompra;
import fiuba.tecnicas.modelo.general.Producto;
import fiuba.tecnicas.modelo.general.ProductoFactory;

/**
 * Comando para agregar productos
 * Agrega los productos correspondientes a una compra.
 *
 */
public class AgregarProductosCommand implements ICommand {

	@Override
	public Resultado execute(String input) {
		Producto p = null;
		int y = 0;
		String[] listaCodigos;
		listaCodigos = input.split(Constante.getConstante("separador_parametros"));
		ProductoFactory pf = ProductoFactory.getInstance();
		Compra compra = Caja.getInstance().getCompraActiva();
		if (compra != null){
			Iterator<ItemCompra> it = compra.getItems().iterator();
			boolean isagregado = false;
			if (compra.getItems().isEmpty() && listaCodigos.length > 0) {
				p = pf.getProducto(listaCodigos[0].trim());
				compra.addItem(new ItemCompra(p, 1));
				y = 1;
			}
			if (!compra.getItems().isEmpty() && listaCodigos.length > 0) {
				for (int x=y ;x<listaCodigos.length;x++){
					p = pf.getProducto(listaCodigos[x].trim());
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
			}
			return new Resultado(Mensaje.getMensaje("mensaje_AgregarProducto"));
		}else{
			return new Resultado(Mensaje.getMensaje("mensaje_inicializar_compra"));
		}
	}
}
