package Test;
import org.junit.jupiter.api.Test;

import Factory.Vehiculo;
import Factory.Vuelo;
import GestorIncidencias.GestionIncidencia;
import GestorIncidencias.Incidencia;
import Reservas.Reserva;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

public class IncidenciaTest {
    private GestionIncidencia gestor;
    private Vuelo vueloPrueba;
    private Vehiculo vehiculoPrueba;

    @BeforeEach
    void setUp(){
        gestor = new GestionIncidencia();
        vueloPrueba = new Vuelo("V-01", "Quito - Guayaquil", 120.0, "Aerolinea1");
        vehiculoPrueba = new Vehiculo("A-10", "Aveo", 50.0,"AgenciaAutos");
    }

    @Test
    @DisplayName("Probar estrategia de agente soporte")
    void testResolucionPorAgenteSoporte(){
        Reserva reservaVuelo = new Reserva("RES-01", vueloPrueba);
        Incidencia incVuelo = new Incidencia("INC-01", "Reembolso", reservaVuelo);
        gestor.ejecutarSolucion(incVuelo, true);

        assertEquals("RESUELTO", incVuelo.getEstado());

        Reserva reservaVehiculo = new Reserva("RES-02", vehiculoPrueba);
        Incidencia incVehiculo = new Incidencia("INC-02", "Llanta dañada", reservaVehiculo);
        gestor.ejecutarSolucion(incVehiculo, true);

        assertEquals("RESUELTO", incVehiculo.getEstado());
    }

    @Test
    @DisplayName("Probar estrategia escalado a proveedor")
    void testEscaladoProveedor(){
        Reserva reservaVehiculo = new Reserva("RES-03", vehiculoPrueba);
        Incidencia incidenciaVehiculo= new Incidencia("INC-03", "Fallo mecánico en el vehiculo", reservaVehiculo);
        gestor.ejecutarSolucion(incidenciaVehiculo, false);
        String provEsperadoVehiculo = incidenciaVehiculo.getReserva().getServicio().getNombreProveedor();

        assertEquals("Escalado a "+ provEsperadoVehiculo, incidenciaVehiculo.getEstado());

        Reserva reservaVuelo = new Reserva("RES-04", vueloPrueba);
        Incidencia incidenciaVuelo= new Incidencia("INC-04", "Cambio de horario", reservaVuelo);
        gestor.ejecutarSolucion(incidenciaVuelo, false);
        String provEsperadoVuelo = incidenciaVuelo.getReserva().getServicio().getNombreProveedor();

        assertEquals("Escalado a "+ provEsperadoVuelo, incidenciaVuelo.getEstado());
    }
    
    @Test
    @DisplayName("Probar metodo de contexto ejecutar solucion")
    void testEjecutarSolucion(){
        Reserva reservaAgente = new Reserva("RES-05", vehiculoPrueba);
        Incidencia incidenciaAgente = new Incidencia("INC-05", "Asiento asignado equivocado", reservaAgente);
        gestor.ejecutarSolucion(incidenciaAgente, true);
        
        assertEquals("RESUELTO", incidenciaAgente.getEstado());

        Reserva reservaProveedor = new Reserva("RES-06", vueloPrueba);
        Incidencia incidenciaProveedor = new Incidencia("INC-04", "Pérdida de equipaje", reservaProveedor);
        gestor.ejecutarSolucion(incidenciaProveedor, false);
        String proveedorEsperado = incidenciaProveedor.getReserva().getServicio().getNombreProveedor();

        assertEquals("Escalado a "+ proveedorEsperado, incidenciaProveedor.getEstado());
    }
    
    @Test
    @DisplayName("Comprobar que no se permitan estados nulos o vacios en incidencia")
    void testSetEstadoIncidencia(){
        Reserva reserva = new Reserva("RES-07", vueloPrueba);
        Incidencia incidencia = new Incidencia("INC-07", "Problema con equipaje", reserva);
        assertNotNull(incidencia.getEstado());
        assertFalse(incidencia.getEstado().trim().isEmpty());

        assertThrows(IllegalArgumentException.class, ()-> incidencia.setEstado(null));
        assertThrows(IllegalArgumentException.class, ()-> incidencia.setEstado("  "));
    }
}
