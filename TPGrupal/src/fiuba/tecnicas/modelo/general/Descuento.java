package fiuba.tecnicas.modelo.general;

public class Descuento {
	private double valor;
	private String nombre;
	
	public Descuento(double valor, String nombre){
		this.valor = valor;
		this.nombre = nombre;		
	}
	
	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
