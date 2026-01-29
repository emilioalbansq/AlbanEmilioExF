package DataAccess.DTOs;

public class aeExoBotArmaDTO {
    private Integer idExoBotArma;
    private Integer idExoBot;
    private Integer idTipoArma;
    private Integer idTipoEnergia;
    private Integer idAccionArma;
    private Integer noAccion;
    private String descripcion;
    private String estado;
    private String fechaCreacion;
    private String fechaModifica;

    public aeExoBotArmaDTO() {}

    public Integer getIdExoBotArma() {
        return idExoBotArma;
    }

    public void setIdExoBotArma(Integer idExoBotArma) {
        this.idExoBotArma = idExoBotArma;
    }

    public Integer getIdExoBot() {
        return idExoBot;
    }

    public void setIdExoBot(Integer idExoBot) {
        this.idExoBot = idExoBot;
    }

    public Integer getIdTipoArma() {
        return idTipoArma;
    }

    public void setIdTipoArma(Integer idTipoArma) {
        this.idTipoArma = idTipoArma;
    }

    public Integer getIdTipoEnergia() {
        return idTipoEnergia;
    }

    public void setIdTipoEnergia(Integer idTipoEnergia) {
        this.idTipoEnergia = idTipoEnergia;
    }

    public Integer getIdAccionArma() {
        return idAccionArma;
    }

    public void setIdAccionArma(Integer idAccionArma) {
        this.idAccionArma = idAccionArma;
    }

    public Integer getNoAccion() {
        return noAccion;
    }

    public void setNoAccion(Integer noAccion) {
        this.noAccion = noAccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getFechaModifica() {
        return fechaModifica;
    }

    public void setFechaModifica(String fechaModifica) {
        this.fechaModifica = fechaModifica;
    }

    @Override
    public String toString() {
        return "\n" + getClass().getName()
            + "\n idExoBotArma =  " + getIdExoBotArma()
            + "\n idExoBot =      " + getIdExoBot()
            + "\n idTipoArma =    " + getIdTipoArma()
            + "\n idTipoEnergia = " + getIdTipoEnergia()
            + "\n idAccionArma =  " + getIdAccionArma()
            + "\n noAccion =      " + getNoAccion()
            + "\n descripcion =   " + getDescripcion()
            + "\n estado =        " + getEstado()
            + "\n fechaCreacion = " + getFechaCreacion()
            + "\n fechaModifica = " + getFechaModifica();
    }
}
