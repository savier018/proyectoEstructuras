package Modelo;

//import TDA.CDLinkedList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import TDA.ArrayList;
import javafx.scene.image.Image;

public class Usuario {
    
    private String usuario;
    private String contraseña;
    private ArrayList<Usuario> userList;
  //  private CDLinkedList<Emoji> coleccionEmojis;
  //  private CDLinkedList<Image> componentesAdicionales;

    public Usuario(String usuario, String contraseña) {
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.userList = new ArrayList<Usuario>();
    }
  
    public String getUsuario() {
        return usuario;
    }
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    public String getContraseña() {
        return contraseña;
    }
    
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    public static ArrayList<Usuario> cargarListaU(){
        ArrayList<Usuario> usuarios = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/text/usuarios.txt"));){
            br.readLine();
            String linea;
            while ((linea = br.readLine())!=null){
                String[] datos = linea.split(","); 
                usuarios.addLast(new Usuario(datos[0],datos[1]));
            }
        }catch (IOException e){
            
        }
        return usuarios;
    }

   /* public CDLinkedList<Image> getComponentesAdicionales() {
        return componentesAdicionales;
    }

    public void setComponentesAdicionales(CDLinkedList<Image> componentesAdicionales) {
        this.componentesAdicionales = componentesAdicionales;
    }
    

    public CDLinkedList<Emoji> getColeccionEmojis() {
        return coleccionEmojis;
    }

    public void setColeccionEmojis(CDLinkedList<Emoji> coleccionEmojis) {
        this.coleccionEmojis = coleccionEmojis;
    }*/
    
}
