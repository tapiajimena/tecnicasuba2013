package fiuba.tecnicas.modelo.comun;

public class Resultado {
	private String mensaje;
	private Boolean exito;
	
	public Resultado() {}
	
	public Resultado(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public Resultado(Boolean exito) {
		this.exito = exito;
	}
	
	public Resultado(String mensaje, boolean exito) {
		this.exito = exito;
		this.mensaje = mensaje;
	}
	
	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public Boolean getExito() {
		return exito;
	}
	
	public void setExito(Boolean exito) {
		this.exito = exito;
	}
	
}
