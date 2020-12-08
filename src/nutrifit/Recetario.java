
package nutrifit;

import java.time.LocalDate;

public class Recetario {
    private Receta desayuno, almuerzo, merienda;
    public LocalDate fechaInicio;

    public Recetario(Receta desayuno, Receta almuerzo, Receta merienda,LocalDate fecha) {
        this.desayuno = desayuno;
        this.almuerzo = almuerzo;
        this.merienda = merienda;
        this.fechaInicio = fecha;
    }

    public Receta getDesayuno() {
        return desayuno;
    }

    public void setDesayuno(Receta desayuno) {
        this.desayuno = desayuno;
    }

    public Receta getAlmuerzo() {
        return almuerzo;
    }

    public void setAlmuerzo(Receta almuerzo) {
        this.almuerzo = almuerzo;
    }

    public Receta getMerienda() {
        return merienda;
    }

    public void setMerienda(Receta merienda) {
        this.merienda = merienda;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    
    public LocalDate fechaFin(){
        LocalDate fin = fechaInicio.plusDays(5);
        return fin;

    }

    @Override
    public String toString() {
        return "\ndesayuno=" + desayuno + "\nalmuerzo=" + almuerzo + "\nmerienda=" + merienda;
    }




    
    
    
}
