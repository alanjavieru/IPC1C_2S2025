package proyecto1;


public class Producto {
    // Atributos
    private String nombre;
    private String codigo;
    private String categoria;
    private int stock;
    private double precio;
    
    // Constructor - crear producto 
    public Producto(String nombre, String codigo, String categoria, int stock, double precio){
    this.nombre = nombre;
    this.codigo = codigo;
    this.categoria = categoria;
    this.stock = stock;
    this.precio = precio;
    }
    
    // Constructor vacío
    public Producto(){
    this.nombre = "";
    this.codigo = "";
    this.categoria = "";
    this.stock = 0;
    this.precio = 0.0;
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
     
     // Conversion del producto 
     public String convertirString(){
     return String.format("Nombre: %-20s | Codigo: %-20s | Categoria: %-20s | Stock: %d | Precio: Q%.2f");
     }
     
     //Mostrar info 
     public void mostrarInformación(){
         System.out.println("-----------INFORMACION-----------------");
         System.out.println("Nombre: " + nombre );
         System.out.println("Código: " + codigo );
         System.out.println("Categoría:  " + categoria );
         System.out.println("Stock disponible: "+ stock + " unidades");
         System.out.println("Precio: Q"+ String.format("%.2f", precio));
         
     }
             
}
