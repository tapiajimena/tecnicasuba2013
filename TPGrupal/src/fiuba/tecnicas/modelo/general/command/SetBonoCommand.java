package fiuba.tecnicas.modelo.general.command;

import fiuba.tecnicas.modelo.comun.Mensaje;
import fiuba.tecnicas.modelo.comun.Resultado;

import fiuba.tecnicas.modelo.general.Caja;
import fiuba.tecnicas.modelo.general.Compra;
import fiuba.tecnicas.modelo.servicios.validacion.ServicioValidacion;

public class SetBonoCommand implements ICommand {

	@Override
	public Resultado execute(String input) {
		Compra compraActiva = Caja.getInstance().getCompraActiva();
		Resultado resultado = ServicioValidacion.validarEjecucionComandoAgregarProductos(compraActiva);
		if (resultado.getExito()) {
			double valorSinDescuento = new Double(input);
			
			/*
			 * El tope del valor del descuento es del 20% del total de la compra
			 */
			double totalCompra = compraActiva.CalcularTotal();
			double topeDescuento = valorSinDescuento*0.20;

			double total;
			if(valorSinDescuento>topeDescuento)
				total = totalCompra - topeDescuento;
			else
				total = totalCompra - valorSinDescuento;
			
			compraActiva.setTotalCompra(total);
			String stringCosto = new Double(total).toString();
			String stringBono = new Double(compraActiva.getTotalBonosCompra()).toString();
			
			resultado.setMensaje(Mensaje.getMensaje("mensaje_CalcularTotalCompra")+ " " + stringCosto+" "+Mensaje.getMensaje("mensaje_CalcularTotalBono")+ " " + stringBono);
		}
		return resultado;
	}
}
