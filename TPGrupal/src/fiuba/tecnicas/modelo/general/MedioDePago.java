package fiuba.tecnicas.modelo.general;

//TODO:armar jerarquia de medios de pago
public class MedioDePago {
   
    private String banco;
    private TipoPago tipo;
    private String isJubilado;
 
    public MedioDePago(TipoPago tipo, String banco, String isJubilado) {
        this.tipo = tipo;
        this.banco = banco;
        this.setIsJubilado(isJubilado);
    }
 
    public String getBanco() {
        return this.banco;
    }
    
    public TipoPago getTipoPago(){
    	return this.tipo;
    }
    
    public String toString() {
    	return tipo + " " + banco;
    }

	public void setIsJubilado(String isJubilado) {
		this.isJubilado = isJubilado;
	}

	public String getIsJubilado() {
		return isJubilado;
	}
}
