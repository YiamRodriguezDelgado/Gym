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
import java.time.format.DateTimeFormatter;
import retoGym.RetoGym;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import retoGym.Actividad;
import retoGym.Cargo;
import retoGym.Categoria;
import retoGym.Ficha;
import retoGym.Reto;
import retoGym.TipoCategoria;
import static retoGym.TipoCategoria.FatBurn;
import static retoGym.TipoCategoria.HiperGain;
import static retoGym.TipoCategoria.MuscleAgain;
import static retoGym.TipoCategoria.SugarFree;
/**
 *
 * @author Yiam Rodriguez-Karina Ortega-Darwin Borja
 * Se crea la clase Empleado que tiene herencia de la clase Persona
*/
public class Empleado extends Persona {
    //Atributos propios de la clase Empleado
    Cargo cargo;
   
    //Constructor sin ningun parámetro
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
    /**
     * Método que retorna un Empleado de la lista de empleados.
     * @param id es el identificador de cada empleado con el
     * cual realiza la busca en la lista de empleados.
     */
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
    
    
    /**
     * Metodo toString que nos ayudará a imprimir las características que deseamos
     * de la clase Empleado, es decir las que se encuentran en la clase padre y en
     * la clase hija.
     */
    @Override //Metodo Sobreescrito
    public String toString() {
        return "Empleado{" +super.toString()+ ", Cargo= " + cargo+'}';
    }
     /**
      * Método registrarActividad ingresa la actividad que realiza el cliente
      * inscrito en el reto.
      * Guarda la fecha actual, la actividad realizada y el empleado(nutricionista
      * terapista o entrenador) que registra dicha actividad en una lista de 
      * actividades.
      */
   
