package Test;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import Factory.Vuelo;
import Factory.Vehiculo;
import Factory.VueloFactory;
import Factory.VehiculoFactory;
import Factory.VueloEconomicoFactory;
import Factory.VueloEjecutivoFactory;
import Factory.VueloPrimeraClaseFactory;
import Factory.VehiculoEconomicoFactory;
import Factory.VehiculoSUVFactory;
import Factory.VehiculoLujoFactory;
import Reservas.ServicioReserva;

public class FactoryTest {

    @Test
    @DisplayName("VueloEconomicoFactory debe crear un Vuelo con precio base sin recargo")
    void testVueloEconomicoFactory() {
        VueloFactory fabrica = new VueloEconomicoFactory();
        Vuelo vuelo = fabrica.crearVuelo("V001", "Guayaquil - Quito", 100, "LATAM");

        assertEquals("V001", vuelo.getID());
        assertEquals(100, vuelo.getPrecio());
        assertTrue(vuelo.getDescripcion().contains("Clase Económica"));
        assertEquals("LATAM", vuelo.getNombreProveedor());
    }

    @Test
    @DisplayName("VueloEjecutivoFactory debe agregar el recargo de clase ejecutiva")
    void testVueloEjecutivoFactory() {
        VueloFactory fabrica = new VueloEjecutivoFactory();
        Vuelo vuelo = fabrica.crearVuelo("V002", "Guayaquil - Madrid", 480, "LATAM");

        assertEquals(630, vuelo.getPrecio(), "Debe sumar 150 al precio base");
        assertTrue(vuelo.getDescripcion().contains("Clase Ejecutiva"));
    }

    @Test
    @DisplayName("VueloPrimeraClaseFactory debe agregar el recargo de primera clase")
    void testVueloPrimeraClaseFactory() {
        VueloFactory fabrica = new VueloPrimeraClaseFactory();
        Vuelo vuelo = fabrica.crearVuelo("V003", "Guayaquil - Nueva York", 700, "LATAM");

        assertEquals(1050, vuelo.getPrecio(), "Debe sumar 350 al precio base");
        assertTrue(vuelo.getDescripcion().contains("Primera Clase"));
    }

    @Test
    @DisplayName("reservarVuelo debe devolver un ServicioReserva válido")
    void testReservarVueloDevuelveServicioReserva() {
        VueloFactory fabrica = new VueloEconomicoFactory();
        ServicioReserva servicio = fabrica.reservarVuelo("V004", "Guayaquil - Lima", 200, "LATAM");

        assertNotNull(servicio);
        assertEquals("V004", servicio.getID());
        assertEquals("LATAM", servicio.getNombreProveedor());
    }

    @Test
    @DisplayName("VehiculoEconomicoFactory debe crear un Vehiculo con precio base sin recargo")
    void testVehiculoEconomicoFactory() {
        VehiculoFactory fabrica = new VehiculoEconomicoFactory();
        Vehiculo vehiculo = fabrica.crearVehiculo("VH01", "Sedan", 60, "Hertz");

        assertEquals(60, vehiculo.getPrecio());
        assertTrue(vehiculo.getDescripcion().contains("Económico"));
    }

    @Test
    @DisplayName("VehiculoSUVFactory debe agregar el recargo de SUV")
    void testVehiculoSUVFactory() {
        VehiculoFactory fabrica = new VehiculoSUVFactory();
        Vehiculo vehiculo = fabrica.crearVehiculo("VH02", "Camioneta", 90, "Hertz");

        assertEquals(130, vehiculo.getPrecio(), "Debe sumar 40 al precio base");
        assertTrue(vehiculo.getDescripcion().contains("SUV"));
    }

    @Test
    @DisplayName("VehiculoLujoFactory debe agregar el recargo de lujo")
    void testVehiculoLujoFactory() {
        VehiculoFactory fabrica = new VehiculoLujoFactory();
        Vehiculo vehiculo = fabrica.crearVehiculo("VH03", "Mercedes Benz", 150, "Hertz");

        assertEquals(270, vehiculo.getPrecio(), "Debe sumar 120 al precio base");
        assertTrue(vehiculo.getDescripcion().contains("Lujo"));
    }

    @Test
    @DisplayName("reservarVehiculo debe devolver un ServicioReserva válido")
    void testReservarVehiculoDevuelveServicioReserva() {
        VehiculoFactory fabrica = new VehiculoSUVFactory();
        ServicioReserva servicio = fabrica.reservarVehiculo("VH04", "RAV4", 90, "Hertz");

        assertNotNull(servicio);
        assertEquals("VH04", servicio.getID());
        assertEquals("Hertz", servicio.getNombreProveedor());
    }
}