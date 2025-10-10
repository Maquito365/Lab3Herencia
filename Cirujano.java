public class Cirujano extends PersonalMedico{
    private String TipoOperacion;
    private int HorasCirugia;
    private double BonosPorRiesgo;
    private double TarifaPHora;
    
    public Cirujano(int ID, String NCompleto, String Departamento, int AniosExperiencia, int SalarioBase, String TipoOperacion, 
    int HorasCirugia, double BonosPorRiesgo, double TarifaPHora){
        super(ID, NCompleto, Departamento, AniosExperiencia, SalarioBase);
        this.TipoOperacion = TipoOperacion;
        this.HorasCirugia = HorasCirugia;
        this.BonosPorRiesgo = BonosPorRiesgo;
        this.TarifaPHora = TarifaPHora;
    }
    public String getTipoOperacion(){
        return TipoOperacion;
    }
    public int getHorasCirugia(){
        return HorasCirugia;
    }
    public double getBonosPorRiesgo(){
        return BonosPorRiesgo;
    }
    public double getTarifaPHora(){
        return TarifaPHora;
    }
    public void setTipoOperacion(String TipoOperacion){
        this.TipoOperacion = TipoOperacion;
    }
    public void setHorasCirugia(int HorasCirugia){
        this.HorasCirugia = HorasCirugia;
    }
    public void setBonosPorRiesgo(double BonosPorRiesgo){
        this.BonosPorRiesgo = BonosPorRiesgo;
    }
    public void setTarifaPHora(double TarifaPHora){
        this.TarifaPHora = TarifaPHora;
    }

    @Override
    public double calcularSalario(){
        return getSalarioBase() + (HorasCirugia * TarifaPHora) + BonosPorRiesgo;
    }

}