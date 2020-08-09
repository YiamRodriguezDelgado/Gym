
package modelo;


//Importacion de los paquetes que se requieren en esta clase
import java.util.Random;


/**
 * @author Darwin Borja
 * @author Karina Ortega
 * @author Yiam Rodriguez
 */
/*Se crea la clase PERSONA de la cual se heredaran algunas caracteristicas para otras 
clases, tales como la clase Administrador, Cliente y Empleado*/
public class Persona {
    //Atributos de la clase Persona
    private String id;
    private User user;
    private String nombre;
    private String direccion;
    private String telefono;
    private String email;
    public Persona(){  
    }
    
    //Constructores de la Clase persona que reciben diferentes parametros (Metodos sobrecargados)
    public Persona(String id,String nombre, String direccion, String telefono, String email) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    } 
    
    public Persona(String id, User user, String nombre, String direccion, String telefono, String email) {
        this.id = id;
        this.user=user;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        
    }

    //Metodos Getters&Setters de la clase Persona
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String Id) {
        this.id = Id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //Metodo toString de la clase Persona (Metodo usado en otras clases que heredan de esta clase)
    @Override
    public String toString() {
        return "Id=" + id + ", user=" + user + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono= " + telefono + ", email= " + email ;
    }
    
    /*Con este metodo se trata de crear un nuevo usuario en base a la cédula y al nivel 
    que posee este dentro del Gym.
    Este usuario se generará de forma aleatoria en base a la lista de letras que esta a
    continuacion.*/
    public void generarUser(String cedula,String nivel){
        //Lista de todas las letras del alfabeto
         char[] letras= {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        
        String clave="" ; //Inicializamos la variable clave
        // Se crea un for para que se repita el proceso 8 veces ya que se desea una clave con 8 digitos
        for(int i=0; i<8;i++){
            Random rand = new Random(); //Se crea un nuevo objeto de la clase Random
            int n = rand.nextInt(26); //Esoge aleatoriamente un numero de 0 a 26 la cual dara una posicion de la lista
            clave+=letras[n]; //Guarda cada letra escogida aleatoriamente segun la posicion de la lista
        }
        
        //Se crea un nuevo objeto User que lleva como parametros Cedula, clave y nivel.
        User user= new User(cedula,clave,nivel);
        this.user=user;//Se obtiene el Usuario
    }
    
}


