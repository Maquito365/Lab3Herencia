import java.timeLocalDateTime; // Importa la clase LocalDateTime para manejar fechas y horas
public class EntradasHistorial{
    private LocalDateTime fechaAnterior; // Fecha y hora de la entrada anterior
    private LocalDateTime fechaNueva; // Fecha y hora de la entrada actual
    private LocalDateTime fechaEdicion; // Fecha y hora en que se editó la entrada
    private String motivo;

    public EntradasHistorial(LocalDateTime fechaAnterior, LocalDateTime fechaNueva, LocalDateTime fechaEdicion, String motivo) {
        this.fechaAnterior = fechaAnterior;
        this.fechaNueva = fechaNueva;
        this.fechaEdicion = LocalDateTime.now(); // Se asigna la fecha y hora actual al momento de la creación
        this.motivo = motivo;
    }

    public LocalDateTime getFechaAnterior() {
        return fechaAnterior;
    }
    public LocalDateTime getFechaNueva() {
        return fechaNueva;
    }
    public LocalDateTime getFechaEdicion() {
        return fechaEdicion;
    }
    public String getMotivo() {
        return motivo;
    }

    @Override
    public String toString() {
        return "Cambio realizado el " + fechaEdicion + 
        "\nDe: " + fechaAnterior + 
        "\nA: " + fechaNueva +
        (motivo != null && !motivo.isEmpty() ? "\nMotivo: " + motivo : ""); // Solo muestra el motivo si no es nulo o vacío
    }
}