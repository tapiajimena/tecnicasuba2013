package fiuba.tecnicas.modelo.general;

public class Caracteristica implements Comparable<Caracteristica> {

	
	private String tipoCaracteristica;
	private String valor;
	private CaracteristicaAplicoA objetoAlQueAplico;
	private int valorSiExisteLaCaracteristica;
	
	public Caracteristica(){}
	
	public Caracteristica(String tipoCaracteristica, String valor, CaracteristicaAplicoA tipoObjetoAlQueAplico)
	{
		this.tipoCaracteristica = tipoCaracteristica;
		this.valor = valor.toUpperCase();
		this.objetoAlQueAplico = tipoObjetoAlQueAplico;
				
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
			return getValorSiExisteLaCaracteristica();
		
		return -1;
	}

	public CaracteristicaAplicoA getObjetoAlQueAplico() {
		return objetoAlQueAplico;
	}

	public void setObjetoAlQueAplico(CaracteristicaAplicoA objetoAlQueAplico) {
		this.objetoAlQueAplico = objetoAlQueAplico;
	}

	public int getValorSiExisteLaCaracteristica() {
		return valorSiExisteLaCaracteristica;
	}

	public void setValorSiExisteLaCaracteristica(
			int valorSiExisteLaCaracteristica) {
		this.valorSiExisteLaCaracteristica = valorSiExisteLaCaracteristica;
	}
}