    public void registrarActividad(String idReto, String idUsuario, String userEmpleado){
       Reto reto= new Reto();
       Categoria cat= new Categoria();
       Scanner sc= new Scanner(System.in);
        Reto r=reto.buscarReto(idReto);
        boolean bandera=false;
        Empleado e=null;
        for(Empleado e1:r.getEmpleados()){
            if(e1.getUser().getUsuario().equals(userEmpleado)){
                bandera=true;
                e=e1;
            }
        }
        if(bandera==true){
           
            
            System.out.println("Ingrese una descripcion");
            String d= sc.nextLine();
            
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedLocalDate = localDate.format(formatter);
        
        
        LocalDate f = LocalDate.parse(localDate.format(formatter), formatter);
           
           
         
        cat.buscarInscritoReto(idReto, idUsuario).getActividades().add(new Actividad(f,d,e));
          
         
           
            
        }
        else{
            System.out.println("Uste no es un empleado inscrito en el reto");
        }
    }
    /**
      * Método ingresarFichaInicial ingresa los datos de la ficha inicial que tiene el 
      * cliente inscrito en la etapa inicial del reto.
      * Los datos se almacenan en la ficha inicial de cada cliente inscrito.
      */
     public void ingresarFichaInicial(String UserEmpleado){
                Reto reto = new Reto();
                
                Ficha ficha= new Ficha();
                
               
                Categoria cat = new Categoria();
                Scanner sc = new Scanner(System.in);
                
                System.out.println("Ingrese id del Reto");
                  
                 String idReto= sc.nextLine();
                 Reto r=reto.buscarReto(idReto);
            if (ficha.dispFichaInicial(r)==true) {

             boolean bandera = false;
             Empleado e = null;
             for (Empleado e1 : r.getEmpleados()) {
                 if (e1.getUser().getUsuario().equals(UserEmpleado)) {
                     bandera = true;
                     e = e1;
                 }
             }
             System.out.println("Ingrese id del Usuario inscrito en el reto");

             String idUsuario = sc.nextLine();
             while (cat.buscarInscritoReto(idReto, idUsuario) == null) {
                 System.out.println("El usuario no esta inscrito en el reto");
                 System.out.println("Ingrese el id del Usuario inscrito en el reto");
                 idUsuario = sc.nextLine();

             }
             
             Cliente usuario= cat.buscarInscritoReto(idReto, idUsuario);
             
//                System.out.println(usuario.getFichaInicial()==null);
//                System.out.println(cat.buscarTipoCategoria(idUsuario));
//                System.out.println(cat.buscarTipoCategoria(idUsuario).equals(TipoCategoria.HiperGain));
//                System.out.println(usuario);
//                System.out.println(ficha.dispFichaInicial(r));
                
                
             if(usuario.getFichaInicial()==null&& (cat.buscarTipoCategoria(idUsuario).equals(TipoCategoria.FatBurn)||cat.buscarTipoCategoria(idUsuario).equals(TipoCategoria.MuscleAgain))){
                usuario.setFichaInicial(new Ficha("No registra datos","No registra datos","No registra datos","No registra datos","No registra datos","No registra datos","No registra datos","No registra datos"));
                
             }
             if(usuario.getFichaInicial()==null&& (cat.buscarTipoCategoria(idUsuario).equals(TipoCategoria.SugarFree)||cat.buscarTipoCategoria(idUsuario).equals(TipoCategoria.HiperGain))){
                 usuario.setFichaInicial(new Ficha("No registra datos","No registra datos","No registra datos","No registra datos","No registra datos","No registra datos","No registra datos","No registra datos","No registra datos","No registra datos"));
                  
             } 
             if(cat.buscarTipoCategoria(idUsuario).equals(TipoCategoria.FatBurn)||cat.buscarTipoCategoria(idUsuario).equals(TipoCategoria.MuscleAgain)){
                 if (bandera == true && e.getCargo().equals(Cargo.Nutricionista)) {
                     System.out.println("Ingrese el indice de masa corporal:");
                      String f1=sc.nextLine();
                     usuario.getFichaInicial().setI_MasaCorporal(f1);
                     System.out.println("Ingrese el indice de masa muscular:");
                      String f2=sc.nextLine();
                     usuario.getFichaInicial().setI_MasaMuscular(f2);
                     System.out.println("Ingrese el indice de grasa corporal");
                      String f3=sc.nextLine();
                     usuario.getFichaInicial().setI_GrasaCorporal(f3);
                     System.out.println("Ingrese las medidas antropometricas:");
                      String f4=sc.nextLine();
                     usuario.getFichaInicial().setMedidasAntro(f4);

                 }

                 if (bandera == true && e.getCargo().equals(Cargo.Terapista)) {
                     System.out.println("Ingrese los datos del Test de Burpee");
                     String f5=sc.nextLine();
                     usuario.getFichaInicial().setTestBurpee(f5);
                     System.out.println("Ingrese la frecuencia cardiaca en reposo ");
                     String f6=sc.nextLine();
                     usuario.getFichaInicial().setFrecuenciaCardiaca(f6);
                 }
                 if (bandera == true && e.getCargo().equals(Cargo.Entrenador)) {
                     System.out.println("Ingrese las maximas sentadillas en un minuto");
                      String f7=sc.nextLine();
                     usuario.getFichaInicial().setMaxSentadilla(f7);
                     System.out.println("Ingrese la flexibilidad:");
                     String f8=sc.nextLine();
                     usuario.getFichaInicial().setFlexibilidad(f8);
                 }

              
             }
             if(cat.buscarTipoCategoria(idUsuario).equals(TipoCategoria.SugarFree)||cat.buscarTipoCategoria(idUsuario).equals(TipoCategoria.HiperGain)){ 
              
                  if (bandera == true && e.getCargo().equals(Cargo.Nutricionista)) {
                     System.out.println("Ingrese el indice de masa corporal:");
                     String f1=sc.nextLine();
                     usuario.getFichaInicial().setI_GrasaCorporal(f1);
                     System.out.println("Ingrese el indice de masa muscular:");
                     String f2=sc.nextLine();
                       usuario.getFichaInicial().setI_MasaMuscular(f2);
                     System.out.println("Ingrese el indice de grasa corporal");
                     String f3=sc.nextLine();
                     usuario.getFichaInicial().setI_GrasaCorporal(f3);
                     System.out.println("Ingrese las medidas antropometricas:");
                     String f4=sc.nextLine();
                     usuario.getFichaInicial().setMedidasAntro(f4);
                 }

                 if (bandera == true && e.getCargo().equals(Cargo.Terapista)) {
                     
                     System.out.println("Ingrese la frecuencia cardiaca en reposo:");
                     String f5=sc.nextLine();
                     usuario.getFichaInicial().setFrecuenciaCardiaca(f5);
                     System.out.println("Ingrese la presion arterial:");
                     String f6=sc.nextLine();
                     usuario.getFichaInicial().setPresionArterial(f6);
                     System.out.println("Ingrese el perfil lipidico");
                     String f7=sc.nextLine();
                     usuario.getFichaInicial().setPerfilLipidico(f7);
                 }
                 if (bandera == true && e.getCargo().equals(Cargo.Entrenador)) {
                     System.out.println("Ingrese las maximas sentadillas en un minuto");
                     String f8=sc.nextLine();
                     usuario.getFichaInicial().setMaxSentadilla(f8);
                     System.out.println("Ingrese la flexibilidad:");
                     String f9=sc.nextLine();
                     usuario.getFichaInicial().setFlexibilidad(f9);
                     System.out.println("Ingrese los datos del trote en 5 min:");
                     String f10=sc.nextLine();
                     usuario.getFichaInicial().setTrote(f10);
                 }
                 if(bandera==false){
                      System.out.println("Uste no es un empleado inscrito en el reto");
                 }
                 
             }  
             
             
         }else{
                System.out.println("EL reto no esta dispnible para ingresar ficha inicial");
            }


                
                  
                  
                  
                  
//                  

    }
     /**
      * Método ingresarFichaFinal ingresa los datos de la ficha final que tiene el 
      * cliente inscrito en la etapa final del reto.
      * Los datos se almacenan en la ficha final de cada cliente inscrito.
      */
   
