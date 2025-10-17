import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class HospitalManager {

    private List<PersonalMedico> personal;
    private List<CitaMedica> citas;

    public HospitalManager() {
        this.personal = new ArrayList<>();
        this.citas = new ArrayList<>();
    }

    //Gestiona al personal
    public void contratarPersonal(PersonalMedico p){
        personal.add(p);
        System.out.println("Contratado: "+p.getNCompleto());
    }

    public void despedirPersonal(int ID){
        personal.removeIf(p -> p.getID() == ID);
    }

    public List<PersonalMedico> getPersonal(){
        return personal;
    }

    //Gestion de citas
    public boolean programarCita(CitaMedica cita){
        if (!medicoDisponible(cita.getMedicoAsignado(), cita.getFechaHora())){
            System.out.println("El medico no esta disponible en esa fecha y hora.");
            boolean reagendado = reagendarAutomatico(cita);
            if (!reagendado){
                System.out.println("No se pudo reagendar la cita automaticamente.");
                return false;
            }
            return true;
        }
        citas.add(cita);
        System.out.println("Cita programada correctamente: " + cita);
        return true;
    }

    //verificacion de disponibilidad del medico
    private boolean medicoDisponible(PersonalMedico medico, LocalDateTime fechaHora){
        for(CitaMedica c : citas){
            if(c.getMedicoAsignado().getID() == medico.getID() &&
               c.getFechaHora().equals(fechaHora)){
                return false;
            }
        }
        return true;
    }

    //Reagendamiento automatico
    public boolean reagendarAutomatico(CitaMedica cita){
        LocalDateTime nuevaFecha = cita.getFechaHora().plusHours(1);
        int intentos = 0;

        while(intentos < 10){
            if(medicoDisponible(cita.getMedicoAsignado(), nuevaFecha)){
                cita.reagendarCita(nuevaFecha, "Reagendado automaticamente");
                citas.add(cita);
                System.out.println("Cita reagendada a: " + nuevaFecha);
                return true;
            }
            nuevaFecha = nuevaFecha.plusHours(1);
            intentos++;
        }

        for (PersonalMedico p : personal){
            if(esCandidato(cita.getTipoCita(),p) && medicoDisponible(p, cita.getFechaHora())){
                cita.reagendarCita(cita.getFechaHora().plusHours(1), "Reagendado automáticamente a " + p.getNCompleto());
                try{
                    cita.setMedicoAsignado(p);
                }catch (Exception e){
                    System.out.println("Nota: No se pudo cambiar el medico asignado.");
                }
                citas.add(cita);
                return true;
            }
        }
        return false;
    }

    //Verificacion de medico candidato
    private boolean esCandidato(TipoCita tipo, PersonalMedico p){
        switch (tipo){
            case CONSULTA_GENERAL:
                return p instanceof DoctorGeneral;
            case CIRUGIA:
                return p instanceof Cirujano;
            case TERAPIA:
                return p instanceof Terapeuta;
            default:
                return true;
        }
    }

    //Resolucion conflictos
    public void resolverConflictos(){
        Map<String, List<CitaMedica>> conflictos = new HashMap<>(); //HashMap para almacenar conflictos

        for(CitaMedica c : citas){
            String clave = c.getMedicoAsignado().getID() + "|" + c.getFechaHora();
            conflictos.computeIfAbsent(clave, k -> new ArrayList<>()).add(c);
        }

        for(List<CitaMedica> grupo : conflictos.values()){
            if(grupo.size() > 1){
                System.out.println("Conflictos detectado para: " +
                    grupo.get(0).getMedicoAsignado().getNCompleto());
                for(int i = 1; i< grupo.size(); i++){
                    CitaMedica cita = grupo.get(i);
                    if(!reagendarAutomatico(cita)){
                        System.out.println("Cita cancelada por conflicto ");;
                    }
                }
            }
        }
    }

    //Reportes
    public void reportePersonal(){
        System.out.println("\n Reporte de Personal Médico: ");
        for(PersonalMedico p : personal){
            System.out.println(p.getNCompleto() + " - Salario: " +p.calcularSalario());
        }
    }

    public void reporteCitas() {
        System.out.println("\n Reporte de Citas Médicas:");
        for (CitaMedica c : citas) {
            System.out.println(c);
        }
    }

    public void mostrarHistorial() {
        System.out.println("\n Historial de cambios en citas:");
        for (CitaMedica c : citas) {
            System.out.println("Cita ID " + c.getIDcita() + ":");
            for (EntradasHistorial h : c.getHistorialMedico()) {
                System.out.println(h);
            }
        }
    }

}