package nutrifit;

public class Persona {

    private String cedula;
    private String nombres;
    private String apellidos;
    private String telefono;
    private String correo;
    private String direccion;

    public Persona(String cedula, String nombres, String apellidos, String telefono, String correo, String direccion) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void enviarCorreo(Recetario[] semanal) {
        System.out.println("Enviar correo a: " + this.correo);
        if (this instanceof ClienteVip) {
            ClienteVip vip = (ClienteVip) this;
            System.out.println("Debe pagar un valor mensual de $120");
            System.out.println("Aqui su Recetario");
            System.out.println("Fecha Inicio: Lunes/" + semanal[0].fechaInicio.toString()
                    + " Viernes/" + semanal[0].fechaFin().toString());
            System.out.println("Lunes: " + semanal[0]);
            System.out.println("Martes: " + semanal[1]);
            System.out.println("Miercoles: " + semanal[2]);
            System.out.println("Jueves: " + semanal[3]);
            System.out.println("Viernes: " + semanal[4]);
            System.out.println("Su IMC es: " + Double.toString(vip.IMC()));
        } else if (this instanceof ClienteFresh) {
            ClienteFresh fresh = (ClienteFresh) this;
            if (fresh.isEnvio()) {
                System.out.println("Debe pagar un valor mensual de $70");

            } else {
                System.out.println("Debe pagar un valor mensual de $" + Integer.toString(70 + 30));
            }
            System.out.println("Aqui su Recetario");
            System.out.println("Fecha Inicio: Lunes/" + semanal[0].fechaInicio.toString()
                    + " Viernes/" + semanal[0].fechaFin().toString());
            System.out.println("Lunes: " + semanal[0]);
            System.out.println("Martes: " + semanal[1]);
            System.out.println("Miercoles: " + semanal[2]);
            System.out.println("Jueves: " + semanal[3]);
            System.out.println("Viernes: " + semanal[4]);

        } else {
            System.out.println("No se puede enviar correo.");
        }
    }

}
