/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package retoGym;

//Importaciones de los paquetes a usarse
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import modelo.Cliente;
import modelo.User;


/**
 *
 * @author Borja_Ortega_Rodriguez
 */
//Se crea la clase categoria
public class Categoria {
    //Atributos propio de la clase categoria
    private TipoCategoria categoria;
    private ArrayList<Cliente> inscritos=new ArrayList<>();
    private Cliente ganador;
    
    //Constructores definidos en la clase categoria
    public Categoria(){
        
    }

    public Categoria(TipoCategoria categoria ) {
        this.categoria = categoria;
    }
   
    public Categoria(TipoCategoria categoria, ArrayList<Cliente> inscritos, Cliente ganador) { 
        this.categoria = categoria;
        this.inscritos = inscritos;
        this.ganador=ganador;
    }
    
    //Metodos Getters&Setters de la clase Categoria
    public TipoCategoria getCategoria() {
        return categoria;
    }

    public void setCategoria(TipoCategoria categoria) {
        this.categoria = categoria;
    }

    public ArrayList<Cliente> getInscritos() {
        return inscritos;
    }

    public void setInscritos(ArrayList<Cliente> inscritos) {
        this.inscritos = inscritos;
    }

    public Cliente getGanador() {
        return ganador;
    }

    public void setGanador(Cliente ganador) {
        this.ganador = ganador;
    }

    //Metodo toString que nos ayudará a imprimir las caracteristicas que necesitemos
    @Override
    public String toString() {
        return "Categoria{" + "categoria=" + categoria + ", inscritos=" + inscritos + ", ganador=" + ganador + '}';
    }
    
    // Realizamos los metodos para las categorias
    
