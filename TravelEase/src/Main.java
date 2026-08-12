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


        // ===== Decorator (Steven) =====
        System.out.println("\n--- Demostración Decorator ---");

        System.out.println("Vuelo original: " + vueloEjecutivo.getDescripcion() + " - $" + vueloEjecutivo.getPrecio());

        ServicioReserva vueloConSeguro = new SeguroViajeDecorator(vueloEjecutivo);
        System.out.println("Vuelo con seguro: " + vueloConSeguro.getDescripcion() + " - $" + vueloConSeguro.getPrecio());

        System.out.println("Vehículo original: " + vehiculoSUV.getDescripcion() + " - $" + vehiculoSUV.getPrecio());

        ServicioReserva vehiculoConCobertura = new CoberturaVehiculoDecorator(vehiculoSUV);
        System.out.println("Vehículo con cobertura: " + vehiculoConCobertura.getDescripcion() + " - $" + vehiculoConCobertura.getPrecio());

        Reserva reservaDecorada = new Reserva("R011", vueloConSeguro);
        System.out.println("Reserva decorada " + reservaDecorada.getIdReserva() + " -> " + reservaDecorada.getEstado());
        System.out.println("Servicio: " + reservaDecorada.getServicio().getDescripcion());
        System.out.println("Precio final: $" + reservaDecorada.getServicio().getPrecio());

    }
}