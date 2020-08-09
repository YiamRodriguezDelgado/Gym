  
package modelo;

//Importacion de los paquetes que se requieren en esta clase
import java.util.Random;

//Se crea l clase Usuario que nos ayudará con la contraseña, el usuario y el nivel del usuario
//que ingresa
public class User {
    //Atributos de la clase
    private String usuario;
    private String clave;
    private String nivel;
    
    //Constructores del Usuario
    public User(){    
    }
    
    public User (String usuario, String clave, String nivel){
        this.usuario = usuario;
        this.clave = clave;
        this.nivel = nivel;
    }

   //Getters y Setters de Usuarios
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
    
    //METODOS SOBRECARGADOS
    
    //Se puede crear un nuevo usuario ingresando el id y el nivel del mismo
    public User crearUsuario(String id, String nivel)  {
        char[] letras= {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        
        String clave="" ; //Se inicializa la clave
        for(int i=0; i<8;i++){
            Random rand = new Random(); //Se crea un objeto de la clase Random
            int n = rand.nextInt(26);
            clave+=letras[n];
        }
        User user= new User(id, clave, nivel);
        return user;  
    }
    
    //creamos un nuevo usuario para un cliente el cual recibe como parametro su ID
     public User crearUsuario(String id)  {
        char[] letras= {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        
        String clave="" ; //Se inicializa la clave
        for(int i=0; i<8;i++){
            Random rand = new Random(); //Se crea un objeto de la clase Random
            int n = rand.nextInt(26);
            clave+=letras[n];
        }
        User user= new User(id, clave, "cliente");
        return user;
    } 
     
     
    //Metodo toString
    @Override
    public String toString() {
        return "User{" + "usuario=" + usuario + ", clave=" + clave +", nivel= "+nivel+ '}';
    }
    
}
