public class Usuario extends Persona {
    
    public String idUsuario;

    public Usuario(String nombre, String email) {
        super(nombre, email);
    }

    public Usuario(String nombre, String email, String idUsuario) {
        super(nombre, email);
        this.idUsuario = idUsuario;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

}
