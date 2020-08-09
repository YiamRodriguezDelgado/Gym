
package leerArchivos;


import static leerArchivos.LectArchivoUsuarios.usuarios;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import modelo.Empleado;
import modelo.User;
import retoGym.Cargo;

/**
 *
 * @author darwi
 */
public class LectArchivosEmpleados {
    
    public static ArrayList<Empleado> empleados(){
        ArrayList<Empleado> listaEmpleado= new ArrayList();
        ArrayList<User> usuarios = usuarios();
        
        
        //Ingresamos la direccion de donde se encuentra nuestro archivo
        String DocClientes= "src\\archivos\\empleados.csv";
        //Inicializamos el objeto de la clase que nos permitirá leer una linea completa de nuestro cvs
        BufferedReader list1 = null;
        String line ="";
        //Guardamos en una variable el caracter que nos ayudará a separar los diferentes datos
        String Separador = ",";
        //Inicializamos el contador que usaremos en mnuestro proceso ciclico
        int contador=0;
        
        try{
            //Creamos el objeto de la clase BufferedReader y FileReader
            list1 = new BufferedReader(new FileReader(DocClientes));
            boolean oc = true;
            while ((line=list1.readLine())!=null){
                //Usamos trim() para eliminar los caracteres del inicio y final de la linea de caracteres
                if (contador!=0 && !(line.trim().equals("")||line.trim().equals("\n"))){
                    //Separamos nuestros datos a partir de cada coma que encontremos
                    String[] datos =line.split(Separador);
                    
                    //Guardamos los datos en nuestro array
                    
                    
                    User user= new User();
                    for (User u : usuarios) {
                        if (u.getUsuario().equals(datos[6]));
                          user=u;
                       

                    }
                   
                        Cargo cargo= null;
                        if (datos[5].equalsIgnoreCase("terapista")) {
                            cargo = Cargo.Terapista;

                        }
                        if (datos[5].equalsIgnoreCase("nutricionista")) {
                            cargo = Cargo.Nutricionista;


                        }
                        if (datos[5].equalsIgnoreCase("entrenador")) {
                          cargo = Cargo.Entrenador;

                        }
                        if (datos[5].equalsIgnoreCase("administrador")) {
                           cargo = Cargo.Administrador;

                        }
                        
                    Empleado empleado = new Empleado(datos[0],user, datos[1],datos[2],datos[3],datos[4],cargo);
                    listaEmpleado.add(empleado);
                }
                contador++;
            }
        }catch(FileNotFoundException e){
        }catch (IOException e){
        }finally{
            if (list1!=null){
                try{
                    list1.close();
                }catch(IOException e){
                }
                
            }
                
        }
        return listaEmpleado;   
    }
    
    //Main realizado para probar el resultado que se obtiene del proceso
    //En este caso obsevaremos la lista de los Empleados del .cvs
       /*  public static void main (String [] Args) {
        ArrayList<Empleado> listaEmpleados = empleados();
        for (Empleado p:listaEmpleados){
            System.out.println(p);
        }
        
        }*/
        //ejemplo para escribir un archivo nuevo a partir de un arraylist

    
}
