
package retoGym;


//Importaciones de los paquetes que vamos a necesitar
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import leerArchivos.LectArchivoUsuarios;
import leerArchivos.LectArchivosClientes;
import leerArchivos.LectArchivosEmpleados;
import modelo.Cliente;
import modelo.User;
import modelo.Empleado;
import retoGym.Reto;
import retoGym.Ficha;

/**
 *
 * @author Yiam Rodriguez-Karina Ortega- Darwin Borja
 */
public class RetoGym {
    //Atributos de la clase RetoGym
    public static ArrayList<User> usuarios;
    public static ArrayList<Cliente> clientes;
    public static ArrayList<Empleado> empleados;
    public static ArrayList<Reto> retos ;
    
    public static void main (String[] args){
        
        
        Reto reto=new Reto();
        Categoria c= new Categoria();
        Reto r1= new Reto();
        Ficha f= new Ficha();
        Empleado empleado=new Empleado();
        //Se crean los nuevos objetos a usarse segun su clase
        usuarios = LectArchivoUsuarios.usuarios();
        clientes = LectArchivosClientes.Clientes();
        empleados = LectArchivosEmpleados.empleados();
        retos= new ArrayList<>();
        
        
        Sistema.inicializarSistema();
//        System.out.println(retos.get(0).getCategorias().get(3).getInscritos().size());
//        System.out.println(retos.get(1).getCategorias().get(3).getInscritos().size());
//        System.out.println(retos.get(2).getCategorias().get(3).getInscritos().size());
//        System.out.println(retos.get(2));
        //Listas impresas en pantallas
//        System.out.println(clientes);
//        System.out.println(empleados);
//        System.out.println(usuarios);
//        
        System.out.println("Reto 1 en etapa Inicial");
        System.out.println("Reto 2 en etapa de ejecucion");
        System.out.println("Reto 3 en etapa de cierre");
       
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Se guarda la opcion que el usuario ingresa
        int opcion11;
        
        /*Este while nos permite hacer tantas repeticiones del programa hasta que algun usuario
        decida salir del mismo*/
        while (!salir) {
            int n=0;
            //En esta parte se ingresan las credenciales que cada usuario tiene
            System.out.println("\n\n***************INGRESO DE CREDENCIALES****************");
            System.out.print("\n\tIngrese su usuario: ");
            String usuario= sn.nextLine(); //Se crea la variable usuario
            System.out.print("\tIngrese su contrasena: ");
            String contrasena= sn.nextLine();//Se crea la variable contrasena
                  
            boolean bandera= false;
            for (User d: RetoGym.usuarios){
                
                 if(d.getUsuario().equals(usuario)&& d.getClave().equals(contrasena)&& d.getNivel().equals("admin")){
                     bandera= true;
                    
                 }
                 
                           
               }
            boolean bandera1 = false;
            for (User d : RetoGym.usuarios) {
                if (d.getUsuario().equals(usuario) && d.getClave().equals(contrasena) && d.getNivel().equals("empleado")) {
                    bandera1 = true;
                } 

            }
               boolean bandera2= false;
               for(Reto rr: retos){
                   for(Categoria cat: rr.getCategorias()){
                       for( Cliente cc: cat.getInscritos()){
                           if (cc.getUser() != null) {
                               if (cc.getUser().getUsuario().equals(usuario) && cc.getUser().getClave().equals(contrasena)) {
                                   bandera2 = true;
                               }
                           }   
                       }
                   }
               }
//                System.out.println(bandera);
//                System.out.println(bandera1);
//                System.out.println(bandera2); 
            //Ingreso del usuario que es administrador
                if(bandera){
                    n=1;
                //Evita o ayuda a prever el error de que ingrese una letra en vez de un numero
                try {
                do{
                //Menu principal que tiene el administrador
                System.out.println("\n********************MENÚ PRINCIPAL********************");
                System.out.println("1. Crear Reto");
                System.out.println("2. Inscribir usuarios al reto");
                System.out.println("3. Consultar Inscritos en cada reto");
                System.out.println("4. Consultar fichas y actividades de usuario");
                System.out.println("5. Registrar ganador en reto");
                System.out.println("6. Mostrar Ganadores de Reto");
                System.out.println("7. Regresar");
                System.out.println("8. Salir del Programa");
                
                    //Se escoge una de las opciones que desea relizar
                    System.out.print("\nEscoja una de las opciones: ");
                    opcion = sn.nextInt(); //Se guarda en la variable opcion el dato ingresado por el usuario
                    sn.nextLine();//Se limpia el objeto sn de la clase Scanner del String que se alojó ahí
                    switch (opcion) {
                        case 1:
                            System.out.println("\n******************************************************");
                            System.out.println("*************Has seleccionado la opcion 1*************\n");
                            reto.crearReto();
                            break;
                        case 2:
                            System.out.println("\n******************************************************");
                            System.out.println("*************Has seleccionado la opcion 2*************\n");
                            c.inscribirUsuario();
                            break;
                        case 3:
                            System.out.println("\n******************************************************");
                            System.out.println("*************Has seleccionado la opcion 3*************\n");
                            reto.consultarInscritos();
                            break;
                        case 4:
                            System.out.println("\n******************************************************");
                            System.out.println("*************Has seleccionado la opcion 4*************\n");
                            do{
                            System.out.println("\n********************** SUB-MENÚ **********************");
                            System.out.println("1. Consulta de ficha inicial");
                            System.out.println("2. Consulta de actividades realizadas en el reto");
                            System.out.println("3. Consulta de ficha final");
                            System.out.println("4. Retroceder");
                            System.out.print("Escoge una de las opciones: ");
                            opcion11 = sn.nextInt(); //Se guarda en la variable opcion el dato ingresado por el usuario
                            sn.nextLine();//Se limpia el objeto sn de la clase Scanner del String que se alojó ahí
                            switch (opcion11) { 
                                case 1:
                                    System.out.println("\n******************************************************");
                                    System.out.println("*************Has seleccionado la opcion 1*************\n");
                                    System.out.print("\tIngrese id del Reto: ");
                                    String idReto7= sn.nextLine();
                                    System.out.print("\tIngrese id del usuario: ");
                                    String idUsuario7= sn.nextLine();
                                    c.verFichaInicial(idUsuario7);
                                  
                                    break;
                                case 2:
                                    System.out.println("\n******************************************************");
                                    System.out.println("*************Has seleccionado la opcion 2*************\n");
                                    System.out.print("\tIngrese id del Reto: ");
                                    String idRet= sn.nextLine();
                                    System.out.print("\tIngrese id del usuario: ");
                                    String idCliente= sn.nextLine();
                                    while(c.buscarInscritoReto(idRet, idCliente)==null){
                                        System.out.println("El cliente no esta inscrito en el reto");
                                        System.out.println("Ingrese el id del usuario inscrito en el reto");
                                        idCliente=sn.nextLine();
                                    }
                                    
                                    empleado.consultarActividad(idCliente);
                                    break;
                                case 3:
                                    System.out.println("\n******************************************************");
                                    System.out.println("*************Has seleccionado la opcion 3*************\n");
                                    System.out.print("\tIngrese id del Reto: ");
                                    String idRe= sn.nextLine();
                                    System.out.print("\tIngrese id del usuario: ");
                                    String idUsuario3= sn.nextLine();
                                    c.verFichaFinal(idUsuario3);
                                  
                                    break;
                                case 4:
                                    
                                    break;
                                default:
                                    System.out.println("Solo números entre 1 y 4");
                            }
                            }while(opcion11<4);
                            break;
                        case 5:
                            System.out.println("\n******************************************************");
                            System.out.println("*************Has seleccionado la opcion 5*************\n");
                            System.out.println("Ingrese id del reto:");
                            String fav= sn.nextLine();
                            reto.registrarGanador(fav);
                            break;
                        case 6: 
                            System.out.println("\n******************************************************");
                            System.out.println("*************Has seleccionado la opcion 6*************\n");
                            System.out.println("\t      Los retos disponibles son: ");
                            for(Reto r: RetoGym.retos){
                                System.out.println("\t\t       Reto: "+r.getIdReto());
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
                            reto.consultarGanador(idReto);
                            break;     
                        case 7:
                            
                            break;
                        case 8:
                            salir = true;
                            break;
                        default:
                            System.out.println("Solo números entre 1 y 8");
                    }
                }while(opcion<7);//Se realiza este do while para que se repita el menu hasta que desee regresar al menu principal o salir
                } catch (InputMismatchException e) {
                    System.out.println("Debes insertar un número");//Mensaje que se imprime si se produce la excepcion
                    sn.next();//Se limpia el objeto sn de la clase Scanner
                } 
            }
            
            
            else if(bandera1){
                n=1;
                try {
                do{ 
                //Menu del opciones para el Empleado
                System.out.println("\n********************MENÚ PRINCIPAL********************");
                System.out.println("1. Ingreso de ficha inicial");
                System.out.println("2. Registro actividad de usuario");
                System.out.println("3. Ingreso de ficha final");
                System.out.println("4. Regresar");
                System.out.println("5. Salir");
                    Empleado e = new Empleado();
                    System.out.print("Escoja una de las opciones: ");
                    opcion = sn.nextInt();//Se guarda en la variable opcion el dato ingresado por el usuario
                    sn.nextLine();//Se limpia el objeto sn de la clase Scanner del String que se alojó ahí
                    switch (opcion) {
                        case 1:
                            System.out.println("\n******************************************************");
                            System.out.println("*************Has seleccionado la opcion 1*************\n");
                            
                            
                            e.ingresarFichaInicial(usuario);
                            break;
                        case 2:
                            System.out.println("\n******************************************************");
                            System.out.println("*************Has seleccionado la opcion 2*************\n");
                            System.out.println("Ingrese id del Reto");
                            String idReto= sn.nextLine();
                            while(reto.buscarReto(idReto)==null){
                                System.out.println("Ingrese un id de reto valido");
                                idReto=sn.nextLine();
                            }
                            System.out.println("Ingrese el id del Usuario");
                            String idUsuario= sn.nextLine();
                            while(c.buscarInscritoReto(idReto, idUsuario)==null){
                                System.out.println("Ingrese el id del Usuario inscrito en el reto");
                                idUsuario= sn.nextLine();
                               
                            }
                            e.registrarActividad(idReto,idUsuario,usuario);
                            break;
                        case 3:
                            System.out.println("\n******************************************************");
                            System.out.println("*************Has seleccionado la opcion 3*************\n");
                            e.ingresarFichaFinal(usuario);
                            break;
                        case 4:
                            break;
                        case 5:
                            salir = true;
                            break;
                        default:
                            System.out.println("Solo números entre 1 y 5");
                    }
                }while (opcion<4);//Se realiza este do while para que se repita el menu hasta que desee regresar al menu principal o salir
                } catch (InputMismatchException e) {
                    System.out.println("Debes insertar un número");
                    sn.next();//Se limpia el objeto sn de la clase Scanner
                }
                }
            
            else if(bandera2){
                n=1;
                try {
                    do{
                    System.out.println("\n********************MENÚ PRINCIPAL********************");
                    System.out.println("1. Consulta de ficha inicial");
                    System.out.println("2. Consulta de actividades realizadas en el reto");
                    System.out.println("3. Consulta de ficha final");
                    System.out.println("4. Regresar");
                    System.out.println("5. Salir");

                    System.out.print("Escoge una de las opciones: ");
                    opcion = sn.nextInt(); //Se guarda en la variable opcion el dato ingresado por el usuario
                    sn.nextLine();//Se limpia el objeto sn de la clase Scanner del String que se alojó ahí
                    switch (opcion) { 
                        case 1:
                            System.out.println("\n******************************************************");
                            System.out.println("*************Has seleccionado la opcion 1*************\n");
                            c.verFichaInicial(usuario);
                            
                           
                            break;
                        case 2:
                            System.out.println("\n******************************************************");
                            System.out.println("*************Has seleccionado la opcion 2*************\n");
                            empleado.consultarActividad(usuario);
                           
                            
                            break;
                        case 3:
                            System.out.println("\n******************************************************");
                            System.out.println("*************Has seleccionado la opcion 3*************\n");
                            c.verFichaFinal(usuario);
                           
                            
                            break;
                        case 4:
                            break;
                        case 5:
                            salir = true;
                            break;
                        default:
                            System.out.println("Solo números entre 1 y 5");
                    }
                    }while (opcion<4);//Se realiza este do while para que se repita el menu hasta que desee regresar al menu principal o salir
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Debes insertar un número");
                    sn.next();//Se limpia el objeto sn de la clase Scanner
                }
            }
                
           
            if (n==0){
                    System.out.println("\n\tUSUARIO O CONTRASEÑA NO VALIDOS");
                }
        }
        
    sn.close();
    }
}