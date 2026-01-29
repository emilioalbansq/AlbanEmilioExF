package DataAccess.DTOs;

public class aeExoBotDTO {
    private Integer idExoBot;
    private Integer idIABot;
    private Integer idTipoExoBot;
    private String entreno;
    private Integer noAccion;
    private String estado;
    private String fechaCreacion;
    private String fechaModifica;

    public aeExoBotDTO() {}

    public Integer getIdExoBot() {
        return idExoBot;
    }

    public void setIdExoBot(Integer idExoBot) {
        this.idExoBot = idExoBot;
    }

    public Integer getIdIABot() {
        return idIABot;
    }

    public void setIdIABot(Integer idIABot) {
        this.idIABot = idIABot;
    }

    public Integer getIdTipoExoBot() {
        return idTipoExoBot;
    }

    public void setIdTipoExoBot(Integer idTipoExoBot) {
        this.idTipoExoBot = idTipoExoBot;
    }

    public String getEntreno() {
        return entreno;
    }

    public void setEntreno(String entreno) {
        this.entreno = entreno;
    }

    public Integer getNoAccion() {
        return noAccion;
    }

    public void setNoAccion(Integer noAccion) {
        this.noAccion = noAccion;
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
            + "\n idExoBot =      " + getIdExoBot()
            + "\n idIABot =       " + getIdIABot()
            + "\n idTipoExoBot =  " + getIdTipoExoBot()
            + "\n entreno =       " + getEntreno()
            + "\n noAccion =      " + getNoAccion()
            + "\n estado =        " + getEstado()
            + "\n fechaCreacion = " + getFechaCreacion()
            + "\n fechaModifica = " + getFechaModifica();
    }
}
