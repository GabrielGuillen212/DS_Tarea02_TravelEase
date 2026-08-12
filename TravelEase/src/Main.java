import Factory.*;
import GestorIncidencias.*;
import Notificaciones.*;
import Reservas.*;

public class Main {
    public static void main(String[] args) {

        // ===== Factory Method (Jairo) =====
        System.out.println("--- Demostración Factory Method ---");

        VueloFactory fabricaVuelo = new VueloEjecutivoFactory();
        ServicioReserva vueloEjecutivo = fabricaVuelo.reservarVuelo("V002", "Guayaquil - Madrid", 480, "LATAM");
        System.out.println(vueloEjecutivo.getDescripcion() + " - $" + vueloEjecutivo.getPrecio());

        VehiculoFactory fabricaVehiculo = new VehiculoSUVFactory();
        ServicioReserva vehiculoSUV = fabricaVehiculo.reservarVehiculo("VH02", "Camioneta", 90, "Hertz");
        System.out.println(vehiculoSUV.getDescripcion() + " - $" + vehiculoSUV.getPrecio());

        Reserva reservaFactory = new Reserva("R010", vueloEjecutivo);
        System.out.println("Reserva " + reservaFactory.getIdReserva() + " -> " + reservaFactory.getEstado());

        // Demostración de la validación agregada en el refactor (Sección D)
        try {
            new Vuelo(null, "Ruta inválida", 100, "LATAM");
        } catch (IllegalArgumentException e) {
            System.out.println("Validación funcionando correctamente: " + e.getMessage());
        }

    }
}