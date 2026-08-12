package Test;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import Notificaciones.Notificador;
import Notificaciones.EmailNotificado;
import Notificaciones.AppNotificado;
import Notificaciones.Administrador;


class NotificadorTest {
    
    private Notificador notificador;
    private EmailNotificado usuarioemail;
    private AppNotificado usuarioapp;
    private Administrador administrador;

    @BeforeEach
    public void setUp() {
        notificador = new Notificador();
        administrador = new Administrador("Gabriel", "gaguillen@hotmail.com", "admin123", notificador);
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

    @Test
    @DisplayName("Debe notificar a todos los usuarios correctamente desde el administrador")
    void testNotificarDesdeAdministrador() {
        notificador.agregarUsuario(usuarioemail);
        notificador.agregarUsuario(usuarioapp);
        administrador.gestionarPoliticas("pol123", "Cambio de política");
        assertDoesNotThrow(() -> administrador.gestionarPoliticas("pol123", "Cambio de política"), "La notificación debería enviarse sin errores.");
    }

}

