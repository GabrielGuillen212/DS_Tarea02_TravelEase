package Reservas;

public class SeguroViajeDecorator extends ServicioReservaDecorator {

    public SeguroViajeDecorator(ServicioReserva servicio) {
        super(servicio, "Seguro de viaje", 50);
    }
}