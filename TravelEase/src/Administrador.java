public class Administrador extends Persona {
    
    String idAdministrador;

    public Administrador(String nombre, String email) {
        super(nombre, email);
    }
    
    public Administrador(String nombre, String email, String idAdministrador) {
        super(nombre, email);
        this.idAdministrador = idAdministrador;
    }

    public String getIdAdmin() {
        return idAdministrador;
    }

    public void setIdAdmin(String idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

}
