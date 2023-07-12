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
        
        
        
        for(int i =0;i<listaEmojisF.size();i++){
            Image Face = listaEmojisF.get(i).getImage();
            Image Eyes = listaEmojisE.get(i).getImage();
            Image Mouth = listaEmojisM.get(i).getImage();
            
            ImageView cara = new ImageView(Face);
            hb.getChildren().add(cara);
        }
        
        
    }    
    
   public void setear(){
       
   }
   
   public static ArrayList<LinkedList> cargarEmojis(){
       ArrayList<LinkedList> listaEmojis = new ArrayList();
       LinkedList<EmojiImage> listaEmojisF = new LinkedList();
       LinkedList<EmojiImage> listaEmojisE = new LinkedList();
       LinkedList<EmojiImage> listaEmojisM = new LinkedList();
       listaEmojis.addLast(listaEmojisF);
       listaEmojis.addLast(listaEmojisE);
       listaEmojis.addLast(listaEmojisM);
       String[] tipos = {"faces","eyes","mouth"};
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
            
            } 
    }
    
    public static void setNombreUsuario(String nombre) {
        nombreUsuario = nombre;
    }
}
