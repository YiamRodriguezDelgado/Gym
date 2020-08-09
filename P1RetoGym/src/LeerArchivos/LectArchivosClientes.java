
package leerArchivos;

import java.io.*;
import modelo.Cliente;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import modelo.User;
/**
 *
 * @author Darwin_Borja
 */
public class LectArchivosClientes {
    
    public static ArrayList<Cliente> Clientes(){
        ArrayList<Cliente> listaClientes= new ArrayList();
        
        //Ingresamos la direccion de donde se encuentra nuestro archivo
        String DocClientes= "src\\archivos\\clientes-1.csv";
        //Inicializamos el objeto de la clase que nos permitirá leer una linea completa de nuestro cvs
        BufferedReader list1 = null;
        String line =" ";
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
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
                    String date = datos[5];
                    //convert String to LocalDate
	            LocalDate localDate = LocalDate.parse(date, formatter);
                    
                    
                    Cliente cliente = new Cliente(datos[0],datos[1],datos[2],datos[3],datos[4],localDate);
                    listaClientes.add(cliente);
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
        return listaClientes;   
    }
    
    //Main realizado para probar el resultado que se obtiene del proceso
    //En este caso, ver la lista de Clientes leidos del .cvs
        /* public static void main (String [] Args) {

        ArrayList<Cliente> listaUsuarios = Clientes();
        for (Cliente p:listaUsuarios){
            System.out.println(p);
        }
        //ejemplo para escribir un archivo nuevo a partir de un arraylist


    }*/
       
}
    
   
        

    