    public void ingresarFichaFinal(String UserEmpleado){
                Reto reto = new Reto();
                
                Ficha ficha= new Ficha();
                
               
                Categoria cat = new Categoria();
                Scanner sc = new Scanner(System.in);
                
                System.out.println("Ingrese id del Reto");
                  
                 String idReto= sc.nextLine();
                 Reto r=reto.buscarReto(idReto);
            if (ficha.dispFichaFinal(r)) {

             boolean bandera = false;
             Empleado e = null;
             for (Empleado e1 : r.getEmpleados()) {
                 if (e1.getId().equals(UserEmpleado)) {
                     bandera = true;
                     e = e1;
                 }
             }
             System.out.println("Ingrese id del Usuario inscrito en el reto");

             String idUsuario = sc.nextLine();
             while (cat.buscarInscritoReto(idReto, idUsuario) == null) {
                 System.out.println("El usuario no esta inscrito en el reto");
                 System.out.println("Ingrese el id del Usuario inscrito en el reto");
                 idUsuario = sc.nextLine();

             }
             
             Cliente usuario= cat.buscarInscritoReto(idReto, idUsuario);
             
             
             
             if(usuario.getFichaFinal()==null&& cat.buscarTipoCategoria(idUsuario).equals(TipoCategoria.FatBurn)||cat.buscarTipoCategoria(idUsuario).equals(TipoCategoria.MuscleAgain)){
                usuario.setFichaFinal(new Ficha("No registra datos","No registra datos","No registra datos","No registra datos","No registra datos","No registra datos","No registra datos","No registra datos"));
                
             }
             if(usuario.getFichaFinal()==null&& cat.buscarTipoCategoria(idUsuario).equals(TipoCategoria.SugarFree)||cat.buscarTipoCategoria(idUsuario).equals(TipoCategoria.HiperGain)){
                 usuario.setFichaFinal(new Ficha("No registra datos","No registra datos","No registra datos","No registra datos","No registra datos","No registra datos","No registra datos","No registra datos","No registra datos","No registra datos"));
                  
             } 
             if(cat.buscarTipoCategoria(idUsuario).equals(TipoCategoria.FatBurn)||cat.buscarTipoCategoria(idUsuario).equals(TipoCategoria.MuscleAgain)){
                 if (bandera == true && e.getCargo().equals(Cargo.Nutricionista)) {
                     System.out.println("Ingrese el indice de masa corporal:");
                      String f1=sc.nextLine();
                     usuario.getFichaFinal().setI_MasaCorporal(f1);
                     System.out.println("Ingrese el indice de masa muscular:");
                      String f2=sc.nextLine();
                     usuario.getFichaFinal().setI_MasaMuscular(f2);
                     System.out.println("Ingrese el indice de grasa corporal");
                      String f3=sc.nextLine();
                     usuario.getFichaFinal().setI_GrasaCorporal(f3);
                     System.out.println("Ingrese las medidas antropometricas:");
                      String f4=sc.nextLine();
                     usuario.getFichaFinal().setMedidasAntro(f4);

                 }

                 if (bandera == true && e.getCargo().equals(Cargo.Terapista)) {
                     System.out.println("Ingrese los datos del Test de Burpee");
                     String f5=sc.nextLine();
                     usuario.getFichaFinal().setTestBurpee(f5);
                     System.out.println("Ingrese la frecuencia cardiaca en reposo ");
                     String f6=sc.nextLine();
                     usuario.getFichaFinal().setFrecuenciaCardiaca(f6);
                 }
                 if (bandera == true && e.getCargo().equals(Cargo.Entrenador)) {
                     System.out.println("Ingrese las maximas sentadillas en un minuto");
                      String f7=sc.nextLine();
                     usuario.getFichaFinal().setMaxSentadilla(f7);
                     System.out.println("Ingrese la flexibilidad:");
                     String f8=sc.nextLine();
                     usuario.getFichaFinal().setFlexibilidad(f8);
                 }

              
             }
             if(cat.buscarTipoCategoria(idUsuario).equals(TipoCategoria.SugarFree)||cat.buscarTipoCategoria(idUsuario).equals(TipoCategoria.HiperGain)){ 
              
                  if (bandera == true && e.getCargo().equals(Cargo.Nutricionista)) {
                     System.out.println("Ingrese el indice de masa corporal:");
                     String f1=sc.nextLine();
                     usuario.getFichaFinal().setI_GrasaCorporal(f1);
                     System.out.println("Ingrese el indice de masa muscular:");
                     String f2=sc.nextLine();
                       usuario.getFichaFinal().setI_MasaMuscular(f2);
                     System.out.println("Ingrese el indice de grasa corporal");
                     String f3=sc.nextLine();
                     usuario.getFichaFinal().setI_GrasaCorporal(f3);
                     System.out.println("Ingrese las medidas antropometricas:");
                     String f4=sc.nextLine();
                     usuario.getFichaFinal().setMedidasAntro(f4);
                 }

                 if (bandera == true && e.getCargo().equals(Cargo.Terapista)) {
                     
                     System.out.println("Ingrese la frecuencia cardiaca en reposo:");
                     String f5=sc.nextLine();
                     usuario.getFichaFinal().setFrecuenciaCardiaca(f5);
                     System.out.println("Ingrese la presion arterial:");
                     String f6=sc.nextLine();
                     usuario.getFichaFinal().setPresionArterial(f6);
                     System.out.println("Ingrese el perfil lipidico");
                     String f7=sc.nextLine();
                     usuario.getFichaFinal().setPerfilLipidico(f7);
                 }
                 if (bandera == true && e.getCargo().equals(Cargo.Entrenador)) {
                     System.out.println("Ingrese las maximas sentadillas en un minuto");
                     String f8=sc.nextLine();
                     usuario.getFichaFinal().setMaxSentadilla(f8);
                     System.out.println("Ingrese la flexibilidad:");
                     String f9=sc.nextLine();
                     usuario.getFichaFinal().setFlexibilidad(f9);
                     System.out.println("Ingrese los datos del trote en 5 min:");
                     String f10=sc.nextLine();
                     usuario.getFichaFinal().setTrote(f10);
                 }
                 if(bandera==false){
                      System.out.println("Uste no es un empleado inscrito en el reto");
                 }
                 
             }  
             
             
         }else{
                System.out.println("EL reto no esta dispnible para ingresar ficha Final");
            }

    }
    public void consultarActividad(String idUsuario){
        Reto reto= new Reto();
        Cliente cli= new Cliente();
        Cliente usuario=cli.BuscarCliente(idUsuario);
        
        if(usuario.getActividades().size()>0){
            for(Actividad a: usuario.getActividades()){
            System.out.println(a);
            }
          
        }
        else{
            System.out.println("El cliente no registra actividades");
        }
    }
}
