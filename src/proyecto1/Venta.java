package proyecto1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Venta {
    // Atributos 
    private String codigoProducto;
    private String nombreProducto;
    private int cantidadVendida;
    private double precioUnitario;
    private double totalVenta;
    private String fechaHora;
    
    // Constructor para nueva venta 
    public Venta(String codigoProducto, String nombreProducto, int cantidadVendida, double precioUnitario){
    this.codigoProducto = codigoProducto;
    this.nombreProducto = nombreProducto;
    this.cantidadVendida = cantidadVendida;
    this.precioUnitario = precioUnitario;
    this.totalVenta = cantidadVendida * precioUnitario;
    this.fechaHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }
    
    // Constructor vacio 
    public Venta(){
    this.codigoProducto = "";
    this.nombreProducto = "";
    this.cantidadVendida = 0;
    this.precioUnitario = 0.0;
    this.totalVenta = 0.0;
    this.fechaHora = "";
    }
        
    // Getters 
    public String getCodigoProducto(){
    return codigoProducto;
    }
   public String getNombreProducto(){
   return nombreProducto;
   } 
    public int getCantidadVendida (){
    return cantidadVendida;
  
    }
    public double getPrecioUnitario (){
    return precioUnitario;
   
    }
    public double getTotalVenta (){
    return totalVenta;
    }
    public String getFechaHora(){
    return fechaHora;
    }
    
    // Setters 
    public void setCodigoProducto(String codigoProducto){
    this.codigoProducto = codigoProducto;
    }
    public void setNombreProducto(String nombreProducto){
    this.nombreProducto = nombreProducto;
    }
    public void setCantidadVendida (int cantidadVendida){
    this.cantidadVendida = cantidadVendida;
      this.totalVenta = cantidadVendida * precioUnitario;
    }
    public void setPrecioUnitario (double precioUnitario){
    this.precioUnitario = precioUnitario;
     this.totalVenta = cantidadVendida * precioUnitario;
    }
    public void setTotalVenta (double totalVenta){
    this.totalVenta = totalVenta;
    }
    public void setFechaHora (String fechaHora){
    this.fechaHora = fechaHora;
    }
    
    //Convertir a string para mostrar info
    public String toString(){
    return String.format("Codigo: %-10s | Producto: %-20s | Cantidad: %3d | P.unit: Q%2f | Total: Q%2f | Fecha: %s");
    }
    
    // Mostrar info 
    public void mostrarDetalleVenta(){
        System.out.println("------DETALLE DE VENTA-------");
        System.out.println("Código del producto: " + codigoProducto);
        System.out.println("Nombre del producto: " + nombreProducto);
        System.out.println("Cantidad vendida: "+ cantidadVendida + " unidades");
        System.out.println("Precio unitario: Q" + String.format("%.2f", precioUnitario));
        System.out.println("Total de la venta: Q" + String.format("%.2f", totalVenta));
        System.out.println("Fecha y hora: " + fechaHora);
    }
    
// Convertir a formato archivo de texto 
public String toFileString(){
return codigoProducto + "," + nombreProducto + "," + cantidadVendida + "," + precioUnitario + "," + totalVenta + "," + fechaHora;
} 
    }

