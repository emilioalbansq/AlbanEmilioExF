package BusinessLogic.Entities;

public abstract class aeTipoMunicion {
    private String tipo;


    public aeTipoMunicion(String tipo) {
        this.tipo = tipo;
    }

    public aeTipoMunicion() {
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


}
