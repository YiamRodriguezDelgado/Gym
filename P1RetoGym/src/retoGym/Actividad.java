/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package retoGym;

//Importacion de los paquetes que se requieren en esta clase
import java.time.LocalDate;
import modelo.Empleado;

/**
 *
 * @author Yiam Rodriguez
 */
public class Actividad {
    //Atributos de la clase Actividades
    private LocalDate fecha;
    private String descripcion;
    private Empleado empleo;
    public Actividad(){
        
    }
    
    //Constructor de la clase Actividad
    public Actividad(LocalDate fecha, String descripcion, Empleado empleo) {
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.empleo = empleo;
    }

    //Metodos Getters&Setters
    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Empleado getEmpleo() {
        return empleo;
    }

    public void setEmpleo(Empleado empleo) {
        this.empleo = empleo;
    }

    //Metodo toString que nos ayudará a imprimir los datos que necesitemos
    @Override
    public String toString() {
        return "Actividad{" + "fecha=" + fecha + ", descripcion=" + descripcion + ", empleo=" + empleo + '}';
    }
    
}
