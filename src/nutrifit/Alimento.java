
package nutrifit;

import java.io.Serializable;

public class Alimento implements Serializable{
    private String nombre;
    private int calorias;
    private int hidratos;
    private int proteinas;
    private int grasas;
    private int fibras;
    private int gramos;

    public Alimento(String nombre, int calorias, int hidratos, int proteinas, int grasas, int fibras) {
        this.nombre = nombre;
        this.calorias = calorias;
        this.hidratos = hidratos;
        this.proteinas = proteinas;
        this.grasas = grasas;
        this.fibras = fibras;
        this.gramos = 100;
    }

    public Alimento(String[] lista) {
        this.nombre = lista[0];
        this.calorias = Integer.parseInt(lista[1]);
        this.hidratos = Integer.parseInt(lista[2]);
        this.proteinas = Integer.parseInt(lista[3]);
        this.grasas = Integer.parseInt(lista[4]);
        this.fibras = Integer.parseInt(lista[5]);
        this.gramos = 100;
    }
    
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCalorias() {
        return calorias;
    }

    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }

    public int getHidratos() {
        return hidratos;
    }

    public void setHidratos(int hidratos) {
        this.hidratos = hidratos;
    }

    public int getProteinas() {
        return proteinas;
    }

    public void setProteinas(int proteinas) {
        this.proteinas = proteinas;
    }

    public int getGrasas() {
        return grasas;
    }

    public void setGrasas(int grasas) {
        this.grasas = grasas;
    }

    public int getFibras() {
        return fibras;
    }

    public void setFibras(int fibras) {
        this.fibras = fibras;
    }

    public int getGramos() {
        return gramos;
    }

    public void setGramos(int gramos) {
        this.gramos = gramos;
    }

    @Override
    public String toString() {
        return nombre + "," + calorias + "," + hidratos + "," + proteinas + ","
                + grasas + "," + fibras;
    }


    
}
