import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
public class CitaMedica {
    private int IDcita;
    private String nombrePaciente;
    private PersonalMedico medicoAsignado;
    private LocalDateTime fechaHora;
    private TipoCita tipoCita;
    private EstadoCita estado;
    private List<EntradasHistorial> historialMedico;
    private List<String> historialestados;

    public CitaMedica(int IDcita, String nombrePaciente, PersonalMedico medicoAsignado, LocalDateTime fechaHora, TipoCita tipoCita) {
        this.IDcita = IDcita;
        this.nombrePaciente = nombrePaciente;
        this.medicoAsignado = medicoAsignado;
        this.fechaHora = fechaHora;
        this.tipoCita = tipoCita;
        this.estado = EstadoCita.PROGRAMADA; // Estado inicial
        this.historialMedico = new ArrayList<>(); // Inicializa la lista vacía
        this.historialestados = new ArrayList<>();
        registrarCambioEstado("Inicial: " + this.estado);
    }

    public int getIDcita() {
        return IDcita;
    }
    public String getNombrePaciente() {
        return nombrePaciente;
    }
    public PersonalMedico getMedicoAsignado() {
        return medicoAsignado;
    }
    public void setMedicoAsignado(PersonalMedico medicoAsignado) {
        this.medicoAsignado = medicoAsignado;
        registrarCambioEstado("Médico reasignado a: " + medicoAsignado.getNCompleto());
    }
    public LocalDateTime getFechaHora() {
        return fechaHora;
    }
    public TipoCita getTipoCita() {
        return tipoCita;
    }
    public EstadoCita getEstado() {
        return estado;
    }
    public List<EntradasHistorial> getHistorialMedico() {
        return historialMedico;
    }
    public List<String> getHistorialestados() {
        return historialestados;
    } 

    public void setEstado(EstadoCita nuevoEstado) {
        registrarCambioEstado("Estado cambiado: " + this.estado + " -> " + nuevoEstado);
        this.estado = nuevoEstado;
    }

    public void reagendarCita(LocalDateTime nuevaFecha, String motivo) {
        EntradasHistorial entrada = new EntradasHistorial(this.fechaHora, nuevaFecha, motivo);
        historialMedico.add(entrada);
        this.fechaHora = nuevaFecha;
        this.estado = EstadoCita.REAGENDADA;
        registrarCambioEstado("Reagendada a: " + nuevaFecha + " por motivo: " + motivo);
    }

    private void registrarCambioEstado(String texto) {
        historialestados.add(LocalDateTime.now() + " - " + texto);
    }

    @Override
    public String toString() {
        return "CitaMedica { " +
                " IDcita= " + IDcita +
                ", nombrePaciente= '" + nombrePaciente + '\'' +
                ", medicoAsignado= " + medicoAsignado.getNCompleto() +
                ", fechaHora= " + fechaHora +
                ", tipoCita= " + tipoCita +
                ", estado= " + estado +
                '}';
    }

}