package fiuba.tecnicas.modelo.general;

public enum DiaSemana {
	DOMINGO(1), LUNES(2), MARTES(3), MIERCOLES(4), JUEVES(5), VIERNES(6), SABADO(7);
	
	private int numeroDia;
	
	DiaSemana(int num) {
		this.numeroDia = num;
	}
}

