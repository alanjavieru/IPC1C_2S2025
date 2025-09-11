package proyecto1;


public class Producto {
    // Atributos
    private String nombre;
    private String codigo;
    private String categoria;
    private int stock;
    private double precio;
    
    // Constructor - crear producto 
    public Producto(String codigo, String nombre, String categoria, double precio, int stock ){
    this.codigo = codigo;
    this.nombre = nombre;
    this.categoria = categoria;
    this.precio = precio;
    this.stock = stock;

    }
    
    // Constructor vacío
    public Producto(){
    this.codigo = "";    
    this.nombre = "";
    this.categoria = "";
    this.precio = 0.0;
    this.stock = 0;

    }
     
    // Getters
    public String getNombre(){
    return nombre;
    }
   
    public String getCodigo(){
    return codigo;
    }
    
   public String getCategoria(){
    return categoria;
    }
    
     public int getStock(){
    return stock;
    }
     
     public double getPrecio(){
     return precio;
     }
     
     //Setters 
     public  void setNombre(String nombre){
     this.nombre = nombre;
     }
     
     public void setCodigo(String codigo){
     this.codigo = codigo;
     }
     
     public void setCategoria(String categoria){
     this.categoria = categoria;
     }
     
     public void setStock(int stock){
     this.stock = stock;
     }
     
     public void setPrecio(double precio){
     this.precio = precio;
     }
     
     // Aumenta stock del producto 
     public void añadirStock(int cantidad){
     stock += cantidad;
     }
     
     // Reduce el stock 
     public boolean reducirStock(int cantidad){
     if (cantidad <= stock){
     stock -= cantidad;
     return true;     
     }
     return false;
     }
    
     // Verificar suficiente stock 
     public boolean verificarStock(int cantidad){
     return stock >= cantidad;
     }
     
     // Conversion a string para mostrar info
     public String convertirString(){
     return String.format("Código: %-20s | Nombre: %-20s | Categoria: %-20s | Precio: Q%.2f | Stock: %d");
     }
     
     //Mostrar info 
     public void mostrarInformación(){
         System.out.println("-----------INFORMACION-----------------");
         System.out.println("Código: " + codigo );
         System.out.println("Nombre: " + nombre );
         System.out.println("Categoría:  " + categoria );
         System.out.println("Precio: Q"+ String.format("%.2f", precio));
         System.out.println("Stock disponible: "+ stock + " unidades");

         
     }
             
}