    //Creamos los objetos que necesitaremos para los metodos siguientes
    User user= new User();
    Reto reto= new Reto();
    Scanner sn= new Scanner(System.in);
    Cliente cli= new Cliente();
    
    
    public void inscribirUsuario(){
        boolean salir= false;  
        int opc;
        do{  
        Ficha f= new Ficha();
        Cliente client= new Cliente();
                System.out.println("Los retos disponibles son: ");
                for(Reto reto: RetoGym.retos){
                    System.out.println("Reto: "+reto.getIdReto());
                }
                
                boolean cambio=false;
                System.out.print("Ingrese id del reto: ");
                String idReto= sn.nextLine();
                while (!cambio){
                    if (reto.buscarReto(idReto)== null){
                        System.out.println("\n\tIngrese un ID de reto VÁLIDO\n");
                        System.out.print("Ingrese id del reto: ");
                        idReto=sn.nextLine();
                    }else{
                        cambio=true;
                    }
                }
            System.out.print("Ingrese id del cliente: ");
            String id= sn.nextLine();
                 while (cli.BuscarCliente(id)==null ){
                     System.out.println("\n\t¡El cliente NO está inscrito en el Gimnasio!\n");
                     System.out.print("Ingrese id del cliente: ");
                     id=sn.nextLine();
                 }
        Reto r1=reto.buscarReto(idReto);
        if( r1!=null){
        TipoCategoria cat = null;
        int opcion;
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
                        cli.BuscarCliente(id).setUser(user.crearUsuario(id));
                        r1.getCategorias().get(0).inscritos.add(cli.BuscarCliente(id));
                        retoGym.Correo.EnvioCorreo(cli.BuscarCliente(id).getEmail(),("Su usuario es "+cli.BuscarCliente(id).getUser().getUsuario() +" y su clave es "+cli.BuscarCliente(id).getUser().getClave()), "Se inscribio a un reto en RetoGym");
                        System.out.println("\t         Usuario ingresado con ÉXITO");  
                        break;
                    case 2:
                        cat = TipoCategoria.SugarFree;
                        cli.BuscarCliente(id).setUser(user.crearUsuario(id));
                        r1.getCategorias().get(1).inscritos.add(cli.BuscarCliente(id));
                        retoGym.Correo.EnvioCorreo(cli.BuscarCliente(id).getEmail(),("Su usuario es: "+cli.BuscarCliente(id).getUser().getUsuario() +" y su clave es "+cli.BuscarCliente(id).getUser().getClave()), "Se inscribio a un reto en RetoGym");
                        
                        System.out.println("\t         Usuario ingresado con ÉXITO");break;
                    case 3:
                        cat = TipoCategoria.FatBurn;
                        cli.BuscarCliente(id).setUser(user.crearUsuario(id));
                        r1.getCategorias().get(2).inscritos.add(cli.BuscarCliente(id));
                        retoGym.Correo.EnvioCorreo(cli.BuscarCliente(id).getEmail(),("Su usuario es "+cli.BuscarCliente(id).getUser().getUsuario() +" y su clave es "+cli.BuscarCliente(id).getUser().getClave()), "Se inscribio a un reto en RetoGym");
                        System.out.println("\t         Usuario ingresado con ÉXITO");
                        break;
                    case 4:
                        cat = TipoCategoria.MuscleAgain;
                        cli.BuscarCliente(id).setUser(user.crearUsuario(id));
                        r1.getCategorias().get(3).inscritos.add(cli.BuscarCliente(id));    
                        retoGym.Correo.EnvioCorreo(cli.BuscarCliente(id).getEmail(),("Su usuario es "+cli.BuscarCliente(id).getUser().getUsuario() +" y su clave es "+cli.BuscarCliente(id).getUser().getClave()), "Se inscribio a un reto en RetoGym");
                        System.out.println("\t         Usuario ingresado con ÉXITO");
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 4\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número\n");
                sn.next();//Se limpia el objeto sn de la clase Scanner
            }
        }
        else{
            System.out.println("El id del reto es invalido");
        }
        boolean nand = false;
        while(!nand){
        System.out.println("¿Desea seguir inscribiendo en las siguientes categorias?  Si/No");
            String a= sn.nextLine();
            if (a.equals("No")) {
                nand=true;
                salir = true;
            }else if(a.equals("Si")){
                nand=true;
                break;
            } else{
                System.out.println("\n\t\t   **Ingrese algo correcto**\n");
            }
        }
        } while(!salir);         
    }
    
    //Revision del tamaño de la lista de los inscritos
    public int tamanoInscritos(){
        int i= inscritos.size();
        return i;
    }
    
    //Nos ayuda a buscar a un cliente inscrito en la lista de clientes
     public Cliente buscarInscrito(String idInscrito){
         
       for( Cliente ins: this.inscritos){
           if(ins.getId().equals(idInscrito));
           return  ins;
       }
       return null;
   }
     
     
   public Cliente buscarInscritoReto(String idReto, String idInscrito) {
        for (Reto r : RetoGym.retos) {
            if (r.getIdReto().equals(idReto)) {
                for (Categoria c : r.getCategorias()) {
                    for (Cliente c1 : c.getInscritos()) {
                        if (c1.getId().equals(idInscrito)) {
                            return c1;                  
                        }
                    }
                }
            }
        }
        return null;
    }   

 
   
    
    
    
    // Retorna true si no esta inscrito
    public boolean consultarInscritoReto(String reto,String id){
        for(Reto r: RetoGym.retos ){
            if(buscarInscritoReto(reto,id)==null){
                return true;
            }
            
        }
       return false;
    
    }
    
    
    public void verFichaInicial(String id){
            boolean bandera=false;
            Reto reto= null;
            Cliente cl=null;
            Categoria categoria=buscarCategoria(id);
            
            
            for(Reto r1:RetoGym.retos){
                if(buscarInscritoReto(r1.getIdReto(),id)!=null && buscarInscritoReto(r1.getIdReto(),id).getId().equals(id)){
                  bandera=true;
                  reto=r1;
                  cl=buscarInscritoReto(r1.getIdReto(),id);
                  }
            }
            if(bandera==true){
                System.out.println("Usted esta inscrito en el reto: "+ reto.getIdReto());
                System.out.println("En la categoria: "+categoria.getCategoria());
                if(cl.getFichaInicial()!=null){ 
                   if(categoria.equals(TipoCategoria.FatBurn)||categoria.equals(TipoCategoria.MuscleAgain)){
                     System.out.println(cl.getFichaInicial().toString1());
                   }
                   if(categoria.equals(TipoCategoria.SugarFree)||categoria.equals(TipoCategoria.HiperGain)){
                    System.out.println(cl.getFichaInicial().toString2());
                   }
                }
                else{
                    System.out.println("El usuario no registra ficha inicial");
                }
            }
            else{
                System.out.println("El usuario no esta inscrito en un reto");
            }
        
        
          
    }        
     
    public void verFichaFinal(String id){
            boolean bandera=false;
            Reto reto= null;
            Cliente cl=null;
            Categoria categoria=buscarCategoria(id);
            
            
            for(Reto r1:RetoGym.retos){
                if(buscarInscritoReto(r1.getIdReto(),id)!=null && buscarInscritoReto(r1.getIdReto(),id).getId().equals(id)){
                  bandera=true;
                  reto=r1;
                  cl=buscarInscritoReto(r1.getIdReto(),id);
                  }
            }
            if(bandera==true){
                System.out.println("Usted esta inscrito en el reto: "+ reto.getIdReto());
                System.out.println("En la categoria: "+categoria.getCategoria());
                if(cl.getFichaInicial()!=null){ 
                    if(categoria.equals(TipoCategoria.FatBurn)||categoria.equals(TipoCategoria.MuscleAgain)){
                     System.out.println(cl.getFichaFinal().toString1());
                    }
                    if(categoria.equals(TipoCategoria.SugarFree)||categoria.equals(TipoCategoria.HiperGain)){
                     System.out.println(cl.getFichaFinal().toString2());
                    }
                }else{
                   System.out.println("El usuario no registra ficha Final");  
                }
            }
            else{
                System.out.println("El usuario no esta inscrito en un reto");
            }
        

            
       
    }    

/**
 *Recibe el string de la categoria 
 * y retorna 1 si es fat Burn o Muscle again o Retorna 2 si es cualquiera de las otras dos categorias.
 * 
 */
//Se el metodo buscarCategoria
     
    public Categoria buscarCategoria(String id){
        for(Reto r11: RetoGym.retos){
            for(Categoria cat: r11.getCategorias()){
                for(Cliente cl: cat.getInscritos()){
                    if(cl.getId().equals(id)){
                        
                            return cat;
                        
                        
                    }
                }
            }
        }
        return null;
    }
    public TipoCategoria buscarTipoCategoria(String id){
        for(Reto r11: RetoGym.retos){
            for(Categoria cat: r11.getCategorias()){
                for(Cliente cl: cat.getInscritos()){
                    if(cl.getId().equals(id)){
                        
                            return cat.getCategoria();
                        
                        
                    }
                }
            }
        }
        return null;
    }
}

