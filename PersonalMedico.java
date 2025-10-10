public abstract class PersonalMedico{
    private int ID;
    private String NCompleto;
    private String Departamento;
    private int AniosExperiencia;
    private int SalarioBase;

    public PersonalMedico(int ID, String NCompleto, String Departamento, int AñosExperiencia, int SalarioBase){
        this.ID = ID;
        this.NCompleto = NCompleto;
        this.Departamento = Departamento;
        this.AñosExperiencia = AñosExperiencia;
        this.SalarioBase = SalarioBase;
    }
    public abstract double calcularSalario();
    public int getID(){
        return ID;
    }
    public void setID(int ID){
        this.ID = ID;
    }
    public String getNCompleto(){
        return NCompleto;
    }
    public void setNCompleto(String NCompleto){
        this.NCompleto = NCompleto;
    }
    public String getDepartamento(){
        return Departamento;
    }
    public void setDepartamento(String Departamento){
        this.Departamento = Departamento;
    }
    public int getAñosExperiencia(){
        return AñosExperiencia;
    }
    public void setAñosExperiencia(int AñosExperiencia){
        this.AñosExperiencia = AñosExperiencia;
    }
    public int getSalarioBase(){
        return SalarioBase;
    }
    public void setSalarioBase(int SalarioBase){
        this.SalarioBase = SalarioBase;
    }   

    @Override  
    public String toString(){
        return "ID: " + ID + ", Nombre Completo: " + NCompleto + ", Departamento: " + Departamento + ", Años de Experiencia: " + AñosExperiencia + ", Salario Base: " + SalarioBase;
    }
}