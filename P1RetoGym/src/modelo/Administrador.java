/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Yiam Rodriguez
 */

/*Creacion de la clase Administrador que proviene de la Herencia que se genera de 
la clase PERSONA por las caracteristicas semejantes que poseen*/
/*Se crea esta clase para mantener las diferencias que tiene un administrador y que 
lo diferencia de los otros*/
public class Administrador extends Persona {
 

    //Constructor vacio
    public Administrador() {
    }
    //Constructor heredado de la clase padre que posee los siguientes atributos
    public Administrador(String id, User user, String nombre, String direccion, String telefono, String email) {
        super(id, user, nombre, direccion, telefono, email);
    }

    
    /*Metodo ToString que nos ayudará a imprimir cada una de las caracteristicas que deseamos,
    que en este caso son aquellos de la clase PERSONA*/
    @Override
    public String toString() {
        return "Administrador{"+super.toString() + '}';
    }
    
}
