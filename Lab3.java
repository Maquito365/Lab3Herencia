import java.time.LocalDateTime;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        PersonalMedico medico1 = new DoctorGeneral(101, "Juan Pérez", "Consultas", 5, 8000, "Medicina Interna", 30, 150.0, 20);

        CitaMedica cita1 = new CitaMedica(1, "Pedro Gómez", medico1, LocalDateTime.of(2025, 10, 20, 9, 0), TipoCita.CONSULTA_GENERAL);
        System.out.println(cita1);

        // Cambiar estado a CONFIRMADA
        cita1.cambiarEstado(EstadoCita.CONFIRMADA);

        // Reagendar (ejemplo)
        cita1.reagendar(LocalDateTime.of(2025, 10, 20, 11, 0), "Conflicto horario del paciente");

        // Mostrar historial de reagendamientos
        System.out.println("\nHistorial de reagendamientos:");
        for (EntradasHistorial h : cita1.getHistorialReagendamientos()) {
            System.out.println(" - " + h);
        }

        // Mostrar historial de estados
        System.out.println("\nHistorial de estados:");
        for (String s : cita1.getHistorialEstados()) {
            System.out.println(" - " + s);
        }
    }
}

