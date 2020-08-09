/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package retoGym;

//Importacion a la clase de los paquetes que se necesitan
import retoGym.RetoGym;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import modelo.Empleado;
import java.util.Scanner;
import modelo.Cliente;
import retoGym.Categoria;



/**
 *
 * @author Yiam Rodriguez-Karina Ortega-Darwin Borja
 */
public class Reto {
    //Atributos de la clase reto
    private String idReto;
    private int duracion;
    private LocalDate fechaInicio_Incsrip;
    private LocalDate fechaCierre_Inscrip;
    private LocalDate fechaInicio_Reto;
    private LocalDate fechaCierre_Reto;
    public ArrayList<Categoria> categorias;
    private ArrayList<Empleado> empleados;
  
    //Constructores de la clase reto
    public Reto(){
        empleados= new ArrayList<>();
        categorias= new ArrayList<>();
    }
    public Reto(String idReto, int duracion,LocalDate fechaInicio_Incsrip, LocalDate fechaCierre_Inscrip, LocalDate fechaInicio_Reto, LocalDate fechaCierre_Reto, ArrayList<Empleado> empleados) {
        
        categorias= new ArrayList<>();
        
        this.idReto = idReto;
        this.duracion = duracion;
        this.fechaInicio_Incsrip=fechaInicio_Incsrip ;
        this.fechaCierre_Inscrip = fechaCierre_Inscrip;
        this.fechaInicio_Reto = fechaInicio_Reto;
        this.fechaCierre_Reto = fechaCierre_Reto;
        this.empleados = empleados;
        ingresarCategorias();
    }
    
    
//    public Reto(String idReto, int duracion,LocalDate fechaInicio_Incsrip, LocalDate fechaCierre_Inscrip, LocalDate fechaInicio_Reto, LocalDate fechaCierre_Reto, ArrayList<Categoria> categorias, ArrayList<Empleado> empleados) {
//        this.idReto = idReto;
//        this.duracion = duracion;
//        this.fechaInicio_Incsrip=fechaInicio_Incsrip ;
//        this.fechaCierre_Inscrip = fechaCierre_Inscrip;
//        this.fechaInicio_Reto = fechaInicio_Reto;
//        this.fechaCierre_Reto = fechaCierre_Reto;
//        this.categorias = categorias;
//        this.empleados = empleados;
//    }
//    public Reto(String idReto, int duracion,LocalDate fechaInicio_Incsrip, LocalDate fechaCierre_Inscrip, LocalDate fechaInicio_Reto, LocalDate fechaCierre_Reto, ArrayList<Empleado> empleados) {
//        this.idReto = idReto;
//        this.duracion = duracion;
//        this.fechaInicio_Incsrip=fechaInicio_Incsrip ;
//        this.fechaCierre_Inscrip = fechaCierre_Inscrip;
//        this.fechaInicio_Reto = fechaInicio_Reto;
//        this.fechaCierre_Reto = fechaCierre_Reto;
//        this.empleados = empleados;
//    }
//    
    //Metodos Getters&Setters de la clase Reto
    public String getIdReto() {
        return idReto;
    }

