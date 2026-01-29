package BusinessLogic.Entities;

public class aeUsuario {

    private String usuario = "patmic";
    private String contrasena = "123";
    private String aeNombre = "Emilio Albán";
    private String aeCedula = "17151257088";

    

    public aeUsuario(String usuario, String contrasena) {
        setUsuario(usuario);
        setContrasena(contrasena);
    }

    public boolean aeCheckLogin(String usuario, String contrasena) {
        //Refactorización: el enunciado solicita "cédula y clave" pero también pide agregar acceso "patmic/123".
        boolean byUser = this.usuario.equals(usuario) && this.contrasena.equals(contrasena);
        return byUser;
    }



    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getAeNombre() {
        return aeNombre;
    }

    public void setAeNombre(String aeNombre) {
        this.aeNombre = aeNombre;
    }

    public String getAeCedula() {
        return aeCedula;
    }

    public void setAeCedula(String aeCedula) {
        this.aeCedula = aeCedula;
    }
}
