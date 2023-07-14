/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyectoestructurasdatos;

import TDA.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.image.WritableImage;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author fnand
 */
public class AgregarImagenController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    BorderPane bp;
    @FXML
    Button abrirbtn;
    @FXML
    Button agregarbtn;
    @FXML
    Label ruta;
    @FXML
    ComboBox cmbTipos;
    
    File selectedFile;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       mostrartipos();
       encontrarImagen();
    }    
    
    
   
    public void encontrarImagen(){
        abrirbtn.setOnAction(actionEvent ->{
        ImageView imgView = new ImageView();
        FileChooser filechooser = new FileChooser();
        filechooser.setTitle("Open a file");
        filechooser.setInitialDirectory(new File("C:\\"));
        filechooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("PNG image","*.png"),new FileChooser.ExtensionFilter("All images", "*.png"));
        Stage stage = (Stage) abrirbtn.getScene().getWindow();
        selectedFile = filechooser.showOpenDialog(stage);
        if(selectedFile!= null){
            ruta.setText(selectedFile.getName());
            try{
                Image image = new Image(selectedFile.getAbsolutePath());  
                imgView.setImage(image);
            } catch (Exception e){
                System.out.println("No se pudo cargar la imagen");
            }  
            bp.setCenter(imgView);
        } else{
            System.out.println("No file has been selected");
        }
        
        });
    }
    
    @FXML
    public void agregarImagen(){
        ArrayList<String> listaDeSi = cargarTextoEmoji();
        registrarEmoji(listaDeSi);
        
        
    }
    
    public ArrayList<String> cargarTextoEmoji(){
        String tipo = (String) cmbTipos.getValue();
        ArrayList<String> listaEnombre = new ArrayList<>();
        try{
            BufferedReader br = new BufferedReader(new FileReader("src/main/resources/text/"+tipo+".txt"));
            String linea;
            while((linea=br.readLine())!=null){
                listaEnombre.addLast(linea);
            }
        }catch(Exception e){
    System.err.println(e);
        } 
        return listaEnombre;
    }
    
    public void registrarEmoji(ArrayList<String> listaDeSI){
        String tipo = (String) cmbTipos.getValue();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(String.format("src/main/resources/text/%s.txt",tipo)));){
           for(int i = 0;i<listaDeSI.size();i++){             
                bw.newLine();
                bw.write(listaDeSI.get(i));
            }
            bw.newLine();
            bw.write(selectedFile.getName().replace(".png",""));
        }catch (IOException e){
            System.out.println("error");
        }
    }
    
    
    
   public void agregarImagenEmoji(){
        String tipo = (String) cmbTipos.getValue();
        try{
            String filepath = selectedFile.getAbsolutePath();
            Image image = new Image(selectedFile.getAbsolutePath());
            String fichero =("src/main/resources/Images."+tipo);
           
        }catch(Exception e){
            System.err.println(e);
        } 
    }
    
    
    
    public void mostrartipos(){
        cmbTipos.getItems().clear();
        this.cmbTipos.getItems().add("faces");
        this.cmbTipos.getItems().add("eyes");
        this.cmbTipos.getItems().add("mouth");
        this.cmbTipos.getItems().add("accesories");
        this.cmbTipos.getItems().add("eyebrows");
        
    }
    @FXML
    void volver()throws IOException {
        try {                          
            App.setRoot("nuevoEmoji");
            } 
        catch (IOException ex) {
            
            } 
    }
    
}