    public void setIdReto(String idReto) {
        this.idReto = idReto;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public LocalDate getFechaInicio_Incsrip() {
        return fechaInicio_Incsrip;
    }

    public void setFechaInicio_Incsrip(LocalDate fechaInicio_Incsrip) {
        this.fechaInicio_Incsrip = fechaInicio_Incsrip;
    }

    public LocalDate getFechaCierre_Inscrip() {
        return fechaCierre_Inscrip;
    }

    public void setFechaCierre_Inscrip(LocalDate fechaCierre_Inscrip) {
        this.fechaCierre_Inscrip = fechaCierre_Inscrip;
    }

    public LocalDate getFechaInicio_Reto() {
        return fechaInicio_Reto;
    }

    public void setFechaInicio_Reto(LocalDate fechaInicio_Reto) {
        this.fechaInicio_Reto = fechaInicio_Reto;
    }

    public LocalDate getFechaCierre_Reto() {
        return fechaCierre_Reto;
    }

    public void setFechaCierre_Reto(LocalDate fechaCierre_Reto) {
        this.fechaCierre_Reto = fechaCierre_Reto;
    }

    public ArrayList<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(ArrayList<Categoria> categorias) {
        this.categorias = categorias;
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }

    @Override
    public String toString() {
        return "Reto{" + "idReto=" + idReto + ", duracion=" + duracion + ", fechaInicio_Incsrip=" + fechaInicio_Incsrip + ", fechaCierre_Inscrip=" + fechaCierre_Inscrip + ", fechaInicio_Reto=" + fechaInicio_Reto + ", fechaCierre_Reto=" + fechaCierre_Reto + ", categorias=" + categorias + ", empleados=" + empleados + ", sn=" + sn + ", e=" + e + '}';
    }
    
    
    //Comenzamos a realizar los metodos 
     Scanner sn= new Scanner(System.in);
     Empleado e= new Empleado();
     
    /*Creamos el metodo Crear Reto, el cual sera una opcion
     que tendra el administrador del gym para crear un reto 
     y definir cada una de las caracteristicas que este va 
     a poseer, tales como fecha de inicio y cierre de inscripciones,
     id del reto, entre otras cosas. Todo esto ser guardado 
     en una lista.*/
    public void crearReto(){
        //Pedimos al usuario ADMIN que ingrese los datos que se necesitan del reto y se lo 
        //guarda en un variable
         System.out.println("Ingrese la fecha de inicio de inscripciones (dd/mm/aaaa): ");
         String fecha1= sn.nextLine();
         LocalDate f1 = LocalDate.parse(fecha1, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
         System.out.println("Ingrese la fecha de cierre de inscripciones (dd/mm/aaaa): ");
         String fecha2= sn.nextLine();
         LocalDate f2 = LocalDate.parse(fecha2, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
         System.out.println("Ingrese la fecha de inicio del reto (dd/mm/aaaa): ");
         String fecha3= sn.nextLine();
         LocalDate f3 = LocalDate.parse(fecha3, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
         System.out.println("Ingrese la fecha de cierre del reto (dd/mm/aaaa): ");
         String fecha4= sn.nextLine();
         LocalDate f4 = LocalDate.parse(fecha4, DateTimeFormatter.ofPattern("dd/MM/yyyy"));   
         String id="";
         //Se pedirá el Id del terapista hasta que se encuentre entre los empleados
         do{
             System.out.println("Ingrese un ID del terapista fisico: ");
             id= sn.nextLine();
         }while(!e.buscarEmpleado(id).getCargo().equals(Cargo.Terapista));
         sn.nextLine();
         String id1="";
         do{
         System.out.println("Ingrese ID del nutricionista: "); 
         id1= sn.nextLine(); 
         //Se pedirá el Id del nutricionista hasta que se encuentre entre los empleados
         }while (!e.buscarEmpleado(id1).getCargo().equals(Cargo.Nutricionista));
         sn.nextLine();
         String id2="";
         do{    
         System.out.println("Ingrese ID del entrenador: ");
               id2= sn.nextLine();
         //Se pedirá el Id del entrenador hasta que se encuentre entre los empleados
         }while(!e.buscarEmpleado(id2).getCargo().equals(Cargo.Entrenador));
         sn.nextLine();
         //Se crea el nuevo ID del reto
         String idreto = Integer.toString((RetoGym.retos.size()+1));
         //Se añaden los ID de los empleados que van a trabajar en el reto
         empleados.add(e.buscarEmpleado(id));
         empleados.add(e.buscarEmpleado(id1));
         empleados.add(e.buscarEmpleado(id2));
         //Se añaden todos los datos del nuevo reto a la lista reto
         RetoGym.retos.add(new Reto(idreto, 10, f1, f2, f3, f4,empleados)); 
         System.out.println(buscarReto(idreto).toString());
        }
        
        //Metodo que nos ayudará a buscar reto a partir de su ID
        public Reto buscarReto(String i){
            for(Reto r: RetoGym.retos){
                if(r.getIdReto().equals(i)){
                    return r;
                }    
            }  
            return null;
        }
        
        public void ingresarCategorias(){
             int count=0;
             TipoCategoria[] tipo=TipoCategoria.values();
                while(count<4){
                    categorias.add(new Categoria(tipo[count]));
                    count++;
                }
        }
        
        
    public void consultarFicha(String idCliente){
        
        for (Reto r: RetoGym.retos){
            for( Categoria c: r.getCategorias()){
                for( Cliente c1: c.getInscritos()){
                    if( c1.getId().equals(idCliente))
                        
                        System.out.println("Ha consultado la ficha del cliente "+ c1.getNombre() +", inscrito en la categoria :"+ c.getCategoria().toString());
                       if(c1.getActividades()!=null)
                        for(Actividad a: c1.getActividades()){
                            System.out.println(a);
                        
                        }
                       else{
                           System.out.println("El cliente no registra actividades");
                       }
                       if(c1.getFicha()!=null) {
                           System.out.println(c1.getFicha());
                       }
                       else{
                           System.out.println("El cliente no registra ficha");
                       }
                }
            }
            
        }
        
    }
    public void consultarInscritos(){
        System.out.println("Ingrese id del reto");
        String idReto= sn.nextLine();
        for (Reto r: RetoGym.retos){
            if (r.getIdReto().equals(idReto)){
                System.out.println("El reto "+ r.getIdReto()+",de duracion "+r.getDuracion());
                System.out.println("La fecha de inicio de Incripciones es: "+r.fechaInicio_Incsrip);
                System.out.println("La fecha de cierre de inscripciones es: "+r.fechaCierre_Inscrip);
                System.out.println("La fecha de inicio del reto es: "+r.fechaInicio_Reto);
                System.out.println("La fecha de del cierre del reto es: "+r.fechaCierre_Reto);
                for(Categoria ct:r.categorias){
                    System.out.println(ct.getCategoria());
                    System.out.println(ct.getInscritos());
                    
                }
            }
        }
    }
    public void registrarGanador(String idReto) {
        boolean salir= false;
        Reto r1=buscarReto(idReto);
        if( r1!=null){
        TipoCategoria cat = null;
        int opcion;
        boolean gospel = false;
           do{  
            try {
                System.out.println("1.- HiperGain ");
                System.out.println("2.- SugarFree");
                System.out.println("3.- FatBurn");
                System.out.println("4.- MuscleAgain");
                System.out.print("Ingrese la categoría: ");
                opcion = sn.nextInt();
                sn.nextLine();
                switch (opcion) {
                    case 1:
                        cat = TipoCategoria.HiperGain;
                        System.out.println("Ingrese el id del ganador");
                        String idGanador1= sn.nextLine();
                        if(r1.getCategorias().get(0).buscarInscrito(idGanador1)!=null){
                            r1.getCategorias().get(0).setGanador(r1.getCategorias().get(0).buscarInscrito(idGanador1));   
                        }
                        else{
                            System.out.println("El usuario no esta inscrito en esta categoria");
                        }
                        System.out.println("Desea seguir ingresando ganador en las siguientes categorias  Si/No");
                        if(sn.nextLine().equals("No")){
                            salir=true;
                        }
                        break;
                    case 2:
                        cat = TipoCategoria.SugarFree;
                        System.out.println("Ingrese el id del ganador");
                        String idGanador2= sn.nextLine();
                        if(r1.getCategorias().get(1).buscarInscrito(idGanador2)!=null){
                            r1.getCategorias().get(1).setGanador(r1.getCategorias().get(1).buscarInscrito(idGanador2)); 
                        }
                        else{
                            System.out.println("El usuario no esta inscrito en esta categoria");
                        }
                        System.out.println("Desea seguir ingresando ganador en las siguientes categorias  Si/No");
                        if(sn.nextLine().equals("No")){
                            salir=true;
                        }
                        break;
                    case 3:
                        cat = TipoCategoria.FatBurn;
                        String idGanador3= sn.nextLine();
                        if(r1.getCategorias().get(2).buscarInscrito(idGanador3)!=null){
                            r1.getCategorias().get(2).setGanador(r1.getCategorias().get(2).buscarInscrito(idGanador3));  
                        }
                        else{
                            System.out.println("El usuario no esta inscrito en esta categoria");
                        }
                        System.out.println("Desea seguir ingresando ganador en las siguientes categorias  Si/No");
                        if(sn.nextLine().equals("No")){
                            salir=true;
                        }
                        break;
                    case 4:
                        cat = TipoCategoria.MuscleAgain;
                       
                         String idGanador4= sn.nextLine();
                        if(r1.getCategorias().get(3).buscarInscrito(idGanador4)!=null){
                            r1.getCategorias().get(3).setGanador(r1.getCategorias().get(3).buscarInscrito(idGanador4));  
                        }else{
                            System.out.println("El usuario no esta inscrito en esta categoria");
                        }
                        System.out.println("Desea seguir ingresando ganador en las siguientes categorias  Si/No");
                        if(sn.nextLine().equals("No")){
                            salir=true;
                        }
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 4\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número\n");
                sn.next();//Se limpia el objeto sn de la clase Scanner
            } 
        } while(!salir);
        }
        else{
            System.out.println("El id del reto es invalido");
        }   
    }
    
  public void consultarGanador(String idReto){
      for( Reto r11:RetoGym.retos ){
          if(r11.getIdReto().equals(idReto)){
               System.out.println("Reto "+ r11.getIdReto());
               System.out.println("Los ganadores de cada categoria son");
                for (Categoria cat: r11.getCategorias()){
                  if(cat.getGanador()!=null){
                     
                      System.out.println(cat.getCategoria()+":"+cat.getGanador().getNombre());
                      
                      
                  }
                  else{
                      System.out.println(cat.getCategoria()+": no registra ganador");
                  }
              }
          }
      }
  }     
    
    

    
}
