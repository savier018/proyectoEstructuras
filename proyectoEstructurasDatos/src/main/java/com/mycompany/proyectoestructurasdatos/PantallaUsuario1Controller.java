package com.mycompany.proyectoestructurasdatos;

import Modelo.Emoji;
import Modelo.EmojiImage;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import java.io.IOException;
import java.net.URL;
import TDA.ArrayList;
import TDA.LinkedList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import Modelo.Usuario;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author fnand
 */
public class PantallaUsuario1Controller implements Initializable {
    
    //FXML
    @FXML
    private TextField textNombre;
    //Variables and Lists
    static Usuario user;
    static String nombreUsuario;
    
    @FXML
    private Button seguirbtn;
    @FXML
    private Button nuevobtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        textNombre.setText(nombreUsuario);
        textNombre.setDisable(true);
        if (SeguirController.cargarEmojis().get(0).isEmpty()){
            seguirbtn.setDisable(true);
        }
        
    }    
    //Metodos FXML
      
    @FXML
    public void nuevo()throws IOException {
       try {
            App.setRoot("nuevoEmoji");
        }catch (IOException e){
            System.err.println(e);
        }
    }   
    
     
    @FXML
    public void seguir()throws IOException {
        try {                          
            App.setRoot("seguir");
            } 
        catch (IOException ex) {
            seguirbtn.setDisable(true);   
            }    
    }           
   
     
    
    //Metodos variables
    public static void setNombreUsuario(String nombre) {
        nombreUsuario = nombre;
    }
    
    public static void setUsuario(Usuario usuario) {
        user = usuario;
    }
    
    
    @FXML
    public void volver()throws IOException {
        try {                          
            App.setRoot("inicioSesion");
            } 
        catch (IOException ex) {
            
            }    
    }           
    
    
}
