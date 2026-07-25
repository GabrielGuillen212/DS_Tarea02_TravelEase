package Test;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import Notificaciones.EmailNotificado;
import Notificaciones.AppNotificado;

class UsuarioNotificadoTest {

    private EmailNotificado usuarioEmail;
    private AppNotificado usuarioApp;

    @BeforeEach
    public void setUp() {
        usuarioEmail = new EmailNotificado("gaguille@espol.edu.ec");
        usuarioApp = new AppNotificado("Gaguille");
    }

    @Test
    @DisplayName("Debe cumplir el update correctamente para EmailNotificado")
    void testUpdateEmail() {
        assertDoesNotThrow(() -> usuarioEmail.update("Mensaje de prueba"), "El método update debería ejecutarse sin errores.");
    }

    @Test
    @DisplayName("Debe cumplir el update correctamente para AppNotificado")
    void testUpdateApp() {
        assertDoesNotThrow(() -> usuarioApp.update("Mensaje de prueba"), "El método update debería ejecutarse sin errores.");
    }
}
