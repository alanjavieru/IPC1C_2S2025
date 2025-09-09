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
        String usuario  = teclado.nextLine();
        
        
        // Bienvenida al menú del sistema
        System.out.println("Bienvenido al menú del sistema " + usuario) ;

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
    
    
    //Opción 1: Agregar producto 
    public static void agregarProducto(){
    System.out.println("----------------- AGREGAR PRODUCTO-----------------");
    }
    
    // Opción 2: Buscar producto 
    public static void buscarProducto(){
    System.out.println("----------------- BUSCAR PRODUCTO -----------------");
    }
    
    //Opción 3:  Eliminar producto 
    public static void eliminarProducto(){
    System.out.println("----------------- ELIMINAR PRODUCTO -----------------");
    }
    
    // Opción 4: Registrar venta 
    public static void registrarVenta(){
    System.out.println("----------------- REGISTRAR VENTA -----------------");
    }
    
    // Opción 5: Ver Bitacora
    public static void verBitacora(){
    System.out.println("-----------------  BITACORA -----------------");
    }
    
    // Opción 6: Generar reportes
    public static void generarReportes(){
    System.out.println("----------------- GENERAR REPORTES -----------------");
    }
    
    // Opción 7: Ver datos de estudiante
    public static void verDatosEstudiante(){
        System.out.println("----------------- DATOS DE ESTUDIANTE -----------------");
        System.out.println("Nombre: Alan Javier García Pérez");
        System.out.println("Carnet: 202101135");
        System.out.println("Curso: Laboratorio de Introducción a la Programación y Computación 1");
        System.out.println("Sección:  C");
    }
    
    // Opción 8: Salir del sistema
    private static void salirSistema(){
        System.out.println("----------------- SALIENDO DEL SISTEMA -----------------");
        System.out.println("Gracias por usar el sistema de inventario ");
        
    }

}
