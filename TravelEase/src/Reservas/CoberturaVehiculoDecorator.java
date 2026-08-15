package Reservas;

public class CoberturaVehiculoDecorator
        extends ServicioReservaDecorator {

    public CoberturaVehiculoDecorator(ServicioReserva servicio) {
        super(servicio, "Cobertura extendida", 35);
    }
}