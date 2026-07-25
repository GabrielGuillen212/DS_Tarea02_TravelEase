package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Factory.Vehiculo;
import Factory.Vuelo;
import Reservas.CoberturaVehiculoDecorator;
import Reservas.Reserva;
import Reservas.SeguroViajeDecorator;
import Reservas.ServicioReserva;

public class DecoratorTest {

    @Test
    @DisplayName("Agregar seguro de viaje a un vuelo")
    void testSeguroViajeDecorator() {

        ServicioReserva vuelo = new Vuelo("V001", "Guayaquil - Quito", 200, "LATAM");
        vuelo = new SeguroViajeDecorator(vuelo);

        assertEquals(250, vuelo.getPrecio());
        assertTrue(vuelo.getDescripcion().contains("Seguro de viaje"));
        assertEquals("LATAM", vuelo.getNombreProveedor());
    }

    @Test
    @DisplayName("Agregar cobertura extendida a un vehículo")
    void testCoberturaVehiculoDecorator() {

        ServicioReserva vehiculo = new Vehiculo("VH01", "Toyota Corolla", 100, "Hertz");
        vehiculo = new CoberturaVehiculoDecorator(vehiculo);

        assertEquals(135, vehiculo.getPrecio());
        assertTrue(vehiculo.getDescripcion().contains("Cobertura extendida"));
        assertEquals("Hertz", vehiculo.getNombreProveedor());
    }

    @Test
    @DisplayName("Agregar seguro y cobertura a un servicio")
    void testMultiplesDecoradores() {

        ServicioReserva vuelo = new Vuelo("V002", "Guayaquil - Madrid", 500, "LATAM");
        vuelo = new SeguroViajeDecorator(vuelo);
        vuelo = new CoberturaVehiculoDecorator(vuelo);

        assertEquals(585, vuelo.getPrecio());
        assertTrue(vuelo.getDescripcion().contains("Seguro de viaje"));
        assertTrue(vuelo.getDescripcion().contains("Cobertura extendida"));
    }

    @Test
    @DisplayName("Crear una reserva con un servicio decorado")
    void testReservaDecorada() {

        ServicioReserva vuelo = new Vuelo("V003", "Quito - Cuenca", 180, "LATAM");
        vuelo = new SeguroViajeDecorator(vuelo);
        Reserva reserva = new Reserva("RES-01", vuelo);

        assertNotNull(reserva.getServicio());
        assertEquals(230, reserva.getServicio().getPrecio());
        assertTrue(reserva.getServicio().getDescripcion().contains("Seguro de viaje"));
    }

}