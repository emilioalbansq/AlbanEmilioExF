package DataAccess.DTOs;

public class aeTipoEnergiaDTO {
    private Integer idTipoEnergia;
    private String nombre;
    private String estado;
    private String fechaCreacion;
    private String fechaModifica;

    public aeTipoEnergiaDTO() {}

    public aeTipoEnergiaDTO(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdTipoEnergia() {
        return idTipoEnergia;
    }

    public void setIdTipoEnergia(Integer idTipoEnergia) {
        this.idTipoEnergia = idTipoEnergia;
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
            + "\n idTipoEnergia = " + getIdTipoEnergia()
            + "\n nombre =        " + getNombre()
            + "\n estado =        " + getEstado()
            + "\n fechaCreacion = " + getFechaCreacion()
            + "\n fechaModifica = " + getFechaModifica();
    }
}
