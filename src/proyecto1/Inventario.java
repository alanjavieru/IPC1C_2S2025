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
    public static boolean agregarProducto (Producto nuevoProducto){
        //Verificar si hay espacio en inventario 
    if(total >= CAPACIDAD_MAX){
        System.out.println("El inventario está lleno");
        return false;
    }
    // Verificar si ya existe - codigo 
    if (buscarCodigo(nuevoProducto.getCodigo())!= null){
        System.out.println("Ya existe un producto con el código " + nuevoProducto.getCodigo());
        return false;
    }
    
    // Agregar a inventario 
    productos [total] = nuevoProducto;
    total++;
    
        System.out.println("Se ha agregado el producto:");
        nuevoProducto.mostrarInformación();
        return true;
    }
    
    // Buscar por código 
    public static Producto buscarCodigo(String codigo){
    for(int i=0; i< total; i++){
    if (productos[i].getCodigo().equalsIgnoreCase(codigo)){
    return productos[i];
    }
    }
    return null;
    }
    
    // Buscar por nombre
    public static void buscarNombre(String nombre){
    boolean encontrado = false;
        System.out.println("-------- RESULTADOS --------");
        
        for (int i=0; i< total; i++){
        if(productos [i].getNombre().toLowerCase().contains(nombre.toLowerCase())){
            System.out.println(productos[i].toString());
            encontrado = true;
        }
        }
        if(!encontrado){
            System.out.println("No se encontraron resultados con el nombre: " + nombre);
        }
    }
    
    
    // Buscar por categoria 
    public static void buscarCategoria(String categoria){
    boolean encontrado = false;
        System.out.println("-------- RESULTADOS --------");
        
        for(int i=0; i<total; i++){
        if (productos[i].getCategoria().equalsIgnoreCase(categoria)){
            System.out.println(productos[i].toString());
            encontrado = true;
        }
        }
        if (!encontrado){
            System.out.println("No se encontraron resultados en la categoría: " + categoria);
        }
    }
    
    
    // Eliminar producto 
    public static boolean eliminarProducto(String codigo){
    for (int i =0; i< total; i++){
    if (productos[i].getCodigo().equalsIgnoreCase(codigo)){
        // Confirmación 
        System.out.println("¿Está seguro de eliminar el producto?");
        productos[i].mostrarInformación();
        System.out.println("Porfavor escriba SI para confirmar: " );
        String confirmacion = teclado.nextLine();
        
        if (confirmacion.equalsIgnoreCase("SI")){
        // Mover todos los productos una posición hacia atras 
        for (int j=1; j< total -1; j++){
        productos[j] = productos[j+1];
        }
        productos[total - 1] = null;
        total--;
        
            System.out.println("El producto se ha eliminado");
            return true;
        }else{
            System.out.println("Se ha cancelado la eliminación");
            return false;
        }
    }
    }
        System.out.println("No se encontró un producto con el codigo: " + codigo);
        return false;
    }
    
    
    // Mostrar inventario 
    public static void mostrarInventario(){
        System.out.println("------ RESULTADO ------");
        System.out.println("El total de productos es: " + total);
        System.out.println("");
        
        for (int i = 0; i< total; i++){
            System.out.println((i + 1) + ". " + productos[i].toString());
        }
    }
    
    
    // Total productos en inventario 
    public static int getTotalProductos(){
    return total;
    }
    
    // Verificar si está vacío
    public static boolean inventarioVacio(){
    return total == 0;
    }
    
    // Obtener productos para reportes
    public static Producto[]obtenerProductos(){
    Producto[]productosActivos = new Producto[total];
    for (int i= 0; i< total; i++){
    productosActivos[i] = productos[i];
    }
    return productosActivos;
    }
    
    
    
}
