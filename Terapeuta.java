public class Terapeuta extends PersonalMedico{
    private String tipoTerapia;
    private double DuracionPromedioSesiones;
    private double ComisionPorSesion;
    private int Csensiones;

    public Terapeuta(int ID, String NCompleto, String Departamento, int AñosExperiencia, int SalarioBase, 
    String tipoTerapia, double DuracionPromedioSesiones, double ComisionPorSesion, int Csensiones) {
        super(ID, NCompleto, Departamento, AñosExperiencia, SalarioBase);
        this.tipoTerapia = tipoTerapia;
        this.DuracionPromedioSesiones = DuracionPromedioSesiones;
        this.ComisionPorSesion = ComisionPorSesion;
        this.Csesiones = Csensiones;
    }
    public String getTipoTerapia() {
        return tipoTerapia;
    }
    public void setTipoTerapia(String tipoTerapia) {
        this.tipoTerapia = tipoTerapia;
    }
    public double getDuracionPromedioSesiones() {
        return DuracionPromedioSesiones;
    }
    public void setDuracionPromedioSesiones(double DuracionPromedioSesiones) {
        this.DuracionPromedioSesiones = DuracionPromedioSesiones;
    }
    public double getComisionPorSesion() {
        return ComisionPorSesion;
    }
    public void setComisionPorSesion(double ComisionPorSesion) {
        this.ComisionPorSesion = ComisionPorSesion;
    }
    public int getCsensiones() {
        return Csensiones;
    }
    public void setCsensiones(int Csensiones) {
        this.Csesiones = Csensiones;
    }

    @Override
    public double calcularSalario(){
        return getSalarioBase() + (ComisionPorSesion * Csensiones);
    }
}