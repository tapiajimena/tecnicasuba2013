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
