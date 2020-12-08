
package nutrifit;

public class ClienteVip extends Persona {
    private int peso;
    private double estatura;
    private int horas;
    private String profesion;

    public ClienteVip(int peso, double estatura, int horas, String profesion, String cedula, String nombres, String apellidos, String telefono, String correo, String direccion) {
        super(cedula, nombres, apellidos, telefono, correo, direccion);
        this.peso = peso;
        this.estatura = estatura;
        this.horas = horas;
        this.profesion = profesion;
    }
    
    public ClienteVip(Persona p,int peso,double estatura,int horas,String profesion){
        super(p.getCedula(),p.getNombres(),p.getApellidos(),p.getTelefono(),p.getCorreo(),p.getDireccion());
        this.peso = peso;
        this.estatura = estatura;
        this.horas = horas;
        this.profesion = profesion;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public double getEstatura() {
        return estatura;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }
    
    public double IMC(){
        return (double)peso/(estatura * estatura);
    }

}
