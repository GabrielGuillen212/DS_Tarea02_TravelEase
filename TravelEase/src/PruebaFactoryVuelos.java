import Factory.*;
import Reservas.*;

public class PruebaFactoryVuelos {
    public static void main(String[] args) {
        // Reserva de vuelo usando Factory Method (clase Ejecutiva)
        VueloFactory fabricaVuelo = new VueloEjecutivoFactory();
        ServicioReserva vueloEjecutivo = fabricaVuelo.reservarVuelo("V002", "Guayaquil - Madrid", 480);

        // Reserva de vehiculo usando Factory Method (tipo SUV)
        VehiculoFactory fabricaVehiculo = new VehiculoSUVFactory();
        ServicioReserva vehiculoSUV = fabricaVehiculo.reservarVehiculo("VH02", "Camioneta", 90);

        System.out.println(vueloEjecutivo.getDescripcion() + " - $" + vueloEjecutivo.getPrecio());
        System.out.println(vehiculoSUV.getDescripcion() + " - $" + vehiculoSUV.getPrecio());

        // Probemos tambien con las otras clases/tipos para verificar que todas las factories funcionan
        VueloFactory fabricaEconomica = new VueloEconomicoFactory();
        ServicioReserva vueloEconomico = fabricaEconomica.reservarVuelo("V003", "Guayaquil - Bogota", 180);
        System.out.println(vueloEconomico.getDescripcion() + " - $" + vueloEconomico.getPrecio());

        VueloFactory fabricaPrimera = new VueloPrimeraClaseFactory();
        ServicioReserva vueloPrimera = fabricaPrimera.reservarVuelo("V004", "Guayaquil - Nueva York", 700);
        System.out.println(vueloPrimera.getDescripcion() + " - $" + vueloPrimera.getPrecio());

        VehiculoFactory fabricaEconomico = new VehiculoEconomicoFactory();
        ServicioReserva vehiculoEconomico = fabricaEconomico.reservarVehiculo("VH03", "Sedan", 60);
        System.out.println(vehiculoEconomico.getDescripcion() + " - $" + vehiculoEconomico.getPrecio());

        VehiculoFactory fabricaLujo = new VehiculoLujoFactory();
        ServicioReserva vehiculoLujo = fabricaLujo.reservarVehiculo("VH04", "Mercedes Benz", 150);
        System.out.println(vehiculoLujo.getDescripcion() + " - $" + vehiculoLujo.getPrecio());

        // Confirmamos la reserva de uno de ellos
        Reserva reserva = new Reserva("R010", vueloEjecutivo);
        System.out.println("Reserva " + reserva.getIdReserva() + " -> " + reserva.getEstado());
    }
}