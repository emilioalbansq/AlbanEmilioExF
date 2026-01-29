package DataAccess.DTOs;

public class aeIABotDTO {
    private Integer idIABot;
    private String nombre;
    private String descripcion;
    private String estado;
    private String fechaCreacion;
    private String fechaModifica;

    public aeIABotDTO() {}

    public aeIABotDTO(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Integer getIdIABot() {
        return idIABot;
    }

    public void setIdIABot(Integer idIABot) {
        this.idIABot = idIABot;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
            + "\n idIABot =       " + getIdIABot()
            + "\n nombre =        " + getNombre()
            + "\n descripcion =   " + getDescripcion()
            + "\n estado =        " + getEstado()
            + "\n fechaCreacion = " + getFechaCreacion()
            + "\n fechaModifica = " + getFechaModifica();
    }
}
