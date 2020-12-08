package nutrifit;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;


public class NutriFit {

    
    public static ArrayList<Alimento> alimentos = new ArrayList<>();
    public static ArrayList<Receta> recetas = new ArrayList<>();
    public static ArrayList<ClienteVip> clientesVip = new ArrayList<>();
    public static ArrayList<ClienteFresh> clientesFresh = new ArrayList<>();
    public static Recetario[] semanal = new Recetario[5];

    static String mensaje = "Bienvenido a NutriFit\n"
            + "1.- Subida de Productos\n"
            + "2.- Registro de Recetas\n"
            + "3.- Registro de Clientes\n"
            + "4.- Creación Automática de Menú Semanal\n"
            + "5.- Envió de Menú Semanal a Clientes por correo electrónico\n"
            + "6.- Consultar Suscripciones\n"
            + "7.- Salir\n";

    public static void main(String[] args) {

        ManejadorArchivo.leerRecetas();
        ManejadorArchivo.llenarIngredientes(alimentos);
        Scanner sc = new Scanner(System.in);
        String opcion = "";
        while (!opcion.equalsIgnoreCase("7")) {
            System.out.println(mensaje);
            System.out.print("Elegir opcion: ");
            opcion = sc.nextLine();
            menuPrincipal(opcion);
        }

    }

    public static void menuPrincipal(String opcion) {
        switch (opcion) {
            case "1": {
                subirProducto();
                break;
            }
            case "2": {
                registrarReceta();
                break;
            }
            case "3": {
                registroClientes();
                break;
            }
            case "4": {
                crearMenuSemanal();
                break;
            }
            case "5": {
                enviarCorreos();
                break;
            }
            case "6": {
                consultarSuscripciones();
                break;
            }
            case "7": {
                System.out.println("Gracias por usar NutriFit!");
                break;
            }
            default: {
                break;
            }
        }
    }

    public static void subirProducto() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Escrbir Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("\nEscribir calorias: ");
        String caloria = sc.nextLine();
        System.out.print("\nEscribir hidrato: ");
        String hidrato = sc.nextLine();
        System.out.print("\nEscribir proteina: ");
        String proteina = sc.nextLine();
        System.out.print("\nEscribir grasa: ");
        String grasa = sc.nextLine();
        System.out.print("\nEscribir fibra: ");
        String fibra = sc.nextLine();
        System.out.println("");
        String[] campos = {nombre, caloria, hidrato, proteina, grasa, fibra};
        Alimento alimento = new Alimento(campos);
        ManejadorArchivo.escribirIngrediente(alimento);
    }

    public static void registrarReceta() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Escribe una descripcion: ");
        String desc = sc.nextLine();
        Receta receta = new Receta(desc);
        if (!desc.equalsIgnoreCase("")) {
            String query = "";
            while (!query.equalsIgnoreCase("no")) {
                System.out.print("Agregar a la receta (Para dejar de agregar escribir no): ");
                query = sc.nextLine();
                for (Alimento a : alimentos) {
                    if (a.getNombre().equalsIgnoreCase(query)) {
                        if (!receta.getProductos().contains(a)) {
                            receta.getProductos().add(a);
                        }
                    }
                }
            }
            if (!receta.getProductos().isEmpty()) {
                recetas.add(receta);
                ManejadorArchivo.escribirReceta(recetas);
            } else {

                System.out.println("La receta no contiene productos.");
            }
        }else{
            System.out.println("La descripcion esta vacia.");
        }

        System.out.println("Las recetas que hay hasta ahora son:");
        for (Receta r : recetas) {
            System.out.println(r.getProductos());
            System.out.println(r.getDescripcion());
        }

    }

    public static void registroClientes() {
        try {

            Scanner sc = new Scanner(System.in);
            System.out.print("Numero de cedula: ");
            String cedula = sc.nextLine();
            Integer.parseInt(cedula);
            if (cedula.length() != 10) {
                throw new NumberFormatException("Cedula invalida");
            }
            System.out.print("Nombres: ");
            String nombres = sc.nextLine();
            System.out.print("Apellidos: ");
            String apellidos = sc.nextLine();
            System.out.print("Telefono: ");
            String telefono = sc.nextLine();
            Integer.parseInt(telefono);
            System.out.print("Correo Electronico: ");
            String correo = sc.nextLine();
            if (!correo.contains("@")) {
                throw new Exception("correo electronico invalido");
            }
            System.out.print("direccion : ");
            String direccion = sc.nextLine();
            System.out.print("Escoger Cliente Vip (1) o Fresh(2): ");
            String query = sc.nextLine();
            Persona p = new Persona(cedula, nombres, apellidos, telefono, correo, direccion);
            if (query.equalsIgnoreCase("1")) {
                System.out.print("Esribir peso: ");
                String peso = sc.nextLine();
                int pesoInt = Integer.parseInt(peso);
                System.out.print("Escribir altura: ");
                String altura = sc.nextLine();
                double alturaDouble = Double.parseDouble(altura);
                System.out.print("Escribir horas de ejercios semanales: ");
                String horas = sc.nextLine();
                int horasInt = Integer.parseInt(horas);
                System.out.print("Escribir profesion: ");
                String profesion = sc.nextLine();
                ClienteVip vip = new ClienteVip(p, pesoInt, alturaDouble, horasInt, profesion);
                clientesVip.add(vip);
            } else {
                System.out.print("Desea ser envio adicional? (si/no): ");
                String eleccion = sc.nextLine();
                ClienteFresh fresh;
                if (eleccion.equalsIgnoreCase("si")) {
                    fresh = new ClienteFresh(p, true);
                } else {
                    fresh = new ClienteFresh(p, false);
                }
                clientesFresh.add(fresh);
            }
        } catch (NumberFormatException ex) {
            System.out.println(ex);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static void crearMenuSemanal() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Escribir fecha(yyyy-mm-dd): ");
            String fecha = sc.nextLine();
            if (recetas.size() >= 15) {
                Queue<Receta> cola = new LinkedList<>();
                Collections.shuffle(recetas);
                cola.addAll(recetas);
                for (int i = 0; i < 5; i++) {
                    Receta desayno = cola.poll();
                    Receta almuerzo = cola.poll();
                    Receta merienda = cola.poll();
                    semanal[i] = new Recetario(desayno, almuerzo, merienda, LocalDate.parse(fecha));
                }
                for (Recetario r : Arrays.asList(semanal)) {
                    System.out.println(r);
                }
            } else {
                System.out.println("No hay Recetas suficientes");
            }
        } catch (DateTimeParseException ex) {
            System.out.println(ex);
        }
    }

    public static void enviarCorreos() {
        if (clientesVip.isEmpty() && clientesFresh.isEmpty() || Arrays.asList(semanal).isEmpty()) {
            System.out.println("No hay correos para enviar");
        } else {
            if (!clientesVip.isEmpty()) {
                for (ClienteVip c : clientesVip) {
                    c.enviarCorreo(semanal);
                }
            } else {
                System.out.println("No hay correos para Clientes Vip");
            }

            if (!clientesFresh.isEmpty()) {
                for (ClienteFresh f : clientesFresh) {
                    f.enviarCorreo(semanal);
                }
            } else {
                System.out.println("No hay correos para Clientes Fresh");
            }
        }

    }

    public static void consultarSuscripciones() {
        System.out.println("Hay " + Integer.toString(clientesVip.size()) + " Clientes Vip");
        System.out.println("Hay " + Integer.toString(clientesFresh.size()) + " Clientes Fresh");
    }

}
