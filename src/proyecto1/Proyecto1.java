package proyecto1;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Proyecto1 {

    // Herramienta Scanner
    private static Scanner teclado = new Scanner(System.in);
    // Bitacora
    private static Bitacora bitacora = new Bitacora();

    public static void main(String[] args) {
        // Bienvenida al programa y nombre de usuario 
        System.out.println("BIENVENIDO AL SISTEMA DE INVENTARIO");
        System.out.println("Porfavor ingrese su nombre: ");
        String usuario = teclado.nextLine();

        // Bienvenida al menú del sistema
        System.out.println("Bienvenido al menú del sistema " + usuario);

        int opcion = 0;

        do {
            System.out.println("----------------- MENÚ-----------------");
            System.out.println("1. Agregar producto");
            System.out.println("2. Buscar producto");
            System.out.println("3. Eliminar producto");
            System.out.println("4. Registrar venta");
            System.out.println("5. Bitácora");
            System.out.println("6. Generar reportes");
            System.out.println("7. Ver datos de estudiante");
            System.out.println("8. Salir");
            System.out.println("");
            System.out.println("Porfavor seleccione una opción");

            try {
                opcion = teclado.nextInt();

                switch (opcion) {
                    case 1:
                        agregarProducto();
                        break;
                    case 2:
                        buscarProducto();
                        break;
                    case 3:
                        eliminarProducto();
                        break;
                    case 4:
                        registrarVenta();
                        break;
                    case 5:
                        verBitacora();
                        break;
                    case 6:
                        generarReportes();
                        break;
                    case 7:
                        verDatosEstudiante();
                        break;
                    case 8:
                        salirSistema();
                        break;
                    default:
                        System.out.println("Porfavor seleccione una opción del 1 al 8");
                        System.out.println("");
                }
            } catch (InputMismatchException e) {
                System.out.println("");
                System.out.println("Error: Ingrese un número válido ");
                teclado.nextLine();
            }
        } while (opcion != 8);
        System.out.println("EL PROGRAMA HA FINALIZADO");
    }
    
    // Método para validar que la opción sea número 
    public static int validarOpcion(){
    while (!teclado.hasNextInt()){
        System.out.println("Error: Debe ingresar un número: ");
        teclado.next();
    }
    return teclado.nextInt();
    }

    //Opción 1: Agregar producto 
    public static void agregarProducto() {
        System.out.println("----------------- AGREGAR PRODUCTO-----------------");
        teclado.nextLine();

        try {
            System.out.println("Ingrese el código del producto: ");
            String codigo = teclado.nextLine().trim();

            if (codigo.isEmpty()) {
                System.out.println("Error: el código no puede estar vacío");
                return;
            }
            System.out.println("Ingrese el nombre del producto: ");
            String nombre = teclado.nextLine().trim();

            if (nombre.isEmpty()) {
                System.out.println("Error: el nombre no puede estar vacío");
                return;
            }

            System.out.println("Ingrese la categoría del producto: ");
            String categoria = teclado.nextLine().trim();

            if (categoria.isEmpty()) {
                System.out.println("Error: la categoría no puede estar vacía");
                return;
            }

            System.out.println("Ingrese el precio del producto: Q");
            double precio = teclado.nextDouble();

            if (precio <= 0) {
                System.out.println("Error: el precio debe ser mayor a 0");
                return;
            }

            System.out.println("Ingrese cantidad en stock: ");
            int stock = teclado.nextInt();

            if (stock < 0) {
                System.out.println("Error: el stock no puede ser negativo");
                return;
            }

            // Creación del producto 
            Producto nuevoProducto = new Producto(codigo, nombre, categoria, precio, stock);
            Inventario.agregarProducto(nuevoProducto);
        } catch (Exception e) {
            System.out.println("Error: Datos inválidos. Intente nuevamente");
        }
    }

    // Opción 2: Buscar producto 
    public static void buscarProducto() {
        System.out.println("----------------- BUSCAR PRODUCTO -----------------");
        if (Inventario.inventarioVacio()) {
            System.out.println("El inventario está vacío");
            return;
        }
        System.out.println("Seleccione la opcion de búsqueda: ");
        System.out.println("1. Por código");
        System.out.println("2. Por nombre");
        System.out.println("3. Por categoría");
        System.out.println("Digite la opción: ");

        int opcionBusqueda = validarOpcion();
        teclado.nextLine();

        switch (opcionBusqueda) {
            case 1:
                System.out.println("Ingrese el código del producto: ");
                String codigo = teclado.nextLine().trim();
                Producto producto = Inventario.buscarCodigo(codigo);
                if (producto != null){
                producto.mostrarInformación();
                }else{
                    System.out.println("No se encontró un producto con el código: "+codigo);
                }
                break;
            case 2: 
                System.out.println("Ingrese el nombre del producto: ");
                String nombre = teclado.nextLine().trim();
                Inventario.buscarNombre(nombre);
                break;
            case 3:
                System.out.println("Ingrese la categoría");
                String categoria = teclado.nextLine().trim();
                Inventario.buscarCategoria(categoria);
                break;
                
            default:
                System.out.println("Opción no válida");
        }
    }

    
    //Opción 3:  Eliminar producto 
    public static void eliminarProducto() {
        System.out.println("----------------- ELIMINAR PRODUCTO -----------------");
        if (Inventario.inventarioVacio()){
            System.out.println("El inventario está vacio");
            return;
        }
        System.out.println("Ingrese el código de producto a eliminar: ");
        String codigo = teclado.nextLine().trim();
        
        Inventario.eliminarProducto(codigo);
        
    }
    
   
    // Opción 4: Registrar venta 
    public static void registrarVenta() {
        System.out.println("----------------- REGISTRAR VENTA -----------------");
        
        
        
    }

    // Opción 5: Ver Bitacora
    public static void verBitacora() {
        System.out.println("-----------------  BITACORA -----------------");
    }

    // Opción 6: Generar reportes
    public static void generarReportes() {
        System.out.println("----------------- GENERAR REPORTES -----------------");
    }

    // Opción 7: Ver datos de estudiante
    public static void verDatosEstudiante() {
        System.out.println("----------------- DATOS DE ESTUDIANTE -----------------");
        System.out.println("Nombre: Alan Javier García Pérez");
        System.out.println("Carnet: 202101135");
        System.out.println("Curso: Laboratorio de Introducción a la Programación y Computación 1");
        System.out.println("Sección:  C");
    }

    // Opción 8: Salir del sistema
    private static void salirSistema() {
        System.out.println("----------------- SALIENDO DEL SISTEMA -----------------");
        System.out.println("Gracias por usar el sistema de inventario ");

    }

}
