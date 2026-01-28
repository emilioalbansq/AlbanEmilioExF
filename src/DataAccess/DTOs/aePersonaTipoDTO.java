package DataAccess.DTOs;

public class aePersonaTipoDTO {

    private Integer idCatalogo;
    private Integer idCatalogoTipo;
    private String nombre;
    private String descripcion;
    private String estado;
    private String fechaCrea;
    private String fechaModifica;

    public aePersonaTipoDTO(){}

    public aePersonaTipoDTO(Integer idCatalogo, Integer idCatalogoTipo, String nombre, String descripcion, String estado,
        String fechaCrea, String fechaModifica) {
        this.idCatalogo = idCatalogo;
        this.idCatalogoTipo = idCatalogoTipo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
        this.fechaCrea = fechaCrea;
        this.fechaModifica = fechaModifica;
    }



    public Integer getIdCatalogo() {
        return idCatalogo;
    }

    public void setIdCatalogo(Integer idCatalogo) {
        this.idCatalogo = idCatalogo;
    }

    public Integer getIdCatalogoTipo() {
        return idCatalogoTipo;
    }

    public void setIdCatalogoTipo(Integer idCatalogoTipo) {
        this.idCatalogoTipo = idCatalogoTipo;
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
        return fechaCrea;
    }

    public void setFechaCreacion(String fechaCrea) {
        this.fechaCrea = fechaCrea;
    }

    public String getFechaModifica() {
        return fechaModifica;
    }

    public void setFechaModifica(String fechaModifica) {
        this.fechaModifica = fechaModifica;
    }

    @Override
    public String toString(){
        return "\n" + getClass().getName()
            + "\n idCatalogo =     "+ getIdCatalogo()
            + "\n idCatalogoTipo = "+ getIdCatalogoTipo()
            + "\n nombre =         "+ getNombre()
            + "\n descripcion =    "+ getDescripcion()
            + "\n estado =         "+ getEstado()
            + "\n fechaCrea =      "+ getFechaCreacion()
            + "\n fechaModifica =  "+ getFechaModifica();
    }

}
