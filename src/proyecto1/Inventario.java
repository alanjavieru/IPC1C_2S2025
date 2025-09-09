package proyecto1;

import java.util.Scanner;

public class Inventario {
    
    // Arreglo - almacenar productos 
    private static Producto[]productos;
    // productos registrados
    private static int total;
    // Constante- capacidad maxima 
    private static final int CAPACIDAD_MAX = 1000;
    // Scanner
    private static Scanner teclado = new Scanner(System.in);
    
    //Inicializar 
    static{
    productos = new Producto[CAPACIDAD_MAX];
    total = 0;
    }
    
    // Nuevo producto 
    
    
}
