public class DoctorGeneral extends PersonalMedico{
    private String especializacion;
    private int CPacientesDia;
    private double tarifaConsulta;
    private int NConsultas;

    public DoctorGeneral(int ID, String NCompleto, String Departamento, int AniosExperiencia, int SalarioBase, String especializacion, 
    int CPacientesDia, double tarifaConsulta, int NConsultas) {
        super(ID, NCompleto, Departamento, AniosExperiencia, SalarioBase);
        this.especializacion = especializacion;
        this.CPacientesDia = CPacientesDia;
        this.tarifaConsulta = tarifaConsulta;
        this.NConsultas = NConsultas;
    }
    public String getEspecializacion() {
        return especializacion;
    }
    public void setEspecializacion(String especializacion) {
        this.especializacion = especializacion;
    }
    public int getCPacientesDia() {
        return CPacientesDia;
    }
    public void setCPacientesDia(int CPacientesDia) {
        this.CPacientesDia = CPacientesDia;
    }
    public double getTarifaConsulta() {
        return tarifaConsulta;
    }
    public void setTarifaConsulta(double tarifaConsulta) {
        this.tarifaConsulta = tarifaConsulta;
    }
    public int getNConsultas() {
        return NConsultas;
    }
    public void setNConsultas(int NConsultas) {
        this.NConsultas = NConsultas;
    }
    @Override
    public double calcularSalario() {
        return getSalarioBase() + (NConsultas * tarifaConsulta);
    }
}