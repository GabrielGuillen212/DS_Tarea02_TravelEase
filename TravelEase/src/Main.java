import Factory.Vehiculo;
import Factory.VehiculoFactory;
import Factory.VehiculoSUVFactory;
import Factory.Vuelo;
import Factory.VueloEjecutivoFactory;
import Factory.VueloFactory;
import Reservas.*;

public class Main {
    public static void main(String[] args) {
        ServicioReserva vuelo = new Vuelo("V001", "Vuelo Guayaquil - Quito", 220,"Aerolinea 1");
        vuelo = new SeguroViajeDecorator(vuelo);

        System.out.println(vuelo.getDescripcion());
        System.out.println(vuelo.getPrecio());

        ServicioReserva vehiculo = new Vehiculo("VH01", "SUV Toyota", 90, "ProveedorTransporte");
        vehiculo = new CoberturaVehiculoDecorator(vehiculo);

        System.out.println(vehiculo.getDescripcion());
        System.out.println(vehiculo.getPrecio());

        Reserva reserva = new Reserva("R001", vuelo);

        System.out.println(reserva.getServicio().getDescripcion());
        System.out.println(reserva.getServicio().getPrecio());

        //Factory Method
        VueloFactory fabricaVuelo = new VueloEjecutivoFactory();
        ServicioReserva vueloEjecutivo = fabricaVuelo.reservarVuelo("V002", "Guayaquil - Madrid", 480);
        vueloEjecutivo = new SeguroViajeDecorator(vueloEjecutivo);

        VehiculoFactory fabricaVehiculo = new VehiculoSUVFactory();
        ServicioReserva vehiculoSUV = fabricaVehiculo.reservarVehiculo("VH02", "Camioneta", 90);
        vehiculoSUV = new CoberturaVehiculoDecorator(vehiculoSUV);

        System.out.println(vueloEjecutivo.getDescripcion() + " - $" + vueloEjecutivo.getPrecio());
        System.out.println(vehiculoSUV.getDescripcion() + " - $" + vehiculoSUV.getPrecio());

        Reserva reservaFactory = new Reserva("R010", vueloEjecutivo);
        System.out.println("Reserva " + reservaFactory.getIdReserva() + " -> " + reservaFactory.getEstado());
    }
}
