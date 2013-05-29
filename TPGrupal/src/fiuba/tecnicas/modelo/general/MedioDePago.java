package fiuba.tecnicas.modelo.general;

//TODO:armar jerarquia de medios de pago
public class MedioDePago {
   
    private String banco;
    private TipoPago tipo;
 
    public MedioDePago(TipoPago tipo, String banco) {
        this.tipo = tipo;
        this.banco = banco;
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
}
