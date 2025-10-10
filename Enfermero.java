public class Enfermero extends PersonalMedico{
    private boolean turno; //True= Nocturno, False=Diurno
    private int NivelCertificacion;
    private double bonoNocturno;

    public Enfermero(int ID, String NCompleto, String Departamento, int AñosExperiencia, int SalarioBase,
    boolean turno, int NivelCertificacion, double bonoNocturno){
        super(ID, NCompleto, Departamento, AñosExperiencia, SalarioBase);
        this.turno = turno;
        this.NivelCertificacion = NivelCertificacion;
        this.bonoNocturno = bonoNocturno;
    }
    public boolean isTurno() {
        return turno;
    }
    public void setTurno(boolean turno) {
        this.turno = turno;
    }
    public int getNivelCertificacion() {
        return NivelCertificacion;
    }
    public void setNivelCertificacion(int NivelCertificacion) {
        this.NivelCertificacion = NivelCertificacion;
    }
    public double getBonoNocturno() {
        return bonoNocturno;
    }
    public void setBonoNocturno(double bonoNocturno) {
        this.bonoNocturno = bonoNocturno;
    }
    
    @Override
    public double calcularSalario(){
        double salario = getSalarioBase();
        if(turno==true){
            salario += bonoNocturno;
            return salario;
        }
        else{
            return salario;
        }
    }
}