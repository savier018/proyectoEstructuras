/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
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
import java.io.FileReader;
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
    @FXML
    private VBox ListContainer;
    @FXML
    private HBox ListFaces;
    @FXML
    private HBox ListEyes;
    @FXML
    private HBox ListMouth;
    @FXML
    private Button resetbtn;
    @FXML
    private Button acceptbtn;
    @FXML
    private Button prevbtn;
    @FXML
    private Button nextbtn;
    
    
    //Variables and Lists
    static Usuario user;
    static String nombreUsuario;
    private LinkedList<EmojiImage> lFaces;
    private LinkedList<EmojiImage> lEyes;
    private LinkedList<EmojiImage> lMouth;
    private Emoji emoji;
    private EmojiImage Face;
    private EmojiImage Eyes;
    private EmojiImage Mouth;

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
        loadLFaces();
        loadLMouth();
        loadLEyes();
        loadToHBox(lFaces,lEyes,lMouth);
    }    
    //Metodos FXML
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
            acceptbtn.setDisable(true);   
            }    
    }           
    //Metodos Listas
    //ARREGLAR BUFFER READER PARA QUE BUSQUE LAS CARPETAS
    public LinkedList<EmojiImage> loadImages(String Type){
    LinkedList<EmojiImage> images= new LinkedList();    
    try{
    BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Win1OPro Station\\Documents\\NetBeansProjects\\SpaceAdventure\\src\\main\\resources\\Data\\"+Type+".txt"));
     String linea;
     while((linea=br.readLine())!=null){
     String[] datos= linea.split("/");
     String url= datos[1];
     Image img= new Image("Images."+Type.toLowerCase()+url);       
     EmojiImage f= new EmojiImage(datos[0],img);
     images.addLast(f);
     }
    }
    catch(Exception e){
    System.out.println(e);
    } 
    return images;
 }
    
    public void loadLFaces(){
        lFaces=loadImages("faces");
    }
    
    public void loadLEyes(){
        lEyes=loadImages("eyes");
    }
    public void loadLMouth(){
        lMouth=loadImages("mouth");
    }
    
    public void loadToHBox(LinkedList<EmojiImage> lF,LinkedList<EmojiImage> lE,LinkedList<EmojiImage> lM){
        for(EmojiImage f:lF){
            Image i = f.getImage();
            ImageView d= new ImageView(i);
            ListFaces.getChildren().add(d);
        }
        for(EmojiImage f:lE){
            Image i = f.getImage();
            ImageView d= new ImageView(i);
            ListEyes.getChildren().add(d);
        }
        for(EmojiImage f:lM){
            Image i = f.getImage();
            ImageView d= new ImageView(i);
            ListMouth.getChildren().add(d);
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
