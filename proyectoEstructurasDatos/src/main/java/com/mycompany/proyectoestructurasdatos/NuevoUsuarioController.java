package com.mycompany.proyectoestructurasdatos;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import Modelo.Usuario;
import TDA.ArrayList;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;


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
    
    @FXML
    private Button botonRegresar;
    
  
     
    ArrayList<Usuario> listaUsuario = Usuario.cargarListaU();
    

    @FXML
    public void aceptarNuevo() throws IOException {
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
    
    @FXML
    public void volverLogin(ActionEvent event){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("inicioSesion.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) botonRegresar.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       this.visible(null); 
    }   
    
    
}