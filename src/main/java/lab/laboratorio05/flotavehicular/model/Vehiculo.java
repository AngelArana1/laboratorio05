package lab.laboratorio05.flotavehicular.model;

public abstract class Vehiculo implements Mantenible {
    protected String placa;
    protected String marca;
    protected int kilometraje;
    protected EstadoVehiculo estado;

    public Vehiculo(String marca, String placa, int kilometraje, EstadoVehiculo estado) {
        this.marca = marca;
        this.placa = placa;
        this.kilometraje = kilometraje;
        this.estado = EstadoVehiculo.DISPONIBLE;
    }

    public abstract void iniciarRuta();
    public void finalizarRuta(){
        // Regla de negocio: solo se puede finalizar si está EN_RUTA
        if (estado != EstadoVehiculo.EN_RUTA) {
            throw new IllegalStateException(
                    "El vehículo [" + placa + "] no se encuentra en ruta."
            );
        }

        // Regresa a DISPONIBLE
        estado = EstadoVehiculo.DISPONIBLE;
    }
    public abstract  TipoVehiculo getTipo();

    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public int getKilometraje() {
        return kilometraje;
    }

    public EstadoVehiculo getEstado() {
        return estado;
    }
    public void setEstado(EstadoVehiculo estado) { this.estado = estado; }
    @Override
    public String toString() {
        return marca + " [" + placa + "]";
    }
}
