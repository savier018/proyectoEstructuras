package Modelo;

import TDA.LinkedList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import TDA.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import javafx.scene.image.Image;

public class Usuario {
    
    private String usuario;
    private String contraseña;
    public LinkedList<Emoji> coleccionEmojis;
  //  private CDLinkedList<Image> componentesAdicionales;

    public Usuario(String usuario, String contraseña) {
        this.usuario = usuario;
        this.contraseña = contraseña;
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
    
     public static void sobreescribirFichero(ArrayList<Usuario> usuarios){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/resources/text/usuarios.txt"));){
            bw.write("Usuario,Contrasena");
            for(int i = 0;i<usuarios.size();i++){
                Usuario u= usuarios.get(i);
                bw.newLine();
                bw.write(u.getUsuario()+","+u.getContraseña());
            }
        }catch (IOException e){
            System.out.println("error");
        }
    }
     
     public LinkedList<Emoji> cargarListaEmoji(){
        LinkedList<Emoji> emojis = new LinkedList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(String.format("src/main/resources/text/%s.txt",usuario)));){
            br.readLine();
            String linea;
            while ((linea = br.readLine())!=null){
                String[] datos = linea.split(","); 
                //emojis.addLast(new Emoji(datos[0],datos[1],datos[2]));
            }
        }catch (IOException e){
            System.out.println("Texto no encontrado");
        }
        return emojis;
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
