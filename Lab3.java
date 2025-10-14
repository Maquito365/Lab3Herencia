import java.time.LocalDateTime;
public class Main {
    public static void main(String[] args) {
        // Crear personal médico
        PersonalMedico medico1 = new DoctorGeneral(
                101, "Juan Pérez", "Consultas", 5, 8000,
                "Medicina Interna", 30, 150.0, 20
        );
        // Crear cita médica
        CitaMedica cita1 = new CitaMedica(
                1, "Pedro Gómez", medico1,
                LocalDateTime.of(2025, 10, 20, 9, 0),
                TipoCita.CONSULTA_GENERAL
        );
        // Mostrar información de la cita
        System.out.println("=== Información Inicial ===");
        System.out.println(cita1);
        // Cambiar estado a CONFIRMADA
        cita1.setEstado(EstadoCita.CONFIRMADA);
        // Reagendar la cita
        cita1.reagendarCita(LocalDateTime.of(2025, 10, 20, 11, 0),
                "Conflicto horario del paciente");
        // Mostrar historial de reagendamientos
        System.out.println("\n=== Historial de Reagendamientos ===");
        for (EntradasHistorial h : cita1.getHistorialMedico()) {
            System.out.println(" - " + h);
        }
        // Mostrar historial de estados
        System.out.println("\n=== Historial de Estados ===");
        for (String s : cita1.getHistorialestados()) {
            System.out.println(" - " + s);
        }
        // Mostrar salario del médico
        System.out.println("\n=== Salario Calculado ===");
        System.out.println(medico1.getNCompleto() + ": Q" + medico1.calcularSalario());
    }
}
