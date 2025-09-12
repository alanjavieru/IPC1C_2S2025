package proyecto1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RegistroBitacora {
private String tipoAccion;
private String descripcion;
private boolean exitosa;
private String usuario;
private String fechaHora;

// constructor 
public RegistroBitacora(String tipoAccion, String descripcion, boolean exitosa, String usuario){
this.tipoAccion = tipoAccion;
this.descripcion = descripcion;
this.exitosa = exitosa;
this.usuario = usuario;
this.fechaHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/YYYY HH:mm:ss"));
}

//  Constructor vacio 
public RegistroBitacora(){
this.tipoAccion = "";
this.descripcion = "";
this.exitosa = false;
this.usuario ="";
this.fechaHora = "";
}

// Getters
public String getTipoAccion(){
return tipoAccion;        
}
public String getDescripcion(){
return descripcion;
}
public boolean getExitosa(){
return exitosa;
}
public String getUsuario(){
return usuario;
}
public String getFechaHora(){
return fechaHora;
}

// Setters
public void setTipoAccion(String tipoAccion){
this.tipoAccion = tipoAccion;
}
public void setDescripcion(String descripcion){
this.descripcion = descripcion;
}
public void setExitosa(boolean exitosa){
this.exitosa = exitosa;
}
public void setUsuario(String usuario){
this.usuario = usuario;
}
public void setFechaHora(String fechaHora){
this.fechaHora = fechaHora;
}


// Convertir registro a string para mostrar 
public String toString(){
String estado = exitosa ? "EXITOSA":"ERROR";
return String.format("[%s] %s - %s - %s - Usuario: %s",
    fechaHora, estado, tipoAccion, descripcion, usuario);
}

// Convertir a formato para archivo 
public String toFileString(){
return tipoAccion + "," + descripcion + "," + exitosa + "," + usuario + "," + fechaHora;
}

// Mostrar info del registro 
public void mostrarDetalle(){
    System.out.println("-----DETALLE DE REGISTRO------");
    System.out.println("Tipo de acción: "+ tipoAccion);
    System.out.println("Descripción: " + descripcion);
    System.out.println("Estado: " + (exitosa ? "EXITOSA": "ERROR"));
    System.out.println("Usuario: " + usuario);
    System.out.println("Fecha y hora: " + fechaHora);
    System.out.println("");
    
}


}
