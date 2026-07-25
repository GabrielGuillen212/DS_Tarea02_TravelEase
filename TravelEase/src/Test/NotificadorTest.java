package Test;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import Notificaciones.Notificador;
import Notificaciones.EmailNotificado;
import Notificaciones.AppNotificado;


class NotificadorTest {
    
    private Notificador notificador;
    private EmailNotificado usuarioemail;
    private AppNotificado usuarioapp;

    @BeforeEach
    public void setUp() {
        notificador = new Notificador();
        usuarioemail = new EmailNotificado("gaguille@espol.edu.ec");
        usuarioapp = new AppNotificado("Gaguille");
    }

    @Test
    @DisplayName("Debe agregar usuarios a la lista de notificación correctamente")
    void testAgregarUsuario() {
        notificador.agregarUsuario(usuarioemail);
        assertEquals(1, notificador.getListaUsuarios().size(), "El usuario debería registrarse correctamente.");
        assertTrue(notificador.getListaUsuarios().contains(usuarioemail));
    }

    @Test
    @DisplayName("Debe quitar usuarios de la lista de notificación correctamente")
    void testQuitarUsuario() {
        notificador.agregarUsuario(usuarioemail);
        notificador.quitarUsuario(usuarioemail);
        assertEquals(0, notificador.getListaUsuarios().size(), "El usuario debería eliminarse correctamente.");
        assertFalse(notificador.getListaUsuarios().contains(usuarioemail));
    }

    @Test
    @DisplayName("Debe notificar a todos los usuarios correctamente")
    void testNotificar() {
        notificador.agregarUsuario(usuarioemail);
        notificador.agregarUsuario(usuarioapp);
        notificador.notificar("Mensaje de prueba");
        assertDoesNotThrow(() -> notificador.notificar("Mensaje de prueba"), "La notificación debería enviarse sin errores.");
    }

}
}
