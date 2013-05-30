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

		Caja.getInstance().setTotalPorMedioDePago(crearIndiceMediosDePago());
		HashMap<String,Double> totales = (Caja.getInstance().getTotalPorMedioDePago());
		if (totales != null && !totales.isEmpty()) {
			return new Resultado(Mensaje.getMensaje("mensaje_CalcularTotalCajaPorMedioDePago") + renderTotalesXMedioDePago(totales));
		} else {
			return new Resultado(Mensaje.getMensaje("error_ordenEjec_MedioPago"));
		}
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
