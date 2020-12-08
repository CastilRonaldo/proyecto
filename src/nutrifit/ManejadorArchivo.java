package nutrifit;

import java.io.*;

import java.util.ArrayList;

public class ManejadorArchivo {

    public static void llenarIngredientes(ArrayList<Alimento> alimentos) {
        BufferedReader buff = null;
        try {
            buff = new BufferedReader(new FileReader("Ingredientes.csv"));
            buff.readLine();
            String linea = buff.readLine();
            while (linea != null) {
                String[] campos = linea.split(",");
                alimentos.add(new Alimento(campos));
                linea = buff.readLine();
            }
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            if (buff != null) {
                try {
                    buff.close();
                } catch (IOException e) {
                    System.out.println(e);
                }
            }
        }
    }

    public static void escribirIngrediente(Alimento a) {

        try (FileWriter myWriter = new FileWriter("Ingredientes.csv", true)) {
            myWriter.write(a.toString() + "\n");
            myWriter.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void escribirReceta(ArrayList<Receta> r) {
        try {
            FileOutputStream archivo = new FileOutputStream("recetas.bin");
            ObjectOutputStream obj = new ObjectOutputStream(archivo);
            obj.writeObject(r);
            obj.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public static void leerRecetas() {
        try {

            FileInputStream fileIn = new FileInputStream("recetas.bin");
            ObjectInputStream objStream = new ObjectInputStream(fileIn);
            ArrayList<Receta> obj = (ArrayList<Receta>)objStream.readObject();
            NutriFit.recetas.addAll(obj);
            objStream.close();

        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex);
        }
    }
}
