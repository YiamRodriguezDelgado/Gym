/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leerArchivos;

//Importamos cada una de las clases de los diferentes paquetes que se van a usar
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import modelo.User;

/**
 *
 * @author darwi
 */

//Creamos la clase que nos ayudará a Leer los archivos en donde se encuentran los usuarios
public class LectArchivoUsuarios {
     public static ArrayList<User> usuarios(){
        ArrayList<User> listaUsuarios= new ArrayList();
        
        //Ingresamos la direccion de donde se encuentra nuestro archivo
        String DocClientes= "src\\archivos\\usuarios-1.csv";
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
                    //Guardamos los datos en nuestra lista
                    User usuario = new User(datos[0],datos[1],datos[2]);
                    //Añadimos los datos anteriores en el Array
                    listaUsuarios.add(usuario);
                }
                contador++;
            }
        //En caso de algun error recibido se realizará aquello
        }catch(FileNotFoundException e){
        }catch (IOException e){
        }finally{
            if (list1!=null){
                try{
                    list1.close(); //Se cierra la lista
                }catch(IOException e){
                }
                
            }
                
        }
        return listaUsuarios;   
    }
     
//     Main realizado para probar el resultado que se obtiene del proceso
//     Se obtendrá la lista de usuarios ingresados en el .cvs
        public static void main (String [] Args) {

        ArrayList<User> listaUsuarios = usuarios();
        for (User p:listaUsuarios){
            System.out.println(p);
        }
//        ejemplo para escribir un archivo nuevo a partir de un arraylist
    }
}
