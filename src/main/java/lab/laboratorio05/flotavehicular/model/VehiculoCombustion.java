package lab.laboratorio05.flotavehicular.model;

// 'extends Vehiculo': hereda todo lo del padre (placa, marca, km, estado)
public class VehiculoCombustion extends Vehiculo {

    // Porcentaje de combustible (0.0 a 100.0)
    private double nivelCombustible;

    // Constructor
    public VehiculoCombustion(
            String placa,
            String marca,
            int kilometraje,
            double nivelCombustible) {

        // Llama al constructor de la clase padre
        super(placa, marca, kilometraje);

        // Inicializa el atributo propio
        this.nivelCombustible = nivelCombustible;
    }

    // Getter del nivel de combustible
    public double getNivelCombustible() {
        return nivelCombustible;
    }

    @Override
    // Cómo inicia ruta un vehículo de combustión
    public void iniciarRuta() {

        // Si está en el taller, no puede salir
        if (estado == EstadoVehiculo.TALLER) {
            throw new IllegalStateException(
                    "El vehículo [" + placa + "] está en el taller. No puede salir."
            );
        }

        // Si ya está en ruta, no puede iniciar otra
        if (estado == EstadoVehiculo.EN_RUTA) {
            throw new IllegalStateException(
                    "El vehículo [" + placa + "] ya se encuentra en ruta."
            );
        }

        // No puede salir con menos de 10% de combustible
        if (nivelCombustible < 10) {
            throw new IllegalStateException(
                    "Combustible insuficiente. Debe ir a la gasolinera."
            );
        }

        // Consume 10% y avanza 50 km
        nivelCombustible -= 10;
        kilometraje += 50;
        estado = EstadoVehiculo.EN_RUTA;
    }

    @Override
    // Este vehículo es de tipo COMBUSTION
    public TipoVehiculo getTipo() {
        return TipoVehiculo.COMBUSTION;
    }

    @Override
    // Evalúa el estado según el combustible
    public String evaluarEstadoGeneral() {

        // Si hay menos de 15%, avisa; si no, todo bien
        return nivelCombustible < 15
                ? "Requiere ir a la gasolinera"
                : "Niveles óptimos";
    }

}