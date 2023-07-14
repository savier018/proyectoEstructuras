package com.mycompany.proyectoestructurasdatos;


import Modelo.Emoji;
import Modelo.EmojiImage;
import TDA.ArrayList;
import TDA.LinkedList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author fnand
 */
public class SeguirController implements Initializable {

    @FXML
    private Button seguirbtn;

    @FXML
    private Button volverbtn;
    @FXML
    private HBox hb;
    
    private Pane EmojiSetA;
    
    private ArrayList<Pane> listaEmojiSet;
    
    static String nombreUsuario;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ArrayList<LinkedList> listaEmojis = cargarEmojis();
        LinkedList<EmojiImage> listaEmojisF = listaEmojis.get(0);
        LinkedList<EmojiImage> listaEmojisE = listaEmojis.get(1);
        LinkedList<EmojiImage> listaEmojisM = listaEmojis.get(2);
        LinkedList<EmojiImage> listaEmojisA = listaEmojis.get(3);
        LinkedList<EmojiImage> listaEmojisEb = listaEmojis.get(4);
        listaEmojiSet = new ArrayList<>();
        for(int i =0;i<listaEmojisF.size();i++){
            Image Face = listaEmojisF.get(i).getImage();
            Image Eyes = listaEmojisE.get(i).getImage();
            Image Mouth = listaEmojisM.get(i).getImage();
            Image Accessories = listaEmojisA.get(i).getImage();
            Image Eyebrows = listaEmojisEb.get(i).getImage();
            Pane EmojiSet = new Pane();
            ImageView cara = new ImageView(Face);
            ImageView ojos = new ImageView(Eyes);
            ImageView boca = new ImageView(Mouth);
            ImageView accesorio = new ImageView(Accessories);
            ImageView cejas = new ImageView(Eyebrows);
            EmojiSet.getChildren().add(0,cara);
            EmojiSet.getChildren().add(1,ojos);
            EmojiSet.getChildren().add(2,boca);
            EmojiSet.getChildren().add(3,accesorio);
            EmojiSet.getChildren().add(4,cejas);
            listaEmojiSet.addLast(EmojiSet);
            hb.getChildren().add(EmojiSet);
        }
        
    }    
    
   public void setear(){
      ImageView Face= (ImageView)EmojiSetA.getChildren();
      ImageView Eyes=(ImageView)EmojiSetA.getChildren();
      ImageView Mouth=(ImageView)EmojiSetA.getChildren();
      NuevoEmojiController.f=true;
      NuevoEmojiController.EyesS=Eyes;
      NuevoEmojiController.MouthS=Mouth;
      NuevoEmojiController.FaceS=Face;
   }
   
    @FXML
    public void mouseClicked(MouseEvent e) {
        System.out.println(e.getSource().toString());
        System.out.println(e.getTarget().toString());
        for(int i = 0; i<listaEmojiSet.size();i++){
            if(e.getTarget().equals(listaEmojiSet.get(i))){
                this.EmojiSetA = listaEmojiSet.get(i);
            }
        }
        
    }
   
   public static ArrayList<LinkedList> cargarEmojis(){
       ArrayList<LinkedList> listaEmojis = new ArrayList();
       LinkedList<EmojiImage> listaEmojisF = new LinkedList();
       LinkedList<EmojiImage> listaEmojisE = new LinkedList();
       LinkedList<EmojiImage> listaEmojisM = new LinkedList();
       LinkedList<EmojiImage> listaEmojisA = new LinkedList();
       LinkedList<EmojiImage> listaEmojisEb = new LinkedList();
       listaEmojis.addLast(listaEmojisF);
       listaEmojis.addLast(listaEmojisE);
       listaEmojis.addLast(listaEmojisM);
       listaEmojis.addLast(listaEmojisA);
       listaEmojis.addLast(listaEmojisEb);
       String[] tipos = {"faces","eyes","mouth","accessories","eyebrows"};
       try (BufferedReader br = new BufferedReader(new FileReader(String.format("src/main/resources/text/%s.txt",nombreUsuario)));){
            br.readLine();
            String linea;
            while ((linea = br.readLine())!=null){
                String[] imagenes = linea.split(",");
                for(int i =0;i<tipos.length;i++){
                    System.out.println("Images/"+tipos[i]+"/"+imagenes[i]+".png");
                    Image img= new Image("Images/"+tipos[i]+"/"+imagenes[i]+".png",50,50,true,true);       
                    EmojiImage Ei= new EmojiImage(imagenes[i],img);
                    listaEmojis.get(i).addLast(Ei);
                }
                
            }
        }catch (IOException e){
            System.out.print(e);
        }
       return listaEmojis;
   }

    @FXML
    void seguir() {
        try {          
            setear();
            App.setRoot("nuevoEmoji");
            } 
        catch (IOException ex) {
            
            } 
    }

    @FXML
    void volver()throws IOException {
        try {                          
            App.setRoot("pantallaUsuario1");
            } 
        catch (IOException ex) {
            volverbtn.setDisable(true);
            } 
    }
    
    public static void setNombreUsuario(String nombre) {
        nombreUsuario = nombre;
    }
}
