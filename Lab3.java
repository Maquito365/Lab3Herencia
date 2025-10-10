import java.util.ArrayList;

public class Lab3 {
    public static void main(String[] args) {

        ArrayList<PersonalMedico> personal = new ArrayList<>();

        // Crear ejemplos según tu constructor exacto:

        personal.add(new DoctorGeneral(
            101, "Juan Pérez", "Consultas", 5, 8000, 
            "Medicina Interna", 30, 150.0, 20 // CPacientesDia, tarifaConsulta, NConsultas
        ));

        personal.add(new Cirujano(
            102, "María López", "Cirugía", 10, 12000, 
            "Cardiovascular", 15, 2000.0, 500.0 // TipoOperacion, HorasCirugia, BonosPorRiesgo, TarifaPHora
        ));

        personal.add(new Enfermero(
            103, "Carlos Reyes", "Urgencias", 3, 5000, 
            true, 2, 1000.0 // turno, NivelCertificacion, bonoNocturno
        ));

        personal.add(new Terapeuta(
            104, "Ana Torres", "Rehabilitación", 6, 7000, 
            "Fisioterapia", 45, 200.0, 25 // tipoTerapia, DuracionPromedioSesiones, ComisionPorSesion, Csesiones
        ));

        // Mostrar datos y salario calculado
        for (PersonalMedico p : personal) {
            System.out.println(p);  // toString()
            System.out.println("Salario Calculado: " + p.calcularSalario());
            System.out.println("---------------------------------------------");
        }
    }
}
