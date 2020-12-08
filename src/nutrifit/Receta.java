
package nutrifit;

import java.io.Serializable;
import java.util.ArrayList;

public class Receta implements Serializable{
    private static final long serialVersionUID = -7994075029785071481L;
    private ArrayList<Alimento> productos;
    private String descripcion;

    public Receta(String descripcion) {
        this.descripcion = descripcion;
        this.productos = new ArrayList<>();
    }

    public ArrayList<Alimento> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Alimento> productos) {
        this.productos = productos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public int valorNutricional(){
        int valorTotal = 0;
        for(Alimento a:productos){
            valorTotal += a.getCalorias() + a.getFibras() + a.getGramos() 
                    + a.getGrasas() + a.getHidratos() + a.getProteinas();
        }
        return valorTotal;
    }   

    @Override
    public String toString() {
        return this.getDescripcion();
    }
    
    
}
