package Test;
import org.junit.jupiter.api.Test;
import Factory.Vehiculo;
import Factory.Vuelo;
import GestorIncidencias.*;
import Reservas.Reserva;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;


public class IncidenciaTest {
    private GestionIncidencia gestor;
    private Vuelo vueloPrueba;
    private Vehiculo vehiculoPrueba;

    @BeforeEach
    void setUp() {
        gestor = new GestionIncidencia();
        vueloPrueba = new Vuelo("V-01", "Quito - Guayaquil", 120.0, "Aerolinea1");
        vehiculoPrueba = new Vehiculo("A-10", "Aveo", 50.0, "AgenciaAutos");
    }

    @Test
    @DisplayName("Probar estrategia de agente soporte")
    void testResolucionPorAgenteSoporte() {
        Reserva reservaVuelo = new Reserva("RES-01", vueloPrueba);
        Incidencia incVuelo = new Incidencia("INC-01", "Reembolso", reservaVuelo);
        
        // Asignación explícita de la estrategia
        gestor.setEstrategia(new EstrategiaAgenteSoporte());
        gestor.ejecutarSolucion(incVuelo);

        assertEquals("RESUELTO", incVuelo.getEstado());

        Reserva reservaVehiculo = new Reserva("RES-02", vehiculoPrueba);
        Incidencia incVehiculo = new Incidencia("INC-02", "Llanta dañada", reservaVehiculo);
        
        gestor.setEstrategia(new EstrategiaAgenteSoporte());
        gestor.ejecutarSolucion(incVehiculo);

        assertEquals("RESUELTO", incVehiculo.getEstado());
    }

    @Test
    @DisplayName("Probar estrategia escalado a proveedor")
    void testEscaladoProveedor() {
        Reserva reservaVehiculo = new Reserva("RES-03", vehiculoPrueba);
        Incidencia incidenciaVehiculo = new Incidencia("INC-03", "Fallo mecánico en el vehiculo", reservaVehiculo);
        
        gestor.setEstrategia(new EstrategiaEscaladoProveedor());
        gestor.ejecutarSolucion(incidenciaVehiculo);
        
        String provEsperadoVehiculo = incidenciaVehiculo.getReserva().getServicio().getNombreProveedor();
        assertEquals("Escalado a " + provEsperadoVehiculo, incidenciaVehiculo.getEstado());

        Reserva reservaVuelo = new Reserva("RES-04", vueloPrueba);
        Incidencia incidenciaVuelo = new Incidencia("INC-04", "Cambio de horario", reservaVuelo);
        
        gestor.setEstrategia(new EstrategiaEscaladoProveedor());
        gestor.ejecutarSolucion(incidenciaVuelo);
        
        String provEsperadoVuelo = incidenciaVuelo.getReserva().getServicio().getNombreProveedor();
        assertEquals("Escalado a " + provEsperadoVuelo, incidenciaVuelo.getEstado());
    }

    @Test
    @DisplayName("Probar cambio dinámico de estrategia en el contexto")
    void testEjecutarSolucion() {
        // Escenario 1: Ejecución con Estrategia Agente Soporte
        Reserva reservaAgente = new Reserva("RES-05", vehiculoPrueba);
        Incidencia incidenciaAgente = new Incidencia("INC-05", "Asiento asignado equivocado", reservaAgente);
        
        gestor.setEstrategia(new EstrategiaAgenteSoporte());
        gestor.ejecutarSolucion(incidenciaAgente);
        
        assertEquals("RESUELTO", incidenciaAgente.getEstado());

        // Escenario 2: Cambio de estrategia en tiempo de ejecución a Escalado Proveedor
        Reserva reservaProveedor = new Reserva("RES-06", vueloPrueba);
        Incidencia incidenciaProveedor = new Incidencia("INC-06", "Pérdida de equipaje", reservaProveedor);
        
        gestor.setEstrategia(new EstrategiaEscaladoProveedor());
        gestor.ejecutarSolucion(incidenciaProveedor);
        
        String proveedorEsperado = incidenciaProveedor.getReserva().getServicio().getNombreProveedor();
        assertEquals("Escalado a " + proveedorEsperado, incidenciaProveedor.getEstado());
    }

    @Test
    @DisplayName("Comprobar excepciones al ejecutar solución sin estrategia o con incidencia nula")
    void testExcepcionesEjecutarSolucion() {
        Incidencia incidencia = new Incidencia("INC-07", "Prueba", new Reserva("RES-07", vueloPrueba));
        
        // Debe fallar si intentamos ejecutar solución sin haber seteado una estrategia previa
        GestionIncidencia gestorSinEstrategia = new GestionIncidencia();
        assertThrows(IllegalStateException.class, () -> gestorSinEstrategia.ejecutarSolucion(incidencia));

        // Debe fallar si se le pasa una incidencia nula
        gestor.setEstrategia(new EstrategiaAgenteSoporte());
        assertThrows(IllegalArgumentException.class, () -> gestor.ejecutarSolucion(null));
    }

    @Test
    @DisplayName("Comprobar que no se permitan estados nulos o vacios en incidencia")
    void testSetEstadoIncidencia() {
        Reserva reserva = new Reserva("RES-08", vueloPrueba);
        Incidencia incidencia = new Incidencia("INC-08", "Problema con equipaje", reserva);
        assertNotNull(incidencia.getEstado());
        assertFalse(incidencia.getEstado().trim().isEmpty());

        assertThrows(IllegalArgumentException.class, () -> incidencia.setEstado(null));
        assertThrows(IllegalArgumentException.class, () -> incidencia.setEstado("  "));
    }
}
