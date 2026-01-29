package DataAccess.DTOs;

public class aeAccionArmaDTO {
    private Integer idAccionArma;
    private String nombre;
    private String estado;
    private String fechaCreacion;
    private String fechaModifica;

    public aeAccionArmaDTO() {}

    public aeAccionArmaDTO(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdAccionArma() {
        return idAccionArma;
    }

    public void setIdAccionArma(Integer idAccionArma) {
        this.idAccionArma = idAccionArma;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
            + "\n idAccionArma =  " + getIdAccionArma()
            + "\n nombre =        " + getNombre()
            + "\n estado =        " + getEstado()
            + "\n fechaCreacion = " + getFechaCreacion()
            + "\n fechaModifica = " + getFechaModifica();
    }
}
