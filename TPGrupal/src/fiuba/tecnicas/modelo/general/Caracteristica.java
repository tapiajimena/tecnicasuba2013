package fiuba.tecnicas.modelo.general;

public class Caracteristica implements Comparable<Caracteristica> {

	
	private String tipoCaracteristica;
	private String valor;
	
	public Caracteristica(){}
	
	public Caracteristica(String tipoCaracteristica, String valor)
	{
		this.tipoCaracteristica = tipoCaracteristica;
		this.valor = valor;
				
	}
	
	public String getTipoCaracteristica() {
		return tipoCaracteristica;
	}
	public void setTipoCaracteristica(String tipoCaracteristica) {
		this.tipoCaracteristica = tipoCaracteristica;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}

	@Override
	public int compareTo(Caracteristica o) {
		if(o.getTipoCaracteristica().compareTo(this.getTipoCaracteristica()) == 0
				&& o.getValor().compareTo(this.getValor())==0)
			return 0;
		
		return -1;
	}
}
