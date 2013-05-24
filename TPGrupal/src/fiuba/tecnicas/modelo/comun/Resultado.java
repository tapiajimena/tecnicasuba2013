package fiuba.tecnicas.modelo.comun;

public class Resultado {
	private String mensaje;

	public Resultado() {}
	public Resultado(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
}
