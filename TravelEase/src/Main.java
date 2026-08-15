import Factory.*;
import GestorIncidencias.*;
import Notificaciones.*;
import Reservas.*;

public class Main {
    public static void main(String[] args) {

        // ===== Factory Method =====
        System.out.println("--- Demostración Factory Method ---");

        VueloFactory fabricaVuelo = new VueloEjecutivoFactory();
        ServicioReserva vueloEjecutivo = fabricaVuelo.reservarVuelo("V002", "Guayaquil - Madrid", 480, "LATAM");
        System.out.println(vueloEjecutivo.getDescripcion() + " - $" + vueloEjecutivo.getPrecio());

        VehiculoFactory fabricaVehiculo = new VehiculoSUVFactory();
        ServicioReserva vehiculoSUV = fabricaVehiculo.reservarVehiculo("VH02", "Camioneta", 90, "Hertz");
        System.out.println(vehiculoSUV.getDescripcion() + " - $" + vehiculoSUV.getPrecio());

        Reserva reservaFactory = new Reserva("R010", vueloEjecutivo);
        System.out.println("Reserva " + reservaFactory.getIdReserva() + " -> " + reservaFactory.getEstado());

        
        try {
            new Vuelo(null, "Ruta inválida", 100, "LATAM");
        } catch (IllegalArgumentException e) {
            System.out.println("Validación funcionando correctamente: " + e.getMessage());
        }


        // ===== Decorator =====
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
        

        //===== Observer =====
        System.out.println("\n---Demostracion Observer---");

        Notificador notificador = new Notificador();
        Administrador admin = new Administrador("Gabriel", "gguillen@easytr.com", "admin123", notificador);

        Itinerario vuelo_1 = new Itinerario("10:00", "vuelo a Quito");
        Itinerario vuelo_2 = new Itinerario("12:00", "vuelo a Colombia");
        Itinerario vuelo_3 = new Itinerario("14:00", "vuelo a Peru");

        Politicas politica_1 = new Politicas("Fecha maxima de cancelacion", "Un vuelo se puede cancelar maximo 1 dia antes", "POC01");
        Politicas politica_2 = new Politicas("Motivos aceptables para una cancelacion", "Los motivos aceptables seran:..... ", "POC02");

        Reembolsos reembolso_1 = new Reembolsos("REM01", "Por motivos medicos de ambito urgentes, el cliente tubo que cancelar el vuelo");

        System.out.println(admin.getNombre() + " " + admin.getIdAdmin());
        System.out.println(Itinerario.listaItinerarios);
        System.out.println(Politicas.listaPoliticas);
        System.out.println(Reembolsos.listaReembolsos);

        admin.gestionarPoliticas("POC02", "Los motivos aceptables seran: casos medicos de urgencia");
        admin.gestionarItinerario("10:00", "vuelo a Brasil");
        admin.gestionarReembolsos("REM01", "Aceptado", "Se a acepto la causa del reembolso");

        System.out.println("\n==== Cambios realizados ====");

        System.out.println(admin.getNombre() + " " + admin.getIdAdmin());
        System.out.println(Itinerario.listaItinerarios);
        System.out.println(Politicas.listaPoliticas);
        System.out.println(Reembolsos.listaReembolsos);

        //===== Strategy =====
        System.out.println("\n---Demostracion Strategy---");

        GestionIncidencia gestor = new GestionIncidencia();

        // Caso 1: Resolución por Agente de Soporte
        Incidencia inc1 = new Incidencia("INC-001", "Pérdida de equipaje", reservaFactory);

        gestor.setEstrategia(new EstrategiaAgenteSoporte()); 
        gestor.ejecutarSolucion(inc1);                       
        System.out.println("Estado Final INC-001: " + inc1.getEstado());

        System.out.println();
        // Caso 2: Escalado a Proveedor (Cambiando la estrategia en tiempo de ejecución)
        Incidencia inc2 = new Incidencia("INC-002", "Falla mecánica en auto", reservaDecorada);

        gestor.setEstrategia(new EstrategiaEscaladoProveedor()); 
        gestor.ejecutarSolucion(inc2);                          
        System.out.println("Estado Final INC-002: " + inc2.getEstado());

    }
}