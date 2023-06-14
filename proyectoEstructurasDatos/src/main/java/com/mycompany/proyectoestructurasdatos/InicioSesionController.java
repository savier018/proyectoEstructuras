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



/**
 * FXML Controller class
 *
 * @author fnand
 */
public class InicioSesionController implements Initializable {
    ArrayList<Usuario> usuarioLista = Usuario.cargarListaU();
    
    @FXML
    private TextField usuario;
    @FXML
    private TextField clave;
    @FXML
    private Button iniciarSesion;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    public void verificar() throws IOException{
        //extrae lo que el usuario ingreso en los textfield y los guarda en variables
        String user = usuario.getText();
        String pass = clave.getText();
        int cont=0; //va a sumar los intentos correctos, verificando que la informacion ingresada es correcta
        for(int i= 0;i<usuarioLista.size(); i++){ //recorre la lista usuario en donde si pertence a un nivel lo lleve a la interfaz de ese
            Usuario u = usuarioLista.get(i); 
            if(user.equals(u.getUsuario()) && pass.equals(u.getContraseña())){
                    PantallaUsuario1Controller.setNombreUsuario(user);
                    PantallaUsuario1Controller.setUsuario(u);
                    try {       
                        
                        App.setRoot("pantallaUsuario1");
                    } 
                    catch (IOException ex) {
                        iniciarSesion.setDisable(true);
                    }
                
                cont++; 
                } 
        }
        
        //si no ingresa los datos correctos va a presentar una alerta
        if(cont==0){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Alerta");
                alert.setContentText("Su usuario o contraseña son erroneas, intentelo de nuevo");

                alert.showAndWait();
                App.setRoot("inicioSesion");
                alert.close();
        }
    }

}
