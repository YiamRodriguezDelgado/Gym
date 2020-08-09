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
        do{  
        Ficha f= new Ficha();
        Cliente client= new Cliente();
        
            for(Reto r: RetoGym.retos){
                
                System.out.println("Los retos disponibles son");
                for(Reto reto: RetoGym.retos){
                    System.out.println("Reto:"+reto.getIdReto());
                }
            }
            System.out.println("Ingrese id del reto:");
            String idReto= sn.nextLine();
            while(!reto.buscarReto(idReto).getIdReto().equals(idReto)){
                System.out.println("Ingrese un id de reto valido");
                System.out.println("Ingrese id del reto");
                idReto=sn.nextLine();
            }
            
            System.out.println("Ingrese id del cliente");
            String id= sn.nextLine();

                 while (cli.BuscarCliente(id)==null ){
                     
                    
                     System.out.println("El cliente no esta inscrito en el Gimnasio");
                     System.out.println("Ingrese id del cliente");
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
                        //retoGym.Correo.EnvioCorreo(cli.BuscarCliente(id).getEmail(),("Su usuario es "+cli.BuscarCliente(id).getUser().getUsuario() +" y su clave es "+cli.BuscarCliente(id).getUser().getClave()), "Se inscribio a un reto en RetoGym");
                        client.BuscarCliente(id).setFicha(f.ingresarFicha2());   
                        break;
                    case 2:
                        cat = TipoCategoria.SugarFree;
                        cli.BuscarCliente(id).setUser(user.crearUsuario(id));
                        r1.getCategorias().get(1).inscritos.add(cli.BuscarCliente(id));
                        client.BuscarCliente(id).setFicha(f.ingresarFicha2());    
                        //retoGym.Correo.EnvioCorreo(cli.BuscarCliente(id).getEmail(),("Su usuario es: "+cli.BuscarCliente(id).getUser().getUsuario() +" y su clave es "+cli.BuscarCliente(id).getUser().getClave()), "Se inscribio a un reto en RetoGym");
                        break;
                    case 3:
                        cat = TipoCategoria.FatBurn;
                        cli.BuscarCliente(id).setUser(user.crearUsuario(id));
                        r1.getCategorias().get(2).inscritos.add(cli.BuscarCliente(id));
                        client.BuscarCliente(id).setFicha(f.ingresarFicha1());   
                        //retoGym.Correo.EnvioCorreo(cli.BuscarCliente(id).getEmail(),("Su usuario es "+cli.BuscarCliente(id).getUser().getUsuario() +" y su clave es "+cli.BuscarCliente(id).getUser().getClave()), "Se inscribio a un reto en RetoGym");
                        break;
                    case 4:
                        cat = TipoCategoria.MuscleAgain;
                        cli.BuscarCliente(id).setUser(user.crearUsuario(id));
                        r1.getCategorias().get(3).inscritos.add(cli.BuscarCliente(id));    
                        client.BuscarCliente(id).setFicha(f.ingresarFicha1());   
                        //retoGym.Correo.EnvioCorreo(cli.BuscarCliente(id).getEmail(),("Su usuario es "+cli.BuscarCliente(id).getUser().getUsuario() +" y su clave es "+cli.BuscarCliente(id).getUser().getClave()), "Se inscribio a un reto en RetoGym");
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
        System.out.println("Desea seguir ingresando Clientes en algun reto Si/No");
                        if(sn.nextLine().equals("No")){
                            salir=true;
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

    public void ImprimirFicha(Ficha ficha,TipoCategoria categoria){
        if (categoria.equals("Fat burn") || categoria.equals("Muscle gain")){
            System.out.println(ficha.toString1());
        }
        if (categoria.equals("Sugar free") || categoria.equals("Hiper gain")){
            System.err.println(ficha.toString2());
        }
   }
    
       
     /*
     * El método ConsultarFichaInicial recibe el id de Reto
     * y retorna true en caso de que la fecha de inicio de 
     * reto este dentro de los siete días luego de iniciado
     * este.Caso contrario retorna false indicando que la 
     * ficha ya no está disponible para la consulta.
     */
    public void ConsultarFichaInicial(String idReto, String idClienteInscrito){        
        if(FichaInicialDisponible(idReto)){//Se verifica la disponibilidad de la ficha antes de consultar
            for(Cliente a: inscritos){ //Se recorre la lista de inscritos hasta coincidir con el id ingresado
                if(a.getId().equals(idClienteInscrito)){
                    ImprimirFicha(a.getFicha(),categoria);
                }else{
                    System.out.println("Las credenciales del cliente son incorrectos");
                }
            }
        
        }
    }
    
    
    /**
     * El método ConsultarFichaFinal recibe el id de Reto
     * y retorna true en caso de que la fecha de inicio de 
     * reto este dentro de los siete días luego de iniciado
     * este.Caso contrario retorna false indicando que la 
     * ficha ya no está disponible para la consulta.
     */
    public void ConsultarFichaFinal(String idReto, String idClienteInscrito){        
       
        if(FichaCierreDisponible(idReto)){//Se verifica la disponibilidad de la ficha antes de consultar
            for(Cliente a: inscritos){ //Se recorre la lista de inscritos hasta coincidir con el id ingresado
                if(a.getId().equals(idClienteInscrito)){
                    ImprimirFicha(a.getFicha(),categoria);
                }else{
                    System.out.println("Las credenciales del cliente son incorrectos");
                    //SubMenuFichasActividades();
                }
            }
        
        }
    }
    
    
    
    //Metodo que se usa pra imprimir las caracteristicas de cada cliente, solo con ingresar el id del cliente inscrito
    public void ImprimirFicha(String idClienteInscrito,ArrayList <Categoria> cat){
        ArrayList <Cliente> inscritos= null; // Se crea un objeto Cliente en el que se guardará el cliente participante
        //Se inicializan las variables de instancia
        Categoria categoria= null;
        Cliente inscrito = null;
        //Se analiza la lista Categoria con la ayuda de un for each para obtener a los iscritos
        for (Categoria c:cat){
            inscritos = c.getInscritos();//Se obtiene a los inscritos en los retos
            for(Cliente cliente:inscritos){
                //Se revisa si el ID del cliente es igual al ID de algun cliente inscrito
                if(cliente.getId().equals(idClienteInscrito)){
                    //Se guarda en los datos inicializados a los elementos encontrados
                    categoria = c;
                    inscrito = cliente;
                }     
            }
        }
        //Se imprimen los datos del cliente que esta inscrito en algun reto
        System.out.println("Cliente: " + inscrito.getNombre()+"participa en Reto con categoria: " +categoria);
        inscrito.getFicha();
    }

    
    /**
     * El método ConsultarActividades recibe el id de Reto y 
     * id de ususario inscrito para retornar un String con el
     * tipo de actividad realizada. Ejemplo: aplicación de 
     * compresas, control de peso,entrenamiento con pesas, etc.
     */
    public void ConsultarActividades(String idClienteInscrito, String idReto) {
        //Se inicializan las variables a utilizarse en el metodo
        ArrayList<Cliente> inscritos = null;
        ArrayList<Categoria> categorias = new ArrayList<>();
        for(Reto r:RetoGym.retos){
            //Se recorre la lista de Categorias para ibtener las categorias
            categorias = r.getCategorias();
            for(Categoria c: categorias){
                //Se recorre la lista de Categoria para obtener a los inscritos
                inscritos = c.getInscritos();
                for (Cliente i: inscritos){
                    //Se compara si el ID ingresado es igual al ID del cliente inscrito
                    if(i.getId().equals(idClienteInscrito)){
                         i.getActividades().toString();//Se imprime el toString
                    }
            }
            }
        }
        
    }
    
    
    
    /** El método FichaInicialDisponible recibe el id de Reto
      * y retorna true en caso de que la fecha de inicio de 
      * reto este dentro de los siete días luego de iniciado
      * este.Caso contrario retorna false indicando que la 
      * ficha ya no está disponible para la consulta.
      */
    public boolean FichaInicialDisponible(String idReto){
        //ArrayList<Reto>ListaRetos = new ArrayList<>();//Esta lista es momentanea hasta usar la lista de retos.
        LocalDate fechaInicio = null;
       for(Reto a: RetoGym.retos){ // Por cada reto en la lista.
           if (a.getIdReto().equals(idReto)) // Compara el id enviado.
               fechaInicio = a.getFechaInicio_Reto(); // Obtiene la fecha de inicio de reto.
       }
        //String fechaInicio= "15/06/2019";
        Date date = new Date();
        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
        String fechaActual= df.format(date); // Fecha actual del sistema.
        String fechaInicioReto = fechaInicio.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        String fechaIni [] = fechaInicioReto.split("/"); //Se almacena un arreglo con elementos de la fecha de inicio.
        String fechaFin [] = fechaActual.split("/"); //Se almacena un arreglo con elementos de la fecha actual.
        Integer diaInicio = Integer.parseInt(fechaIni[0]); // Convertimos el día a tipo entero para poder condicionar.
        Integer diaActual = Integer.parseInt(fechaFin[0]);
        int diaTope = diaInicio +7; //La variable diaTope indica hasta que día se puede consultar la ficha.
        if (diaActual>diaTope){ //Pasado los 7 días de iniciado el reto ya no se podrá consultar la ficha.
            System.out.println("La ficha no está disponible");
            return false;
        }
        return true;
    }
    
    
    /**
     * El método FichaCierreDisponible recibe el id de Reto
     * y retorna true en caso de que la fecha de cierre de 
     * reto esté dentro de los siete días luego de cerrado
     * este. Caso contrario retorna false indicando que la 
     * ficha ya no está disponible para la consulta.
     */
    public boolean FichaCierreDisponible(String idReto){
        //ArrayList<Reto>ListaRetos = new ArrayList<>();//Esta lista es momentanea hasta usar la lista de retos.
      LocalDate fechaCierre = null;
        for(Reto a: RetoGym.retos){ // Por cada reto en la lista.
            if (a.getIdReto().equals(idReto)) // Compara el id enviado.
                fechaCierre = a.getFechaInicio_Reto(); // Obtiene la fecha de inicio de reto.
        }
        //String fechaInicio= "15/06/2019";
        Date date = new Date();
        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
        String fechaActual= df.format(date); // Fecha actual del sistema.
        String fechaCierreReto = fechaCierre.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        String fechaClose [] = fechaCierreReto.split("/"); //Se almacena un arreglo con elementos de la fecha de inicio.
        String fechaFin [] = fechaActual.split("/"); //Se almacena un arreglo con elementos de la fecha actual.
        Integer diaCierre = Integer.parseInt(fechaClose[0]); // Convertimos el día a tipo entero para poder condicionar.
        Integer diaActual = Integer.parseInt(fechaFin[0]);
        int diaTope = diaCierre +7; //La variable diaTope indica hasta que día se puede consultar la ficha.
        if (diaActual>diaTope){ //Pasado los 7 días de cerrado el reto ya no se podrá consultar la ficha.
            System.out.println("La ficha no está disponible");
            return false;
        }
        return true;
    }      
    
    /*
    
    //Metodo que nos entregará como resultado el menu de las fichas
    public void SubMenuFichasActividades(){
        //SE crea un objeto de la clase Scanner
        Scanner sn = new Scanner(System.in);
        int opcion; //Se define el dato 
        boolean salir = false;
        while(!salir){//Bucle que ayudará a mantenerse dentro del submenu
            try {
                do{ 
                    System.out.println("\n***************************  SUBMENÚ  ***************************");
                    System.out.println("1. Consulta de ficha inicial");
                    System.out.println("2. Consulta de Actividades realizadas en el Reto");
                    System.out.println("3. Consulta de ficha final");
                    //System.out.println("4. Regresar");
                    System.out.println("4. Salir");

                    System.out.print("Escoja una de las opciones: ");
                    opcion = sn.nextInt();//Se guarda en la variable opcion el dato ingresado por el usuario
                    sn.nextLine();//Se limpia el objeto sn de la clase Scanner del String que se alojó ahí
                    switch (opcion){
                        //Se escoge la primera opcion 
                        case 1:
                            System.out.println("\n******************************************************");
                            System.out.println("*************Consulta de ficha inicial*************\n");
                            System.out.print("Ingrese id de Reto a consultar: ");
                            String idReto = sn.nextLine();//Se guarda el ID del Reto
                            System.out.print("Ingrese id de Cliente Inscrito a consultar: ");
                            String idClienteInscrito = sn.nextLine();//Se guarda el ID del cliente
                            /*Se llama al metodo cosultar ficha inicial que tiene como parametros 
                            el ID del reto y el ID del cliente
                           ConsultarFichaInicial(idReto, idClienteInscrito);
                            break;//Se rompe el ciclo
                            //Se escoge la segunda opcion
                        case 2:
                            System.out.println("\n******************************************************");
                            System.out.println("*****Consulta de Actividades realizadas en el Reto****\n");
                            System.out.print("Ingrese id de Cliente Inscrito a consultar: ");
                            String idClienteInscrito1 = sn.nextLine();//Se guarda el ID del cliente
                            System.out.print("Ingrese id del Reto a consultar: ");
                            String id_Reto = sn.nextLine();//Se guarda el ID del Reto
                            /*Se llama al metodo consultar actividades, la cual pide como parametros el ID del cliente 
                            y el ide del reto
                            ConsultarActividades(idClienteInscrito1,id_Reto);
                            break;//Se rompe el ciclo
                            //Se escoge la tercera opcion
                        case 3:
                            System.out.println("\n******************************************************");
                            System.out.println("****************Consulta de ficha final****************\n");
                            System.out.print("Ingrese id de Reto a consultar: ");
                            String idReto2 = sn.nextLine();//Se guarda el ID del Reto
                            System.out.print("Ingrese id de Cliente Inscrito a consultar: ");
                            String idClienteInscrito2 = sn.nextLine();//Se guarda el ID del cliente
                            /*Se llama al metodo que consulta la ficha y tiene como parametros el ID del reto 
                            y el ID del cliente
                            ConsultarFichaInicial(idReto2, idClienteInscrito2);
                            break;//Se rompe el ciclo
                        case 4:
                            salir = true;//Se sale del bucle y del programa en sí
                            break;//Se rompe el ciclo
                        default:
                            System.out.println("Solo números entre 1 y 4");
                        }
                    }while (opcion<4);//Se realiza este do while para que se repita el menu hasta que desee regresar al menu principal o salir
                    }catch (InputMismatchException e) {
                        System.out.println("Debes insertar un número");
                        sn.next();//Se limpia el objeto sn de la clase Scanner
                    }  
        }
    }*/
}

