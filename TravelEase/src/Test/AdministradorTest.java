package Test;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


import Notificaciones.Notificador;
import Notificaciones.Politicas;
import Notificaciones.Itinerario;
import Notificaciones.Reembolsos;
import Notificaciones.Administrador;

public class AdministradorTest {

    private Administrador admin;
    private Notificador notificador;
    private Politicas politica;
    private Itinerario itinerario;
    private Reembolsos reembolso;

    @BeforeEach
    public void setUp() {
        
        notificador = new Notificador();
        admin = new Administrador("Admin1", "admin@email.com", "A001", notificador);
        politica = new Politicas("titulo", "Política original", "P001");
        itinerario = new Itinerario("10:00", "Itinerario original");
        reembolso = new Reembolsos("R001", "Reembolso original");

    }

    @Test
    @DisplayName("Debe modificar la política correctamente y notificar a los usuarios")
    void testGestionarPoliticas() {

        admin.gestionarPoliticas( "P001", "Política modificada");

        assertEquals("Política modificada", politica.getDescripcion(), "La política debería haberse modificado correctamente.");
    }

    @Test
    @DisplayName("Debe modificar el itinerario correctamente y notificar a los usuarios")
    void testGestionarItinerario() {

        admin.gestionarItinerario( "10:00", "Itinerario modificado");

        assertEquals("Itinerario modificado", itinerario.getDescripcion(), "El itinerario debería haberse modificado correctamente.");
    }

    @Test
    @DisplayName("No debe modificar el itinerario si el horario es nulo")
    void testGestionarItinerarioHorarioNulo() {

        admin.gestionarItinerario( null, "Itinerario modificado");

        assertEquals("Itinerario original", itinerario.getDescripcion(), "El itinerario no debería haberse modificado debido a un horario nulo.");
    }

    @Test
    @DisplayName("Debe modificar el estado del reembolso correctamente y notificar a los usuarios")
    void testGestionarReembolsos() {

        admin.gestionarReembolsos( "R001", "Aprobado", "Reembolso aprobado");

        assertEquals("Aprobado", reembolso.getEstado(), "El estado del reembolso debería haberse modificado correctamente.");
    }

}
