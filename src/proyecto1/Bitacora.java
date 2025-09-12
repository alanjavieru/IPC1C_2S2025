package proyecto1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.*;

public class Bitacora {
   private static RegistroBitacora[]registros;
   private static int totalRegistros;
   private static final int CAPACIDAD_MAX = 8000;
   private static final String ARCHIVO_BITACORA ="bitacora.txt";
   private static final String USUARIO_SISTEMA = "Estudiante";
   
   // Inicializar 
   static{
   registros = new RegistroBitacora[CAPACIDAD_MAX];
   totalRegistros = 0;
   }
   
   // Registra una acción en bitácora 
   public static void registrarAccion(String tipoAccion, String descripcion, boolean exitosa){
   if (totalRegistros >= CAPACIDAD_MAX){
   return;
   }
   
   RegistroBitacora registro = new RegistroBitacora(
   tipoAccion,
   descripcion,
   exitosa,
   USUARIO_SISTEMA
           );
   registros[totalRegistros] = registro;
   totalRegistros++;
   
   //Guardar en archivo 
   guardarRegistroEnArchivo(registro);
   }
   
   // Mostrar bitacora 
   public static void mostrarBitacora(){
   if (totalRegistros == 0){
       System.out.println("La bitácora está vacía");
       return;
   }
   
       System.out.println("------ BITACORA -----");
       System.out.println("Total de registros: " + totalRegistros);
       System.out.println();
       
       for (int i=0; i<totalRegistros; i++){
           System.out.println((i+1) + "." + registros[i].toString());
       }
   }
     // Guardar un registro en archivo de bitacora 
private static void guardarRegistroEnArchivo(RegistroBitacora registro){
try{
FileWriter writer = new FileWriter(ARCHIVO_BITACORA, true);
PrintWriter printWriter = new PrintWriter(writer);
printWriter.println(registro.toFileString());
printWriter.close();
}catch (IOException e){
}
}

// Cargar registros de bitacora desde archivo 
public static void cargarBitacoraDesdeArchivo(){
try{
File archivo = new File (ARCHIVO_BITACORA);
if(!archivo.exists()){
return;
}

BufferedReader reader = new BufferedReader(new FileReader(archivo));
String linea;

while ((linea = reader.readLine())!= null && totalRegistros < CAPACIDAD_MAX){
String [] datos = linea.split(",");
if (datos.length == 5){
RegistroBitacora registro = new RegistroBitacora();
registro.setTipoAccion(datos[0]);
registro.setDescripcion(datos[1]);
registro.setExitosa(Boolean.parseBoolean(datos[2]));
registro.setUsuario(datos[3]);
registro.setFechaHora(datos[4]);

registros[totalRegistros]=registro;
totalRegistros++;
}
}
reader.close(); 


} catch (IOException e){

}
}

// Total de registros
public static int getTotalRegistros(){
return totalRegistros;
}






}



   
    
    
