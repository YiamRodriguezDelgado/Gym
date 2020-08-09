/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

//Importacion de los paquetes que se requieren en esta clase
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.text.DateFormat;
import java.time.LocalDate;
import retoGym.RetoGym;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import retoGym.Actividad;
import retoGym.Cargo;
import retoGym.Categoria;
import retoGym.Reto;
/**
 *
 * @author Yiam Rodriguez-Karina Ortega-Darwin Borja
 */
/*Se crea la clase Empleado que tiene herencia de la clase Persona*/
public class Empleado extends Persona {
    //Atributos propios de la clase Empleado
    Cargo cargo;
   
    //Constructor sin ningun parametro
    public Empleado(){
    }
    //Constructor que recibe el cargo del Empleado y lo entrega al programador
    public Empleado(Cargo cargo) {
        this.cargo = cargo;
    }
    
    /*Constructor de la clase Empleado que recibe caracteristicas de la clase padre
    e incluye el atributo de la clase hija*/
    public Empleado(String id, User user, String nombre, String direccion, String telefono, String email,Cargo cargo ) {
        super(id, user, nombre, direccion, telefono, email);
        this.cargo = cargo;
    }
    
    //Metodo Get y Set del atributo de la clase Empleado
    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
    
    //Se crea el metodo buscar empleado el cual tiene como parametro el ID del empleado
    public Empleado buscarEmpleado(String id){
        //Se realiza un for each que revise la lista de empleados uno por uno.
        for(Empleado e: RetoGym.empleados){
            /*Si se llega a obtener el id igresado igual al id de una lista este entregará 
            a la variable temporal que obtendra nuestro ID*/
            if (e.getId().equals(id)){
                return e; //Retorno de la variable temporal
            }
        }
        return null;//Si no se llegase a encontrar el ID, se obtendrá un null
    }
    
    /*Metodo toString que nos ayudará a imprimir las caraccteristicas que deseamos, 
    es decir las que se encuentran en la clase padre y en la clase hija.*/
    @Override //Metodo Sobre escrito
    public String toString() {
        return "Empleado{" +super.toString()+ ", Cargo= " + cargo+'}';
    }
    
    /*registrarActividad recibe como parámetro el id de reto y el id de
     *usuario inscrito en reto para que cada empleado sea entrenador,
     *nutricionista o terapista registre la actividad que realiza el
     *cliente participante del reto.
     * @param String idReto 
     * @param String idUserInscrito
    */
    public void registrarActividad(){
        Scanner sn = new Scanner(System.in);
        Cliente cliente = null;
        Empleado e = new Empleado();
        Reto r = null;
        String actividad = null;
        LocalDate fechaActual = LocalDate.now();
        System.out.println("Ingrese el id de Reto: ");
        String idReto = sn.nextLine();
        if (r.buscarReto(idReto)!=null){
             System.out.println("Ingrese el id de Usuario inscrito: ");
             String idUserInscrito = sn.nextLine();
             for(Categoria c: (r.getCategorias())){
                 if (c.buscarInscrito(idUserInscrito)!=null)   {       
                    System.out.println("Ingrese el detalle de la Actividad realizada:");
                    actividad = sn.nextLine();
                 }else{
                     System.out.println("El id de usuario no existe o está incorrecto!");
                     registrarActividad();
                 }
             }
        }else{
            System.out.println("El id de reto no existe o está incorrecto!");
            registrarActividad();
        }
        Actividad act = new Actividad(fechaActual,actividad,e);
        cliente.getActividades().add(act);  
    }
    
    
}
