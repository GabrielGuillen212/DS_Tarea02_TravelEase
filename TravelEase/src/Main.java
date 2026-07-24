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
    }
}
