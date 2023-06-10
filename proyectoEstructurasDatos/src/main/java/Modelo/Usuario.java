package Modelo;

import TDA.CDLinkedList;
import javafx.scene.image.Image;

public class Usuario {
    
    private String nombre;
    private String contraseña;
    private CDLinkedList<Emoji> coleccionEmojis;
    private CDLinkedList<Image> componentesAdicionales;

    public Usuario(String nombre, String contraseña) {
        this.nombre = nombre;
        this.contraseña = contraseña;
    }
  
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getContraseña() {
        return contraseña;
    }
    
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public CDLinkedList<Image> getComponentesAdicionales() {
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
    }
    
}
