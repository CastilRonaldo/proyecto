
package nutrifit;

public class ClienteFresh extends Persona{
    private boolean envio;
    private final int adicional = 30;
    public ClienteFresh(boolean envio, String cedula, String nombres, String apellidos, String telefono, String correo, String direccion) {
        super(cedula, nombres, apellidos, telefono, correo, direccion);
        this.envio = envio;
    }
    
    public ClienteFresh(Persona p,boolean envio){
        super(p.getCedula(),p.getNombres(),p.getApellidos(),p.getTelefono(),p.getCorreo(),p.getDireccion());
        this.envio = envio;
    }
    public boolean isEnvio() {
        return envio;
    }

    public void setEnvio(boolean envio) {
        this.envio = envio;
    }

    public int getAdicional() {
        return adicional;
    }
    

}
