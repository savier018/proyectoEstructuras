/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyectoestructurasdatos;

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
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author fnand
 */
public class PantallaUsuario1Controller implements Initializable {
    @FXML
    private TextField textNombre;
    
    static Usuario user;
    
    static String nombreUsuario;
    
    @FXML
    private Button nuevobtn;
    @FXML
    private Button seguirbtn;
    @FXML
    private Button volverbtn;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        textNombre.setText(nombreUsuario);
        textNombre.setDisable(true);
        /*if (user.coleccionEmojis.isEmpty()){
            seguir.setDisable(true);
        }*/
    }    
    
    @FXML
    public void nuevo()throws IOException {
        // TODO
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
