package com.mycompany.proyectoestructurasdatos;

import java.io.IOException;
import java.net.URL;
import TDA.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import Modelo.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;



/**
 * FXML Controller class
 
 * @author fnand
 */
public class InicioSesionController implements Initializable {
    static ArrayList<Usuario> usuarioLista = Usuario.cargarListaU();
    
    @FXML
    private TextField usuario;
    @FXML
    private PasswordField clave;
    @FXML
    private TextField clavetf1;
    @FXML
    private CheckBox vistaclave;
    @FXML
    private Button iniciarSesionbtn;
    @FXML
    private Button registrobtn;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.visible(null);
    }    
    
    @FXML
    public void verificar() throws IOException{
        //extrae lo que el usuario ingreso en los textfield y los guarda en variables
        String user = usuario.getText();
        String pass = clave.getText();
        if(vistaclave.isSelected()){
            pass = clavetf1.getText();
        }
        int cont=0; //va a sumar los intentos correctos, verificando que la informacion ingresada es correcta
        for(int i= 0;i<usuarioLista.size(); i++){ //recorre la lista usuario en donde si pertence a un nivel lo lleve a la interfaz de ese
            Usuario u = usuarioLista.get(i); 
            if(user.equals(u.getUsuario()) && pass.equals(u.getContraseña())){
                    PantallaUsuario1Controller.setNombreUsuario(user);
                    PantallaUsuario1Controller.setUsuario(u);
                    NuevoEmojiController.setNombreUsuario(user);
                    SeguirController.setNombreUsuario(user);
                    //u.cargarListaEmoji();
                    try {       
                        
                        App.setRoot("pantallaUsuario1");
                    } 
                    catch (IOException ex) {
                        iniciarSesionbtn.setDisable(true);
                    }
                
                cont++; 
                } 
        }
        
        //si no ingresa los datos correctos va a presentar una alerta
        if(cont==0){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Alerta");
                alert.setContentText("Su usuario o contraseña son erroneos, intentelo de nuevo");

                alert.showAndWait();
                App.setRoot("inicioSesion");
                alert.close();
        }
    }

    @FXML
    public void visible(ActionEvent event){
        if(vistaclave.isSelected()){
            clavetf1.setText(clave.getText());
            clavetf1.setVisible(true);
            clave.setVisible(false);
            return;
        }
        clave.setText(clavetf1.getText());
        clave.setVisible(true);
        clavetf1.setVisible(false);
    }
    
    @FXML
    public void registrar(ActionEvent event) throws IOException{
        try {
            App.setRoot("nuevoUsuario");
        } catch (IOException e) {
            registrobtn.setDisable(true);
        }
        
    }
       
}
