package BusinessLogic.Entities;

import Infrastructure.Tools.CMD;

public abstract class aeTipoArma {


    private String tipo;

   
    public aeTipoArma(String tipo) {
        setTipo(tipo);
    }

    public void accionArmar(aeTipoArma tipoArma, aeTipoMunicion tipoMunicion) {
        CMD.traceGood(
        tipoArma.getTipo() + " " +
        this.getClass().getSimpleName() + " " +
        tipoMunicion.getTipo()
    );}

    
     public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
