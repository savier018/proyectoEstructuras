
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyectoestructurasdatos;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import Modelo.Usuario;
import TDA.ArrayList;
import java.io.IOException;
import javafx.event.ActionEvent;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.CheckBox;


/**
 * FXML Controller class
 *
 * @author fnand
 */
public class NuevoUsuarioController implements Initializable {

    /**
     * Initializes the controller class.
     * Controls the visibility of the Password field
     * @param event
     */
    
    @FXML
    private PasswordField clavetf;
    
    @FXML
    private TextField clavetf1;

    @FXML
    private Button registrobtn;

    @FXML
    private TextField usuariotf;
    @FXML
    private CheckBox vistaclave;
    
  
     
    ArrayList<Usuario> listaUsuario = Usuario.cargarListaU();
    

    @FXML
    void aceptarNuevo() throws IOException {
        String usuario = usuariotf.getText();
        String clave = clavetf.getText();
        Usuario u = new Usuario(usuario,clave);
        listaUsuario.addLast(u);
        Usuario.sobreescribirFichero(listaUsuario);
        PantallaUsuario1Controller.setNombreUsuario(usuario);
        PantallaUsuario1Controller.setUsuario(u);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Usuario creado exitosamente");
        alert.setContentText("Su usuario ha sido creado exitosamente");
        alert.showAndWait();
        alert.close();
        App.setRoot("pantallaUsuario1");
    }
    
   @FXML
    public void visible(ActionEvent event){
        if(vistaclave.isSelected()){
            clavetf1.setText(clavetf.getText());
            clavetf1.setVisible(true);
            clavetf.setVisible(false);
            return;
        }
        clavetf.setText(clavetf1.getText());
        clavetf.setVisible(true);
        clavetf1.setVisible(false);
    }
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       this.visible(null);
        
        
    }    
    
    
}