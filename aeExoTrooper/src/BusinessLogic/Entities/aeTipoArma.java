package BusinessLogic.Entities;

public abstract class aeTipoArma {


    private String tipo;

   
    public aeTipoArma(String tipo) {
        setTipo(tipo);
    }

    public void accionArmar(aeTipoArma tipoArma, aeTipoMunicion tipoMunicion) {
        // Implementación de la acción de armar con el tipo de arma específico
    }

     public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
