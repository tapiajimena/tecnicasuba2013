package fiuba.tecnicas.modelo.general.command;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import fiuba.tecnicas.modelo.comun.Mensaje;
import fiuba.tecnicas.modelo.comun.Resultado;
import fiuba.tecnicas.modelo.general.Caja;
import fiuba.tecnicas.modelo.general.Compra;
import fiuba.tecnicas.modelo.general.ItemCompra;
import fiuba.tecnicas.modelo.general.MedioDePago;
import fiuba.tecnicas.modelo.general.TipoPago;

public class VerTotalCajaPorMediosDePagoCommand implements ICommand {

	@Override
	public Resultado execute(String input) {

		List<Compra> comprasDeCaja = Caja.getInstance().getComprasDeCaja();
		HashMap<String, Double> totales = crearIndiceMediosDePago();

		if (comprasDeCaja != null && !comprasDeCaja.isEmpty()) {
			Iterator<Compra> it_comprasDeCaja = comprasDeCaja.iterator();

			while (it_comprasDeCaja.hasNext()) {
				Compra compra = it_comprasDeCaja.next();
				MedioDePago medioUsado = compra.getMedioDePago();
				if (totales.containsKey(medioUsado.getTipoPago().name())) {
					double totalAux = totales.get(medioUsado.getTipoPago().name());
					totalAux += compra.getTotalCompraSinDescuentos();
					totales.remove(medioUsado);
					totales.put(medioUsado.getTipoPago().name(), totalAux);
				}
			}
		} else {
			return new Resultado(Mensaje.getMensaje("error_ordenEjec_MedioPago"));
		}

		return new Resultado(Mensaje.getMensaje("mensaje_CalcularTotalCajaPorMedioDePago") + renderTotalesXMedioDePago(totales));
	}

	private String renderTotalesXMedioDePago(HashMap<String,Double> totales) {
		return totales.entrySet().toString();
	}
	
	private HashMap<String, Double> crearIndiceMediosDePago() {
		HashMap<String, Double> totales = new HashMap<String, Double>();
		for (TipoPago tp : TipoPago.values()) {
			totales.put(tp.name(), 0.0);
		}
		return totales;
	}

}
