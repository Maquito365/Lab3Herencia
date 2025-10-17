import java.time.LocalDateTime;
public class Lab3 {
    public static void main(String[] args) {
        HospitalManager manager = new HospitalManager();

        // === Personal médico ===
        DoctorGeneral doc1 = new DoctorGeneral(1, "Dr. Ana López", "Medicina General", 10, 1500, 
            "Medicina Interna", 20, 30.0, 50);
        Cirujano cir1 = new Cirujano(2, "Dr. Mario Ruiz", "Cirugía", 8, 2500,
            "Cardíaca", 15, 400, 200);
        Terapeuta ter1 = new Terapeuta(3, "Lic. Carla Gómez", "Rehabilitación", 6, 1200,
            "Fisioterapia", 45.0, 20.0, 40);
        Enfermero enf1 = new Enfermero(4, "Enf. Juan Pérez", "Urgencias", 4, 800,
            true, 2, 100);

        // Contratar personal
        manager.contratarPersonal(doc1);
        manager.contratarPersonal(cir1);
        manager.contratarPersonal(ter1);
        manager.contratarPersonal(enf1);

        // === Crear citas ===
        LocalDateTime fecha = LocalDateTime.now().plusDays(1).withHour(9).withMinute(0);

        CitaMedica cita1 = new CitaMedica(101, "Paciente A", doc1, fecha, TipoCita.CONSULTA_GENERAL);
        CitaMedica cita2 = new CitaMedica(102, "Paciente B", doc1, fecha, TipoCita.CONSULTA_GENERAL); // misma hora
        CitaMedica cita3 = new CitaMedica(103, "Paciente C", cir1, fecha.plusHours(2), TipoCita.CIRUGIA);
        CitaMedica cita4 = new CitaMedica(104, "Paciente D", ter1, fecha.plusHours(3), TipoCita.TERAPIA);

        // === Programar citas ===
        manager.programarCita(cita1);
        manager.programarCita(cita2); // causará reagendamiento automático
        manager.programarCita(cita3);
        manager.programarCita(cita4);

        // === Forzar conflicto adicional ===
        CitaMedica cita5 = new CitaMedica(105, "Paciente E", cir1, fecha.plusHours(2), TipoCita.CIRUGIA);
        manager.programarCita(cita5); // conflicto con cita3

        // === Reportes ===
        manager.reportePersonal();
        manager.reporteCitas();

        // === Resolver conflictos restantes ===
        manager.resolverConflictos();

        // === Mostrar historial de reagendamientos ===
        manager.mostrarHistorial();
    }
}
