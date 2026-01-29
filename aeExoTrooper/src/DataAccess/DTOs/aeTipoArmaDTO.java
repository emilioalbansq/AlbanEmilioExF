package DataAccess.DTOs;

public class aeTipoArmaDTO {
    private Integer idTipoArma;
    private String nombre;
    private String tipoRecursos;
    private String estado;
    private String fechaCreacion;
    private String fechaModifica;

    public aeTipoArmaDTO() {}

    public aeTipoArmaDTO(String nombre, String tipoRecursos) {
        this.nombre = nombre;
        this.tipoRecursos = tipoRecursos;
    }

    public Integer getIdTipoArma() {
        return idTipoArma;
    }

    public void setIdTipoArma(Integer idTipoArma) {
        this.idTipoArma = idTipoArma;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoRecursos() {
        return tipoRecursos;
    }

    public void setTipoRecursos(String tipoRecursos) {
        this.tipoRecursos = tipoRecursos;
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
            + "\n idTipoArma =    " + getIdTipoArma()
            + "\n nombre =        " + getNombre()
            + "\n tipoRecursos =  " + getTipoRecursos()
            + "\n estado =        " + getEstado()
            + "\n fechaCreacion = " + getFechaCreacion()
            + "\n fechaModifica = " + getFechaModifica();
    }
}
