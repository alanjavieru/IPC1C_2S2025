package proyecto1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class SistemaVentas {
// Arreglo almacenar ventas 
    private static Venta[] ventas;
    private static int totalVentas;
    private static final int CAPACIDAD_MAX = 5000;
    private static final String ARCHIVO_VENTAS = "Ventas.txt";
    private static Scanner teclado = new Scanner(System.in);
    
    // Inicializar 
   static {
   ventas = new Venta[CAPACIDAD_MAX];
   totalVentas = 0;
   cargarVentasDesdeArchivo();
   }
    
    // Procesar ventas 
   public static boolean procesarVenta(String codigoProducto, int cantidadVender) throws IOException{
   
       // Buscar producto en inventario
       Producto producto = Inventario.buscarCodigo(codigoProducto);
       
       if(producto == null){
           System.out.println("No se encontró el producto con código " + codigoProducto);
           return false;
       }
       
       // verificar si hay stock
       if(!producto.verificarStock(cantidadVender)){
           System.out.println("Stock insuficiente");
           System.out.println("El stock disponible es: " + producto.getStock());
           return false;
       }
       
       // Confirmación de venta
       System.out.println("-----CONFIRMAR VENTA------");
       System.out.println("Producto: " + producto.getNombre());
       System.out.println("Precio Unitario: Q" + String.format("%.2f", producto.getPrecio()));
       System.out.println("Cantidad a vender: " + cantidadVender);
       System.out.println("Total a pagar: Q" + String.format("%.2f", (producto.getPrecio()*cantidadVender)));
       
       String confirmacion = teclado.nextLine();
       
       if (!confirmacion.equalsIgnoreCase("SI")){
           System.out.println("Venta cancelada");
           return false;
       }
       
       // procesar la venta 
       if(producto.reducirStock(cantidadVender)){
       Venta nuevaVenta = new Venta(
       producto.getCodigo(),producto.getNombre(), cantidadVender, producto.getPrecio()
       );
       
       //Guardar venta en sistema
       if(agregarVenta(nuevaVenta)){
           System.out.println("VENTA PROCESADA EXITOSAMENTE");
           nuevaVenta.mostrarDetalleVenta();
           guardarVentaEnArchivo(nuevaVenta);
           return true;
       } else {
       // Revertir reducción de stock si no se registra la venta
       producto.añadirStock(cantidadVender);
           System.out.println("No se registro la venta");
           return false;
       }
       }
       return false;
   }
   
   
   // Agrega venta a sistema
   private static boolean agregarVenta(Venta venta){
   if (totalVentas >= CAPACIDAD_MAX){
       System.out.println("Sistema de ventas lleno");
       return false;
   }
   ventas[totalVentas] = venta;
   totalVentas++;
   return true;
   }
            
   
   // Historial de ventas
   public static void mostrarHistorialVentas(){
   if(totalVentas == 0){
       System.out.println("No hay ventas registradas");
       return;
   }
       System.out.println("----- HISTORIAL DE VENTAS -----");
       System.out.println("Total de ventas: " + totalVentas);
       System.out.println();
       
       double totalGanancias = 0;
       for (int i = 0; i < totalVentas; i++){
           System.out.println((i+1) + "." + ventas[i].toString());
           totalGanancias += ventas [i].getTotalVenta();
       }
       System.out.println("Total de ganancias: Q" + String.format("%.2f", totalGanancias));
   }

   // Guardar venta en archivo 
   private static void guardarVentaEnArchivo(Venta venta) throws IOException{
   try{
   FileWriter writer = new FileWriter(ARCHIVO_VENTAS, true);
   PrintWriter printWriter = new PrintWriter(writer);
   printWriter.println(venta.toFileString());
   printWriter.close();
   }catch (IOException e){
       System.out.println("Error al guardar la venta en archivo: " + e.getMessage());
   }
   }
    
   
   // Cargar las ventas desde el archivo al iniciar el programa 
   private static void cargarVentasDesdeArchivo(){
   try{
   File archivo = new File(ARCHIVO_VENTAS);
   if(!archivo.exists()){
   return;
   }
   
   BufferedReader reader = new BufferedReader (new FileReader(archivo));
   String linea;
   
   while ((linea = reader.readLine())!= null && totalVentas < CAPACIDAD_MAX){
   String[] datos = linea.split(",");
   if (datos.length == 6){
   Venta venta = new Venta();
   venta.setCodigoProducto(datos[0]);
   venta.setNombreProducto(datos[1]);
   venta.setCantidadVendida(Integer.parseInt(datos[2]));
   venta.setPrecioUnitario(Double.parseDouble(datos[3]));
   venta.setFechaHora(datos[5]);
   
   ventas[totalVentas]=venta;
   totalVentas++;
   }
   }
   reader.close();
   }catch(IOException | NumberFormatException e){
       System.out.println("Error al cargar ventas desde archivo"+ e.getMessage());
   }
   }
   
   //Obtener ventas para reportes
   public static Venta[]obtenerTodasLasVentas(){
   Venta[] ventasActivas = new Venta [totalVentas];
   for (int i = 0; i< totalVentas; i++){
   ventasActivas[i]=ventas[i];
   }
   return ventasActivas;
   }
   
   // Obtener todas las ventas registradas 
   public static int getTotalVentas(){
   return totalVentas;
   }
   
   // Calcula el total de ganancias
   public static double calcularTotalGanancias(){
   double total = 0;
   for (int i = 0; i<totalVentas; i++){
   total += ventas[i].getTotalVenta();
   }
   return total;
   }
}
