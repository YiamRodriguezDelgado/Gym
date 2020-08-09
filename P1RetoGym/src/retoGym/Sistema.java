/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package retoGym;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import modelo.Cliente;
import modelo.Empleado;
import modelo.User;
import static retoGym.RetoGym.clientes;
import static retoGym.RetoGym.retos;

/**
 *
 * @author Yiam Rodriguez
 */
public class Sistema {
      
    public static void inicializarSistema(){
        
        
        //Reto inicial
        Categoria c= new Categoria();
        // Creacion de nuevo reto
         LocalDate f1 = LocalDate.parse("07/07/2019", DateTimeFormatter.ofPattern("dd/MM/yyyy"));        
         LocalDate f2 = LocalDate.parse("13/07/2019", DateTimeFormatter.ofPattern("dd/MM/yyyy"));     
         LocalDate f3 = LocalDate.parse("14/07/2019", DateTimeFormatter.ofPattern("dd/MM/yyyy"));   
         LocalDate f4 = LocalDate.parse("14/10/2019", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        
         Empleado empleado= new Empleado();
         ArrayList<Empleado> e1= new ArrayList<>();
         e1.add(empleado.buscarEmpleado("0923456789"));
         e1.add(empleado.buscarEmpleado("0923456799"));
         e1.add(empleado.buscarEmpleado("0923456788"));
         
         Actividad actividad= new Actividad(f1,"Tiene que trotar 5 minutos diarios",empleado.buscarEmpleado("0923456789"));
        
         
         
         Reto reto1=new Reto("1",10,f1,f2,f3,f4,e1);
//         System.out.println(reto1.getCategorias()+"hola");
         
         
        retos.add(reto1);
        
        User u= new User();
        Ficha ficha1= new Ficha("15-15.9", "18.5-24.9", "<3%", "22-75-34", "Capacidad Buena", "24", "Media", "70-84") ;
        Ficha ficha2= new Ficha("15-15.9", "18.5-24.9", "<3%", "22-75-34", "24", "Media", "70-84","<120","Colesrerol Total:120, LDL Colesterol: <100mg/dl, HDL colesterol: >50 mg/dl, Trigliceridos ","Aprobado");
       
        clientes.get(0).setUser(u.crearUsuario(clientes.get(0).getId()));        
//        clientes.get(0).setFichaInicial(ficha2);
        reto1.getCategorias().get(0).getInscritos().add(clientes.get(0));
       
        clientes.get(1).setUser(u.crearUsuario(clientes.get(1).getId()));
//        clientes.get(1).setFichaInicial(ficha2);
        reto1.getCategorias().get(0).getInscritos().add(clientes.get(1));
      
        
             
        clientes.get(2).setUser(u.crearUsuario(clientes.get(2).getId()));
//        clientes.get(2).setFichaInicial(ficha2);
        reto1.getCategorias().get(1).getInscritos().add(clientes.get(2));
        
        
        
        clientes.get(3).setUser(u.crearUsuario(clientes.get(3).getId()));
//        clientes.get(3).setFichaInicial(ficha2);
        reto1.getCategorias().get(1).getInscritos().add(clientes.get(3));
       
        
        clientes.get(4).setUser(u.crearUsuario(clientes.get(4).getId()));
//        clientes.get(4).setFichaInicial(ficha2);
        reto1.getCategorias().get(1).getInscritos().add(clientes.get(4));
        
        
               

       clientes.get(5).setUser(u.crearUsuario(clientes.get(5).getId()));
//        clientes.get(5).setFichaInicial(ficha1);
        reto1.getCategorias().get(2).getInscritos().add(clientes.get(5));
        
        
       clientes.get(6).setUser(u.crearUsuario(clientes.get(6).getId()));
//        clientes.get(6).setFichaInicial(ficha1);
        reto1.getCategorias().get(2).getInscritos().add(clientes.get(6));
        
       clientes.get(7).setUser(u.crearUsuario(clientes.get(7).getId()));
//        clientes.get(7).setFichaInicial(ficha1);
        reto1.getCategorias().get(3).getInscritos().add(clientes.get(7));
        
       clientes.get(8).setUser(u.crearUsuario(clientes.get(8).getId()));
//        clientes.get(8).setFichaInicial(ficha1);
        reto1.getCategorias().get(3).getInscritos().add(clientes.get(8));
       
       
        
        
        
        //Reto en etapa de ejecucion
        
        // Creacion de nuevo reto
         LocalDate f11 = LocalDate.parse("01/07/2019", DateTimeFormatter.ofPattern("dd/MM/yyyy"));        
         LocalDate f22 = LocalDate.parse("06/07/2019", DateTimeFormatter.ofPattern("dd/MM/yyyy"));     
         LocalDate f33 = LocalDate.parse("07/07/2019", DateTimeFormatter.ofPattern("dd/MM/yyyy"));   
         LocalDate f44 = LocalDate.parse("07/10/2019", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        
        
        
         
         
        
         
         
         Reto reto2=new Reto("2",10,f11,f22,f33,f44,e1);
//         System.out.println(reto1.getCategorias()+"hola");
         
         
        retos.add(reto2);
        
        
        clientes.get(9).setUser(u.crearUsuario(clientes.get(9).getId()));        
        clientes.get(9).setFichaInicial(ficha2);
        reto2.getCategorias().get(0).getInscritos().add(clientes.get(9));
       
        clientes.get(10).setUser(u.crearUsuario(clientes.get(10).getId()));
        clientes.get(10).setFichaInicial(ficha2);
        reto2.getCategorias().get(0).getInscritos().add(clientes.get(10));
        
//        clientes.get(2).setUser(u.crearUsuario(clientes.get(2).getId()));
//        clientes.get(2).setFichaInicial(ficha2);
//        reto2.getCategorias().get(0).getInscritos().add(clientes.get(2));
        
             
        clientes.get(11).setUser(u.crearUsuario(clientes.get(11).getId()));
        clientes.get(11).setFichaInicial(ficha2);
        reto2.getCategorias().get(1).getInscritos().add(clientes.get(11));
        
        
        
        clientes.get(12).setUser(u.crearUsuario(clientes.get(12).getId()));
        clientes.get(12).setFichaInicial(ficha2);
        reto2.getCategorias().get(1).getInscritos().add(clientes.get(12));
       
        
//        clientes.get(5).setUser(u.crearUsuario(clientes.get(5).getId()));
//        clientes.get(5).setFichaInicial(ficha2);
//        reto2.getCategorias().get(1).getInscritos().add(clientes.get(5));
//        
        clientes.get(13).setUser(u.crearUsuario(clientes.get(13).getId()));
        clientes.get(13).setFichaInicial(ficha1);
        reto2.getCategorias().get(2).getInscritos().add(clientes.get(13));
               

       clientes.get(14).setUser(u.crearUsuario(clientes.get(14).getId()));
        clientes.get(14).setFichaInicial(ficha1);
        reto2.getCategorias().get(2).getInscritos().add(clientes.get(14));
        
        
//       clientes.get(8).setUser(u.crearUsuario(clientes.get(8).getId()));
//        clientes.get(8).setFichaInicial(ficha1);
//        reto2.getCategorias().get(2).getInscritos().add(clientes.get(8));
        
       clientes.get(15).setUser(u.crearUsuario(clientes.get(15).getId()));
        clientes.get(15).setFichaInicial(ficha1);
        reto2.getCategorias().get(3).getInscritos().add(clientes.get(15));
       
        clientes.get(16).setUser(u.crearUsuario(clientes.get(16).getId()));
        clientes.get(16).setFichaInicial(ficha1);
        reto2.getCategorias().get(3).getInscritos().add(clientes.get(16));
        
//       clientes.get(11).setUser(u.crearUsuario(clientes.get(11).getId()));
//       clientes.get(11).setFichaInicial(ficha1);
//       reto2.getCategorias().get(3).getInscritos().add(clientes.get(11));
//       
        
         LocalDate f111 = LocalDate.parse("27/03/2019", DateTimeFormatter.ofPattern("dd/MM/yyyy"));        
         LocalDate f222 = LocalDate.parse("02/04/2019", DateTimeFormatter.ofPattern("dd/MM/yyyy"));     
         LocalDate f333 = LocalDate.parse("03/04/2019", DateTimeFormatter.ofPattern("dd/MM/yyyy"));   
         LocalDate f444 = LocalDate.parse("03/07/2019", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        
        
        //Reto final
         Reto reto3=new Reto("3",10,f111,f222,f333,f444,e1);
//         System.out.println(reto1.getCategorias()+"hola");
         
         
        retos.add(reto3);
        
        
        clientes.get(17).setUser(u.crearUsuario(clientes.get(17).getId()));        
        clientes.get(17).setFichaInicial(ficha2);
        clientes.get(17).setFichaFinal(ficha2);
        clientes.get(17).getActividades().add(actividad);
        reto3.getCategorias().get(0).getInscritos().add(clientes.get(17));
       
        clientes.get(18).setUser(u.crearUsuario(clientes.get(18).getId()));
        clientes.get(18).setFichaInicial(ficha2);
        clientes.get(18).setFichaFinal(ficha2);
        clientes.get(18).getActividades().add(actividad);
        reto3.getCategorias().get(0).getInscritos().add(clientes.get(18));
        
        clientes.get(19).setUser(u.crearUsuario(clientes.get(19).getId()));
        clientes.get(19).setFichaInicial(ficha2);
        clientes.get(19).setFichaFinal(ficha2);
        clientes.get(19).getActividades().add(actividad);
        reto3.getCategorias().get(0).getInscritos().add(clientes.get(19));
        
             
        clientes.get(20).setUser(u.crearUsuario(clientes.get(20).getId()));
        clientes.get(20).setFichaInicial(ficha2);
        clientes.get(20).setFichaFinal(ficha2);
        clientes.get(20).getActividades().add(actividad);
        reto3.getCategorias().get(1).getInscritos().add(clientes.get(20));
        
        
        
        clientes.get(21).setUser(u.crearUsuario(clientes.get(21).getId()));
        clientes.get(21).setFichaInicial(ficha2);
        clientes.get(21).setFichaFinal(ficha2);
        clientes.get(21).getActividades().add(actividad);
        reto3.getCategorias().get(1).getInscritos().add(clientes.get(21));
       
        
        clientes.get(22).setUser(u.crearUsuario(clientes.get(22).getId()));
        clientes.get(22).setFichaInicial(ficha2);
        clientes.get(22).setFichaFinal(ficha2);
        clientes.get(22).getActividades().add(actividad);
        reto3.getCategorias().get(1).getInscritos().add(clientes.get(22));
        
        clientes.get(23).setUser(u.crearUsuario(clientes.get(23).getId()));
        clientes.get(23).setFichaInicial(ficha1);
        clientes.get(23).setFichaFinal(ficha1);
        clientes.get(23).getActividades().add(actividad);
        reto3.getCategorias().get(2).getInscritos().add(clientes.get(23));
               

       clientes.get(24).setUser(u.crearUsuario(clientes.get(24).getId()));
        clientes.get(24).setFichaInicial(ficha1);
        clientes.get(24).setFichaFinal(ficha1);
        clientes.get(24).getActividades().add(actividad);
        reto3.getCategorias().get(2).getInscritos().add(clientes.get(24));
        
        
        clientes.get(25).setUser(u.crearUsuario(clientes.get(25).getId()));
        clientes.get(25).setFichaInicial(ficha1);
        clientes.get(25).setFichaFinal(ficha1);
        clientes.get(25).getActividades().add(actividad);
        reto3.getCategorias().get(2).getInscritos().add(clientes.get(25));
        
       clientes.get(26).setUser(u.crearUsuario(clientes.get(26).getId()));
        clientes.get(26).setFichaInicial(ficha1);
        clientes.get(26).setFichaFinal(ficha1); 
        clientes.get(26).getActividades().add(actividad);
        reto3.getCategorias().get(3).getInscritos().add(clientes.get(26));
        
       clientes.get(27).setUser(u.crearUsuario(clientes.get(27).getId()));
        clientes.get(27).setFichaInicial(ficha1);
        clientes.get(27).setFichaFinal(ficha1);
        clientes.get(27).getActividades().add(actividad);
        reto3.getCategorias().get(3).getInscritos().add(clientes.get(27));
        
       clientes.get(28).setUser(u.crearUsuario(clientes.get(28).getId()));
       clientes.get(28).setFichaInicial(ficha1);
       clientes.get(28).setFichaFinal(ficha1);
       clientes.get(28).getActividades().add(actividad);
       reto3.getCategorias().get(3).getInscritos().add(clientes.get(28));
       
        
  
        
//        retos.get(2).getCategorias().get(0).setGanador(retos.get(2).getCategorias().get(0).getInscritos().get(0));
//        retos.get(2).getCategorias().get(1).setGanador(retos.get(2).getCategorias().get(1).getInscritos().get(1));
//        retos.get(2).getCategorias().get(2).setGanador(retos.get(2).getCategorias().get(2).getInscritos().get(1));
//        retos.get(2).getCategorias().get(3).setGanador(retos.get(2).getCategorias().get(3).getInscritos().get(1));
//            
        
    }
    
}
