/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

//Importacion de los paquetes que se requieren en esta clase
import java.time.LocalDate;
import java.util.ArrayList;
import retoGym.Actividad;
import retoGym.Ficha;
import retoGym.RetoGym;

/**
 *
 * @author Yiam Rodriguez-Karina Ortega- Darwin Borja
 */
/*Se crea la clase Cliente que proviene de la clase persona por la herencia que 
estas poseen.*/
public class Cliente extends Persona{
    //Atributos que posee la clase Cliente
    private LocalDate fechaExpMembresia ;
    private Ficha ficha;
    private ArrayList<Actividad> actividades;//Arraylist de las actividades de los clientes
    
    //Constructor vacio de la clase Cliente
    public Cliente() {
        actividades = new ArrayList<>();
    }
    
    /*Constructtor que inicializa las variables tanto de la clase Padre como la de la 
    fecha de expedicion de membesia*/
     public Cliente(String id,String nombre, String direccion, String telefono, String email, LocalDate fechaExpMembresia ) {
        super(id, nombre, direccion, telefono, email);
        this.fechaExpMembresia = fechaExpMembresia;
        
    }
     /*Constructtor que inicializa las variables tanto de la clase Padre como la de la 
    fecha de expedicion de membesia, ficha e incluso actividades*/
    public Cliente(String id, User user, String nombre, String direccion, String telefono, String email, LocalDate fechaExpMembresia, Ficha ficha, ArrayList<Actividad> actividades ) {
        super(id, user, nombre, direccion, telefono, email);
        this.fechaExpMembresia = fechaExpMembresia;
        this.ficha = ficha;
        this.actividades = actividades;
    }

    //Metodos Getters&Setters de la clase Cliente
    public LocalDate getFechaExpMembresia() {
        return fechaExpMembresia;
    }

    public void setFechaExpMembresia(LocalDate fechaExpMembresia) {
        this.fechaExpMembresia = fechaExpMembresia;
    }

    public Ficha getFicha() {
        return ficha;
    }

    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
    }

    public ArrayList<Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(ArrayList<Actividad> actividades) {
        this.actividades = actividades;
    }
  
    /*Metodo toString que nos ayudará a imprimir las carateristcas de la clase padre
    e incluidas a algunas de la clase hija*/
    @Override
    public String toString() {
        return "Cliente{" +super.toString()+ ", fechaExpMembresia:" + fechaExpMembresia + ", ficha:" + ficha + ", actividades:" + actividades +'}';
    }

     public Cliente BuscarCliente(String id){
       for(Cliente r: RetoGym.clientes){
           if (r.getId().equals(id))
               return r;
       }
       return null;
   } 
    
    
    

    

    
}
