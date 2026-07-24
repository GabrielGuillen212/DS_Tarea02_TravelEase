package Reservas;

public class CoberturaVehiculoDecorator extends ServicioReservaDecorator {

    public CoberturaVehiculoDecorator(ServicioReserva servicio) {
        super(servicio);
    }

    @Override
    public String getDescripcion() {
        return servicio.getDescripcion() + " + Cobertura extendida";
    }

    @Override
    public double getPrecio() {
        return servicio.getPrecio() + 35;
    }
}